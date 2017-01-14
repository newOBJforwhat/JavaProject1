package JDBCDemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.JavaFileObject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 编写一些尝试查找归类的数据库操作
 * @author ctk
 *
 */
public class Demo1 {
	JDBCTools tool = new JDBCTools();
	//集合存储
	public void test1(){
		tool.connection2MYSQL();
		Connection conn = tool.getCon();
		String sql = "select * from category";
		Statement stm = null;
		List<category> clist = new ArrayList<>();
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql); 
			while(rs.next()){
				category c = new category();
				c.setId(rs.getLong("id"));
				c.setName(rs.getString("name"));
				c.setParentId(rs.getLong("parent_id"));
				c.setIsRoot(rs.getInt("is_root"));
				clist.add(c);
			}
			tool.closeConn(conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		 * 检查集合
		 */
//		for(category ca:clist){
//			System.out.println("id: "+ca.getId()+" name: "+ca.getName()+" parentId: "+ca.getParentId()+" isRoot: "+ca.getIsRoot());
//		}
		/**
		 * 逻辑尝试=====
		 */
		List<CategoryTree> roots = new ArrayList<>();
		List<CategoryTree> second = new ArrayList<>();
		List<CategoryTree> third = new ArrayList<>();
		//一次遍历 添加根节点
		int i = 0;
		while(i != clist.size()-1){
			if(clist.get(i).getParentId() == 0){
				CategoryTree ct = new CategoryTree();
				ct.setId(clist.get(i).getId());
				ct.setName(clist.get(i).getName());
				roots.add(ct);
				clist.remove(i);
			}else
				i++;
		}
		//二次遍历 添加二级节点
		for(int j=0;j<roots.size();j++){
			i = 0;
			while(i < clist.size()){
				if(clist.get(i).getParentId() == roots.get(j).getId()){
					CategoryTree ct = new CategoryTree();
					ct.setId(clist.get(i).getId());
					ct.setName(clist.get(i).getName());
					roots.get(j).getChildren().add(ct);
					second.add(ct);//用空间换
					clist.remove(i);
				}else
					i++;
			}
		}
		//三次遍历 添加三级节点
		for(int j=0;j<second.size();j++){
			i = 0;
			while(i < clist.size()){
				if(clist.get(i).getParentId() == second.get(j).getId()){
					CategoryTree ct = new CategoryTree();
					ct.setId(clist.get(i).getId());
					ct.setName(clist.get(i).getName());
					second.get(j).getChildren().add(ct);
					third.add(ct);//用空间换
					clist.remove(i);
				}else
					i++;
			}
		}
		for(category ca:clist){
			System.out.println("id: "+ca.getId()+" name: "+ca.getName()+" parentId: "+ca.getParentId()+" isRoot: "+ca.getIsRoot());
		}
		for(CategoryTree ct:roots){
			System.out.println("id: "+ct.getId()+" name: "+ct.getName());
			{
			for(CategoryTree ct1:ct.getChildren())
			{
				System.out.println("二级 id: "+ct1.getId()+" name: "+ct1.getName());
				for(CategoryTree ct2:ct1.getChildren())
					System.out.println("三级 id: "+ct2.getId()+" name: "+ct2.getName());
			}
				
			}
		}
		JSONObject json = new JSONObject();
		json.put("test", roots);
		System.out.println(json.toString());
		/**
		 * 逻辑尝试=====
		 */
		
	}
	public void test2(){
		tool.connection2MYSQL();
		Connection conn = tool.getCon();
		String sql = "select * from category";
		Statement stm = null;
		List<category> clist = new ArrayList<>();
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql); 
			while(rs.next()){
				category c = new category();
				c.setId(rs.getLong("id"));
				c.setName(rs.getString("name"));
				c.setParentId(rs.getLong("parent_id"));
				c.setIsRoot(rs.getInt("is_root"));
				clist.add(c);
			}
			tool.closeConn(conn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/**
		 * 逻辑尝试=====
		 */
		Map<Long,CategoryMap> rootMap = new HashMap<>();
		Map<Long,CategoryMap> secondMap = new HashMap<>();
		//遍历一级
		int i = 0;
		while(i < clist.size()){
			if(clist.get(i).getParentId() == 0){
				CategoryMap cm = new CategoryMap();
				cm.setId(clist.get(i).getId());
				cm.setName(clist.get(i).getName());
				rootMap.put(cm.getId(),cm);
				clist.remove(i);
			}else
				i++;
		}
		//遍历二级
		i = 0;
		while (i < clist.size()) {
			if (rootMap.get(clist.get(i).getParentId()) != null) {
				CategoryMap cm = new CategoryMap();
				cm.setId(clist.get(i).getId());
				cm.setName(clist.get(i).getName());
				rootMap.get(clist.get(i).getParentId()).getChildren().put(cm.getId(), cm);
				secondMap.put(cm.getId(), cm);
				clist.remove(i);
			} else
				i++;
		}
		//遍历三级
		i = 0;
		while (i < clist.size()) {
			if (secondMap.get(clist.get(i).getParentId()) != null) {
				CategoryMap cm = new CategoryMap();
				cm.setId(clist.get(i).getId());
				cm.setName(clist.get(i).getName());
				secondMap.get(clist.get(i).getParentId()).getChildren().put(cm.getId(), cm);
				clist.remove(i);
			} else
				i++;
		}
//		for (Map.Entry<Long, CategoryMap> entry : rootMap.entrySet()) {  
//		    System.out.println("Key = " + entry.getKey() + ", id : " + entry.getValue().getId()+" name : "+entry.getValue().getName());
//		    for (Map.Entry<Long, CategoryMap> entry1 : entry.getValue().getChildren().entrySet()){
//		    	System.out.println("二级 Key = " + entry1.getKey() + ", id : " + entry1.getValue().getId()+" name : "+entry1.getValue().getName());
//		    	  for (Map.Entry<Long, CategoryMap> entry2 : entry1.getValue().getChildren().entrySet()){
//		    		  System.out.println("三级 Key = " + entry2.getKey() + ", id : " + entry2.getValue().getId()+" name : "+entry2.getValue().getName());
//		    	  }
//		    }
//		    
//		}
		JSONArray json = new JSONArray();
		for (CategoryMap entry : rootMap.values()) { 
			JSONObject job1 = new JSONObject();
			job1.put("id", entry.getId());
			job1.put("name", entry.getName());
			JSONArray joa1 = new JSONArray();
//		    System.out.println("id : " + entry.getId()+" name : "+entry.getName());
		    for (CategoryMap entry1 : entry.getChildren().values()){
				JSONObject job2 = new JSONObject();
				job2.put("id", entry1.getId());
				job2.put("name", entry1.getName());
				JSONArray joa2 = new JSONArray();
//		    	System.out.println("二级 id : " + entry1.getId()+" name : "+entry1.getName());
		    	  for (CategoryMap entry2 : entry1.getChildren().values()){
					JSONObject job3 = new JSONObject();
					job3.put("id", entry2.getId());
					job3.put("name", entry2.getName());
					joa2.add(job3);
//					System.out.println("三级 id : " + entry2.getId() + " name : "+entry2.getName());
		    	  }
		    	  job2.put("chird", joa2);
		    	  joa1.add(job2);
		    }
		    job1.put("chird", joa1);
		    json.add(job1);
		}
		
		for(int k=0;k<json.size();k++){
			JSONObject jo = json.getJSONObject(k);
			System.out.println(jo.toString());
		}
		/**
		 * 逻辑尝试=====
		 */
	}
	public static void main(String[] args) {
		Demo1 d = new Demo1();
		d.test2();
	}
}
/*
 * 商品类目标
 */
class category{
	private long id;
	private String name;
	private long parentId;
	private int isRoot;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public int getIsRoot() {
		return isRoot;
	}
	public void setIsRoot(int isRoot) {
		this.isRoot = isRoot;
	}
	
}
/*
 * 树型存储
 */
class CategoryTree{
	private long id;
	private String name;
	private List<CategoryTree> children;
	public CategoryTree(){
		children = new ArrayList<>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CategoryTree> getChildren() {
		return children;
	}
	public void setChildren(List<CategoryTree> children) {
		this.children = children;
	}
	
}
/*
 * 哈希表存储
 */
class CategoryMap{
	private long id;
	private String name;
	private Map<Long,CategoryMap> children;
	public CategoryMap(){
		children = new HashMap<>();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Long, CategoryMap> getChildren() {
		return children;
	}
	public void setChildren(Map<Long, CategoryMap> children) {
		this.children = children;
	}
}

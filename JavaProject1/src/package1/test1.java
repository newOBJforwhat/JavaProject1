package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class test1 {
	String  driver="com.mysql.jdbc.Driver";  
    Connection con;  
    //链接方式有些改变
    String url="jdbc:mysql://localhost:3306/MyData?useUnicode=true&characterEncoding=utf-8&useSSL=false";  
    String user="root";  
    String pwd="qwert123"; 
    public void connection2MYSQL()  
    {  
        try {  
            Class.forName(driver);  
              
            con=DriverManager.getConnection(url,user,pwd);  
              
            if(!con.isClosed())  
                System.out.println("连接成功");  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
          
          
    } 

	public void addUser(test_u u) {
		String sql = "insert into test_u(id,name,sex,age) values(?,?,?,?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getSex());
			ps.setString(4, u.getAge());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public void SelectTables(){  
        
        try {  
            // 执行sql语句  
            Statement statement = con.createStatement();  
  
            String sql = "select * from persion";  
            ResultSet rs = statement.executeQuery(sql);  
            String name = "";  
            int id = 0;  
            while (rs.next()) {  
            	id = rs.getInt("id");  
                name = rs.getString("name");  
                System.out.println("name =" + name + "   id="+id);  
  
            }  
            rs.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
    } 
    //转置
    public void transpose(int matrix[][]){
    	int temp;
    	for(int i=0;i<matrix.length;i++)
    		for(int j=0;j<i;j++){
    			temp=matrix[i][j];
    			matrix[i][j]=matrix[j][i];
    			matrix[j][i]=temp;
    		}
    	  
    }
    //逆序
    public void reserve(int matrix[][]){
    	int temp;
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix.length/2;j++){
    			int end=matrix.length-j-1;
    			temp=matrix[i][j];
    			matrix[i][j]=matrix[i][end];
    			matrix[i][end]=temp;
    		}
    	}
    	
    }
    public static void main(String[] args){
    	
    }
}

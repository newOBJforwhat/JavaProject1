package JDBCConectionPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class accountDAO {
	public List<account> selectAllAccount(Connection conn){
		String sql = "select * from account";
        Statement statement;
        ResultSet rs = null;
        List<account> list =new ArrayList<account>();
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float money = rs.getFloat("money");
				account a = new account(id,name,money);
				list.add(a);
				System.out.println("id:"+id+" name:"+name+" money:"+money);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return list;
	}
	//转出账户
	public void decAccount(Connection conn,String name,float number){
		String sql = "update account set money = money -? where name = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, number);
			stmt.setString(2, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//转入账户
	public void incAccount(Connection conn,String name,float number){
		String sql = "update account set money = money + ? where name = ?";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setFloat(1, number);
			stmt.setString(2, name);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//单个搜索
	public account selectUser(Connection conn,String name){
		String sql = "select * from account where name = ?";
        PreparedStatement statement;
        ResultSet rs = null;
        account a = null;
        try {
			statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			rs = statement.executeQuery();
			if(rs.next())
			{
				a = new account(rs.getInt("id"),rs.getString("name"),rs.getFloat("money"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
}

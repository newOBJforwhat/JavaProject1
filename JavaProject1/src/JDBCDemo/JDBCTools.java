package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTools {
    String  driver="com.mysql.jdbc.Driver";  
    Connection con;  
    String url="jdbc:mysql://localhost:3306/Test";  
    String user="root";  
    String pwd="qwert1234";  
    //连接上数据库mysql  
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
    
    public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public void closeConn(Connection connect) throws SQLException{
    	if(!connect.isClosed())
    		connect.close();
    }
}

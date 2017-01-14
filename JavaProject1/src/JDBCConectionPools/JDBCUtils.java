package JDBCConectionPools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static ComboPooledDataSource cpds = null;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static {
		// 这里有个优点，写好配置文件，想换数据库，简单
		cpds = new ComboPooledDataSource("mysql");// 这是mysql数据库
	}
    public static Connection getConnection(){  
		Connection conn = tl.get();
		try {
			if (conn == null) {
				conn = cpds.getConnection();
				tl.set(conn);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return conn;
       
    }
    //事务有关
	public static void beginTransaction() throws SQLException{
		Connection conn = tl.get();
		if(conn == null){
			conn = cpds.getConnection();
			tl.set(conn);
		}
		conn.setAutoCommit(false);
	}
	public static void commitTransaction() throws SQLException{
		Connection conn = tl.get();
		if(conn == null){
			conn = cpds.getConnection();
			tl.set(conn);
		}
		conn.commit();
		tl.remove();
	}
	
	public static void rollbackTransaction() throws SQLException{
		Connection conn = tl.get();
		if(conn == null){
			conn = cpds.getConnection();
			tl.set(conn);
		}
		conn.rollback();
		tl.remove();
	}
	// 释放资源的方法
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static void release(ResultSet rs,Statement stmt) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
	}

	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
		
}

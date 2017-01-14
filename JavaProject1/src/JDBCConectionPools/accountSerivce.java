package JDBCConectionPools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;


public class accountSerivce {
	//搜索事务
	public List<account> selectAccountService(){
		Connection conn = JDBCUtils.getConnection();
		accountDAO dao = new accountDAO();

		List<account> list = null;
		try {
			JDBCUtils.beginTransaction();
			list = dao.selectAllAccount(conn);
			JDBCUtils.commitTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				JDBCUtils.rollbackTransaction();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return list;
	}
	//赚钱服务
	public void transferAccounts(String from,String to,float number){
		Connection conn = JDBCUtils.getConnection();
		accountDAO dao = new accountDAO();
		
		try {
			JDBCUtils.beginTransaction();
			dao.decAccount(conn, from, number);
			dao.incAccount(conn, to, number);
			account account = dao.selectUser(conn, from);
			if(account != null)
				if(account.getMoney() < 0)
				{
					System.err.println("余额不足！无法转账！");
					JDBCUtils.rollbackTransaction();
				}
				else {
					JDBCUtils.commitTransaction();
				}
			else
				JDBCUtils.rollbackTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				JDBCUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	@Test
	public void test(){
		accountSerivce service = new accountSerivce();
		service.transferAccounts("美美", "冠希", 10000);
		List<account> list = service.selectAccountService();
		for(int i =0;i<list.size();i++)
			System.out.println(list.get(i).getId()+" "+list.get(i).getName()+" "+list.get(i).getMoney());
	}
	
}

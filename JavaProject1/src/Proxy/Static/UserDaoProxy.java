package Proxy.Static;
/**
 * 代理对象
 * @author ctk
 *
 */
public class UserDaoProxy implements DAOInterface{
	UserDao userDao = null;
	public UserDaoProxy(UserDao userDao){
		this.userDao = userDao;
	}
	@Override
	public void add() {
		userDao.add();
		System.out.println("记录日志add");
	}

	@Override
	public void delete() {
		userDao.delete();
		System.out.println("记录日志delete");
	}

	@Override
	public void update() {
		userDao.update();
		System.out.println("记录日志update");
	}

	@Override
	public void query() {
		userDao.query();
		System.out.println("记录日志query");
	}

}

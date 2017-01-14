package oop;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseServiceImpl<T> implements BaseService<T>{
	private SessionFactory ssf;
	public BaseServiceImpl(){
		System.out.println("基础服务类启动");
	}
	
	public SessionFactory getSsf() {
		return ssf;
	}
	//spring会注入
	public void setSsf(SessionFactory ssf) {
		this.ssf = ssf;
	}
	//获取当前线程的session
	protected Session getSession(){
		return ssf.getCurrentSession();
	}
	//基础服务方法
	@Override
	public void add(T obj) {
		// TODO Auto-generated method stub
		this.getSession().save(obj);
	}

	@Override
	public void delete(T obj) {
		// TODO Auto-generated method stub
		this.getSession().delete(obj);
	}
	@Override
	public void update(T obj) {
		// TODO Auto-generated method stub
		this.getSession().update(obj);
	}

}

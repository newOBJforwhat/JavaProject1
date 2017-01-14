package package2;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateExecute {

	public static void main(String[] args) {
		HibernateController hc=new HibernateController();
		persion toadd=new persion();
		toadd.setId(6);
		toadd.setName("lkxj");
		hc.update(toadd);
	}

}
class HibernateUtil{
	private static SessionFactory ssf;
	static{
		Configuration cfg=new Configuration().configure();
		ssf=cfg.buildSessionFactory();
	}
	public static Session getSession(){
		Session session=ssf.openSession();
		return session;
	}
	public static void closeSession(Session session){
		session.close();
	}
}
class HibernateController implements DAOInterface{

	// 添加信息
	@Override
	public void add(persion p) {
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.save(p);
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
	// 删除信息
	@Override
	public void delete(persion p) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.delete(p);
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
	// 搜寻信息
	@Override
	public persion search(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		persion p=null;
		try{
			p=(persion)session.get(persion.class, id);
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession(session);
		}
		return p;
	}
	// 更新信息
	@Override
	public void update(persion p) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		try{
			session.update(p);
			transaction.commit();
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
	
}

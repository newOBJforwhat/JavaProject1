package HibernateRelation;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args){
		Configuration cfg=new Configuration().configure();
		SessionFactory ssf=cfg.buildSessionFactory();
		Session session=ssf.openSession();
		Transaction t=session.beginTransaction();
		User3 u=new User3();
		Address3 a=new Address3();
		Address3 a1=new Address3();
		u.setUserid(1);
		u.setName("jack");
		u.setPassword("1111");
		a.setAddressinfo("france");
		a1.setAddressinfo("china");
		Set<Address3> s=new HashSet<Address3>();
		s.add(a1);
		s.add(a);
		u.setAddress3s(s);
		session.save(u);
		session.save(a);
		session.save(a1);
		t.commit();
		session.close();
	}
}

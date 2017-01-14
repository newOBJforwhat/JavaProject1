package Hibernate_Many2Many;


import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


public class  TestUtills{
	private SessionFactory ssf;
	public TestUtills(){
		Configuration cfg = new Configuration().configure();
		ssf = cfg.buildSessionFactory();
	}
	//添加对象
	public void save(Object obj){
		Session session = ssf.openSession();
		Transaction transaction = session.beginTransaction();
		try{
			session.save(obj);
			transaction.commit();
			
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
		session.close();
	}
	//遍历employee
	public List<Employee> selectEmployee(){
		Session session = ssf.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> list = null;
		try{
			String hql = "FROM Employee";
			Query q = session.createQuery(hql);
			list = q.list();
			transaction.commit();
			
		}catch (Exception e) {
			// TODO: handle exception
			transaction.rollback();
		}
        session.close();
        return list;
        
	}
	//遍历部门
		public List<Department> selectDept(){
			Session session = ssf.openSession();
			Transaction transaction = session.beginTransaction();
			List<Department> list = null;
			try{
				String hql = "FROM Department";
				Query q = session.createQuery(hql);
				list = q.list();
				transaction.commit();
				
			}catch (Exception e) {
				// TODO: handle exception
				transaction.rollback();
			}
	        session.close();
	        return list;
	        
		}
	//更新
	public void updateObject(Object obj) {  
        Session session=ssf.openSession();  
        Transaction transaction=session.beginTransaction();  
        try{  
            transaction=session.beginTransaction();//开启一个事务  
            session.update(obj);  
            transaction.commit();  
        }catch(HibernateException e){  
            if(transaction!=null){  
                transaction.rollback();  
            }  
            e.printStackTrace();  
        }finally{  
            if(session!=null){  
                session.close();  
            }  
        }  
    }  
	//查找雇员
	 public Employee queryEmp(int empId){  
	        Session session=ssf.openSession();  
	        try{  
	            Employee emp=(Employee)session.get(Employee.class, empId);//这里会执行一次查询employee的语句  
	            System.out.println(emp.getDepart().getName());//这里会执行一次查询department的语句  
	            Hibernate.initialize(emp.getDepart());//初始化代理，即初始化一个持久态的对象，加上这一句，才能在外部查询  
	            return emp;  
	        }catch(HibernateException e){  
	            e.printStackTrace();  
	            return null;  
	        }finally{  
	            if(session!=null){  
	                session.close();  
	            }  
	        }  
	    }  
}

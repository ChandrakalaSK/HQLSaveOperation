package in.ineuron.main;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class StandardApp {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session session=null;
		Transaction transaction=null;
		Integer idValue=null;
		boolean flag=false;
		
		cfg=new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());
		
		factory=cfg.buildSessionFactory();
		
		session=factory.openSession();

		Employee e=new Employee();
		e.setEmpId(20);
		e.setEmpName("Sachin");
		e.setEmpSal(16897.00);
		
		try {
		transaction=session.beginTransaction(); //connection.setAutoCommit(false);
		idValue=(Integer)session.save(e);
		System.out.println("Generated value is :: "+idValue);
		System.out.println("id values is :: "+e.getEmpId());
		flag=true;
		}
		catch (HibernateException he) 
		{
			he.printStackTrace();
		}
		catch (Exception e2) {
			e2.printStackTrace();
		}finally {
			if(flag==true)
			{
				transaction.commit();//con.commit
			}
			else
			{
			transaction.rollback();	//con.rollback
			}
			session.close();
			factory.close();
		}
		
		
		
	}

}

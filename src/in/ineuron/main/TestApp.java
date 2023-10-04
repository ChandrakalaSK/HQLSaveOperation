package in.ineuron.main;



import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.ineuron.Model.Employee;

public class TestApp {

	public static void main(String[] args) {
		
		//step1 create configuration object
		Configuration cfg=new Configuration();
		
		//step-2 configure hibernate.cfg.xml file to Configuration object 
		cfg.configure("sql.cfg.xml").addAnnotatedClass(Employee.class);
		
		//step-3 create SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		
		//step-4 Get the session object from sessionFactory
		Session session=factory.openSession();
		
		//step-5 Begin the Transaction within a session
		Transaction transaction =session.beginTransaction();
		
		Employee e=new Employee();
		e.setEmpId(20);
		e.setEmpName("Sachin");
		e.setEmpSal(16897.00);
		
		//step-6 perform operations
		Serializable object=session.save(e);
		System.out.println(object);
		
		//step-7 performing transaction operation
		transaction.commit();
		
		//Step-8 Close the session
		session.close();
		
		//step-9 Close the factory
		factory.close();
	}

}

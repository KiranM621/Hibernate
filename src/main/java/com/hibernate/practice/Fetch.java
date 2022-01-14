package com.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student obj1 = new Student();
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	    
  	
	  	SessionFactory sf = config.buildSessionFactory();
	  	
	  	Session session = sf.openSession();
	  	
	  	//interface for following acid property
	  	Transaction tx = session.beginTransaction();
	  	

	  	obj1 = session.get(Student.class, 2);
//	  	System.out.println(obj1);
	  	System.out.println(obj1.getName());
	  	

//	  	obj1 = session.load(Student.class, 2);
//	  	System.out.println(obj1);
//	  	System.out.println(obj1.getName());
	  	
	  	tx.commit();
		

		
		
	}

}

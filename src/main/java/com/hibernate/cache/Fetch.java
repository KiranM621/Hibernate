package com.hibernate.cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.Laptop;
import com.hibernate.practice.Student;

public class Fetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Players obj = new Players();

		Configuration config = new Configuration().configure().addAnnotatedClass(Players.class);
	    
  	
	  	SessionFactory sf = config.buildSessionFactory();
	  	
	  	Session session1 = sf.openSession();
	  	
	  	//interface for following acid property
	  	Transaction tx = session1.beginTransaction();
	  	
	  	Query q1 = session1.createQuery("from Players where id = 1"); 
	  	q1.setCacheable(true);
	  	obj = (Players)q1.uniqueResult();
	  	
	  	// first level example

//	  	obj = session1.get(Players.class,1);
	  	System.out.println("Via Query "+obj);
	  	
	  	tx.commit();
	  	
	  	session1.close();
	  	
	  	Session session2 = sf.openSession();
	  	
	  	session2.beginTransaction();
	  	
	  	Query q2 = session2.createQuery("from Players where id = 2"); 
	  	q1.setCacheable(true);

	  	obj = (Players)q2.uniqueResult();

//	  	obj = session2.get(Players.class, 1);
	  	System.out.println(obj);

	  	session2.getTransaction().commit();
	  	
		


	}

}

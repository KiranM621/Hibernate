package com.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.Laptop;
import com.hibernate.practice.Student;

public class Fetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car obj1 = new Car();
		Configuration config = new Configuration().configure().addAnnotatedClass(Car.class);
	    
  	
	  	SessionFactory sf = config.buildSessionFactory();
	  	
	  	Session session = sf.openSession();
	  	
	  	
	  	SQLQuery query = session.createSQLQuery("select * from Car");
	  	query.addEntity(Car.class);
	  	List<Car> data = query.list();
	  	
	  	System.out.println(data);
	  
////	  	List<Car> list = session.createQuery("from Car where id = 1").getResultList();
//	  
//	  	
//	  	List<Object> sobj = session.createQuery("select name from Car where id").getResultList();
//	  	
//	  	
//	  	//interface for following acid property
	  	Transaction tx = session.beginTransaction();
//	  	
//
////	  	obj1 = session.get(Car.class, 1);
//		for(Object obj : sobj) {
//			 System.out.println(obj);
//		}
////	  	System.out.println(sobj);


	  	tx.commit();
		
	}

}

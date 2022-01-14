package com.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.practice.Laptop;
import com.hibernate.practice.Student;

public class AddData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Car obj = new Car();
		//Transient state
		obj.setId(7);
		obj.setName("Ford");
		

    	//configures the config file created for databases
    	Configuration config = new Configuration().configure().addAnnotatedClass(Car.class);
    
    	
    	SessionFactory sf = config.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	session.beginTransaction();
    	
    	
    	session.save(obj); // enter persistent state
    	
    	session.remove(obj);
    	//name Laural will get stored in database as it is not
    	// detached
    	obj.setName("Laural");

    	
    	//after commit it is already in detach state
    	session.getTransaction().commit();
    	
//    	session.detach(obj);
//    	obj.setName("Swift");
    	
	}

}

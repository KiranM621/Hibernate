package com.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("hi");
    	Players pobj = new Players();
    	pobj.setId(3);
    	pobj.setName("Rahul");
    	
    	//configures the config file created for databases
    	Configuration config = new Configuration().configure().addAnnotatedClass(Players.class);
    
    	
    	SessionFactory sf = config.buildSessionFactory();
    	
    	Session session1 = sf.openSession();
    	
    	//interface for following acid property
    	Transaction tx = session1.beginTransaction();
    	
    	session1.save(pobj);
    	
    	
    	
    	tx.commit();
    	
    }
}

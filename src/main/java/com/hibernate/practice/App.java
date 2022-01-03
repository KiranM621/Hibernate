package com.hibernate.practice;

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
    	Name name = new Name();
    	name.setF_name("Kiran");
    	name.setM_name("Ravishankar");
    	name.setL_name("Mishra");

    	Laptop lap1 = new Laptop();

    	lap1.setLid(1);
    	lap1.setName("Dell");
    	
    	
    	Student dep1 = new Student();
    	dep1.setDep_id(2);
    	dep1.setDep_name("Finance");
    	dep1.setLocation("Pune");
    	dep1.setName(name);
    	dep1.getLaptop().add(lap1);
    	
    	
    	
    	//configures the config file created for databases
    	Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
    
//        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
    	
    	SessionFactory sf = config.buildSessionFactory();
    	
    	Session session = sf.openSession();
    	
    	//interface for following acid property
    	Transaction tx = session.beginTransaction();
    	
    	session.save(lap1);
    	session.save(dep1);
    	
    	
    	tx.commit();
    	
    }
}

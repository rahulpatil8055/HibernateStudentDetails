package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapConfig {
	
	public static void main(String[] args) {
		
		Configuration config= new Configuration();
		SessionFactory factory= config.configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=factory.openSession();
		Transaction tc= session.beginTransaction();
		Student s1= new Student();
		s1.setSid(1);
		s1.setName("Raha");
		s1.setAge(1);
		
		Department d1 = new Department();
		d1.setDept_id(2);  
		d1.setDept_name("Baby");
		d1.setStd(s1);
		s1.setDept(d1);
		session.persist(s1);

		tc.commit();
	}

}

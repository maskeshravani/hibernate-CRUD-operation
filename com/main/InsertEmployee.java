package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.employee.Employee;

public class InsertEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee e = new Employee();
		e.setName("Shravani");
		e.setAddress("Sangli");
		e.setSalary(405000);
		e.setMobno(8309273985l);
		System.out.println(e);
		
		ss.save(e);
		tr.commit();
		ss.close();
		sf.close();
		
		System.out.println("Application is Started...");

	}

}

package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.employee.Employee;

public class UpdateEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		
		int id = 1;
		Employee e = ss.get(Employee.class, id);
		
		e.setName("Abhi");
		e.setAddress("Pune");
		e.setMobno(9382457298l);
		//e.setSalary(89999);
		
		ss.update(e);
		
		tr.commit();
		ss.close();
		sf.close();
	}
}

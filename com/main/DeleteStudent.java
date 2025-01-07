package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Student.Student;


public class DeleteStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		 SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction(); 
		
		int rollno = 2;
		Student s = ss.get(Student.class, rollno);
		ss.delete(s);
		
		
		tr.commit();
		ss.close();
		sf.close();
		
	}

}

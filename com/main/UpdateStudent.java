package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.Student.Student;

public class UpdateStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int rollno = 1;
		Student s = ss.get(Student.class, rollno);
		
		s.setCity("Sangli");
		s.setMarks(96);
		s.setName("Abhi");
		
		ss.update(s);
		tr.commit();
		ss.close();

	}

}

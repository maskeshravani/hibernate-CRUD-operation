package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Student.Student;



public class SinRecHqlStudent {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Student.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        String hqlQuery = "from Student where id =: id";
	        Query<Student> query = ss.createQuery(hqlQuery, Student.class);
	       
	        query.setParameter("id", 3);
	        Student a = query.getSingleResult();
	            System.out.println(a);
	        

	}

}

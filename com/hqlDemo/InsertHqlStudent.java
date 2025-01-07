package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Student.Student;


public class InsertHqlStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "insert into Student (name,city, marks, mobino) values(:name ,:city, :marks, :mNo )";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("name", "Rahul");
		query.setParameter("city", "Dilhi");
		query.setParameter("marks", 85);
		query.setParameter("mNo",15645463534l);
		
		query.executeUpdate();
		System.out.println("Data inserted Successfully...");
	
		tr.commit();
		ss.close();

	}

}

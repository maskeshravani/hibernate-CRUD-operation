package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.animal.Animal;

public class InsertHqlAnimal {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Animal.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "insert into Animal (age ,name, color, sound, Eat) values(:age ,:name,:col, :sound, :eat )";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		
		query.setParameter("age", "15");
		query.setParameter("name", "Tiger");
		query.setParameter("col", "orange");
		query.setParameter("sound", "Hissing");
		query.setParameter("eat", "deer");
		
		query.executeUpdate();
		System.out.println("Data inserted Successfully...");
	
		tr.commit();
		ss.close();
	


	}

}

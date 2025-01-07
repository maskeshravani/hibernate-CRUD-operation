package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.animal.Animal;

public class UpdateHqlAnimal {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Animal.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "update Animal set Eat=:eat where age=: age";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("eat", "wild boar");
		query.setParameter("age", 15);
		
		query.executeUpdate();
		System.out.println("Data Updated Successfully...");
		
		tr.commit();
		ss.close();
		

	}

}

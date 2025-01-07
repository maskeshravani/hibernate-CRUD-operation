package com.hqlDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.animal.Animal;

public class SRecordAnimal {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Animal.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        String hqlQuery = "from Animal where age =: age";
	        Query<Animal> query = ss.createQuery(hqlQuery, Animal.class);
	       
	        query.setParameter("age", 12);
	        Animal a = query.getSingleResult();
	            System.out.println(a);
	        

	}

}

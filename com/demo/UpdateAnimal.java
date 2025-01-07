package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.animal.Animal;

public class UpdateAnimal {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Animal.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int age = 12;
		Animal a = ss.get(Animal.class, age);
		
		a.setName("Dog");
		a.setColor("Black");
		a.setEat("milk");
		a.setSound("Meww");
		
		ss.update(a);
		
		tr.commit();
		ss.close();
	}

}

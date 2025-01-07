package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.animal.Animal;

public class DeleteAnimal {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Animal.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();
        
        int age = 13;
        Animal a =  ss.get(Animal.class, age);
        
        ss.remove(a);
        tr.commit();
        ss.close();
        sf.close();
	}

}

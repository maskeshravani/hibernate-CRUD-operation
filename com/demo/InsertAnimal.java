package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.animal.Animal;

public class InsertAnimal {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Animal.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Animal an = new Animal();
        an.setAge(13);
        an.setName("xaj");
        an.setColor("Bjns");
        an.setEat("ass");
        an.setSound("dzcmlkz");
        
        ss.save(an);

        System.out.println("Animal saved: " + an);

        tr.commit();
        ss.close();
        sf.close();
        

        System.out.println("Application is Ended...");

	}

}

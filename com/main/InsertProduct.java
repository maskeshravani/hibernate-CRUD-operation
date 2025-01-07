package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.Product;

public class InsertProduct {

	public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Product.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

      
        Product p = new Product();
        p.setCname("Choklet");
        p.setPrice(200);
        p.setColor("pink");
        p.setPname("Parle");

        System.out.println(p);

       
        ss.save(p);
        tr.commit();

      
        ss.close();
        sf.close();

        System.out.println("Application is Started...");

	}

}

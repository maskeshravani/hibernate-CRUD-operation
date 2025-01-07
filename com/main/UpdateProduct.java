package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.Product;

public class UpdateProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = 1;
		Product p = ss.get(Product.class, id);
		p.setCname("Zyzddn");
		p.setPname("Bag");
		p.setPrice(500);
		p.setColor("black");
	
		ss.update(p);
		tr.commit();
		ss.close();
		sf.close();
	}

}

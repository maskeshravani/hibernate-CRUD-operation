package com.hqlDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.product.Product;

public class FetchHqlProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "from Product";
		
		Query<Product> query = ss.createQuery(hqlQuery, Product.class);
		List<Product> list = query.list();
		
		for(Product p: list) {
			System.out.println(p);
		}
		tr.commit();
		ss.close();
		sf.close();
	}

}

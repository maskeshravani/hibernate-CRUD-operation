package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.product.Product;

public class SiRecHqlProduct {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Product.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        String hqlQuery = "from Product where id =: id";
	        Query<Product> query = ss.createQuery(hqlQuery, Product.class);
	       
	        query.setParameter("id", 1);
	        Product a = query.getSingleResult();
	            System.out.println(a);
	        

	}

}

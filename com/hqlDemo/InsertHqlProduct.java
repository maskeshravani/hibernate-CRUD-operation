package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.product.Product;

public class InsertHqlProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);

		SessionFactory cf = cfg.buildSessionFactory();
		Session ss = cf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "insert into Product (pname, price, color, cname) values(:name ,:pri,:col, :CName )";
		MutationQuery query = ss.createMutationQuery(hqlQuery);

		query.setParameter("name", "bag");
		query.setParameter("pri", 1000);
		query.setParameter("col", "Black");
		query.setParameter("CName", "Birkin bag");

		query.executeUpdate();
		System.out.println("Data inserted Successfully...");

		tr.commit();
		ss.close();
	}

}

package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.product.Product;

public class UpdateHqlProduct {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Product.class);

		SessionFactory cf = cfg.buildSessionFactory();
		Session ss = cf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Product set price=:pri where id=: id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);

		query.setParameter("pri", 1200);
		query.setParameter("id", 6);

		query.executeUpdate();
		System.out.println("Data Updated Successfully...");

		tr.commit();
		ss.close();

	}

}

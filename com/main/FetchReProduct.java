package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.product.Product;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FetchReProduct {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Product.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        CriteriaBuilder hcb = ss.getCriteriaBuilder();
	        CriteriaQuery<Product> cq = hcb.createQuery(Product.class);
	        Root<Product> root = cq.from(Product.class);
	        cq.select(root);

	        Query query = ss.createQuery(cq);
	        List<Product> list = query.getResultList();

	        for (Product p : list) {
	            System.out.println(p);
	        }

	        tr.commit();
	        ss.close();

	}

}

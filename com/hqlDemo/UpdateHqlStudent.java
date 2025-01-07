package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.Student.Student;

public class UpdateHqlStudent {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory cf = cfg.buildSessionFactory();
		Session ss = cf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "update Student set city=:city, mobino=:mno where id=: id";
		
		MutationQuery query = ss.createMutationQuery(hqlQuery);

		query.setParameter("city", "Kolkata");
		query.setParameter("mno", 7856984754l);
		query.setParameter("id", 7);

		query.executeUpdate();
		System.out.println("Data Updated Successfully...");

		tr.commit();
		ss.close();

	}

}

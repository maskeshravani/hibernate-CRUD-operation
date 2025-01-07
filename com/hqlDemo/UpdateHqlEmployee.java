package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.employee.Employee;

public class UpdateHqlEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "update Employee set name=:name, salary=:sal where id=: id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("name", "Rushikesh");
		query.setParameter("sal", 70000);
		query.setParameter("id", 6);
		
		query.executeUpdate();
		System.out.println("Data Updated Successfully...");
		
		tr.commit();
		ss.close();
		

	}

}

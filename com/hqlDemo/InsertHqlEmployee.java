package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.employee.Employee;

public class InsertHqlEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "insert into Employee (name, address, salary, mobno) values(:name ,:add,:sal, :mob )";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("name", "Raj");
		query.setParameter("add", "Kolhapur");
		query.setParameter("sal", 50000);
		query.setParameter("mob", 7439178733l);
		
		query.executeUpdate();
		System.out.println("Data inserted Successfully...");
	
		tr.commit();
		ss.close();

	}

}

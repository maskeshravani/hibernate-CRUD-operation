package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.vehicle.Vehicle;

public class inserthqlVehicle {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "insert into Vehicle (name, price, color, comName) values(:name ,:pri,:col, :CName )";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("name", "jeep");
		query.setParameter("pri", 500000);
		query.setParameter("col", "Black");
		query.setParameter("CName", "AMC");
		
		query.executeUpdate();
		System.out.println("Data inserted Successfully...");
	
		tr.commit();
		ss.close();
	
	}

}

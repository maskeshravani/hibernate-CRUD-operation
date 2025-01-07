package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.vehicle.Vehicle;

public class UpdatehqlVehicle {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory cf = cfg.buildSessionFactory();
		Session ss= cf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hqlQuery = "update Vehicle set price=:pri where id=: id";
		MutationQuery query = ss.createMutationQuery(hqlQuery);
		
		query.setParameter("pri", 700000);
		query.setParameter("id", 12);
		
		query.executeUpdate();
		System.out.println("Data Updated Successfully...");
		
		tr.commit();
		ss.close();
		

	}

}

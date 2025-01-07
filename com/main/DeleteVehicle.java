package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vehicle.Vehicle;

public class DeleteVehicle {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Vehicle v = new Vehicle();
		
		int id = 5;
		Vehicle v1 = ss.get(Vehicle.class, id );
		ss.delete(v1);
		
		tr.commit();
		ss.close();
		sf.close();
		
		
	}

}

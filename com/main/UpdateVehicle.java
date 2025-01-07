package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vehicle.Vehicle;

public class UpdateVehicle {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		int id = 1;
		Vehicle v = ss.get(Vehicle.class, id);
		v.setName("Car");
		v.setColor("Blue");
		v.setComName("Tata");
		
		tr.commit();
		ss.close();
		sf.close();
		

	}

}

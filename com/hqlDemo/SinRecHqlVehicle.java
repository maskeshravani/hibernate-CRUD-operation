package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.vehicle.Vehicle;

public class SinRecHqlVehicle {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Vehicle.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "from Vehicle where id =: id";
		Query<Vehicle> query = ss.createQuery(hqlQuery, Vehicle.class);

		query.setParameter("id", 6);
		Vehicle a = query.getSingleResult();
		System.out.println(a);

	}

}

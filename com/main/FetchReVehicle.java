package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vehicle.Vehicle;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FetchReVehicle {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Vehicle.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        CriteriaBuilder hcb = ss.getCriteriaBuilder();
	        CriteriaQuery<Vehicle> cq = hcb.createQuery(Vehicle.class);
	        Root<Vehicle> root = cq.from(Vehicle.class);
	        cq.select(root);

	        Query query = ss.createQuery(cq);
	        List<Vehicle> list = query.getResultList();

	        for (Vehicle v : list) {
	            System.out.println(v);
	        }

	        tr.commit();
	        ss.close();


	}

}

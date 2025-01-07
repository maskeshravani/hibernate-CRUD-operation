package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.vehicle.Vehicle;

public class InsertVehicle {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Vehicle.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

       
        Vehicle v = new Vehicle();
        v.setName("Car");
        v.setPrice(20000);
        v.setColor("Black");
        v.setComName("xyz");

        System.out.println(v);

        ss.save(v);
        tr.commit();
        ss.close();
        sf.close();

        System.out.println("Application is Started...");
    }
}

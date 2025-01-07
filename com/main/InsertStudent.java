package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.Student.Student;

public class InsertStudent {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        
        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        Student s = new Student();
        s.setName("Rushi");
        s.setCity("Kolhapur");
        s.setMarks(80); 
        s.setMobino(9876543210L); 
        ss.save(s);
       
        

        tr.commit();
        ss.close();
        sf.close();

        System.out.println("Application is Started...");
    }
}

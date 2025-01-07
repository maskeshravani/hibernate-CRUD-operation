package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.employee.Employee;

import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class FetchEmployee {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Employee.class);

        SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Transaction tr = ss.beginTransaction();

        CriteriaBuilder hcb = ss.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = hcb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);

        Query query = ss.createQuery(cq);
        List<Employee> list = query.getResultList();

        for (Employee e : list) {
            System.out.println(e);
        }

        tr.commit();
        ss.close();
    }
}

package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.employee.Employee;


public class DeleteHqlEmployee {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		String hqlQuery = "DELETE FROM Employee where id =: id";
		
		Query query = ss.createQuery(hqlQuery);
		query.setParameter("id", 5);
		
		
		int delete = query.executeUpdate();
		System.out.println(delete);
		tr.commit();
        ss.close();
        sf.close();

	}

}

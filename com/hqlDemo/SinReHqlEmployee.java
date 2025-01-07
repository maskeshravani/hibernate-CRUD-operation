package com.hqlDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.employee.Employee;

public class SinReHqlEmployee {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        cfg.addAnnotatedClass(Employee.class);

	        SessionFactory sf = cfg.buildSessionFactory();
	        Session ss = sf.openSession();
	        Transaction tr = ss.beginTransaction();

	        String hqlQuery = "from Employee where id =: id";
	        Query<Employee> query = ss.createQuery(hqlQuery, Employee.class);
	       
	        query.setParameter("id", 1);
	        Employee a = query.getSingleResult();
	            System.out.println(a);
	        

	}

}

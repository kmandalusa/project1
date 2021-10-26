package com.revature.dao;

import org.hibernate.Session;

import com.revature.model.Employee;

public class EmployeeDAO {

	public static Employee findById(String name) {

		try (Session session = DBConnection.getSession()) {
			return session.find(Employee.class, name);
		}

	}

	public static void create(Employee employee) {

		try (Session session = DBConnection.getSession()) {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			
		}

	}
	

}

package com.revature.dao;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Employee;

public class EmployeeDAO {
	
	private static	Logger logger = LoggerFactory.getLogger(EmployeeDAO.class);

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
			logger.info(employee.toString());
		}

	}
	

}

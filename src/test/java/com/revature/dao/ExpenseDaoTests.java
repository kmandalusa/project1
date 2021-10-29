package com.revature.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.model.Expense;

public class ExpenseDaoTests {

	private static Logger logger = LoggerFactory.getLogger(ExpenseDaoTests.class);

	// @Test
	public void testCreate() {
		Expense expense = new Expense("Krishna", 20.56, "Food", "Pending");

		ExpenseDAO.create(expense);
		logger.info(expense.toString());

	}

	// @Test
	public void testUpdate() {
		
		

	}

	// @Test
	public void testFindByemployeeId() {
		
	}
	// @Test
	public void testFindExpenseByStatus() {
		
	}
	
	// @Test
	public void testFindExpenseByStat() {
		
	}
}

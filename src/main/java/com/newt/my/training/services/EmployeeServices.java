package com.newt.my.training.services;


	import java.util.List;

import com.newt.my.training.Entity.Employee;

	

	public interface EmployeeServices {
		public void addEmployee(Employee employee);
		 
	    public List<Employee> getAllEmployees();
	 
	    public void deleteEmployee(Integer employeeId);
	 
	    public Employee getEmployee(int employeeid);
	 
	    public Employee updateEmployee(Employee employee);
	}




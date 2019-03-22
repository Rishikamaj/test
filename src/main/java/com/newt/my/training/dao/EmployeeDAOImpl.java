package com.newt.my.training.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.newt.my.training.Entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	@PersistenceContext
	private EntityManager entityManager;

	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * public void addEmployee(Employee employee) {
	 * sessionFactory.getCurrentSession().saveOrUpdate(employee);
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return entityManager.createQuery("from Employee").getResultList();
	}

	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) entityManager.find(Employee.class, employeeId);
		if (null != employee) {
			this.entityManager.remove(employee);
		}

	}

	public Employee getEmployee(int empid) {
		return (Employee) entityManager.find(Employee.class, empid);
	}

	public Employee updateEmployee(Employee employee) {
		entityManager.merge(employee);
		return employee;
	}

}

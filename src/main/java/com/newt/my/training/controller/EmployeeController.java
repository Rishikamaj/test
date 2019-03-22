package com.newt.my.training.controller;



import java.io.IOException;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.newt.my.training.Entity.Employee;
import com.newt.my.training.Entity.Student;
import com.newt.my.training.services.EmployeeServices;





@RestController
public class EmployeeController {

	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	public EmployeeController() {
		System.out.println("EmployeeController()");
	}

	@Autowired
	private EmployeeServices employeeServices;

	@GetMapping("/")
	public ResponseEntity<List<Employee>> listEmployee() throws IOException {
		List<Employee> listEmployee = employeeServices.getAllEmployees();

		return ResponseEntity.ok(listEmployee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws IOException {
		Employee employee = employeeServices.getEmployee(id);

		return ResponseEntity.ok(employee);
	}

	/*
	 * @RequestMapping(value = "/newEmployee", method = RequestMethod.GET) public
	 * ModelAndView newContact(ModelAndView model) { Employee employee = new
	 * Employee(); model.addObject("employee", employee);
	 * model.setViewName("EmployeeForm"); return model; }
	 */
	@PostMapping("/")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

		employeeServices.addEmployee(employee);

		return ResponseEntity.ok().body("new emp saved");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id) {

		employeeServices.deleteEmployee(id);
		return ResponseEntity.ok().body("emp " + id + "deleted successfully");
	}

	@PutMapping("/")
	public ResponseEntity<?> editContact(@RequestBody Employee employee) {

		employeeServices.addEmployee(employee);

		return ResponseEntity.ok().body(employee);
	}

	/*@GetMapping("/selectedstudent")
	private ResponseEntity<Student[]> getStudent() throws IOException {
		final String uri = "http://localhost:8080/BestEmployee/eligibleStudent/60";

		RestTemplate restTemplate = new RestTemplate();
		Student[] result = restTemplate.getForObject(uri, Student[].class);

		// System.out.println(result);
		return ResponseEntity.ok().body(result);
	}*/

@GetMapping("/selectedstudent")
private ResponseEntity<Student[]> getStudent() throws IOException {
	final String uri = "http://localhost:8081/eligibleStudent/60";

	RestTemplate restTemplate = new RestTemplate();
	Student[] result = restTemplate.getForObject(uri, Student[].class);

	// System.out.println(result);
	return ResponseEntity.ok().body(result);
}}

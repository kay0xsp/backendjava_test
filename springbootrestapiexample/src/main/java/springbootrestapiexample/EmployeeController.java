package springbootrestapiexample;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@CrossOrigin( origins= "http://localhost:8080")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	
	
	//SAVE EMPLOYEE
	@PostMapping("/employees")
	public Employee createemployee(@Valid @RequestBody Employee emp) {
		
		return employeeDAO.save(emp);
	}
	
	
	//GET ALL EMPLOYEES
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		List<Employee> a = employeeDAO.findAll();
		return a;
	}
	
	
	//GET ONE EMPLOYEE
	@GetMapping("/note/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id")Long Empid){
		
		Employee emp=employeeDAO.findOne(Empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
			
		}
		
		return ResponseEntity.ok().body(emp);
	}
	
	
	//UPDATE EMPLOYEE BY ID
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @Valid @RequestBody Employee empDetails){
		 
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
			
		}
		
		emp.setEmp_name(empDetails.getEmp_name());
		emp.setEmp_adress(empDetails.getEmp_adress());
		emp.setEmp_mobile_nos(empDetails.getEmp_mobile_nos());
		
		Employee updateEmployee=employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee);
		
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") long empid){
		
		Employee emp=employeeDAO.findOne(empid);
		
		if(emp == null) {
			return ResponseEntity.notFound().build();
			
		}
		
		employeeDAO.delete(empid);
		
		return ResponseEntity.ok().build();
		
		
		
		
	}
	
}

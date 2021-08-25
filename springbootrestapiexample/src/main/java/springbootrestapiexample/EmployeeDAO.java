package springbootrestapiexample;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeDAO {

	@Autowired
	EmployeeRepository employeeRepository;
	
	
	// SAVE EMPLOYEE
	public Employee save(Employee emp) {
		
		return employeeRepository.save(emp); 
	}
	
	// GET ALL EMPLOYEE
	public List<Employee> findAll(){
		
		return employeeRepository.findAll();
	}
	
	// GET SPECIFIC EMPLOYEE
	public Employee findOne(Long empid) {
		
		return employeeRepository.findOne(empid);
	}
	
	// UPDATE EMPLOYEE

	
	// DELETE ONE EMPLOYEE
	public void delete(Long empid) {
		
		 employeeRepository.delete(empid);
	}
}

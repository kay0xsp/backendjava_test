package springbootrestapiexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	

	//MAPPING
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private long id;
	
	@Column(name = "emp_name")
	private String emp_name;
	
	@Column(name = "emp_adress")
	private String emp_adress;
	
	
	@Column(name = "emp_mobile_nos")
	private String emp_mobile_nos;
	
		
	//SETTERS & GETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_adress() {
		return emp_adress;
	}

	public void setEmp_adress(String emp_adress) {
		this.emp_adress = emp_adress;
	}

	public String getEmp_mobile_nos() {
		return emp_mobile_nos;
	}

	public void setEmp_mobile_nos(String emp_mobile_nos) {
		this.emp_mobile_nos = emp_mobile_nos;
	}

	

	
}

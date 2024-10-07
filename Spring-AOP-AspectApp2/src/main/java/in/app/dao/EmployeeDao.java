package in.app.dao;

import org.springframework.stereotype.Component;

import in.app.annotation.MyTransaction;

@Component
public class EmployeeDao {

	@MyTransaction
	public void saveEmployee() {
		System.out.println("Employee is saved");
	}
	
}

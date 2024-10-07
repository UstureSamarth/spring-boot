package in.app.dao;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {

	public String saveEmployee() {
		if(new Random().nextInt(15)<10) {
			throw new RuntimeException("Dummy Exception");
		}
		return ("Employee is saved");
	}
	
}

package in.app.comp;

import java.util.List;

import in.app.dto.Employee;

public interface IEmplyeeDAO {
	List<Employee> findAllEmployees();
}

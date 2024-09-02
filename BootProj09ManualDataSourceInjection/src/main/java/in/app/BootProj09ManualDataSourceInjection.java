package in.app;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ApplicationContext;

import in.app.comp.IEmplyeeDAO;
import in.app.dto.Employee;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class })
public class BootProj09ManualDataSourceInjection {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(BootProj09ManualDataSourceInjection.class, args);
		IEmplyeeDAO empDAO = factory.getBean(IEmplyeeDAO.class);

		try {
			List<Employee> emps = empDAO.findAllEmployees();
			emps.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.comp.Employee;

@SpringBootApplication
public class BootProj05BeanInjectionWithCollectionYml {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(BootProj05BeanInjectionWithCollectionYml.class, args);
		Employee e = factory.getBean(Employee.class);
		System.out.println(e);
	}
}

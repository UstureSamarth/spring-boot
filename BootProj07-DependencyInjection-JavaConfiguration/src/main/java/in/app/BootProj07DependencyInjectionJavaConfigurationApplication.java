package in.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import in.app.comp.Student;

@SpringBootApplication
@ImportResource(locations = "applicationContext.xml")
public class BootProj07DependencyInjectionJavaConfigurationApplication {

	public static void main(String[] args) throws Exception {
		ApplicationContext factory=SpringApplication.run(BootProj07DependencyInjectionJavaConfigurationApplication.class, args);
		Student s=factory.getBean(Student.class);
		s.preparation("CET");
		
		
	}

}

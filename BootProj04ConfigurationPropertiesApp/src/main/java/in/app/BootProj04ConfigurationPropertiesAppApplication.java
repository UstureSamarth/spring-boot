package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.comp.Company;
import in.app.comp.Company2;

@SpringBootApplication
public class BootProj04ConfigurationPropertiesAppApplication {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(BootProj04ConfigurationPropertiesAppApplication.class, args);
		Company c=factory.getBean(Company.class);
		Company2 c2=factory.getBean(Company2.class);
		System.out.println(c);
		System.out.println(c2);
	}

}

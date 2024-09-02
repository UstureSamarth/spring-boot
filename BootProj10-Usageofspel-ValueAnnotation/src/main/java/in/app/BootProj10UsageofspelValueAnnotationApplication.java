package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.comp.BillGenerator;

@SpringBootApplication
public class BootProj10UsageofspelValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext factory=SpringApplication.run(BootProj10UsageofspelValueAnnotationApplication.class, args);
		BillGenerator b=factory.getBean(BillGenerator.class);
		System.out.println(b);
	}

}

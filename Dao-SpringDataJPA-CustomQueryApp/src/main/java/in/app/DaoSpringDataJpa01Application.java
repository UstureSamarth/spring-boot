package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.service.IVaccineService;
import in.app.service.VaccineServiceImpl;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		IVaccineService service = factory.getBean(VaccineServiceImpl.class);
		service.fetchDetailsByComapny("LABU").forEach(System.out::println);
	}

}

package in.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.app.service.IVaccineService;
import in.app.service.VaccineServiceImpl;
import in.app.type.ResultView;
import in.app.type.ResultView2;

@SpringBootApplication
public class DaoSpringDataJpa01Application {

	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(DaoSpringDataJpa01Application.class, args);
		IVaccineService service = factory.getBean(VaccineServiceImpl.class);
		service.searchVaccineByCompany("serum", ResultView.class).forEach(i->{
			System.out.println(i.getName()+" "+i.getCompany());
		});
		
		service.searchVaccineByCompany("serum", ResultView2.class).forEach(i->{
			System.out.println(i.getCountry()+" "+i.getPrice());
		});
	}

}

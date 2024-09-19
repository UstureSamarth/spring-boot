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
		/*
		 * Vaccine v = new Vaccine("Covishield", "Serum", "IND", 224.87, 2);
		 * System.out.println(service.registerVaccine(v)); List<Vaccine> vaccines=new
		 * ArrayList<Vaccine>(); Vaccine v1=new Vaccine("Sputnik", "LABR", "Russia",
		 * 231.4, 2); Vaccine v2=new Vaccine("Pyzer", "LABU", "USA", 231.3, 2); Vaccine
		 * v3=new Vaccine("Moderna", "LABU", "USA", 234.4, 2); vaccines.add(v1);
		 * vaccines.add(v2); vaccines.add(v3); Iterable<Vaccine>
		 * v=service.registerInBatch(vaccines); v.forEach(System.out::println);
		 */
		/*
		 * System.out.println("Total records are "+service.getVaccineCount()); Long
		 * regNo=2l; if(service.checkAvailabilityByRegNo(regNo)) {
		 * System.out.println("Record found with id "+regNo); }else {
		 * System.out.println("Record not found with id "+regNo);
		 * 
		 * } service.fetchAllDetails().forEach(System.out::println);
		 * System.out.println(); List<Long> ids=new ArrayList<>(); ids.add(1l);
		 * ids.add(4l); service.fetchAllDetailsByID(ids).forEach(System.out::println);
		 * Long id=5l; System.out.println(service.fetchVaccineByID(id));
		 */
		System.out.println(service.removeVaccineByID(3l));
	}

}

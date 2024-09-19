package in.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.app.bo.Vaccine;
import java.util.List;


public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
	List<Vaccine> findByCompany(String company);
	List<Vaccine> findByCompanyEquals(String company);
	List<Vaccine> findByPriceLessThan(Double price);
	
}

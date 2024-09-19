package in.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.app.bo.Vaccine;
import in.app.type.ResultView;

import java.util.List;


public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
	List<ResultView> findByPriceGreaterThanEqualOrderByPrice(Double price);
	
}

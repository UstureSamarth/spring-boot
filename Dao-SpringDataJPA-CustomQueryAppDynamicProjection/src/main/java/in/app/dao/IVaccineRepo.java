package in.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.app.bo.Vaccine;
import in.app.type.View;


public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {
	<T extends View> List<T> findByCompanyOrderByCompanyDesc(String company,Class<T> clazz);
}

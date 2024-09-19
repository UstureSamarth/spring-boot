package in.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import in.app.bo.Vaccine;

public interface IVaccineRepo extends PagingAndSortingRepository<Vaccine, Long>,CrudRepository<Vaccine, Long> {

}

package in.app.dao;

import org.springframework.data.repository.CrudRepository;

import in.app.bo.Vaccine;

public interface IVaccineRepo extends CrudRepository<Vaccine, Long> {

}

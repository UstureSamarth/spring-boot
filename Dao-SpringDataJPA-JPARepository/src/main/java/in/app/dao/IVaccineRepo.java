package in.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.app.bo.Vaccine;

public interface IVaccineRepo extends JpaRepository<Vaccine, Long> {

}

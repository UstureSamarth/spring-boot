package in.app.service;

import java.util.List;
import java.util.Optional;

import in.app.bo.Vaccine;

public interface IVaccineService {

	String registerVaccine(Vaccine v);
	Iterable<Vaccine> registerInBatch(Iterable<Vaccine> vaccines);
	Integer getVaccineCount();
	Boolean checkAvailabilityByRegNo(Long regNo);
	Iterable<Vaccine> fetchAllDetails();
	Iterable<Vaccine> fetchAllDetailsByID(List<Long> ids);
	Optional<Vaccine> fetchVaccineByID(Long id);
	String removeVaccineByID(Long id);
}

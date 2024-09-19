package in.app.service;

import java.util.List;

import in.app.bo.Vaccine;

public interface IVaccineService {
	List<Vaccine> fetchDetailsByComapny(String company);
}

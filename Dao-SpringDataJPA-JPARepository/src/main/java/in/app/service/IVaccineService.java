package in.app.service;

import java.util.List;

import in.app.bo.Vaccine;

public interface IVaccineService {
	List<Vaccine> searchVaccineByGivenData(Vaccine v,Boolean asc,String ...properties);
}

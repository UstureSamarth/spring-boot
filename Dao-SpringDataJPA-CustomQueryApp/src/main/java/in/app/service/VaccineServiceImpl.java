package in.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.bo.Vaccine;
import in.app.dao.IVaccineRepo;

@Service
public class VaccineServiceImpl implements IVaccineService {

	@Autowired
	private IVaccineRepo dao;

	@Override
	public List<Vaccine> fetchDetailsByComapny(String company) {
		dao.findByCompanyEquals(company).forEach(System.out::println);
		return dao.findByCompany(company);
	}

	
}

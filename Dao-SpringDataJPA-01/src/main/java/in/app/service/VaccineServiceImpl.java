package in.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.bo.Vaccine;
import in.app.dao.IVaccineRepo;

@Service
public class VaccineServiceImpl implements IVaccineService {

	@Autowired
	private IVaccineRepo dao;
	
	@Override
	public String registerVaccine(Vaccine v) {
		System.out.println("In memory proxy class is "+dao.getClass().getName());
		Vaccine saveVaccine=null;
		if(v!=null) {
			saveVaccine=dao.save(v);
		}
		return saveVaccine!=null? "Vaccine registered successfully "+saveVaccine.getRegNo():"Vaccine registration failed";
	}

	@Override
	public Iterable<Vaccine> registerInBatch(Iterable<Vaccine> vaccines) {

		if(vaccines!=null) {
			return dao.saveAll(vaccines);
		}else {
			throw new IllegalArgumentException("Batch insertion failed");
		}
		
	}

	@Override
	public Integer getVaccineCount() {
		return (int) dao.count();
	}

	@Override
	public Boolean checkAvailabilityByRegNo(Long regNo) {
		return dao.existsById(regNo);
	}

	@Override
	public Iterable<Vaccine> fetchAllDetails() {
		return dao.findAll();
	}

	@Override
	public Iterable<Vaccine> fetchAllDetailsByID(List<Long> ids) {
		return dao.findAllById(ids);
	}

	@Override
	public Optional<Vaccine> fetchVaccineByID(Long id) {
		return dao.findById(id);
	}

	@Override
	public String removeVaccineByID(Long id) {
		Optional<Vaccine> v=dao.findById(id);
		if(v.isPresent()) {
			dao.deleteById(id);
			return "Record deleted for id "+id;
		}
		
		return "Record not found for "+id;
	}

}

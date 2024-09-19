package in.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.dao.IVaccineRepo;
import in.app.type.View;

@Service
public class VaccineServiceImpl implements IVaccineService {

	@Autowired
	private IVaccineRepo dao;

	@Override
	public <T extends View> List<T> searchVaccineByCompany(String comapany, Class<T> clazz) {
		return dao.findByCompanyOrderByCompanyDesc(comapany, clazz);
	}


	

	
}

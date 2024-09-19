package in.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.dao.IVaccineRepo;
import in.app.type.ResultView;

@Service
public class VaccineServiceImpl implements IVaccineService {

	@Autowired
	private IVaccineRepo dao;

	@Override
	public List<ResultView> searchVaccineByStartPrice(Double price) {
		return dao.findByPriceGreaterThanEqualOrderByPrice(price);
	}

	

	
}

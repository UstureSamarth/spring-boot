package in.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.app.bo.Vaccine;
import in.app.dao.IVaccineRepo;

@Service
public class VaccineServiceImpl implements IVaccineService {

	@Autowired
	private IVaccineRepo dao;

	@Override
	public List<Vaccine> searchVaccineByGivenData(Vaccine v, Boolean asc, String... properties) {
		Example<Vaccine> example = Example.of(v);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);

		List<Vaccine> list = dao.findAll(example, sort);

		return list;
	}

}

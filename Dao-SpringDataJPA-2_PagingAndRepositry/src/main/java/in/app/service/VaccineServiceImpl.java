package in.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public Iterable<Vaccine> fetchDetails(boolean asc, String... properties) {
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		return dao.findAll(sort);
	}

	@Override
	public Iterable<Vaccine> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
		Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC : Direction.DESC, properties);
		Page<Vaccine> page = dao.findAll(pageable);
		return page.getContent();
	}

	@Override
	public void fetchDetailsByPagination(int pageSize) {
		Long count = dao.count();
		Long pageCount = count / pageSize;
		pageCount = count % pageSize == 0 ? pageCount : ++pageCount;

		for (int i = 0; i < pageCount; i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			Page<Vaccine> page=dao.findAll(pageable);
			page.getContent().forEach(System.out::println);
			System.out.println("-----------------"+(i+1)+"--------------------");
		}

	}

}

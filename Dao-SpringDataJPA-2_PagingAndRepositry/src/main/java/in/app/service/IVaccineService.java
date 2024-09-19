package in.app.service;

import in.app.bo.Vaccine;

public interface IVaccineService {

	Iterable<Vaccine> fetchDetails(boolean asc,String ...properties);
	Iterable<Vaccine> fetchDetailsByPageNo(int pageNo,int pageSize,boolean asc,String ...properties);
	void fetchDetailsByPagination(int pageSize);

}

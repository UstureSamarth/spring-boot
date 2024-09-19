package in.app.service;

import java.util.List;

import in.app.type.ResultView;

public interface IVaccineService {
	List<ResultView> searchVaccineByStartPrice(Double price);
}

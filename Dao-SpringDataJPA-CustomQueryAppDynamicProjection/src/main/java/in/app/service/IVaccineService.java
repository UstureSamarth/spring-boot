package in.app.service;

import java.util.List;

import in.app.type.View;

public interface IVaccineService {
	
	<T extends View> List<T> searchVaccineByCompany(String comapany,Class<T> clazz);
}

package in.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.app.service.IStudentService;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private IStudentService service;
	
	@Override
	public void run(String... args) throws Exception {

	}

}

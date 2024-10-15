package in.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.app.dao.IStudentDao;
import in.app.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private IStudentDao dao;

	@Override
	public String saveStudent(Student student) {
		Student s = dao.save(student);
		return "Student record saved with id " + s.getSid();
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAll();
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> optional = dao.findById(id);
		return optional.get();
	}

	@Override
	public String updateStudent(Student student) {
		Student s = dao.save(student);
		return "Student with id " + s.getSid() + " updated " + s.toString();
	}

	@Override
	public String deleteById(Integer id) {
		dao.deleteById(id);
		return "Student with id " + id + " deleted ";
	}

}

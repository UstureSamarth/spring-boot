package in.app.service;

import java.util.List;

import in.app.model.Student;

public interface IStudentService {

	String saveStudent(Student student);

	List<Student> findAllStudents();

	Student findById(Integer id);

	String updateStudent(Student student);

	String deleteById(Integer id);

}

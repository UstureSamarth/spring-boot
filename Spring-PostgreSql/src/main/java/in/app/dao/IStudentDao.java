package in.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.app.model.Student;

public interface IStudentDao extends JpaRepository<Student, Integer> {

}

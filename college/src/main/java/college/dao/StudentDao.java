package college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import college.entity.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

}

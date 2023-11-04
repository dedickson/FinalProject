package college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import college.entity.Professor;

public interface ProfessorDao extends JpaRepository<Professor, Long> {

}

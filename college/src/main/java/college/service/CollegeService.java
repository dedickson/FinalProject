package college.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import college.controller.model.CourseData;
import college.controller.model.ProfessorData;
import college.controller.model.StudentData;
import college.dao.CourseDao;
import college.dao.ProfessorDao;
import college.dao.StudentDao;
import college.entity.Course;
import college.entity.Professor;
import college.entity.Student;

@Service
public class CollegeService {

	@Autowired
	private ProfessorDao professorDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Autowired
	private CourseDao courseDao;
	
	@Transactional(readOnly = false)
	public ProfessorData saveProfessor(ProfessorData professorData) {
		 Professor professor = professorData.toProfessor();
		 Professor dbProfessor = professorDao.save(professor);
		 
		 return new ProfessorData(dbProfessor);
	}
	
	@Transactional(readOnly = false)
	public CourseData saveCourse(CourseData courseData) {
		Course course = courseData.toCourse();
		Course dbCourse = courseDao.save(course);

		return new CourseData(dbCourse);
	}

	@Transactional(readOnly = false)
	public StudentData saveStudent(StudentData studentData) {
		Student student = studentData.toStudent();
		Student dbStudent = studentDao.save(student);
		
		return new StudentData(dbStudent);
	}

	@Transactional(readOnly = true)
	public StudentData retrieveStudentById(Long studentId) {
		Student student = findStudentById(studentId);
		return new StudentData(student);
	}

	private Student findStudentById(Long studentId) {
		return studentDao.findById(studentId).orElseThrow(() -> new NoSuchElementException("Student with ID " + studentId + " is not valid"));
	}

	@Transactional(readOnly = true)
	public List<StudentData> retrieveAllStudents() {
		List<Student> studentEntities = studentDao.findAll();
		List<StudentData> studentDtos = new LinkedList<>();
		
		for(Student student : studentEntities) {
			StudentData studentData = new StudentData(student);
			studentDtos.add(studentData);
		}
		return studentDtos;
	}

	@Transactional(readOnly = false)
	public void deleteStudent(Long studentId) {
		Student student = findStudentById(studentId);
		studentDao.delete(student);
	}

	@Transactional(readOnly = false)
	public void deleteCourse(Long courseId) {
		Course course = findCourseById(courseId);
		courseDao.delete(course);
	}

	private Course findCourseById(Long courseId) {
		return courseDao.findById(courseId).orElseThrow(() -> new NoSuchElementException("Course with ID " + courseId + " is not valid"));
	}

	public void deleteProfessor(Long professorId) {
		Professor professor = findProfessorById(professorId);
		professorDao.delete(professor);
	}

	private Professor findProfessorById(Long professorId) {
		return professorDao.findById(professorId).orElseThrow(() -> new NoSuchElementException("Professor with ID " + professorId + " is not valid."));
	}

//	public void deleteStudentCourseByCourse(Long courseId) {
//		Course course = findCourseById(courseId);
//		courseDao.delete(course);
//	}
	
//	public void deleteStudentCourseByStudent (Long studentId) {
//		Student student = findStudentById(studentId);
//		studentDao.delete(student);
//	}


	

	
	

	
	
	
	
	
	

}

package college.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import college.controller.model.CourseData;
import college.controller.model.ProfessorData;
import college.controller.model.StudentData;
import college.service.CollegeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/college")
@Slf4j
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@PostMapping("/professor")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProfessorData createProfessor (@RequestBody ProfessorData professorData) {
		log.info("Creating professor {}", professorData);
		return collegeService.saveProfessor(professorData);
	}
	
	@PostMapping("/course")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CourseData createCourse (@RequestBody CourseData courseData) {
		log.info("Create a new course {}", courseData);
		return collegeService.saveCourse(courseData);
	}
	
	@PostMapping("/student")
	@ResponseStatus(code = HttpStatus.CREATED)
	public StudentData createStudent (@RequestBody StudentData studentData) {
		log.info("Create new student {}", studentData);
		return collegeService.saveStudent(studentData);
	}
	
	
	@GetMapping("/student/{studentId}")
	public StudentData retrieveStudent (@PathVariable Long studentId) {
		log.info("Retrieve student with ID = {}", studentId);
		return collegeService.retrieveStudentById(studentId);
	}
	
	@GetMapping("/student")
	public List<StudentData> retrieveAllStudents(){
		log.info("Retrieving all student");
		return collegeService.retrieveAllStudents();
	}
	
	
	@PutMapping("/student/{studentId}")
	public StudentData updateStudent(@PathVariable Long studentId, @RequestBody StudentData studentData){
		studentData.setStudentId(studentId);
		log.info("Update the student with ID = {}", studentData);
		return collegeService.saveStudent(studentData);
	}
	
	
	@DeleteMapping("/student/{studentId}")
	public Map<String, String> deleteStudent(@PathVariable Long studentId){
		log.info("Delete student with ID = {}", studentId);
		collegeService.deleteStudent(studentId);
		return Map.of("message", "Student with ID = " + studentId + " has been expelled.");
	}
	
	@DeleteMapping("/course/{courseId}")
	public Map<String, String> deleteCourse (@PathVariable Long courseId){
		log.info("Delete course with ID = {}", courseId );
		collegeService.deleteCourse(courseId);
		return Map.of("message", "Course with ID = " + courseId + " has been dropped.");
	}
	
	@DeleteMapping("/professor/{professorId}")
	public Map<String, String> deleteProfessor (@PathVariable Long professorId){
		log.info("Delete professor with ID = {}", professorId);
		collegeService.deleteProfessor(professorId);
		return Map.of("message", "Professor with ID = " + professorId + "has been fired.");
	}
	
//	@DeleteMapping("/student_course/{studentId}")
//	public Map<String, String> deleteStudentFromStudentCourse (@PathVariable Long studentId) {
//		log.info("Remove from the course catalog student with ID {}", studentId);
//		collegeService.deleteStudentCourseByStudent(studentId);
//		return Map.of("message", "Student with ID = " + studentId + " has been removed from the courses.");
//	}
	
//	@DeleteMapping("/student_course/{courseId}")
//	public Map<String, String> deleteCourseFromStudentCourse (@PathVariable Long courseId) {
//		log.info("Remove from the course catalog course with ID {}", courseId);
//		collegeService.deleteStudentCourseByCourse(courseId);
//		return Map.of("message", "Course with ID = " + courseId + " has been removed.");
//	}
	
	
	
	
	

}

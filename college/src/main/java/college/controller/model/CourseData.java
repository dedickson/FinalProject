package college.controller.model;

import java.util.HashSet;
import java.util.Set;

import college.entity.Course;
import college.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CourseData {

	
	private Long courseId;
	private String courseName; 
//	private Professor professor;
	private Set<StudentData> students = new HashSet<>();
	
	public CourseData(Course course) {
		this.courseId = course.getCourseId();
		this.courseName = course.getCourseName();
//		this.professor = course.getProfessor();
		
		for(Student student : course.getStudents()) {
			this.students.add(new StudentData(student));
		}
	}
	
	public Course toCourse() {
		Course course = new Course();
		
		course.setCourseId(courseId);
		course.setCourseName(courseName);
//		course.setProfessor(professor);
		
		for(StudentData studentData : students) {
			course.getStudents().add(studentData.toStudent());
		}
		
		return course;
	}
	
	
	
}

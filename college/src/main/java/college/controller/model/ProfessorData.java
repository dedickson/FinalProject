package college.controller.model;

import java.util.HashSet;
import java.util.Set;

import college.entity.Course;
import college.entity.Professor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfessorData {
	
	private Long professorId;
	private String firstName;
	private String lastName;
	private String department;
	private Set<CourseData> courses = new HashSet<>();
	
	public ProfessorData (Professor professor) {
		this.professorId = professor.getProfessorId();
		this.firstName = professor.getFirstName();
		this.lastName = professor.getLastName();
		this.department = professor.getDepartment();
		
		for(Course course : professor.getCourses()) {
			this.courses.add(new CourseData(course));
		}
	}

public ProfessorData(Long professorId, String firstName, String lastName, String department) {
	this.professorId = professorId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.department = department;
}

public Professor toProfessor() {
	Professor professor = new Professor();
	
	professor.setProfessorId(professorId);
	professor.setFirstName(firstName);
	professor.setLastName(lastName);
	professor.setDepartment(department);
	
	for(CourseData courseData : courses) {
		professor.getCourses().add(courseData.toCourse());
	}
	
	return professor;
}

	


	
	
	
}

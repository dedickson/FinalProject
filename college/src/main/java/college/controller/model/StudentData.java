package college.controller.model;

import college.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentData {
	
	private Long studentId;
	private String firstName;
	private String lastName;
	private String year;
	private String major;
	
	public StudentData(Student student) {
		
		this.studentId = student.getStudentId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.year = student.getYear();
		this.major = student.getMajor();
	}
	
	public Student toStudent() {
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setYear(year);
		student.setMajor(major);
		
		return student;
		
	}
	
	
}



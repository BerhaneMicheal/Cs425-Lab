package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class StudentmgmtApplication implements CommandLineRunner {
	private final StudentService studentService;

	public StudentmgmtApplication(StudentService studentService) {
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentmgmtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");


		var student = new Student(
				"000-61-0002",
				"Michael",
				"Berhane",
				"Gebremicael",
				3.45,
				LocalDate.of(2019, 5, 24));
//		saveStudent(student);

		var transcript= new Transcript(null, "BS Computer Science");
//		saveStudent(student, transcript);

		var classroom= new Classroom(null, "McLaughlin building", "M105");
//		saveStudent(student, transcript, classroom);

		var course= new Course(null,"CS401", "Modern Prog Practices");
		var course2= new Course(null,"CS425", "Software Engineering");
		var course3= new Course(null,"CS390", "FPP");
		saveStudent(student, transcript, classroom, List.of(course, course2, course3));
	}
	void saveStudent(Student student){
		var savedStudent=studentService.add(student);
		System.out.println("It is saved");
		System.out.println(savedStudent);
	}

	void saveStudent(Student student, Transcript transcript){
		student.setTranscript(transcript);
		var savedStudent=studentService.add(student);
		System.out.println("It is saved");
		System.out.println(savedStudent);
	}
	void saveStudent(Student student, Transcript transcript, Classroom classroom){
		student.setTranscript(transcript);
		student.setClassroom(classroom);
		var savedStudent=studentService.add(student);
		System.out.println("It is saved");
		System.out.println(savedStudent);
	}
	void saveStudent(Student student, Transcript transcript, Classroom classroom, List<Course> courses){
		student.setTranscript(transcript);
		student.setClassroom(classroom);
		student.setCourses(courses);
		var savedStudent=studentService.add(student);
		System.out.println("It is saved");
		System.out.println(savedStudent);
	}
}

package com.hannan.hannan;

import com.hannan.hannan.Dao.StudentDao;
import com.hannan.hannan.Entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class HannanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HannanApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDao studentDao){
		return runner -> {
			//createStudent(studentDao);
			//createMultipleStudent(studentDao);

			//findStudent(studentDao);
			//getAllStudents(studentDao);
			//updateStudent(studentDao);

			deleteStuden(studentDao);
		};

	}

	private void deleteStuden(StudentDao studentDao) {
		studentDao.delete(1);
		getAllStudents(studentDao);
	}

	private void updateStudent(StudentDao studentDao) {
		System.out.println("Update Student Object");

		int studentId = 3;
		System.out.println("We have student Id"+studentId);
		Student student = studentDao.find(3);
		System.out.println(student);
		student.setFirstname("PILANI");
		student.setLastname("YOUSUF");

		studentDao.update(student);
		Student student1 = studentDao.find(3);
		System.out.println(student1);

	}

	private void getAllStudents(StudentDao studentDao) {
		System.out.println("get All Student Object");

		List<Student> studentList = studentDao.findAll();

		for(Student tempStudent: studentList){
			System.out.println(tempStudent);
		}
	}


	private void findStudent(StudentDao studentDao) {
		System.out.println("Find Student Object");

		Student student = studentDao.find(1);
		System.out.println(student);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		//creating new Student
		System.out.println("creating new Student Object");
		Student student1 = new Student("Abdul Ahad","Rashid","droudrazer@gmail.com");
		Student student2 = new Student("Abdul Rehman","Arif","rehmank.k@gmail.com");
		Student student3 = new Student("Abdul Samad","Arif","khansamad.k@gmail.com");


		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDao studentDao) {
		//creating new Student
		System.out.println("creating new Student Object");
		Student student = new Student("Abdul Hannan","Arif","ah1663227@gmail.com");

		studentDao.save(student);

		// after saving print the success message
		System.out.println("save Student. Geneared Id:" + student.getId());


	}


}

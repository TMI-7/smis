package com.SpringBoot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.SpringBoot.sms.Entity.Student;
import com.SpringBoot.sms.Repository.StudentRepository;

/*
 * Instead of adding records manually to the DB,we gone write a code to add the records to the table.
 * Go to the Spring boot main entry point class,implement this class from CommandLineRunner interface.
     This provides a method called-run==>Implement this method.
 * his run method basically executes when we run our Spring boot application.
 * In this method we gone write some logic to insert some few student records.
 * Before that we are going to inject StudentRepository in this main class.The reason is because we are going to call StudentRepository methods here.
 * Go ahead and create various student objects in this run method as implementation and then using studentRepository reference variable, call save() method to persist the various objects to the DB:
 * Like this if you run your Spring boot application you will notice that all  the various student objects have been successfully added to the DB  and if you refresh the web page you are  able to view the list of students.
 * This means that we've successfully implemented List Students Feature. Hurreeeyy.
 * */

@SpringBootApplication
public class StudentmanagementsystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementsystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
		/*Student student1 = new Student("Colince", "TMI", "tmi2022@gmail.com");
		studentRepository.save(student1);
		Student student2 = new Student("Keneth", "Chillis", "ken2022@gmail.com");
		studentRepository.save(student2);
		Student student3 = new Student("Rufus", "Kairu", "kairu2022@gmail.com");
		studentRepository.save(student3);
		*/
	}

}

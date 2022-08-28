package com.SpringBoot.sms.Service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.sms.Entity.Student;
import com.SpringBoot.sms.Repository.StudentRepository;
import com.SpringBoot.sms.Service.StudentService;

/*
 * Before implementing this methods,first we have to annotate this class with @Service annotation to make it a Service class/Business logic class.
 * We mark Spring beans with @Service annotation to indicate that they are holding the business logic.
 * We are also going to inject the dependency here-Constructor based dependency injection we are going to use-StudentRepository is what we are going to inject here.
 * As we are using constructor based DI, we have to generate a constructor for this secondary type attribute.
 * And we also have to remember that if Spring bean has only one Constructor then @Autowired annotation can be omitted and Spring will use that constructor and inject all necessary dependencies
 * Now lets go to implementing our method.
.Like this we've done all the changes at the service layer.Now its time to change our controller layer.
 * */

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	/*
	 * We use studentRepository secondary type-->It provides all the CRUD methods.
	 * Use studentRepository to call findAll() method.
	 * findAll() method basically returns a List of Students.
	 * 
	 * */
	
	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}


}

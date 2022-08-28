package com.SpringBoot.sms.Service;

import java.util.List;

import com.SpringBoot.sms.Entity.Student;

/*
 * Under Service Package create-StudentService-interface
 * Within service package create a sub-package-ServiceImpl.
 * Right click on the service package, then just modify the package name by adding -.Impl-infront of it.
 * Typically we use spring provided Dependency injection to achieve Loosely coupling for the various independent layers.
 * For loosely coupling we gone use Interfaces and we separately create classes to implement this interfaces.This architecture is the one that helps achieve loosely coupling.
 * Thats why we use naming conventions in packages like,*Impl,used for Implementation classes.
 * In the Service Implementation Package create a class-StudentServiceImpl-which implements-StudentService-Interface.
 * 
 * Inside StudentService interface,We gone define a method-->List<Student> getAllStudent();
 *In StudentServiceImpl,Implement this method.
 * */

public interface StudentService {

	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(Long id);
	Student updateStudent(Student student);
	void deleteStudentById(Long id);
}

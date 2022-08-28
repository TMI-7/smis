package com.SpringBoot.sms.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.sms.Entity.Student;

/*
 * Extend this interface from -->JpaRepository.
 * JpaRepository has two parameters: ==Name of the JPA Entity-->In our case,Student,is the JPA Entity.
                                    ==Type of the PK--In our case we specified the type as -Long
We don't have to add @Repository annotation on top of StudentRepository Interface,because this JpaRepository interface has a default implementation class that is-SimpleJpaRepository
If you go inside SimpleJpaRepository implementation class, this class already annotated with @Repository annotation,hence the reason ,we don't need to add @Repository annotation again on top of StudentRepository interface.
Another important point is JpaRepository interface by default provides transaction for all it's methods.Hence again we don't need to add @Transacional annotation in Service layer.
If you go inside SimpleJpaRepository implementation class(JpaRepository interface default implementation class),It is annotated with @Transactional annotation.And if you can see the methods of the class-SimpleJpaRepository-All the methods are by default transcational because @Transactional annotation is added to all its public methods.
 *
 * NB:And like this our BASE for creating the Student Management System is Ready..!!
   ==
 * First we gone implement end to end List student feature then we will see how to implement add student feature and then update student feature,Delete student feature..etc.
 * Changes begin from backend part then we move to front end part.
 * StudentRepository-->Already gets all the CRUD Methods to interact with the DB
   =================-->We don't need to make any changes here.

 * */

public interface StudentRepository extends JpaRepository<Student, Long>{

}

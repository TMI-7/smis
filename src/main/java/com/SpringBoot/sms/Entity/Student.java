package com.SpringBoot.sms.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To keep it simple I just provided this few(4) properties/Fields,Make sure to add properties/Fields for Student class as per your requirement.
 * Generate getters setters to provide access to this private fields.Select all fields.
 * Generate a parameterized constructor for this fields except the id field.Ommit the id field during the generation of the parameterized constructor.
 * Make sure to create a default constructor as well,because Hibernate internally uses proxys to create objects dynamically and it needs a default constructor.
 * 
 * So whenever you create a parameterized constructor make sure to create a default constructor in JPA entity as well.
 * So far,the Student class we have created is just but a simple java class.
 * We use JPA annotations, I.E @Entity annotation to make this simple java class a JPA Entity class.
 * To map this Entity to DB tables we are going to use @Table annotation.
 * @Table annotation specifies the table in the database which this Entity is mapped.
 * Using this annotation we can provide table details i.e table name,EX:@Table(name="students")
 * To add a PK for this table we are going to use @Id annotation-->specifies the PK of the entity.
 * To provide PK generation strategy we are going to use
     @GeneratedValue annotation
     ==========================
     Has an attribute-strategy-which we use to specify the generation strategy.
     We are going to use: GenerationType.IDENTITY as the strategy.
 * @Id and @GeneratedValue(strategy=GenerationType.IDENTITY) are used on top of the  attribute we want to make as the PK for our table in this case--id attribute.
 * 
 * Mapping Column names for the fields/Attributes
==============================================
--Use @Column annotation on top of each of the rest other remaining attributes.
                       @Column annotation
                       ====================
                       --Has an attribute-name-to specify the column name.
                       --Has an attribute-nullable-to specify a column as NOT NULL.
    EX:@Column(name="first_name",nullable=false)
 
 *NB:--If you don't add @Table annotation the JPA by default add tablename as the name of the class.
  == --If you don't add @Column annotation then JPA by default add column name as name of the field.

 **/

@Entity
@Table(name="students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name",nullable = false)
	private String firstName;
	
	@Column(name="last_name",nullable = false)
	private String lastName;
	
	@Column(name="email",nullable = false)
	private String email;
	
	public Student() { 
		
	}
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

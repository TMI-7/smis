package com.SpringBoot.sms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.SpringBoot.sms.Entity.Student;
import com.SpringBoot.sms.Service.StudentService;

/*
 * Create class-StudentController.
 * Annotate this class with @Controller annotation.
 * @Controller annotation-->Indicate that a particular class serves the role of a Controller.
 * This makes the simple java class to be a spring MVC class that can handle the various http requests
 * 
 * Within the StudentController first we gone Inject the Dependency-->StudentService.
 * Generate a constructor for this class Secondary attribute as we are using Constructor DI.
 * And as we know if Spring Bean  has only one Constructor then we can omit @Autowired annotation.
 * -Now we are going to create a Handler method-listStudents()- to handle  list students request and return model and view.
 * 
 * */

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	/*
	 * Annotate it with @GetMapping("/students") with url students.
	 * Add a Model as a method argument to this method.
	 * Add data to this model,by calling it's method-model.addAttribute("key","value") with key value pair.
	 * For key am gonna use -students- and for value:
       =>Use studentService Secondary type to call getAllStudents() method.EX: studentService.getAllStudents()
	 * Finally am gone just return a view for this Controller Method-listStudents(Model model){}
	 * The view name am going to take as--students--This we will create in the Templates folder.
	 * Basically SpringBoot will AutoConfigure view Resolver for Thymeleaf,We don't have to create view Resolver bean for Thymeleaf.
	 * Spring boot will auto configure view Resolver for Thymeleaf,whenever Spring boot finds spring-boot-starter-thymeleaf dependency in class path.
	 * Another important thing is,By default spring boot will look for Thymeleaf templates in templates folder so we need to keep all our Thymeleaf HTML files under templates folder.
	 * 
	 * */
	
	//Handler method to handle list students and return model and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());//Like this here, by calling -studentService.getAllStudents() method  we are getting our model,which is a list of students.It's this model that we have to display  in the view.That is students.html
		return "students";//Here students is our view as Under templates folder we've created Thymeleaf HTML template-students.html
	}
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		//create empty Student object to hold Student Form data
		Student student = new Student();
		//Adding data to model,-->key is-student-and the value/empty Student object/model is-student->Which will be holding the form data
		model.addAttribute("student", student);
		//view-->Created in the templates folder.Go there to see its implementation.
		return "create_student"; 
	}
	
	/*
	 * We are going to use-@ModelAttribute annotation to directly bind form data to the object-student.I.E @ModelAttribute("student") and we are going to bind to the Student entity.I.E saveStudent(@ModelAttribute("student") Student student){}
	 * Save the student object to the DB and for that we are going to call-studentService.saveStudent(student);
	 * The saveStudent() is defined in the StudentService and implemented in the StudentServiceImpl. Visit to see this.
	 * Once,The user successfully add a student, then we need to redirect to-students- page
	   and students page  here means-->to the request above.I.E @GetMapping("/students")
	   
	 * Nothing but after executing this method handler-@PostMapping("/students") it will redirect to the method handler- @GetMapping("/students") for execution
	 *Run spring Boot application and see how i works.
	 * */
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model) {
		
	//First get student from DB by id
		Student existingStudent=studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
	//Save updated Student Object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	//Handler Method to Handle Delete Student request
	@GetMapping("students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}

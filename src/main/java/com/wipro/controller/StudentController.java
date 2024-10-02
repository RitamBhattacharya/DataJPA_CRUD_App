package com.wipro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.wipro.entity.Student;
import com.wipro.service.IStudentService;

@Controller
public class StudentController {
	@Autowired
	private IStudentService service;

	// Insert Methods
	public Student insertOne(Student s) {
		return service.insertOne(s);
	}

	public List<Student> insertMany(List<Student> s) {
		return service.insertMany(s);
	}

	// Update Methods
	public Student updateOne(Student s) {
		return service.updateOne(s);
	}

	public List<Student> updateMany(List<Student> s) {
		return service.updateMany(s);
	}

	// Searching Methods
	public Optional<Student> findById(Integer id) {
		return service.findById(id);
	}

	public List<Student> findAllById(List<Integer> ids) {
		return service.findAllById(ids);
	}

	public List<Student> findAll() {
		return service.findAll();
	}

	public boolean existsById(Integer id) {
		return service.existsById(id);
	}

	public long count() {
		return service.count();
	}

	// Delete Methods
	public void deleteById(Integer id) {
		service.deleteById(id);
	}

	public void deleteAllById(List<Integer> ids) {
		service.deleteAllById(ids);
	}

	public void deleteAll(List<Student> s) {
		service.deleteAll(s);
	}

	public void delete(Student s) {
		service.delete(s);
	}

	public void deleteAll() {
		service.deleteAll();
	}
	
	
	
	
	
	public void myController() {
		Scanner sc = new Scanner(System.in);
	    while (true) {
	        System.out.println();
	        System.out.println("========== Main Menu ==========");
	        System.out.println("1. ADD Student");
	        System.out.println("2. SEARCH Student");
	        System.out.println("3. UPDATE Student");
	        System.out.println("4. DELETE Student");
	        System.out.println("5. EXIT");

	        System.out.print("Enter your Option [1,2,3,4,5] : ");
	        int option = 0;

	        try {
	            option = sc.nextInt();
	            sc.nextLine();

	            switch (option) {
	            case 1:
	                System.out.println();
	                System.out.println("========== Student ADD Module ==========");
	                System.out.println("1. Insert One Record");
	                System.out.println("2. Insert Many Records");

	                System.out.print("Enter your Option [1,2] : ");
	                int insertOption = sc.nextInt();
	                sc.nextLine();

	                switch (insertOption) {
	                case 1:
	                    System.out.println();
	                    System.out.println("Inserting One Record");
	                    System.out.println("------------------------");
	                    Student s = new Student();

	                    System.out.print("Enter the Student no: ");
	                    s.setSno(sc.nextInt());

	                    System.out.print("Enter the Student Name: ");
	                    s.setSname(sc.next());

	                    System.out.print("Enter the Student Address: ");
	                    s.setSaddr(sc.next());

	                    System.out.print("Enter the Student Marks: ");
	                    s.setMarks(sc.nextDouble());

	                    insertOne(s);
	                    System.out.println("Record Inserted !!!!!");
	                    System.out.println();

	                    break;

	                case 2:
	                    System.out.println();
	                    System.out.println("Inserting Multiple Records");
	                    System.out.println("------------------------------");

	                    System.out.print("Enter the number of students you want to add: ");
	                    int numOfStudents = sc.nextInt();
	                   //sc.nextLine(); 

	                    List<Student> students = new ArrayList<>();

	                    for (int i = 1; i <= numOfStudents; i++) {
	                        System.out.println("Enter details for Student " + i + ":");
	                        Student student = new Student();

	                        System.out.print("Enter the Student no: ");
	                        student.setSno(sc.nextInt());
	                        sc.nextLine(); 

	                        System.out.print("Enter the Student Name: ");
	                        student.setSname(sc.next()); 

	                        System.out.print("Enter the Student Address: ");
	                        student.setSaddr(sc.next()); 
	                        
	                        System.out.print("Enter the Student Marks: ");
	                        student.setMarks(sc.nextDouble());
	                        sc.nextLine(); 

	                        students.add(student);
	                        System.out.println("Student " + i + " added to the list.\n");
	                    }

	                    insertMany(students);
	                    System.out.println(numOfStudents + " records inserted successfully!");
	                    System.out.println();
	                    break;

	                default:
	                    System.out.println("Invalid Insert Option. Please try again.");
	                } 
	                break;

	                
	                
	                
	            case 2: 
	                System.out.println();
	                System.out.println("========== Student SEARCH Module ==========");
	                System.out.println("1. Find one Student by ID");
	                System.out.println("2. Find Students by multiple IDs");
	                System.out.println("3. Check if a Student exists by ID");
	                System.out.println("4. Find all Students");
	                System.out.println("5. Count total number of Students");

	                System.out.print("Enter your search option [1,2,3,4,5] : ");
	                int searchOption = sc.nextInt();
	                sc.nextLine(); 

	                switch (searchOption) {
	                case 1:
	                    System.out.print("Enter the Student ID to search: ");
	                    int studentId = sc.nextInt();
	                    sc.nextLine();

	                    Optional<Student> student = findById(studentId); 
	                    if (student.isPresent()) {
	                        System.out.println("Student is :"+student.get());
	                    } else {
	                        System.out.println("No Student found with ID: " + studentId);
	                    }
	                    break;

	                case 2:
	                    System.out.println("Enter Student IDs separated by spaces:");
	                    String[] idsInput = sc.nextLine().split(" ");
	                    List<Integer> studentIds = new ArrayList<>();
	                    for (String id : idsInput) {
	                        studentIds.add(Integer.parseInt(id));
	                    }

	                    List<Student> studentsByIds = findAllById(studentIds); 
	                    if (!studentsByIds.isEmpty()) {
	                        System.out.println("Students Found: ");
	                        studentsByIds.forEach(System.out::println);
	                    } else {
	                        System.out.println("No Students found for the provided IDs.");
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter the Student ID to check: ");
	                    int checkStudentId = sc.nextInt();
	                    sc.nextLine(); 

	                    boolean exists = existsById(checkStudentId); 
	                    if (exists) {
	                        System.out.println("Student with ID " + checkStudentId + " exists.");
	                    } else {
	                        System.out.println("No Student found with ID: " + checkStudentId);
	                    }
	                    break;

	                case 4:
	                    List<Student> allStudents = findAll(); 
	                    if (!allStudents.isEmpty()) {
	                        System.out.println("All Students:");
	                        allStudents.forEach(System.out::println);
	                    } else {
	                        System.out.println("No Students found.");
	                    }
	                    break;

	                case 5:
	                    long studentCount = count();
	                    System.out.println("Total number of Students: " + studentCount);
	                    break;

	                default:
	                    System.out.println("Invalid search option. Please try again.");
	                }
	                break;


	                
	                
	                
	            case 3: 
	            	 System.out.println();
		                System.out.println("========== Student UPDATE Module ==========");
		                System.out.println("1. Update One Record");
		                System.out.println("2. Update Many Records");

		                System.out.print("Enter your Option [1,2] : ");
		                int updateOption = sc.nextInt();
		                sc.nextLine();

		                switch (updateOption) {
		                case 1:
		                    System.out.println();
		                    System.out.println("Updating One Record");
		                    System.out.println("------------------------");
		                    Student s = new Student();

		                    System.out.print("Enter the Student no: ");
		                    s.setSno(sc.nextInt());

		                    System.out.print("Enter the Student Name: ");
		                    s.setSname(sc.next());

		                    System.out.print("Enter the Student Address: ");
		                    s.setSaddr(sc.next());

		                    System.out.print("Enter the Student Marks: ");
		                    s.setMarks(sc.nextDouble());

		                    updateOne(s);
		                    System.out.println("Record Updated !!!!!");
		                    System.out.println();

		                    break;

		                case 2:
		                    System.out.println();
		                    System.out.println("Updating Multiple Records");
		                    System.out.println("------------------------------");

		                    System.out.print("Enter the number of students you want to update: ");
		                    int numOfStudents = sc.nextInt();
		                    sc.nextLine(); 

		                    List<Student> students = new ArrayList<>();

		                    for (int i = 1; i <= numOfStudents; i++) {
		                        System.out.println("Enter details for Student " + i + ":");
		                        Student student = new Student();

		                        System.out.print("Enter the Student no: ");
		                        student.setSno(sc.nextInt());
		                        sc.nextLine(); 

		                        System.out.print("Enter the Student Name: ");
		                        student.setSname(sc.next()); 

		                        System.out.print("Enter the Student Address: ");
		                        student.setSaddr(sc.next()); 

		                        System.out.print("Enter the Student Marks: ");
		                        student.setMarks(sc.nextDouble());
		                        sc.nextLine(); 

		                        students.add(student);
		                        System.out.println("Student " + i + " added to the list.\n");
		                    }

		                    updateMany(students);
		                    System.out.println(numOfStudents + " records updated successfully!");
		                    System.out.println();
		                    break;

		                default:
		                    System.out.println("Invalid Update Option. Please try again.");
		                } 
	                break;

	                
	                
	                
	            case 4: 
	                System.out.println();
	                System.out.println("========== Student DELETE Module ==========");
	                System.out.println("1. Delete by Student ID");
	                System.out.println("2. Delete by List of Student IDs");
	                System.out.println("3. Delete a Specific Student");
	                System.out.println("4. Delete Multiple Students");
	                System.out.println("5. Delete All Students");

	                System.out.print("Enter your Option [1,2,3,4,5]: ");
	                int deleteOption = sc.nextInt();
	                sc.nextLine(); 

	                switch (deleteOption) {
	                    case 1:
	                        System.out.print("Enter the Student ID to delete: ");
	                        int id = sc.nextInt();
	                        sc.nextLine();
	                        deleteById(id);
	                        System.out.println("Student with ID " + id + " deleted successfully.");
	                        break;

	                    case 2:
	                        System.out.print("Enter the number of Student IDs you want to delete: ");
	                        int numOfIds = sc.nextInt();
	                        sc.nextLine();

	                        List<Integer> ids = new ArrayList<>();
	                        for (int i = 1; i <= numOfIds; i++) {
	                            System.out.print("Enter Student ID " + i + ": ");
	                            ids.add(sc.nextInt());
	                            sc.nextLine();
	                        }

	                        deleteAllById(ids);
	                        System.out.println("Students with IDs " + ids + " deleted successfully.");
	                        break;

	                    case 3: 
	                        Student s = new Student();
	                        System.out.print("Enter the Student ID: ");
	                        s.setSno(sc.nextInt());
	                        sc.nextLine(); 

	                        System.out.print("Enter the Student Name: ");
	                        s.setSname(sc.next());

	                        System.out.print("Enter the Student Address: ");
	                        s.setSaddr(sc.next());

	                        System.out.print("Enter the Student Marks: ");
	                        s.setMarks(sc.nextDouble());
	                        sc.nextLine(); 

	                        delete(s);
	                        System.out.println("Student " + s.getSname() + " deleted successfully.");
	                        break;

	                    case 4:
	                        System.out.print("Enter the number of students you want to delete: ");
	                        int numOfStudentsToDelete = sc.nextInt();
	                        sc.nextLine();

	                        List<Student> studentsToDelete = new ArrayList<>();
	                        for (int i = 1; i <= numOfStudentsToDelete; i++) {
	                            Student stu = new Student();
	                            System.out.println("Enter details for Student " + i + ":");

	                            System.out.print("Enter the Student ID: ");
	                            stu.setSno(sc.nextInt());
	                            sc.nextLine(); 

	                            System.out.print("Enter the Student Name: ");
	                            stu.setSname(sc.next());

	                            System.out.print("Enter the Student Address: ");
	                            stu.setSaddr(sc.next());

	                            System.out.print("Enter the Student Marks: ");
	                            stu.setMarks(sc.nextDouble());
	                            sc.nextLine();

	                            studentsToDelete.add(stu);
	                        }

	                        deleteAll(studentsToDelete);
	                        System.out.println(numOfStudentsToDelete + " students deleted successfully.");
	                        break;

	                    case 5: 
	                        deleteAll();
	                        System.out.println("All students deleted successfully.");
	                        break;

	                    default:
	                        System.out.println("Invalid Delete Option! Please try again.");
	                }
	                break;
	                
	                
	                
	            case 5: 
	                System.out.println();
	                System.out.print("********** Thank You for using Student Application **********");
	                System.out.println();

	                sc.close();
	                System.exit(0);

	            default:
	                System.out.println("Wrong Choice!! Please Enter a valid no!!!");
	            }

	        } catch (Exception e) {
	            System.out.println("Invalid input! Please enter a valid option.");
	            e.printStackTrace();
	        }
	    }
	}
}

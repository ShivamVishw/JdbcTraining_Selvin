package com.jdbc;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.StudentDAO;
import com.jdbc.model.Student;

public class Main {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		
		
		while(true) {
			System.out.println("\n=========Student Mangement=======");
			System.out.println("1. Add Student");
			System.out.println("2. View All Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			System.out.println("Enter a choise: ");
			
			
			int choise = sc.nextInt();
			
			switch(choise) {
			case 1:
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				
				dao.addStudent(new Student(name, age));
				break;
				
			case 2:
				List<Student> students = dao.getAllStudent();
				
				for(Student s : students) {
					System.out.println(
							s.getId()+ " "
							+s.getName()+ " "
							+s.getAge());
				}
				break;
				
			case 3:
				System.out.println("Enter ID to update");
				int updateId = sc.nextInt();
				
				System.out.println("Enter new name");
				String newName = sc.next();
				System.out.print("Enter new age");
				int newAge = sc.nextInt();
				
				dao.updateStudent(new Student(updateId, newName, newAge));
				
				break;
				
			case 4: 
				System.out.println("Enter id to delete: ");
				int deleteId = sc.nextInt();
				dao.deleteStudent(deleteId);
				break;
				
			case 5: 
				System.out.println("Exiting ......");
				sc.close();
				System.exit(0);
			}
			
			
		}
	}
	
	
	
}

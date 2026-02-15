package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.model.Student;
import com.jdbc.util.DBConnection;

public class StudentDAO {
	
	// Create 
	public void addStudent(Student student) {
		
		String sql = "insert into student(name, age) values (?, ?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			
			ps.executeUpdate();
			System.out.println("Student Added Successfully");
			
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Read
	
	public List<Student> getAllStudent(){
		
		List<Student> list = new ArrayList<>();
		String sql = "select * from student";
		
		try(Connection con = DBConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
			
			
			while(rs.next()) {
				Student s = new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
				list.add(s);  // adding into list
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// Update operation 
	public void updateStudent(Student student) {
		String sql = "update student set name = ?, age= ? where id =?";
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setInt(3, student.getId());
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Student updated successfully");
			}else {
				System.out.println("Student not found");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Delete 
	public void deleteStudent(int id) {
		String sql = "delete from student where id = ?";
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){
			
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Student deleted successfully");
			}else {
				System.out.println("Student not found");
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	
	

}

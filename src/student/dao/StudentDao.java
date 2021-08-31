package student.dao;

import java.util.ArrayList;

import student.dto.Student;

public interface StudentDao {
	ArrayList<Student> selectStudentAll();
	Student selectStudentByNo(Student student);
	
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(Student student);
}

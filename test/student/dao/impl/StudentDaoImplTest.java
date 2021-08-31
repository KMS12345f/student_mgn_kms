package student.dao.impl;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import student.dao.StudentDao;
import student.dto.Student;

class StudentDaoImplTest {
	private StudentDao dao = StudentDaoImpl.getInstance();

	@AfterEach
	void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	void testSelectStudentAll() {
		System.out.println("testSelectStudentByAll()");
		ArrayList<Student> list = dao.selectStudentAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	void testSelectStudentByNo() {
		System.out.println("testSelectStudentByNo()");
		Student selectStudent = dao.selectStudentByNo(new Student(1));
		Assert.assertNotNull(selectStudent);
		System.out.println(selectStudent);
	}

	@Test
	void testInsertStudent() {
		System.out.println("testInsertStudent()");
		Student std = new Student(3, "abc", 99, 99, 99); // insert data
		int res = dao.insertStudent(std);  
		Assert.assertEquals(1, res);  //JUnit test확인
		
		dao.deleteStudent(std);
	}

	@Test
	void testUpdateStudent() {
		System.out.println("testUpdateStudent()");
		
		Student std = new Student(3, "abc", 99, 99, 99);
		dao.insertStudent(std);
		
		std.setSname("만점자");
		std.setKor(100);
		std.setEng(100);
		std.setMath(100);
		int res = dao.updateStudent(std);
		Assert.assertEquals(1, res);
		
		Student selstd = dao.selectStudentByNo(std);
		System.out.println(selstd);
		
		dao.deleteStudent(std);
	}

	@Test
	void testDeleteStudent() {
		System.out.println("testDeleteStudent()");
		
		Student std = new Student(3, "abc", 99, 99, 99);
		dao.insertStudent(std); // 데이터 추가부분
		
		int res = dao.deleteStudent(std);
		Assert.assertEquals(1, res); 
		
		Student selstd = dao.selectStudentByNo(std);
		Assert.assertNull(selstd);
	}

}

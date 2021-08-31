package student.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import student.dao.StudentDao;
import student.dto.Student;
import student_mgn_kms.util.JdbcUtil;

public class StudentDaoImpl implements StudentDao {
	private static final StudentDaoImpl instance = new StudentDaoImpl();
	
	public StudentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static StudentDaoImpl getInstance() {
		return instance;
	}

	@Override
	public ArrayList<Student> selectStudentAll() {
		String sql = "select sno, sname, kor, eng, math from student";
		ArrayList<Student> list = null;
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			list = new ArrayList<Student>();
			while (rs.next()) {
				list.add(getStudent(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Student selectStudentByNo(Student std) {
		String sql = "select sno, sname, kor, eng, math from student where sno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, std.getSno());
			try(ResultSet rs = pstmt.executeQuery()){
				if (rs.next()) {
					return getStudent(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Student getStudent(ResultSet rs) throws SQLException {
		// sno, sname, kor, eng, math, getTotal, getCount
		int sno = rs.getInt("sno");
		String sname = rs.getString("sname");
		int kor = rs.getInt("kor");
		int eng = rs.getInt("eng");
		int math = rs.getInt("math");
		
		return new Student(sno, sname, kor, eng, math);
	}

	@Override
	public int insertStudent(Student student) {
		String sql = "insert into student values (?, ?, ?, ?, ?);";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setInt(1, student.getSno());
			pstmt.setString(2, student.getSname());
			pstmt.setInt(3, student.getKor());
			pstmt.setInt(4, student.getEng());
			pstmt.setInt(5, student.getMath());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update student set sname = ?, kor = ?, eng = ?, math = ? where sno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getKor());
			pstmt.setInt(3, student.getEng());
			pstmt.setInt(4, student.getMath());
			pstmt.setInt(5, student.getSno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int deleteStudent(Student student) {
		String sql = "delete from student where sno = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setInt(1, student.getSno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

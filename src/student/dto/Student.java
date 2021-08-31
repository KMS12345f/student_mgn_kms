package student.dto;

public class Student {
	private int sno;
	private String sname;
	private int kor;
	private int eng;
	private int math;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int sno) {
		this.sno = sno;
	}

	public Student(int sno, String sname, int kor, int eng, int math) {
		this.sno = sno;
		this.sname = sname;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	
	int getTotal(){
		return kor + eng + math;
	}
	
	double getCount() {
		return (int)getTotal()/3;
	}

	@Override
	public String toString() {
		return String.format(" 학생정보 학번 : %s, 이름 : %s%n 국어점수 : %d, 영어점수 : %d, 수학점수 : %d%n 총점 : %d, 평균 : %.1f%n"
				, sno, sname, kor, eng, math, getTotal(), getCount());
	}
	
	
	
}
	
	
	

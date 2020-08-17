package java_swing_erp.dto;

public class Student {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int no) {
		this.no = no;
	}

	public Student(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public int getTotal() {
		return kor + eng + math;
	}
	
	public double getAverage() {
		return Double.parseDouble(String.format("%.2f", getTotal() / 3D));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + no;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		return this.no == ((Student)obj).no;
	}

	@Override
	public String toString() {
		return String.format("%3d %5s %3d %3d %3d %3d %.2f", 
				no, name, kor, eng, math, getTotal(), getAverage());
	}
	
	

}

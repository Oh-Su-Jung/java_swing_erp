package java_swing_erp.dto;

public class Department {
	private int no;
	private String name;
	private String tel;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int no) {
		this.no = no;
	}

	public Department(int no, String name, String tel) {
		this.no = no;
		this.name = name;
		this.tel = tel;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
		return no == ((Department)obj).no;
	}

	@Override
	public String toString() {
		return String.format("Department [no=%s, name=%s, tel=%s]", no, name, tel);
	}
	
	
	
	
}

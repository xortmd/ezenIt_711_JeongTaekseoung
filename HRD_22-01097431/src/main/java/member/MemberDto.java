package member;

public class MemberDto {
	private int custno;
	private String custName;
	private String phone;
	private String address;
	private String joinDate;
	private String grade;
	private String city;
	
	public MemberDto(int custno, String custName, String phone, String address, String joinDate, String grade, String city) {
		this.custno = custno;
		this.custName = custName;
		this.phone = phone;
		this.address = address;
		this.joinDate = joinDate;
		this.grade = grade;
		this.city = city;
	}

	public int getCustno() {
		return custno;
	}

//	public void setCustno(int custno) {
//		this.custno = custno;
//	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJoinDate() {
		return joinDate.split(" ")[0];
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	public String getGrade() {
		return grade;
	}

	public String getGradeString() {
		if(this.grade.equals("A"))
			return "VIP";
		else if(this.grade.equals("B"))
			return "일반";
		else
			return "직원";
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

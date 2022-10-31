package user;

import java.sql.Timestamp;

public class UserDto {
	private int code;
	private String id;
	private String password;
	private String name;
	private String address;
	private String phone;
	private int license;
	private Timestamp regDate;
	
	public UserDto(int code, String id, String password, String name, String address, String phone, int license,
			Timestamp regDate) {
		super();
		this.code = code;
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.license = license;
		this.regDate = regDate;
	}
	
	public UserDto(int code, String password, String name, String address, String phone) {
		super();
		this.code = code;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public UserDto(int code) {
		super();
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public String getId() {
		return id;
	}

//	public void setId(String id) {
//		this.id = id;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getLicense() {
		return license;
	}

//	public void setLicense(int license) {
//		this.license = license;
//	}

	public Timestamp getRegDate() {
		return regDate;
	}

//	public void setRegDate(Timestamp regDate) {
//		this.regDate = regDate;
//	}	
}

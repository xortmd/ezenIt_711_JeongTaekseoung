package car;

import java.sql.Timestamp;

public class CarDto {
	private int code;
	private String name;
	private int carNo;
	private int year;
	private int km;
	private int price;
	private String kind;
	private String fuel;
	private Timestamp regDate;
	
	public CarDto(int code, String name, int carNo, int year, int km, int price, String kind, String fuel, Timestamp regDate) {
		super();
		this.code = code;
		this.name = name;
		this.carNo = carNo;
		this.year = year;
		this.km = km;
		this.kind = kind;
		this.fuel = fuel;
		this.price = price;
		this.regDate = regDate;
	}
	
	public CarDto(int code, String name, int carNo, int year, int km, int price, String kind, String fuel) {
		super();
		this.code = code;
		this.name = name;
		this.carNo = carNo;
		this.year = year;
		this.km = km;
		this.kind = kind;
		this.fuel = fuel;
		this.price = price;
	}
	
	public CarDto(int code, int km, int price) {
		super();
		this.code = code;
		this.km = km;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

//	public void setCode(int code) {
//		this.code = code;
//	}
	
	public String getName() {
		return name;
	}

	public int getCarNo() {
		return carNo;
	}

//	public void setCarNo(int carNo) {
//		this.carNo = carNo;
//	}

	public int getYear() {
		return year;
	}

//	public void setYear(int year) {
//		this.year = year;
//	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getKind() {
		return kind;
	}

//	public void setCarKind(String kind) {
//		this.kind = kind;
//	}

	public String getFuel() {
		return fuel;
	}

//	public void setFuel(String fuel) {
//		this.fuel = fuel;
//	}

	public Timestamp getRegDate() {
		return regDate;
	}

//	public void setRegDate(Timestamp regDate) {
//		this.regDate = regDate;
//	}
	
}

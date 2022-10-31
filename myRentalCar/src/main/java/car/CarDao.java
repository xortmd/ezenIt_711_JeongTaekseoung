package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.DBManager;

public class CarDao {
	
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // 결과테이블
	
	private CarDao() {
		this.url = "jdbc:mysql://localhost:3306/mvc2_car";
		this.user = "root";
		this.password = "1234";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	private static CarDao instance = new CarDao();
	public static CarDao getInstance() {
		return instance;
	}
	
	// CRUD
	// Create
	public void createCar(CarDto car) {
		String sql = "insert into car values(?, ?, ?, ?, ?, ?, ?, ?, ?);";
		int code = codeGenerator();
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, code);
			this.pstmt.setString(2, car.getName());
			this.pstmt.setInt(3, car.getCarNo());
			this.pstmt.setInt(4, car.getYear());
			this.pstmt.setInt(5, car.getKm());
			this.pstmt.setInt(6, car.getPrice());
			this.pstmt.setString(7, car.getKind());
			this.pstmt.setString(8, car.getFuel());
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(9, now);
			
			this.pstmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
				this.conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int codeGenerator() {
		String sql = "SELECT MAX(`code`) FROM car;";
		int code = 0;
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			if(this.rs.next()) {
				code = this.rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ++code;
	}
	
	// Read
	// 1. All
	public ArrayList<CarDto> getCarAll() {
		ArrayList<CarDto> list = new ArrayList<CarDto>();
		String sql = "SELECT * FROM car ORDER BY `code`";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int code = this.rs.getInt(1);
				String name = this.rs.getString(2);
				int carNo = this.rs.getInt(3);
				int year = this.rs.getInt(4);
				int km = this.rs.getInt(5);
				int price = this.rs.getInt(6);
				String kind = this.rs.getString(7);
				String fuel = this.rs.getString(8);
				Timestamp regDate = this.rs.getTimestamp(9);
				
				CarDto car = new CarDto(code, name, carNo, year, km, price, kind, fuel, regDate);
				list.add(car);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	// 2. One
	public CarDto getCarByCode(int code) {
		CarDto car = null;
		String sql = "SELECT * FROM car WHERE `code` = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, code);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String name = this.rs.getString(2);
				int carNo = this.rs.getInt(3);
				int year = this.rs.getInt(4);
				int km = this.rs.getInt(5);
				int price = this.rs.getInt(6);
				String kind = this.rs.getString(7);
				String fuel = this.rs.getString(8);
				Timestamp regDate = this.rs.getTimestamp(9);
				
				car = new CarDto(code, name, carNo, year, km, price, kind, fuel, regDate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return car;
	}
	
	// Update
	public void updateCar(CarDto car) {
		String sql = "UPDATE car SET km = ?, price = ? WHERE code = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, car.getKm());
			this.pstmt.setInt(2, car.getPrice());
			this.pstmt.setInt(3, car.getCode());
			
			this.pstmt.execute();
			
			System.out.println("UPDATE SUCCESS");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("UPDATE FAIL");
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Delete
	public void deleteCar(CarDto car) {
		String sql = "DELETE FROM car WHERE code = ?;";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, car.getCode());
			
			this.pstmt.execute();
			
			System.out.println("DELETE SUCCESS");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("DELETE FAIL");
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

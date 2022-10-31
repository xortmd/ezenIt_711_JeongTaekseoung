package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class UserDao {
	
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private UserDao() {
		this.url = "jdbc:mysql://localhost:3306/mvc2_car";
		this.user = "root";
		this.password = "1234";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	
	private static UserDao instance = new UserDao();
	public static UserDao getInstance() {
		return instance;
	}
	
	// CRUD
	// Create
	public void createUser(UserDto user) {
		String sql = "INSERT INTO user VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		int code = codeGenerator();
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, code);
			this.pstmt.setString(2, user.getId());
			this.pstmt.setString(3, user.getPassword());
			this.pstmt.setString(4, user.getName());
			this.pstmt.setString(5, user.getAddress());
			this.pstmt.setString(6, user.getPhone());
			this.pstmt.setInt(7, user.getLicense());
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(8, now);
			
			this.pstmt.execute();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int codeGenerator() {
		String sql = "SELECT MAX(`code`) FROM user;";
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
	public ArrayList<UserDto> getUserAll() {
		ArrayList<UserDto> list = new ArrayList<>();
		
		String sql = "SELECT * FROM user ORDER BY `code`;";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			while(this.rs.next()) {
				int code = this.rs.getInt(1);
				String id = this.rs.getString(2);
				String password = this.rs.getString(3);
				String name = this.rs.getString(4);
				String address = this.rs.getString(5);
				String phone = this.rs.getString(6);
				int license = this.rs.getInt(7);
				Timestamp regDate = this.rs.getTimestamp(8);
				
				UserDto user = new UserDto(code, id, password, name, address, phone, license, regDate);
				list.add(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
				this.rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public UserDto getUserById(String id) {
		UserDto user = null;
		
		String sql = "SELECT * FROM user WHERE `id` = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, id);
			this.rs = pstmt.executeQuery();
			
			if(this.rs.next()) {
				int code = this.rs.getInt(1);
				String password = this.rs.getString(3);
				String name = this.rs.getString(4);
				String address = this.rs.getString(5);
				String phone = this.rs.getString(6);
				int license = this.rs.getInt(7);
				Timestamp regDate = this.rs.getTimestamp(8);
				
				user = new UserDto(code, id, password, name, address, phone, license, regDate);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
				this.rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	// Update
	public void updateUser(UserDto user) {
		
		String sql = "UPDATE user SET password = ?, name = ?, address = ?, phone = ? WHERE `code` = ?;";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getPassword());
			this.pstmt.setString(2, user.getName());
			this.pstmt.setString(3, user.getAddress());
			this.pstmt.setString(4, user.getPhone());
			this.pstmt.setInt(5, user.getCode());
			
			this.pstmt.execute();
		} catch(Exception e) {
			e.printStackTrace();
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
	public void deleteUser(UserDto user) {
		
		String sql = "DELETE FROM user WHERE code = ?;";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, user.getCode());
			
			this.pstmt.execute();
		} catch(Exception e) {
			e.printStackTrace();
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

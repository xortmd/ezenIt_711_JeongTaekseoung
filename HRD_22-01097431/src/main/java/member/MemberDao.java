package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import money.MoneyDao;
import money.MoneyDto;
import util.DBManager;

public class MemberDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	private MemberDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##myid";
		this.password = "mypw";
	}
	
	private static MemberDao instance = new MemberDao();
	
	public static MemberDao getInstance() {
		return instance;
	}
	
	// CRUD
	// 1. CREATE
	public int getLastCustno() {
		int result = 0;
		String sql = "SELECT MAX(custno) FROM member_tbl_02";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			if(rs.next())
				result = rs.getInt(1) + 1;
			
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
		return result;
	}
	
	
	public void addMember(MemberDto member) {
		String sql = "INSERT INTO member_tbl_02 VALUES(?,?,?,?,?,?,?)";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, member.getCustno());
			this.pstmt.setString(2, member.getCustName());
			this.pstmt.setString(3, member.getPhone());
			this.pstmt.setString(4, member.getAddress());
			this.pstmt.setString(5, member.getJoinDate());
			this.pstmt.setString(6, member.getGrade());
			this.pstmt.setString(7, member.getCity());
			
			this.pstmt.execute();
			
			System.out.println("INSERT SUCCESS");
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("INSERT FAIL");
		} finally {
			try {
				this.conn.close();
				this.pstmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 2. READ
	public MemberDto getMember(int custno) {
		MemberDto result = null;
		String sql = "SELECT * FROM member_tbl_02 WHERE custno = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.pstmt.setInt(1, custno);
			this.rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String custName = rs.getString(2);
				String phone = rs.getString(3);
				String address = rs.getString(4);
				String joinDate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				result = new MemberDto(custno, custName, phone, address, joinDate, grade, city);
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
		
		return result;
	}
	
	public ArrayList<MemberDto> getMemberAll() {
		ArrayList<MemberDto> result = new ArrayList<>();
		String sql = "SELECT * FROM member_tbl_02";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				String custName = rs.getString(2);
				String phone = rs.getString(3);
				String address= rs.getString(4);
				String joinDate = rs.getString(5);
				String grade = rs.getString(6);
				String city = rs.getString(7);
				
				result.add(new MemberDto(custno, custName, phone, address, joinDate, grade, city));
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
		
		return result;
	}
	
	public int getMemberSales(int custno) {
		int sum = 0;
		
		MoneyDao moneyDao = MoneyDao.getInstance();
		ArrayList<MoneyDto> monList = moneyDao.getMoneyAll();
		
		for(MoneyDto money : monList) {
			if(money.getCustno() == custno)
				sum += money.getPrice();
		}
		
		return sum;
	}
	
	// 3. UPDATE
	public void updateMember(MemberDto member) {
		String sql = "UPDATE member_tbl_02 SET custname = ?, phone = ?, address = ?,"
				+ "joindate = ?, grade = ?, city = ? WHERE custno = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, member.getCustName());
			this.pstmt.setString(2, member.getPhone());
			this.pstmt.setString(3, member.getAddress());
			this.pstmt.setString(4, member.getJoinDate());
			this.pstmt.setString(5, member.getGrade());
			this.pstmt.setString(6, member.getCity());
			this.pstmt.setInt(7, member.getCustno());
			
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
	
	// 4. DELETE
}

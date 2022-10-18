package money;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.MemberDao;
import member.MemberDto;
import util.DBManager;

public class MoneyDao {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String url;
	private String user;
	private String password;
	
	private MoneyDao() {
		this.url = "jdbc:oracle:thin:@localhost:1521:xe";
		this.user = "c##myid";
		this.password = "mypw";
	}
	
	private static MoneyDao instance = new MoneyDao();
	
	public static MoneyDao getInstance() {
		return instance;
	}
	
	public ArrayList<MoneyDto> getMoneyAll() {
		ArrayList<MoneyDto> result = new ArrayList<MoneyDto>();
		String sql = "SELECT * FROM money_tbl_02";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				int salenol = rs.getInt(2);
				int pcost = rs.getInt(3);
				int amount = rs.getInt(4);
				int price = rs.getInt(5);
				String pcode = rs.getString(6);
				String sdate = rs.getString(7);
				
				result.add(new MoneyDto(custno, salenol, pcost, amount, price, pcode, sdate));
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
	
	public ArrayList<String[]> getSalesReport() {
		ArrayList<String[]> result = new ArrayList<>();
		String sql = "SELECT custno, SUM(price) AS total FROM money_tbl_02 GROUP BY custno ORDER BY total DESC";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int custno = rs.getInt(1);
				int total = rs.getInt(2);
				
				MemberDao memberDao = MemberDao.getInstance();
				MemberDto member = memberDao.getMember(custno);
				
				String[] data = new String[4];
				
				data[0] = custno + "";
				data[1] = member.getCustName();
				data[2] = member.getGradeString();
				data[3] = total + "";
				
				result.add(data);
				
				System.out.println(data[0]);
				System.out.println(data[1]);
				System.out.println(data[2]);
				System.out.println(data[3]);
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
}

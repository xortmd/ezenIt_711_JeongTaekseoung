package community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import util.DBManager;

public class CommunityDao {
	
	private String url;
	private String user;
	private String password;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; // 결과테이블
	
	// 단일한 인스턴스 제공
	// Singletone 구현
	private CommunityDao() {
		this.url = "jdbc:mysql://localhost:3306/mvc2_car";
		this.user = "root";
		this.password = "1234";
		
		this.conn = null;
		this.pstmt = null;
		this.rs = null;
	}
	private static CommunityDao instance = new CommunityDao();
	public  static CommunityDao getInstance() {
		return instance;
	}
	
	// CRUD
	// Create
	public void createCommunity(CommunityDto community) {
		String sql = "insert into community values(?, ?, ?, ?, ?, ?, ?, ?);";
		int no = noGenerator(); // 마지막 no + 1
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no); // 마지막 no + 1
			this.pstmt.setString(2, community.getTitle());
			this.pstmt.setString(3, community.getContent());
			this.pstmt.setString(4, community.getUser());
			this.pstmt.setString(5, community.getPassword());
			
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(6, now);
			this.pstmt.setTimestamp(7, now);
			this.pstmt.setInt(8, 0);
			
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
	
	private int noGenerator() {
		String sql = "SELECT MAX(`no`) FROM community;";
		int no = 0;
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = pstmt.executeQuery();
			
			if(this.rs.next()) {
				no = this.rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				this.pstmt.close();
				this.conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return ++no;
	}
	
	// Read
	// 1. All
	public ArrayList<CommunityDto> getCommunityAll() {
		ArrayList<CommunityDto> list = new ArrayList<CommunityDto>();
		String sql = "SELECT * FROM community ORDER BY `no`";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				int no = this.rs.getInt(1);
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				String password = this.rs.getString(5);
				Timestamp regDate = this.rs.getTimestamp(6);
				Timestamp modDate = this.rs.getTimestamp(7);
				int viewCnt = this.rs.getInt(8);
				
				CommunityDto community = new CommunityDto(no, title, content, user, password, regDate, modDate, viewCnt);
				list.add(community);
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
	public CommunityDto getCommunityByNo(int no) {
		CommunityDto community = null;
		String sql = "SELECT * FROM community WHERE `no` = ?";
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, no);
			this.rs = this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				String title = this.rs.getString(2);
				String content = this.rs.getString(3);
				String user = this.rs.getString(4);
				String password = this.rs.getString(5);
				Timestamp regDate = this.rs.getTimestamp(6);
				Timestamp modDate = this.rs.getTimestamp(7);
				int viewCnt = this.rs.getInt(8);
				
				community = new CommunityDto(no, title, content, user, password, regDate, modDate, viewCnt);
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
		return community;
	}
	
	// Update
	public void updateCommunity(CommunityDto community) {
		String sql = "UPDATE community SET title = ?, content = ?, modDate = ? WHERE no = ?";
		
		int no = community.getNo();
		String title = community.getTitle();
		String content = community.getContent();
//		String password = board.getPassword();
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setString(1, title);
			this.pstmt.setString(2, content);
			Timestamp now = new Timestamp(System.currentTimeMillis());
			this.pstmt.setTimestamp(3, now);
			this.pstmt.setInt(4, no);
			
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
	public void deleteCommunity(CommunityDto community) {
		String sql = "DELETE FROM community WHERE no = ?;";
		
		int no = community.getNo();
		
		try {
			this.conn = DBManager.getConnection(this.url, this.user, this.password);
			this.pstmt = conn.prepareStatement(sql);
			
			this.pstmt.setInt(1, no);
			
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

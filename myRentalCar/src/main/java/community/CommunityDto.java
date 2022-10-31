package community;

import java.sql.Timestamp;

public class CommunityDto {
	
	// no title content user password regDate modDate viewCnt
	private int no;
	private String title;
	private String content;
	private String user;
	private String password;
	private Timestamp regDate;
	private Timestamp modDate;
	private int viewCnt;
	
	// All Arguments Constructor
	public CommunityDto(int no, String title, String content, String user, String password, Timestamp regDate,
			Timestamp modDate, int viewCnt) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.user = user;
		this.password = password;
		this.regDate = regDate;
		this.modDate = modDate;
		this.viewCnt = viewCnt;
	}
	public CommunityDto(int no, String title, String content,  String password) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.password = password;
	}
	public CommunityDto(String title, String content, String user, String password) {
		super();
		this.title = title;
		this.content = content;
		this.user = user;
		this.password = password;
	}
	public int getNo() {
		return no;
	}
//	public void setNo(int no) {
//		this.no = no;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser() {
		return user;
	}
//	public void setUser(String user) {
//		this.user = user;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
//	public void setRegDate(Timestamp regDate) {
//		this.regDate = regDate;
//	}
	public Timestamp getModDate() {
		return modDate;
	}
	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}

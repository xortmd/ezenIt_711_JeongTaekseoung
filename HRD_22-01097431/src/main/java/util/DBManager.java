package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	public static Connection getConnection(String url, String user, String password) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ����");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("�����ͺ��̽� ���� ����");
		}
		
		return conn;
	}
	
}

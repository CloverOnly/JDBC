package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {
	
	public static void main(String[] args) {
		//DB ����
		Connection conn = null;
		try {
			//JDBC Driver ���
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletex",
												"root","1234"); //���, id, pw
			System.out.println("���� ���� Ȯ��");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//���� ����
					conn.close();
					System.out.println("���� ���� Ȯ��");
				}catch (SQLException e) {}
			}
		}
	}

}

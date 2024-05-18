package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 insert ��
 users ���̺� ���ο� ����� ������ �����ϴ� INSERT�� ����
 INSERT ���� String Ÿ�� ���� sql�� ���ڿ��� ���� 
 */
public class UserInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC ���
			Class.forName("com.mysql.cj.jdbc.Driver");
			//�����ϱ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf8",
												"root", "1234");
			
			//INSERT ���� String Ÿ�� ���� sql�� ���ڿ��� ���� 
			String sql = ""+
			"INSERT INTO users(userid, username, userpassword, userage, useremail )" + "VALUES(?,?,?,?,?) ";	
			//�پ�� ����
			
			//PreparedStatement ��� �� �� ����
			//�Ű�����ȭ�� SQL���� �����ϱ� ���� Connection�� prepareDtatement()�޼ҵ�κ��� PreparedStatement�� ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//������	27�ڵ� ?�� ���� ��
			pstmt.setString(1, "winter");
			pstmt.setString(2, "�Ѱܿ�");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "winter@mycompany.com" );
			
			//�� ������ executeUpdate() �޼ҵ带 ȣ���ϸ� SQL���� ����Ǹ鼭 users ���̺� 1���� ���� ����
			int rows = pstmt.executeUpdate();
			System.out.println("����� �� ��: " + rows);
			
			//close()�޼ҵ带 ȣ���ϸ� PreparedStatement�� ����ߴ� �޸� ����
			pstmt.close();
			
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {}
			}
		}
		
		
	}
}
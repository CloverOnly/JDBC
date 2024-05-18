package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 insert 문
 users 테이블에 새로운 사용자 정보를 저장하는 INSERT문 실행
 INSERT 문을 String 타입 변수 sql에 문자열로 대입 
 */
public class UserInsertExample {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			//JDBC 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			//연결하기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletex?useUnicode=true&characterEncoding=utf8",
												"root", "1234");
			
			//INSERT 문을 String 타입 변수 sql에 문자열로 대입 
			String sql = ""+
			"INSERT INTO users(userid, username, userpassword, userage, useremail )" + "VALUES(?,?,?,?,?) ";	
			//뛰어쓰기 주의
			
			//PreparedStatement 얻기 및 값 지정
			//매개변수화된 SQL문을 실행하기 위해 Connection의 prepareDtatement()메소드로부터 PreparedStatement를 얻음
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//값지정	27코드 ?로 값이 들어감
			pstmt.setString(1, "winter");
			pstmt.setString(2, "한겨울");
			pstmt.setString(3, "12345");
			pstmt.setInt(4, 25);
			pstmt.setString(5, "winter@mycompany.com" );
			
			//값 지정후 executeUpdate() 메소드를 호출하면 SQL문이 실행되면서 users 테이블에 1개의 행이 저장
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			//close()메소드를 호출하면 PreparedStatement가 사용했던 메모리 해제
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
package db_study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.ArrayList;

import db.DBConnectionMgr;
import repository.user.User;

public class UserDao { //Dao: data access object
	private final DBConnectionMgr pool;
	
	public UserDao(DBConnectionMgr pool) {
		this.pool = pool;
	}
	
	public User getUserByUsername(String username) {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		User user = null;
		
		try {
			con =pool.getConnection();
			sql = "select * from user_mst where username = ?"; // and password = ?
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, username); //첫번째 물음표에 username을 넣음
			//pstmt.setString(2, password); //두번째 물음표
			rs= pstmt.executeQuery();
			
			rs.next();
			
			try { //해당 username이 없을때
			user = User.builder()
					.user_code(rs.getInt(1)) 
					.username(rs.getString(2))
					.password(rs.getString(3))
					.name(rs.getString(4))
					.email(rs.getString(5))
					.create_date(rs.getTimestamp(6).toLocalDateTime())
					.update_date(rs.getTimestamp(7).toLocalDateTime())
					.build();
			}catch (SQLDataException e) {
				System.out.println("해당 아이디로 조회한 데이터가 없습니다.");
				//user = null;
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return user;
	}
	
	public ArrayList<User> getUserAll() {
		String sql = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //결과를 담을수있음
		
		ArrayList<User> userList = new ArrayList<User>();
		
		try {
			con = pool.getConnection(); //db연결
			sql = "select * from user_mst";//쿼리문(select)
			pstmt = con.prepareStatement(sql); //쿼리작성
			rs = pstmt.executeQuery(); //쿼리실행 : executeQuery()
			
			
			while(rs.next()) { //next : 다음이 있으면 /결과가 여러줄이기 때문에 while문 사용
				User user = User.builder()
							.user_code(rs.getInt(1)) //colum의 번호순서 (1번부터시작)
							.username(rs.getString(2))
							.password(rs.getString(3))
							.name(rs.getString(4))
							.email(rs.getString(5))
							.create_date(rs.getTimestamp(6).toLocalDateTime())
							.update_date(rs.getTimestamp(7).toLocalDateTime())
							.build();
				userList.add(user);
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return userList;
	}
}

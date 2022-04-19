package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DBConnectionMgr;
import repository.file.FileEntity;

public class FileDaoImpl implements FileDao {
	private DBConnectionMgr pool;
	
	public FileDaoImpl(DBConnectionMgr pool) {
		this.pool = pool;
	}
	
	@Override
	public int uploadFile(ArrayList<String> fileList) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			con=pool.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into file_mst values");
			for(String fileName : fileList) {
				sql.append("(0,\'");
				sql.append(fileName);
				sql.append("\',now(),now()),");
			}
			sql.delete(sql.length() -1, sql.length()); //끝에 있는 , 지워줌
			pstmt = con.prepareStatement(sql.toString());
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	@Override
	public ArrayList<FileEntity> getImgListALL() {
		String sql = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FileEntity> imgList = new ArrayList<FileEntity>();
		
		try {
			con = pool.getConnection();
			sql = "select * from file_mst";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FileEntity file = FileEntity.builder()
									.file_code(rs.getInt(1))
									.file_name(rs.getString(2))
									.create_date(rs.getTimestamp(3).toLocalDateTime())
									.update_date(rs.getTimestamp(4).toLocalDateTime())
									.build();
				imgList.add(file);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return imgList;
	}
}

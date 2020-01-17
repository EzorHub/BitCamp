package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;
import vo.BoardVo;

public class BoardDao {
	
	public int insertBoard(BoardVo b) {
		int re = -1;
		try {
			String sql = "insert into board values((select nvl(max(no), 0)+1 from board),?,?,?,?,0,sysdate,?,?, 0,0,0)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getPwd());
			pstmt.setString(4, b.getContent());
			pstmt.setString(5, b.getIp());
			pstmt.setString(6, b.getFname());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return re;
	}
	
	public BoardVo getboard(int no) {
		BoardVo vo = null;
		try {
			String sql = "select * from board where no= ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), 
						rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12));
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public ArrayList<BoardVo> listAll(){
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "select * from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), 
						rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;
import vo.BoardVo;

public class BoardDao {
	public ArrayList<BoardVo> listAll() {
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		String sql = "select * from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7)));
			}

			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public String listDetail(int no) {
		String content = "";
		String sql = "select content from board where no = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				content = rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return content;
	}

	public BoardVo getBoard(int no) {
		BoardVo b = null;
		String sql = "select * from board where no = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				b = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getString(7));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return b;
	}

	public int insertBoard(BoardVo v) {
		int re = -1;
		String sql = "insert into board values(seq_board.nextval,?,?,?,?,0,sysdate)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, v.getTitle());
			pstmt.setString(2, v.getWriter());
			pstmt.setString(3, v.getPwd());
			pstmt.setString(4, v.getContent());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(conn, pstmt);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	public int updateBoard(String title, String content, int no) {
		int re = -1;
		String sql = "update board set title=?, content=? where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return re;
	}

	public int deleteBoard(int no, String pwd) {
		int re = -1;
		String sql = "delete board where no =? and pwd = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, pwd);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return re;
	}
}

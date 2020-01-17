package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import db.ConnectionProvider;
import vo.GoodsVo;

public class GoodsDao {
	public ArrayList<GoodsVo> listAll() {
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		String sql = "select * from goods order by no desc";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				list.add(new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
			}

			ConnectionProvider.close(conn, stmt, rs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;
	}

	public GoodsVo getGoods(int no) {
		GoodsVo g = null;
		String sql = "select * from goods where no = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				g = new GoodsVo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return g;
	}

	public int insertGoods(GoodsVo g) {
		int re = -1;
		String sql = "insert into goods values((select nvl(max(no),0)+1 from goods),?,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setInt(3, g.getQty());
			pstmt.setString(4, g.getFname());

			re = pstmt.executeUpdate();

			ConnectionProvider.close(conn, pstmt);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return re;
	}

	public int updateGoods(String name, int price, int qty, String fname, int no) {
		int re = -1;
		String sql = "update goods set name=?, price=?, qty=?, fname=? where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setInt(3, qty);
			pstmt.setString(4, fname);
			pstmt.setInt(5, no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return re;
	}

	public int deleteGoods(int no) {
		int re = -1;
		String sql = "delete goods where no =?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);

			re = pstmt.executeUpdate();

			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return re;
	}
}
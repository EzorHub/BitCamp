package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import db.ConnectionProvider;
import vo.DeptVo;

public class DeptDao {
	
	public ArrayList<DeptVo> listAll(){
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		try {
			String sql = "select * from dept";
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			ConnectionProvider.close(conn, stmt, rs);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert(DeptVo d) {
		// TODO Auto-generated method stub
		int re = -1;
		String sql = "insert into dept values(?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDno());			
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getDloc());
			
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public DeptVo getDept(int no) {
		// TODO Auto-generated method stub
		DeptVo d = null;
		String sql = "select * from dept where dno = ?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
//				new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3)); "d = " ÀúÀå¾ÈÇØÁà¼­ ¾È³ª¿È
		
				d = new DeptVo(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(d);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return d;
	}

}

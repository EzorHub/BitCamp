package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.ConnectionProvider;
import vo.MemberVo;

public class MemberDao {
	
	public int insertMember(MemberVo m) {
		
		int re = -1;
		String sql = "insert into member values(select nvl(max(no),0+1),?,?,?,?,?,?,?,?,?,?";
		
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getTel());
			pstmt.setString(6, m.getAddr());
			pstmt.setString(7, m.getHobby());
			pstmt.setString(8, m.getJob());
			pstmt.setString(9, m.getGender());
			pstmt.setString(10, m.getImg());
			
			return m;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

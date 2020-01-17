package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import db.ConnectionProvider;

public class BankDao {

	public boolean transfer(int from, int to, int amount) {
		boolean re = false;
		try {
			Connection conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			String sql_minus = "update bank set balance=balance-? where no=?";
			String sql_add = "update bank set balance=balance+? where no=?";

			PreparedStatement pstmt_minus = conn.prepareStatement(sql_minus);
			PreparedStatement pstmt_add = conn.prepareStatement(sql_add);

			pstmt_minus.setInt(1, amount);
			pstmt_minus.setInt(2, from);

			pstmt_add.setInt(1, amount);
			pstmt_add.setInt(2, to);

			int re_minus = pstmt_minus.executeUpdate();
			int re_add = pstmt_add.executeUpdate();

			if (re_minus > 0 && re_add > 0) {
				conn.commit();
				re = true;
			} else {
				conn.rollback();
			}

			if (pstmt_add != null) {
				pstmt_add.close();
			}

			if (pstmt_minus != null) {
				pstmt_minus.close();
			}

			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return re;
	}
}

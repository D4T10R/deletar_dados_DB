package principal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = DB.getConnection();
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department " +
					"WHERE " +
					"Id = ?");
		
			st.setInt(1, 2);
			
			int linhasAfetadas = st.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeConnection();
		}
		
		

	}

}

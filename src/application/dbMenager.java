package application;

import java.sql.*;
import java.util.Properties;

public class dbMenager {

	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private SimpleQuery simpleQuery = new SimpleQuery();

	public void dbstart() {
		conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", "inf109708");
		connectionProps.put("password", "inf109708");
		try {
			conn = DriverManager
					.getConnection(
							"jdbc:oracle:thin:@//admlab2-main.cs.put.poznan.pl:1521/dblab01.cs.put.poznan.pl",
							connectionProps);
			System.out.println("Po��czono z baz� danych");
		} catch (SQLException ex) {
			System.out.println("Nie uda�o si� nawi�za� po��czenia");
			System.exit(-1);
		}
	}

	public void selectQuery(String query) throws SQLException {
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
	}

	public void updateQuery(String query) throws SQLException {
		int changes;
		stmt = conn.createStatement();
		changes = stmt.executeUpdate(query);
		System.out.println(changes);
		conn.commit();
		stmt.close();
	}
	
	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public SimpleQuery getSimpleQuery() {
		return simpleQuery;
	}
	
	public void writeItToMe() {
		try {
			while (rs.next()) {
				System.out.println(rs.getString(2) + " " + rs.getString(3)
						+ " " + rs.getString(6));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}

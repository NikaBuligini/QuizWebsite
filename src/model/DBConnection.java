package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * imisatvis rom am nawilma imushaos sachiroa MyDBInfo zustad iseti
 * rogoric mesame davalebashi gvqonda.
 */
public class DBConnection {
	
	static String account = MyDBInfo.MYSQL_USERNAME;
	static String password = MyDBInfo.MYSQL_PASSWORD;
	static String server = MyDBInfo.MYSQL_DATABASE_SERVER;
	static String database = MyDBInfo.MYSQL_DATABASE_NAME;
	
	static final String TABLE_NAME = "products";
	
	private Connection con;
	
	/**
	 * iqmndeba Connection obieqti gadacemuli cvladebistvis
	 */
	public DBConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?"
					+ "user=" + account + "&password=" + password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @return metodi abrunebs Connection tipis obieqts
	 */
	public Connection getConnection() {
		return con;
	}
	
	
	/**
	 * roca Connection sachiro agaraa is unda daixuros. amas ServletListenershi vaketeb
	 */
	public void close() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

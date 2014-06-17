package model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class SQLTest {

	@Test
	public void test() {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		
//		assertEquals(1, AccountManager.getIDByUsername(con, "nika"));
		
		db.close();
	}

}

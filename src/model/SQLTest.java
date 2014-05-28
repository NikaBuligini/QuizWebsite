package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLTest {

	@Test
	public void test() {
		DBConnection db = new DBConnection();
		
//		SQLManager.addCookie(db.getConnection(), "l;egw;e", 1);
		
		assertEquals(1, SQLManager.getUserIDByCookie(db.getConnection(), "afasgf15"));
		assertEquals(2, SQLManager.getUserIDByUsername(db.getConnection(), "patrick"));
		assertEquals(1, SQLManager.getUserIDByEMail(db.getConnection(), "nbuli11@gmail.com"));
		
		SQLManager.updateCookie(db.getConnection(), "nikaupdatedthis", 3);
		
//		SQLManager.addCookie(db.getConnection(), "97654321", 4);
		
//		assertEquals(0, SQLManager.getUserByCookie(db.getConnection(), "1234"));
		
		
	}

}

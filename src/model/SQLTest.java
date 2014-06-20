package model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class SQLTest {

	@Test
	public void test() {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();
		
		boolean bla = FriendManager.areFriends(con, 2, 1);
		
		if (bla)
		
		db.close();
	}

}

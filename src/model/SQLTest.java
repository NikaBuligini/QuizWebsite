package model;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

public class SQLTest {

	@Test
	public void test() {
		DBConnection db = new DBConnection();
		Connection con = db.getConnection();

		AccountManager.search(con, "gode go");
//		AchievementManager.addFriendsAchievement(con, 1);
		Quiz qu = new Quiz("saxeli", "descr", true, false, true, 1, 1);
		QuizManager.insert(qu, con);
		
		db.close();
	}

}

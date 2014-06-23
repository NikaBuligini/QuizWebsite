package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Manager {

	private static final String ALL = "*";

	static final int FAILED = 0;
	static final int SUCCESS = 1;
	static final int ZERO_RESULT = 0;

	/**
	 * mashin unda gamoidzaxos es metodi roca select-is shedegi vicit rom
	 * aucileblad 1 cvladi iqneba
	 * 
	 * @param con
	 *            Connection
	 * @param table
	 *            cxrilis saxeli bazashi
	 * @param column
	 *            svetis saxeli, romlelsac vwert pirobashi
	 * @param value
	 *            column svetis mnishvneloba (isev pirobistvis)
	 * @param needed_Col
	 *            im svetis saxeli, romlis mnishvnelobac unda daabrunos
	 * @return abrunebs int-s gadacemuli saxelebistvis
	 */
	protected static int getSingleInt(Connection con, String table,
			String column, Object value, String needed_Col) {
		if (!(value instanceof Integer) && !(value instanceof String))
			return ZERO_RESULT;

		String SQLQuery = buildSelect(ALL, table, column, value);
		return getInt(con, SQLQuery, needed_Col);
	}

	/**
	 * mashin unda gamoidzaxos es metodi roca select-is shedegi vicit rom
	 * aucileblad 1 cvladi iqneba
	 * 
	 * @param con
	 *            Connection
	 * @param table
	 *            cxrilis saxeli bazashi
	 * @param column
	 *            svetis saxeli, romlelsac vwert pirobashi
	 * @param value
	 *            column svetis mnishvneloba (isev pirobistvis)
	 * @param needed_Col
	 *            im svetis saxeli, romlis mnishvnelobac unda daabrunos
	 * @return abrunebs String-s gadacemuli saxelebistvis
	 */
	protected static String getSingleString(Connection con, String table,
			String column, Object value, String needed_Col) {
		if (!(value instanceof Integer) && !(value instanceof String))
			return null;

		String SQLQuery = buildSelect(ALL, table, column, value);
		return getString(con, SQLQuery, needed_Col);
	}

	protected static ArrayList<Object> getSingleRow(Connection con,
			String table, String column, Object value, int rowSize) {
		if (!(value instanceof Integer) && !(value instanceof String))
			return null;

		String SQLQuery = buildSelect(ALL, table, column, value);

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		ArrayList<Object> row = new ArrayList<Object>();
		try {
			while (rs.next()) {
				for (int i = 1; i <= rowSize; i++)
					row.add(rs.getObject(i));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return row;
	}

	protected static ArrayList<ArrayList<Object>> getMultipleRows(
			Connection con, String table, String column, Object value,
			int rowSize) {
		if (!(value instanceof Integer) && !(value instanceof String))
			return null;

		String SQLQuery = buildSelect(ALL, table, column, value);

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		try {
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for (int i = 1; i <= rowSize; i++) {
					row.add(rs.getObject(i));
				}
				list.add(row);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return list;
	}

	protected static ArrayList<ArrayList<Object>> getAllRows(Connection con,
			String table, int rowSize) {
		String SQLQuery = "SELECT * FROM " + table;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		ArrayList<ArrayList<Object>> list = new ArrayList<ArrayList<Object>>();
		try {
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for (int i = 1; i <= rowSize; i++) {
					row.add(rs.getObject(i));
				}
				list.add(row);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return list;
	}

	protected static int insert(Connection con, String table, String columns,
			Object[] values) {
		if (values.length == 0)
			return FAILED;

		String SQLQuery = buildInsert(table, columns, values);

		executeUpdate(con, SQLQuery);

		return SUCCESS;
	}

	protected static void update(Connection con, String table,
			String whatUpdate, Object value, String whereCol, Object equals) {
		String SQLQuery = buildUpdate(table, whatUpdate, value, whereCol,
				equals);
		if (SQLQuery != null)
			executeUpdate(con, SQLQuery);
	}

	protected static void delete(Connection con, String table, String column,
			Object value) {
		String SQLQuery = buildDelete(table, column, value);
		if (SQLQuery != null)
			executeUpdate(con, SQLQuery);
	}

	private static void executeUpdate(Connection con, String SQLQuery) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(SQLQuery);
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private static int getInt(Connection con, String SQLQuery, String needed_Col) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		int result = 0;
		try {
			while (rs.next())
				result = rs.getInt(needed_Col);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	private static String getString(Connection con, String SQLQuery,
			String needed_Col) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		String result = null;
		try {
			while (rs.next())
				result = rs.getString(needed_Col);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return result;
	}

	private static String buildSelect(String what, String table, String column,
			Object value) {
		String val = "";
		if (value instanceof Integer)
			val += value;
		else if (value instanceof String)
			val += "'" + (String) value + "'";
		else
			return null;

		return "SELECT " + what + " FROM " + table + " WHERE " + column + "="
				+ val;

	}

	private static String buildInsert(String table, String columns,
			Object[] values) {
		String query = "INSERT INTO " + table + " " + columns + " VALUES (";

		for (int i = 0; i < values.length; i++) {
			Object obj = values[i];
			if (obj instanceof Integer)
				query += (Integer) obj;
			else if (obj instanceof String)
				query += "'" + (String) obj + "'";
			else
				return null;

			if (i == values.length - 1)
				query += ")";
			else
				query += ", ";
		}

		return query;
	}

	private static String buildUpdate(String table, String update_col,
			Object value, String col, Object equals) {
		String query = "UPDATE " + table + " SET " + update_col + "=";

		if (value instanceof Integer)
			query += value;
		else if (value instanceof String)
			query += "'" + (String) value + "'";
		else
			return null;

		query += " WHERE " + col + "=";

		if (equals instanceof Integer)
			query += equals;
		else if (equals instanceof String)
			query += "'" + (String) equals + "'";
		else
			return null;

		return query;
	}

	private static String buildDelete(String table, String column, Object value) {
		String val = "";
		if (value instanceof Integer)
			val += value;
		else if (value instanceof String)
			val += "'" + value + "'";
		else
			return null;

		return "DELETE FROM " + table + " WHERE " + column + "=" + val;
	}

}

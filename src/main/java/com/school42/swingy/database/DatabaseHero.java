package com.school42.swingy.database;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import com.school42.swingy.hero.*;

public class DatabaseHero {

	protected Connection _conn = null;
	protected static File file = new File("swingy.db");
	protected Statement _stmt = null;
	protected PreparedStatement _pstmt = null;
	protected ResultSet _rs = null;

	public DatabaseHero() {
		String sql = Utils.createTableHeros();

		try {
			file.createNewFile();
			_connect();
			_stmt = _conn.createStatement();
			_stmt.execute(sql);
		} catch (IOException e) { /* ignored */ }
		catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
		finally {
			_close();
		}
	}

	protected void _connect() {
		String url = "jdbc:sqlite:" + file.getAbsoluteFile().toString();

		try {
        	_conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
	}

	protected void _close() {
		if (_stmt != null)
		{
			try {
				_stmt.close();
			} catch (SQLException e) {/* ignored */}
		}
		if (_pstmt != null) {
			try {
				_pstmt.close();
			} catch (SQLException e) {/* ignored */}
		}
	}

	public void insert(Hero hero) {
		String sql = "INSERT INTO heros(heroname, heroclass, herolvl, heroxp) VALUES(?,?,?,?)";

		try {
			_connect();
			_pstmt = _conn.prepareStatement(sql);
			_pstmt.setString(1, hero.getName());
			_pstmt.setString(2, hero.getClassName());
			_pstmt.setInt(3, hero.getLevel());
			_pstmt.setDouble(4, hero.getXp());
			_pstmt.executeUpdate();
			hero.setId(_pstmt.getGeneratedKeys().getInt(1));
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		} finally {
			_close();
		}
	}

	public void update(Hero hero) {
		String sql = "UPDATE heros ";
		sql += "SET herolvl = ?, ";
		sql += "heroxp = ?, ";
		sql += "weapontype = ?, ";
		sql += "weaponvalue, ";
		sql += "armortype = ?, ";
		sql += "armorvalue = ?, ";
		sql += "helmtype = ?, ";
		sql += "helmvalue = ? ";
		sql += "WHERE id = ?";

		try {
			_pstmt = _conn.prepareStatement(sql);
			_pstmt.setInt(1, hero.getLevel());
			_pstmt.setDouble(2, hero.getXp());
			if (hero.getWeapon() != null) {
				_pstmt.setString(3, hero.getWeapon().getName());
				_pstmt.setDouble(4, hero.getWeapon().getValue());
			}
			if (hero.getArmor() != null) {
				_pstmt.setString(5, hero.getArmor().getName());
				_pstmt.setDouble(6, hero.getArmor().getValue());
			}
			if (hero.getHelm() != null) {
				_pstmt.setString(7, hero.getHelm().getName());
				_pstmt.setDouble(8, hero.getHelm().getValue());
			}
			_pstmt.setInt(9, hero.getId());
			_pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		} finally {
			_close();
		}
	}
	
}

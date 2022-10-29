package com.school42.swingy.database;

import java.sql.SQLException;
import java.util.Vector;

import com.school42.swingy.artefac.ArtefacFactory;
import com.school42.swingy.hero.Hero;
import com.school42.swingy.hero.HeroFactory;

public class Utils {
	
	private static String createSqlType(String name, String type, Boolean isNull, boolean last) {
		String sqlType = name + " " + type;

		if (!isNull)
			sqlType += " NOT NULL";
		if (!last)
			sqlType += ",";
		sqlType += "\n";
		return (sqlType);
	}

	public static String createTableHeros() {
		String sql = "CREATE TABLE IF NOT EXISTS heros (\n";
		sql += "id integer PRIMARY KEY,";
		sql += createSqlType("heroname", "TEXT", false, false);
		sql += createSqlType("heroclass", "TEXT", false, false);
		sql += createSqlType("herolvl", "INT", false, false);
		sql += createSqlType("heroxp", "DOUBLE", false, false);
		sql += createSqlType("weapontype", "TEXT", true, false);
		sql += createSqlType("weaponvalue", "DOUBLE", true, false);
		sql += createSqlType("armortype", "TEXT", true, false);
		sql += createSqlType("armorvalue", "DOUBLE", true, false);
		sql += createSqlType("helmtype", "TEXT", true, false);
		sql += createSqlType("helmvalue", "DOUBLE", true, true);
		sql += ");";
		return (sql);
	}

	public static void addAllHero(final Vector<Hero> heros) {
		class Read extends DatabaseHero {
			public Read() { super(); }

			public void readAllHero() {
				String sql = "SELECT id, heroname, heroclass, herolvl, heroxp, weapontype, weaponvalue, armortype, armorvalue, helmtype, helmvalue FROM heros";

				try {
					_connect();
             		_stmt  = _conn.createStatement();
            		_rs = _stmt.executeQuery(sql);
					while (_rs.next()) {
						int id = _rs.getInt("id");
						String heroName = _rs.getString("heroname");
						String heroClass = _rs.getString("heroclass");
						int heroLvl = _rs.getInt("herolvl");
						double heroxp = _rs.getDouble("heroxp");
						String weaponType = _rs.getString("weapontype");
						double weaponValue = _rs.getDouble("weaponvalue");
						String armorType = _rs.getString("armortype");
						double armorValue = _rs.getDouble("armorvalue");
						String helmType = _rs.getString("helmtype");
						double helmValue = _rs.getDouble("helmvalue");
						Hero hero = HeroFactory.newHero(heroClass, heroName, heroLvl, heroxp);
						if (hero == null) {
							throw new SQLException("Hero class not found");
						}
						if (weaponType != null)
							hero.setArtefac(ArtefacFactory.newArtefac(weaponType, weaponValue), true);
						if (armorType != null)
							hero.setArtefac(ArtefacFactory.newArtefac(armorType, armorValue), true);
						if (helmType != null)
							hero.setArtefac(ArtefacFactory.newArtefac(helmType, helmValue), true);
						hero.setId(id);
						heros.add(hero);
					}
				} catch (SQLException e) {
					System.out.println("Error: " + e.getMessage());
					System.exit(1);
				} finally {
					_close();
				}
			}
		}

		new Read().readAllHero();
	}

}

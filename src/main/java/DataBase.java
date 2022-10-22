package main.java;

import java.io.File;
import java.io.IOException;
import java.sql.*;

import main.java.artefac.ArtefacsFactory;
import main.java.hero.Hero;
import main.java.hero.HeroFactory;

public class DataBase {

	static private Connection _conn; 

	private void connect(String dbFile) throws SQLException {
		String url = "jdbc:sqlite:" + dbFile;
        _conn = DriverManager.getConnection(url);
	}

	private String createSqlType(String name, String type, Boolean isNull, boolean last) {
		String sqlType = new String();

		sqlType += name + " " + type;
		if (!isNull)
			sqlType += " NOT NULL";
		if (!last)
			sqlType += ",";
		sqlType += "\n";
		return (sqlType);
	}

	private String createTableSwingy() {
		String sql = new String();

		sql += "CREATE TABLE IF NOT EXISTS heros (\n";
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

	public int insertHero(String heroName, String heroClass, int herolvl, double heroXp)
	{
		String sql = "INSERT INTO heros(heroname, heroclass, herolvl, heroxp) VALUES(?,?,?,?)";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setString(1, heroName);
			pstmt.setString(2, heroClass);
			pstmt.setInt(3, herolvl);
			pstmt.setDouble(4, heroXp);
			pstmt.executeUpdate();
			return (pstmt.getGeneratedKeys().getInt(1));
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
		return (0);
	}

	public void updateHeroLevel(int id, int herolvl) {
        String sql = "UPDATE heros SET herolvl = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setInt(1, herolvl);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
    }

	public void updateHeroXp(int id, double xp) {
        String sql = "UPDATE heros SET heroxp = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setDouble(1, xp);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
    }

	public void updateHeroWeapon(int id, String weaponType, double weaponValue) {
        String sql = "UPDATE heros SET weapontype = ?, weaponvalue = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setString(1, weaponType);
			pstmt.setDouble(2, weaponValue);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
    }

	public void updateHeroArmor(int id, String armorType, double armorValue) {
        String sql = "UPDATE heros SET armortype = ?, armorvalue = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setString(1, armorType);
			pstmt.setDouble(2, armorValue);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
    }

	public void updateHeroHelm(int id, String helmType, double helmValue) {
        String sql = "UPDATE heros SET helmtype = ?, helmvalue = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = _conn.prepareStatement(sql);
			pstmt.setString(1, helmType);
			pstmt.setDouble(2, helmValue);
			pstmt.setInt(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
		}
    }

	public void readAllHero() {
        String sql = "SELECT id, heroname, heroclass, herolvl, heroxp, weapontype, weaponvalue, armortype, armorvalue, helmtype, helmvalue FROM heros";
        
        try {
            Statement stmt  = _conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
				String heroName = rs.getString("heroname");
				String heroClass = rs.getString("heroclass");
				int heroLvl = rs.getInt("herolvl");
				double heroXp = rs.getDouble("heroxp");
				String weaponType = rs.getString("weapontype");
				double weaponvalue = rs.getDouble("weaponvalue");
				String armorType = rs.getString("armortype");
				double armorValue = rs.getDouble("armorvalue");
				String helmType = rs.getString("helmtype");
				double helmValue = rs.getDouble("helmvalue");

				Hero hero = HeroFactory.newHero(heroClass, heroName, heroLvl, heroXp);
				hero.setId(id);
				if (weaponType != null)
					hero.setWeapon(ArtefacsFactory.newArtefacs(weaponType, weaponvalue));
				if (armorType != null)
					hero.setArmor(ArtefacsFactory.newArtefacs(armorType, armorValue));
				if (helmType != null)
					hero.setHelm(ArtefacsFactory.newArtefacs(helmType, helmValue));
				Game.heros.add(hero);
            }
        } catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.exit(1);
        }
    }

	public DataBase() throws IOException, SQLException {
		File file = new File("swingy.db");
		file.createNewFile();
		connect(file.getAbsoluteFile().toString());
		String sql = createTableSwingy();
		Statement stmt = _conn.createStatement();
		stmt.execute(sql);
	}
}

package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Weapon;

public class WeaponManagerDBImplementation implements WeaponManager {

	// Variables
	private Connection con;
	private PreparedStatement stmt;

	// SQL operations
	final String INSERTweapon = "INSERT INTO weapon(weaponName, weaponDamage, weaponType, weaponSubType, weaponIsActive) VALUES( ?, ?, ?, ?, ?, ?)";
	final String LISTweapon = "SELECT * FROM weapon WHERE weaponName = ?";
	final String LISTweapons = "SELECT * FROM weapon";
	final String LISTweaponsPrimary = "SELECT * FROM weapon where weaponType = 'Primary'";
	final String LISTweaponsSidearm = "SELECT * FROM weapon where weaponType = 'Secondary'";
	final String UPDATEweapon = "UPDATE weapon SET weaponDamage= ? , weaponType= ? , weaponSubType= ? , weaponIsActive= ? WHERE weaponName = ?";
	final String DELETEweapon = "DELETE FROM weapon WHERE weaponName = ?";

	// Method to open the connection
	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/valorant_protocol?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");

		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la BD");
		}
	}

	// Method to close the connection
	private void closeConnection() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

	@Override
	public void addWeapon(Weapon weapon) {
		// TODO Auto-generated method stub

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(INSERTweapon);

			stmt.setString(1, weapon.getWeaponName());
			stmt.setInt(2, weapon.getWeaponDamage());
			stmt.setString(3, weapon.getWeaponType());
			stmt.setString(4, weapon.getWeaponSubType());
<<<<<<< HEAD
			stmt.setBoolean(5, true);
			stmt.executeUpdate();
			stmt.close();	

=======
			stmt.setBoolean(5, false);
			
			stmt.executeUpdate();
			stmt.close();
>>>>>>> devMikel
		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close the connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public Weapon getWeaponByName(String name) {
		// Variables
		ResultSet rs = null;
		Weapon weapon = null;

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweapon);

			stmt.setString(1, name);
			rs = stmt.executeQuery();
			stmt.close();	


			if (rs.next()) {
				weapon = new Weapon(name, rs.getInt("WeaponDamage"), rs.getString("weaponType"),
						rs.getString("weaponSubType"), rs.getBoolean("weaponIsActive"));
			} else
				weapon = null;

		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			// Cerramos ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapon;
	}

	@Override
	public boolean modifyWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		boolean changes = false;

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(UPDATEweapon);

			stmt.setInt(1, weapon.getWeaponDamage());
			stmt.setString(2, weapon.getWeaponType());
			stmt.setString(3, weapon.getWeaponSubType());
			stmt.setBoolean(4, weapon.isWeaponIsActive());
			stmt.setString(5, weapon.getWeaponName());

			if (stmt.executeUpdate() == 1) {
				changes = true;
				stmt.close();
				}
		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close Connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		return changes;
	}

	@Override
	public void deleteWeapon(String name) {
		// TODO Auto-generated method stub

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(DELETEweapon);
			stmt.setString(1, name);
			stmt.executeUpdate();
			stmt.close();	

		} catch (SQLException e1) {
			System.out.println("Error en la modificación SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close Connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<Weapon> getAllWeapon() {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweapons);

			rs = stmt.executeQuery();
			stmt.close();	


			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponIsActive(false);
				weapons.add(weapon);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Close ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				// Close Connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

	@Override
	public List<Weapon> getAllSidearms() {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon = null;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweaponsSidearm);

			rs = stmt.executeQuery();
			stmt.close();	


			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapons.add(weapon);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Close ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				// Close connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

	@Override
	public List<Weapon> getAllPrimary() {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		this.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweaponsPrimary);

			rs = stmt.executeQuery();
			stmt.close();	


			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponIsActive(false);
				weapons.add(weapon);
			}

		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		} finally {
			// Close ResultSet
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					System.out.println("Error en cierre del ResultSet");
				}
			}
			try {
				// Close connection
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

}

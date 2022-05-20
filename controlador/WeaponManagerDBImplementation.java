package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ExceptionManager;
import model.Weapon;

public class WeaponManagerDBImplementation implements WeaponManager {

	// Variables
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	// SQL operations
	final String INSERTweapon = "INSERT INTO weapon(weaponName, weaponDamage, weaponType, weaponSubType, weaponIsActive) VALUES( ?, ?, ?, ?, ?)";
	final String LISTweapon = "SELECT * FROM weapon WHERE weaponName = ?";
	final String LISTweapons = "SELECT * FROM weapon";
	final String LISTweaponsPrimary = "SELECT * FROM weapon where weaponType = 'Primary'";
	final String LISTweaponsSidearm = "SELECT * FROM weapon where weaponType = 'Secondary'";
	final String UPDATEweapon = "UPDATE weapon SET weaponDamage= ? , weaponType= ? , weaponSubType= ? , weaponIsActive= ? WHERE weaponName = ?";
	final String DELETEweapon = "UPDATE weapon set weaponIsActive=false WHERE weaponName = ?";
	final String ACTIVATEweapon = "UPDATE weapon set weaponIsActive=true WHERE weaponName = ?";

	@Override
	/**
	 * Insertar un arma
	 * 
	 * @param weapon arma a ingresar
	 * @throws ExceptionManager ExceptionManager
	 */
	public void addWeapon(Weapon weapon) throws ExceptionManager {
		// TODO Auto-generated method stub

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(INSERTweapon);

			stmt.setString(1, weapon.getWeaponName());
			stmt.setInt(2, weapon.getWeaponDamage());
			stmt.setString(3, weapon.getWeaponType());
			stmt.setString(4, weapon.getWeaponSubType());
			stmt.setBoolean(5, true);
			stmt.executeUpdate();

			stmt.close();

		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close the connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	/**
	 * buscar un arma por su nombre
	 * 
	 * @param name nombre del arma a buscar
	 * @throws ExceptionManager ExceptionManager
	 */
	public Weapon getWeaponByName(String name) throws ExceptionManager {
		// Variables
		ResultSet rs = null;
		Weapon weapon = null;

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweapon);

			stmt.setString(1, name);
			rs = stmt.executeQuery();

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
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapon;
	}

	@Override
	/**
	 * modificar un arma
	 * 
	 * @param weapon arma a modificar
	 * @return changes boolean que te devuelve si se ha modificado o no
	 * @throws ExceptionManager ExceptionManager
	 */
	public boolean modifyWeapon(Weapon weapon) throws ExceptionManager {
		// TODO Auto-generated method stub
		boolean changes = false;

		// Open the connection
		con = conection.openConnection();

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
			System.out.println("Error en la modificacion SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close Connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
		return changes;
	}

	@Override
	/**
	 * Borrado del arma
	 * 
	 * @param name nombre del arma que se desea borrar
	 * @throws ExceptionManager ExceptionManager
	 */
	public void deleteWeapon(String name) throws ExceptionManager {
		// TODO Auto-generated method stub

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(DELETEweapon);
			stmt.setString(1, name);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e1) {
			System.out.println("Error en la modificacion SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close Connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	/**
	 * Listado de todas las armas
	 * 
	 * @return weapons Listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Weapon> getAllWeapon() throws ExceptionManager {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweapons);

			rs = stmt.executeQuery();

			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponIsActive(rs.getBoolean("weaponIsActive"));
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
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				// Close Connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

	@Override
	/**
	 * Listado de todas las armas secundarias
	 * 
	 * @return weapons Listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Weapon> getAllSidearms() throws ExceptionManager {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon = null;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweaponsSidearm);
			rs = stmt.executeQuery();

			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapon.setWeaponIsActive(rs.getBoolean("weaponIsActive"));
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
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				// Close connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

	@Override
	/**
	 * Listado de todas las armas primarias
	 * 
	 * @return weapons Listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Weapon> getAllPrimary() throws ExceptionManager {
		// TODO Auto-generated method stub

		// Variables
		ResultSet rs = null;
		Weapon weapon;
		List<Weapon> weapons = new ArrayList<>();

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(LISTweaponsPrimary);

			rs = stmt.executeQuery();

			while (rs.next()) {
				weapon = new Weapon();
				weapon.setWeaponName(rs.getString("weaponName"));
				weapon.setWeaponDamage(rs.getInt("weaponDamage"));
				weapon.setWeaponType(rs.getString("weaponType"));
				weapon.setWeaponSubType(rs.getString("weaponSubType"));
				weapon.setWeaponIsActive(rs.getBoolean("weaponIsActive"));
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
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				// Close connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapons;
	}

	@Override
	/**
	 * Activar un arma inavilitada
	 * 
	 * @param name nombre del arma inavilitada
	 * @throws ExceptionManager ExceptionManager
	 */
	public void activateWeapon(String name) throws ExceptionManager {
		// TODO Auto-generated method stub

		// Open the connection
		con = conection.openConnection();

		// Code
		try {
			stmt = con.prepareStatement(ACTIVATEweapon);
			stmt.setString(1, name);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e1) {
			System.out.println("Error en la modificacion SQL");
			e1.printStackTrace();
		} finally {
			try {
				// Close Connection
				conection.closeConnection(stmt, con);
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

}

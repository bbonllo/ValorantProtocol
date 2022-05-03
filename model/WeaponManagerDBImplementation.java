package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WeaponManagerDBImplementation implements WeaponManager{
	
	//Variables
	private Connection con;
	private PreparedStatement stmt;
	
	// SQL operations
	final String INSERTwep = "INSERT INTO weapon(weaponName, weaponDamage, weaponType, weaponSubType, weaponIsActive) VALUES( ?, ?, ?, ?, ?, ?)";
	final String LISTwep = "SELECT * FROM weapon WHERE weaponName = ?";
	final String LISTweps = "SELECT * FROM weapon";
	final String UPDATEwep = "UPDATE weapon SET weaponDamage= ? , weaponType= ? , weaponSubType= ? , weaponIsActive= ? WHERE weaponName = ?";
	final String DELETEwep = "DELETE FROM weapon WHERE weaponName = ?";
	
	// Method to open the connection
	private void openConnection(){
		 try {
		  String url ="jdbc:mysql://localhost:3306/valorant_protocol?serverTimezone=Europe/Madrid&useSSL=false";
		  con =  DriverManager.getConnection(url,"root" ,"abcd*1234");

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
			stmt = con.prepareStatement(INSERTwep);
			
			stmt.setString(1, weapon.getWeaponName());
			stmt.setInt(2, weapon.getWeaponDamage());
			stmt.setString(3, weapon.getWeaponType());
			stmt.setString(4, weapon.getWeaponSubType());
			stmt.setBoolean(5, false);
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
		Weapon wep = null;
		
		// Open the connection
		this.openConnection();
		
		// Code
		try {
			stmt = con.prepareStatement(LISTwep);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				wep = new Weapon(name, rs.getInt("WeaponDamage"), rs.getString("weaponType"), 
						rs.getString("weaponSubType"), rs.getBoolean("weaponIsActive"));
			}else 
				wep = null;
			
		}catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		}finally {
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
		return wep;
	}

	@Override
	public boolean modifyWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		boolean changes=false;
		
		
		// Open the connection
		this.openConnection();
		
		// Code
		try {
			stmt = con.prepareStatement(UPDATEwep);
			
			stmt.setString(1, weapon.getWeaponName());
			stmt.setInt(2, weapon.getWeaponDamage());
			stmt.setString(3, weapon.getWeaponType());
			stmt.setString(4, weapon.getWeaponSubType());
			stmt.setBoolean(5, weapon.isWeaponIsActive());
			
			if (stmt.executeUpdate()==1) 
				changes=true;
		}catch (SQLException e1) {
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
			stmt = con.prepareStatement(DELETEwep);
			stmt.setString(1, name);
			stmt.executeUpdate();
		}catch (SQLException e1) {
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
	public Set<Weapon> getAllWeapon() {
		// TODO Auto-generated method stub
		
		// Variables
		ResultSet rs = null;
		Weapon wep;
		Set<Weapon> weps = new HashSet<>();
		
		// Open the connection
		this.openConnection();
		
		// Code
		try {
			stmt = con.prepareStatement(LISTweps);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				wep = new Weapon();
				wep.setWeaponName(rs.getString("weaponName"));
				wep.setWeaponDamage(rs.getInt("weaponDamage"));
				wep.setWeaponType(rs.getString("weaponSubType"));
				wep.setWeaponSubType(rs.getString("weaponSubType"));
				wep.setWeaponIsActive(false);
				weps.add(wep);
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
		return weps;
	}


	@Override
	public Set<String> getAllSidearms() {
		// TODO Auto-generated method stub
		
		//Variables
		ResultSet rs = null;
		String wep;
		Set<String> weps = new HashSet<>();
		
		// Open the connection
		this.openConnection();
		
		// Code
		try {
			stmt = con.prepareStatement(LISTweps);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				wep = rs.getString("weaponName");
				weps.add(wep);
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
		return weps;
	}


	@Override
	public Set<Weapon> getAllPrimary() {
		// TODO Auto-generated method stub
		
		// Variables
		ResultSet rs = null;
		Weapon wep;
		Set<Weapon> weps = new HashSet<>();
		
		// Open the connection
		this.openConnection();
		
		// Code
		try {
			stmt = con.prepareStatement(LISTweps);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("weaponType").equalsIgnoreCase("primary")) {
					wep = new Weapon();
					wep.setWeaponName(rs.getString("weaponName"));
					wep.setWeaponDamage(rs.getInt("weaponDamage"));
					wep.setWeaponType(rs.getString("weaponSubType"));
					wep.setWeaponSubType(rs.getString("weaponSubType"));
					wep.setWeaponIsActive(false);
					weps.add(wep);
				}
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
		return weps;
	}

	
	
}

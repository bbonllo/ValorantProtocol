package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MissionManagerBDImplementation implements MissionManager{

	@Override
	public Mission getMissionByCod(String codM) {
		ResultSet rs = null;
		Weapon weapon = null;

		// Open the connection
		this.openConnection();

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
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en el cierre de la BD");
				e.printStackTrace();
			}
		}
		return weapon;
	}

	@Override
	public void registerMission(Mission wMisson) {
		
	}

	@Override
	public void modifyMisionDate(Mission modifyMission) {
		
	}

	@Override
	public void EndMission(String codM) {
		
	}

	@Override
	public List<Mission> getAllMissions() {
		return null;
	}

	@Override
	public List<Mission> getAllActiveMissions() {
		return null;
	}

	@Override
	public List<Mission> getAllFinishedMissions() {
		return null;
	}

}

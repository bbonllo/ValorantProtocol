package controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Mission;

public class MissionManagerBDImplementation implements MissionManager{

	@Override
	public Mission getMissionByCod(String codM) {
		ResultSet rs = null;
		Mission getMission  = null;

		// Open the connection

		// Code
		try {
			stmt = con.prepareStatement(LISTMission);

			stmt.setString(1, name);
			rs = stmt.executeQuery();

			if (rs.next()) {
			
			} else
			

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
		return getMission;
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

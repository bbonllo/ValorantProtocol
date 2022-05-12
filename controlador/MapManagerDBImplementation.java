package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.ExceptionManager;
import model.Map;

public class MapManagerDBImplementation implements MapManager {

	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();


	@Override
	public Map getMapByName(String mapName) {
		ResultSet rs = null;
		Map mapIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHMap = "SELECT * from map where mapName = ?";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();
			stmt.close();	

			if (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(mapName);
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				// mapIntro.setMapCoords(rs.getString("mapCoords"));
			} else
				mapIntro = null;

			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapIntro;
	}

	@Override
	public void makeStadisctic(String mapName) {
		
		String ATTACKMISSIONSTADISTIC = "select a.agentName from agent a, mission m, attack_mission am where agentCode in(select agentCode from agent_on_mission group by agentCode having count(agentCode)) and m.missionCode = am.AttackmissionCode and m.mapName = ? limit 3";
		String DEFENDMISSIONSTADISTIC = "select a.agentName from agent a, mission m, defend_mission df where agentCode in(select agentCode from agent_on_mission group by agentCode having count(agentCode)) and m.missionCode = df.defendmissionCode and m.mapName = ? limit 3";
		String ATTACKMISSIONWEAPONSTADISTIC = "select weaponName from agent_on_mission, agent a, mission m, attack_mission am where m.missionCode = am.attackmissionCode and m.mapName = ?  group by weaponName having count(weaponName) limit 3";
		String DEFENDMISSIONWEAPONSTADISTIC = "select weaponName from agent_on_mission, agent a, mission m, defend_mission df where m.missionCode = df.defendmissionCode and m.mapName = ?  group by weaponName having count(weaponName) limit 3";
	}

	@Override
	public Set<Map> getAllMaps() throws ExceptionManager {
		Set<Map> maps = new HashSet<>();
		ResultSet rs = null;
		Map mapIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHMap = "SELECT * from map";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			rs = stmt.executeQuery();
			stmt.close();	


			while (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(rs.getString("mapName"));
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				mapIntro.setMapCoords(rs.getString("mapCoords"));
				maps.add(mapIntro);
			}

			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recuperar todos los mapas";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maps;
	}

}

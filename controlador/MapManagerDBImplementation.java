package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ExceptionManager;
import model.Map;

public class MapManagerDBImplementation implements MapManager {

	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	@Override
	/**
	 * Busqueda de mapa con su nombre
	 * 
	 * @param mapName nombre del mapa a buscar
	 * @return mapIntro mapa encontrado
	 * @throws ExceptionManager ExceptionManager
	 */
	public Map getMapByName(String mapName) throws ExceptionManager {
		ResultSet rs = null;
		Map mapIntro = null;

		con = conection.openConnection();
		String SEARCHMap = "SELECT * from map where mapName = ?";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(mapName);
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				// mapIntro.setMapCoords(rs.getString("mapCoords"));
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String error = "Error al recoger informacion del mapa selecionado";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return mapIntro;
	}

	@Override
	/**
	 * Listado de todos los mapas
	 * 
	 * @return maps El listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Map> getAllMaps() throws ExceptionManager {
		List<Map> maps = new ArrayList<>();
		ResultSet rs = null;
		Map mapIntro = null;

		con = conection.openConnection();
		String SEARCHMap = "SELECT * from map";

		try {
			stmt = con.prepareStatement(SEARCHMap);
			rs = stmt.executeQuery();

			while (rs.next()) {
				mapIntro = new Map();
				mapIntro.setMapName(rs.getString("mapName"));
				mapIntro.setMapDesc(rs.getString("mapDesc"));
				maps.add(mapIntro);
			}
			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recuperar todos los mapas";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		}

		return maps;
	}

	@Override
	/**
	 * Listado de todos los agentes en misiones de ataque
	 * 
	 * @param mapName nombre del mapa de ataque a buscar
	 * @return nameAgents Listado del nombre de los agentes encontrados en misiones
	 *         en ese mapa
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<String> getAttackMissionAgents(String mapName) throws ExceptionManager {
		String ATTACKMISSIONSTADISTIC = "select distinct a.agentName from agent a, mission m, attack_mission am, agent_on_mission aom where a.agentCode in(select agentCode from agent_on_mission group by agentCode having count(agentCode)) and a.agentCode=aom.agentCode and m.missionCode = am.attackMissionCode and am.attackMissionCode = aom.missionCode and m.mapName = ? order by a.agentCode asc limit 3";
		ArrayList<String> nameAgents = new ArrayList<>();
		ResultSet rs = null;
		String nameAgent;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(ATTACKMISSIONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				nameAgent = rs.getString("agentName");
				nameAgents.add(nameAgent);
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "Error al reocoger la informacion sobre las msisiones de ataque";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return nameAgents;
	}

	@Override
	/**
	 * Listado de todos los agentes en misiones de defensa
	 * 
	 * @param mapName nombre del mapa de ataque a buscar
	 * @return nameAgents Listado del nombre de los agentes encontrados en misiones
	 *         en ese mapa
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<String> getDefendMissionAgents(String mapName) throws ExceptionManager {
		String DEFENDMISSIONSTADISTIC = "select distinct a.agentName from agent a, mission m, defend_mission am, agent_on_mission aom where a.agentCode in(select agentCode from agent_on_mission group by agentCode having count(agentCode)) and a.agentCode=aom.agentCode and m.missionCode = am.defendMissionCode and am.defendMissionCode = aom.missionCode and m.mapName = ? order by a.agentCode asc limit 3";
		ArrayList<String> nameAgents = new ArrayList<>();
		ResultSet rs = null;
		String nameAgent;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(DEFENDMISSIONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				nameAgent = rs.getString("agentName");
				nameAgents.add(nameAgent);
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String error = "Error al recoger la informacion sobre las misiones de defensa";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return nameAgents;
	}

	@Override
	/**
	 * Arma mas usada en mapas de misiones de ataque
	 * 
	 * @param mapName nombre del mapa en la que quiere buscar
	 * @return weaponName nombre del arma mas usada en ese mapa
	 * @throws ExceptionManager ExceptionManager
	 */
	public String getAttackMissionWeapon(String mapName) throws ExceptionManager {
		String ATTACKMISSIONWEAPONSTADISTIC = "select weaponName from agent_on_mission, agent a, mission m, attack_mission am where m.missionCode = am.attackmissionCode and m.mapName = ?  group by weaponName having count(weaponName) order by weaponName desc limit 1";
		ResultSet rs = null;
		String weaponName = null;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(ATTACKMISSIONWEAPONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				weaponName = rs.getString("weaponName");
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String error = "Error al recoger la informacion sobre las misiones de ataque";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return weaponName;
	}

	@Override
	/**
	 * Arma mas usada en mapas de misiones de defensa
	 * 
	 * @param mapName nombre del mapa en la que quiere buscar
	 * @return weaponName nombre del arma mas usada en ese mapa
	 * @throws ExceptionManager ExceptionManager
	 */
	public String getDefendMissionWeapon(String mapName) throws ExceptionManager {
		String DEFENDMISSIONWEAPONSTADISTIC = "select weaponName from agent_on_mission, agent a, mission m, defend_mission df where m.missionCode = df.defendmissionCode and m.mapName = ?  group by weaponName having count(weaponName) order by weaponName desc limit 1";
		ResultSet rs = null;
		String weaponName = null;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(DEFENDMISSIONWEAPONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				weaponName = rs.getString("weaponName");
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String error = "Error al recoger la informacion sobre las misiones de defensa";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return weaponName;
	}

	@Override
	/**
	 * Listado de los agentes mas usado en los mapas de misiones de ataque
	 * 
	 * @param mapName mapa a buscar
	 * @return codTop3Agents Listado de los 3 agentes mas usados con su porcentaje
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Integer> agentPercentageMapAttack(String mapName) throws ExceptionManager {
		String ATTACKMISSIONWEAPONSTADISTIC = "select count(m.mapName) 'MapMissionTimes' from mission m where m.mapName = ? and m.MissionCode in (select attackMissionCode from attack_mission) group by mapName limit 1";
		String TimesAgentOnAttackMissionMap = "SELECT distinct count(agM.agentCode) 'AgentMissionTimesOnMap', agM.agentCode from agent_on_mission agM, mission m, attack_mission aM, map mP where aM.attackMissionCode=m.missionCode and m.mapName=mP.mapName and m.missionCode=agM.missionCode and m.mapName= ? group by agM.agentCode order by agM.agentCode asc limit 3";
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<Integer> codTop3Agents = new ArrayList<>();
		int mapTimes = 0;
		float percentage = 0;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(ATTACKMISSIONWEAPONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				mapTimes = rs.getInt("MapMissionTimes");
			}

			if (mapTimes != 0) {
				stmt = con.prepareStatement(TimesAgentOnAttackMissionMap);
				stmt.setString(1, mapName);

				rs2 = stmt.executeQuery();

				while (rs2.next()) {
					percentage = rs2.getInt("AgentMissionTimesOnMap");
					percentage = (((percentage / 2) / mapTimes) * 100);
					codTop3Agents.add((int) percentage);
				}

				if (rs2 != null)
					rs2.close();
			}
			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "Error al generar la estadistica de ataque";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return codTop3Agents;
	}

	@Override
	/**
	 * Listado de los agentes mas usado en los mapas de misiones de defensa
	 * 
	 * @param mapName nombre del mapa a buscar
	 * @return codTop3Agents Listado de los 3 agentes mas usados con su porcentaje
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Integer> agentPercentageMapDefend(String mapName) throws ExceptionManager {
		String DEFENDMISSIONWEAPONSTADISTIC = "select count(m.mapName) 'MapMissionTimes' from mission m where m.mapName = ? and m.MissionCode in (select defendMissionCode from defend_mission) group by mapName limit 1";
		String TimesAgentOnDefendMissionMap = "SELECT distinct count(agM.agentCode) 'AgentMissionTimesOnMap', agM.agentCode from agent_on_mission agM, mission m, defend_mission aM, map mP where aM.defendMissionCode=m.missionCode and m.mapName=mP.mapName and m.missionCode=agM.missionCode and m.mapName= ? group by agM.agentCode order by agM.agentCode asc limit 3";
		ResultSet rs = null;
		ResultSet rs2 = null;
		List<Integer> codTop3Agents = new ArrayList<>();
		int mapTimes = 0;
		float percentage = 0;

		con = conection.openConnection();

		try {
			stmt = con.prepareStatement(DEFENDMISSIONWEAPONSTADISTIC);
			stmt.setString(1, mapName);

			rs = stmt.executeQuery();

			while (rs.next()) {
				mapTimes = rs.getInt("MapMissionTimes");
			}

			if (mapTimes != 0) {
				stmt = con.prepareStatement(TimesAgentOnDefendMissionMap);
				stmt.setString(1, mapName);

				rs2 = stmt.executeQuery();

				while (rs2.next()) {
					percentage = rs2.getInt("AgentMissionTimesOnMap");
					percentage = (((percentage / 2) / mapTimes) * 100);
					codTop3Agents.add((int) percentage);
				}

				if (rs2 != null)
					rs2.close();
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "Error al generar la estadistica de defensa";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return codTop3Agents;
	}

}

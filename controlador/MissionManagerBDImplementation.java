package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exceptions.ExceptionManager;
import model.AttackMission;
import model.DefendMission;
import model.Mission;

public class MissionManagerBDImplementation implements MissionManager {
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	@Override
	/**
	 * Buscar mision por su codigo 
	 * @param codM codigo de la mision a buscar
	 * @return getMission mission encontrada
	 * @throws ExceptionManager ExceptionManager
	 */
	public Mission getMissionByCod(int codM) throws ExceptionManager {
		ResultSet rs = null;
		Mission getMission = null;

		// Open the connection
		con = conection.openConnection();
		String LISTMission = "SELECT * FROM MISSION, defend_mission, attack_mission WHERE missionCode = ? ";

		// Code

		try {
			stmt = con.prepareStatement(LISTMission);
			stmt.setInt(1, codM);
			rs = stmt.executeQuery();

			if (rs.next()) {
				getMission = new AttackMission();
				getMission.setMissionCode(codM);
				((AttackMission) getMission).setstolenRadianite(rs.getInt("stolenRadianite"));

			} else {
				getMission = new DefendMission();
				getMission.setMissionCode(codM);
				((DefendMission) getMission).setdefendedRadianite(rs.getInt("defendedRadianite"));

			}

			stmt = con.prepareStatement(LISTMission);
			stmt.setInt(1, codM);
			rs = stmt.executeQuery();

			if (rs.next()) {
				getMission.setMapName(rs.getString("mapName"));
				getMission.setMissionFI((rs.getDate("missionSD").toLocalDate()));
				getMission.setMissionFF((rs.getDate("missionFD").toLocalDate()));
				getMission.setmissionFinished(rs.getBoolean("missionFinished"));
			} else {
				getMission = null;
			}

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

		return getMission;
	}

	@Override
	/**
	 * Registra mision enviandole una mision y caracter tipo
	 * @param vMisson mision a registrar 
	 * @param type tipo de mision que se desea registrar
	 * @return missionCode el codigo de la mision registrada
	 * @throws ExceptionManager ExceptionManager
	 */
	public int registerMission(Mission wMisson, String type) throws ExceptionManager {
		ResultSet rs = null;
		int missionCode = -1;

		String INSERTMission = "{CALL createMission(?,?,?,?)}";
		String getMissionCode = "select Max(missionCode) from mission";
		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			e1.printStackTrace();
		}

		try {
			stmt = con.prepareCall(INSERTMission);
			stmt.setString(1, wMisson.getMapName());
			stmt.setDate(2, Date.valueOf(wMisson.getMissionFI()));
			stmt.setDate(3, Date.valueOf(wMisson.getMissionFF()));
			stmt.setNString(4, type);
			stmt.execute();
			stmt = con.prepareStatement(getMissionCode);
			rs = stmt.executeQuery();

			if (rs.next()) {
				missionCode = rs.getInt("Max(missionCode)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conection.closeConnection(stmt, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return missionCode;
	}

	@Override
	/**
	 * Enviar agente a una mission con su codigo y sus respectivas armas
	 * @param codM codigo de la mision a la que desea mandar su agente 
	 * @param codA codigo del agente que desea mandar de mision
	 * @param primaryWeapon el arma principal del agente 
	 * @param secondaryWeapon el arma secundaria del agente
	 * @throws ExceptionManager ExceptionManager
	 */
	public void sendAgentToMission(int codM, int codA, String primaryWeapon, String secondaryWeapon)
			throws ExceptionManager {

		String SENDagentToMission = "{CALL sendAgentToMission(?,?,?,?)}";

		try {
			con = conection.openConnection();

		} catch (ExceptionManager e1) {
			e1.printStackTrace();
		}

		try {
			CallableStatement cst = con.prepareCall(SENDagentToMission);
			cst.setInt(1, codM);
			cst.setInt(2, codA);
			cst.setString(3, primaryWeapon);
			cst.setString(4, secondaryWeapon);
			cst.execute();
			cst.close();
		} catch (SQLException e) {

		}

		try {
			conection.closeConnection(stmt, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * Terminar mision
	 * @param codM codigo de la mision que desea terminar
	 * @param type tipo de la mision
	 * @throws ExceptionManager ExceptionManager
	 */
	public void endMission(int codM, String type) throws ExceptionManager {
		String ENDMission = "{CALL endMission(?,?)}";
		try {
			con = conection.openConnection();

		} catch (ExceptionManager e1) {
			e1.printStackTrace();
		}

		try {
			CallableStatement cst = con.prepareCall(ENDMission);
			cst.setInt(1, codM);
			cst.setString(2, type);
			cst.execute();
			cst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			conection.closeConnection(stmt, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * Listado de todas las misiones
	 * @return allMissions Listado
	 *  @throws ExceptionManager ExceptionManager
	 */
	public List<Mission> getAllMissions() throws ExceptionManager {
		List<Mission> allMissions = new ArrayList<>();
		ResultSet rs = null;
		ResultSet rs2 = null;
		Mission missionIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String SEARCHAttackMission = "SELECT distinct m.*, am.* from mission m, attack_mission am where missionCode = attackMissionCode";
		String SEARCHDeffendMission = "SELECT distinct m.*, dm.* from mission m, defend_mission dm where missionCode = defendMissionCode";

		try {
			stmt = con.prepareStatement(SEARCHAttackMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new AttackMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setMapName(rs.getString("mapName"));
				missionIntro.setMissionFF(rs.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs.getBoolean("missionFinished"));
				((AttackMission) missionIntro).setstolenRadianite(rs.getInt("stolenRadianite"));
				allMissions.add(missionIntro);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt = con.prepareStatement(SEARCHDeffendMission);
			rs2 = stmt.executeQuery();

			while (rs2.next()) {
				missionIntro = new DefendMission();
				missionIntro.setMissionCode(rs2.getInt("missionCode"));
				missionIntro.setMapName(rs2.getString("mapName"));
				missionIntro.setMissionFF(rs2.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs2.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs2.getBoolean("missionFinished"));
				((DefendMission) missionIntro).setdefendedRadianite(rs2.getInt("defendedRadianite"));
				allMissions.add(missionIntro);
			}

			if (rs != null)
				rs.close();

			if (rs2 != null)
				rs2.close();

		}

		catch (Exception e) {
			String msg = "Error en recuperar las misiones de defensa";
			ExceptionManager x = new ExceptionManager(msg);
			e.printStackTrace();
			// throw x;
		}

		try {
			conection.closeConnection(stmt, con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allMissions;
	}

	@Override
	/**
	 * Listado de todas las misiones de ataque
	 * @return attackMissions listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<AttackMission> getAllAttackMissions() throws ExceptionManager {
		List<AttackMission> attackMissions = new ArrayList<>();
		ResultSet rs = null;
		AttackMission missionIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHAttackMission = "SELECT m.*, am.* from mission m, attack_mission am where missionCode = attackMissionCode";

		try {
			stmt = con.prepareStatement(SEARCHAttackMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new AttackMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setMapName(rs.getString("mapName"));
				missionIntro.setMissionFF(rs.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs.getBoolean("missionFinished"));
				missionIntro.setstolenRadianite(rs.getInt("stolenRadianite"));
				attackMissions.add(missionIntro);
			}

			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recuperar las misiones de ataque";
			ExceptionManager x = new ExceptionManager(msg);
			e.printStackTrace();
			// throw x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return attackMissions;
	}

	@Override
	/**
	 * Listado de todas las misiones de defensa
	 * @return DefendMissions listado
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<DefendMission> getAllDefendMissions() throws ExceptionManager {
		List<DefendMission> DefendMissions = new ArrayList<>();
		ResultSet rs = null;
		DefendMission missionIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHDeffendMission = "SELECT m.*, dm.* from mission m, defend_mission dm where missionCode = defendMissionCode";

		try {
			stmt = con.prepareStatement(SEARCHDeffendMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new DefendMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setMapName(rs.getString("mapName"));
				missionIntro.setMissionFF(rs.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs.getBoolean("missionFinished"));
				missionIntro.setdefendedRadianite(rs.getInt("defendedRadianite"));
				DefendMissions.add(missionIntro);
			}

			if (rs != null)
				rs.close();

			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recuperar las misiones de ataque";
			ExceptionManager x = new ExceptionManager(msg);
			e.printStackTrace();
			// throw x;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DefendMissions;
	}

}

package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.ExceptionManager;
import model.AttackMission;
import model.DefendMission;
import model.Map;
import model.Mission;

public class MissionManagerBDImplementation implements MissionManager {
	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	@Override
	public Mission getMissionByCod(int codM) {
		ResultSet rs = null;
		Mission getMission = null;

		// Open the connection
		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {

		}
		String LISTMission = "SELECT * FROM MISSION WHERE missionCode = ? ";

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
				getMission.setmapName(rs.getString("mapName"));
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
	public int registerMission(Mission wMisson, char type) {
		ResultSet rs = null;
		int missionCode = -1;

		String INSERTMission = "{CALL createMission(?,?,?,?)}";
		String getMissionCode = "select Max(missionCode) from mission";
		try {
			con = conection.openConnection();

		} catch (ExceptionManager e1) {

		}

		try {
			CallableStatement cst = con.prepareCall(INSERTMission);
			cst.setString(1, wMisson.getmapName());
			cst.setDate(2, Date.valueOf(wMisson.getmissionFI()));
			cst.setDate(3, Date.valueOf(wMisson.getMissionFF()));
			cst.setLong(4, type);
			cst.execute();

			stmt = con.prepareStatement(getMissionCode);
			rs = stmt.executeQuery();
			if (rs.next()) {
				missionCode = rs.getInt("Max(missionCode)");

			}

		} catch (SQLException e) {

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
	public void sendAgentToMission(int codM, int codA, String primaryWeapon, String secondaryWeapon) {

		String SENDagentToMission = "{CALL sendAgentToMission(?,?,?,?)}";

		try {
			con = conection.openConnection();

		} catch (ExceptionManager e1) {

		}

		try {
			CallableStatement cst = con.prepareCall(SENDagentToMission);
			cst.setInt(1, codM);
			cst.setInt(2, codA);
			cst.setString(3, primaryWeapon);
			cst.setString(4, secondaryWeapon);
			cst.execute();

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
	public void endMission(int codM, char type) {
		String ENDMission = "{CALL endMission(?,?)}";
		try {
			con = conection.openConnection();

		} catch (ExceptionManager e1) {

		}

		try {
			CallableStatement cst = con.prepareCall(ENDMission);
			cst.setInt(1, codM);
			cst.setLong(2, type);

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
	public List<Mission> getAllMissions() {
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
		String SEARCHAttackMission = "SELECT m.*, am.* from mission m, attack_mission am";
		String SEARCHDeffendMission = "SELECT m.*, dm.* from mission m, defend_mission dm";

		try {
			stmt = con.prepareStatement(SEARCHAttackMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new AttackMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setmapName(rs.getString("mapName"));
				missionIntro.setMissionFF(rs.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs.getBoolean("missionFinished"));
				((AttackMission) missionIntro).setstolenRadianite(rs.getInt("stolenRadianite"));
				allMissions.add(missionIntro);
			}

			if (rs != null)
				rs.close();

		} catch (SQLException e) {

		}
		try {
			stmt = con.prepareStatement(SEARCHDeffendMission);
			rs2 = stmt.executeQuery();
			while (rs2.next()) {
				missionIntro = new DefendMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setmapName(rs.getString("mapName"));
				missionIntro.setMissionFF(rs.getDate("missionSD").toLocalDate());
				missionIntro.setMissionFI(rs.getDate("missionFD").toLocalDate());
				missionIntro.setmissionFinished(rs.getBoolean("missionFinished"));
				((DefendMission) missionIntro).setdefendedRadianite(rs.getInt("defendedRadianite"));
				allMissions.add(missionIntro);
			}

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
	public List<AttackMission> getAllAttackMissions() {
		List<AttackMission> attackMissions = new ArrayList<>();
		ResultSet rs = null;
		AttackMission missionIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHAttackMission = "SELECT m.*, am.* from mission m, attack_mission am";

		try {
			stmt = con.prepareStatement(SEARCHAttackMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new AttackMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setmapName(rs.getString("mapName"));
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
	public List<DefendMission> getAllDefendMissions() {
		List<DefendMission> DefendMissions = new ArrayList<>();
		ResultSet rs = null;
		DefendMission missionIntro = null;

		try {
			con = conection.openConnection();
		} catch (ExceptionManager e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String SEARCHDeffendMission = "SELECT m.*, dm.* from mission m, defend_mission dm";

		try {
			stmt = con.prepareStatement(SEARCHDeffendMission);
			rs = stmt.executeQuery();

			while (rs.next()) {
				missionIntro = new DefendMission();
				missionIntro.setMissionCode(rs.getInt("missionCode"));
				missionIntro.setmapName(rs.getString("mapName"));
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

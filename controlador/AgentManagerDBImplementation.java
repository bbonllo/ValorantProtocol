
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import exceptions.ExceptionManager;
import model.Ability;
import model.AbilityUltimate;
import model.Agent;

public class AgentManagerDBImplementation implements AgentManager {

	private Connection con;
	private PreparedStatement stmt;

	private void openConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/valorant_protocol?serverTimezone=Europe/Madrid&useSSL=false";
			con = DriverManager.getConnection(url, "root", "abcd*1234");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
			e.printStackTrace();
		}

	}

	private void closeConnection() throws SQLException {
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
	}

	@Override
	public Agent getAgentByID(int agentCode) {
		ResultSet rs = null;
		ResultSet rs2 = null;
		Agent getAgent = null;
		AbilityUltimate abilityUltimate = new AbilityUltimate();
		Ability[] agentAbilities = new Ability[4];
		int cont = 0;

		openConnection();
		final String SEARCHAgent = "SELECT * from Agent where agentCode = ?";

		try {
			stmt = con.prepareStatement(SEARCHAgent);
			stmt.setInt(1, agentCode);

			rs = stmt.executeQuery();
			if (rs.next()) {
				getAgent = new Agent();
				getAgent.setAgentCode(agentCode);
				getAgent.setAgentPasswd("yakisieras");
				getAgent.setAgentName(rs.getString("agentName"));
				getAgent.setAgentNationality(rs.getString("agentNationality"));
				getAgent.setAgentRol(rs.getString("agentRol"));
				getAgent.setAgentIsAdmin(rs.getBoolean("agentIsAdmin"));
				getAgent.setAgentIsOnMission(rs.getBoolean("agentIsOnMission"));
				getAgent.setAgentIsOnMission(rs.getBoolean("agentIsActive"));

				final String SEARCHAgentsAbility = "SELECT * from ability where agentCode = ? order by orbNum asc";

				stmt = con.prepareStatement(SEARCHAgentsAbility);
				stmt.setInt(1, agentCode);

				rs2 = stmt.executeQuery();
				while (rs2.next()) {

					if (cont == 3) {
						abilityUltimate.setAbilityName(rs2.getString("abilityName"));
						abilityUltimate.setAbilityDescription(rs2.getString("abilityDescription"));
						abilityUltimate.setAbilityUltimateRequiredOrbs(rs2.getInt("orbNum"));
						agentAbilities[cont] = abilityUltimate;
					} else {
						Ability ability = new Ability();
						ability.setAbilityName(rs2.getString("abilityName"));
						ability.setAbilityDescription(rs2.getString("abilityDescription"));
						agentAbilities[cont] = ability;
					}
					cont++;
				}
				getAgent.setAgentAbilities(agentAbilities);
			} else
				getAgent = null;

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAgent;

	}

	@Override
	public void registerAgent(Agent registerAgent) {
		Ability ability1;
		Ability ability2;
		Ability ability3;
		AbilityUltimate ability4;
		Ability[] agentAbilities = new Ability[4];

		// Abrimos la conexi�n
		this.openConnection();

		// Meto los valores del agente dentro del stmt:
		try {
			final String INSERTAgent = "INSERT INTO agent(agentCode, agentPasswd, agentName, agentNationality, agentRol, agentIsAdmin, agentIsOnMission, agentIsActive) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(INSERTAgent);

			stmt.setInt(1, registerAgent.getAgentCode());
			stmt.setString(2, registerAgent.getAgentPasswd());
			stmt.setString(3, registerAgent.getAgentName());
			stmt.setString(4, registerAgent.getAgentNationality());
			stmt.setString(5, registerAgent.getAgentRol());
			stmt.setBoolean(6, registerAgent.isAgentIsAdmin());
			stmt.setBoolean(7, registerAgent.isAgentIsOnMission());
			stmt.setBoolean(8, registerAgent.isAgentIsOnActive());

			stmt.executeUpdate();

			agentAbilities = registerAgent.getAgentAbilities();

			ability1 = agentAbilities[0];
			ability2 = agentAbilities[1];
			ability3 = agentAbilities[2];
			ability4 = (AbilityUltimate) agentAbilities[3];

			// INSERTAR HABILIDADES DEL AGENTE

			// HABILIDAD 1
			final String INSERTAbility1 = "INSERT INTO ability(abilityName, agentCode, abilityDescription, orbnum) VALUES(?, ?, ?, null)";

			stmt = con.prepareStatement(INSERTAbility1);

			stmt.setString(1, ability1.getAbilityName());
			stmt.setInt(2, registerAgent.getAgentCode());
			stmt.setString(3, ability1.getAbilityDescription());

			stmt.executeUpdate();

			// HABILIDAD 2
			final String INSERTAbility2 = "INSERT INTO ability(abilityName, agentCode, abilityDescription, orbnum) VALUES(?, ?, ?, null)";

			stmt = con.prepareStatement(INSERTAbility2);

			stmt.setString(1, ability2.getAbilityName());
			stmt.setInt(2, registerAgent.getAgentCode());
			stmt.setString(3, ability2.getAbilityDescription());

			stmt.executeUpdate();

			// HABILIDAD 3
			final String INSERTAbility3 = "INSERT INTO ability(abilityName, agentCode, abilityDescription, orbnum) VALUES(?, ?, ?, null)";

			stmt = con.prepareStatement(INSERTAbility3);

			stmt.setString(1, ability3.getAbilityName());
			stmt.setInt(2, registerAgent.getAgentCode());
			stmt.setString(3, ability3.getAbilityDescription());

			stmt.executeUpdate();

			// HABILIDAD ULTIMATE
			final String INSERTAbility4 = "INSERT INTO ability(abilityName, agentCode, abilityDescription, orbnum) VALUES(?, ?, ?, ?)";

			stmt = con.prepareStatement(INSERTAbility4);

			stmt.setString(1, ability4.getAbilityName());
			stmt.setInt(2, registerAgent.getAgentCode());
			stmt.setString(3, ability4.getAbilityDescription());
			stmt.setInt(4, ability4.getAbilityUltimateRequiredOrbs());

			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void modifyAgent(Agent modifyAgent) {
		Ability ability1;
		Ability ability2;
		Ability ability3;
		AbilityUltimate ability4;
		Ability[] agentAbilities = new Ability[4];

		// Abrimos la conexi�n
		this.openConnection();

		// Meto los valores del agente dentro del stmt:
		try {
			final String INSERTAgent = "update agent set agentName = ?, agentNationality = ?, agentRol = ? where agentCode = ?";
			stmt = con.prepareStatement(INSERTAgent);

			stmt.setString(1, modifyAgent.getAgentName());
			stmt.setString(2, modifyAgent.getAgentNationality());
			stmt.setString(3, modifyAgent.getAgentRol());
			stmt.setInt(4, modifyAgent.getAgentCode());

			stmt.executeUpdate();

			agentAbilities = modifyAgent.getAgentAbilities();

			ability1 = agentAbilities[0];
			ability2 = agentAbilities[1];
			ability3 = agentAbilities[2];
			ability4 = (AbilityUltimate) agentAbilities[3];

			// INSERTAR HABILIDADES DEL AGENTE

			// HABILIDAD 1
			final String INSERTAbility1 = "update ability set AbilityName = ?, AbilityDescription = ? where agentCode = ?";

			stmt = con.prepareStatement(INSERTAbility1);

			stmt.setString(1, ability1.getAbilityName());
			stmt.setString(3, ability1.getAbilityDescription());
			stmt.setInt(3, modifyAgent.getAgentCode());

			stmt.executeUpdate();

			// HABILIDAD 2
			final String INSERTAbility2 = "update ability set AbilityName = ?, AbilityDescription = ? where agentCode = ?";

			stmt = con.prepareStatement(INSERTAbility2);

			stmt.setString(1, ability2.getAbilityName());
			stmt.setString(3, ability2.getAbilityDescription());
			stmt.setInt(3, modifyAgent.getAgentCode());

			stmt.executeUpdate();

			// HABILIDAD 3
			final String INSERTAbility3 = "update ability set AbilityName = ?, AbilityDescription = ? where agentCode = ?";

			stmt = con.prepareStatement(INSERTAbility3);

			stmt.setString(1, ability3.getAbilityName());
			stmt.setString(3, ability3.getAbilityDescription());
			stmt.setInt(3, modifyAgent.getAgentCode());

			stmt.executeUpdate();

			// HABILIDAD ULTIMATE
			final String INSERTAbility4 = "update ability set AbilityName = ?, AbilityDescription = ?, orbNum = ? where agentCode = ?";

			stmt = con.prepareStatement(INSERTAbility4);

			stmt.setString(1, ability4.getAbilityName());
			stmt.setString(2, ability4.getAbilityDescription());
			stmt.setInt(3, ability4.getAbilityUltimateRequiredOrbs());
			stmt.setInt(4, modifyAgent.getAgentCode());

			stmt.executeUpdate();

		} catch (SQLException e1) {
			System.out.println("Error en alta SQL");
			e1.printStackTrace();
		} finally {
			try {
				this.closeConnection();
			} catch (SQLException e) {
				System.out.println("Error en cierre de la BD");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void makeAgentInactive(int agentCode) {

		openConnection();
		final String deleteAgent = "update agent set agentIsActive = false where agentCode = ?;";

		try {
			stmt = con.prepareStatement(deleteAgent);
			stmt.setInt(1, agentCode);

			stmt.executeUpdate();

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void makeAgentActive(int agentCode) {

		openConnection();
		final String deleteAgent = "update agent set agentIsActive = true where agentCode = ?;";

		try {
			stmt = con.prepareStatement(deleteAgent);
			stmt.setInt(1, agentCode);

			stmt.executeUpdate();

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Agent> getAllAgents() throws ExceptionManager {

		// ArrayList<Agent> agentsList
		List<Agent> activeAgents = new ArrayList<>();
		ResultSet rs = null;
		Agent agentIntro = null;

		openConnection();
		String SEARCHAllAgents = "SELECT * from agent order by agentCode";

		try {
			stmt = con.prepareStatement(SEARCHAllAgents);
			rs = stmt.executeQuery();

			while (rs.next()) {

				agentIntro = new Agent();
				agentIntro.setAgentCode(rs.getInt("agentCode"));
				agentIntro.setAgentName(rs.getString("agentName"));
				activeAgents.add(agentIntro);
			}

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			String msg = "Error en recoger a todos los agentes";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		}
		return activeAgents;
	}

	@Override
	public List<Agent> getAllActiveAgents() {
		// TODO Auto-generated method stub

		List<Agent> activeAgents = new ArrayList<>();
		ResultSet rs = null;
		Agent agentIntro = null;

		openConnection();
		String SEARCHAllAgents = "select * from agent where agentIsActive = true";

		try {
			stmt = con.prepareStatement(SEARCHAllAgents);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agentIntro = new Agent();
				agentIntro.setAgentCode(rs.getInt("agentCode"));
				agentIntro.setAgentName(rs.getString("agentName"));
				activeAgents.add(agentIntro);
			}

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			String msg = "Error en recoger a todos los agentes";
			ExceptionManager x = new ExceptionManager(msg);
		}
		return activeAgents;
	}

	@Override
	public Agent login(int agentCode, String passwd) {

		ResultSet rs = null;
		ResultSet rs2 = null;
		Agent getAgent = null;
		Ability ability = new Ability();
		AbilityUltimate abilityUltimate = new AbilityUltimate();
		Ability[] agentAbilities = new Ability[4];

		openConnection();
		final String SEARCHAgent = "SELECT * from Agent where agentCode = ? and agentPasswd = ?";

		try {
			stmt = con.prepareStatement(SEARCHAgent);
			stmt.setInt(1, agentCode);
			stmt.setString(2, passwd);

			rs = stmt.executeQuery();
			if (rs.next()) {
				getAgent = new Agent();
				getAgent.setAgentCode(agentCode);
				getAgent.setAgentPasswd("yakisieras");
				getAgent.setAgentName(rs.getString("agentName"));
				getAgent.setAgentNationality(rs.getString("agentNationality"));
				getAgent.setAgentRol(rs.getString("agentRol"));
				getAgent.setAgentIsAdmin(rs.getBoolean("agentIsAdmin"));
				getAgent.setAgentIsOnMission(rs.getBoolean("agentIsOnMission"));
				getAgent.setAgentIsOnMission(rs.getBoolean("agentIsActive"));

				final String SEARCHAgentsAbility = "SELECT * from ability where agentCode = ? order by orbNum asc";

				stmt = con.prepareStatement(SEARCHAgentsAbility);
				stmt.setInt(1, agentCode);

				rs2 = stmt.executeQuery();
				int cont = 0;
				while (rs2.next()) {

					if (cont == 3) {
						abilityUltimate.setAbilityName(rs2.getString("abilityName"));
						abilityUltimate.setAbilityDescription(rs2.getString("abilityDescription"));
						abilityUltimate.setAbilityUltimateRequiredOrbs(rs2.getInt("orbNum"));
						agentAbilities[cont] = abilityUltimate;
					} else {
						ability.setAbilityName(rs2.getString("abilityName"));
						ability.setAbilityDescription(rs2.getString("abilityDescription"));

						agentAbilities[cont] = ability;
						cont++;

					}
				}
				getAgent.setAgentAbilities(agentAbilities);

			} else
				getAgent = null;

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAgent;
	}

	@Override
	public List<Agent> getTeammates(int agentCode) {
		List<Agent> teammates = new ArrayList<>();
		ResultSet rs = null;
		Agent teammate = null;

		openConnection();
		String SEARCHteammates = "select * from agent where agentCode in(select agentCode from agent_on_mission where missionCode in(select missionCode from agent_on_mission where agentCode = ?";

		try {
			stmt = con.prepareStatement(SEARCHteammates);
			stmt.setInt(1, agentCode);
			rs = stmt.executeQuery();

			while (rs.next()) {
				teammate = new Agent();
				teammate.setAgentCode(rs.getInt("agentCode"));
				teammate.setAgentName(rs.getString("agentName"));
				teammates.add(teammate);
			}

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			String msg = "Error en recoger a todos los agentes";
			ExceptionManager x = new ExceptionManager(msg);
		}
		return teammates;
	}

}
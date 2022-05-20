package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import exceptions.ExceptionManager;
import model.Ability;
import model.AbilityUltimate;
import model.Agent;

public class AgentManagerDBImplementation implements AgentManager {

	private Connection con;
	private PreparedStatement stmt;
	private ConnectionOpenClose conection = new ConnectionOpenClose();

	@Override
	/**
	 * Busqueda de agente por ID
	 * 
	 * @param agentCode ID del agente a buscar
	 * @return getAgent encontrado (Si no es encontrado null)
	 * @throws ExceptionManager ExceptionManager
	 */
	public Agent getAgentByID(int agentCode) throws ExceptionManager {
		ResultSet rs = null;
		ResultSet rs2 = null;
		Agent getAgent = null;
		AbilityUltimate abilityUltimate = new AbilityUltimate();
		Ability[] agentAbilities = new Ability[4];
		int cont = 0;

		con = conection.openConnection();
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
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			String error = "error al recuperar del agente";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return getAgent;

	}

	@Override
	/**
	 * Registro de un agente
	 * 
	 * @param registerAgent agente que se quiere registrar
	 * @throws ExceptionManager ExceptionManager
	 */
	public void registerAgent(Agent registerAgent) throws ExceptionManager {
		Ability ability1;
		Ability ability2;
		Ability ability3;
		AbilityUltimate ability4;
		Ability[] agentAbilities = new Ability[4];

		// Abrimos la conexiï¿½n
		con = conection.openConnection();

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
			stmt.close();
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

			conection.closeConnection(stmt, con);
		} catch (SQLException e1) {

			String error = "Agente ya existe";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}

	}

	@Override
	/**
	 * Modificacion de un agente
	 * 
	 * @param modifyAgent
	 * @throws ExceptionManager ExceptionManager
	 */
	public void modifyAgent(Agent modifyAgent) throws ExceptionManager {
		Ability ability1;
		Ability ability2;
		Ability ability3;
		AbilityUltimate ability4;
		Ability[] agentAbilities = new Ability[4];

		// Abrimos la conexiï¿½n
		con = conection.openConnection();

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
			final String UPDATEAbility1 = "update ability set AbilityDescription = ? where agentCode = ? and AbilityName = ?";
			PreparedStatement stmt2;
			stmt2 = con.prepareStatement(UPDATEAbility1);

			stmt2.setString(1, ability1.getAbilityDescription());
			stmt2.setInt(2, modifyAgent.getAgentCode());
			stmt2.setString(3, ability1.getAbilityName());

			stmt2.executeUpdate();

			// HABILIDAD 2
			final String UPDATEAbility2 = "update ability set AbilityDescription = ? where agentCode = ? and AbilityName = ?";
			PreparedStatement stmt3;
			stmt3 = con.prepareStatement(UPDATEAbility2);

			stmt3.setString(1, ability2.getAbilityDescription());
			stmt3.setInt(2, modifyAgent.getAgentCode());
			stmt3.setString(3, ability2.getAbilityName());

			stmt3.executeUpdate();

			// HABILIDAD 3
			final String UPDATEAbility3 = "update ability set AbilityDescription = ? where agentCode = ? and AbilityName = ?";
			PreparedStatement stmt4;
			stmt4 = con.prepareStatement(UPDATEAbility3);

			stmt4.setString(1, ability3.getAbilityDescription());
			stmt4.setInt(2, modifyAgent.getAgentCode());
			stmt4.setString(3, ability3.getAbilityName());
			stmt4.executeUpdate();

			// HABILIDAD ULTIMATE
			final String UPDATEAbility4 = "update ability set AbilityDescription = ?, orbNum = ? where agentCode = ? and AbilityName = ?";
			PreparedStatement stmt5;
			stmt5 = con.prepareStatement(UPDATEAbility4);

			stmt5.setString(1, ability4.getAbilityDescription());
			stmt5.setInt(2, ability4.getAbilityUltimateRequiredOrbs());
			stmt5.setInt(3, modifyAgent.getAgentCode());
			stmt5.setString(4, ability4.getAbilityName());

			stmt5.executeUpdate();

			conection.closeConnection(stmt, con);
			conection.closeConnection(stmt2, con);
			conection.closeConnection(stmt3, con);
			conection.closeConnection(stmt4, con);
			conection.closeConnection(stmt5, con);
		} catch (SQLException e1) {
			e1.printStackTrace();
			String error = "ERROR AL MODIFICAR EL AGENTE";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}

	}

	@Override
	/**
	 * Poner un agente inactivo con su ID
	 * 
	 * @param agentCode ID del agente
	 * @throws ExceptionManager ExceptionManager
	 */
	public void makeAgentInactive(int agentCode) throws ExceptionManager {

		con = conection.openConnection();
		final String deleteAgent = "update agent set agentIsActive = false where agentCode = ?";

		try {
			stmt = con.prepareStatement(deleteAgent);
			stmt.setInt(1, agentCode);

			stmt.executeUpdate();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "ERROR AL HACER EL AGENTE INACTIVO";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}

	}

	@Override
	/**
	 * Poner un agente activo con su ID
	 * 
	 * @param agentCode ID del agente
	 * @throws ExceptionManager ExceptionManager
	 */
	public void makeAgentActive(int agentCode) throws ExceptionManager {

		con = conection.openConnection();
		final String addAgent = "update agent set agentIsActive = true where agentCode = ?";

		try {
			stmt = con.prepareStatement(addAgent);
			stmt.setInt(1, agentCode);

			stmt.executeUpdate();
			stmt.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "ERROR AL PONER EL AGENTE EN ACTIVO";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
	}

	@Override
	/**
	 * Listado de todos los agentes
	 * 
	 * @return agents Un List de los agentes
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Agent> getAllAgents() throws ExceptionManager {

		// ArrayList<Agent> agentsList
		List<Agent> agents = new ArrayList<>();

		ResultSet rs = null;
		Agent agentIntro = null;

		con = conection.openConnection();
		String SEARCHAllAgents = "SELECT * from agent order by agentCode";

		try {
			stmt = con.prepareStatement(SEARCHAllAgents);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agentIntro = new Agent();
				agentIntro.setAgentCode(rs.getInt("agentCode"));
				agentIntro.setAgentName(rs.getString("agentName"));
				agentIntro.setAgentNationality(rs.getString("agentNationality"));
				agentIntro.setAgentRol(rs.getString("agentRol"));
				agentIntro.setAgentIsAdmin(rs.getBoolean("agentIsAdmin"));
				agentIntro.setAgentIsOnMission(rs.getBoolean("agentIsOnMission"));
				agentIntro.setAgentIsOnActive(rs.getBoolean("agentIsActive"));
				agents.add(agentIntro);
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String msg = "Error en recoger a todos los agentes";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		}
		return agents;
	}

	@Override
	/**
	 * Listado de todos los agentes activos
	 * 
	 * @return activeAgents Un List de los agentes activos
	 * @throws ExceptionManager ExceptionManager
	 */
	public List<Agent> getAllActiveAgents() throws ExceptionManager {
		// TODO Auto-generated method stub

		List<Agent> activeAgents = new ArrayList<>();
		ResultSet rs = null;
		Agent agentIntro = null;

		con = conection.openConnection();
		String SEARCHAllAgents = "select * from agent where agentIsActive = true";

		try {
			stmt = con.prepareStatement(SEARCHAllAgents);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agentIntro = new Agent();
				agentIntro.setAgentCode(rs.getInt("agentCode"));
				agentIntro.setAgentName(rs.getString("agentName"));
				agentIntro.setAgentNationality(rs.getString("agentNationality"));
				agentIntro.setAgentRol(rs.getString("agentRol"));
				agentIntro.setAgentIsAdmin(rs.getBoolean("agentIsAdmin"));
				agentIntro.setAgentIsOnMission(rs.getBoolean("agentIsOnMission"));
				agentIntro.setAgentIsOnActive(rs.getBoolean("agentIsActive"));
				activeAgents.add(agentIntro);
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
		return activeAgents;
	}

	@Override
	/**
	 * LogIn de un agente
	 * 
	 * @param agentCode ID del agente
	 * @param passwd    contraseña del agente
	 * @return getAgent Agente logueado
	 * @throws ExceptionManager ExceptionManager
	 */
	public Agent login(int agentCode, String passwd) throws ExceptionManager {

		ResultSet rs = null;
		ResultSet rs2 = null;
		Agent getAgent = null;
		Ability ability = new Ability();
		AbilityUltimate abilityUltimate = new AbilityUltimate();
		Ability[] agentAbilities = new Ability[4];

		con = conection.openConnection();
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
				getAgent.setAgentIsOnActive(rs.getBoolean("agentIsActive"));

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
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			String error = "error en el login";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return getAgent;
	}

	@Override
	/**
	 * Listado de los compañeros de un agente a su codigo
	 * 
	 * @param agenCode ID del agente
	 * @return teammates int[] de los ID de sus compañeros
	 * @throws ExceptionManager ExceptionManager
	 */
	public int[] getTeammates(int agentCode) throws ExceptionManager {
		int i = 0;
		int[] teammates = new int[5];
		ResultSet rs = null;

		con = conection.openConnection();
		String SEARCHteammates = "{CALL bring(?)}";
		String getTeammates = "Select * from log_record";

		try {
			CallableStatement cst = con.prepareCall(SEARCHteammates);
			cst.setInt(1, agentCode);
			cst.execute();
			cst.close();

			stmt = con.prepareStatement(getTeammates);

			rs = stmt.executeQuery();

			while (rs.next()) {
				teammates[i] = (rs.getInt("agentcode1"));
				i++;
				teammates[i] = (rs.getInt("agentcode2"));
				i++;
				teammates[i] = (rs.getInt("agentcode3"));
				i++;
				teammates[i] = (rs.getInt("agentcode4"));
				i++;
				teammates[i] = (rs.getInt("agentcode5"));
			}

			if (rs != null)
				rs.close();
			conection.closeConnection(stmt, con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getStackTrace();
			String error = "Error al recoger informacion del mapa selecionado";
			ExceptionManager uwu = new ExceptionManager(error);
			throw uwu;
		}
		return teammates;
	}

}
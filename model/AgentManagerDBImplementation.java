
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import exceptions.ExceptionManager;

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
		Agent getAgent = null;

		openConnection();
		String SEARCHAgent = "SELECT * from Agent where agentCode = ?";

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
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyAgent(Agent modifyAgent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAgent(int agentCode) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Agent> getAllAgents() throws ExceptionManager {

		Set<Agent> agents = new HashSet<>();
		ResultSet rs = null;
		Agent agentIntro = null;

		openConnection();
		String SEARCHAllAgents = "SELECT * from agent";

		try {
			stmt = con.prepareStatement(SEARCHAllAgents);
			rs = stmt.executeQuery();

			while (rs.next()) {
				agentIntro = new Agent();
				agentIntro.setAgentCode(rs.getInt("agentCode"));
				agentIntro.setAgentName(rs.getString("agentName"));
			}

			if (rs != null)
				rs.close();

			closeConnection();
		} catch (SQLException e) {
			String msg = "Error en recoger a todos los agentes";
			ExceptionManager x = new ExceptionManager(msg);
			throw x;
		}
		return agents;
	}

	@Override
	public Set<Agent> getAllActiveAgents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent Login(String username, String passwd) {
		// TODO Auto-generated method stub
		return null;
	}
}
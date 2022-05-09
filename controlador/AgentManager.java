package controlador;

import java.sql.Array;
import java.util.Set;

import exceptions.ExceptionManager;
import model.Agent;

public interface AgentManager {

	public Agent getAgentByID(int agentCode);

	public void registerAgent(Agent registerAgent);

	public void modifyAgent(Agent modifyAgent);

	public void makeAgentActive(int agentCode);

	public Set<Agent> getAllAgents() throws ExceptionManager;

	public Set<Agent> getAllActiveAgents();

	public Agent login(int agentCode, String passwd);
	
	public void makeAgentInactive(int agentCode);
	
	public int[] getTeammates(int agentCode);
	
}

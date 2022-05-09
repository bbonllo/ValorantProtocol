package controlador;

import java.util.Set;

import exceptions.ExceptionManager;
import model.Agent;

public interface AgentManager {

	public Agent getAgentByID(int agentCode);

	public boolean registerAgent(Agent registerAgent);

	public boolean modifyAgent(Agent modifyAgent);

	public boolean makeAgentActive(int agentCode);

	public Set<Agent> getAllAgents() throws ExceptionManager;

	public Set<Agent> getAllActiveAgents();

	public Agent login(int agentCode, String passwd);
	
	public boolean makeAgentInactive(int agentCode);
	
	public Set<Agent> getTeammates(int agentCode);
	
}

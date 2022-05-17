package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Agent;

public interface AgentManager {

	public Agent getAgentByID(int agentCode);

	public Agent login(int agentCode, String passwd);

	public void registerAgent(Agent registerAgent);

	public void modifyAgent(Agent modifyAgent);

	public void makeAgentActive(int agentCode);

	public List<Agent> getAllAgents() throws ExceptionManager;

	public List<Agent> getAllActiveAgents();

	public void makeAgentInactive(int agentCode);

	public int[] getTeammates(int agentCode);

}

package model;

import java.util.Set;

import exceptions.ExceptionManager;

public interface AgentManager {

	public Agent getAgentByID(int agentCode);

	public void registerAgent(Agent registerAgent);

	public void modifyAgent(Agent modifyAgent);

	public void deleteAgent(int agentCode);

	public Set<Agent> getAllAgents() throws ExceptionManager;

	public Set<Agent> getAllActiveAgents();

	public Agent Login(String username, String passwd);
}

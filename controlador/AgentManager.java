package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Agent;

public interface AgentManager {

	public Agent getAgentByID(int agentCode) throws ExceptionManager;

	public Agent login(int agentCode, String passwd) throws ExceptionManager;

	public void registerAgent(Agent registerAgent) throws ExceptionManager;

	public void modifyAgent(Agent modifyAgent) throws ExceptionManager;

	public void makeAgentActive(int agentCode) throws ExceptionManager;

	public List<Agent> getAllAgents() throws ExceptionManager;

	public List<Agent> getAllActiveAgents() throws ExceptionManager;

	public void makeAgentInactive(int agentCode) throws ExceptionManager;

	public int[] getTeammates(int agentCode) throws ExceptionManager;

}

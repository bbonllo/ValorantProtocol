package controlador;

<<<<<<< HEAD
import java.util.List;
=======
import java.sql.Array;
import java.util.Set;
>>>>>>> 7e3907b59808802c78856ca6e0a1309bd3276d04

import exceptions.ExceptionManager;
import model.Agent;

public interface AgentManager {

	public Agent getAgentByID(int agentCode);

	public void registerAgent(Agent registerAgent);

	public void modifyAgent(Agent modifyAgent);

	public void makeAgentActive(int agentCode);

	public List<Agent> getAllAgents() throws ExceptionManager;

	public List<Agent> getAllActiveAgents();

	public Agent login(int agentCode, String passwd);

	public void makeAgentInactive(int agentCode);
<<<<<<< HEAD

	public List<Agent> getTeammates(int agentCode);

=======
	
	public int[] getTeammates(int agentCode);
	
>>>>>>> 7e3907b59808802c78856ca6e0a1309bd3276d04
}

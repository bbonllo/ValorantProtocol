package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.AgentManager;
import controlador.AgentManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Agent;

public class AgentTest {
	int agentCode = 1;
	String agentPasswd = "adadawd"; 
	String agentName = "adadada";
	String agentNationality = "adadadad";
	String agentRol = "adadadad";
	AgentManager agMan = new AgentManagerDBImplementation();
	Agent agent = new Agent(agentCode, agentPasswd, agentName, agentNationality, null, false, false);
	
	@Test
	public void testGetAgentByID() {
		assertNotNull(agMan.getAgentByID(agentCode));
	}

	@Test
	public void testRegisterAgent() {
		assertTrue(agMan.registerAgent(agent));
	}

	@Test
	public void testModifyAgent() {
		assertFalse(agMan.modifyAgent(agent));
	}

	@Test
	public void testMakeAgentInactive() {
		assertFalse(agMan.makeAgentInactive(agentCode));	
	}

	@Test
	public void testMakeAgentActive() {
		assertFalse(agMan.makeAgentActive(agentCode));
	}

	@Test
	public void testGetAllAgents() {
		try {
			assertNotNull(agMan.getAllAgents());
		} catch (ExceptionManager e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAllActiveAgents() {
		assertNotNull(agMan.getAllActiveAgents());
	}

	@Test
	public void testLogin() {
		assertNull(agMan.login(agentCode, agentPasswd));
	}

	@Test
	public void testGetTeammates() {
		assertNotNull(agMan.getTeammates(agentCode));
	}

}

package tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import controlador.AgentManager;
import controlador.AgentManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Ability;
import model.Agent;

public class AgentTest {
	
	@Test
	public void testGetAgentByID() {
		//Preparar datos
		int agentCode = 23;
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		Agent ag = agMan.getAgentByID(agentCode);
		//Preguntar por resultado assert
		assertNotNull(ag);
	}
	
	@Test
	public void testRegisterAgent() {
		//Preparar datos
		int agentCode = 24;
		String agentPasswd = "adadawd"; 
		String agentName = "adadada";
		String agentNationality = "adadadad";
		String agentRol = "Duelist";
		Ability[] abs = new Ability[4];
		AgentManager agMan = new AgentManagerDBImplementation();
		Agent agent = new Agent(agentCode, agentPasswd, agentName, agentNationality, agentRol, false, false);
		//Llamar al método a testear
		boolean isTrue = agMan.registerAgent(agent);
		//Preguntar por resultado assert
		assertTrue(isTrue);
	}

	@Test
	public void testModifyAgent() {
		//Preparar datos
		int agentCode = 21;
		String agentPasswd = "adadawd"; 
		String agentName = "adadada";
		String agentNationality = "adadadad";
		String agentRol = "Duelist";
		Ability[] abs = new Ability[4];
		AgentManager agMan = new AgentManagerDBImplementation();
		Agent agent = new Agent(agentCode, agentPasswd, agentName, agentNationality, agentRol, false, false);
		//Llamar al método a testear
		boolean isTrue = agMan.modifyAgent(agent);
		//Preguntar por resultado assert
		assertTrue(isTrue);
	}

/*	@Test
	public void testMakeAgentInactive() {
		//Preparar datos
		int agentCode = 21;
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		boolean isTrue = agMan.makeAgentInactive(agentCode);
		//Preguntar por resultado assert
		assertFalse(isTrue);	
	}
*/
	@Test
	public void testMakeAgentActive() {
		//Preparar datos
		int agentCode = 21;
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		boolean isTrue = agMan.makeAgentActive(agentCode);
		//Preguntar por resultado assert
		assertFalse(isTrue);	
	}

	@Test
	public void testGetAllAgents() {
		//Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		List<Agent> agents;
		try {
			agents = agMan.getAllAgents();
			//Preguntar por resultado assert
			assertNotNull(agents);
		} catch (ExceptionManager e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetAllActiveAgents() {
		//Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		List<Agent> agents = agMan.getAllActiveAgents();
		//Preguntar por resultado assert
		assertNotNull(agents);
	}

	@Test
	public void testLogin() {
		//Preparar datos
		int agentCode = 21;
		String agentPasswd = "adadawd"; 
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		Agent agent = agMan.login(agentCode, agentPasswd);
		//Preguntar por resultado assert
		assertNotNull(agent);
	}

	@Test
	public void testGetTeammates() {
		//Preparar datos
		int agentCode = 21;
		String agentPasswd = "adadawd"; 
		AgentManager agMan = new AgentManagerDBImplementation();
		//Llamar al método a testear
		List<Agent> agents = agMan.getTeammates(agentCode);
		//Preguntar por resultado assert
		assertNotNull(agents);
	}

}

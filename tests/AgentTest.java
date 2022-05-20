package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import controlador.AgentManager;
import controlador.AgentManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Ability;
import model.AbilityUltimate;
import model.Agent;

/**
 * @author Grupo-E
 *
 */
public class AgentTest {

	/**
	 * Testeo de obtencion de agente por su ID
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAgentByID() throws ExceptionManager {
		// Preparar datos
		int agentCode = 10;
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertNotNull(ag);
	}

	/**
	 * Testeo del registro de un agente
	 * 
	 * @throws ExceptionManager
	 */
	@Test(expected = ExceptionManager.class)
	public void testRegisterAgent() throws ExceptionManager {
		// Preparar datos
		int agentCode = 23;
		String agentPasswd = "adadawd";
		String agentName = "adadada";
		String agentNationality = "adadadad";
		String agentRol = "Duelist";

		Ability ab1 = new Ability("test1", "mata");
		Ability ab2 = new Ability("test2", "mata");
		Ability ab3 = new Ability("test3", "mata");
		Ability ab4 = new AbilityUltimate(4, "test4", "mata");
		Ability[] abs = { ab1, ab2, ab3, ab4 };

		AgentManager agMan = new AgentManagerDBImplementation();
		Agent agent = new Agent(agentCode, agentPasswd, agentName, agentNationality, agentRol, abs, false, false);
		// Llamar al método a testear
		agMan.registerAgent(agent);
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertFalse(ag.isAgentIsOnActive());
	}

	/**
	 * Testeo de la modificacion de un agente
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testModifyAgent() throws ExceptionManager {
		// Preparar datos
		int agentCode = 21;
		String agentPasswd = "adadawd";
		String agentName = "adadada";
		String agentNationality = "adadadad";
		String agentRol = "Duelist";

		Ability ab1 = new Ability("test1", "mata");
		Ability ab2 = new Ability("test2", "mata");
		Ability ab3 = new Ability("test3", "mata");
		Ability ab4 = new AbilityUltimate(4, "test4", "mata");
		Ability[] abs = { ab1, ab2, ab3, ab4 };

		AgentManager agMan = new AgentManagerDBImplementation();
		Agent agent = new Agent();
		agent.setAgentCode(agentCode);
		agent.setAgentPasswd(agentPasswd);
		agent.setAgentName(agentName);
		agent.setAgentNationality(agentNationality);
		agent.setAgentRol(agentRol);
		agent.setAgentAbilities(abs);
		// Llamar al método a testear
		agMan.modifyAgent(agent);
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertNotNull(ag.getAgentCode());
	}

	/**
	 * Testeo de la conversion de un agente a inactivo
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testMakeAgentInactive() throws ExceptionManager {
		// Preparar datos
		int agentCode = 21;
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		agMan.makeAgentInactive(agentCode);
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertFalse(ag.isAgentIsOnActive());
	}

	/**
	 * Testeo de la conversion de un agente a activo
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testMakeAgentActive() throws ExceptionManager {
		// Preparar datos
		int agentCode = 21;
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		agMan.makeAgentActive(agentCode);
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertFalse(ag.isAgentIsOnActive());
	}

	/**
	 * Testeo del listado de todos los agentes
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllAgents() throws ExceptionManager {
		// Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		List<Agent> agents;

		agents = agMan.getAllAgents();
		// Preguntar por resultado assert
		assertNotNull(agents);

	}

	/**
	 * Testeo del listado de todos los agentes activos
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllActiveAgents() throws ExceptionManager {
		// Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		List<Agent> agents = agMan.getAllActiveAgents();
		// Preguntar por resultado assert
		assertNotNull(agents);
	}

	/**
	 * Testeo de logeo del agente
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testLogin() throws ExceptionManager {
		// Preparar datos
		int agentCode = 13;
		String agentPasswd = "1234";
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		Agent agent = agMan.login(agentCode, agentPasswd);
		// Preguntar por resultado assert
		assertNotNull(agent);
	}

	/**
	 * Testeo del listado de los compa�eros de un agente
	 * 
	 * @throws ExceptionManager
	 */
	@Test(expected = ExceptionManager.class)
	public void testGetTeammates() throws ExceptionManager {
		// Preparar datos
		int agentCode = 1;
		// String agentPasswd = "adadawd";
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		int[] agents = agMan.getTeammates(agentCode);
		// Preguntar por resultado assert
		assertNotNull(agents);
	}
}

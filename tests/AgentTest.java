package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.AgentManager;
import controlador.AgentManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Ability;
import model.AbilityUltimate;
import model.Agent;

public class AgentTest {
	
	@Before
	/**
	 * Pasos previos para poder modificar un agente sin que afecte a los de la base de datos
	 * @throws ExceptionManager
	 */
	public void setUp() throws ExceptionManager {
		int agentCode = 21;
		String agentPasswd = "adada";
		String agentName = "adada";
		String agentNationality = "adadad";
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
		agMan.registerAgent(agent);
	}
	
	@After
	/**
	 * Invalidar el uso de los agentes usados en el testeo
	 * @throws ExceptionManager
	 */
	public void clear() throws ExceptionManager {
		int agentCode = 21;
		int agentCode2 = 23;
		AgentManager agMan = new AgentManagerDBImplementation();
		agMan.makeAgentInactive(agentCode);
		agMan.makeAgentInactive(agentCode2);
		// para el borrado total de ellos ir a la base de datos ya que no hay metodo de borrado
	}
	
	@Test
	/**
	 * Testeo de obtencion de agente por su ID
	 * @throws ExceptionManager
	 */
	public void testGetAgentByID() throws ExceptionManager {
		// Preparar datos
		int agentCode = 10;
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		Agent ag = agMan.getAgentByID(agentCode);
		// Preguntar por resultado assert
		assertNotNull(ag);
	}

	@Test
	/**
	 * Testeo del registro de un agente
	 * @throws ExceptionManager
	 */
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

	@Test
	/**
	 * Testeo de la modificacion de un agente
	 * @throws ExceptionManager
	 */
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

	@Test
	/**
	 * Testeo de la conversion de un agente a inactivo
	 * @throws ExceptionManager
	 */
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

	@Test
	/**
	 * Testeo de la conversion de un agente a activo
	 * @throws ExceptionManager
	 */
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

	@Test
	/**
	 * Testeo del listado de todos los agentes 
	 * @throws ExceptionManager
	 */
	public void testGetAllAgents() throws ExceptionManager {
		// Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		List<Agent> agents;

		agents = agMan.getAllAgents();
		// Preguntar por resultado assert
		assertNotNull(agents);

	}

	@Test
	/**
	 * Testeo del listado de todos los agentes activos
	 * @throws ExceptionManager
	 */
	public void testGetAllActiveAgents() throws ExceptionManager {
		// Preparar datos
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		List<Agent> agents = agMan.getAllActiveAgents();
		// Preguntar por resultado assert
		assertNotNull(agents);
	}

	@Test
	/**
	 * Testeo de logeo del agente
	 * @throws ExceptionManager
	 */
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

	@Test
	/**
	 * Testeo del listado de los compa�eros de un agente
	 * @throws ExceptionManager
	 */
	public void testGetTeammates() throws ExceptionManager {
		// Preparar datos
		int agentCode = 21;
		// String agentPasswd = "adadawd";
		AgentManager agMan = new AgentManagerDBImplementation();
		// Llamar al método a testear
		int[] agents = agMan.getTeammates(agentCode);
		// Preguntar por resultado assert
		assertNotNull(agents);
	}
}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.MapManager;
import controlador.MapManagerDBImplementation;
import exceptions.ExceptionManager;

public class MapTest {

	@Test
	public void testGetMapByName() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getMapByName(name));
	}

	@Test
	public void testGetAllMaps() throws ExceptionManager {
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAllMaps());
	}

	@Test
	public void testGetAttackMissionAgents() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionAgents(name));
	}

	@Test
	public void testGetDefendMissionAgents() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionAgents(name));
	}

	@Test
	public void testGetAttackMissionWeapon() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionWeapon(name));
	}

	@Test
	public void testGetDefendMissionWeapon() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionWeapon(name));
	}

	@Test
	public void testAgentPercentageMapAttack() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapAttack(name));
	}

	@Test
	public void testAgentPercentageMapDefend() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapDefend(name));
	}

}

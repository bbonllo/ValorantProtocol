package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controlador.MapManager;
import controlador.MapManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Map;

public class MapTest {
	
	@Before
	public void setUp() {
		String mapName = "Juan";
		String mapDesc = "afafgagag";
		Map map = new Map(mapName, mapDesc);
	}

	@Test
	public void testGetMapByName() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getMapByName(name).getMapName());
	}

	@Test
	public void testGetAllMaps() throws ExceptionManager {
		MapManager newMap = new MapManagerDBImplementation();
		ArrayList<Map> maps = (ArrayList<Map>) newMap.getAllMaps();
		assertNotNull(maps.get(0).getMapDesc());
	}

	@Test
	public void testGetAttackMissionAgents() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionAgents(name));
	}

	@Test
	public void testGetDefendMissionAgents() throws ExceptionManager {
		String name = "Haven";
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
		String name = "Haven";
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
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapDefend(name));
	}

}

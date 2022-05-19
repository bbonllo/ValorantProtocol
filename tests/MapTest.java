package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controlador.MapManager;
import controlador.MapManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Map;

public class MapTest {

	@Test
	/**
	 * Testeo de la busqueda del mapa por nombre
	 * @throws ExceptionManager
	 */
	public void testGetMapByName() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getMapByName(name).getMapName());
	}

	@Test
	/**
	 * Testeo del listado de todos los mapas
	 * @throws ExceptionManager
	 */
	public void testGetAllMaps() throws ExceptionManager {
		MapManager newMap = new MapManagerDBImplementation();
		ArrayList<Map> maps = (ArrayList<Map>) newMap.getAllMaps();
		assertNotNull(maps.get(0).getMapDesc());
	}

	@Test
	/**
	 * Testeo del listado de agentes en misiones de ataque
	 * @throws ExceptionManager
	 */
	public void testGetAttackMissionAgents() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionAgents(name));
	}

	@Test
	/**
	 * Testeo del listado de agentes en misiones de defensa
	 * @throws ExceptionManager
	 */
	public void testGetDefendMissionAgents() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionAgents(name));
	}

	@Test
	/**
	 * Testeo del listado de armas en misiones de ataque
	 * @throws ExceptionManager
	 */
	public void testGetAttackMissionWeapon() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionWeapon(name));
	}

	@Test
	/**
	 * Testeo del listado de armas en misiones de defensa
	 * @throws ExceptionManager
	 */
	public void testGetDefendMissionWeapon() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionWeapon(name));
	}

	@Test
	/**
	 * Testeo del listado del porcentaje uso agentes en misiones de ataque
	 * @throws ExceptionManager
	 */
	public void testAgentPercentageMapAttack() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapAttack(name));
	}

	@Test
	/**
	 * Testeo del listado del porcentaje uso agentes en misiones de defensa
	 * @throws ExceptionManager
	 */
	public void testAgentPercentageMapDefend() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapDefend(name));
	}

}

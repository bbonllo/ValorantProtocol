package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import controlador.MapManager;
import controlador.MapManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Map;

/**
 * @author Grupo-E
 *
 */
public class MapTest {

	/**
	 * Testeo de la busqueda del mapa por nombre
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetMapByName() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getMapByName(name).getMapName());
	}

	/**
	 * Testeo del listado de todos los mapas
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllMaps() throws ExceptionManager {
		MapManager newMap = new MapManagerDBImplementation();
		ArrayList<Map> maps = (ArrayList<Map>) newMap.getAllMaps();
		assertNotNull(maps.get(0).getMapDesc());
	}

	/**
	 * Testeo del listado de agentes en misiones de ataque
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAttackMissionAgents() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionAgents(name));
	}

	/**
	 * Testeo del listado de agentes en misiones de defensa
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetDefendMissionAgents() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionAgents(name));
	}

	/**
	 * Testeo del listado de armas en misiones de ataque
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAttackMissionWeapon() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getAttackMissionWeapon(name));
	}

	/**
	 * Testeo del listado de armas en misiones de defensa
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetDefendMissionWeapon() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.getDefendMissionWeapon(name));
	}

	/**
	 * Testeo del listado del porcentaje uso agentes en misiones de ataque
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testAgentPercentageMapAttack() throws ExceptionManager {
		String name = "Split";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapAttack(name));
	}

	/**
	 * Testeo del listado del porcentaje uso agentes en misiones de defensa
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testAgentPercentageMapDefend() throws ExceptionManager {
		String name = "Haven";
		MapManager newMap = new MapManagerDBImplementation();
		assertNotNull(newMap.agentPercentageMapDefend(name));
	}

}

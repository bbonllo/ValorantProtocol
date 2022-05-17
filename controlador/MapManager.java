package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Map;

public interface MapManager {

	public Map getMapByName(String mapName);

	public List<Map> getAllMaps() throws ExceptionManager;

	/*
	 * Para estadistica de mapas
	 */

	public List<Integer> agentPercentageMapAttack(String mapName);

	public List<Integer> agentPercentageMapDefend(String mapName);

	public List<String> getAttackMissionAgents(String mapName);

	public List<String> getDefendMissionAgents(String mapName);

	public String getAttackMissionWeapon(String mapName);

	public String getDefendMissionWeapon(String mapName);

}

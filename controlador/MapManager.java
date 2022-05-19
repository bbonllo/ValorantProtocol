package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Map;

public interface MapManager {

	public Map getMapByName(String mapName) throws ExceptionManager;

	public List<Map> getAllMaps() throws ExceptionManager;

	/*
	 * Para estadistica de mapas
	 */

	public List<Integer> agentPercentageMapAttack(String mapName) throws ExceptionManager;

	public List<Integer> agentPercentageMapDefend(String mapName) throws ExceptionManager;

	public List<String> getAttackMissionAgents(String mapName) throws ExceptionManager;

	public List<String> getDefendMissionAgents(String mapName) throws ExceptionManager;

	public String getAttackMissionWeapon(String mapName) throws ExceptionManager;

	public String getDefendMissionWeapon(String mapName) throws ExceptionManager;

}

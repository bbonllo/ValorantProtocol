package controlador;

public interface ViewManager {
	/**
	 * Metodo que abre la ventana
	 * 
	 * @param map     MapManager
	 * @param agent   AgentManager
	 * @param weapon  WeaponManager
	 * @param mission MissionManager
	 */
	public void openView(MapManager map, AgentManager agent, WeaponManager weapon, MissionManager mission);
}

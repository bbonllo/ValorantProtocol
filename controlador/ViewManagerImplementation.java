package controlador;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	/**
	 * Abrir la ventana de logeo
	 * 
	 * @param map     MapManager
	 * @param agent   AgentManager
	 * @param weapon  WeaponManager
	 * @param mission MissionManager
	 */
	public void openView(MapManager map, AgentManager agent, WeaponManager weapon, MissionManager mission) {
		VLogin vMain = new VLogin(map, agent, weapon, mission);
		vMain.setVisible(true);
	}

}

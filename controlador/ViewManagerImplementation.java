package controlador;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	/**
	 * Abrir la ventana de logeo
	 * @param map MapManager
	 * @param agent AgentManager
	 * @param weapon WeaponManager
	 */
	public void openView(MapManager map, AgentManager agent, WeaponManager weapon) {
		VLogin vMain = new VLogin(map, agent, weapon);
		vMain.setVisible(true);
	}

}

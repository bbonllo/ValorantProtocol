package controlador;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	public void openView(MapManager map, AgentManager agent, WeaponManager weapon) {
		VLogin vMain = new VLogin(map, agent, weapon);
		vMain.setVisible(true);
	}

}

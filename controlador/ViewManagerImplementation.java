package controlador;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	public void openView(MapManager map, AgentManager agent, WeaponManager weapon, MissionManager mission) {
		VLogin vMain = new VLogin(map, agent, weapon, mission);
		vMain.setVisible(true);
	}

}

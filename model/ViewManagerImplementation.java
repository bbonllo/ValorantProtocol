package model;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	public void openView(MapManager map, AgentManager agent) {
		VLogin vMain = new VLogin(map, agent);
		vMain.setVisible(true);
	}

}

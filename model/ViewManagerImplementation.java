package model;

import view.VLogin;

public class ViewManagerImplementation implements ViewManager {

	@Override
	public void openView(MapManager map) {
		VLogin vMain = new VLogin(map);
		vMain.setVisible(true);
	}

}

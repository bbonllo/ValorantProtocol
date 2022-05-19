package main;

import controlador.AgentManager;
import controlador.DataFactoryMap;
import controlador.DataFactoryMission;
import controlador.DataFactoryWeapon;
import controlador.DataFactoryAgent;
import controlador.MapManager;
import controlador.MissionManager;
import controlador.ViewManager;
import controlador.ViewManagerImplementation;
import controlador.WeaponManager;

public class Main {

	public static void main(String[] args) {
		// Data manipulation
		MapManager map = DataFactoryMap.getMapData();
		AgentManager agent = DataFactoryAgent.getAgentData();
		WeaponManager weapon = DataFactoryWeapon.getWeaponData();
		MissionManager mission = DataFactoryMission.getMissionData();

		// View manipulation
		ViewManager view = new ViewManagerImplementation();
		view.openView(map, agent, weapon, mission);
	}

}
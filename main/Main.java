package main;

import model.AgentManager;
import model.AgentManagerDBImplementation;
import model.MapManager;
import model.MapManagerDBImplementation;
import model.ViewManager;
import model.ViewManagerImplementation;
import model.WeaponManager;
import model.WeaponManagerDBImplementation;

public class Main {

	public static void main(String[] args) {
		
		// Data
		MapManager map = new MapManagerDBImplementation();
		AgentManager agent = new AgentManagerDBImplementation();
		WeaponManager weapon = new WeaponManagerDBImplementation();
		
		// View 
		ViewManager view = new ViewManagerImplementation();
		view.openView(map, agent, weapon);
		
	}

}



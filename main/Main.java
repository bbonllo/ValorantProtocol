package main;

import model.AgentManager;
import model.AgentManagerDBImplementation;
import model.MapManager;
import model.MapManagerDBImplementation;
import model.ViewManager;
import model.ViewManagerImplementation;

public class Main {

	public static void main(String[] args) {
		MapManager map = new MapManagerDBImplementation();
		AgentManager agent = new AgentManagerDBImplementation();
		
		ViewManager view = new ViewManagerImplementation();
		view.openView(map, agent);
		
	}

}



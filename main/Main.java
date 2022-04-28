package main;

import model.MapManager;
import model.MapManagerDBImplementation;
import model.ViewManager;
import model.ViewManagerImplementation;

public class Main {

	public static void main(String[] args) {
		MapManager map = new MapManagerDBImplementation();
		
		ViewManager view = new ViewManagerImplementation();
		view.openView(map);
		
	}

}



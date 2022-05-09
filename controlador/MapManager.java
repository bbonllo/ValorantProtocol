package controlador;

import java.util.Set;

import exceptions.ExceptionManager;
import model.Map;

public interface MapManager {
	
	public Map getMapByName(String mapName);
	
	public void makeStadisctic(String mapName);
	
	public Set<Map> getAllMaps() throws ExceptionManager;

}

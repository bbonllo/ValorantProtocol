package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Map;

public interface MapManager {

	public Map getMapByName(String mapName);

	public void makeStadisctic(String mapName);

	public List<Map> getAllMaps() throws ExceptionManager;

}

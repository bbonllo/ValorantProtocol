package model;

public class Map {

	private String mapName;
	private String mapDesc;

	// Constructor
	public Map() {
		super();
	}

	public Map(String mapName, String mapDesc) {
		super();
		this.mapName = mapName;
		this.mapDesc = mapDesc;
	}

	// Getters & Setters
	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapDesc() {
		return mapDesc;
	}

	public void setMapDesc(String mapDesc) {
		this.mapDesc = mapDesc;
	}

}

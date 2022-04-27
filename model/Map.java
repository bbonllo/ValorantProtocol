package model;

public class Map {

	private String mapName;
	private String mapCoords;
	private String mapDesc;

	// Constructor
	public Map() {
		super();
	}

	public Map(String mapName, String mapCoords, String mapDesc) {
		super();
		this.mapName = mapName;
		this.mapCoords = mapCoords;
		this.mapDesc = mapDesc;
	}

	// Getters & Setters
	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapCoords() {
		return mapCoords;
	}

	public void setMapCoords(String mapCoords) {
		this.mapCoords = mapCoords;
	}

	public String getMapDesc() {
		return mapDesc;
	}

	public void setMapDesc(String mapDesc) {
		this.mapDesc = mapDesc;
	}

}

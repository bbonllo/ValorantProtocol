package controlador;

public class DataFactoryMap {
	private static MapManager data;

	public static synchronized MapManager getMapData() {
		if (data == null) {
			data = new MapManagerDBImplementation();
		}
		return data;
	}

}

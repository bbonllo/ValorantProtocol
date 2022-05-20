package controlador;

public class DataFactoryMap {
	private static MapManager data;

	/**
	 * Carga la variable data, si esta no esta cargada previamente
	 * @return data Modelo de datos de tipo Mapa {@link MapManager}
	 */
	public static MapManager getMapData() {
		if (data == null) {
			data = new MapManagerDBImplementation();
		}
		return data;
	}

}

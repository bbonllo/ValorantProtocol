package controlador;

public class DataFactoryMission {
	private static MissionManager data;

	/**
	 * Carga la variable data, si esta no esta cargada previamente.
	 * @return data Modelo de datos de tipo Mision {@link MissionManager}
	 */
	public static MissionManager getMissionData() {
		if (data == null) {
			data = new MissionManagerDBImplementation();
		}
		return data;
	}

}

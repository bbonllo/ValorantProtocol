package controlador;

public class DataFactoryMission {
	private static MissionManager data;

	public static synchronized MissionManager getMissionData() {
		if (data == null) {
			data = new MissionManagerDBImplementation();
		}
		return data;
	}

}

package controlador;

public class DataFactoryAgent {
	private static AgentManager data;

	public static synchronized AgentManager getAgentData() {
		if (data == null) {
			data = new AgentManagerDBImplementation();
		}
		return data;
	}

}

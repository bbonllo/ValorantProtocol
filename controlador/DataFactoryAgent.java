package controlador;

public class DataFactoryAgent {
	private static AgentManager data;

	/**
	 * Carga la variable data, si esta no esta cargada previamente
	 * @return data Modelo de datos de tipo Agente {@link AgentManager}
	 */
	public static AgentManager getAgentData() {
		if (data == null) {
			data = new AgentManagerDBImplementation();
		}
		return data;
	}

}

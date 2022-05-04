package model;

public class Agent implements Comparable<Agent> {

	private int agentCode;
	private String agentPasswd; // no podemos tener getPasswd por razones obvias
	private String agentName;
	private String agentNationality;
	private String agentRol; /*
								 * Se controlara que solo pueda ser de uno de los 4 roles (Duelista, Iniciador,
								 * Controlador,Centinela)
								 */
	private Ability[] agentAbilities = new Ability[4]; // se controlara que no tenga mas de una habilidad ultimate;
	private boolean agentIsAdmin;
	private boolean agentIsOnMission;
	private boolean agentIsOnActive;

	/*
	 * Constructor
	 */

	public Agent() {
		super();
	}

	public Agent(int agentCode, String agentPasswd, String agentName, String agentNationality, String agentRol,
			boolean agentIsAdmin, boolean agentIsOnActive) {
		super();
		this.agentCode = agentCode;
		this.agentPasswd = agentPasswd;
		this.agentName = agentName;
		this.agentNationality = agentNationality;
		this.agentRol = agentRol;
		this.agentIsAdmin = agentIsAdmin;
		this.agentIsOnActive = agentIsOnActive;
	}

	public Agent(int agentCode, String agentPasswd, String agentName, String agentNationality, String agentRol,
			Ability[] agentAbilities, boolean agentIsAdmin, boolean agentIsOnActive) {
		super();
		this.agentCode = agentCode;
		this.agentPasswd = agentPasswd;
		this.agentName = agentName;
		this.agentNationality = agentNationality;
		this.agentRol = agentRol;
		this.agentAbilities = agentAbilities;
		this.agentIsAdmin = agentIsAdmin;
		this.agentIsOnActive = agentIsOnActive;
	}

	/*
	 * Getters & Setters
	 */

	public int getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(int agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentPasswd() {
		return agentPasswd;
	}

	public void setAgentPasswd(String agentPasswd) {
		this.agentPasswd = agentPasswd;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentNationality() {
		return agentNationality;
	}

	public void setAgentNationality(String agentNationality) {
		this.agentNationality = agentNationality;
	}

	public String getAgentRol() {
		return agentRol;
	}

	public void setAgentRol(String agentRol) {
		this.agentRol = agentRol;
	}

	public Ability[] getAgentAbilities() {
		return agentAbilities;
	}

	public void setAgentAbilities(Ability[] agentAbilities) {
		this.agentAbilities = agentAbilities;
	}

	public boolean isAgentIsAdmin() {
		return agentIsAdmin;
	}

	public void setAgentIsAdmin(boolean agentIsAdmin) {
		this.agentIsAdmin = agentIsAdmin;
	}

	public boolean isAgentIsOnActive() {
		return agentIsOnActive;
	}

	public void setAgentIsOnActive(boolean agentIsOnActive) {
		this.agentIsOnActive = agentIsOnActive;
	}

	public boolean isAgentIsOnMission() {
		return agentIsOnMission;
	}

	public void setAgentIsOnMission(boolean agentIsOnMission) {
		this.agentIsOnMission = agentIsOnMission;
	}

	@Override
	public int compareTo(Agent o) {
		if (agentCode > o.getAgentCode()) {
			return 1;
		} else if (agentCode == o.getAgentCode()) {
			return 0;
		} else
			return -1;
	}
}

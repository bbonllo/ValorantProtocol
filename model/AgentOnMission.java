package model;

public class AgentOnMission {
	// Variables 
	private int MissionCode;
	private int agentCode;
	private String WeaponName;
	
	// Constructors
	
	public AgentOnMission(int missionCode, int agentCode, String weaponName) {
		super();
		MissionCode = missionCode;
		this.agentCode = agentCode;
		WeaponName = weaponName;
	}

	// getters and setters

	public int getMissionCode() {
		return MissionCode;
	}

	public void setMissionCode(int missionCode) {
		MissionCode = missionCode;
	}

	public int getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(int agentCode) {
		this.agentCode = agentCode;
	}

	public String getWeaponName() {
		return WeaponName;
	}

	public void setWeaponName(String weaponName) {
		WeaponName = weaponName;
	}
	
}

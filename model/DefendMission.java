package model;


public class DefendMission extends Mission {
	private int defendMissionCode;
	private int defendedRadianite;

	/*
	 * Constructores
	 */

	public DefendMission() {
		super();
	}

	public DefendMission(int defendMissionCode, int defendedRadianite) {
		super();
		this.defendMissionCode = defendMissionCode;
		this.defendedRadianite = defendedRadianite;
	}

	/*
	 * Getters & Setters
	 */
	
	public int getdefendedRadianite() {
		return defendedRadianite;
	}

	public int getDefendMissionCode() {
		return defendMissionCode;
	}

	public void setDefendMissionCode(int defendMissionCode) {
		this.defendMissionCode = defendMissionCode;
	}

	public void setdefendedRadianite(int defendedRadianite) {
		this.defendedRadianite = defendedRadianite;
	}



}
package model;

public class AttackMission extends Mission {
	private static final long serialVersionUID = 1L;

	private int attackMissionCode;
	private int stolenRadianite;

	/*
	 * Constructores
	 */

	public AttackMission() {
		super();
	}

	public AttackMission(int attackMissionCode, int stolenRadianite) {
		super();
		this.attackMissionCode = attackMissionCode;
		this.stolenRadianite = stolenRadianite;
	}

	/*
	 * Getters & Setters
	 */

	public int getattackMissionCode() {
		return attackMissionCode;
	}

	public void setattackMissionCode(int attackMissionCode) {
		this.attackMissionCode = attackMissionCode;
	}

	public int getstolenRadianite() {
		return stolenRadianite;
	}

	public void setstolenRadianite(int stolenRadianite) {
		this.stolenRadianite = stolenRadianite;
	}


}
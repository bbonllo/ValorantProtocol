package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Mission implements Serializable {
	private static final long serialVersionUID = 1L;

	private int missionCode;
	private String mapName; // si nos da tiempo tener los 7 mapas + su info en ficheros ya creados
	private LocalDate missionFI; // DD/MM/AAAA
	private LocalDate missionFF; // DD/MM/AAAA
	private boolean missionFinished;

	/*
	 * Constructores
	 */

	public Mission() {
		super();
	}

	public Mission(int missionCode, String mapName, LocalDate missionFI, LocalDate missionFF, boolean missionFinished) {
		super();
		this.missionCode = missionCode;
		this.mapName = mapName;
		this.missionFI = missionFI;
		this.missionFF = missionFF;
		this.missionFinished = missionFinished;
	}

	/*
	 * Getters & Setters
	 */

	public int getMissionCode() {
		return missionCode;
	}

	public void setMissionCode(int missionCode) {
		this.missionCode = missionCode;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public LocalDate getMissionFI() {
		return missionFI;
	}

	public LocalDate getMissionFF() {
		return missionFF;
	}

	public void setMissionFF(LocalDate missionFF) {
		this.missionFF = missionFF;
	}

	public void setMissionFI(LocalDate missionFI) {
		this.missionFI = missionFI;
	}

	public boolean ismissionFinished() {
		return missionFinished;
	}

	public void setmissionFinished(boolean missionFinished) {
		this.missionFinished = missionFinished;
	}

}

package model;

import java.util.List;
import java.util.Set;

import exceptions.ExceptionManager;

public interface MissionManager {

	public Mission getMissionByCod(String codM);

	public void registerMission(Mission wMisson);

	public void modifyMisionDate(Mission modifyMission);

	public void EndMission(String codM);

	public List<Mission> getAllMissions();

	public List<Mission> getAllActiveMissions();

	public List<Mission> getAllFinishedMissions();

}

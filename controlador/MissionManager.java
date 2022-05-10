package controlador;

import java.util.List;
import java.util.Set;

import exceptions.ExceptionManager;
import model.Mission;

public interface MissionManager {

	public Mission getMissionByCod(String codM);

	public void registerMission(Mission wMisson);

	public void modifyMisionDate(Mission modifyMission);

	public void EndMission(String codM);

	public List<Mission> getAllMissions();

	public List<Mission> getAllActiveMissions();

	public List<Mission> getAllFinishedMissions();

}

package controlador;

import java.util.List;
import java.util.Set;

import exceptions.ExceptionManager;
import model.AttackMission;
import model.DefendMission;
import model.Mission;

public interface MissionManager {

	public Mission getMissionByCod(int codM);

	public int registerMission(Mission wMisson, char type);
	
	public void sendAgentToMission(int codM, int codA, String primaryWeapon, String secondaryWeapon);

	public void endMission(int codM, char type);

	public List<Mission> getAllMissions();

	public List<AttackMission> getAllAttackMissions();

	public List<DefendMission> getAllDefendMissions();

}

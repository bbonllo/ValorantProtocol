package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.AttackMission;
import model.DefendMission;
import model.Mission;

public interface MissionManager {

	public Mission getMissionByCod(int codM) throws ExceptionManager;

	public int registerMission(Mission wMisson, String type) throws ExceptionManager;
	
	public void sendAgentToMission(int codM, int codA, String primaryWeapon, String secondaryWeapon) throws ExceptionManager;

	public void endMission(int codM, String type) throws ExceptionManager;

	public List<Mission> getAllMissions() throws ExceptionManager;

	public List<AttackMission> getAllAttackMissions() throws ExceptionManager;

	public List<DefendMission> getAllDefendMissions() throws ExceptionManager;

}

package tests;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.MissionManager;
import controlador.MissionManagerDBImplementation;
import exceptions.ExceptionManager;
import model.AttackMission;
import model.DefendMission;
import model.Mission;

public class MissionTest {

	@Before
	@Test(expected = ExceptionManager.class)
	public void testRegisterMission() throws ExceptionManager {
		Mission mision = new Mission();
		mision.setMapName("Split");
		mision.setMissionFI(LocalDate.parse("2022-12-03"));
		mision.setMissionFF(LocalDate.parse("2023-12-03"));
		mision.setmissionFinished(false);
		MissionManager mm = new MissionManagerDBImplementation();
		int codMision = mm.registerMission(mision, "A");
		assertNotNull(codMision);
	}
	
	@Test
	public void testGetMissionByCod() throws ExceptionManager {
		int code = 3;
		MissionManager mm = new MissionManagerDBImplementation();	
		Mission mision = mm.getMissionByCod(code);
		assertNotNull(mision);
	}

	@Test
	public void testGetAllMissions() throws ExceptionManager {
		MissionManager mm = new MissionManagerDBImplementation();	
		List<Mission> misions = mm.getAllMissions();
		assertNotNull(misions);
	}

	@Test
	public void testGetAllAttackMissions() throws ExceptionManager {
		MissionManager mm = new MissionManagerDBImplementation();	
		List<AttackMission> misions = mm.getAllAttackMissions();
		assertNotNull(misions);
	}

	@Test
	public void testGetAllDefendMissions() throws ExceptionManager {
		MissionManager mm = new MissionManagerDBImplementation();	
		List<DefendMission> misions = mm.getAllDefendMissions();
		assertNotNull(misions);
	}

	@After
	@Test(expected = ExceptionManager.class)
	public void testEndMission() throws ExceptionManager {
		int code = 20;
		MissionManager mm = new MissionManagerDBImplementation();	
		mm.endMission(code, "A");
		Mission mision = mm.getMissionByCod(code);
		assertNotNull(mision);
	}
}

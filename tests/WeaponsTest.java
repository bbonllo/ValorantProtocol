package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.WeaponManager;
import controlador.WeaponManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Weapon;

public class WeaponsTest {
	String name = "Ares";
	int weaponDamage = 30;
	String weaponType = "Primary";
	String weaponSubType = "Machine gun";

	Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
	WeaponManager wepMan = new WeaponManagerDBImplementation();

	@Test
	public void testAddWeapon() throws ExceptionManager {
		wepMan.addWeapon(wep);
		testGetWeaponByName(name);
	}

	@Test
	public void testModifyWeapon() throws ExceptionManager {
		assertTrue(wepMan.modifyWeapon(wep));
	}

	@Test
	public void testDeleteWeapon() throws ExceptionManager {
		wepMan.deleteWeapon(name);
		testGetWeaponByName(name);
	}

	@Test
	public void testGetAllWeapon() throws ExceptionManager {
		assertNotNull(wepMan.getAllWeapon());
	}

	@Test
	public void testGetAllSidearms() throws ExceptionManager {
		assertNotNull(wepMan.getAllSidearms());
	}

	@Test
	public void testGetAllPrimary() throws ExceptionManager {
		assertNotNull(wepMan.getAllPrimary());
	}
	
	@Test
	public void testActivateWeapon() throws ExceptionManager {
		wepMan.activateWeapon(name);
		testGetWeaponByName(name);
	}

// Methods to control other methods
	public void testGetWeaponByName(String name) throws ExceptionManager {
		assertNotEquals(wep, wepMan.getWeaponByName(name));
	}
}

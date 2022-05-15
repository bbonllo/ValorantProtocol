package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.WeaponManager;
import controlador.WeaponManagerDBImplementation;
import model.Weapon;

public class WeaponsTest {
	String name = "Ares";
	int weaponDamage = 30;
	String weaponType = "Primary";
	String weaponSubType = "Machine gun";

	Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
	WeaponManager wepMan = new WeaponManagerDBImplementation();

	@Test
	public void testAddWeapon() {
		wepMan.addWeapon(wep);
		testGetWeaponByName(name);
	}

	@Test
	public void testModifyWeapon() {
		assertFalse(wepMan.modifyWeapon(wep));
	}

	@Test
	public void testDeleteWeapon() {
		wepMan.deleteWeapon(name);
		testGetWeaponByName(name);
	}

	@Test
	public void testGetAllWeapon() {
		assertNotNull(wepMan.getAllWeapon());
	}

	@Test
	public void testGetAllSidearms() {
		assertNotNull(wepMan.getAllSidearms());
	}

	@Test
	public void testGetAllPrimary() {
		assertNotNull(wepMan.getAllPrimary());
	}

// Methods to control other methods
	public void testGetWeaponByName(String name) {
		assertNotEquals(wep, wepMan.getWeaponByName(name));
	}
}

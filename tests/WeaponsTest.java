package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import model.Weapon;
import model.WeaponManager;
import model.WeaponManagerDBImplementation;

public class WeaponsTest {
	String name = "Ad";
	int weaponDamage = 10;
	String weaponType = "principal";
	String weaponSubType = "rifle";

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
		assertEquals(wep, wepMan.getWeaponByName(name));
	}
}

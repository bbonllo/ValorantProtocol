package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controlador.WeaponManager;
import controlador.WeaponManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Weapon;

public class WeaponsTest {
	
	@Before
	public void setUp() {
		String name = "Test1";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		wepMan.addWeapon(wep);
	}
	
	@After
	public void clearData() {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		String name = "klok";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		wepMan.deleteWeapon(name);
		testGetWeaponByName(wep, name);
	}
	
	@Test
	public void testAddWeapon() {
		String name = "klok";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		wepMan.addWeapon(wep);
	}

	@Test
	public void testModifyWeapon() {
		String name = "klok";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		assertFalse(wepMan.modifyWeapon(wep));
	}

	@Test
	public void testDeleteWeapon() {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		String name = "Test1";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		wepMan.deleteWeapon(name);
		testGetWeaponByName(wep, name);
	}

	@Test
	public void testGetAllWeapon() {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		assertNotNull(wepMan.getAllWeapon());
	}

	@Test
	public void testGetAllSidearms() {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		assertNotNull(wepMan.getAllSidearms());
	}

	@Test
	public void testGetAllPrimary() {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		assertNotNull(wepMan.getAllPrimary());
		}
	
	
// Methods to control other methods
	public void testGetWeaponByName(Weapon wep, String name) {
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		assertNotEquals(wep, wepMan.getWeaponByName(name));
	}
}

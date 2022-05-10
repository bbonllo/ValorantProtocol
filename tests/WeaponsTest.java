package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;

import controlador.WeaponManager;
import controlador.WeaponManagerDBImplementation;
import model.Weapon;

public class WeaponsTest {
	String name = "Ares";
	@Test
	public void testAddWeapon() {
		//Preparar datos
		String name = "Ares";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//Llamar al método a testear
		wepMan.addWeapon(wep);
		//Preguntar por resultado assert
		testGetWeaponByName(name);
	}

	@Test
	public void testModifyWeapon() {
		//Preparar datos
		String name = "Ares";
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//LLamar al método a testear
		boolean a = wepMan.modifyWeapon(wep);
		//Preguntar por el resultado assert
		assertFalse(a);
	}

	@Test
	public void testDeleteWeapon() {
		//Preparar datos
		String name = "Ares";
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//Llamar al método a testear
		wepMan.deleteWeapon(name);
		//Preguntar por resultado assert
		testGetWeaponByName(name);
	}

	@Test
	public void testGetAllWeapon() {
		//Preparar datos
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//LLamar al método a testear
		Set<Weapon> weps = wepMan.getAllWeapon();
		//Preguntar por resultado assert
		assertNotNull(weps);
	}

	@Test
	public void testGetAllSidearms() {
		//Preparar datos
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//LLamar al método a testear
		Set<String> weps = wepMan.getAllSidearms();
		//Preguntar por resultado assert
		assertNotNull(weps);
	}

	@Test
	public void testGetAllPrimary() {
		//Preparar datos
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//LLamar al método a testear
		Set<Weapon> weps = wepMan.getAllPrimary();
		//Preguntar por resultado assert
		assertNotNull(weps);
		}
	
	
// Methods to control other methods
	public void testGetWeaponByName(String name) {
		//Preparar datos
		int weaponDamage = 30;
		String weaponType = "Primary";
		String weaponSubType = "Machine gun";

		Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
		WeaponManager wepMan = new WeaponManagerDBImplementation();
		//LLamar al método a testear
		Weapon wep2 = wepMan.getWeaponByName(name);
		//Preguntar por resultado assert
		assertNotEquals(wep, wep2);
	}
}

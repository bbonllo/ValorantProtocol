package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import controlador.WeaponManager;
import controlador.WeaponManagerDBImplementation;
import exceptions.ExceptionManager;
import model.Weapon;

/**
 * @author Grupo-E
 *
 */
public class WeaponsTest {
	/**
	 * 
	 */
	String name = "cloack";
	/**
	 * 
	 */
	int weaponDamage = 30;
	/**
	 * 
	 */
	String weaponType = "Primary";
	/**
	 * 
	 */
	String weaponSubType = "Machine gun";

	/**
	 * 
	 */
	Weapon wep = new Weapon(name, weaponDamage, weaponType, weaponSubType, false);
	/**
	 * 
	 */
	WeaponManager wepMan = new WeaponManagerDBImplementation();

	/**
	 * Testeo de la insercion de un arma
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testAddWeapon() throws ExceptionManager {
		wepMan.addWeapon(wep);
		testGetWeaponByName(name);
	}

	/**
	 * Testeo de la modificacion de un arma
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testModifyWeapon() throws ExceptionManager {
		assertTrue(wepMan.modifyWeapon(wep));
	}

	/**
	 * Testeo del borrado de un arma
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testDeleteWeapon() throws ExceptionManager {
		wepMan.deleteWeapon(name);
		testGetWeaponByName(name);
	}

	/**
	 * Testeo del listado de todas las armas
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllWeapon() throws ExceptionManager {
		assertNotNull(wepMan.getAllWeapon());
	}

	/**
	 * Testeo del listado de las armas secundarias
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllSidearms() throws ExceptionManager {
		assertNotNull(wepMan.getAllSidearms());
	}

	/**
	 * Testeo del listado de las armas primarias
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testGetAllPrimary() throws ExceptionManager {
		assertNotNull(wepMan.getAllPrimary());
	}

	/**
	 * Testeo de la activacion de un arma borrada anteriormente
	 * 
	 * @throws ExceptionManager
	 */
	@Test
	public void testActivateWeapon() throws ExceptionManager {
		wepMan.activateWeapon(name);
		testGetWeaponByName(name);
	}

// Methods to control other methods
	/**
	 * Metodo complementario para testear otros metodos que no devuelven nada
	 * 
	 * @param name
	 * @throws ExceptionManager
	 */
	public void testGetWeaponByName(String name) throws ExceptionManager {
		assertNotEquals(wep, wepMan.getWeaponByName(name));
	}
}

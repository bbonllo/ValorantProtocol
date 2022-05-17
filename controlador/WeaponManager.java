package controlador;

import java.util.List;

import exceptions.ExceptionManager;
import model.Weapon;

public interface WeaponManager {
	public void addWeapon(Weapon weapon) throws ExceptionManager;

	public Weapon getWeaponByName(String name) throws ExceptionManager;

	public boolean modifyWeapon(Weapon weapon) throws ExceptionManager;

	public void deleteWeapon(String name) throws ExceptionManager;

	public List<Weapon> getAllWeapon() throws ExceptionManager;

	public List<Weapon> getAllSidearms() throws ExceptionManager;

	public List<Weapon> getAllPrimary() throws ExceptionManager;
}

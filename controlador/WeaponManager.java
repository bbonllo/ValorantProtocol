package controlador;

import java.util.List;

import model.Weapon;

public interface WeaponManager {
	public void addWeapon(Weapon weapon);

	public Weapon getWeaponByName(String name);

	public boolean modifyWeapon(Weapon weapon);

	public void deleteWeapon(String name);

	public List<Weapon> getAllWeapon();

	public List<String> getAllSidearms();

	public List<Weapon> getAllPrimary();
}

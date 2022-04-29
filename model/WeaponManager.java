package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public interface WeaponManager {
	public void addWeapon(Weapon weapon);
	public Weapon getWeaponByName(String name);
	public boolean modifyWeapon(Weapon weapon);
	public void deleteWeapon(String name);
	public Set<Weapon> getAllWeapon();
	public Set<String> getAllSidearms();
	public Set<Weapon> getAllPrimary();
}

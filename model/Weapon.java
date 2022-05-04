package model;

public class Weapon {
	// Variables
	
	private String weaponName;
	private int weaponDamage;
	private String weaponType;
	private String weaponSubType;
	private boolean weaponIsActive;
	
	// Constructor
	
	public Weapon(String weaponName, int weaponDamage, String weaponType, String weaponSubType,
			boolean weaponIsActive) {
		super();
		this.weaponName = weaponName;
		this.weaponDamage = weaponDamage;
		this.weaponType = weaponType;
		this.weaponSubType = weaponSubType;
		this.weaponIsActive = weaponIsActive;
	}
	
	public Weapon() {
		// TODO Auto-generated constructor stub
	}
	
	// getters y setters
	
	public String getWeaponName() {
		return weaponName;
	}
	
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}
	
	public int getWeaponDamage() {
		return weaponDamage;
	}
	
	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}
	
	public String getWeaponType() {
		return weaponType;
	}
	
	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	
	public String getWeaponSubType() {
		return weaponSubType;
	}
	
	public void setWeaponSubType(String weaponSubType) {
		this.weaponSubType = weaponSubType;
	}
	
	public boolean isWeaponIsActive() {
		return weaponIsActive;
	}
	
	public void setWeaponIsActive(boolean weaponIsActive) {
		this.weaponIsActive = weaponIsActive;
	}
	
	
}

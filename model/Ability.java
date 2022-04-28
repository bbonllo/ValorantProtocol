package model;



public class Ability {

	private String abilityName;
	private String abilityDescription;

	// Constructor
	public Ability() {
		super();
	}

	public Ability(String abilityName, String abilityDescription) {
		super();
		this.abilityName = abilityName;
		this.abilityDescription = abilityDescription;
	}

	// Getters & Setters
	public String getAbilityName() {
		return abilityName;
	}

	public void setAbilityName(String abilityName) {
		this.abilityName = abilityName;
	}

	public String getAbilityDescription() {
		return abilityDescription;
	}

	public void setAbilityDescription(String abilityDescription) {
		this.abilityDescription = abilityDescription;
	}

}

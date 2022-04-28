package model;

public class AbilityUltimate extends Ability {

	private int abilityUltimateRequiredOrbs;

	// Constructor
	public AbilityUltimate() {
		super();
	}

	public AbilityUltimate(int abilityUltimateRequiredOrbs, String abilityName, String abilityDescription) {
		super(abilityName, abilityDescription);
		this.abilityUltimateRequiredOrbs = abilityUltimateRequiredOrbs;
	}

	// Getters & Setters
	public int getAbilityUltimateRequiredOrbs() {
		return abilityUltimateRequiredOrbs;
	}

	public void setAbilityUltimateRequiredOrbs(int abilityUltimateRequiredOrbs) {
		this.abilityUltimateRequiredOrbs = abilityUltimateRequiredOrbs;
	}

	
}

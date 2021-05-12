package decoratorPattern;

import base.*;
import base.Character;

public abstract class ActiveItemDecorator extends ItemDecorator { //Objetos que dotan al personaje de habilidades activas
	
	private String skillName; //Nombre de la habilidad
	protected ActionType actionType;
	protected SkillType skillType;
	
	public ActiveItemDecorator() {
		super();
	}
	
	public ActiveItemDecorator(Item equipment, String name, String skillName, Stats stats, ActionType actionType, SkillType skillType, Tier tier) {
		super(equipment, name, stats, tier);
		this.skillName = skillName;
		this.setActionType(actionType);
		this.setSkillType(skillType);
	}
	
	public abstract void useSkill(Character user, Character target); //Efecto de la habilidad
	
	public void inform(Character user, Character target) {
		System.out.println(user.getName()+" uses "+ skillName + " on "+ target.getName());
	}

	public String getSkillname() {
		return skillName;
	}

	public void setSkillname(String skillName) {
		this.skillName = skillName;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}

	public ActionType getActionType() {
		return actionType;
	}

	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}

	

	
	
}

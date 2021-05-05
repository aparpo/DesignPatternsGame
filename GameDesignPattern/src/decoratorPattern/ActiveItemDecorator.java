package decoratorPattern;

import base.ActionType;
import base.Character;
import base.SkillType;
public abstract class ActiveItemDecorator extends ItemDecorator { //Objetos que dotan al personaje de habilidades activas
	
	private String skillname; //Nombre de la habilidad
	protected ActionType actionType;
	protected SkillType skillType;
	
	public ActiveItemDecorator(Equipment equipment, String name, String skillName, int life, int maxLife, int attack, int defense, int speed,
			ActionType actionType, SkillType skillType) {
		super(equipment, name, life, maxLife, attack, defense, speed);
		this.skillname = skillName;
		this.setActionType(actionType);
		this.setSkillType(skillType);
	}
	
	public abstract void useSkill(Character user, Character target); //Efecto de la habilidad

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
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

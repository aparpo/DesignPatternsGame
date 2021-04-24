package decoratorPattern;

import base.Character;

public class Action {
	private Stats variation;
	private ActionType actionType;
	private SkillType skillType;
	private Character target;
	
	public Action(Stats variation, ActionType actionType, SkillType skillType, Character target) {
		this.variation = variation;
		this.actionType = actionType;
		this.skillType = skillType;
		this.target = target;
	}
	
	public Stats getVariation() {
		return variation;
	}
	public void setVariation(Stats variation) {
		this.variation = variation;
	}
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public SkillType getSkillType() {
		return skillType;
	}
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
	public Character getTarget() {
		return target;
	}
	public void setTarget(Character target) {
		this.target = target;
	}
	
}

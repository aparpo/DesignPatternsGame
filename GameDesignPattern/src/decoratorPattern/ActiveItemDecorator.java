package decoratorPattern;

import base.Character;
public abstract class ActiveItemDecorator extends ItemDecorator {
	
	private String skillname;
	
	public ActiveItemDecorator(Item equipment, String name, String skillName, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
		this.skillname = skillName;
	}
	
	public abstract void useSkill(Character user, Character target);

	public String getSkillname() {
		return skillname;
	}

	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}

	

	
	
}

package decoratorPattern;

import base.ActionType;
import base.EquipmentTier;
import base.SkillType;

public abstract class UsableItemDecorator extends ActiveItemDecorator { //Objeto con activa que se puede usar un numero finito de veces
	protected int amount;
	
	public UsableItemDecorator(Equipment equipment, String name, String skillName, int life, int maxLife, int attack, int defense, int speed,
			ActionType actionType, SkillType skillType,EquipmentTier equipmentTier, int amount) {
		super(equipment, name, skillName, life, maxLife, attack, defense, speed, actionType, skillType, equipmentTier);
		this.amount = amount;
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}

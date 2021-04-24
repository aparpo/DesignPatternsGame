package base;

import decoratorPattern.Item;

public abstract class Character {
	protected String name;
	protected Item equipment;
	public Item getEquipment() {
		return equipment;
	}
	public void setEquipment(Item equipment) {
		this.equipment = equipment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

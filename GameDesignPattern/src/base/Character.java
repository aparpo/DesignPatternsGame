package base;

import decoratorPattern.*;

public abstract class Character {
	protected String name;
	protected Item equipment = new Stats();
	
	public Character(String name, Item equipment) {
		this.name = name;
		this.equipment = equipment;
	}

	public Item getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Item equipment) {
		System.out.println("Actual equipment"+equipment.getClass());
		this.equipment = equipment;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}

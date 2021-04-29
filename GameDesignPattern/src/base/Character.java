package base;

import decoratorPattern.*;

public abstract class Character {
	protected String name;
	protected Equipment equipment = new Stats();
	
	public Character(String name) {
		this.name = name;		
	}

	public Equipment getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Equipment equipment) {
		System.out.println("Actual equipment" + equipment.getClass());
		this.equipment = equipment;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void decision();
	
}

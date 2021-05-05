package base;

import java.util.ArrayList;
import java.util.List;

import decoratorPattern.*;
import statePattern.*;

public abstract class Character {
	protected String name;
	private State state;
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
	
	public Action StatusEffect(Action action) {
		return state.effect(action);
	}
	
	public Stats modifyStats() {
		List<PassiveItemDecorator> list = new ArrayList<PassiveItemDecorator>();
		Stats aux = new Stats(equipment.getLife(),equipment.getMaxLife(), equipment.getAttack(),equipment.getDefense(), equipment.getSpeed());
		list = equipment.areThereAnyPassives(list);
		for(int i=0; i < list.size(); i++) {
			aux = ((PassiveItemDecorator) list.get(i)).modifyStats(aux);
		}
		return aux;
	}
	
	public void applyStats(Stats variation) {
		equipment.applyStats(variation);
	}
	
	public abstract void decision();
	
}

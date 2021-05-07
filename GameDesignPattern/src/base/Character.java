package base;

import java.util.ArrayList;
import java.util.List;

import decoratorPattern.*;
import singletonPattern.GameManager;
import statePattern.*;

public abstract class Character {
	protected String name;
	protected State state;
	protected Item equipment;
	
	public Character(String name) {
		super();
		this.name = name;
		this.state = new State();
		this.equipment = new Stats();
	}

	public abstract void decision();
	
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
	
	public void backToNormal() {
		equipment.backToNormal();
	}
	
	public boolean isAlive() {
		if(equipment.getLife()>0) {
			return true;
		}
		return false;
	}
	
	public Item getEquipment() {
		return equipment;
	}
	
	public void setEquipment(Item equipment) {
		System.out.println("Actual equipment" + equipment.getClass());
		this.equipment = equipment;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public State getState() {
		return state;
	}
	
	
}

package decoratorPattern;

import java.util.ArrayList;
import java.util.List;

import base.*;

public abstract class ItemDecorator implements Item{
	protected Item equipment;
	protected int life=0;
	protected int maxLife=0;
	protected int attack=0;
	protected int defense=0;
	protected int speed=0;
	protected String desc;
	protected String name;
	protected Tier tier;
	
	public ItemDecorator() {
		super();
	}
	public ItemDecorator(Item equipment, String name,  int life, int maxLife, int attack, int defense, int speed, Tier tier) {
		this.equipment = equipment;
		this.life = life;
		this.maxLife = maxLife;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.name = name;
		this.tier = tier;
	}
	
	//Metodo para añadir un item sin que haya repeticiones
	public Item addItem(ItemDecorator newItem) { 
		Item aux = isThereAny(newItem);
		if(aux==null) { //No hay items del mismo tipo equipados
			newItem.setEquipment(this); //Decorar
			return newItem;
		}else { //Hay un item del mismo tipo equipado
			if(newItem instanceof UsableItemDecorator) { //El objeto es un consumible
				((UsableItemDecorator) aux).addAmount(((UsableItemDecorator) newItem).getAmount()); //Aumentar su cantidad
				return this;
			}else { //En cualquier otro caso, crear una copia sin habilidades, solo estadisticas
				Stats newItemCopy = new Stats(newItem.getLife(), newItem.getMaxLife(), newItem.getAttack(), newItem.getDefense(), newItem.getSpeed());
				ItemDecorator regularVersion = new RegularItem(this, newItem.getName()+" Repeated", newItemCopy);
				return regularVersion;
			}
			
		}
		
	}
	
	public Item isThereAny(Item model){
		if(this.getClass() == model.getClass()) { //Si son de la misma clase devuelve el objeto
			return this;
		}else {
			return equipment.isThereAny(model);	
		}
		
	}
	
	public List<ActiveItemDecorator> areThereAnyActives(List<ActiveItemDecorator> list){
		if(this instanceof ActiveItemDecorator) { //Si es un objeto con activa lo añade a la lista
			list.add((ActiveItemDecorator) this);
		}
		
		return equipment.areThereAnyActives(list); //Llamada recursiva
	}
	public List<PassiveItemDecorator> areThereAnyPassives(List<PassiveItemDecorator> list){
		if(this instanceof PassiveItemDecorator) {//Si es un objeto con pasiva lo añade a la lista
			list.add((PassiveItemDecorator) this);
		}
		
		return equipment.areThereAnyPassives(list);//Llamada recursiva
	}
	
	public void applyStats(Stats variation) { //Solo se aplican en el componente base
		equipment.applyStats(variation);
	}
	
	public void backToNormal() { //Solo se aplica en el componente base
		equipment.backToNormal();
	}
	
	public Item getEquipment() {
		return equipment;
	}
	public void setEquipment(Item equipment) {
		this.equipment = equipment;
	}
	public int getLife() {
		try { //Excepcion para instancias de decoradores que aun no tienen objeto decorado
			return equipment.getLife()+life;
		}catch(NullPointerException e) {
			return 0+life;
		}
		
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAttack() {
		try { //Excepcion para instancias de decoradores que aun no tienen objeto decorado
			return equipment.getAttack()+attack;
		}catch(NullPointerException e) {
			return 0+attack;
		}
		
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		try { //Excepcion para instancias de decoradores que aun no tienen objeto decorado
			return equipment.getDefense()+defense;
		}catch(NullPointerException e) {
			return 0+defense;
		}
		
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSpeed() {
		try { //Excepcion para instancias de decoradores que aun no tienen objeto decorado
			return equipment.getSpeed()+speed;
		}catch(NullPointerException e) {
			return 0+speed;
		}
		
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMaxLife() {
		try { //Excepcion para instancias de decoradores que aun no tienen objeto decorado
			return equipment.getMaxLife()+maxLife;
		}catch(NullPointerException e) {
			return 0+maxLife;
		}
		
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return equipment.getDesc()+desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Tier getTier() {
		return tier;
	}
	
	public void setTier(Tier tier) {
		this.tier = tier;
	}
	
}

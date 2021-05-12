package base;

import java.util.List;

import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Item;
import decoratorPattern.ItemDecorator;
import decoratorPattern.PassiveItemDecorator;
import decoratorPattern.Tier;

public class Stats implements Item{ //Componente base 
	private int life=0;
	private int maxLife=0;
	private int attack=0;
	private int defense=0;
	private int speed=0;
	private String desc;
	
	public Stats() {
		super();
	}
	
	public Stats(int life, int maxLife, int attack, int defense, int speed) {
		super();
		this.life = life;
		this.maxLife = maxLife;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}
	
	public String toString() {
		return "(Life: " + life + ", Att: " + attack + ", Def: " + defense + ", Speed: " + speed + ")";
		
	}
	
	public void applyStats(Stats variation) { //Aplicar una variacion de estadisticas
		life+=variation.getLife();
		maxLife+=variation.getMaxLife();
		attack+=variation.getAttack();
		defense+=variation.getDefense();
		speed+=variation.getSpeed();
	}
	
	public void backToNormal() { //Devolver al estado basico todas las estadisticas menos la vida actual
		maxLife=0;
		attack = 0;
		defense = 0;
		speed = 0;
	}
	
	@Override
	public Item addItem(ItemDecorator newItem) {
		newItem.setEquipment(this);
		return newItem;
	}
	
	public Item isThereAny(Item model){
		return null; //Se ha llegado al final y no se ha encontrado un model
		
	}

	public List<ActiveItemDecorator> areThereAnyActives(List<ActiveItemDecorator> list){
		return list; //Se ha llegado al final y se devuelve la lista de los encontrados
	}

	public List<PassiveItemDecorator> areThereAnyPassives(List<PassiveItemDecorator> list){
		return list; //Se ha llegado al final y se devuelve la lista de los encontrados
	}
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getMaxLife() {
		return maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public Tier getTier() {
		return null;
	}

	@Override
	public String getName() {
		return "";
	}

	
}

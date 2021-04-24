package decoratorPattern;

import java.util.List;

public abstract class ItemDecorator implements Item{
	Item equipment;
	protected int life=0;
	protected int maxLife=0;
	protected int attack=0;
	protected int defense=0;
	protected int speed=0;
	protected String desc;
	protected String name;
	
	public ItemDecorator(Item equipment, String name,  int life, int maxLife, int attack, int defense, int speed) {
		this.life = life;
		this.maxLife = maxLife;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.name = name;
	}
	
	/*public <T extends Item> List<T> isThereAny(List<T> list){
		if(this instanceof T) {
			list.add((T) this);
		}
		return equipment.isThereAny(list);
	}*/
	
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
		return equipment.getLife()+life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAttack() {
		return equipment.getAttack()+attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return equipment.getDefense()+defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getSpeed() {
		return equipment.getSpeed()+speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMaxLife() {
		return equipment.getMaxLife()+maxLife;
	}
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public String getDesc() {
		return equipment.getDesc()+desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

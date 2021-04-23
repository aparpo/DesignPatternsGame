package DecoratorPattern;

public abstract class ItemDecorator implements Item{
	Item equipment;
	int life;
	int attack;
	int defense;
	int speed;
	
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
	
}

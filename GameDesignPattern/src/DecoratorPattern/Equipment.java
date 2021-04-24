package DecoratorPattern;

import java.util.List;

public class Equipment implements Item{
	
	private int life=0;
	private int maxLife=0;
	private int attack=0;
	private int defense=0;
	private int speed=0;
	private String desc;
	
	public Equipment() {
		super();
	}
	
	public Equipment(int life, int maxLife, int attack, int defense, int speed) {
		super();
		this.life = life;
		this.maxLife = maxLife;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
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



}

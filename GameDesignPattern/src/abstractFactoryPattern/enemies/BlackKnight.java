package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class BlackKnight extends Enemy{
	protected String weaponType;

	public BlackKnight(String name, Stats stats, ActiveItemDecorator weapon, String weaponType) {
		super(name, stats, weapon);
		this.weaponType = weaponType;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(String weaponType) {
		this.weaponType = weaponType;
	}
	
}

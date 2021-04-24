package decoratorPattern;

public abstract class PassiveItemDecorator extends ItemDecorator {

	public PassiveItemDecorator(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}
	
	public abstract Stats modifyStats(int life, int maxLife, int attack, int defense, int speed);
	
	public Stats modifyStats(Stats equipment) {
		return modifyStats(equipment.getLife(),equipment.getMaxLife(), equipment.getAttack(), equipment.getDefense(), equipment.getSpeed());
	}

}

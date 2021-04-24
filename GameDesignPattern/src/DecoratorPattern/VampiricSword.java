package DecoratorPattern;

public class VampiricSword extends PassiveItemDecorator{

	public VampiricSword(Item equipment) {
		super(equipment, "Vampiric Sword", 0, 0, 20, 0, 0);
	}
	

	@Override
	public Equipment modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		life+=0.1*attack; //Restores health based on attack
		if(life > maxLife) {
			life=maxLife;
		}
		return new Equipment(life, maxLife, attack, defense, speed);
	}

}

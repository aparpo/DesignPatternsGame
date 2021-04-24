package decoratorPattern;

public class RegularItem extends ItemDecorator{ //Decoradores que solo modifican las estadisticas
	
	public RegularItem(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}

}

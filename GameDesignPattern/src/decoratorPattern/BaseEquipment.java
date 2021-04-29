package decoratorPattern;

public class BaseEquipment extends ItemDecorator{ //Decoradores que solo modifican las estadisticas
	
	public BaseEquipment(Equipment equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}

}

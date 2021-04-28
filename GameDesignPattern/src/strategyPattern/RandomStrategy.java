package strategyPattern;
import java.util.ArrayList;
import java.util.List;

import base.Character;
import decoratorPattern.ActiveItemDecorator;

public class RandomStrategy implements ActionStrategy{

	public void decision(Character user, Character player) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list); //Conseguir todos los items con habilidades de activas
		list.get((int) Math.random()* list.size()).useSkill(user, player); //Elegir uno aleatorio y lanzar su habilidad
	}

}

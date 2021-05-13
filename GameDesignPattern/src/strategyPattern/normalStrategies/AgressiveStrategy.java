package strategyPattern.normalStrategies;

import java.util.List;

import base.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import singletonPattern.GameManager;
import strategyPattern.*;

public class AgressiveStrategy extends DecisionTemplate{

	@Override
	protected int worthAttack(Enemy user, Player player) {
		int worth = 2;
		
		//Va a hacer mas daño que su oponente
		if(user.getEquipment().getAttack() > player.getEquipment().getAttack()) worth++;
		
		//Va a hacer bastante daño a su oponente
		if(user.getEquipment().getAttack() > player.getEquipment().getDefense()) worth++;
		
		//Tiene vida de sobra
		if(user.getEquipment().getLife() > user.getEquipment().getMaxLife()*0.75) worth++;
		
		//Hay al menos dos aliados mas en el bando enemigo con vida
		if(GameManager.getManager().getCharacters().size() > 3) worth++;
		
		return worth;
	}

	@Override
	protected int worthDefend(Enemy user, Player player) {
		int worth = 1;
		
		//Le queda muy poca vida
		if(user.getEquipment().getLife() < user.getEquipment().getMaxLife()*0.25) worth++;
		
		//Tiene poco ataque comparado con su defensa
		if(user.getEquipment().getDefense() > user.getEquipment().getAttack()) worth++;
		
		return worth;
	}

	@Override
	protected int worthNeutral(Enemy user, Player player) {
		int worth = 0;
		
		if(user.getEquipment().isThereAny(new Potion())==null) return worth; //No quedan pociones para curarse
		//Le queda poca vida
		if(user.getEquipment().getLife() < user.getEquipment().getMaxLife()*0.5) worth++;
		
		return worth;
	}

	@Override
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int total = 0; //Total de prioridades
		//double chance = Math.random(); //probabilidad de eleccion (entre 0 y 1)
		int aux; //Accion elegida
		ActionType action = null; //Tipo de habilidad elegido
		for(int i = 0; i < options.length; i++) {
			total += options[i];
		}
		int chance = (int) (Math.random()*(total+1));//probabilidad de eleccion (entre 0 y total+1, esto para que el numero limite sea total)
		if(chance < options[0]) action = ActionType.OFFENSIVE; //Proporicion de ataque
		else if(chance < options[0]+options[1]/*(options[0] +options[1])/total*/) action = ActionType.DEFENSIVE; //Proporcion de defensa
		else action = ActionType.NEUTRAL; //Proporcion de neutral
		
		while(true) {
			aux = (int)Math.random() * skills.size(); //Habilidad aleatoria
			if(skills.get(aux).getActionType() == action) { //Que concuerde con la decision
				skills.get(aux).useSkill(user, target); //Se usa la habilidad
				return;
			}else {
				skills.remove(aux); //Se elimina de la lista temporal para agilizar
			}
		}
		
		
		
	}
	
	public String toString() {
		return "Agressive";
	}

}

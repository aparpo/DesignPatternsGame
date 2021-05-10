package strategyPattern.normalStrategies;

import java.util.List;

import base.ActionType;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.items.Potion;
import singletonPattern.GameManager;
import strategyPattern.DecisionTemplate;

public class DefensiveStrategy extends DecisionTemplate{

	
	protected int worthAttack(Enemy user, Player player) {
		int worth = 1;
		
		//Va a hacer mas da�o que su oponente
		if(user.getEquipment().getAttack() > player.getEquipment().getAttack()) worth++;
		
		return worth;
	}

	
	protected int worthDefend(Enemy user, Player player) {
		int worth = 2;
		
		//Le queda muy poca vida
		if(user.getEquipment().getLife() < user.getEquipment().getMaxLife()*0.25) worth++;
		
		//Tiene poco ataque comparado con su defensa
		if(user.getEquipment().getDefense() > user.getEquipment().getAttack()) worth++;
		
		//Si su armadura cubre todo el da�o
		if(user.getEquipment().getAttack() < player.getEquipment().getDefense()) worth++;
		
		//Si es el ultimo del bando enemigo con vida
		if(GameManager.getManager().getCharacters().size()==2) worth +=2;
		return worth;
	}

	
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
		double chance = Math.random(); //probabilidad de eleccion (entre 0 y 1)
		int aux; //Accion elegida
		ActionType action = null; //Tipo de habilidad elegido
		for(int i = 0; i < options.length; i++) {
			total += options[i];
		}
		if(chance < options[0]/total) action = ActionType.OFFENSIVE; //Proporicion de ataque
		else if(chance < (options[0] +options[1])/total) action = ActionType.DEFENSIVE; //Proporcion de defensa
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
	
}
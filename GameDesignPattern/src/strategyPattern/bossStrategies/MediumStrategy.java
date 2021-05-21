package strategyPattern.bossStrategies;
import java.util.ArrayList;
import java.util.List;
import base.ActionType;
import base.Character;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import strategyPattern.DecisionTemplate;

public class MediumStrategy extends DecisionTemplate{

	private void attack(Enemy user, Character player, List<ActiveItemDecorator> skills) {
		skills.get(objectType(ActionType.OFFENSIVE, user)).useSkill(user, player);
	}
	private void defense(Enemy user, Character player, List<ActiveItemDecorator> skills) {
		skills.get(objectType(ActionType.DEFENSIVE, user)).useSkill(user, player);
	}
	private void neutral(Character user, Character player, List<ActiveItemDecorator> skills) {
		skills.get(objectType(ActionType.NEUTRAL, user)).useSkill(user, player);
	}
	
	//Funcion que comprueba que tan "rentable" es defender (no tiene en cuenta objetos al contrario del HardStrategy)
	protected int worthDefend(Enemy user, Player player) {

		int i = 0;
		// Comprueba si el ataque del jugador es mayor a la defensa del enemigo
		if(player.getEquipment().getAttack() > user.getEquipment().getDefense()*1.3) {
			i++;
		}
		// Comprueba si la vida del enemigo es menor al 75%
		if(user.getEquipment().getLife() < 0.75* user.getEquipment().getLife()) {
			i++;
		}
		return i;
	}
	
	//Funcion que comprueba que tan "rentable" es atacar (no tiene en cuenta objetos al contrario del HardStrategy)
	protected int worthAttack(Enemy user, Player player) {
		int i = 0;
		// Comprueba que el ataque del enemigo seaa mejor que la defensa del jugador
		if(user.getEquipment().getAttack() > player.getEquipment().getDefense()) {
			i++;
		}
		// Comprueba si el enemigo puede aguantar 3 ataques o no
		if(user.getEquipment().getAttack()*3 > player.getEquipment().getLife()) {
			i++;
		}
		return i;
	}
	
	protected int worthNeutral(Enemy user, Player player) {
		if(objectType(ActionType.NEUTRAL, user) != -1) {
			return 1;
		}else {
			return 0;
		}	
	}

	// Esta funcion devuelve la posicion del primer equipment del tipo que le pases
	public int objectType(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return i;
			}
		}
		return -1;
	}
	
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int total = 0;
		options[0] *=1.5;	// Este multiplicador hace ms agresivo a la IA
		for(int i =0; i < options.length; i++) {
			total += options[i];
		}
		int random = (int)Math.random()*(total+1);
		if(random < options[0]) {
			attack(user, target, skills);
		}else if(random < options[0] + options[1]) {
			defense(user, target, skills);
		}else {
			neutral(user, target,skills);
		}
		
	}
}

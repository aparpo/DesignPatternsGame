package strategyPattern;
import java.util.List;

import base.Character;
import base.Enemy;
import decoratorPattern.ActiveItemDecorator;
public interface StrategyTemplate {
	public int worthAttack(Character enemy, Character player);
	public int worthDefend(Character enemy, Character player);
	public void attack(Enemy user, Character player, List<ActiveItemDecorator> skills);
	public void defense(Enemy user, Character player, List<ActiveItemDecorator> skills);
	public void neutral(Character user, Character player);
}

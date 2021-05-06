package strategyPattern;
import base.Character;
import base.Enemy;
public interface StrategyTemplate {
	public int worthAttack(Character enemy, Character player);
	public int worthDefense(Character enemy, Character player);
	public void attack(Enemy user, Character player);
	public void defense(Enemy user, Character player);
	public void neutral(Character user, Character player);
}

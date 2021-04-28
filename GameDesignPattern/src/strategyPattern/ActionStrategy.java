package strategyPattern;
import base.Character;
public interface ActionStrategy {
	public void decision(Character user, Character player);
}

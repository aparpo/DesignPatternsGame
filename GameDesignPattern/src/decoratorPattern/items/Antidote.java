package decoratorPattern.items;

import base.Action;
import base.ActionType;
import base.Character;
import base.SkillType;
import base.Stats;
import decoratorPattern.Item;
import decoratorPattern.Tier;
import decoratorPattern.UsableItemDecorator;
import singletonPattern.GameManager;
import statePattern.States;

public class Antidote extends UsableItemDecorator{ //Cambia a estado standard si es posible 
	
	public Antidote(Item equipment, int amount) {
		super(equipment, "Antidote", "Use antidote", new Stats(0, 0, 0, 0, 0),ActionType.NEUTRAL, SkillType.MAGIC,Tier.C, amount);
	}
	public Antidote(int amount) {
		this(null, amount);
	}
	public Antidote() {
		this(null,0);
	}

	@Override
	public void useSkill(Character user, Character target) {
		if(amount > 0) { //Quedan antidotos
			target.getState().setSuggestion(States.STANDARD);	
			informPlayer(user,target);
			amount--;
		}
		
	}
}

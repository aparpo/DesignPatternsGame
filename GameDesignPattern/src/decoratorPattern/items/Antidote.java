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

public class Antidote extends UsableItemDecorator{ //Cura 50 de vida 
	
	public Antidote(Item equipment, int amount) {
		super(equipment, "Antidore", "Use antidote", 0, 0, 0, 0, 0,ActionType.NEUTRAL, SkillType.MAGIC,Tier.C, amount);
	}
	
	public Antidote() {
		super();
	}

	@Override
	public void useSkill(Character user, Character target) {
		if(amount > 0) { //Quedan antidotos
			target.getState().setSuggestion(States.STANDARD);	
		}
		
	}
}

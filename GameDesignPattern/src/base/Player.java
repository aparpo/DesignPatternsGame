package base;

import java.util.List;
import java.util.Scanner;

import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.RegularItem;

public class Player extends Character{
	
	private ActiveItemDecorator nextSkill;
	private Character target;

	public Player(String name) {
		super(name);
		addItem(new RegularItem(new Stats(100,100,50,40,2)));
	}

	public void decision() {
		nextSkill.useSkill(this, target);
	}
	
	public void selectItem(List<ActiveItemDecorator> skills, List<Character> characters) {
		Scanner scanner = new Scanner(System.in);
		int option; 
		
		System.out.println("Select a skill to use:");
		for(int i = 0; i < skills.size(); i++) {
			System.out.println(i + ":"+skills.get(i).getSkillname());
		}
		
		do {
			option = scanner.nextInt();
		}while(option < 0 || option > skills.size());
		
		setNextSkill(skills.get(option));
		
		System.out.println("Select the target:");
		for(int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i));
		}
		
		do {
			option = scanner.nextInt();
		}while(option < 0 || option > characters.size());
		
		setTarget(characters.get(option));
		
	}

	public ActiveItemDecorator getNextSkill() {
		return nextSkill;
	}

	public void setNextSkill(ActiveItemDecorator nextSkill) {
		this.nextSkill = nextSkill;
	}

	public Character getTarget() {
		return target;
	}

	public void setTarget(Character target) {
		this.target = target;
	}
}

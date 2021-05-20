package singletonPattern;

import java.util.List;
import java.util.Scanner;

import base.Character;
import base.Player;
import decoratorPattern.ActiveItemDecorator;

public class ConsoleDisplay implements DisplayStrategy{

	@Override
	public void informPlayer(String data) {
		System.out.println(data);
	}

	@Override
	public void askPlayer(Player player, List<ActiveItemDecorator> skills, List<Character> characters) {
		Scanner scanner = new Scanner(System.in);
		int option; 
		
		System.out.println("Select a skill to use:");
		for(int i = 0; i < skills.size(); i++) {
			System.out.println(i + ":"+skills.get(i).getSkillname());
		}
		
		do {
			option = scanner.nextInt();
		}while(option < 0 || option > skills.size()-1);
		
		player.setNextSkill(skills.get(option));
		
		System.out.println("Select the target:"+characters.size());
		for(int i = 0; i < characters.size(); i++) {
			System.out.println(i + ":"+characters.get(i));
		}
		
		do {
			option = scanner.nextInt();
		}while(option < 0 || option > characters.size()-1);
		
		player.setTarget(characters.get(option));
		
		GameManager.getManager().turn();
		
	}

	@Override
	public void paint(Player player, List<Character> characters) {
		for(int i = 0; i < characters.size(); i++) {
			System.out.println(characters.get(i));
		}
		
		
	}

}

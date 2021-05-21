package singletonPattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import base.Character;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import display.Ventana;

public class WindowDisplay implements DisplayStrategy, ActionListener{
	private Ventana window;
	private int state = 0;
	private List<Character> currentCharacters;
	private List<ActiveItemDecorator> currentSkills;
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(state == 0) {
			for(int i = 0; i < currentSkills.size(); i++) {
				if(event.getActionCommand().equals(currentSkills.get(i).getSkillname())) {
					GameManager.getManager().getPlayer().setNextSkill(currentSkills.get(i));
					state = 1;
					window.cambiarBotones(getCharactersString(currentCharacters), this);
				}
			}
			if(state == 0) informPlayer("Warning: Something went wrong");
		}else if(state == 1) {
			for(int i = 0; i < currentSkills.size(); i++) {
				if(event.getActionCommand().equals(currentCharacters.get(i).getName())) {
					GameManager.getManager().getPlayer().setTarget(currentCharacters.get(i));
					state = 0;
					GameManager.getManager().turn();
				}
			}
			if(state == 1) informPlayer("Warning: Something went wrong");
		}
		
	}

	@Override
	public void informPlayer(String data) {
		window.getHistory().append(data+"\n");
	}

	@Override
	public void askPlayer(Player player, List<ActiveItemDecorator> skills, List<Character> characters) {
		currentCharacters = characters;
		currentSkills = skills;
		window.cambiarBotones(getSkillsString(skills),this);
	}

	@Override
	public void paint(Player player, List<Character> characters) {
		if(window==null) {
			String data[] = getSkillsString(player);
			window = new Ventana(data,this,player);
			window.setVisible(true);
		}else {
			window.actualizarVentana(player);
		}
		
	}
	
	private String[] getSkillsString(List<ActiveItemDecorator> list) {
		String data[] = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			data[i] = list.get(i).getSkillname();
		}
		
		return data;
	}
	private String[] getSkillsString(Player player) {
		List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
		skills = player.getEquipment().areThereAnyActives(skills);
		return getSkillsString(skills);
	}
	private String[] getCharactersString(List<Character> list) {
		String data[] = new String[list.size()];
		for(int i = 0; i < list.size(); i++) {
			data[i] = list.get(i).getName();
		}
		
		return data;
	}
	

}

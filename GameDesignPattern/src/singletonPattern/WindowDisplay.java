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
	Ventana window;
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void informPlayer(String data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void askPlayer(Player player, List<ActiveItemDecorator> skills, List<Character> characters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paint(Player player, List<Character> characters) {
		if(window==null) {
			List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
			skills = player.getEquipment().areThereAnyActives(skills);
			String data[] = new String[skills.size()];
			for(int i = 0; i < skills.size(); i++) {
				data[i] = skills.get(i).getSkillname();
			}
			window = new Ventana(data,this,player);
			window.setVisible(true);
		}else {
			
		}
		
	}

}

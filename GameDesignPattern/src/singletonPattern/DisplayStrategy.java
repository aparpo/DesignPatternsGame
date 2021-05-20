package singletonPattern;

import java.util.List;

import base.*;
import base.Character;
import decoratorPattern.ActiveItemDecorator;

public interface DisplayStrategy {
	public void informPlayer(String data);
	public void askPlayer(Player player,List<ActiveItemDecorator> skills, List<Character> characters);
	public void paint(Player player, List<Character> characters);
}

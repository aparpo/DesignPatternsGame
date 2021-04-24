package singletonPattern;

import java.util.ArrayList;
import java.util.List;

import decoratorPattern.Action;

public class GameManager {
	private static GameManager manager = new GameManager();
	private List<Action> actions = new ArrayList<Action>();
	private GameManager() {}

	public static GameManager getManager() {
		return manager;
	}

	public static void setManager(GameManager manager) {
		GameManager.manager = manager;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
}

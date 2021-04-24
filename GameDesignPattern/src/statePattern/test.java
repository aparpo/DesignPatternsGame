package statePattern;

public class test {
	public static void main(String argv[]) {
		Character erick = new Character("Erick");
		//erick.setState(new State(erick));
		//erick.getState().setStatePoisoned();
		//erick.getState().changeState(new StatePoisoned());
		erick.getState().process();
		erick.getState().process();
		System.out.println(erick.getVida());
	}
}

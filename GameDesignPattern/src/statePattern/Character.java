package statePattern;

public class Character {
	String nombre;
	int vida = 10;
	int damage = 10;
	State state;
	public Character(String nombre) {
		this.nombre = nombre;
		this.state = new State(this);
	}
	public Character() {}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int dano) {
		this.damage = dano;
	}
}

package display;

import javax.swing.*;

import base.*;
import singletonPattern.GameManager;

import java.awt.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea inventory, history;
	private JPanel panelLateral, optionPanel, panelResumen, panelTitulo, worldPanel, playerSection, enemySection;
	private JScrollPane sbrText;
	private JLabel estado,titulo, playerInfo, objetos[], enemiesInfo[];
	private JButton botones[];
	
	private GameManager manager = GameManager.getManager();
	
	//Constructor de la Interfaz
	public Ventana(String data[], ActionListener listener, Player player) {
		botones = new JButton[data.length];
		
		//Creamos los paneles
		optionPanel = new JPanel();
		worldPanel = new JPanel();
		panelResumen = new JPanel();
		panelTitulo = new JPanel();
		panelLateral = new JPanel();
		playerSection = new JPanel();
		enemySection = new JPanel();
		
		//Diseñamos panelTitulo
		panelTitulo.setLayout(new GridLayout(0,1));
		titulo = new JLabel("You are in the Level "+manager.getCurrentLevel().ordinal());
		titulo.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		panelTitulo.add(titulo);
		/*if(player.getObjeto()==null) {
			estado= new JLabel("Estas en " + player.getLocalizacion().getNombre()+" y no tienes nada");
		}else {
			estado = new JLabel("Estas en " + player.getLocalizacion().getNombre()+" y tienes "+ player.getObjeto().getNombre());
			
		}
		estado.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		panelTitulo.add(estado);*/
		
		
		//Diseñamos panelOpciones
		
		optionPanel.setBackground(Color.gray);
		optionPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		optionPanel.setLayout(new GridLayout(0,1));
		
		
		for(int i = 0; i < data.length; i++) {
			botones[i] = new JButton(data[i]);
			botones[i].setPreferredSize(new Dimension(200,50));
			botones[i].addActionListener(listener);
			optionPanel.add(botones[i]);
		}
		
		//Diseñamos worldPanel
		worldPanel.setBackground(Color.WHITE);
		worldPanel.setBorder(BorderFactory.createTitledBorder("World information"));
		worldPanel.setLayout(new BorderLayout());
		
		playerSection.setLayout(new GridLayout(0,1));
		playerSection.setBackground(Color.WHITE);
		
		String playerDesc = player.getName() + " \n" + player.getEquipment().getLife()+ "/"+ player.getEquipment().getMaxLife();
		playerInfo = new JLabel(playerDesc,new ImageIcon("personaje.jpg"), JLabel.CENTER);
		playerInfo.setVerticalTextPosition(JLabel.BOTTOM);
		playerInfo.setHorizontalTextPosition(JLabel.CENTER);
		
		playerSection.add(playerInfo);
		
		worldPanel.add(playerSection,BorderLayout.CENTER);
		
		enemiesInfo = new JLabel[manager.getCharacters().size()-1];

		
		enemySection.setLayout(new GridLayout(0,1));
		enemySection.setBackground(Color.WHITE);
		
		
		for(int i = 0, j = 0; i <manager.getCharacters().size(); i++) {
			if(!(manager.getCharacters().get(i) instanceof Enemy)) {
				continue;
			}
			Enemy enemy = (Enemy) manager.getCharacters().get(i);
			String info = enemy.getName() + " \n" + enemy.getEquipment().getLife()+ "/"+ enemy.getEquipment().getMaxLife();
			enemiesInfo[j] = new JLabel( info,new ImageIcon("puerta.png"), JLabel.LEFT);
			enemySection.add(enemiesInfo[j]);
			j++;
		}
		
		worldPanel.add(playerSection, BorderLayout.CENTER);
		worldPanel.add(enemySection, BorderLayout.EAST);
		
		//Diseñamos panelLateral
		panelLateral.setLayout(new GridLayout(0,1));
		panelLateral.setPreferredSize(new Dimension(300,700));
		panelLateral.add(worldPanel);
		panelLateral.add(optionPanel);
		
		
		//Diseñamos panelResumen
		panelResumen.setBackground(Color.white);
		panelResumen.setLayout(new GridLayout(0,1));
		
		history = new JTextArea("Action history:\n"); //Esto será el historial de las acciones
		history.setEditable(false);
		history.setBackground(Color.LIGHT_GRAY);
		
		sbrText = new JScrollPane(history, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		inventory = new JTextArea("Inventory:\n" + player); //Esto serán las creencias del jugador
		inventory.setPreferredSize(new Dimension(100,100));
		
		panelResumen.add(sbrText);
		panelResumen.add(inventory);
		
		//Construimos la ventana
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelLateral, BorderLayout.EAST);
		add(panelResumen, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Decision Jugador");
		pack();
		setSize(700,700);
	}
	
	/*public Ventana(String cosas[], GestorJuego gestor, Jugador jugador, boolean disponibles[]) {
		this(cosas, gestor,jugador);
		cambiarBotones(cosas, gestor, disponibles);
	}*/
	/*public JTextArea getHistoria() {
		return historia;
	}*/
	
	public void cambiarBotones(String cosas[], ActionListener listener) {
		for(int i = 0; i < botones.length; i++) {
			optionPanel.remove(botones[i]);
		}
		
		for(int i = 0; i < cosas.length; i++) {
				botones[i] = new JButton(cosas[i]);
				botones[i].setPreferredSize(new Dimension(200,50));
				botones[i].addActionListener(listener);
				optionPanel.add(botones[i]);
			
		}
	
		validate();
		repaint();
	}
	
	public void actualizarVentana(Player player) { //Añadir la nueva informacion de cada turno
		
		//Abajo izquierda
		panelResumen.remove(inventory);
		inventory = new JTextArea("Inventory:\n" + player); //Esto serán las creencias del jugador
		inventory.setPreferredSize(new Dimension(100,100));
		panelResumen.add(inventory);
		
		//Arriba izquierda
		panelTitulo.remove(titulo);
		titulo = new JLabel("You are in the Level "+manager.getCurrentLevel().ordinal());
		titulo.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		panelTitulo.add(titulo);
		
		
		
		//Arriba derecha
		worldPanel.remove(playerSection);
		playerSection.remove(playerInfo);
		
		String playerDesc = player.getName() + " \n" + player.getEquipment().getLife()+ "/"+ player.getEquipment().getMaxLife();
		playerInfo = new JLabel(playerDesc,new ImageIcon("personaje.jpg"), JLabel.CENTER);
		playerInfo.setVerticalTextPosition(JLabel.BOTTOM);
		playerInfo.setHorizontalTextPosition(JLabel.CENTER);
		
		playerSection.add(playerInfo);
		worldPanel.add(playerSection,BorderLayout.CENTER);
		
		worldPanel.remove(enemySection);
		
		for(int i = 0; i <enemiesInfo.length; i++) {
			enemySection.remove(enemiesInfo[i]);
		}
		enemiesInfo = new JLabel[manager.getCharacters().size()-1];
		
		for(int i = 0, j = 0; i <manager.getCharacters().size(); i++) {
			if(!(manager.getCharacters().get(i) instanceof Enemy)) {
				continue;
			}
			Enemy enemy = (Enemy) manager.getCharacters().get(i);
			String info = enemy.getName() + " \n" + enemy.getEquipment().getLife()+ "/"+ enemy.getEquipment().getMaxLife();
			enemiesInfo[j] = new JLabel( info,new ImageIcon("puerta.png"), JLabel.LEFT);
			enemySection.add(enemiesInfo[j]);
			j++;
		}
		
		worldPanel.add(enemySection,BorderLayout.EAST);
		
		
		validate();
		repaint();
	}
}
package display;

import javax.swing.*;

import base.*;
import singletonPattern.GameManager;

import java.awt.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea creencias, historia;
	private JPanel panelLateral, optionPanel, panelResumen, panelTitulo, worldPanel, items, enemySection;
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
		items = new JPanel();
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
		
		
		playerInfo = new JLabel(player.getName(),new ImageIcon("personaje.jpg"), JLabel.CENTER);
		playerInfo.setVerticalTextPosition(JLabel.BOTTOM);
		playerInfo.setHorizontalTextPosition(JLabel.CENTER);
		
		worldPanel.add(playerInfo,BorderLayout.CENTER);
		enemiesInfo = new JLabel[manager.getCharacters().size()-1];

		
		enemySection.setLayout(new GridLayout(0,1));
		enemySection.setBackground(Color.WHITE);
		
		
		for(int i = 0, j = 0; i <manager.getCharacters().size()-1; i++) {
			if(!(manager.getCharacters().get(i) instanceof Enemy)) {
				continue;
			}
			Enemy enemy = (Enemy) manager.getCharacters().get(i);
			String info = enemy.getName() + "\n" + enemy.getEquipment().getLife()+ "/"+ enemy.getEquipment().getMaxLife();
			enemiesInfo[j] = new JLabel( info,new ImageIcon("puerta.png"), JLabel.LEFT);
			enemySection.add(enemiesInfo[j]);
			j++;
		}
		
		worldPanel.add(items, BorderLayout.CENTER);
		worldPanel.add(enemySection, BorderLayout.EAST);
		
		//Diseñamos panelLateral
		panelLateral.setLayout(new GridLayout(0,1));
		panelLateral.setPreferredSize(new Dimension(300,700));
		panelLateral.add(worldPanel);
		panelLateral.add(optionPanel);
		
		
		//Diseñamos panelResumen
		panelResumen.setBackground(Color.white);
		panelResumen.setLayout(new GridLayout(0,1));
		
		historia = new JTextArea("Action history:\n"); //Esto será el historial de las acciones
		historia.setEditable(false);
		historia.setBackground(Color.LIGHT_GRAY);
		
		sbrText = new JScrollPane(historia, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		creencias = new JTextArea("Inventory:\n" + player); //Esto serán las creencias del jugador
		creencias.setPreferredSize(new Dimension(100,100));
		
		panelResumen.add(sbrText);
		panelResumen.add(creencias);
		
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
	}
	public JTextArea getHistoria() {
		return historia;
	}
	public void cambiarBotones(Elemento cosas[], GestorJuego listener) {
		for(int i = 0; i < botones.length; i++) {
			optionPanel.remove(botones[i]);
		}
		
		for(int i = 0; i<cosas.length; i++) {
			if(cosas[i]!=listener.getJugador()) {
				botones[i] = new JButton(cosas[i].getNombre());
				botones[i].setPreferredSize(new Dimension(200,50));
				botones[i].addActionListener(listener);
				optionPanel.add(botones[i]);
			}
			
		}
		
		validate();
		repaint();
	}
	
	public void cambiarBotones(String cosas[], GestorJuego listener) {
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
	public void cambiarBotones(String cosas[], GestorJuego gestor, boolean disponibles[]) { //Habilitar solo algunos de los botones
		cambiarBotones(cosas, gestor);
		for(int i = 0; i < disponibles.length || i < cosas.length; i++) {
			if(disponibles[i]==false) {
				botones[i].setEnabled(false);
			}
		}
	}
	public void actualizarVentana(Jugador jugador) { //Añadir la nueva informacion de cada turno
		
		panelResumen.remove(creencias);
		creencias = new JTextArea("Últimas ubicaciones conocidas: \n" +jugador.getCreencias());
		panelResumen.add(creencias);
		
		panelTitulo.remove(estado);
		if(jugador.getObjeto()==null) {
			estado= new JLabel("Estas en " + jugador.getLocalizacion().getNombre()+" y no tienes nada");
		}else {
			estado = new JLabel("Estas en " + jugador.getLocalizacion().getNombre()+" y tienes "+ jugador.getObjeto().getNombre());
		}
		estado.setFont(new Font("Sans-Serif", Font.BOLD, 25));
		panelTitulo.add(estado);
		
		worldPanel.remove(items);
		if(jugador.getLocalizacion().getPersonajes().size() >= jugador.getLocalizacion().getObjetos().size()) {
			items.setLayout(new GridLayout(2,jugador.getLocalizacion().getPersonajes().size()));
		}else {
			items.setLayout(new GridLayout(2,jugador.getLocalizacion().getObjetos().size()));
		}
		for(int i = 0; i <playerInfo.length; i++) {
			items.remove(playerInfo[i]);
		}
		playerInfo = new JLabel[jugador.getLocalizacion().getPersonajes().size()];
		
		for(int i = 0; i <jugador.getLocalizacion().getPersonajes().size(); i++) {
			playerInfo[i] = new JLabel(jugador.getLocalizacion().getPersonajes().get(i).getNombre(),new ImageIcon("personaje.jpg"), JLabel.CENTER);
			playerInfo[i].setVerticalTextPosition(JLabel.BOTTOM);
			playerInfo[i].setHorizontalTextPosition(JLabel.CENTER);
			items.add(playerInfo[i]);
		}
		for(int i = 0; i <objetos.length; i++) {
			items.remove(objetos[i]);
		}
		objetos = new JLabel[jugador.getLocalizacion().getObjetos().size()];
		for(int i = 0; i <jugador.getLocalizacion().getObjetos().size(); i++) {
			objetos[i] = new JLabel(jugador.getLocalizacion().getObjetos().get(i).getNombre(),new ImageIcon("objeto.png"), SwingConstants.CENTER);
			objetos[i].setVerticalTextPosition(JLabel.BOTTOM);
			objetos[i].setHorizontalTextPosition(JLabel.CENTER);
			items.add(objetos[i]);
		}
		
		worldPanel.add(items,BorderLayout.CENTER);
		
		worldPanel.remove(enemySection);
		
		for(int i = 0; i <enemiesInfo.length; i++) {
			enemySection.remove(enemiesInfo[i]);
		}
		enemiesInfo = new JLabel[jugador.getLocalizacion().getAdyacencias().length];
		for(int i = 0; i <jugador.getLocalizacion().getAdyacencias().length; i++) {
			enemiesInfo[i] = new JLabel(jugador.getLocalizacion().getAdyacencias()[i].getNombre(),new ImageIcon("puerta.png"), JLabel.LEFT);
			enemySection.add(enemiesInfo[i]);
		}
		
		worldPanel.add(enemySection,BorderLayout.EAST);
		
		
		validate();
		repaint();
	}*/
}
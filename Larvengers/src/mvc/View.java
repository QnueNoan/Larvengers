package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import element.*;
import player.PlayerPanel;
import ressource.ListRessources;
import unit.Larva;
import unit.ListLarvas;

public class View extends JFrame {
	/*
	 * width and length of the window
	 */
	public static int WIDTH = 1000;
	public static int HEIGTH = 700;
	/*
	 * the background image
	 */
	private ImageIcon iconBackground;
	private Image imgBackground;
	/*
	 * width and length of the board game
	 */
	public static int widthBackground = 700;
	public static int heigthBackground = 700;
	
	/*
	 * List of elements
	 */
	public ListRessources ressources;
	public ListLarvas larvas;
	
	private JPanel gamePanel;
	private PlayerPanel playerPanel;
	
	/*
	 * constructor of the class
	 */
	public View(){
		super();
		this.iconBackground = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
		this.imgBackground = this.iconBackground.getImage();
		
		ressources = new ListRessources();
		larvas = new ListLarvas();
		setWindow();
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {
					revalidate();
					repaint();
					try {
						Thread.sleep(1000);
					} catch(Exception e) {e.printStackTrace();}
				}
				
			}
			
		}).start();
		
		
	}
	
	/**
	 * This function will set all the features about the window
	 */
	private void setWindow() {
		setTitle("THE FLOOR IS LARVA");
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setLayout(null);
		setGamePanel();
		setBarPlayer();
		add(this.gamePanel);
		add(this.playerPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/*
	 * This function configures all the panel features about the area where the game will be displayed
	 */
	private void setGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setSize(widthBackground, heigthBackground);
		gamePanel.setBounds(0, 0, widthBackground, heigthBackground);
	}
	
	/*
	 * This funtion configures all the panel features about the area where the players can control his actions
	 */
	private void setBarPlayer() {
		playerPanel = new PlayerPanel();
		playerPanel.setSize(playerPanel.getWidth(), playerPanel.getHeight());
		playerPanel.setBounds(widthBackground, 0, playerPanel.getWidth(), playerPanel.getHeight());
	}
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintBackground(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, widthBackground, heigthBackground, null);
	}
	
	/*
	 * Paint the different parts of the game
	 * @Override
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		paintBackground(g);
		
		// Adding of a background for the control panel
		//playerPanel.paintBackground(g);
		
		ressources.paintElements(g);
		//larvas.paintElements(g);
	}
	
	/*
	 * GETTERS AND SETTERS 
	 */
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int WIDTH) {
		WIDTH = WIDTH;
	}
	
	public static int getHEIGHT() {
		return HEIGTH;
	}
	
	public static void setHEIGHT(int HEIGHT) {
		HEIGHT = HEIGHT;
	}
	
	public static int getWidthBackground() {
		return widthBackground;
	}
	public static void setWidthBackground(int widthBackground) {
		View.widthBackground = widthBackground;
	}
	
	public static int getHeigthBackground() {
		return heigthBackground;
	}
	public static void setHeigthBackground(int lengthBackground) {
		View.heigthBackground = lengthBackground;
	}
	
}
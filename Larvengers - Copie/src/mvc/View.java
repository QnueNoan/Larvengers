package mvc;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import element.*;
import player.PlayerPanel;
import ressource.ListRessources;
import unit.ListEnnemies;
import unit.ListLarvas;

public class View extends JFrame{
	/*
	 * width and length of the window
	 */
	public static int WIDTH = 1000;
	public static int HEIGTH = 700;
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
	public ListEnnemies enemies;

	private GamePanel gamePanel;
	private PlayerPanel playerPanel;

	private Control control;

	/*
	 * constructor of the class
	 */
	public View() {
		super();
	}

	/**
	 * This function will set all the features about the window
	 */
	public void setWindow() {
		setTitle("THE FLOOR IS LARVA");
		setSize(WIDTH, HEIGTH);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		setLayout(null);
		setPanels();
		add(this.gamePanel);
		add(this.playerPanel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * This function configures all the panel features about the area where the game will be displayed
	 */
	private void setPanels() {
		gamePanel = new GamePanel();
		playerPanel = new PlayerPanel();
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public void setList (ListRessources ressources, ListLarvas larvas, ListEnnemies enemies) {
		this.ressources = ressources;
		this.larvas = larvas;
		this.enemies = enemies;
	}
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int w) {
		WIDTH = w;
	}

	public static int getHEIGHT() {
		return HEIGTH;
	}

	public static void setHEIGHT(int h) {
		HEIGTH = h;
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

	public void setControl(Control c) {
		this.control = c;
	}

	public GamePanel getGamePanel() {
		return this.gamePanel;
	}

	public PlayerPanel getPlayerPanel() {
		return this.playerPanel;
	}
}
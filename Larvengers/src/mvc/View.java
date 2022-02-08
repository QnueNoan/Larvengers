package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import element.*;
import unit.Larva;

public class View extends JPanel{
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
	public ListElements ressources;
	public ListElements larvas;
	
	/*
	 * constructor of the class
	 */
	public View() {
		super();
		this.iconBackground = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
		this.imgBackground = this.iconBackground.getImage();
		
		ressources = new ListElements();
		larvas = new ListElements();
		
		//ResizeImg.changeSize(inImg, outImg, width, height);
		this.setFocusable(true);
		this.requestFocusInWindow();
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {
					revalidate();
					repaint();
				}
			}
		}).start();
		
	}
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, widthBackground, heigthBackground, null);
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
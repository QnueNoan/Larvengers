package mvc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import element.*;
import ressource.ListRessources;
import ressource.Ressource;
import unit.Larva;
import unit.ListLarvas;

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
	public ListRessources ressources;
	public ListLarvas larvas;
	
	/*
	 * constructor of the class
	 */
	public View() {
		super();
		this.iconBackground = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
		this.imgBackground = this.iconBackground.getImage();
		
		//ResizeImg.changeSize(inImg, outImg, width, height);
		this.setFocusable(true);
		this.requestFocusInWindow();
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {					
					revalidate();
					repaint();
					try {
						Thread.sleep(41);
					} catch(Exception e) {e.printStackTrace();}
				}
				
			}
			
		}).start();
		
	}
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintBackground(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, widthBackground, heigthBackground, null);
		g.drawRect(100, 550, 100, 100);
	}
	
	/*
	 * Paint the different parts of the game
	 * @Override
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		paintBackground(g);
		ressources.paintElements(g);
		larvas.paintElements(g);
	}
	
	/*
	 * GETTERS AND SETTERS 
	 */
	public void setList (ListRessources ressources, ListLarvas larvas) {
		this.ressources = ressources;
		this.larvas = larvas;
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
	
}
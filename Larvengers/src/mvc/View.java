package mvc;

import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class View extends JPanel{
	/*
	 * width and length of the window
	 */
	public static int WIDTH = 1000;
	public static int LENGTH = 700;
	/*
	 * the background image
	 */
	private ImageIcon iconBackground;
	private Image imgBackground;
	/*
	 * width and length of the board game
	 */
	public static int widthBackground = 700;
	public static int lengthBackground = 700;
	
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
		
	}
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, widthBackground, lengthBackground, null);
	}
	
	/*
	 * GETTERS AND SETTERS 
	 */
	public static int getWIDTH() {
		return WIDTH;
	}
	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}
	
	public static int getLENGTH() {
		return LENGTH;
	}
	public static void setLENGTH(int lENGTH) {
		LENGTH = lENGTH;
	}
	
	public static int getWidthBackground() {
		return widthBackground;
	}
	public static void setWidthBackground(int widthBackground) {
		View.widthBackground = widthBackground;
	}
	
	public static int getLengthBackground() {
		return lengthBackground;
	}
	public static void setLengthBackground(int lengthBackground) {
		View.lengthBackground = lengthBackground;
	}
	
}

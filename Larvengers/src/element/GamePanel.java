package element;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mvc.View;
import ressource.ListRessources;
import unit.ListEnnemies;
import unit.ListLarvas;

public class GamePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * the background image
	 */
	private ImageIcon iconBackground;
	private Image imgBackground;
	
	/*
	 * Lists of elements
	 */
	public ListRessources ressources;
	public ListLarvas larvas;
	public ListEnnemies ennemies;
	
	
	private static final int width = View.widthBackground;
	private static final int height = View.heigthBackground;
	
	public GamePanel() {
		this.iconBackground = new ImageIcon(getClass().getResource("/assets/Fond2.jpg"));
		this.imgBackground = this.iconBackground.getImage();
		
		setPanel();
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
	 * this function will allow you to define the configurations of the panel
	 */
	private void setPanel() {
		this.setSize(width, height);
		this.setBounds(0, 0, width, height);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setVisible(true);
	}
	
	
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintBackground(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, width, height, null);
	}
	
	/*
	 * Paint the different parts of the game
	 * @Override
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		paintBackground(g);
		if(ressources != null && larvas != null && ennemies != null) {
			ressources.paintElements(g);
			larvas.paintElements(g);
			ennemies.paintElements(g);
		}
	}
	
	/*
	 * Setter for the lists
	 */
	public void setList (ListRessources ressources, ListLarvas larvas, ListEnnemies ennemies) {
		this.ressources = ressources;
		this.larvas = larvas;
		this.ennemies = ennemies;
	}
}

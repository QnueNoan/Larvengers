package element;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import mvc.View;
import ressource.ListRessources;
import unit.ListLarvas;

public class ElementPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * the background image
	 */
	private ImageIcon iconBackground;
	private Image imgBackground;
	
	public ListRessources ressources;
	public ListLarvas larvas;
	
	
	private static final int width = View.widthBackground;
	private static final int height = View.heigthBackground;
	
	public ElementPanel() {
		this.iconBackground = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
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
	
	private void setPanel() {
		this.setSize(width, height);
		this.setBounds(0, 0, width, height);
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.setVisible(true);
	}
	
	public void setList (ListRessources ressources, ListLarvas larvas) {
		this.ressources = ressources;
		this.larvas = larvas;
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
		if(ressources != null && larvas != null) {
			ressources.paintElements(g);
			larvas.paintElements(g);
		}
	}
}

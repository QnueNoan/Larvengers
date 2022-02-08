package unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import ressource.Ressource;
import unit.Larva;

public class ListLarvas {
	/*
	 * Store all the larvas
	 */
	private ArrayList<Larva> larvas = new ArrayList<Larva>();
	
	// Timer for larva generation
	public static int TIMER_DISPLAY_RESSOURCE = 5000;
	
	// Max larvas on the board
	public static int MAX_LARVAS = 10;
	
	/*
	 * Image attributs
	 */
	public final ImageIcon spriteTmp = new ImageIcon(getClass().getResource("/assets/larva.jpg"));
	public final Image sprite = this.spriteTmp.getImage();
	
	public ListLarvas () {
		larvas.add(new Larva());
		addLarvas();
	}

	public void addLarvas () {
		(new Thread() {
			@Override
			public void run() {
				while(true) {
					if(larvas.size() <= MAX_LARVAS) {
						larvas.add(new Larva());
					}
					try {
						Thread.sleep(TIMER_DISPLAY_RESSOURCE);
					} catch(Exception e) {e.printStackTrace();}
				}
			}
		}).start();
	}
	
	public void paintLarvas (Graphics g) {
		g.drawImage(sprite, 0, 0, Larva.unitWidth, Larva.unitWidth, null);
	}
}

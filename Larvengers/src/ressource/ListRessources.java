package ressource;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import mvc.View;

public class ListRessources {
	/*
	 * ressources : List of ressources
	 * MAX_RESSOURCES : Maximum constant that the list is allowed to contain
	 */
	private ArrayList<Ressource> ressources;
	private static final int MAX_RESSOURCES = 20;
	
	private static final int HEIGHT_IMG = 600;
	private static final int WIDTH_IMG = 650;
	
	private static final int TIMER_DISPLAY_RESSOURCE = 10000;
	
	
	public ListRessources() {
		this.ressources = new ArrayList<Ressource>();
		addRessources();
	}
	
	private void addRessources() {
		(new Thread() {
			@Override
			public void run() {
				while(true) {
					if(ressources.size() <= MAX_RESSOURCES) {
						ressources.add(new Ressource());
					}
					try {
						Thread.sleep(TIMER_DISPLAY_RESSOURCE);
					} catch(Exception e) {e.printStackTrace();}
				}
			}
		}).start();
	}
	
	public void paintRessources(Graphics g) {
		for(int i = 0; i < ressources.size(); i ++) {
			if(ressources.get(i).getTypeRessource() == TypeRessource.POOP)
				g.setColor(Color.BLACK);
			else if (ressources.get(i).getTypeRessource() == TypeRessource.COCKTAIL)
				g.setColor(Color.PINK);
			else 
				g.setColor(Color.blue);
			g.drawOval(ressources.get(i).getCoordinates().x, ressources.get(i).getCoordinates().y, (View.widthBackground - WIDTH_IMG) , (View.heigthBackground - HEIGHT_IMG));
		}
	}
	/*
	 * Method getRessources : return the current ressources that are going to be displayed on the map
	 * @return ressources
	 */
	public ArrayList<Ressource> getRessources() {
		return this.ressources;
	}
}
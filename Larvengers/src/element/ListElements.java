package element;

import java.awt.Graphics;
import java.util.ArrayList;

import unit.Larva;

public class ListElements {
	/*
	 * Store elements
	 */
	private ArrayList<Element> elements = new ArrayList<Element>();
	
	// Timer for element generation
	public static int TIMER_DISPLAY_RESSOURCE;
	
	// Max elements stored
	public static int MAX_ELEMENTS = 10;
	
	public ListElements () {
		
	}
	
	/*
	 * add a new Element to elements list each TIMER_DISPLAY_RESSOURCE ms
	 * add a new Element only if the size of elements is lower than MAX_ELEMNTS
	 */
	public void addElements () {
		(new Thread() {
			@Override
			public void run() {
				while(true) {
					if(elements.size() <= MAX_ELEMENTS) {
						elements.add(new Element();
					}
					try {
						Thread.sleep(TIMER_DISPLAY_RESSOURCE);
					} catch(Exception e) {e.printStackTrace();}
				}
			}
		}).start();
	}
	
	/*
	 * Draw all Element of the elements list
	 */
	public void paintElements (Graphics g) {
		for(int e=0; e<elements.size(); e++) {
			g.drawImage(Element.sprite, elements.get(e).getCoordinates().x, elements.get(e).getCoordinates().y, Element.heigth, Larva.width, null);			
		}
	}
}

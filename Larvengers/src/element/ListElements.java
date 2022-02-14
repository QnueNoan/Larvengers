package element;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

import ressource.Ressource;
import unit.Larva;

public abstract class ListElements<T extends Element> {
	/*
	 * Store elements
	 */
	private ArrayList<T> elements = new ArrayList<>();
	
	// Timer for element generation
	public static int TIMER_DISPLAY_ELEMENT;
	
	// Max elements stored
	public static int MAX_ELEMENTS = 10;
	
	public ListElements (int timer, int maxElem) {
		TIMER_DISPLAY_ELEMENT = timer;
		MAX_ELEMENTS = maxElem;
	}
	
	/*
	 * add a new Element to elements list each TIMER_DISPLAY_RESSOURCE ms
	 * add a new Element only if the size of elements is lower than MAX_ELEMNTS
	 */
	public void addElements (TypeElement te) {
		(new Thread() {
			@Override
			public void run() {
				while(true) {
					if(elements.size() <= MAX_ELEMENTS) {
						switch(te) {
						case RESSOURCE :
							elements.add((T) new Ressource());
							break;
						case LARVA : 
							elements.add((T) new Larva());
							break;
						}
					}
					try {
						Thread.sleep(TIMER_DISPLAY_ELEMENT);
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
			g.drawImage(elements.get(e).sprite, elements.get(e).getCoordinates().x, elements.get(e).getCoordinates().y, elements.get(e).heigth, elements.get(e).width, null);			
		}
	}
    
    /*
     * Getters and setters
     */

	public static int getTIMER_DISPLAY_ELEMENT() {
		return TIMER_DISPLAY_ELEMENT;
	}

	public static void setTIMER_DISPLAY_ELEMENT(int tIMER_DISPLAY_ELEMENT) {
		TIMER_DISPLAY_ELEMENT = tIMER_DISPLAY_ELEMENT;
	}

	public static int getMAX_ELEMENTS() {
		return MAX_ELEMENTS;
	}

	public static void setMAX_ELEMENTS(int mAX_ELEMENTS) {
		MAX_ELEMENTS = mAX_ELEMENTS;
	}

	public ArrayList<T> getElements() {
		return elements;
	}

	public void setElements(ArrayList<T> elements) {
		this.elements = elements;
	}    
    
}

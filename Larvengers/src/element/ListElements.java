package element;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import ressource.Ressource;
import unit.*;

public abstract class ListElements<T extends Element> {
	/*
	 * Store elements
	 */
	private ArrayList<T> elements = new ArrayList<>();
	
	// Timer for element generation
	public static int TIMER_DISPLAY_ELEMENT;
	
	// Max elements stored
	public static int MAX_ELEMENTS = 5;
	
	// Type of the elements stored
	public TypeElement type;
	
	public ListElements (TypeElement te, int timer, int maxElem) {
		type = te;
		TIMER_DISPLAY_ELEMENT = timer;
		MAX_ELEMENTS = maxElem;
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
						switch(type) {
						case RESSOURCE :
							while (true) {
								Ressource r = new Ressource();
								// check if the ressource is in an area without others elements
								if (!isElementInArea(r.coordinates.x, r.coordinates.y, r.width, r.heigth)) {
									elements.add((T) new Ressource());
									break;
								}
							}
							break;
						case LARVA :
							// check if the larva spawning area is empty
							if (!isElementInArea(100, 550, 100, 100))
								elements.add((T) new Larva());
							break;
						case MOSKITO :
							if (!isElementInArea(100, 100, 100, 100)) {
								elements.add((T) new Ennemy());
							}
							break;
						default:
							break;
						}
					}
					
					// remove ressource which capacity is 0
					if (type == TypeElement.RESSOURCE) elements.removeIf((T r) -> ((Ressource)r).getCapacity() < 1);
					
					// remove larvas which health is 0
					else if (type == TypeElement.LARVA) elements.removeIf((T l) -> ((Larva)l).getHealth() < 1);
					
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
			g.drawRect(elements.get(e).coordinates.x, elements.get(e).coordinates.y, elements.get(e).width, elements.get(e).heigth);
		}
	}
	
	/*
	 * Return the element if the player clicked on it
	 */
	public T getClickedElement (Point click) {
		for (int i=0; i<elements.size(); i++) {
			// If the coordinate of the click are inside the element hitbox (sprite)
			if (click.x >= elements.get(i).coordinates.x && click.x <= elements.get(i).coordinates.x+elements.get(i).width+15 &&
				click.y >= elements.get(i).coordinates.y && click.y <= elements.get(i).coordinates.y+elements.get(i).heigth+15) {
				return elements.get(i);
			}
		}
		return null;
	}
	
	// Check is there is, at least, 1 elements (of the same type) in the area
	public boolean isElementInArea (int x, int y, int width, int height) {
		width = width/2;
		height = height/2;
		for (Element e : elements) {
			// Check the distance between the point in argument and the element
			if ( (Math.sqrt((x+width-e.getCoordinates().x)*(x+width-e.getCoordinates().x) + 
					(y+height-e.getCoordinates().y)*(y+height-e.getCoordinates().y))) <= 70.0) {
				return true;
			}
		}
		return false;
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

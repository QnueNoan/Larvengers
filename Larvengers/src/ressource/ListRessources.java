package ressource;

import java.awt.Point;

import element.ListElements;
import element.TypeElement;

public class ListRessources extends ListElements<Ressource>{
	/*
	 * MAX_RESSOURCES : Maximum constant that the list is allowed to contain
	 */
	private static final int MAX_RESSOURCES = 10;
	
	private static final int TIMER_DISPLAY_RESSOURCE = 1000;
	
	
	public ListRessources() {
		super (TypeElement.RESSOURCE, TIMER_DISPLAY_RESSOURCE, MAX_RESSOURCES);
		addElements();
	}

}
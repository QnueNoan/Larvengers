package ressource;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.annotation.ElementType;
import java.util.ArrayList;

import element.ListElements;
import element.TypeElement;
import ressource.Ressource;

public class ListRessources extends ListElements<Ressource>{
	/*
	 * MAX_RESSOURCES : Maximum constant that the list is allowed to contain
	 */
	private static final int MAX_RESSOURCES = 20;
	
	private static final int TIMER_DISPLAY_RESSOURCE = 10000;
	
	
	public ListRessources() {
		super (TIMER_DISPLAY_RESSOURCE, MAX_RESSOURCES);
		addElements(TypeElement.RESSOURCE);
	}

}
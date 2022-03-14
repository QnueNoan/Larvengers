package ressource;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.lang.annotation.ElementType;
import java.util.ArrayList;

import element.ListElements;
import element.TypeElement;
import ressource.Ressource;

public class ListRessources extends ListElements<Ressource>{
	/*
	 * MAX_RESSOURCES : Maximum constant that the list is allowed to contain
	 */
	private static final int MAX_RESSOURCES = 10;
	
	private static final int TIMER_DISPLAY_RESSOURCE = 1000;
	
	
	public ListRessources() {
		super (TIMER_DISPLAY_RESSOURCE, MAX_RESSOURCES);
		this.getElements().add(new Ressource(TypeElement.PICKLE, new Point(50,30)));
		this.getElements().add(new Ressource(TypeElement.COCKTAIL, new Point(200,30)));
		this.getElements().add(new Ressource(TypeElement.POOP, new Point(400,30)));
		addElements(TypeElement.RESSOURCE);
	}

}
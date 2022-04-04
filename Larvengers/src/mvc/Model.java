package mvc;

import java.awt.Point;

import element.Element;
import ressource.ListRessources;
import ressource.Ressource;
import unit.Larva;
import unit.ListLarvas;
import unit.Unit;

public class Model {
	
	/*
	 * MVC useful components
	 */
	public View view;
	public Control control;
	
	/*
	 * Interactive Elements
	 */
	public static ListLarvas larvas;
	public static ListRessources ressources;
	
	
	public Model (View v, Control c) {
		view = v;
		control = c;
		larvas = new ListLarvas();
		ressources = new ListRessources();
		
		control.setModel(this);
		view.setWindow();
		view.getGamePanel().setList(ressources, larvas);
		view.getPlayerPanel().setControl(control);
	}
	
	/*
	 * Move the unit u to the point p
	 */
	public void deplacement (Point p, Unit u) {
		p.setLocation(p.getX()-(u.width/2), p.getY()-(u.heigth/2));
		u.setTargetedLocation(p);
	}
	
	/*
	 * Check if there is another element in the Element e area
	 */
	public static boolean isEmpty (Element e) {
		// If the element cross a larva 
		for (Larva l : larvas.getElements()) {
			if ( (e.getCoordinates().x + e.width < l.getCoordinates().x && e.getCoordinates().y + e.heigth < l.getCoordinates().y) ||
					(e.getCoordinates().x > l.getCoordinates().x+l.width && e.getCoordinates().y+e.heigth < l.getCoordinates().y) ||
					(e.getCoordinates().x+e.width < l.getCoordinates().x && e.getCoordinates().y > l.getCoordinates().y+l.heigth) ||
					(e.getCoordinates().x > l.getCoordinates().x+l.width && e.getCoordinates().y > l.getCoordinates().y+l.heigth) ) {
				return false;
			}
		}
		
		// If the element cross a ressource
		for (Ressource r : ressources.getElements()) {
			if ( (e.getCoordinates().x + e.width < r.getCoordinates().x && e.getCoordinates().y + e.heigth < r.getCoordinates().y) ||
					(e.getCoordinates().x > r.getCoordinates().x+r.width && e.getCoordinates().y+e.heigth < r.getCoordinates().y) ||
					(e.getCoordinates().x+e.width < r.getCoordinates().x && e.getCoordinates().y > r.getCoordinates().y+r.heigth) ||
					(e.getCoordinates().x > r.getCoordinates().x+r.width && e.getCoordinates().y > r.getCoordinates().y+r.heigth) ) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Getters and setters
	 */

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public ListLarvas getLarvas() {
		return larvas;
	}

	public void setLarvas(ListLarvas larvas) {
		this.larvas = larvas;
	}

	public ListRessources getRessources() {
		return ressources;
	}

	public void setRessources(ListRessources ressources) {
		this.ressources = ressources;
	}
	
}

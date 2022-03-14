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
		view.setList(ressources, larvas);
		control.setModel(this);
	}
	
	/*
	 * Move the unit u to the point p
	 */
	public void deplacement (Point p, Unit u) {
		p.setLocation(p.getX()-(u.width/2), p.getY()-(u.heigth/2));
		u.setTargetedLocation(p);
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

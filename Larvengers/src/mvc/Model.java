package mvc;

import java.awt.Point;

import ressource.ListRessources;
import unit.ListLarvas;

public class Model {
	
	/*
	 * MVC useful components
	 */
	public View view;
	public Control control;
	
	/*
	 * Interactive Elements
	 */
	public ListLarvas larvas;
	public ListRessources ressources;
	
	public Model (View v, Control c) {
		view = v;
		control = c;
		larvas = new ListLarvas();
		ressources = new ListRessources();
		view.setList(ressources, larvas);
		control.setModel(this);
	}
	
	public void deplacement (Point p) {
		larvas.getElements().get(0).setTargetedLocation(p);
		//larvas.getElements().get(0).setCoordinates(p);
		
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

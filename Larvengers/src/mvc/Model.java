package mvc;

import java.awt.Point;


import element.Element;
import ressource.ListRessources;
import ressource.Ressource;
import sound.Sounds;
import unit.Ennemy;
import unit.Larva;
import unit.ListEnnemies;
import unit.ListLarvas;
import unit.Unit;

public class Model {

	/*
	 * MVC useful components
	 */
	public View view;
	public Control control;
	public Sounds sounds;

	/*
	 * Interactive Elements
	 */
	public static ListLarvas larvas;
	public static ListEnnemies ennemies;
	public static ListRessources ressources;


	public Model (View v, Control c, Sounds s) {
		view = v;
		control = c;
		sounds = s;
		larvas = new ListLarvas();
		ennemies = new ListEnnemies();
		ressources = new ListRessources();
		

		control.setModel(this);
		view.setWindow();
		view.getGamePanel().setList(ressources, larvas, ennemies);
		view.getPlayerPanel().setControl(control);
		
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {	
					moskitoFocus();
					moskitoAttack();
					try {
						Thread.sleep(80);
					} catch(Exception e) {e.printStackTrace();}
				}
				
			}
			
		}).start();
	}

	/*
	 * Move the unit u to the point p
	 */
	public void deplacement (Point p, Unit u) {
		p.setLocation(p.getX()-(u.width/2), p.getY()-(u.heigth/2));
		u.setTargetedLocation(p);
	}
	
	/*
	 * Move the ennemy to the point P
	 */
	public void deplacementEnnemy(Point p, Unit u) {
		u.setTargetedLocation(p);
	}
	
	/*
	 * Move all the moskitos to the position of the last cocoon
	 */
	public void moskitoFocus () {
			for (Larva l : larvas.getElements()) {
				if(l.getLarvaState()==1) {
					for(Ennemy e : ennemies.getElements()) {
						deplacementEnnemy(l.getCoordinates(),e);
					}
				}		
			}
			
	}
	
	/*
	 * If a moskito attacks a larva or a cocoon, both of them die
	 */
	public void moskitoAttack() {
		for (Larva l : larvas.getElements()) {
			if(l.getLarvaState()<2) {
				for(Ennemy e : ennemies.getElements()) {
					if(e.unitIsInRange(l)) {
						Sounds.playDeadSounds();
						l.setHealth(0);
						e.setHealth(0);
					}
				}
			}		
		}
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
	public ListEnnemies getEnemies() {
		return ennemies;
	}

	public void setEnemies(ListEnnemies enemies) {
		this.ennemies = enemies;
	}

}
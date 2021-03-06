package mvc;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ressource.Ressource;
import unit.Unit;

public class Control implements MouseListener{

	/*
	 * Position of the last click
	 */
	private Point mouseClickedPosition = new Point();
	
	/*
	 * Buffer of the latest unit selected
	 */
	private Unit bufferedUnit;
	
	/*
	 * 
	 */
	private Ressource bufferedRessource;
	
	
	/*
	 * MVC useful components
	 */
	public Model model;
	
	public Control() {
		
	}	
	
	@Override
	/*
	 * change the oval position at each click
	 */
	public void mouseClicked(MouseEvent e) {
		// White bar is included in the coordinates, 'real' origin is (7;30)
		mouseClickedPosition = new Point(e.getX()-7,e.getY()-30);
		
		// If the player clicked on a friendly unit, save it in the buffer
		if (model.getLarvas().getClickedElement(mouseClickedPosition) != null) {
			bufferedUnit = model.getLarvas().getClickedElement(mouseClickedPosition);
		}
		// If an unit is saved in the buffer, move it to the player click
		else if (bufferedUnit != null) {
			// If the player clicked on a ressource
			if (model.getRessources().getClickedElement(mouseClickedPosition) != null) {
				bufferedUnit.setBufferedElement(model.getRessources().getClickedElement(mouseClickedPosition));
				model.deplacement(new Point(model.getRessources().getClickedElement(mouseClickedPosition).getCoordinates()), bufferedUnit);
			}
			else model.deplacement(mouseClickedPosition, bufferedUnit);
		}
		
		
		if(model.getRessources().getClickedElement(mouseClickedPosition) != null) {
			bufferedRessource = model.getRessources().getClickedElement(mouseClickedPosition);
		}
		else if (bufferedRessource != null) {
			if(bufferedRessource.getCapacity() == 0)
				bufferedRessource = null;
			if(model.getRessources().getClickedElement(mouseClickedPosition) != null)
				bufferedRessource.setBufferedElement(model.getRessources().getClickedElement(mouseClickedPosition));
		}
	}
	
	public Point getCursorPosition(Point pos) {
		return mouseClickedPosition;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	/*
	 * Getters and setters
	 */
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	public Unit getBufferedUnit() {
		return this.bufferedUnit;
	}
	
	public Ressource getBufferedRessource() {
		return this.bufferedRessource;
	}
}


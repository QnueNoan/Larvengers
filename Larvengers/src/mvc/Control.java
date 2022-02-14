package mvc;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ressource.ListRessources;
import unit.ListLarvas;

public class Control implements MouseListener{

	/*
	 * Position of the last click
	 */
	Point mouseClickedPosition = new Point();
	
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
		mouseClickedPosition = e.getPoint();
		model.deplacement(mouseClickedPosition);
		
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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}


package unit;

import java.awt.Point;

import element.Element;
import element.TypeElement;

/*
 * Ennemy class
 * Unit managed by AI
 * Ennemy will try to destroy the cocoon
 */
public class Ennemy extends Unit{

	public Ennemy(int h, int a, int s, TypeElement t) {
		super(h, a, s, t);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Point randomCoordinate() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	protected boolean action(Element bufferedElement) {
		// TODO Auto-generated method stub
		return true;
	}
}

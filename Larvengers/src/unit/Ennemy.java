package unit;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import element.Element;
import element.TypeElement;
import ressource.Ressource;

public class Ennemy extends Unit{
		
	/*
	 * Constant for larva caracteristics
	 */
	public static int health = 100;
	public static int speed = 5;
	
	
	public Ennemy () {
		super (health, 1, speed, TypeElement.MOSKITO);
		
	}

	@Override
	protected Point randomCoordinate() {
		return (new Point ( (int)(Math.random() * ((200-width - 100) + 1)) + 100,
				(int)(Math.random() * ((650-heigth - 550) + 1)) + 100));
	}
	

	@Override
	/*
	 * Do all the possible actions for the Moskito
	 */
	protected boolean action(Element bufferedElement) {
		if (bufferedElement.getElementType() == TypeElement.LARVA ||
		
				bufferedElement.getElementType() == TypeElement.COCOON) {
			this.setTargetedLocation(this.coordinates);
			return true;
		}
		return false;
	}
	


	

}


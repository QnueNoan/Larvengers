package unit;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import element.Element;
import element.TypeElement;

public abstract class Unit extends Element{
	/*
	 * attributs of the unit
	 * health : life points of the unit
	 * attackPoint : ennemy health's decreased for each attack
	 * speed : speed of the unit
	 * targetedLocation : position after unit deplacement
	 */
	private int health;
	private int attackPoint;
	private int speed;
	private Point targetedLocation;
	private int range;
	
	/*
	 * Constant for the range
	 */
	public static int RANGE = 15;
	
	/*
	 * Element focused by the Unit 
	 */
	private Element bufferedElement;
	
	public Unit (int h, int a, int s, TypeElement t) {
		super (t);
		this.health = h;
		this.attackPoint = a;
		this.speed = s;
		this.range = RANGE;
	}
	
	public Unit() {
		
	}
	
	/*
	 * Do an action on the bufferedElement
	 */
	protected abstract void action(Element bufferedElement);
	
	/*
	 * Change the position of the unit to be "newPosition"
	 * @param newPosition : new coordinate of the unit
	 */
	protected void deplacement(Point newPosition) {
		coordinates = newPosition;
	}
	
	/*
	 * Decreased the life of the opponent unit
	 * @param opponent : unit attacked
	 */
	protected void attack (Unit opponent) {
		opponent.setHealth(opponent.getHealth()-this.getAttackPoint());
	}
	
	/*
	 * Change the state of the unit depending of the modifications it receives
	 */
	@Override
	public void actualizeElement() {
		if (targetedLocation != null) {
			double distance = Math.sqrt((targetedLocation.y - coordinates.y) * (targetedLocation.y - coordinates.y) 
					+ (targetedLocation.x - coordinates.x) * (targetedLocation.x - coordinates.x));
			double speedRatio = (distance/speed);
			double deltaX;
			double deltaY;
			if (speedRatio < 1) {
				coordinates.x = targetedLocation.x;
				coordinates.y = targetedLocation.y;
			}
			else {
				coordinates.x += (int)(targetedLocation.x - coordinates.x) / speedRatio;
				coordinates.y += (int)(targetedLocation.y - coordinates.y) / speedRatio;
			}
		}
		if (bufferedElement!=null && bufferedElementIsInRange()) {
			action(bufferedElement);
		}		
	}
	
	// check if the Element in the unit's buffer is in its range
	public boolean bufferedElementIsInRange() {
		if ( Math.sqrt((bufferedElement.getCoordinates().x-coordinates.x)*(bufferedElement.getCoordinates().x-coordinates.x) + (bufferedElement.getCoordinates().y-coordinates.y)*(bufferedElement.getCoordinates().y-coordinates.y)) <= range) {
			return true;
		}
		else return false;
	}
	
	/*
	 * Getters and setters
	 */
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttackPoint() {
		return attackPoint;
	}

	public void setAttackPoint(int attackPoint) {
		this.attackPoint = attackPoint;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Point getTargetedLocation() {
		return targetedLocation;
	}

	public void setTargetedLocation(Point targetedLocation) {
		this.targetedLocation = targetedLocation;
	}

	public Element getBufferedElement() {
		return bufferedElement;
	}

	public void setBufferedElement(Element bufferedElement) {
		this.bufferedElement = bufferedElement;
	}	
	
}

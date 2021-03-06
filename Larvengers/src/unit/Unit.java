package unit;

import java.awt.Point;
import java.util.concurrent.TimeUnit;


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
	public static int RANGE = 50;
	
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
	 * Do all the possible things for the bufferedElement
	 */
	protected abstract boolean action(Element bufferedElement);
	
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
		opponent.setHealth(opponent.getHealth() - this.getAttackPoint());
	}
	
	/*
	 * Change the state of the unit depending of the modifications it receives
	 */
	@Override
	public void actualizeElement() {
		if (bufferedElement!=null && bufferedElementIsInRange()) {
			boolean realize = action(bufferedElement);
			// put a cooldown on action like eating or attacking
			if (realize)
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		// If the unit can move and need to move
		if (speed > 0 && targetedLocation != null) {
			double distance = Math.sqrt((targetedLocation.y - coordinates.y) * (targetedLocation.y - coordinates.y) 
					+ (targetedLocation.x - coordinates.x) * (targetedLocation.x - coordinates.x));
			// number of pixel to move for the thread iteration
			double speedRatio = (distance/speed);
			// if the unit is very close to the objective, its position become the objective
			if (speedRatio < 1) {
				coordinates.x = targetedLocation.x;
				coordinates.y = targetedLocation.y;
			}
			// otherwise move of the calculated distance with the speed 
			else {
				coordinates.x += (int)(targetedLocation.x - coordinates.x) / speedRatio;
				coordinates.y += (int)(targetedLocation.y - coordinates.y) / speedRatio;
			}
		}	
	}
	
	// check if the Element in the unit's buffer is in its range
	public boolean bufferedElementIsInRange() {
		return (Math.sqrt((bufferedElement.getCoordinates().x-coordinates.x)*(bufferedElement.getCoordinates().x-coordinates.x) + (bufferedElement.getCoordinates().y-coordinates.y)*(bufferedElement.getCoordinates().y-coordinates.y)) <= range);
	}
	
	// check if a Unit is in range
	public boolean unitIsInRange(Unit u) {
		return (Math.sqrt((u.getCoordinates().x-coordinates.x)*(u.getCoordinates().x-coordinates.x) + (u.getCoordinates().y-coordinates.y)*(u.getCoordinates().y-coordinates.y)) <= range);
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
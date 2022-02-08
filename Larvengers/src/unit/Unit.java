package unit;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public abstract class Unit {
	/*
	 * attributs of the unit
	 * coordinate : position of the unit
	 * health : life points of the unit
	 * attackPoint : ennemy health's decreased for each attack
	 * speed : speed of the unit
	 */
	private Point coordinate;
	private int health;
	private int attackPoint;
	private int speed;
	
	/*
	 * Define the type of unit
	 */
	private static int unitType;
	
	public Unit (int h, int a, int s, int u) {
		this.coordinate= randomCoordinate();
		this.health = h;
		this.attackPoint = a;
		this.speed = s;
		this.unitType = u;
		
	}
	
	/*
	 * Generate randomly the position of the unit at its creation
	 */
	protected abstract Point randomCoordinate();
	
	/*
	 * Change the position of the unit to be "newPosition"
	 * @param newPosition : new coordinate of the unit
	 */
	protected void deplacement(Point newPosition) {
		coordinate = newPosition;
	}
	
	/*
	 * Decreased the life of the opponent unit
	 * @param opponent : unit attacked
	 */
	protected void attack (Unit opponent) {
		opponent.setHealth(opponent.getHealth()-this.getAttackPoint());
	}
	
	/*
	 * Getters and setters
	 */
	public Point getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Point coordinate) {
		this.coordinate = coordinate;
	}

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

	public static int getUnitType() {
		return unitType;
	}

	public static void setUnitType(int unitType) {
		Unit.unitType = unitType;
	}	
}

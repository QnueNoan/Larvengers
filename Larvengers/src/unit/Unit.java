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
	 */
	private int health;
	private int attackPoint;
	private int speed;
	
	public Unit (int h, int a, int s, TypeElement t) {
		super (t);
		this.health = h;
		this.attackPoint = a;
		this.speed = s;
	}
	
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
	
	
	
}

package unit;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import element.TypeElement;
import mvc.View;
import ressource.Ressource;

public class Larva extends Unit{
	/*
	 * Larva attributs to manage the cocoon evolution
	 * picklesEaten : number of ressource "pickle" eaten
	 * cocktailDrunk : number of ressource "coktail" eaten
	 * larvaState : actual state of the larva
	 */
	private int picklesEaten;
	private int cocktailDrunk;
	private int larvaState;
	
	/*
	 * Constant for evolution
	 * picklesToEvolve : number of ressource "pickle" that the larve need to eat before evolving
	 * cocktailToEvolve : number of ressource "coktail" that the larve need to eat before evolving
	 */
	public static int picklesToEvolve = 10;
	public static int cocktailToEvolve = 10;
	
	/*
	 * Constant for larva caracteristics
	 */
	public static int health = 100;
	public static int speed = 5;
	
	public Larva () {
		super (health, 1, speed, TypeElement.LARVA);
		picklesEaten = 0;
		cocktailDrunk = 0;
		larvaState = 0;
	}
	
	@Override
	protected Point randomCoordinate() {
		return (new Point ( (int)(Math.random() * ((View.widthBackground-width - 0) + 1)) + 0,
				(int)(Math.random() * ((View.heigthBackground-heigth - 0) + 1)) + 0));
	}
	
	/*
	 * Evolve the larva into cocoon if the number of ressources eaten is enough
	 */
	public void evolve () {
		if (larvaState == 0 && picklesEaten == picklesToEvolve && cocktailDrunk == cocktailToEvolve) {
			larvaState = 1;
			setHealth(100);
		}
	}
	
	/*
	 * 
	 */
	public void eatRessources (Ressource r) {
		if (this.larvaState != 1 && r.getCapacity()>1) {
			switch(r.getElementType()) {
				case PICKLE:
					this.picklesEaten++;
					break;
				case COCKTAIL:
				    this.cocktailDrunk++;
				    break;
				case POOP:
					if ( (int)(Math.random() * ((2 - 1) + 1)) + 1 == 1) {
						picklesEaten=picklesToEvolve;
						cocktailDrunk=cocktailToEvolve;
					};
					
					break;
			}
			r.decrease();
			this.setAttackPoint(this.cocktailDrunk + this.picklesEaten);
		}
	}

	/*
	 * Getters and setters
	 */
	public int getPicklesEaten() {
		return picklesEaten;
	}

	public void setPicklesEaten(int picklesEaten) {
		this.picklesEaten = picklesEaten;
	}

	public int getCocktailDrunk() {
		return cocktailDrunk;
	}

	public void setCocktailDrunk(int cocktailDrunk) {
		this.cocktailDrunk = cocktailDrunk;
	}

	public int getLarvaState() {
		return larvaState;
	}

	public void setLarvaState(int larvaState) {
		this.larvaState = larvaState;
	}

	public static int getPicklesToEvolve() {
		return picklesToEvolve;
	}

	public static void setPicklesToEvolve(int picklesToEvolve) {
		Larva.picklesToEvolve = picklesToEvolve;
	}

	public static int getCocktailToEvolve() {
		return cocktailToEvolve;
	}

	public static void setCocktailToEvolve(int cocktailToEvolve) {
		Larva.cocktailToEvolve = cocktailToEvolve;
	}

}

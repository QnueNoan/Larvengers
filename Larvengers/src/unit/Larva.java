package unit;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

import element.Element;
import element.TypeElement;
import ressource.Ressource;
import sound.Sounds;

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
	 * picklesToEvolve : number of ressource "pickle" that the larva need to eat before evolving
	 * cocktailToEvolve : number of ressource "coktail" that the larva need to eat before evolving
	 */
	public static int picklesToEvolve = 10;
	public static int cocktailToEvolve = 10;
	
	/*
	 * Constant for larva caracteristics
	 */
	public static int health = 100;
	public static int speed = 5;
	
	/*
	 * Time for the cocoon before becoming a butterfly
	 */
	private Timer timerBeforeButterfly;
	// counter 
	private int timeLeftBeforeButterfly;
	
	public Larva () {
		super (health, 1, speed, TypeElement.LARVA);
		picklesEaten = 0;
		cocktailDrunk = 0;
		larvaState = 0;
	}

	@Override
	/*
	 * Generate random coordinate among the larva spawn point
	 */
	protected Point randomCoordinate() {
		return (new Point ( (int)(Math.random() * ((200-width - 100) + 1)) + 100,
				(int)(Math.random() * ((650-heigth - 550) + 1)) + 550));
	}
	
	/*
	 * Evolve the larva into cocoon if the number of ressources eaten is enough
	 */
	public void evolve () {
		if (larvaState == 0 && picklesEaten >= picklesToEvolve && cocktailDrunk >= cocktailToEvolve) {
			larvaState = 1;
			this.setElementType(TypeElement.COCOON);
			setHealth(100);
			setSpeed(0);
			timerBeforeButterfly = new Timer();
			timeLeftBeforeButterfly = 0;
			Sounds.playCocoonAudio();
			//the timer will repeat the action as long as counter =< 59
			timerBeforeButterfly.scheduleAtFixedRate(new TimerTask() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
				setTimeLeftBeforeButterfly(getTimeLeftBeforeButterfly() + 1);
				if(getTimeLeftBeforeButterfly() >= 60) {
					timerBeforeButterfly.cancel();
					setElementType(TypeElement.BUTTERFLY);
			        setLarvaState(2);
			        setSpeed(1);
				}
				}
				
			}, 100,1000);
		}
	}
	
	
	@Override
	/*
	 * Do all the possible actions for the larva
	 */
	protected boolean action(Element bufferedElement) {
		// if the action of the larva was a ressource
		if (bufferedElement.getElementType() == TypeElement.PICKLE ||
				bufferedElement.getElementType() == TypeElement.COCKTAIL ||
				bufferedElement.getElementType() == TypeElement.POOP) {
			eatRessources((Ressource) bufferedElement);
			// Move the larva towards the ressource
			this.setTargetedLocation(this.coordinates);
			return true;
		}
		return false;
	}
	
	/*
	 * Decrease the ressource amount of 1, increase the 'RessourceType' eated by 1 and modify the larva stats
	 */
	public void eatRessources (Ressource r) {
		if (this.larvaState != 1 && r.getCapacity()>=1) {
			switch(r.getElementType()) {
				case PICKLE:
					this.picklesEaten++;
					break;
				case COCKTAIL:
				    this.cocktailDrunk++;
				    break;
				case POOP:
					// 50% chance to maximize the ressources eaten
					if ( (int)(Math.random() * ((2 - 1) + 1)) + 1 == 1) {
						picklesEaten=picklesToEvolve;
						cocktailDrunk=cocktailToEvolve;
					}
					// or to minimize these
					else {
						picklesEaten = 0;
						cocktailDrunk = 0;
					};
					
					break;
			}
			Sounds.playEatSounds();
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
	
	public int getTimeLeftBeforeButterfly() {
		return this.timeLeftBeforeButterfly;
	}
	public void setTimeLeftBeforeButterfly(int timeleftbeforebutterfly) {
		this.timeLeftBeforeButterfly = timeleftbeforebutterfly;
	}

}

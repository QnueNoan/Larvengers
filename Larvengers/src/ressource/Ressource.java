package ressource;

import java.awt.Point;
import java.util.Random;

import mvc.View;

public class Ressource {
	
	/*
	 * capacity : Integer attribute about the 
	 * coordinates : Point attribute 
	 */
	private int capacity;
	private Point coordinates;
	
	/*
	 * type : TypeRessource attribute
	 */
	private TypeRessource type;
	
	/**
	 * random_type : Random attribute used to define the type of the ressource
	 * random_ capacity : Random attribute used to define the final capacity of the ressource
	 */
	private static final Random random_type = new Random();
	private static final Random random_capacity = new Random();
	
	/**
	 * randomX : 
	 * randomY : 
	 */
	private static final Random randomX = new Random();
	private static final Random randomY = new Random();
	/**
	 * MIN_CAPACITY : Constant of the minimum value for a capacity
	 * MAX_CAPACITY : Constant of the maximum for a capacity
	 */
	private static final int MIN_CAPACITY = 5;
	private static final int MAX_CAPACITY = 20;
	
	/*
	 * MIN_TYPE : Constant of the minimum value for the type
	 * MAX_TYPE : Constant of the maximum value for the type
	 * 
	 */
	private static final int MIN_TYPE = 0;
	private static final int MAX_TYPE = 2;
	/*
	 * Constructor Ressource
	 */
	public Ressource() {
		init_type();
		init_capacity();
		init_coordinates();
	}
	
	/*
	 * Method init_type() : Initialize the specific type of the ressource thanks to the Enum TypeRessource
	 * We use a random number between 0 and 2 to define the type
	 */
	private void init_type() {
		int v = random_type.nextInt((MAX_TYPE - MIN_TYPE + 1) + MIN_TYPE);
		switch(v) {
		case 0 :
			type = TypeRessource.PICKLE;
			break;
		case 1 : 
			type = TypeRessource.COCKTAIL;
			break;
		case 2 : 
			type = TypeRessource.POOP;
			break;
		default:
			break;
		}
	}
	/*
	 * Method init_capacity : Initialize the random capacity of the ressource
	 * if the type is "poop" then the capacity will be divided by 2
	 */
	private void init_capacity() {
		if(this.type == TypeRessource.POOP)
			this.capacity = random_capacity.nextInt((MAX_CAPACITY - MIN_CAPACITY) + MIN_CAPACITY) / 2;
		else
			this.capacity = random_capacity.nextInt((MAX_CAPACITY - MIN_CAPACITY) + MIN_CAPACITY);
	}
	
	private void init_coordinates() {
		double x, y;
		x = 100 + (View.widthBackground - 100 - 50)*randomX.nextDouble();
		y = 100 + (View.heigthBackground - 200)*randomY.nextDouble();
		this.coordinates = new Point();
		this.coordinates.setLocation(x, y);
	}
	/**
	 * Method getCapacity() : return the remain capacity of the ressource
	 * @return capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/*
	 * Method decrease : Decrease the value of the capacity
	 * @param int
	 */
	public void decrease() {
		this.capacity --;
	}
	
	/*
	 * Method getCoordinates : return the current coordinates of the ressource on the map
	 * @return coordinates
	 */
	public Point getCoordinates() {
		return this.coordinates;
	}

	/*
	 * Method getTypeRessource : return the specific type of the ressource
	 * @return typeRessource
	 */
	public TypeRessource getTypeRessource() {
		return this.type;
	}
	
}
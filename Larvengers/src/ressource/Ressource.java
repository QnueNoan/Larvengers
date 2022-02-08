package ressource;

import java.awt.Point;
import java.util.Random;

import element.Element;
import element.TypeElement;
import mvc.View;

public class Ressource extends Element{
	
	/*
	 * capacity : Integer attribute about the 
	 * coordinates : Point attribute 
	 */
	private int capacity;

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
	
	public Ressource() {
		super(init_type());
		init_type();
		init_capacity();
	}
	
	/*
	 * Method init_type() : Initialize the specific type of the ressource thanks to the Enum TypeRessource
	 * We use a random number between 0 and 2 to define the type
	 */
	private static TypeElement init_type() {
		int v = new Random().nextInt((MAX_TYPE - MIN_TYPE + 1) + MIN_TYPE);
		switch(v) {
		case 0 :
			return TypeElement.PICKLE;
		case 1 : 
			return TypeElement.COCKTAIL;
		case 2 : 
			return TypeElement.POOP;
		default :
			return null;
		}
	}
	/*
	 * Method init_capacity : Initialize the random capacity of the ressource
	 * if the type is "poop" then the capacity will be divided by 2
	 */
	private void init_capacity() {
		if(getElementType() == TypeElement.POOP)
			this.capacity = new Random().nextInt((MAX_CAPACITY - MIN_CAPACITY) + MIN_CAPACITY) / 2;
		else
			this.capacity = new Random().nextInt((MAX_CAPACITY - MIN_CAPACITY) + MIN_CAPACITY);
	}
	
	@Override
	public Point randomCoordinate() {
		return (new Point (
				(int) (100 + (View.widthBackground - 100 - 50)*new Random().nextDouble()),
				(int) (100 + (View.heigthBackground - 200)*new Random().nextDouble())) );
	}
	
	/*
	 * Method decrease : Decrease the value of the capacity
	 * @param int
	 */
	public void decrease() {
		this.capacity --;
	}
	
	/*
	 * Getters and setters
	 */
	
	public int getCapacity() {
		return capacity;
	}

}
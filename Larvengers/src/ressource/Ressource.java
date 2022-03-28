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
	
	/*
	 * Image size
	 */
	private final int HEIGHT_IMG = 600;
	private final int WIDTH_IMG = 650;
	
	public Ressource() {
		super(init_type());
		init_capacity();
	}
	
	/*
	 * Constructor for testing
	 */
	public Ressource(TypeElement t, Point coord) {
		super (t);
		this.setCoordinates(coord);
		init_capacity();
	}
	
	/*
	 * Method init_type() : Initialize the specific type of the ressource thanks to the Enum TypeRessource
	 * We use a random number between 0 and 2 to define the type
	 */
	public static TypeElement init_type() {
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
	 * if the type is "poop" then the capacity is 1
	 */
	private void init_capacity() {
		if(getElementType() == TypeElement.POOP)
			this.capacity = 1;
		else
			this.capacity = new Random().nextInt((MAX_CAPACITY - MIN_CAPACITY) + MIN_CAPACITY);
	}
	
	@Override
	/*
	 * generate random coordinate among the playing area for new ressources
	 * the ressources can't be generate at the bottom of the map (larva spawn)
	 */
	public Point randomCoordinate() {
		return (new Point (
				(int) (100 + (View.widthBackground - 100 - 50)*new Random().nextDouble()),
				(int) (100 + (View.heigthBackground - 300)*new Random().nextDouble())) );
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

	public int getHEIGHT_IMG() {
		return HEIGHT_IMG;
	}

	public int getWIDTH_IMG() {
		return WIDTH_IMG;
	}

	@Override
	public void actualizeElement() {
		// TODO Auto-generated method stub
		
	}

}
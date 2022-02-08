package element;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/*
 * Abstract class for all in-game element
 */
public abstract class Element {

	/*
	 * Attributs of the Element
	 * coordinate : 2D position of the element
	 * TypeElement : type of the element
	 */
	protected Point coordinates;
	protected TypeElement elementType;
	
	/*
	 * Image attributs
	 */
	public static int width;
	public static int heigth;
	public static ImageIcon spriteTmp;
	public static Image sprite;
	
	public Element (TypeElement t) {
		coordinates = randomCoordinate();
		initImage(t);
	}
	
	/*
	 * Initialise the image attributs according to the elementType
	 */
	protected void initImage (TypeElement t) {
		switch(t) {
		case PICKLE :
			spriteTmp = new ImageIcon(getClass().getResource("/assets/berry_bush.png"));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case COCKTAIL : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/berry_bush.png"));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case POOP : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/berry_bush.png"));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case LARVA : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/larva.jpg"));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case COCOON : 
			spriteTmp = new ImageIcon(getClass().getResource(""));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case BUTTERFLY : 
			spriteTmp = new ImageIcon(getClass().getResource(""));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		case MOSKITO : 
			spriteTmp = new ImageIcon(getClass().getResource(""));
			this.spriteTmp.getImage();
			width = 0;
			heigth = 0;
			break;
		}
	}
	
	/*
	 * Generate randomly the position of the element at its creation
	 * @return the calculed Point
	 */
	protected abstract Point randomCoordinate();

	/*
	 * Getters and setters
	 */
	public Point getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public TypeElement getElementType() {
		return elementType;
	}

	public void setElementType(TypeElement elementType) {
		this.elementType = elementType;
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int width) {
		Element.width = width;
	}

	public static int getHeigth() {
		return heigth;
	}

	public static void setHeigth(int heigth) {
		Element.heigth = heigth;
	}

	public static ImageIcon getSpriteTmp() {
		return spriteTmp;
	}

	public static void setSpriteTmp(ImageIcon spriteTmp) {
		Element.spriteTmp = spriteTmp;
	}

	public static Image getSprite() {
		return sprite;
	}

	public static void setSprite(Image sprite) {
		Element.sprite = sprite;
	}
}

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
	public int width;
	public int heigth;
	public ImageIcon spriteTmp;
	public Image sprite;
	
	/*
	 * At its creation, the element will refresh its state with a thread
	 */
	public Element (TypeElement t) {
		initImage(t);
		coordinates = randomCoordinate();
		
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {
					actualizeElement();
					try {
						Thread.sleep(80);
					} catch(Exception e) {e.printStackTrace();}
				}
				
			}
			
		}).start();
	}
	
	public Element() {
		
	}
	
	/*
	 * Change the state of the element depending of the modifications it receives
	 */
	public abstract void actualizeElement();
	
	/*
	 * Initialise the image attributs according to the elementType
	 */
	protected void initImage (TypeElement t) {
		elementType = t;
		switch(t) {
		case PICKLE :
			this.spriteTmp = new ImageIcon(getClass().getResource("/assets/bush_pickle.png"));
			sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case COCKTAIL : 
			this.spriteTmp = new ImageIcon(getClass().getResource("/assets/bush_cocktail.png"));
			sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case POOP : 
			this.spriteTmp = new ImageIcon(getClass().getResource("/assets/bush_poop.png"));
			this.sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case LARVA : 
			this.spriteTmp = new ImageIcon(getClass().getResource("/assets/larva1.png"));
			this.sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case COCOON : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/cocoon.png"));
			sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case BUTTERFLY : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/butterfly.png"));
			sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
			break;
		case MOSKITO : 
			spriteTmp = new ImageIcon(getClass().getResource("/assets/moskito.png"));
			sprite = this.spriteTmp.getImage();
			width = 50;
			heigth = 50;
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
	public void setImage (String path, int width, int heigth) {
		
	}
	
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
		initImage(elementType);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public ImageIcon getSpriteTmp() {
		return spriteTmp;
	}

	public void setSpriteTmp(ImageIcon spriteTmp) {
		this.spriteTmp = spriteTmp;
	}

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
}

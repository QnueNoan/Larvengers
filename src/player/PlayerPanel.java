package player;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import element.TypeElement;
import unit.Larva;
import mvc.Control;
import mvc.View;

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel{
	
	/*
	 * Width and height of the panel
	 */
	public static int widthPanel = View.WIDTH - View.widthBackground;
	public static  int heightPanel = View.heigthBackground;
	/*
	 * Width and height of the button
	 */
	private static final int widthButton = 230;
	private static final int heightButton = 40;
	
	/*
	 * Coordinates for the buttons
	 */
	private static final int X_button = 15;
	private static final int Y_EvolveButton = 150;
	private static final int Y_AttackButton = 200;
	/*
	 * Buttons for the larva's actions
	 */
	private JButton evolveButton, attackButton;
	
	/*
	 * Coordinates for the stats of the larvas
	 */
	private static final int width_LABEL = 200;
	private static final int height_LABEL = 40;
	
	private static final int X_HP = 15;
	private static final int Y_HP = 300;
	
	private static final int X_SPEED = 15;
	private static final int Y_SPEED = 315;
	
	private static final int X_PICKLES = 15;
	private static final int Y_PICKLES = 330;
	
	private static final int X_COCKTAILS = 15;
	private static final int Y_COCKTAILS = 345;
	
	private ImageIcon background;
	private Image imgBackground;
	
	private Control control;
	private JLabel hp, speed, pickles, cocktails;
	
	public PlayerPanel() {
		this.background = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
		this.imgBackground = this.background.getImage();
		
		setPanel();
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {
					if(control != null && control.getBufferedUnit() != null) {
						if(control.getBufferedUnit().getElementType() == TypeElement.LARVA) {
							Larva larva = (Larva) control.getBufferedUnit();
							addInformationsUnit(larva);
							evolveToCocoonPossible(larva);
						}
					}
					revalidate();
					repaint();
					try {
						Thread.sleep(41);
					} catch(Exception e) {e.printStackTrace();}
				}
				
			}
			
		}).start();
	}
	
	private void addInformationsUnit(Larva larva) {
		if(hp != null && speed != null && pickles != null && cocktails != null) {
			this.remove(hp);
			this.remove(speed);
			this.remove(pickles);
			this.remove(cocktails);
		}
		hp = new JLabel();
		hp.setText("Hp : " + larva.getHealth());
		hp.setBounds(X_HP, Y_HP, width_LABEL, height_LABEL);
		hp.setVisible(true);
		this.add(hp);
		
		speed = new JLabel();
		speed.setText("Speed : " + larva.getSpeed());
		speed.setBounds(X_SPEED, Y_SPEED, width_LABEL, height_LABEL);
		speed.setVisible(true);
		this.add(speed);
		
		pickles = new JLabel();
		pickles.setText("Pickles : " + larva.getPicklesEaten() + "/"+ larva.getPicklesToEvolve());
		pickles.setBounds(X_PICKLES, Y_PICKLES, width_LABEL, height_LABEL);
		pickles.setVisible(true);
		this.add(pickles);
		
		cocktails = new JLabel();
		cocktails.setText("Cocktails : " + larva.getCocktailDrunk() + "/"+ larva.getCocktailToEvolve());
		cocktails.setBounds(X_COCKTAILS, Y_COCKTAILS, width_LABEL, height_LABEL);
		cocktails.setVisible(true);
		this.add(cocktails);
	}
	/*
	 * This function allows to initialize the player's control panel
	 */
	private void setPanel() {
		this.setSize(widthPanel, heightPanel);
		this.setBounds(View.widthBackground, 0, widthPanel, heightPanel);
		this.setLayout(null);
		setViewButton();
		this.setVisible(true);
	}
	
	/*
	 * Paint the different parts of the game
	 * @Override
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//paintBackground(g);
	}
	
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintBackground(Graphics g) {
		g.drawImage(this.imgBackground, 0, 0, widthPanel, heightPanel, null);
	}

	/*
	 * This function allows to define the parameters of the buttons
	 */
	private void setViewButton() {
		evolveButton = new JButton("COCOON MODE");
		evolveButton.setBounds(X_button, Y_EvolveButton, widthButton, heightButton);
		evolveButton.setVisible(true);
		evolveButton.setEnabled(false);
		this.add(evolveButton);
		
		attackButton = new JButton("COUP DE BOULE");
		attackButton.setBounds(X_button, Y_AttackButton, widthButton, heightButton);
		attackButton.setVisible(true);
		this.add(attackButton);
	}
	
	/*
	 * Getters for the dimension of the control panel
	 */
	public int getWidth() {
		return this.widthPanel;
	}
	
	public int getHeight() {
		return this.heightPanel;
	}
	
	public void evolveToCocoonPossible(Larva larva) {
		if (larva.getPicklesEaten() >= 10 && larva.getCocktailDrunk() >= 10) {
			evolveButton.setEnabled(true);
			CocoonButtonClicked();
		}
		else
			evolveButton.setEnabled(false);
	}
	
	public void CocoonButtonClicked() {
		evolveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(control != null && control.getBufferedUnit() != null) {
            		Larva larva = (Larva) control.getBufferedUnit();
            		larva.evolve();
            		control.getBufferedUnit().setBufferedElement(larva);
            		System.out.println("EVOLUTION " + larva.getLarvaState());
            	}
            }
        });
	}
	/*
	 * Getters for the buttons
	 */
	public JButton getEvolveButton() {
		return this.evolveButton;
	}
	public JButton getAttackButton() {
		return this.attackButton;
	}
	public void setControl(Control ctrl) {
		this.control = ctrl;
	}
}

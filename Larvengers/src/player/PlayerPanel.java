package player;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

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
	
	private static final int X_PICKLES = 15;
	private static final int Y_PICKLES = 350;
	
	private static final int X_COCKTAILS = 15;
	private static final int Y_COCKTAILS = 400;
	
	private static final int X_HPBAR = 15;
	private static final int Y_HPBAR = 330;
	
	private static final int X_PICKLESBAR = 15;
	private static final int Y_PICKLESBAR = 380;
	
	private static final int X_COCKTAILSBAR = 15;
	private static final int Y_COCKTAILSBAR = 430;
	
	/*
	 * Width and length for all the progressBar
	 */
	private static final int widthBar = 200;
	private static final int heightBar = 15;
	
	/*
	 * Score made by the player
	 */
	private int score;
	
	private ImageIcon background;
	private Image imgBackground;
	
	private Control control;
	private JLabel scoreText, hp, pickles, cocktails;
	private JProgressBar hpBar, picklesBar, cocktailsBar;
	
	
	public PlayerPanel() {
		this.background = new ImageIcon(getClass().getResource("/assets/Bg.jpg"));
		this.imgBackground = this.background.getImage();
		
		setPanel();
		(new Thread() {
			@Override
			public synchronized void run() {
				while (true) {
					scoreText();
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
	
	private void scoreText() {
		if(control != null) {
			this.remove(scoreText);
			score = 0;
			for(Larva l : control.getModel().getLarvas().getElements()) {
				if (l.getLarvaState() == 2) {
					score += 1;
				}
			}
		}
		
		scoreText = new JLabel();
		scoreText.setText("Score : " + score);
		scoreText.setBounds(10, 10, width_LABEL, height_LABEL);
		scoreText.setVisible(true);
		this.add(scoreText);
	}
	
	private void addInformationsUnit(Larva larva) {
		if(hp != null && pickles != null && cocktails != null && hpBar != null && picklesBar != null && cocktailsBar != null) {
			this.remove(hp);
			this.remove(pickles);
			this.remove(cocktails);
			this.remove(hpBar);
			this.remove(picklesBar);
			this.remove(cocktailsBar);
		}
		
		hp = new JLabel();
		hp.setText("Hp");
		hp.setBounds(X_HP, Y_HP, width_LABEL, height_LABEL);
		hp.setVisible(true);
		this.add(hp);
		
		hpBar = new JProgressBar(0, 100);
		hpBar.setBounds(X_HPBAR, Y_HPBAR, width_LABEL, height_LABEL);
		hpBar.setValue((larva.getHealth() * 10));
		hpBar.setStringPainted(true); 
		hpBar.setForeground(Color.RED);
		hpBar.setSize(widthBar, heightBar);
		this.add(hpBar);
		
		
		pickles = new JLabel();
		pickles.setText("Pickles");
		pickles.setBounds(X_PICKLES, Y_PICKLES, width_LABEL, height_LABEL);
		pickles.setVisible(true);
		this.add(pickles);
		
		picklesBar = new JProgressBar(0, 100);
		picklesBar.setBounds(X_PICKLESBAR, Y_PICKLESBAR, width_LABEL, height_LABEL);
		picklesBar.setValue((larva.getPicklesEaten() * 10));
		picklesBar.setStringPainted(true); 
		picklesBar.setForeground(Color.GREEN);
		picklesBar.setSize(widthBar, heightBar);
		this.add(picklesBar);
		
		cocktails = new JLabel();
		cocktails.setText("Cocktails");
		cocktails.setBounds(X_COCKTAILS, Y_COCKTAILS, width_LABEL, height_LABEL);
		cocktails.setVisible(true);
		this.add(cocktails);
		
		cocktailsBar = new JProgressBar(0, 100);
		cocktailsBar.setBounds(X_COCKTAILSBAR, Y_COCKTAILSBAR, width_LABEL, height_LABEL);
		cocktailsBar.setValue((larva.getCocktailDrunk() * 10));
		cocktailsBar.setStringPainted(true); 
		cocktailsBar.setForeground(Color.MAGENTA);
		cocktailsBar.setSize(widthBar, heightBar);
		this.add(cocktailsBar);
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
		if (larva.getPicklesEaten() >= 10 && larva.getCocktailDrunk() >= 10 && larva.getLarvaState() == 0) {
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

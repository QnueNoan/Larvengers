package player;


import java.awt.Color;
import java.awt.Font;
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
import ressource.Ressource;

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
	private static final int Y_HP = 295;
	
	private static final int X_PICKLES = 15;
	private static final int Y_PICKLES = 345;
	
	private static final int X_COCKTAILS = 15;
	private static final int Y_COCKTAILS = 395;
	
	private static final int X_HPBAR = 15;
	private static final int Y_HPBAR = 330;
	
	private static final int X_PICKLESBAR = 15;
	private static final int Y_PICKLESBAR = 380;
	
	private static final int X_COCKTAILSBAR = 15;
	private static final int Y_COCKTAILSBAR = 430;
	
	private static final int X_LABEL_CAPACITY = 10;
	private static final int Y_LABEL_CAPACITY = 560;
	
	private static final int X_LABEL_RESSOURCETYPE = 10;
	private static final int Y_LABEL_RESSOURCETYPE = 535;
	
	private static final int X_TIMER = 15;
	private static final int Y_TIMER = 445;
	
	private static final int X_COCOONBAR = 15;
	private static final int Y_COCOONBAR = 480;
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
	private JLabel scoreText, hp, pickles, cocktails, capacity, ressourceType, timerCocoon;
	private JProgressBar hpBar, picklesBar, cocktailsBar, cocoonBar;
	
	
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
						else if(control.getBufferedUnit().getElementType() == TypeElement.COCOON)
								addTimerCocoon((Larva) control.getBufferedUnit());
					}
					
					if(control != null && control.getBufferedRessource() != null) {
						addInformationsRessource(control.getBufferedRessource());
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
	
	/*
	 * Function to display the score of the player
	 */
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
		scoreText.setFont(new Font("Verdana", Font.BOLD, 18));
		scoreText.setText("Score : " + score);
		scoreText.setBounds(88, 50, width_LABEL, height_LABEL);
		scoreText.setVisible(true);
		this.add(scoreText);
	}
	
	/*
	 * Function to add all the informations from the larva to the panel
	 */
	private void addInformationsUnit(Larva larva) {
		if(hp != null && pickles != null && cocktails != null && hpBar != null && picklesBar != null && cocktailsBar != null) {
			this.remove(hp);
			this.remove(pickles);
			this.remove(cocktails);
			this.remove(hpBar);
			this.remove(picklesBar);
			this.remove(cocktailsBar);
		}
		if(cocoonBar != null && timerCocoon != null) {
			this.remove(cocoonBar);
			this.remove(timerCocoon);
		}
		
		hp = new JLabel();
		hp.setForeground(Color.decode("#DFA815"));
		hp.setFont(new Font("SansSerif", Font.BOLD, 25));
		hp.setText("Hp");
		hp.setBounds(X_HP, Y_HP, width_LABEL, height_LABEL);
		hp.setVisible(true);
		this.add(hp);
		
		hpBar = new JProgressBar(0, 100);
		hpBar.setBounds(X_HPBAR, Y_HPBAR, width_LABEL, height_LABEL);
		hpBar.setValue((larva.getHealth() * 10));
		hpBar.setStringPainted(true); 
		hpBar.setForeground(Color.decode("#DFA815"));
		hpBar.setSize(widthBar, heightBar);
		this.add(hpBar);
		
		
		pickles = new JLabel();
		pickles.setForeground(Color.decode("#A8E8EB"));
		pickles.setFont(new Font("SansSerif", Font.BOLD, 25));
		pickles.setText("Pickles");
		pickles.setBounds(X_PICKLES, Y_PICKLES, width_LABEL, height_LABEL);
		pickles.setVisible(true);
		this.add(pickles);
		
		picklesBar = new JProgressBar(0, 100);
		picklesBar.setBounds(X_PICKLESBAR, Y_PICKLESBAR, width_LABEL, height_LABEL);
		picklesBar.setValue((larva.getPicklesEaten() * 10));
		picklesBar.setStringPainted(true); 
		picklesBar.setForeground(Color.decode("#A8E8EB"));
		picklesBar.setSize(widthBar, heightBar);
		this.add(picklesBar);
		
		cocktails = new JLabel();
		cocktails.setForeground(Color.decode("#EDA4BB"));
		cocktails.setFont(new Font("SansSerif", Font.BOLD, 25));
		cocktails.setText("Cocktails");
		cocktails.setBounds(X_COCKTAILS, Y_COCKTAILS, width_LABEL, height_LABEL);
		cocktails.setVisible(true);
		this.add(cocktails);
		
		cocktailsBar = new JProgressBar(0, 100);
		cocktailsBar.setBounds(X_COCKTAILSBAR, Y_COCKTAILSBAR, width_LABEL, height_LABEL);
		cocktailsBar.setValue((larva.getCocktailDrunk() * 10));
		cocktailsBar.setStringPainted(true); 
		cocktailsBar.setForeground(Color.decode("#EDA4BB"));
		cocktailsBar.setSize(widthBar, heightBar);
		this.add(cocktailsBar);
	}
	
	/*
	 * Function to add external informations if the larva is now a cocoon
	 */
	private void addTimerCocoon(Larva larva) {
		if(larva.getLarvaState() == 1) {
			if(this.cocoonBar != null && this.timerCocoon != null) {
				this.remove(cocoonBar);
				this.remove(timerCocoon);
			}
			timerCocoon = new JLabel();
			timerCocoon.setForeground(Color.decode("#AEBECD"));
			timerCocoon.setFont(new Font("SansSerif", Font.BOLD, 15));
			timerCocoon.setText("Progression before evolution");
			timerCocoon.setBounds(X_TIMER, Y_TIMER, width_LABEL+100, height_LABEL);
			timerCocoon.setVisible(true);
			
			cocoonBar = new JProgressBar(0, 100);
			cocoonBar.setBounds(X_COCOONBAR, Y_COCOONBAR, width_LABEL, height_LABEL);
			float val = (float)larva.getTimeLeftBeforeButterfly()/60;
			cocoonBar.setValue((int) (val * 100));
			cocoonBar.setStringPainted(true); 
			cocoonBar.setForeground(Color.decode("#AEBECD"));
			cocoonBar.setSize(widthBar, heightBar);
			cocoonBar.setVisible(true);
			
			this.add(cocoonBar);
			this.add(timerCocoon);
		}
	}
	
	/*
	 * Function to display the informations of a ressource 
	 */
	private void addInformationsRessource(Ressource rs) {
		if(ressourceType != null && capacity != null) {
			this.remove(capacity);
			this.remove(ressourceType);
		}
		
		ressourceType = new JLabel();
		if(rs.getElementType() == TypeElement.POOP) {
			ressourceType.setText("Poop");
			ressourceType.setForeground(Color.decode("#9D6B4D"));}
		else if(rs.getElementType() == TypeElement.COCKTAIL) {
			ressourceType.setText("Cocktail");
			ressourceType.setForeground(Color.decode("#DFA815"));}
		else {
			ressourceType.setText("Pickle");
			ressourceType.setForeground(Color.decode("#316C0D"));}
		
		ressourceType.setFont(new Font("Serif", Font.BOLD, 20));
		ressourceType.setBounds(X_LABEL_RESSOURCETYPE, Y_LABEL_RESSOURCETYPE, width_LABEL, height_LABEL);
		ressourceType.setVisible(true);
		this.add(ressourceType);
		
		
		capacity = new JLabel();
		capacity.setText("Capacity left : " + rs.getCapacity());
		capacity.setFont(new Font("Serif", Font.BOLD, 20));
		capacity.setBounds(X_LABEL_CAPACITY, Y_LABEL_CAPACITY, width_LABEL, height_LABEL);
		capacity.setVisible(true);
		this.add(capacity);
		
		JLabel textRessource = new JLabel();
		textRessource.setText("Ressource Informations:");
		textRessource.setForeground(Color.black);
		textRessource.setFont(new Font("Serif", Font.BOLD, 20));
		textRessource.setBounds(10, 500, width_LABEL+100, height_LABEL);
		textRessource.setVisible(true);
		this.add(textRessource);
		
		
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
		evolveButton.setBackground(Color.black);
		evolveButton.setForeground(Color.white);
		evolveButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		evolveButton.setBounds(X_button, Y_EvolveButton, widthButton, heightButton);
		evolveButton.setVisible(true);
		evolveButton.setEnabled(false);
		this.add(evolveButton);
		
		attackButton = new JButton("COUP DE BOULE");
		attackButton.setBackground(Color.decode("#ABA618"));
		attackButton.setForeground(Color.white);
		attackButton.setFont(new Font("Monospaced", Font.BOLD, 20));
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
            	evolveButton.setForeground(Color.GRAY);
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

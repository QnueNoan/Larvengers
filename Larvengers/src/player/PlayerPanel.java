package player;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

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
	
	private ImageIcon background;
	private Image imgBackground;
	
	public PlayerPanel() {
		setPanel();
	}
	
	/*
	 * This function allows to initialize the player's control panel
	 */
	private void setPanel() {
		this.background = new ImageIcon(getClass().getResource("/assets/red.jpg"));
		this.imgBackground = this.background.getImage();
		this.setSize(widthPanel, heightPanel);
		this.setLayout(null);
		setViewButton();
		this.setVisible(true);
	}
	/*
	 * this function helps to paint the component of the game
	 */
	public void paintBackground(Graphics g) {
		g.drawImage(this.imgBackground, View.widthBackground, 0, widthPanel, heightPanel, null);
	}

	/*
	 * This function allows to define the parameters of the buttons
	 */
	private void setViewButton() {
		evolveButton = new JButton("COCOON MODE");
		evolveButton.setBounds(X_button, Y_EvolveButton, widthButton, heightButton);
		evolveButton.setVisible(true);
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
	
	/*
	 * Getters for the buttons
	 */
	public JButton getEvolveButton() {
		return this.evolveButton;
	}
	public JButton getAttackButton() {
		return this.attackButton;
	}
	
}

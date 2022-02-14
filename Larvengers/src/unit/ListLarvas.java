package unit;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import element.Element;
import element.ListElements;
import ressource.Ressource;
import unit.Larva;

public class ListLarvas extends ListElements<Larva>{
	
	// Timer for larva generation
	public static int TIMER_DISPLAY_RESSOURCE = 5000;
	
	// Max larvas on the board
	public static int MAX_LARVAS = 10;

	public ListLarvas () {
		super (TIMER_DISPLAY_RESSOURCE, MAX_LARVAS);
	}
}

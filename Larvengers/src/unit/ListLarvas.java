package unit;

import element.ListElements;
import element.TypeElement;

public class ListLarvas extends ListElements<Larva>{
	
	// Timer for larva generation
	public static int TIMER_GEN_LARVAS = 1000;
	
	// Max larvas on the board
	public static int MAX_LARVAS = 8;

	public ListLarvas () {
		super (TIMER_GEN_LARVAS, MAX_LARVAS);
		addElements(TypeElement.LARVA);
	}
}
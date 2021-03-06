package unit;

import element.ListElements;
import element.TypeElement;

public class ListEnnemies extends ListElements<Ennemy>{
	
	// Timer for enemy generation
		public static int TIMER_GEN_MOSKITO = 4000;
		
		// Max enemies on the board
		public static int MAX_MOSKITO = 5;

		public ListEnnemies () {
			super (TypeElement.MOSKITO, TIMER_GEN_MOSKITO, MAX_MOSKITO);
			addElements();
			System.out.println(this.getElements().size());
		}
}


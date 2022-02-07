package ressource;

import java.util.ArrayList;

public class ListRessources {
	private ArrayList<Ressource> ressources;
	
	
	public ListRessources() {
		this.ressources = new ArrayList<Ressource>();
	}
	
	private void addRessources() {
		//ressources.add();
	}
	
	/*
	 * Method getRessources : return the current ressources that are going to be displayed on the map
	 * @return ressources
	 */
	public ArrayList<Ressource> getRessources() {
		return this.ressources;
	}
}

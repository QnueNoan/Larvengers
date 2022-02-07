import mvc.View;
import javax.swing.JFrame;

public class Main {
	
	public static JFrame fenetre;
	public static View view;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fenetre	 = new JFrame("THE FLOOR IS LARVA");
		view = new View(); 
		int w = view.getWIDTH() ;
		int l = view.getLENGTH();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(w, l); 
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		fenetre.setContentPane(view);
		fenetre.setVisible(true);

	}



}
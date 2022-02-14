import mvc.Control;
import mvc.Model;
import mvc.View;
import javax.swing.JFrame;

public class Main {
	
	public static JFrame fenetre;
	public static View view;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fenetre	 = new JFrame("THE FLOOR IS LARVA");
		View view = new View();
		Control control = new Control();
		Model model = new Model(view, control);
		int w = view.getWIDTH() ;
		int h = view.getHEIGHT();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(w, h); 
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		fenetre.setContentPane(view);
		fenetre.addMouseListener(control);
		fenetre.setVisible(true);

	}



}

import mvc.Control;
import mvc.Model;
import mvc.View;
import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View view = new View();
		Control control = new Control();
		Model model = new Model(view, control);
		view.setControl(control);
		view.addMouseListener(control);
	}



}

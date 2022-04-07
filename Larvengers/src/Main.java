
import mvc.Control;
import mvc.Model;
import mvc.View;
import sound.Sounds;
import unit.Larva;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

    int CurrentMenu = 1;
    View view ;
    Control control ;
    Model model ;
    Sounds sounds;
    private static final long serialVersionUID = 1L;

    int width, height;


    JButton play = new JButton("play");

    JButton settings = new JButton("settings");

    JButton exit = new JButton("exit");
    
    JLabel title, texte, texte2, texte3, mousep, larva;

    CardLayout layout = new CardLayout();

    JPanel menu = new JPanel();

    public Main(int width, int height) {
        this.width = width;
        this.height = height;

        menu.setLayout(null);
        setWindow();

        setSize(width, height);
        setTitle("Larvengers");
        requestFocus();
        setVisible(true);
    }


    public static void main (String[] args){
        Main m = new Main(1000, 700);
        m.setVisible(true);
        System.out.println(m.CurrentMenu);
    }
    public void setWindow(){

        title();
        texte();
        texte2();
        texte3();
        mouse();
        larva();
        addButtons();
    }
    public void title(){
        BufferedImage titlep = null;
        try {
            titlep = ImageIO.read(this.getClass().getResource("/assets/title1.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        title = new JLabel(new ImageIcon(titlep));
        title.setBounds(20, 100, 1000, 200);
        title.setVisible(true);
        menu.add(title);
    }

    public void texte(){
        texte = new JLabel();
        texte.setFont(new Font("Monospaced", Font.BOLD, 20));
        texte.setText("Click on the larvae, then select the spot where you would like it to go ");
        texte.setBounds(60, 280, 1000, 40);
        texte.setVisible(true);
        menu.add(texte);
    }
    public void texte2(){
        texte2 = new JLabel();
        texte2.setFont(new Font("Monospaced", Font.BOLD, 20));
        texte2.setText("Click on the bush so you can feed the larvae selected");
        texte2.setBounds(130, 310, 1000, 40);
        texte2.setVisible(true);
        menu.add(texte2);
    }
    public void texte3(){
        texte3 = new JLabel();
        texte3.setFont(new Font("Monospaced", Font.BOLD, 20));
        texte3.setText("Then when it is full, you can switch it to a cocoon, then to a butterfly.");
        texte3.setBounds(55, 340, 1000, 40);
        texte3.setVisible(true);
        menu.add(texte3);
    }
    public void mouse(){
        BufferedImage mouse = null;
        try {
            mouse = ImageIO.read(this.getClass().getResource("/assets/mousepp.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        larva = new JLabel(new ImageIcon(mouse));
        larva.setBounds(800, 500, 100, 120);
        larva.setVisible(true);
        menu.add(larva);
    }
    public void larva(){
        BufferedImage larvaa = null;
        try {
            larvaa = ImageIO.read(this.getClass().getResource("/assets/larve4.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mousep = new JLabel(new ImageIcon(larvaa));
        mousep.setBounds(100, 500, 100, 120);
        mousep.setVisible(true);
        menu.add(mousep);
    }
    private void addButtons() {
        play.setBackground(Color.decode("#FAC09C"));
        play.setForeground(Color.white);
        play.setFont(new Font("Monospaced", Font.BOLD, 40));
        play.setBounds(300, 450, 400, 60);
        play.setVisible(true);

        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.setFont(new Font("Monospaced", Font.BOLD, 40));
        exit.setBounds(300, 520, 400, 60);
        exit.setVisible(true);

        play.addActionListener(this);
        exit.addActionListener(this);

        menu.add(play);
        menu.add(exit);
        
        menu.setBackground(Color.decode("#AEBECD"));
        add(menu);
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();

        if (source == exit) {
            System.exit(0);
        } else if (source == play) {
            this.dispose();
            
            sounds = new Sounds();
            view = new View();
            control = new Control();
            model = new Model(view, control, sounds);
            sounds.loopStartSounds();
            
            view.setControl(control);
            view.addMouseListener(control);
        }
    }




}
    
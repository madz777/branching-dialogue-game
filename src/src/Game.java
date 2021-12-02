import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame window;
    private Container con;
    private JPanel narText, cont, choice;
    private JLabel textLabel, cLabel;
    private JButton contButton;
    Font textFont = new Font("Arial", Font.PLAIN, 16);

    static Path a1 = new Path(0, 0, "a1");
    static Path b1 = new Path(3, 3, "b1");
    public static Path pathCurrent = b1;

    private boolean nar = true;

    public static void main(String[] args) {
        //Path a1 = new Path(0, 0, "a1");
        pathCurrent.setDialogue();
        new Game();
    }

    public Game() {


        //Make the Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);

        con = window.getContentPane();

        //Narration Text
        narText = new JPanel();
        narText.setBounds(100,100,600,150);
        narText.setBackground(Color.darkGray);

        textLabel = new JLabel(pathCurrent.dialogueCurrent(), SwingConstants.LEFT);
        textLabel.setForeground(Color.white);
        textLabel.setFont(textFont);

        //Buttons
        if (nar) {
            cont = new JPanel();
            cont.setBounds(10, 520, 760, 40);
            cont.setBackground(Color.darkGray);
            contButton = new JButton("Continue...");
            contButton.setForeground(Color.white);
            contButton.setBackground(Color.black);
            contButton.setPreferredSize(new Dimension(760, 30));
            contButton.setFocusable(false);
            cont.add(contButton);
        } else {
            //Choice Buttons

        }

        narText.add(textLabel);
        con.add(narText);
        con.add(cont);

        window.setVisible(true);
    }




}


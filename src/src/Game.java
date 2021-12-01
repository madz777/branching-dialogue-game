import javax.swing.*;
import java.awt.*;

public class Game {
    private JFrame window;
    private Container con;
    private JPanel narText, cont, choice;
    private JLabel textLabel, cLabel;
    private JButton contButton;
    Font textFont = new Font("Arial", Font.PLAIN, 16);

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextPane text;
    private JTextPane info;

    private boolean nar = true;

    public static void main(String[] args) {
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
        textLabel = new JLabel("You are dead. ", SwingConstants.LEFT);
        textLabel.setForeground(Color.white);
        textLabel.setFont(textFont);

        //Continue Button
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
        }

        narText.add(textLabel);
        con.add(narText);
        con.add(cont);

        window.setVisible(true);
    }

    public void createGameScreen() {

    }
}


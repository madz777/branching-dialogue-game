import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    //Main
    public static void main(String[] args) {
        pathCurrent.setDialogue();
        new Game();
    }

    private Container con;
    private JFrame window;
    private JPanel narText, cont, choices, inv;
    private JButton contButton, invButton, choiceButtonA, choiceButtonB, choiceButtonE;
    private JTextArea text;
    public static boolean nar = true;

    private GlobalListener listener = new GlobalListener();

    Font textFont = new Font("Arial", Font.PLAIN, 16);

    public static Path pathCurrent = new Path(3, 3, "b1", false);

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
        text = new JTextArea(pathCurrent.dialogueCurrent());
        text.setBounds(100, 100, 600, 150);
        text.setBackground(Color.darkGray);
        text.setForeground(Color.white);
        text.setFont(textFont);
        text.setLineWrap(true);
        narText.add(text);

        //Inventory
        inv = new JPanel();
        inv.setBounds(10, 10, 100, 40);
        inv.setBackground(Color.darkGray);
        invButton = new JButton("Inventory");
        invButton.setForeground(Color.white);
        invButton.setBackground(Color.black);
        invButton.setPreferredSize(new Dimension(100, 30));
        invButton.setFocusable(false);
        inv.add(invButton);

        if (nar) {
            //Continue Button
            cont = new JPanel();
            cont.setBounds(12, 490, 760, 40);
            cont.setBackground(Color.darkGray);
            contButton = new JButton("Continue...");
            contButton.setForeground(Color.white);
            contButton.setBackground(Color.black);
            contButton.setPreferredSize(new Dimension(760, 30));
            contButton.setFocusable(false);
            contButton.addActionListener(listener);
            cont.add(contButton);
        }
        con.add(inv);
        con.add(narText);
        con.add(cont);
        window.setVisible(true);
    }

    public void setChoiceMode() {
        cont.setVisible(false);

        choices = new JPanel();
        choices.setBounds(12, 450, 760, 120);
        choices.setBackground(Color.darkGray);

        choiceButtonE = new JButton(pathCurrent.choiceE());
        choiceButtonE.setForeground(Color.white);
        choiceButtonE.setBackground(Color.black);
        choiceButtonE.setPreferredSize(new Dimension(760, 30));
        choiceButtonE.setFocusable(false);
        choiceButtonE.addActionListener(listener);

        choiceButtonA = new JButton(pathCurrent.choice1());
        choiceButtonA.setForeground(Color.white);
        choiceButtonA.setBackground(Color.black);
        choiceButtonA.setPreferredSize(new Dimension(760, 30));
        choiceButtonA.setFocusable(false);
        choiceButtonA.addActionListener(listener);

        choiceButtonB = new JButton(pathCurrent.choice2());
        choiceButtonB.setForeground(Color.white);
        choiceButtonB.setBackground(Color.black);
        choiceButtonB.setPreferredSize(new Dimension(760, 30));
        choiceButtonB.setFocusable(false);
        choiceButtonB.addActionListener(listener);


        choices.add(choiceButtonB);
        choices.add(choiceButtonA);
        choices.add(choiceButtonE);

        //choiceButtonE.setVisible(pathCurrent.hasExtra());

        con.add(choices);
    }

    public class GlobalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonName = (JButton) e.getSource();
            if (buttonName.equals(contButton)) {
                pathCurrent.setDialogue();
                text.setText(pathCurrent.dialogueCurrent());
                if (!nar) setChoiceMode();
            } else if (buttonName.equals("Button 2")) {

            } else {

            }
        }
    }
}


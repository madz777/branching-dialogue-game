import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game {
    //Main
    public static void main(String[] args) {
        pathCurrent.setDialogue();
        new Game();


        System.out.println(pathCurrent.dialogueCurrent());
    }

    private static Container con;
    private JFrame window;
    private JPanel narText, cont, choices, inv;
    private JButton contButton, invButton, choiceButtonA, choiceButtonB, choiceButtonE;
    private JTextArea text;
    public static boolean nar = true;

    private GlobalListener listener = new GlobalListener();



    Font textFont = new Font("Arial", Font.PLAIN, 16);

    //Initialize All Paths
    private static Path e1 = new Path(2, "e1", true);
    private static Path e2 = new Path(2, "e2", true);
    private static Path e3 = new Path(2, "e3", true);
    private static Path e4 = new Path(2, "e4", true);
    private static Path e5 = new Path(2, "e5", true);
    private static Path e6 = new Path(2, "e6", true);
    private static Path e7 = new Path(2, "e7", true);
    private static Path e8 = new Path(2, "e8", true);
    private static Path d1 = new Path(2, "d1", false, false);
    private static Path d2 = new Path(2, "d2", false, true);
    private static Path d3 = new Path(2, "d3", false, false);
    private static Path d4 = new Path(2, "d4", false, false);
    private static Path c1 = new Path(2, "c1", false, false);
    private static Path c2 = new Path(2, "c2", false, false);
    private static Path b1 = new Path(3, "b1", false, false);

    public static Path pathCurrent = b1;

    private static boolean invShow = false;


    public Game() {
        //Make the Window
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);
        con = window.getContentPane();
        System.out.println("Window Success");

        //Narration Text
        b1.setDialogueIndex(0);
        b1.setDialogue();
        narText = new JPanel();
        narText.setBounds(100,100,600,150);
        narText.setBackground(Color.darkGray);
        text = new JTextArea(b1.dialogueCurrent());
        text.setBounds(100, 100, 600, 150);
        text.setBackground(Color.darkGray);
        text.setForeground(Color.white);
        text.setFont(textFont);
        text.setLineWrap(true);
        text.setFocusable(false);
        narText.add(text);
        System.out.println(b1.dialogueCurrent());
        System.out.println("oop");

        //Inventory
        inv = new JPanel();
        inv.setBounds(10, 10, 100, 40);
        inv.setBackground(Color.darkGray);
        invButton = new JButton("Inventory");
        invButton.setForeground(Color.white);
        invButton.setBackground(Color.black);
        invButton.setPreferredSize(new Dimension(100, 30));
        invButton.setFocusable(false);
        invButton.addActionListener(listener);
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

        choiceButtonE.setVisible(pathCurrent.hasExtra());

        con.add(choices);
    }

    public void setNarMode() {
        choices.setVisible(false);
        cont.setVisible(true);
    }

    public class GlobalListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton buttonName = (JButton) e.getSource();
            if (buttonName.equals(contButton)) {
                pathCurrent.setDialogue();
                text.setText(pathCurrent.dialogueCurrent());
                if (!nar) {
                    setChoiceMode();
                }
                System.out.println(pathCurrent.getPathIndex());
            } else if (buttonName.equals(choiceButtonA)) {
                if (pathCurrent.isEnding()) {
                    //ENDING SEQUENCE
                } else {
                    pathCurrent = pathCurrent.getCp1();
                    nar = true;
                    setNarMode();
                }
            } else if (buttonName.equals(choiceButtonB)) {
                if (pathCurrent.isEnding()) {
                    //ENDING SEQUENCE
                } else {
                    pathCurrent = pathCurrent.getCp2();
                    nar = true;
                    setNarMode();
                }
            } else if (buttonName.equals(invButton)) {
                Inventory i = new Inventory(con);
                if (invShow) {
                    i.destroy();
                    invShow = false;
                    if (nar) cont.setVisible(true); else choices.setVisible(true);
                    narText.setVisible(true);

                } else {
                    invShow = true;
                    if (nar) cont.setVisible(false); else choices.setVisible(false);
                    narText.setVisible(false);
                    
                }


            }
        }
    }



    //Saving and Loading

}


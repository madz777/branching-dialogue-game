import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Inventory {
    private JFrame window;
    private JPanel iPanel;
    private JTextArea inv;
    private LinkedList<String> inventoryList = new LinkedList<>();

    public Inventory (Container c) {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.darkGray);
        window.setLayout(null);

        iPanel = new JPanel();
        iPanel.setBounds(100,100,600,150);
        iPanel.setBackground(Color.darkGray);
        inv = new JTextArea(printInventory());
        inv.setBounds(100, 100, 600, 150);
        inv.setBackground(Color.darkGray);
        inv.setForeground(Color.white);
        inv.setLineWrap(true);
        inv.setFocusable(false);
        iPanel.add(inv);

        c.add(iPanel);
    }

    private String printInventory() {
        String list = "";
        if (inventoryList.size() == 0) return "Inventory Empty";
        for (int i = 0; i < inventoryList.size(); i++) {
            list += inventoryList.get(i) + "\n";
        }
        return list;
    }

    public void addItem(String i) {
        inventoryList.add(i);
    }

    public void destroy() {
        iPanel.setVisible(false);
    }
}

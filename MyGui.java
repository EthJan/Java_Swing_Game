import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class MyGui {
    private int counter = 0; // Counter variable

    public static void main(String[] args) {
        new MyGui().createUI(); // Initialize the GUI in an instance
    }

    public void createUI() {
        JFrame frame = new JFrame("My GUI");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE); // Set background for content pane

        // Red Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.RED);
        JLabel label = new JLabel("Hello, Red!");
        JButton button = new JButton("Make Red");
        JTextArea redUser = new JTextArea(1, 5);
        JButton enter = new JButton("Enter Username");

        enter.addActionListener(e -> label.setText("Hello, " + redUser.getText()));

        panel.add(label);
        panel.add(button);
        panel.add(redUser);
        panel.add(enter);

        // Blue Panel
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(Color.BLUE);
        JLabel label2 = new JLabel("Hello, Blue!");
        JButton button2 = new JButton("Make Blue");
        JTextArea blueUser = new JTextArea(1, 5);
        JButton enter2 = new JButton("Enter Username");

        enter2.addActionListener(e -> label2.setText("Hello, " + blueUser.getText()));

        panel2.add(label2);
        panel2.add(button2);
        panel2.add(blueUser);
        panel2.add(enter2);

        // Center Panel
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.WHITE); // Set white background
        JLabel comp = new JLabel("?");
        panel3.add(comp);

        // Add action listeners to buttons
        button.addActionListener(e -> {
            counter--; // Decrement counter
            updateCompText(comp, panel3); // Update the central label text
        });

        button2.addActionListener(e -> {
            counter++; // Increment counter
            updateCompText(comp, panel3); // Update the central label text
        });

        // Add panels to the frame
        frame.add(panel, BorderLayout.WEST);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.CENTER);

        // Add KeyBindings
        addKeyBindings(frame, button, button2, comp, panel3);

        // Make frame visible
        frame.setVisible(true);
    }

    private void updateCompText(JLabel comp, JPanel panel3) {
        // Update the text of the central label based on the counter value
        if (counter > 0) {
            comp.setText("Blue");
            panel3.setBackground(Color.BLUE);
            System.out.println(counter);
        } else if (counter < 0) {
            comp.setText("Red");
            panel3.setBackground(Color.RED);
        } else {
            comp.setText("Neutral");
            panel3.setBackground(Color.WHITE);
            System.out.println(counter);
        }
    }

    private void addKeyBindings(JFrame frame, JButton button, JButton button2, JLabel comp, JPanel panel3) {
        // Get the InputMap and ActionMap
        InputMap inputMap = frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = frame.getRootPane().getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("E"), "makeRed");
        actionMap.put("makeRed", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                button.doClick(); 
            }
        });

        inputMap.put(KeyStroke.getKeyStroke("I"), "makeBlue");
        actionMap.put("makeBlue", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                button2.doClick(); 
            }
        });
    }
}

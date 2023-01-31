import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AOC extends JFrame {

    // constructor
    public AOC(){

        JLabel labels = new JLabel("What is your current AOC?", JLabel.CENTER);

        setTitle("Area of Concentration!");

        // size of the frame
        setSize(500, 300);
        GridLayout gridLayout = new GridLayout(0,1);
        setLayout(gridLayout);

        JCheckBox checkBox = new JCheckBox("Computer Science");

        final JLabel result = new JLabel("", JLabel.CENTER);

        JLabel label = new JLabel("Please select the following area of interest ", JLabel.CENTER);
        label.setSize(500, 300);

        JTextField nameField = new JTextField();

        checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               Core core = new Core(nameField, result );
                setVisible(false);

            }
        });

        add(labels);
        add(checkBox);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); // this must be true to show the frame
    }

}

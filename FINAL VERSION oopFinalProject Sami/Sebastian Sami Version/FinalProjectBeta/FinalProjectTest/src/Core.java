import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Core extends JFrame{

    private int countChecked = 0;

    public Core(JTextField nameField, JLabel result){

        JLabel label = new JLabel("Core", JLabel.CENTER);
        label.setFont(new Font("Select the courses you have taken", Font.PLAIN, 40));

        JFrame frame;
        frame = new JFrame();
        frame.setTitle("Area of Focus");

        setTitle("Courses");
        setSize(800, 800);

        GridLayout gridLayout = new GridLayout(0,1);
        setLayout(gridLayout);

        File file = new File("src/Core.txt");
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                builder.append(scanner.nextLine() + ",");
            }
            scanner.close();

        }catch(FileNotFoundException e) {

            System.out.println(e.getMessage());
        }

        String choices = builder.toString();

        String [] fileForTheBox = choices.split(",");

        JTextArea area = new JTextArea("Dude!");
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        JComboBox box = new JComboBox(fileForTheBox);
        box.setSize(300, 800);
        box.setBackground(Color.orange);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = (String) box.getSelectedItem();

                if(result.getText().equals("")){
                    result.setText(name);

                }else {
                    result.setText(result.getText() + " , " + name); // how do we split the string to make it vertical?
                }
            }
        });
        JButton nextButton = new JButton("Next");
        nextButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton removeButton = new JButton("Remove");
        removeButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel = new JPanel();
        panel.add(nextButton);
        panel.add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int index = result.getText().length() -1;
                while(result.getText().charAt(index) != ',' && index > 0 )
                    index--;

                String substring = result.getText().substring(0, index);
                result.setText(substring);
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComputerSystem computerSystem = new ComputerSystem(nameField, result );
                setVisible(false);
            }
        });

        add(label);
        add(box);
        add(result);
        add(panel);
        setVisible(true);
        nextButton.setVisible(true);


        // this closes the JFrame when the user exits
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}







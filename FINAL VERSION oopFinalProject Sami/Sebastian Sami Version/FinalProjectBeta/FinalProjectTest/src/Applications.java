import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Applications extends JFrame {

    private int countChecked = 0;
    private int requiredCourseCount = 2;

    public Applications(JTextField nameField, JLabel result){

        JLabel label = new JLabel("Applications", JLabel.CENTER);
        label.setFont(new Font("Select the courses you have taken", Font.PLAIN, 40));

        JFrame frame;
        frame = new JFrame();
        frame.setTitle("Area of Focus");

        setTitle("Courses");
        setSize(800, 800);

        GridLayout gridLayout = new GridLayout(0,1);
        setLayout(gridLayout);

        File file = new File("src/Applications.txt");
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

        JComboBox box = new JComboBox(fileForTheBox);
        box.setSize(300, 800);
        box.setBackground(Color.orange);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = (String) box.getSelectedItem();

                if(result.getText().equals("")){
                    result.setText(name);

                    if(e.getSource()==box){
                        System.out.println(box.getSelectedItem());
                        countChecked++;
                        System.out.println(countChecked);
                    }

                }else {
                    result.setText(result.getText() + " , " + name);
                    System.out.println(box.getSelectedItem());
                    countChecked++;
                    System.out.println(countChecked);
                }
            }
        });

        // requiredCourseCount = 2 for Application
        if(countChecked >= requiredCourseCount){
            System.out.println("You already meet this requirment. You do not need to take a class from this area.");

        }else{
            System.out.println("For Application class you can take the following classes: ");
        }


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
                Theory theory = new Theory(nameField, result );
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







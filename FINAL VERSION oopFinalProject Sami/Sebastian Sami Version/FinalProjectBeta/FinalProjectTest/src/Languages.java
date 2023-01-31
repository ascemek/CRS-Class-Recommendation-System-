import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Languages extends JFrame implements IOHandling{

    private int countChecked = 0;
    private int requiredCourseCount = 1;

    //outside of the constructor
    JComboBox comboBox;

    public Languages(JTextField nameField, JLabel result){

        // JLabel is the container which shows the titles in the GUI
        JLabel label = new JLabel("Languages", JLabel.CENTER);
        label.setFont(new Font("Select the courses you have taken", Font.PLAIN, 20));

        // This is also a container
        JFrame frame;
        frame = new JFrame();
        frame.setTitle("Area of Focus");

        // Setting the title and passing a string
        // SetTitle is a built in Java function
        setTitle("Courses");
        setSize(800, 800);

        // Setting the dimensions of the frame
        setSize(800, 800);

        // The GridLayout is also built into Java, while also creating the object gridLayout
        GridLayout gridLayout = new GridLayout(0,1);

        // passing gridLayout here, which we can define the row and columns to the desired dimension
        setLayout(gridLayout);

        // File is reading from the CSV file which we are using src root so anybody can access the file
        // Instead of it being defined to a specific computer
        File file = new File("src/Languages.txt");

       // StringBuilder is a class, and we are creating the object builder
        StringBuilder builder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);

            // The while loop will take the scanner and check if there is another line (NextLine)
            while(scanner.hasNextLine()){
                builder.append(scanner.nextLine() + ",");
            }

            // To reduce resource leak
            scanner.close();

        }catch(FileNotFoundException exception) {

            System.out.println(exception.getMessage());
        }

        // Assigning the variable choice to builder and using toString to define choices as an actual String
        String choices = builder.toString();

        // Splitting the string at each comma by using choices.split
       // Choices is already defined as a string, so we can use an array to split at each comma
        String [] fileForTheBox = choices.split(",");


        // This is the container for the drop menu
        JComboBox box = new JComboBox(fileForTheBox);
        box.setSize(300, 800);
        box.setBackground(Color.orange);

        // ActionListener makes it so the user can actually click the button
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = (String) box.getSelectedItem();
                // This if statement is saying that if we have the first element then a comma is not needed
                // Then it will just pass the name
                if(result.getText().equals("")){
                    result.setText(name);

                    if(e.getSource()==box){
                        System.out.println(box.getSelectedItem());
                        countChecked++;
                        System.out.println(countChecked);
                    }

                    // If it is not the first condition then everything after the first result will have a comma
                }else {
                    result.setText(result.getText() + ", " + name);
                    System.out.println(box.getSelectedItem());
                    countChecked++;
                    System.out.println(countChecked);
                }
            }
        });

        if(countChecked >= requiredCourseCount){
            System.out.println("You already meet this requirment. You do not need to take a class from this area.");

        }else{
            System.out.println("For Application class you can take the following classes: ");

            List<String> list = new ArrayList<>(){{
                add("C");
                add("C++");
                add("C#");
                add("Compilers Tutorial (also in Theory)");
                add("Embedded Systems (also in Systems)");
                add("Functional Programming (no prerequisite)");
                add("Hacking Tutorial (also in Systems)");
                add("Mobile Applications (also in Applications)");
                add("Principles of Programming Languages");
            }};

		    for(String i : list){
			    System.out.println(i);
            }
            
            /*
                //read the classes taken from the CSV output
                String s2 = IOHandling.readData("Languages.txt");

                // split the output for each comma
                String[] splitOne  = s2.split(",");

                ArrayList<String> classTakenArr = new ArrayList<String>();

                for(String a : splitOne){
                    classTakenArr.add(a);
                }

                System.out.println(classTakenArr);
                System.out.println("So far you take " + classTakenArr.size() + " classes.");

                //print all classes taken
                for(String i : classTakenArr){
                    System.out.println(i);
                }
                */












        }

        // Creating the buttons using the container JButton
        JButton removeButton = new JButton("Remove");


        // Flowlayout makes the button a little smaller and more fitting to the page
        // FlowLayout is a class, and we are creating an object of the class
        removeButton.setLayout(new FlowLayout(FlowLayout.CENTER));


        // This is creating the actual button
        JButton showButton = new JButton("Print to a CSV");

        // Changing the layout of how the button will look in the GUI
        // We can change its placement, but CENTER seems to look the best in the GUI layout
        showButton.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Panel is another container to add objects or change the structure of the buttons
        JPanel panel = new JPanel();
        panel.add(removeButton);
        panel.add(showButton);

          /**
          * The remove button function
          * First we need to assign the index as an integer data type since we will lave a list of results
          * We then need to find the last comma by traversing from the end of the array and then reduce the result by -1 to find the last comma
          * Then a while-loop will run until there are no more commas or if it is the first result (there will be no commas)
          * Lastly we are creating the substring variable to display the result before the comma in the TextField
          * Then passing substring as the final result
          */

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

        // Here is the action button that prints the TextField to the CSV file
         showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String csv = result.getText();

                try {
                    Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ClassesTaken.csv")));
                    writer.write(csv);
                    writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

         // The order of the buttons matter because this is how they will be displayed
        add(label);
        add(box);
        add(result);
        add(panel);
        setVisible(true);

        // This closes the JFrame when the user exits
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println("FINAL COUNT BABY" + countChecked);

    }
}







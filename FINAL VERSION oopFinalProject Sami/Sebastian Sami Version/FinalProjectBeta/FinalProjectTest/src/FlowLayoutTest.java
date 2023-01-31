import javax.swing.*;
import java.awt.*;

public class FlowLayoutTest extends JFrame {

    // constructor
    public FlowLayoutTest(){

        setTitle("Flow");
        setSize(500, 800);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new Button("Next"));
        add(new Button("Submit"));
        add(new Button("Other"));




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



    }


}

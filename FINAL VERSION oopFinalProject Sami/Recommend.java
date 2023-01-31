import java.util.Iterator;
import java.util.ArrayList;

/**
 * @author Sami Cemek
 * @version 1.1
 * @since 05/15/22
 */

public class Recommend implements IOHandling{

    private ArrayList<String> classTakenArr = new ArrayList<String>();
    private ArrayList<String> classNeeded = new ArrayList<String>();

    private void ProcessTextFile() {

        //ArrayList<String> classTakenArr = new ArrayList<String>();

        //read the classes taken from the CSV output
        String data = IOHandling.readData("CSVDemo.csv");  //DEMO ASC PART
    
        //String data = IOHandling.readData("ClassesTaken.csv");
        System.out.println("Output read from the file: " + data);
    
        // split the output for each comma
        String[] splitOne  = data.split(",");
    
        for(String a : splitOne){
            classTakenArr.add(a);
        }
    
        System.out.println("Array version: " + classTakenArr);
        System.out.println("So far you take " + classTakenArr.size() + " core classes. These are: ");
        //print all classes taken
        for(String i : classTakenArr){
            System.out.println(i);
        }
    
        System.out.println("You need to take " + (7 - classTakenArr.size()) + " more core courses");

    }

    private void CoreCourses(){
        // I messed up this part somehow and it does not work anymore??
        Iterator<String> iter = classTakenArr.iterator();

        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals("Introduction to Programming with Python")){
                iter.remove();
            }
            if (str.equals(" Discrete Mathematics")){
                iter.remove();
            }
            if (str.equals(" Object-Oriented Programming with Java")){
                iter.remove();
            }
            if (str.equals("  Object-Oriented Design in Java")){
                iter.remove();
            }
            if (str.equals(" Data Structures in Java")){
                iter.remove();
            }
            if (str.equals(" Software Engineering")){
                iter.remove();
            }
            if (str.equals(" Algorithms")){
                iter.remove();
            }

        }

        System.out.println("You should take");
        for(String i : classTakenArr){
            System.out.println(i);
        }
    }
    
    public static void main(String[] args) {
        
        //initialize a Recommend type of object for test purposes
        Recommend test = new Recommend();
        test.ProcessTextFile();
        test.CoreCourses();
         
    }


}

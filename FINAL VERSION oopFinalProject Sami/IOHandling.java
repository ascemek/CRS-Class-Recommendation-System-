import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public interface IOHandling {

	public static String readData(String readFileName) {
		
		StringBuilder s = new StringBuilder();
		
		try {
		      File myObj = new File(readFileName);
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        s.append(myReader.nextLine()+'\n');
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		    	System.out.println("An error occurred.");
		    	e.printStackTrace();
		    }
		  
		return s.toString();
	}
	
	public static void writeData(String data, String writeFileName) {
	
		 try {
		      FileWriter myWriter = new FileWriter(writeFileName);
		      
		      myWriter.write(data);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    
		 } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		  }
		 // sample source: https://www.w3schools.com/java/java_files_create.asp
		
	}
	
	public static void printData(String data) {
		
		System.out.println(data);
		
	}
}

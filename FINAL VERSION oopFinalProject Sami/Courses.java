
class Courses {

    String name;
	Integer price;

    Courses(String _name, Integer _price){
		name = _name;
		price = _price;
	}
    
    public String getName() {
		return name;
	}
	
	public Integer getPrice(){
		return price;
	}
	
	public String toString()
	{
		return name + ", price: " + price;
	}


    // ADD 1 MORE SPLIT FOR this ;
    public static HashMap<Integer, Courses> parseData(String data){
		String[] splitTwo;
		HashMap<Integer,Item> hm = new HashMap<>();
        String[] splitOne  = data.split("\n");
        for (String a : splitOne ){
			splitTwo = a.split(",");
			randomID++;
			Item i = new Item(splitTwo[0], Double.parseDouble(splitTwo[1]));
			hm.put(randomID, i );
		}
		return hm;
    }


    public class TestPart implements IOHandling{
        public static void main(String[] args) {

            //open the "bookcollection.dat" file
            String s = IOHandling.readData("CS_AOC.txt");

        }
    }
}

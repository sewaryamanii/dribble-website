package DribbleWebsite.DribbleWebsite;

import java.util.Random;

public class TestData {
	String query = "SELECT * FROM Users WHERE ID = 'randomuser' ;";
String [] randomID = {"1","2","3","4"};
	
	Random rand = new Random();
	int randomindex = rand.nextInt(randomID.length);
	String randomuser = randomID[randomindex];
	
	String[] colors = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	int randomhex = rand.nextInt(colors.length);
	String randomcolor = colors[randomhex];
	
	String[] options = { "This Past Week", "This Past Month","This Past Year","All Time" };
	int randomoptions = rand.nextInt(options.length);
	
	
	
	String [] popularbutton = {"Popular","New & Noteworthy"};
	int randomselect = rand.nextInt(popularbutton.length);
	

}

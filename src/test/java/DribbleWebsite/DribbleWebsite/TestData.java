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
	
	String[] options = { "week", "month","year","ever","now" };
	int randomoptions = rand.nextInt(options.length);

}

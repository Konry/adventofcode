package nine;

import java.io.File;

import stuff.StringFileReader;

public class Nine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("nine.txt");

		StringFileReader sfr = new StringFileReader();
		String[] lines = StringFileReader.readLinesOfFile(f);

		TravelerSalesmanProblem tsp = new TravelerSalesmanProblem();
		for (String s : lines) {
			tsp.getModelOutOfString(s);
		}
		tsp.calculateShortestRoute();
	}

}

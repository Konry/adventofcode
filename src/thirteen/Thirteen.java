package thirteen;

import java.io.File;

import stuff.StringFileReader;

public class Thirteen {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StringFileReader sfr = new StringFileReader();
		String[] strings = StringFileReader.readLinesOfFile(new File("thirteen.txt"));
		KnightOfTheDinnerTable kotdt = new KnightOfTheDinnerTable();
		kotdt.totalHappiness(strings);
	}


}

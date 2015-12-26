package eightteen;

import java.io.File;

import stuff.StringFileReader;

public class Eightteen {

	public static void main(String[] args) {
		String[] lines = StringFileReader.readLinesOfFile(new File("eightteen.txt"));
		
		Lightshow ls = new Lightshow();
		ls.fillLightArray(lines);
		ls.PlayGame(100);
	}

}

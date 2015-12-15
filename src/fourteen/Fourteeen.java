package fourteen;

import java.io.File;

import stuff.StringFileReader;

public class Fourteeen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = new File("fourteen.txt");
		
		String[] deers = StringFileReader.readLinesOfFile(file);
		ReindeerRace rr = new ReindeerRace();
		
		for(String d : deers){
			rr.parseString(d);
		}
//		rr.race(1001);
		rr.race(2504);
	}

}

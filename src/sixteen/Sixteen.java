package sixteen;

import java.io.File;
import java.util.ArrayList;

import stuff.StringFileReader;

public class Sixteen {

	public static void main(String[] args) {
		String[] auntStrings = StringFileReader.readLinesOfFile(new File("sixteen.txt"));
		
		ArrayList<String> aunts = new ArrayList<>();
		for(String aunt : auntStrings){
			if(Aunt.parse(aunt)){
				System.out.println("############add aunt");
				aunts.add(aunt);
			}
		}
		System.out.println();
		System.out.println("find aunts:");
		for(String aunt : aunts ){
			System.out.println(aunt);
		}
	}

}

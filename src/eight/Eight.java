package eight;

import java.io.File;

import stuff.StringFileReader;

public class Eight {

	public static void main(String[] args){
		StringCounter sc = new StringCounter();
		
		StringFileReader sfr = new StringFileReader();
		File file = new File("eight.txt");
		String[] list = sfr.readLinesOfFile(file);
		
		for(String s:list){
			sc.StringAnalyserTwo(s);
		}
		sc.print();
	}

}

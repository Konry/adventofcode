package day19;

import java.io.File;

import stuff.StringFileReader;

public class day19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = StringFileReader.readLinesOfFile(new File("day19.txt"));
		Example srm = new Example();
		srm.SplitString(str);
		//srm.SplitString(str);
		//srm.calculateWord(srm.calibrationString);
	}

}

package five;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Five {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringAnalyser five = new StringAnalyser();
		System.out.println(five.checkStringsNiceness("ugknbfddgicrmopn"));
		System.out.println(five.checkStringsNiceness("aaa"));
		System.out.println(five.checkStringsNiceness("jchzalrnumimnmhp"));
		System.out.println(five.checkStringsNiceness("haegwjzuvuyypxyu"));
		System.out.println(five.checkStringsNiceness("dvszwmarrgswjxmb"));
		File file = new File("five2.txt");
		String[] stringlines = readLinesOfFile(file);
		int nicenessCount = 0;
		int nicenessCountTwo = 0;
		for (String s : stringlines) {
			if (five.checkStringsNiceness(s)) {
				nicenessCount++;
			}
			if (five.checkStringsNicenessII(s)) {
				nicenessCountTwo++;
			}
		}
		System.out.println(nicenessCount);

		System.out.println("\n\nPart II\n");
		System.out.println(five.checkStringsNicenessII("qjhvhtzxzqqjkmpb"));
		System.out.println(five.checkStringsNicenessII("xxyxx"));
		System.out.println(five.checkStringsNicenessII("uurcxstgmygtbstg"));
		System.out.println(five.checkStringsNicenessII("ieodomkazucvgmuy"));
		System.out.println(five.checkStringsNicenessII("aaoilpoilpoiaaya"));

		// 65, 67 too low
		// 238 too high
		System.out.println(nicenessCountTwo);
	}

	/**
	 * Reads all lines into a String Array.
	 */
	public static String[] readLinesOfFile(File filename) {
		ArrayList<String> stringList = new ArrayList<String>();
		if (filename.exists()) {
			try {
				BufferedReader bufstream = new BufferedReader(new FileReader(filename));
				String line = "";
				while (null != (line = bufstream.readLine())) {
					// System.out.println(line);
					stringList.add(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stringList.toArray(new String[stringList.size()]);
	}

	/**
	 * Reads all lines into an Integer char Array.
	 */
	public static Integer[] readCharsOfFile(File filename) {
		ArrayList<Integer> charList = new ArrayList<Integer>();
		if (filename.exists()) {
			try {
				BufferedReader bufstream = new BufferedReader(new FileReader(filename));
				int line = 0;
				while (-1 != (line = bufstream.read())) {
					// System.out.println(line);
					charList.add(line);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return charList.toArray(new Integer[charList.size()]);
	}

}

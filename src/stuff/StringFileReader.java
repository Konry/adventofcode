package stuff;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringFileReader {
	
	public StringFileReader() {
		// TODO Auto-generated constructor stub
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

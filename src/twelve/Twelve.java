package twelve;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONObject;

import stuff.StringFileReader;

public class Twelve {

	public static void main(String[] args) {
		JSONReader read = new JSONReader();

		String[] jsonLines = StringFileReader.readLinesOfFile(new File("twelve.txt"));
		String json = "";

		for (String line : jsonLines) {
			json += line;
		}
		
		read.read(json);
	}

}

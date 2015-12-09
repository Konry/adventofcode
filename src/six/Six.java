package six;

import java.io.File;

import stuff.StringFileReader;

public class Six {

	public static void main(String[] args) {
		File file = new File("six.txt");
		String[] lines = StringFileReader.readLinesOfFile(file);

		LightsOn light = new LightsOn();
		for (String string : lines) {
			String temp = "";
			if (string.startsWith("turn on ")) {
				String tmp = string.replace("turn on ", "");
				tmp = tmp.replace(" through ", ",");
				String[] split = tmp.split(",");
				light.turnOn(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
			} else if (string.startsWith("turn off ")) {
				String tmp = string.replace("turn off ", "");
				tmp = tmp.replace(" through ", ",");
				System.out.println(string);
				System.out.println(tmp);
				String[] split = tmp.split(",");
				light.turnOff(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));

			} else if (string.startsWith("toggle ")) {
				String tmp = string.replace("toggle ", "");
				tmp = tmp.replace(" through ", ",");
				String[] split = tmp.split(",");
				light.toggle(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));

			} else {
				System.err.println("Error!");
			}
		}

//		light.turnOn(0, 0, 999, 999);
//		System.out.println(light.countLightsOn());
//		light.toggle(0, 0, 999, 0);
//		light.turnOff(499, 499, 500, 500);
		System.out.println(light.countLightsOn());
		System.out.println(light.countBrightness());

	}

}

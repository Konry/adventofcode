package day19;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import stuff.StringFileReader;


/**
 * @author /u/Philboyd_Studge on 12/18/2015.
 */
public class Example {
	static ArrayList<Replacement> list = new ArrayList<>();
	static String calibrationString = "";

	public static void SplitString(String[] strings) {
		for (String s : strings) {
			if (s.contains(" => ")) {
				String[] temp = s.split(" => ");
				list.add(new Replacement(temp[0], temp[1]));
			} else {
				calibrationString += s;
			}
		}
	}

    public static String replace(String s, String in, String out, int position) {
        return s.substring(0, position) + out + s.substring(position + in.length());
    }
    
    public static List<String[]> GetFileLinesSplit(){
    	List<String[]> lis = new ArrayList<String[]>();
    	for(Replacement r: list){
    		lis.add(new String[]{r.from,r.to});
    	}
    	return lis;
    }
    
    public static void main(String[] args) {
    	String[] str = StringFileReader.readLinesOfFile(new File("day19.txt"));
    	SplitString(str);
        List<String[]> input = GetFileLinesSplit();
        List<String> output = new ArrayList<>();
        String molecule = calibrationString;

        for (String[] each : input) {
            int position = 0;
            while ((position = molecule.indexOf(each[0], position)) >= 0) {
                output.add(replace(molecule, each[0], each[1], position));
                position += each[0].length();
            }
        }

        long count = output.stream()
                .distinct()
                .count();

        System.out.println(count);

        int count2 = 0;
        while(!molecule.equals("e")) {
            for (String[] each : input) {
                if (molecule.contains(each[1])) {
                    molecule = replace(molecule, each[1], each[0], molecule.lastIndexOf(each[1]));
                    count2++;
                }
            }
        }
        System.out.println(count2);
    }
    


	public static class Replacement {
		String from;
		String to;

		public Replacement(String from, String to) {
			this.from = from;
			this.to = to;
		}
	}
}
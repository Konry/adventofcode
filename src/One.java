import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import three.GiftList;
import three.GiftMapObject;

public class One {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// one();
		// onetwo();
		// two();
		three();
	}

	public static void three() {
		File file = new File("three.txt");
		Integer[] charArray = readCharsOfFile(file);

		/* Geographische Länge Ost West */
		int length = 0;
		/* Geographische Breite Nord Süd */
		int width = 0;
		/* Geographische Länge Ost West */
		int length_santa = 0;
		/* Geographische Breite Nord Süd */
		int width_santa = 0;
		/* Geographische Länge Ost West */
		int length_copy = 0;
		/* Geographische Breite Nord Süd */
		int width_copy = 0;

		HashMap<Integer, Integer> giftMap = new HashMap<Integer, Integer>();
		giftMap.put(0, 1);
		
		GiftList giftList = new GiftList(1);
		GiftList giftListTwo = new GiftList(2);
//		System.out.println(giftList.size());
//		giftList.add(new GiftMapObject(4, 2));
//		System.out.println(giftList.size());
//		giftList.add(new GiftMapObject(4, 2));
//		System.out.println(giftList.size());
		
		

		boolean santaCopyMovement = false;
		for (int i : charArray) {
//			System.out.print("Chart " + i + " ");
			int charValue = 0;
			switch (i) {
			case 0:
				break;
			case 118:
//				System.out.println("South v");
				width--;
				if(santaCopyMovement) {
					width_copy++;
				}else {
					width_santa++;
				}
				break;
			case 62:
//				System.out.println("East >");
				length++;
				if(santaCopyMovement) {
					length_copy++;
				}else {
					length_santa++;
				}
				break;
			case 60:
//				System.out.println("West <");
				length--;
				if(santaCopyMovement) {
					length_copy--;
				}else {
					length_santa--;
				}
				break;
			case 94:
//				System.out.println("North ^");
				width++;
				if(santaCopyMovement) {
					width_copy--;
				}else {
					width_santa--;
				}
				break;
			}
			if(santaCopyMovement) {
				giftListTwo.add(new GiftMapObject(length_copy, width_copy));
			}else {
				giftListTwo.add(new GiftMapObject(length_santa, width_santa));
			}
			giftList.add(new GiftMapObject(length, width));
			
			int coordinates = 0;
			
			if(length < 0) {
				coordinates = ((width+5000)+ Math.abs(length) * 100000) *-1;
//				System.out.println("one");
			} else {
				coordinates = (width+5000)+ (length) * 100000;
//				System.out.println("two");
			}
//			System.out.println("coordinates "+coordinates + " "+length + " "+width);
			if (giftMap.get(coordinates) == null) {
//				System.out.println("coordinates do not exist!");
				giftMap.put(coordinates, 1);
			} else {
				giftMap.put(coordinates, giftMap.get(coordinates)+1);
//				System.out.println("coordinates "+coordinates+" exist with new value: "+giftMap.get(coordinates));
			}
			santaCopyMovement = !santaCopyMovement;
		}
		int sumOfSingleGift = 0;
		for(Entry<Integer, Integer> i : giftMap.entrySet()){
			int widthCoordinate = Math.abs((i.getKey() - (int)(i.getKey()/100000)*100000));
			//System.out.println("width: "+widthCoordinate);
//			System.out.println("Coordinates "+i.getKey()+" length "+i.getKey()/100000+" width "+(widthCoordinate-5000)+" Value "+i.getValue());
			if(i.getValue() >= 1) {
				sumOfSingleGift++;
			}
		}
		System.out.println("Single gifts delivered: "+sumOfSingleGift + " "+giftList.size());

		System.out.println(giftList.size());
		System.out.println(giftListTwo.size());
	}

	public static void two() {
		File file = new File("two.txt");
		String[] stringsInFile = readLinesOfFile(file);

		System.out.println("Test case 1 " + calculateSurfaceVolume(2, 3, 4));
		System.out.println("Test case 2 " + calculateSurfaceVolume(29, 13, 26));

		System.out.println("Test case 1 calculateRibbon " + calculateRibbon(2, 3, 4));
		System.out.println("Test case 1 calculateRibbonBow " + calculateRibbonBow(2, 3, 4));

		System.out.println("Test case 2 calculateRibbon " + calculateRibbon(1, 1, 10));
		System.out.println("Test case 2 calculateRibbonBow " + calculateRibbonBow(1, 1, 10));

		int sumOfAll = 0;
		int sumOfRibbon = 0;

		for (String line : stringsInFile) {
			String[] lineSplit = line.split("x");
			// System.out.println("Split: " + Integer.valueOf(lineSplit[0]) + "
			// " + Integer.valueOf(lineSplit[1]) + " "
			// + Integer.valueOf(lineSplit[2]));
			int length = Integer.valueOf(lineSplit[0]);
			int width = Integer.valueOf(lineSplit[1]);
			int height = Integer.valueOf(lineSplit[2]);
			sumOfAll += calculateSurfaceVolume(length, width, height);
			// System.out.println(sumOfAll);

			sumOfRibbon += calculateRibbonBow(length, width, height) + calculateRibbon(length, width, height);
			// System.out.println(calculateRibbonBow(length, width, height));
			// System.out.println(calculateRibbon(length, width, height));

		}
		System.out.println(sumOfAll);
		System.out.println(sumOfRibbon);
	}

	public static void onetwo() {
		File file = new File("onetwo.txt");
		if (file.exists()) {
			System.out.println("File exits... open");
			try {
				BufferedReader bufstream = new BufferedReader(new FileReader(file));
				int line = 0;
				int fourty = 0;
				int fourtyone = 0;

				int floor = 0;
				int character = 0;
				boolean stopCount = false;
				for (int i = 0; i < 10000; i++) {
					line = bufstream.read();
					if (line == 40) {
						floor++;
						fourty++;
					} else if (line == 41) {
						floor--;
						fourtyone++;
					} else {
						System.out.println("error");
					}
					if (!stopCount)
						character++;
					if (floor == -1) {
						stopCount = true;
					}
				}
				System.out.println("fourty " + fourty);
				System.out.println("fourtyone " + fourtyone);
				System.out.println("Floor: " + (fourty - fourtyone));
				System.out.println("Character: " + (character));
				System.out.println("Floor short: " + (floor));
				System.out.println("sum: " + (fourty + fourtyone));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void one() {
		File file = new File("one.txt");
		if (file.exists()) {
			System.out.println("File exits... open");
			try {
				BufferedReader bufstream = new BufferedReader(new FileReader(file));
				int line = 0;
				int counter = 0;
				int fourty = 0;
				int fourtyone = 0;
				for (int i = 0; i < 10000; i++) {
					line = bufstream.read();
					if (line == 40) {
						fourty++;
					} else if (line == 41) {
						fourtyone++;
					} else {
						System.out.println("error");
					}
				}
				System.out.println("fourty " + fourty);
				System.out.println("fourtyone " + fourtyone);
				System.out.println("Floor: " + (fourty - fourtyone));
				System.out.println("sum: " + (fourty + fourtyone));

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*****
	 * Helping Functions
	 */

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

	public static int calculateSurfaceVolume(int length, int width, int height) {
		int areaOne = length * width;
		int areaTwo = width * height;
		int areaThree = height * length;
		int surface = (2 * areaOne + 2 * areaTwo + 2 * areaThree);
		int extraPaper = Math.min(Math.min(areaOne, areaTwo), areaThree);
		return surface + extraPaper;
	}

	public static int calculateRibbonBow(int length, int width, int height) {
		return length * width * height;
	}

	public static int calculateRibbon(int length, int width, int height) {
		//
		if (Math.max(length, width) <= height) {
			return 2 * length + 2 * width;
		} else if (Math.max(width, height) <= length) {
			return 2 * width + 2 * height;
		} else if (Math.max(length, height) <= width) {
			return 2 * length + 2 * height;
		}
		System.err.println("Fehler, sollte nicht vorkommen: " + length + " " + width + " " + height);
		return -1;
	}


}
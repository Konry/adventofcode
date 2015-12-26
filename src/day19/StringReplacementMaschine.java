package day19;

import java.util.ArrayList;

public class StringReplacementMaschine {
	ArrayList<Replacement> list = new ArrayList<>();
	String calibrationString = "";

	public void SplitString(String[] strings) {
		for (String s : strings) {
			if (s.contains(" => ")) {
				String[] temp = s.split(" => ");
				list.add(new Replacement(temp[0], temp[1]));
			} else {
				calibrationString += s;
			}
		}
	}

	public void CalculateWord() {
		int sumOfSteps = 0;
		for (Replacement r : list) {
			if (r.equals("e")) {
				String targetWord = r.to;
				int steps = 1;
				// calculateWord(calibrationString, targetWord, steps);
			}
		}
	}

	public void calculateWord(String tw) {
		int countRN = 0;
		int countAR = 0;
		int countY = 0;
		StringBuilder sb = new StringBuilder();
		int countSymbols = 0;
		ArrayList<String> distinctList = new ArrayList<>();
		for(Replacement r:list){
			boolean isAlreadyInside = false;
			for(String s:distinctList){
				if(r.from.equals(s)){
					isAlreadyInside = true;
				}
			}
			if(!isAlreadyInside){
				distinctList.add(r.from);
			}
		}
		for (String s : distinctList) {
			for (int i = 0; i <= calibrationString.length() - s.length(); i++) {
				if (calibrationString.substring(i, i + s.length()).equals(s)) {
					System.out.println(s+ " at "+i + " "+ (i + s.length()));
					countSymbols++;
				}
			}
		}
		for (int i = 0; i < tw.length(); i++) {
			if (tw.charAt(i) == 'A') {
				sb.append('A');
			} else if (tw.charAt(i) == 'R') {
				sb.append('R');
			} else if (tw.charAt(i) == 'Y') {
				System.out.println(tw.substring(i, i+1) + " at "+i + " "+(i+1));
				countY++;
				sb = new StringBuilder();
			} else if (tw.charAt(i) == 'r' && sb.toString().equals("A")) {
				System.out.println(tw.substring(i-1, i+1) + " at "+(i-1) + " "+(i+1));
				countAR++;
				sb = new StringBuilder();
			} else if (tw.charAt(i) == 'n' && sb.toString().equals("R")) {
				System.out.println(tw.substring(i-1, i+1) + " at "+(i-1) + " "+(i+1));
				countRN++;
				sb = new StringBuilder();
			} else {
				sb = new StringBuilder();
			}
		}

		// #NumSymbols - #Rn - #Ar - 2 * #Y - 1
		System.out.println(tw);
		System.out.println(tw.length());
		System.out.println(countSymbols);
		System.out.println(countRN);
		System.out.println(countAR);
		System.out.println(countY);
		System.out.println("length " + (tw.length() - countRN - countAR - (2 * countY) - 1));
		// if(currentWord.equals(targetWord)){
		// return;
		// } else {
		// for (Replacement r : list) {
		// for (int i = 0; i <= calibrationString.length() - r.from.length();
		// i++) {
		// if (calibrationString.substring(i, i +
		// r.from.length()).equals(r.from)) {
		// String result = "";
		// if (i > 0)
		// result = calibrationString.substring(0, i);
		// result += r.to;
		// if ((i + r.from.length()) <= calibrationString.length() -
		// r.from.length())
		// result += calibrationString.substring(i + r.from.length());
		// results.add(result);
		// }
		// }
		// }
		// steps++;
		// }
	}
	
	public void GetSolve(String word){
		for(int i = 0; i < 100; i++){
			System.out.println((int)(Math.random()*10*list.size()));
		}
	}

	public int calculateOptions() {
		ArrayList<String> results = new ArrayList<>();
		for (Replacement r : list) {
			System.out.println("Test " + r.from);
			for (int i = 0; i <= calibrationString.length() - r.from.length(); i++) {
				// System.out.println(calibrationString.substring(i, i +
				// r.from.length()) + " equals "+r.from+"
				// "+calibrationString.substring(i, i +
				// r.from.length()).equals(r.from));
				if (calibrationString.substring(i, i + r.from.length()).equals(r.from)) {
					String result = "";
					if (i > 0)
						result = calibrationString.substring(0, i);
					result += r.to;
					if ((i + r.from.length()) <= calibrationString.length() - r.from.length())
						result += calibrationString.substring(i + r.from.length());
					results.add(result);
				}
			}
		}

		ArrayList<String> endResult = new ArrayList<>();
		for (String s : results) {
			boolean alreadyInside = false;
			for (String er : endResult) {
				if (er.equals(s)) {
					alreadyInside = true;
				}
			}
			if (!alreadyInside) {
				endResult.add(s);
			}
		}
		for (String er : endResult) {
			System.out.println(er);
		}
		return endResult.size();
	}

	public class Replacement {
		String from;
		String to;

		public Replacement(String from, String to) {
			this.from = from;
			this.to = to;
		}
	}
}

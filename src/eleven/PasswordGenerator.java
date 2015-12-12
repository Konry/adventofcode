package eleven;

public class PasswordGenerator {

	/* Rules exactly 8 lowercase letters */
	/* incrementing password */
	/* one increasing straigt of at least three letters abc, bcd, cde */
	/* no i, o, l */
	/* at least two different non overrlapping pairs of letters */

	public String generate(String string) {
		while (true) {
			string = increaseString(string);
			if (!checkConditionsViolations(string)) {
				return string;
			}
		}
	}

	protected String increaseString(String string) {
//		System.out.println(string);
		String s = new String();
		if (string.toCharArray()[string.length() - 1] == 'z') {
			s = increaseString(string.substring(0, string.length() - 1)).concat("a");
//			System.out.println("last is z: " + s);
			return s;
		}
		char increased = (char) ((string.charAt(string.length() - 1)) + 1);
		StringBuilder sb = new StringBuilder(string.substring(0, string.length() - 1));
//		System.out.println("substring: " + sb.toString() + " h increased " + increased);
		s = sb.append(increased).toString();
//		System.out.println("last increased: " + s);
		return s;
	}

	protected boolean checkConditionsViolations(String string) {
		boolean failed = false;
		if (!lookForEightLowercase(string)) {
//			System.out.println("no eight lowercase");
			failed = true;
		}
		if (!lookForIncreasingStraight(string)) {
//			System.out.println("no straigt ");
			failed = true;
		}
		if (lookForMistakenLetters(string)) {
//			System.out.println("contains mistaken letters");
			failed = true;
		}
		if (!lookForTwoDoubleLetters(string)) {
//			System.out.println("no two double letters");
			failed = true;
		}
		return failed;
	}

	protected boolean lookForEightLowercase(String string) {
		if (string.equals(string.toLowerCase()) && string.length() == 8) {
			return true;
		}
		return false;
	}

	protected boolean lookForIncreasingStraight(String string) {
		char[] lastTwoChars = new char[2];
		int counter = 0;
		for (char c : string.toCharArray()) {
			if (counter == 0) {
				lastTwoChars[1] = c;
			} else if (counter == 1) {
				lastTwoChars[0] = lastTwoChars[1];
				lastTwoChars[1] = c;
			} else {
				// System.out.println(lastTwoChars[0] + " "+lastTwoChars[1]+ "
				// "+c+ " "+(c == (lastTwoChars[1] + 1))+ " "+(lastTwoChars[1]
				// == (lastTwoChars[0] + 1)));
				if (c == (lastTwoChars[1] + 1) && lastTwoChars[1] == (lastTwoChars[0] + 1)) {
					return true;
				}
				lastTwoChars[0] = lastTwoChars[1];
				lastTwoChars[1] = c;
			}
			counter++;
		}
		return false;
	}

	protected boolean lookForMistakenLetters(String string) {
		for (char c : string.toCharArray()) {
			if (c == 'i') {
				return true;
			} else if (c == 'o') {
				return true;
			} else if (c == 'l') {
				return true;
			}
		}
		return false;
	}

	protected boolean lookForTwoDoubleLetters(String string) {
		int countOfDoubleLetters = 0;
		char lastChar = 0;
		char lastDoubleLetterChar = 0;
		for (char c : string.toCharArray()) {
			if (lastChar == 0) {
				lastChar = c;
			} else {
				if (c == lastChar && (lastDoubleLetterChar != c)) {
					lastDoubleLetterChar = c;
					countOfDoubleLetters++;
				}
				lastChar = c;
			}
		}
		if (countOfDoubleLetters >= 2) {
			return true;
		} else {
			return false;
		}
	}
}

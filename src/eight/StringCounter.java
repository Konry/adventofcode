package eight;

public class StringCounter {

	int charactersInMemory = 0;
	int charactersInString = 0;

	int charactersOriginal = 0;
	int charactersNew = 0;

	public void test() {
		/* code 1 */
		int hex = (char) 0xAA;
		System.out.println(hex);
		/* code 2 */
		int hex2 = hex;
		System.out.println((char) hex2);
		System.out.println(getCharOfHex("0xaa"));
	}

	public String getCharOfHex(String hex) {
		int hex_code = Integer.parseInt(hex.replace("0x", ""), 16);
		char[] code = new char[1];
		code[0] = (char) hex_code;
		return new String(code);
	}

	public void print() {
		System.out.println(charactersInMemory);
		System.out.println(charactersInString);
		System.out.println(charactersInString - charactersInMemory);
		System.out.println();

		System.out.println(charactersOriginal);
		System.out.println(charactersNew);
		System.out.println(charactersNew - charactersOriginal);
	}

	public void StringAnalyser(String string) {
		System.out.println();
		System.out.println(string);
		int usedSpaceInMemory = 0;
		int usedCharactersForRepresentation = 0;

		int numberRepresentation = 0;
		boolean hasHexNumberInside = false;
		char[] carr = string.toCharArray();

		int lastLength = string.length();

		string = string.substring(1, string.length() - 1);
		usedCharactersForRepresentation += 2;

		System.out.println(string);

		while (lastLength > string.length()) {
			lastLength = string.length();
			if (string.contains("\\\\")) {
				int amountOfDoubleBackslash = 0;
				boolean foundBackslash = false;
				for (char c : string.toCharArray()) {
					if (c == '\\' && !foundBackslash) {
						foundBackslash = true;
					} else if (c == '\\' && foundBackslash) {
						amountOfDoubleBackslash++;
						foundBackslash = false;
					} else {
						foundBackslash = false;
					}
				}
				string = string.replace("\\\\", "");
				usedCharactersForRepresentation += 2 * amountOfDoubleBackslash;
				usedSpaceInMemory += 1 * amountOfDoubleBackslash;
				System.out.println(string + " amount: " + amountOfDoubleBackslash);
			} else if (string.contains("\\\"")) {
				int amountOfBackslashDoubeQuote = 0;
				boolean foundBackslash = false;
				boolean foundDoubleQuote = false;
				for (char c : string.toCharArray()) {
					if (c == '\\') {
						foundBackslash = true;
					} else if (c == '\"' && foundBackslash) {
						amountOfBackslashDoubeQuote++;
					} else {
						foundBackslash = false;
						foundDoubleQuote = false;
					}
				}
				string = string.replace("\\\"", "");
				usedCharactersForRepresentation += 2 * amountOfBackslashDoubeQuote;
				usedSpaceInMemory += 1 * amountOfBackslashDoubeQuote;

				System.out.println(string);
			} else if (string.contains("\\x")) {
				char[] charArray = string.toCharArray();
				int startingNumber = 0;
				int endCounter = 0;
				int correctLineCounter = 0;
				String stringSequenceToRemove = "";
				for (int i = 0; i < charArray.length; i++) {
					if (charArray[i] == '\\') {
						startingNumber = i;
						correctLineCounter = 1;
						endCounter++;
						stringSequenceToRemove += charArray[i];
					} else if (charArray[i] == 'x' && correctLineCounter == 1) {
						endCounter++;
						stringSequenceToRemove += charArray[i];
					} else if (correctLineCounter == 1 && endCounter < 3) {
						endCounter++;
						stringSequenceToRemove += charArray[i];
					} else if (correctLineCounter == 1 && endCounter == 3) {
						stringSequenceToRemove += charArray[i];
						string = string.replace(stringSequenceToRemove, "");
						endCounter = 0;
						startingNumber = 0;
						correctLineCounter = 0;
						stringSequenceToRemove = "";
						usedSpaceInMemory++;
						usedCharactersForRepresentation += 4;
					}

				}
				System.out.println(string);
			}
		}

		System.out.println("rest of String: " + string);

		for (char c : string.toCharArray()) {
			usedCharactersForRepresentation++;
			usedSpaceInMemory++;
		}
		//
		// boolean escapeSequence = false;
		// int index = 0;
		// String oi = "";
		// char lastChar = 0;
		// for (char c : carr) {
		// usedCharactersForRepresentation++;
		// if (hasHexNumberInside) {
		// if (numberRepresentation == 1) {
		// oi += getCharOfHex(new String(new
		// StringBuilder().append(lastChar).append(c)));
		// numberRepresentation = 0;
		// hasHexNumberInside = false;
		// escapeSequence = false;
		// usedCharactersForRepresentation++;
		// usedSpaceInMemory++;
		// }
		// numberRepresentation++;
		// } else if (c == '\\') {
		// if (escapeSequence == true) {
		// escapeSequence = false;
		// usedCharactersForRepresentation++;
		// usedSpaceInMemory++;
		// } else {
		// System.out.println("\\ occured escape sequence");
		// escapeSequence = true;
		// oi += "\\";
		// }
		// } else if (c == 'x') {
		// hasHexNumberInside = true;
		// } else if (c == '"' && escapeSequence) {
		// escapeSequence = false;
		// oi += "\"";
		// usedCharactersForRepresentation++;
		// usedSpaceInMemory++;
		// }
		// lastChar = c;
		// index++;
		// }
		System.out.println(usedCharactersForRepresentation);
		System.out.println(usedSpaceInMemory);

		charactersInString += usedCharactersForRepresentation;
		charactersInMemory += usedSpaceInMemory;
	}

	public void StringAnalyserTwo(String string) {
		int lengthOriginal = 0;
		int lengthNew = 0;
		lengthOriginal += string.length();
		lengthNew += 2;
		System.out.println();
		System.out.println(string);
		int usedSpaceInMemory = 0;
		int usedCharactersForRepresentation = 0;

		int numberRepresentation = 0;
		boolean hasHexNumberInside = false;
		char[] carr = string.toCharArray();

		for (char c : carr) {
			if (c == '\\') {
				lengthNew += 2;
			} else if (c == '\"') {
				lengthNew += 2;
			} else {
				lengthNew++;
			}
		}
		System.out.println(lengthOriginal);
		System.out.println(lengthNew);

		charactersOriginal += lengthOriginal;
		charactersNew += lengthNew;
	}
}
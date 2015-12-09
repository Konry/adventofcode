package five;

public class StringAnalyser {

	/*
	 * String nice if: three vowels (aeiou) one letter twice no combination of
	 * ab, cd, pq, xy
	 */
	public boolean checkStringsNiceness(String input) {
		int vowelCounter = 0;
		
		boolean doubleLetter = false;
		boolean ab = false, cd = false, pq = false, xy = false;

		char[] charArray = input.toCharArray();
		char lastChar = '1';
		for (char c : charArray){
			String twoLetterCombination = new StringBuilder().append(lastChar).append(c).toString();
			switch(twoLetterCombination){
			case "ab":
				return false;
			case "cd":
				return false;
			case "pq":
				return false;
			case "xy":
				return false;
			}
			switch(c){
			case 'a':
				vowelCounter++;
				break;
			case 'e':
				vowelCounter++;
				break;
			case 'i':
				vowelCounter++;
				break;
			case 'o':
				vowelCounter++;
				break;
			case 'u':
				vowelCounter++;
				break;
			}
			if(lastChar == c){
				doubleLetter = true;
			}
			lastChar = c;
		}
		if(!doubleLetter){
			return false;
		}

		if(vowelCounter < 3){
			return false;
		}
		return true;
	}
	
	public boolean checkStringsNicenessII(String input){
//		int[] twiceTwoLetterPosition = new int[]{-1,-1,-1,-1};
		char[] inputAsChar = input.toCharArray();
		
		boolean twiceTwoLetterPostition = false;
		for(int i = 0; i < input.length(); i++){
			for(int j = i+2; j < input.length()-1; j++){
				if(input.substring(i, i+2).equals(input.substring(j, j+2))){
//					System.out.print(input.substring(i, i+2));
//					System.out.println(" vs "+input.substring(j, j+2));
					twiceTwoLetterPostition = true;
					break;
				}
			}
		}
		if(!twiceTwoLetterPostition){
			return false;
		}
		
		boolean twoLetterWithGap = false;
		for(int i = 0; i < input.length()-2; i++){
			if(inputAsChar[i] == inputAsChar[i+2]){
				twoLetterWithGap = true;
				break;
			}
		}
		if(!twoLetterWithGap){
			return false;
		}
		return true;
	}

//	public int checkString
}

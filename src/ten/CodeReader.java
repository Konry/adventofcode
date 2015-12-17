package ten;

public class CodeReader {

	public String readNumber(String number) {
		int counter = 0;
		char lastChar = 0;

		StringBuilder build = new StringBuilder();
		for (int i = 0; i < number.length(); i++) {
			if (i == 0) {
				lastChar = number.charAt(i);
				counter++;
				if(number.length() == 1) {
					build.append(convertToString(counter)).append(lastChar);
				}
			} else if (i == number.length() - 1) {
				if (lastChar != number.charAt(i)) {
					build.append(convertToString(counter)).append(lastChar);
					build.append(convertToString(1)).append(number.charAt(i));
				} else {
					counter++;
					build.append(convertToString(counter)).append(number.charAt(i));
				}
			} else {
				if (lastChar != number.charAt(i)) {
					build.append(convertToString(counter)).append(lastChar);
					counter = 1;
				} else {
					counter++;
				}
				lastChar = number.charAt(i);
			}
		}
		return build.toString();
	}

	private String convertToString(int count) {
		return String.valueOf(count);
	}
}

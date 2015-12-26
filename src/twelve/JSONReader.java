package twelve;

import java.util.ArrayList;
import java.util.Iterator;

public class JSONReader {
	int count = 0;
	int objectCount = 0;

	int generalSum = 0;

	public JSONReader() {
		// TODO Auto-generated constructor stub
	}

	public void doSomething(String json) {
		int paraUp = 0;
		int paraDown = 0;
		int paraUpT = 0;
		int paraDownT = 0;
		for (char c : json.toCharArray()) {
			if (c == '{') {
				paraUp++;
			} else if (c == '}') {
				paraDown++;
			} else if (c == '[') {
				paraUpT++;
			} else if (c == ']') {
				paraDownT++;
			}
		}
//		System.out.println(paraUp);
//		System.out.println(paraDown);
	}

	public String addCurvedParantheses(String json) {
		if (!json.contains("{")) {
			return json;
		}
		boolean blockParantheses = false;
		int indexStart = -1;
		int indexStop = -1;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbRest = new StringBuilder();
		int sumOfBlockBrackets = 0;
		for (char c : json.toCharArray()) {
			if (c == '{' && !blockParantheses) {
				sb = new StringBuilder();
				sb.append(c);
				blockParantheses = true;
			} else if (c == '{' && blockParantheses) {
				sbRest.append(sb);
				sb = new StringBuilder();
				sb.append(c);
				blockParantheses = true;
			} else if (c == '}' && blockParantheses) {
				sb.append(c);
				blockParantheses = false;

				if(sb.toString().contains("[") || sb.toString().contains("]")){
					System.err.println(sb.toString());
				}
				int calc = addCurved(sb.toString());
				sbRest.append(calc);
				sumOfBlockBrackets += calc;
			} else if (blockParantheses && c == '[') {
				sb.append(c);
				sbRest.append(sb);
				blockParantheses = false;
			} else if (blockParantheses) {
				sb.append(c);
			} else {
				sbRest.append(c);
			}
			index++;
		}
		return sbRest.toString();
	}

	public String addBlockParantheses(String json) {
		if (!json.contains("[")) {
			return json;
		}
		boolean blockParantheses = false;
		int index = 0;
		StringBuilder sb = new StringBuilder();
		StringBuilder sbRest = new StringBuilder();
		for (char c : json.toCharArray()) {
			if (c == '[' && !blockParantheses) {
				sb = new StringBuilder();
				sb.append(c);
				blockParantheses = true;
			} else if (c == '[' && blockParantheses) {
				sbRest.append(sb);
				sb = new StringBuilder();
				sb.append(c);
				blockParantheses = true;
			} else if (c == ']' && blockParantheses) {
				sb.append(c);
				blockParantheses = false;

				if(sb.toString().contains("{") || sb.toString().contains("}")){
					System.err.println(sb.toString());
				}
				int calc = add(sb.toString());
				sbRest.append(calc);
			} else if (blockParantheses && c == '{') {
				sb.append(c);
				sbRest.append(sb);
				blockParantheses = false;
			}  else if (blockParantheses) {
				sb.append(c);
			} else {
				sbRest.append(c);
			}
			index++;
		}
		return sbRest.toString();
	}

	private int add(String sb) {
		sb = sb.replace("[", "");
		sb = sb.replace("]", "");
		sb = sb.replace(":", "");
		sb = sb.replace("red","");
		int sum = 0;
		String[] block = sb.split(",");
		for (String s : block) {
			try {
				sum += Integer.parseInt(s);
			} catch (NumberFormatException e) {

			}
		}
		return sum;
	}

	private int addCurved(String sb) {
		sb = sb.replace("{", "");
		sb = sb.replace("}", "");
		sb = sb.replace(":", "");
		if (sb.contains("red")) {
			return 0;
		}
		int sum = 0;
		String[] block = sb.split(",");
		for (String s : block) {
			try {
				sum += Integer.parseInt(s);
			} catch (NumberFormatException e) {

			}
		}
		return sum;
	}

	public void read(String json) {
		String temp = removeStringsOfJson(json);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addBlockParantheses(temp);
		temp = addCurvedParantheses(temp);
		temp = addCurvedParantheses(temp);
		// System.out.println("size of smthng "+smthng.length)
		System.out.println("return " + temp);
	}

	public String removeAnnoyingStuff(String json) {
		if (json.contains("red")) {
			int index = json.indexOf('{');
			String temp = recoursion(json);
			return temp;
		}
		return json;
	}

	public String findAllObjects(String json) {
		int paraUp = 0;
		int paraDown = 0;
		int otherPara = 0;
		int index = 0;
		int replaceUp = -1;
		int replaceDown = -1;
		StringBuilder sb = new StringBuilder();
		boolean insidePara = false;
		boolean insideFirstPara = false;
		for (char c : json.toCharArray()) {
			if (c == '{') {
				paraUp++;
				insidePara = true;
				if (paraUp == 1) {
					insideFirstPara = true;
				} else {
					insideFirstPara = false;
				}
				if (insideFirstPara)
					sb.append(c);
				if (replaceUp == -1) {
					replaceUp = index;
				}
			} else if (c == '}' && paraUp == 1) {
				paraUp--;
				replaceDown = index;
				sb.append(c);
				break;
			} else if (c == '}') {
				paraUp--;
				if (paraUp == 1) {
					insideFirstPara = true;
				}
			} else if (c == '[' && insideFirstPara) {
				otherPara++;
			} else if (c == ']' && insideFirstPara) {
				otherPara--;
			} else if (insideFirstPara && otherPara == 0) {
				sb.append(c);
			}
			index++;
		}
		String temp = "";
		if (replaceUp != -1 && replaceDown != -1) {
		} else {
			return json;
		}
		if (sb.toString().contains("red")) {
			/* remove it */

			count += json.substring(replaceUp, replaceDown + 1).length();
			String replace = json.substring(replaceUp, replaceDown + 1);
			temp = json.replace(replace, "");
		} else {
			if (replaceUp > 0) {
				temp = json.substring(0, replaceUp - 1);
			}
			temp += "(" + json.substring(replaceUp + 1, replaceDown) + ")";
			if (replaceDown < json.length() - 1) {
				temp += json.substring(replaceDown, json.length() - 1);
			}
			objectCount++;
			System.out.println("Object " + objectCount + " " + temp);
			if (temp.contains("{")) {
				temp = findAllObjects(temp);
			}
			// temp = json.substring(0,
			// replaceUp-1)+"("+json.substring(replaceUp+1,
			// replaceDown-1)+")"+json.substring(replaceDown+1,json.length());
		}
		return temp;
	}

	public String recoursion(String json) {
		int paraUp = 0;
		int paraDown = 0;
		int otherPara = 0;
		int index = 0;
		int replaceUp = -1;
		int replaceDown = -1;
		StringBuilder sb = new StringBuilder();
		boolean insidePara = false;
		boolean insideFirstPara = false;
		for (char c : json.toCharArray()) {
			if (c == '{') {
				paraUp++;
				insidePara = true;
				if (paraUp == 1) {
					insideFirstPara = true;
				} else {
					insideFirstPara = false;
				}
				if (insideFirstPara)
					sb.append(c);
				if (replaceUp == -1) {
					replaceUp = index;
				}
			} else if (c == '}' && paraUp == 1) {
				paraUp--;
				replaceDown = index;
				sb.append(c);
				break;
			} else if (c == '}') {
				paraUp--;
				if (paraUp == 1) {
					insideFirstPara = true;
				}
			} else if (c == '[' && insideFirstPara) {
				otherPara++;
			} else if (c == ']' && insideFirstPara) {
				otherPara--;
			} else if (insideFirstPara && otherPara == 0) {
				sb.append(c);
			}
			index++;
		}
		String temp = "";
		if (replaceUp != -1 && replaceDown != -1) {
		} else {
			return json;
		}
		if (sb.toString().contains("red")) {
			/* remove it */

			count += json.substring(replaceUp, replaceDown + 1).length();
			System.out.println("remove " + json.substring(replaceUp, replaceDown + 1));
			String replace = json.substring(replaceUp, replaceDown + 1);
			temp = json.replace(replace, "");
			System.out.println(" REMOVE !!!! " + json.length() + " " + temp.length() + " "
					+ json.substring(replaceUp, replaceDown + 1).length());
		} else {
			if (replaceUp > 0) {
				temp = json.substring(0, replaceUp - 1);
			}
			temp += "(" + json.substring(replaceUp + 1, replaceDown) + ")";
			if (replaceDown < json.length() - 1) {
				temp += json.substring(replaceDown, json.length() - 1);
			}
			if (temp.contains("{")) {
				temp = recoursion(temp);
			}
			// temp = json.substring(0,
			// replaceUp-1)+"("+json.substring(replaceUp+1,
			// replaceDown-1)+")"+json.substring(replaceDown+1,json.length());
		}
		return temp;
	}

	public String removeAllRedObjects(String json) {
		if (json.indexOf("red") >= 0) {
			count++;
			int index = json.indexOf("red");
			int removeStart = 0;
			int removeEnd = 0;
			int upParanthesis = 1;
			int downParanthesis = 1;
			int otherParenthesis = 0;
			// System.out.println("found index " + index);
			boolean foundUp = false;
			boolean foundDown = false;
			for (int i = index; i > 0; i--) {
				if (json.charAt(i) == '{' && downParanthesis == 1) {
					removeStart = i;
					foundUp = true;
					break;
				} else if (json.charAt(i) == '}') {
					downParanthesis++;
				} else if (json.charAt(i) == '{') {
					downParanthesis--;
				} else if (json.charAt(i) == '[' && downParanthesis == 1 && otherParenthesis == 0) {
					// System.out.println("found legal red "+i);
					String temp = json.replaceFirst("red", "mad");
					// System.out.println(temp);
					temp = removeAllRedObjects(temp);
					return temp;
				} else if (json.charAt(i) == ']') {
					otherParenthesis++;
				}
			}
			otherParenthesis = 0;
			for (int i = index; i < json.length(); i++) {
				if (json.charAt(i) == '}' && upParanthesis == 1) {
					removeEnd = i;
					foundDown = true;
					break;
				} else if (json.charAt(i) == '{') {
					upParanthesis++;
				} else if (json.charAt(i) == '}') {
					upParanthesis--;
				} else if (json.charAt(i) == ']' && upParanthesis == 1 && otherParenthesis == 0) {
					// System.out.println("found legal red "+i);
					String temp = json.replaceFirst("red", "mad");
					temp = removeAllRedObjects(temp);
					return temp;
				} else if (json.charAt(i) == '[') {
					otherParenthesis++;
				}
			}
			// System.out.println("FUCK YOU " + json.indexOf("red"));
			// System.out.println(removeStart + " " + removeEnd);
			// System.out.println("remove: "+json.substring(removeStart,
			// removeEnd+1));
			String temp = json.substring(0, removeStart) + json.substring(removeEnd + 1, json.length());
			// System.out.println(temp);
			temp = removeAllRedObjects(temp);
			// System.out.println(temp);
			return temp;
		}
		// System.out.println(json.indexOf("red"));
		// System.out.println(json);
		return json;
	}

	private String removeStringsOfJson(String json) {
		StringBuilder sb = new StringBuilder();

		boolean activeString = false;
		boolean canBeRed = false;
		char lastChar = 0;
		for (char c : json.toCharArray()) {
			if (c == '"' && !activeString) {
				activeString = true;
			} else if (c == '"' && activeString) {
				activeString = false;
			} else if (activeString) {
				if (c == 'r' && !canBeRed) {
					canBeRed = true;
					lastChar = c;
				} else if (c == 'e' && canBeRed && lastChar == 'r') {
					lastChar = c;
				} else if (c == 'd' && canBeRed) {
					sb.append("red");
					canBeRed = false;
				} else {
					canBeRed = false;
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}

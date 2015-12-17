package ten;

public class Ten {
	public static void main(String[] args) {
		CodeReader cr = new CodeReader();
		System.out.println(cr.readNumber("1"));
		System.out.println(cr.readNumber("11"));
		System.out.println(cr.readNumber("21"));
		System.out.println(cr.readNumber("1211"));
		System.out.println(cr.readNumber("111221"));

		String input = "1113122113";
		String output = "";
		for (int i = 0; i < 50; i++) {
			output = cr.readNumber(input);
			System.out.println(output.length());
			input = output;
		}
	}
}

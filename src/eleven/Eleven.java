package eleven;

public class Eleven {

	public static void main(String[] args) {
		
		PasswordGenerator gen = new PasswordGenerator();
		
		System.out.println(gen.checkConditionsViolations("hijklmmn"));
		
		System.out.println(gen.checkConditionsViolations("abbceffg"));
		
		System.out.println(gen.checkConditionsViolations("abbcegjk"));
		
		System.out.println(gen.generate("abcdefgh"));
		System.out.println(gen.generate("ghijklmn"));
		System.out.println(gen.generate("vzbxkghb"));
		System.out.println(gen.generate("vzbxxyzz"));

	}

}

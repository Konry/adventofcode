package sixteen;

public class Aunt {
	public String name = "";
	public int children = -1;
	public int cats = -1;
	public int samoyeds = -1;
	public int pomeranians = -1;
	public int akitas = -1;
	public int vizslas = -1;
	public int goldfish = -1;
	public int trees = -1;
	public int cars = -1;
	public int perfumes = -1;

	public static boolean parse(String aunt) {
		System.out.println(aunt);
		aunt = aunt.replaceFirst(": ", ", ");
		// aunt = aunt.replace(", ", ",");
		String[] split = aunt.split(", ");
		Aunt temp = new Aunt();
		temp.name = split[0];
		for (String s : split) {
			if (s.contains("children")) {
				s = s.replace("children: ", "");
				temp.children = Integer.parseInt(s);

			} else if (s.contains("cats")) {
				s = s.replace("cats: ", "");
				temp.cats = Integer.parseInt(s);

			} else if (s.contains("samoyeds")) {
				s = s.replace("samoyeds: ", "");
				temp.samoyeds = Integer.parseInt(s);

			} else if (s.contains("pomeranians")) {
				s = s.replace("pomeranians: ", "");
				temp.pomeranians = Integer.parseInt(s);

			} else if (s.contains("akitas")) {
				s = s.replace("akitas: ", "");
				temp.akitas = Integer.parseInt(s);

			} else if (s.contains("vizslas")) {
				s = s.replace("vizslas: ", "");
				temp.vizslas = Integer.parseInt(s);

			} else if (s.contains("goldfish")) {
				s = s.replace("goldfish: ", "");
				temp.goldfish = Integer.parseInt(s);

			} else if (s.contains("trees")) {
				s = s.replace("trees: ", "");
				temp.trees = Integer.parseInt(s);

			} else if (s.contains("cars")) {
				s = s.replace("cars: ", "");
				temp.cars = Integer.parseInt(s);

			} else if (s.contains("perfumes")) {
				s = s.replace("perfumes: ", "");
				temp.perfumes = Integer.parseInt(s);

			}
		}
		return checkForCorrectAunt(temp);
	}

	public static boolean checkForCorrectAunt(Aunt aunt) {
		if (aunt.children >= 0 && aunt.children != 3) {
			return false;
		}
		if (aunt.cats >= 0 && aunt.cats <= 7) {
			return false;
		}
		if (aunt.samoyeds >= 0 && aunt.samoyeds != 2) {
			return false;
		}
		if (aunt.pomeranians >= 0 && aunt.pomeranians >= 3) {
			return false;
		}
		if (aunt.akitas >= 0 && aunt.akitas != 0) {
			return false;
		}
		if (aunt.vizslas >= 0 && aunt.vizslas != 0) {
			return false;
		}
		if (aunt.goldfish >= 0 && aunt.goldfish >= 5) {
			return false;
		}
		if (aunt.trees >= 0 && aunt.trees <= 3) {
			return false;
		}
		if (aunt.cars >= 0 && aunt.cars != 2) {
			return false;
		}
		if (aunt.perfumes >= 0 && aunt.perfumes != 1) {
			return false;
		}
		return true;
	}

}

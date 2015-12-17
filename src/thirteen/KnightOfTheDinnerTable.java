package thirteen;

import java.util.ArrayList;

public class KnightOfTheDinnerTable {

	public KnightOfTheDinnerTable() {
	}

	public int totalHappiness(String[] input) throws Exception {
		SittingArrangement[] arrangement = new SittingArrangement[input.length];
		int index = 0;
		for (String s : input) {
			arrangement[index++] = SittingArrangement.parseArrangement(s);
		}

		ArrayList<Sitter> sitters = new ArrayList<Sitter>();
		fillArrayList(arrangement, sitters);

		for (Sitter s : sitters) {
			System.out.println(s.name);
		}

		int[] happiness = new int[multSitters(sitters.size())];
		int maxHappiness = 0;
		System.out.println("go " + sitters.size());
		index = 0;
		Thread.sleep(1000);
		for (int i = 1; i < sitters.size(); i++) {
			for (int j = 1; j < sitters.size(); j++) {
				for (int k = 1; k < sitters.size(); k++) {
					for (int l = 1; l < sitters.size(); l++) {
						for (int m = 1; m < sitters.size(); m++) {
							for (int n = 1; n < sitters.size(); n++) {
								for (int o = 1; o < sitters.size(); o++) {
									for (int p = 1; p < sitters.size(); p++) {
										if (i != j && j != k && k != l && l != m && m != n && n != o && o != p && i != k
												&& i != l && i != m && i != n && i != o && i != p && j != l && j != m
												&& j != n && j != o && j != p && k != m && k != n && k != o && k != p
												&& l != n && l != o && l != p && m != o && m != p && n != p) {
											int distance = 0;

											ArrayList<Sitter> list = new ArrayList<>();
											list.add(sitters.get(0));
											list.add(sitters.get(i));
											list.add(sitters.get(j));
											list.add(sitters.get(k));
											list.add(sitters.get(l));
											list.add(sitters.get(m));
											list.add(sitters.get(n));
											list.add(sitters.get(o));
											list.add(sitters.get(p));

											int tempHappiness = calculateHappieness(list, arrangement);
											index++;

											if (tempHappiness > maxHappiness) {
												maxHappiness = tempHappiness;
											}

											if (index % 1000 == 0) {
												System.out.println(index);
											}

										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(index + " " + multSitters(sitters.size()));
		System.out.println(maxHappiness);
		return 0;
	}

	private int calculateHappieness(ArrayList<Sitter> list, SittingArrangement[] sit) {
		int happiness = 0;
		for (int i = 0; i < list.size(); i++) {
			/* check left */
			String nameOfSitter = list.get(i).name;
			int prev = (i - 1) % list.size();
			int next = (i + 1) % list.size();
			// System.out.println("List "+prev + " "+next + " "+i);
			if (next > list.size() - 1) {
				next = 0;
			}
			if (prev < 0) {
				prev = list.size() - 1;
			}
			String nameOfPrevSitter = list.get(prev).name;
			String nameOfNextSitter = list.get(next).name;
			for (SittingArrangement ara : sit) {
				if (ara.getName().equals(nameOfSitter) && ara.getSittingNextTo().equals(nameOfPrevSitter)) {
					happiness += ara.getHappinessPoints();
				} else if (ara.getName().equals(nameOfSitter) && ara.getSittingNextTo().equals(nameOfNextSitter)) {
					happiness += ara.getHappinessPoints();
				}
			}
		}
		return happiness;
	}

	public int totalHappinessGeneral(String[] input) {
		SittingArrangement[] arrangement = new SittingArrangement[input.length];
		int index = 0;
		for (String s : input) {
			arrangement[index++] = SittingArrangement.parseArrangement(s);
		}

		ArrayList<Sitter> sitters = new ArrayList<Sitter>();
		fillArrayList(arrangement, sitters);

		for (Sitter s : sitters) {
			System.out.println(s.name);
		}
		System.out.println("Sitters on the table: " + sitters + " possibilities: " + multSitters(sitters.size()));

		LinkedLinkedList[] linkedListArray = new LinkedLinkedList[multSitters(sitters.size())];
		for (int i = 0; i < multSitters(sitters.size()); i++) {
			int[] usedInts = new int[sitters.size() - 1];
			LinkedLinkedList list = new LinkedLinkedList();
			list.add(sitters.get(0));
			for (int j = 1; j < sitters.size(); j++) {
				// list = generateList(i, linkedListArray, sitters, usedInts);
			}
			// linkedListArray[i] =
		}

		return -1;
	}

	private void fillArrayList(SittingArrangement[] arrangement, ArrayList<Sitter> sitters) {
		for (SittingArrangement sit : arrangement) {
			if (sitters.size() == 0) {
				sitters.add(new Sitter(sit.getName()));
			} else {
				boolean isAlreadyInside = false;
				for (Sitter s : sitters) {
					if (s.name.equals(sit.getName())) {
						isAlreadyInside = true;
					}
				}
				if (!isAlreadyInside) {
					sitters.add(new Sitter(sit.getName()));
				}
			}
		}
	}

	private int multSitters(int sitters) {
		int sum = 1;
		for (int i = 1; i < sitters; i++) {
			sum *= i;
		}
		return sum;
	}
}

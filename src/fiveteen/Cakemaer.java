package fiveteen;

public class Cakemaer {

	void generateTeig(String[] cakeStrings) {
		Cake[] cakes = new Cake[cakeStrings.length];
		for (int i = 0; i < cakeStrings.length; i++) {
			cakes[i] = Cake.parseCake(cakeStrings[i]);
		}

		generateResult(cakes);
	}

	private void generateResult(Cake[] cakes) {
		// for (Cake c : cakes) {
		int bigResult = 0;
		for (int i = 0; i <= 100; i++) {
			int cakeOne = cakes[0].capacity + cakes[0].durability + cakes[0].flavor + cakes[0].texture;
			if (cakeOne < 0) {
				cakeOne = 0;
			}
			for (int j = 0; j <= 100; j++) {
				int cakeTwo = cakes[1].capacity + cakes[1].durability + cakes[1].flavor + cakes[1].texture;
				if (cakeTwo < 0) {
					cakeTwo = 0;
				}
				if (cakes.length > 2) {
					for (int k = 0; k <= 100; k++) {
						int cakeThree = cakes[2].capacity + cakes[2].durability + cakes[2].flavor + cakes[2].texture;
						if (cakeThree < 0) {
							cakeThree = 0;
						}
						if (cakes.length > 3) {
							for (int l = 0; l <= 100; l++) {
								int cakeFour = cakes[3].capacity + cakes[3].durability + cakes[3].flavor
										+ cakes[3].texture;
								if (cakeFour < 0) {
									cakeFour = 0;
								}
								int sum = i + j + k + l;
								if (sum == 100) {
									int result = 1;
									int temp = 0;
									temp = i * cakes[0].capacity + j * cakes[1].capacity + k * cakes[2].capacity
											+ l * cakes[3].capacity;
									if (temp <= 0) {
										temp = 1;
									}
									result *= temp;
									temp = i * cakes[0].durability + j * cakes[1].durability + k * cakes[2].durability
											+ l * cakes[3].durability;
									if (temp <= 0) {
										temp = 1;
									}
									result *= temp;
									temp = i * cakes[0].flavor + j * cakes[1].flavor + k * cakes[2].flavor
											+ l * cakes[3].flavor;
									if (temp <= 0) {
										temp = 1;
									}
									result *= temp;
									temp = i * cakes[0].texture + j * cakes[1].texture + k * cakes[2].texture
											+ l * cakes[3].texture;
									if (temp <= 0) {
										temp = 1;
									}
									result *= temp;
									System.out.println("result: " + result + " " + cakeFour + " " + i);
									int calories = 0;
									calories += cakes[0].calories*i;
									calories += cakes[1].calories*j;
									calories += cakes[2].calories*k;
									calories += cakes[3].calories*l;
									if (bigResult < result && calories == 500) {
										bigResult = result;
									}
								}
							}
						} else {
							int sum = i + j + k;
							if (sum == 100) {
								int result = 0;
								result += i * cakeOne;
								result += j * cakeTwo;
								result += k * cakeThree;
								System.out.println("result: " + result);
								if (bigResult < result) {
									bigResult = result;
								}
							}
						}
					}
				} else {
					int sum = i + j;
					if (sum == 100) {
						int result = 0;
						result += i * cakeOne;
						result += j * cakeTwo;
						System.out.println("result: " + result);
						if (bigResult < result) {
							bigResult = result;
						}
					}
				}
			}
			// }
		}
		System.out.println(bigResult);
	}

}

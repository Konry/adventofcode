package fourteen;

import java.util.ArrayList;

public class ReindeerRace {

	ArrayList<Reindeer> deers = new ArrayList<>();

	public void race(int seconds) {
		int[] score = new int[deers.size()];
		int[] distances  = new int[deers.size()];
		for (int j = 1; j <= seconds; j++) {
			for (int i = 0; i < deers.size(); i++) {
				
				boolean secondsOutOfBounds = false;
				int multiplicator = 0;
				while (!secondsOutOfBounds) {
					multiplicator++;
					if (j <= (deers.get(i).durabilityInSeconds + deers.get(i).restTimeInSeconds)
							* multiplicator) {
						secondsOutOfBounds = true;
						multiplicator--;
					}
					int runTime = (deers.get(i).durabilityInSeconds + deers.get(i).restTimeInSeconds) * multiplicator;
					int distance = deers.get(i).kmPerSecond * deers.get(i).durabilityInSeconds * multiplicator;
					// System.out.println(deers.get(i).kmPerSecond + "
					// "+deers.get(i).durabilityInSeconds);
//					System.out.println(deers.get(i).name+" Distance "+distance);

					if (secondsOutOfBounds) {
						int general = (j - (runTime + deers.get(i).durabilityInSeconds));
//						System.out.println("seconds " + j + " - runtime + " + runTime + " "
//								+ deers.get(i).durabilityInSeconds + " " + distance + " missing: "
//								+ (deers.get(i).durabilityInSeconds + general));
						if (general < 0) {
							// System.out.println("plus
							// "+(deers.get(i).durabilityInSeconds - general)+ "
							// "+general);
							distance += (deers.get(i).durabilityInSeconds + general) * deers.get(i).kmPerSecond;
						} else {
							distance += (deers.get(i).durabilityInSeconds * deers.get(i).kmPerSecond);
						}
						System.out.println(deers.get(i).name + " distance: " + distance + " time: " + runTime + " "
								+ multiplicator);
						distances[i] = distance;
						break;
					}

				}
//				boolean secondsOutOfBounds = false;
//				int multiplicator = 0;
//				while (!secondsOutOfBounds) {
//					multiplicator++;
//					if (seconds <= (deers.get(i).durabilityInSeconds + deers.get(i).restTimeInSeconds)
//							* multiplicator) {
//						secondsOutOfBounds = true;
//						multiplicator--;
//					}
//					// System.out.println("multi: "+multiplicator);
//					int runTime = (deers.get(i).durabilityInSeconds + deers.get(i).restTimeInSeconds) * multiplicator;
//					int distance = deers.get(i).kmPerSecond * deers.get(i).durabilityInSeconds * multiplicator;
//					// System.out.println(deers.get(i).kmPerSecond + "
//					// "+deers.get(i).durabilityInSeconds);
//
//					if (secondsOutOfBounds) {
//						int general = (seconds - (runTime + deers.get(i).durabilityInSeconds));
//						System.out.println("seconds " + seconds + " - runtime + " + runTime + " "
//								+ deers.get(i).durabilityInSeconds + " " + distance + " missing: "
//								+ (deers.get(i).durabilityInSeconds + general));
//						if (general < 0) {
//							// System.out.println("plus
//							// "+(deers.get(i).durabilityInSeconds - general)+ "
//							// "+general);
//							distance += (deers.get(i).durabilityInSeconds + general) * deers.get(i).kmPerSecond;
//						} else {
//							distance += (deers.get(i).durabilityInSeconds * deers.get(i).kmPerSecond);
//						}
//						System.out.println(deers.get(i).name + " distance: " + distance + " time: " + runTime + " "
//								+ multiplicator);
//					}
//				}
			}
			int index = -1;
			int maxDistance = -1;
			for(int k = 0; k < deers.size(); k++){
				System.out.println(distances[k]);
				if(distances[k] > maxDistance){
					maxDistance = distances[k];
					index = k;
				}
			}
			score[index]++;
		}
		for(int i = 0; i < deers.size(); i++){
			System.out.println("scores: "+i + " "+score[i]);
		}
	}

	public Reindeer parseString(String reindeer) {
		reindeer = reindeer.replace(" can fly ", ",");
		reindeer = reindeer.replace(" km/s for ", ",");
		reindeer = reindeer.replace(" seconds, but then must rest for ", ",");
		reindeer = reindeer.replace(" seconds.", "");
		String[] splits = reindeer.split(",");

		System.out.println(reindeer);
		Reindeer doe = new Reindeer(splits[0], Integer.parseInt(splits[1]), Integer.parseInt(splits[2]),
				Integer.parseInt(splits[3]));
		deers.add(doe);
		return doe;
	}

	class Reindeer {

		Reindeer(String name, int km, int durability, int rest) {
			this.name = name;
			this.kmPerSecond = km;
			this.durabilityInSeconds = durability;
			this.restTimeInSeconds = rest;
		}

		String name;
		int kmPerSecond;
		int durabilityInSeconds;
		int restTimeInSeconds;
	}

}

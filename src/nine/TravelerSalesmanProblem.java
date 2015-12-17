package nine;

import java.util.ArrayList;
import java.util.LinkedList;

public class TravelerSalesmanProblem {

	final int BAD_POINTS = 1000000;
	final int START_MAX = 500000;
	final int START_MIN = 0;

	ArrayList<String> listOfCities;
	ArrayList<DistanceModel> listOfDistances;

	public TravelerSalesmanProblem() {
		listOfCities = new ArrayList<>();
		listOfDistances = new ArrayList<>();
		// TODO Auto-generated constructor stub
	}

	public String addCity(String city) {
		for (String s : listOfCities) {
			if (s.equals(city)) {
				return city;
			}
		}
		listOfCities.add(city);
		return city;
	}

	public void getModelOutOfString(String route) {
		route = route.replace(" = ", ",");
		route = route.replace(" to ", ",");
		String[] split = route.split(",");
		listOfDistances.add(new DistanceModel(addCity(split[0]), addCity(split[1]), Integer.parseInt(split[2])));
		listOfDistances.add(new DistanceModel(addCity(split[1]), addCity(split[0]), Integer.parseInt(split[2])));
	}

	private int moreWay(String nextNode, String start, String end, ArrayList<String> list, int recLevel) {
		int distanceMin = 100000;
		String startingNode = new String(nextNode);
		// for (int i = 0; i < recLevel; i++) {
		// System.out.print("------");
		// }
		// System.out.println();
		// for (int i = 0; i < recLevel; i++) {
		// System.out.print("------");
		// }
		System.out.println("recursion level " + recLevel + " input: nn:" + nextNode + " st:" +start + " end:"+ end + " " + print(list) + " "+list.size()+ " "+listOfCities.size());
		int distance_min = START_MAX;

		if (nextNode == end && list.size() == listOfCities.size()) {
			System.out.println("Ende");
			return 0;
		} else if (nextNode == end) {
			System.out.println("Fehler");
			return BAD_POINTS;
		}
		System.out.println("Possibilities:");
		System.out.println(print(list));
		for (DistanceModel d : listOfDistances) {
			if (d.start.equals(nextNode) && !alreadyVisited(d.end, list)) {
				System.out.println(d.print());
			}
		}
		for (DistanceModel d : listOfDistances) {
			ArrayList<String> visited = new ArrayList<>();
			for(String s: list){
				visited.add(s);
			}
			if (d.start.equals(nextNode) && !alreadyVisited(d.end, visited)) {
				System.out.println();
				visited.add(d.end);
				print("Liste : ",visited);
				System.out.println("try "+d.print());
				int distance = moreWay(d.end, start, end, visited, ++recLevel) + d.distance;
				System.out.println(distance);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// for (int i = 0; i < recLevel; i++) {
		// System.out.print("------");
		// }
		// System.out.println("Return Min from " + distance_min + "" +
		// print(list));
		// System.out.println("CHANGE DIST Min from " + distance_min + " to ");
		return distance_min;
	}

	public void calculateShortestRoute() {
		System.out.println(sillyCalculation());
		// ArrayList<String> visitedCities = new ArrayList<>();
		LinkedList<Integer> results = new LinkedList<>();

		for (DistanceModel n : listOfDistances) {
			System.out.println(n.print());
		}

		for (String startingCity : listOfCities) {
			for (String endingCity : listOfCities) {
				ArrayList<String> visited = new ArrayList<>();
				if (startingCity.equals(endingCity)) {

				} else {
					System.out.println();
					System.out.println("###### " + startingCity + " " + endingCity + " " + visited.size());
					visited.add(startingCity);
					int result = moreWay(startingCity, startingCity, endingCity, visited, 1);
					System.out.println("RETURN " + result);
					results.add(result);
					// if (visited.size() == listOfCities.size()) {
					System.out.println("###### " + startingCity + " " + endingCity + " " + visited.size());
					for (String s : visited) {
						System.out.println(s);
					}
					// }
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for (Integer i : results) {
			if (i < min) {
				min = i;
				System.out.println(i);
			}
		}
	}

	private boolean alreadyVisited(String cityToCheck, ArrayList<String> visitedCities) {
		for (String city : visitedCities) {
			if (city.equals(cityToCheck)) {
				return true;
			}
		}
		// System.out.println("Found city! " + cityToCheck);
		return false;
	}

	private String print(String title, ArrayList<String> visitedCities) {
		String temp = "# " + title + "";
		if (visitedCities.size() == 0) {
			return "#" + title + "\nempty#";
		}
		for (String s : visitedCities) {
			temp += s + " ";
		}
		return temp += "#";

	}

	private String print(ArrayList<String> visitedCities) {
		return print("", visitedCities);
	}

	private int getRoute(String a, String b) {
		for (nine.DistanceModel d : listOfDistances) {
			if (d.getStart().equals(a) && d.getEnd().equals(b)) {
				return d.distance;
			}
		}
		return 120000;
	}

	/*
	 * min: 251 max: 898
	 */
	private int sillyCalculation() {
		int distance_min = 0;
		for (int i = 0; i < listOfCities.size(); i++) {
			for (int j = 0; j < listOfCities.size(); j++) {
				for (int k = 0; k < listOfCities.size(); k++) {
					for (int l = 0; l < listOfCities.size(); l++) {
						for (int m = 0; m < listOfCities.size(); m++) {
							for (int n = 0; n < listOfCities.size(); n++) {
								for (int o = 0; o < listOfCities.size(); o++) {
									for (int p = 0; p < listOfCities.size(); p++) {
										if (i != j && j != k && k != l && l != m && m != n && n != o && o != p && i != k
												&& i != l && i != m && i != n && i != o && i != p && j != l && j != m
												&& j != n && j != o && j != p && k != m && k != n && k != o && k != p
												&& l != n && l != o && l != p && m != o && m != p && n != p) {
											int distance = 0;
											distance += getRoute(listOfCities.get(i), listOfCities.get(j));
											distance += getRoute(listOfCities.get(j), listOfCities.get(k));
											distance += getRoute(listOfCities.get(k), listOfCities.get(l));
											distance += getRoute(listOfCities.get(l), listOfCities.get(m));
											distance += getRoute(listOfCities.get(m), listOfCities.get(n));
											distance += getRoute(listOfCities.get(n), listOfCities.get(o));
											distance += getRoute(listOfCities.get(o), listOfCities.get(p));
											if (distance_min < distance) {
												distance_min = distance;
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
		return distance_min;
	}

}

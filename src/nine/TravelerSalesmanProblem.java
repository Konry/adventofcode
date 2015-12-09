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
		System.out.println();
		for (int i = 0; i < recLevel; i++) {
			System.out.print("------");
		}
		int distance_min = START_MAX;

		for (DistanceModel d : listOfDistances) {
			if (d.start.equals(nextNode)) {
				// System.out.println();
				// System.out.println("Test " + d.print());
				// if (start.equals("A") && end.equals("D"))
				for (int i = 0; i < recLevel; i++) {
					System.out.print("------");
				}
				System.out.println(
				 "try way from: " + start + " to " + end + " over the edge " + d.start + " to " + d.end
				 + " " + d.end.equals(end) + " " + list.size() + " " +
				 listOfCities.size());
				if (d.end.equals(end) && list.size() == listOfCities.size() - 1) {
//					for (int i = 0; i < recLevel; i++) {
//						System.out.print("------");
//					}
//					System.out.println("\n\n\n\nend found + " + list.size() + " " + listOfCities.size() + " "
//							+ print(list) + "\n\n\n\n");
					list.add(d.end);
					return d.distance;
				} else if (d.end.equals(end)) {
					for (int i = 0; i < recLevel; i++) {
						System.out.print("------");
					}
					System.out.println("BAD POINTS");
					list.add(d.end);
					return BAD_POINTS;
				}
				// ArrayList<String> visited = new ArrayList<>();
				// for (String s : list) {
				// visited.add(s);
				// }

				// if (start.equals("A") && end.equals("I"))
				// System.out.println(print("visited list: ", visited) + "
				// check: " + d.end + " "
				// + alreadyNotVisited(d.end, visited));
				if (alreadyNotVisited(d.end, list)) {
					list.add(d.end);
					// System.out.println(print("visited list: ", list) + "
					// check: " + d.end + " "
					// + alreadyNotVisited(d.end, list));

					if (d.end.equals(end) && list.size() == listOfCities.size()) {
						return d.distance;
					}
					int distance = moreWay(d.end, start, end, list, ++recLevel) + d.distance;
					for (int i = 0; i < recLevel; i++) {
						System.out.print("------");
					}
					System.out.println(d.print());
					// System.out.println("BACKTRACE "+d.end);
					// System.out.println("\n\n\n####################\n" +
					// distance + "\n\n\n####################\n");
					// System.out.println("dis: "+distance+ " :
					// "+(distance_min > distance)+ (visited.size() ==
					// listOfCities.size() - 1) + " "+visited.size() + "
					// "+listOfCities.size());
					if (distance_min > distance && list.size() == listOfCities.size()) {
						for (int i = 0; i < recLevel; i++) {
							System.out.print("------");
						}
						System.out.println("CHANGE DIST Min from " + distance_min + " to " + distance + print(list));
						distance_min = distance;
					}
				}
			}
		}
		// System.out.println("CHANGE DIST Min from " + distance_min + " to ");
		return distance_min;
	}

	public void calculateShortestRoute() {
		System.out.println(sillyCalculation());
		// ArrayList<String> visitedCities = new ArrayList<>();
		ArrayList<String> visitedFinalCities = new ArrayList<>();
		LinkedList<Integer> results = new LinkedList<>();

		for (DistanceModel d : listOfDistances) {
			System.out.println(d.print());
		}

		for (String startingCity : listOfCities) {
			for (String endingCity : listOfCities) {
				ArrayList<String> visited = new ArrayList<>();
				if (startingCity.equals(endingCity)) {

				} else {
					visited.add(startingCity);
					results.add(moreWay(startingCity, startingCity, endingCity, visited, 1));
					if (visited.size() == listOfCities.size()) {
						System.out.println("###### " + startingCity + " " + endingCity + " " + visited.size());
						for (String s : visited) {
							System.out.println(s);
						}
					}
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

	private int calculateDistance(String endingCity, String city, ArrayList<String> visitedCities) {
//		System.out.println(print("visited cities", visitedCities));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(print("visitedCities", visitedCities));
		if (city.equals(endingCity)) {
			System.out.println("already ending city");
			visitedCities.add(city);
			return 0;
		}
		String visited = "";
		int distance_min = Integer.MAX_VALUE;
		for (DistanceModel d : listOfDistances) {
			if (d.start.equals(city) && alreadyNotVisited(d.end, visitedCities)) {
				visitedCities.add(d.end);
				int distance = calculateDistance(endingCity, d.end, visitedCities) + d.distance;
				if (distance <= distance_min) {
					for (String s : visitedCities) {
						System.out.println("visited: " + s);
					}
					distance_min = distance;
					visited = d.end;
				}
			}
		}
		visitedCities.add(visited);
		return distance_min;
	}

	private boolean checkCities(ArrayList<String> visitedCities) {
		if (visitedCities.size() != listOfCities.size()) {
			System.out.println("Visited not all " + visitedCities.size() + " " + listOfCities.size());
			return false;
		}
		return true;
	}

	private boolean alreadyNotVisited(String cityToCheck, ArrayList<String> visitedCities) {
		System.out.println(print("visited list: ", visitedCities) + " check:" + cityToCheck);
		for (String city : visitedCities) {
			if (city.equals(cityToCheck)) {
				return false;
			}
		}
		// System.out.println("Found city! " + cityToCheck);
		return true;
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

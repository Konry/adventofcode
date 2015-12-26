package day24;

import java.util.ArrayList;

public class Day24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PackageWeights p = new PackageWeights();
		p.calculatePackageWeights(p.packageWeights);
	}

	public static class PackageWeights {
		public PackageWeights() {

		}

		int[] packageWeights = new int[] { 1, 3, 5, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 67, 71, 73, 79,
				83, 89, 97, 101, 103, 107, 109, 113 };
		int[] examplePackageWeights = new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10, 11 };

		public int calculatePackageWeights(int[] packageList) {
			System.out.println(packageList.length);
			boolean[] isInside = new boolean[packageList.length];
			ArrayList<Integer> packageDistribution = new ArrayList<Integer>();
			for (boolean b : isInside) {
				b = false;
			}

			int sum = 0;
			sum += sum(packageList);
			System.out.println("sum " + sum / 4);

			takeOneFromList(packageList, sum / 4);

			return -1;
		}

		public long takeOneFromList(int[] pl, int sumToReach) {
			ArrayList<Integer> list = new ArrayList<>();
			long minimalQuantumSum = Long.MAX_VALUE;
			int sumOfPackages = 1000;
			int count = 0;
			for (int i = pl.length - 1; i >= 0; i--) {
				for (int j = pl.length - 1; j >= 0; j--) {
					for (int k = pl.length - 1; k >= 0; k--) {
						for (int l = pl.length - 1; l >= 0; l--) {
							for (int m = pl.length - 1; m >= 0; m--) {
								for (int n = pl.length - 1; n >= 0; n--) {
									for (int o = pl.length - 1; o >= 0; o--) {
										// for (int p = pl.length - 1; p >= 0;
										// p--) {
										// for (int q = pl.length - 1; q >= 0;
										// q--) {

										if (i != j && i != k && i != l && i != m && i != n && j != k && j != l && j != m
												&& j != n && k != l && k != m && k != n && l != m && l != n && m != n
												&& i != o && j != o && k != o && l != o && m != o && n != o) {
											// if (i != j && i != k && i != l &&
											// i != m && i != n && j != k && j
											// != l
											// && j != m && j != n && k != l &&
											// k != m && k != n && l != m
											// && l != n && m != n && i != o &&
											// i != p && i != q && j != o
											// && j != p && j != q && k != o &&
											// k != p && k != q && l != o
											// && l != p && l != q && m != o &&
											// m != p && m != q && n != o
											// && n != p && n != q && o != p &&
											// o != q && p != q) {
											count++;
											// System.out.println("inside
											// "+count+ " "+i+" "+j+" "+k+" "+l+
											// " "+m+" "+n+ " "+o+" "+p+" "+q);
											list.clear();
											int sumOfWeights = 0;
											int tempSumOfPackages = 0;

											sumOfWeights += pl[i];
											tempSumOfPackages++;
											list.add(pl[i]);
											// System.out.println("add "+i+"
											// "+sumOfWeights);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[j];
											// System.out.println("add "+i+"
											// "+sumOfWeights+" "+sumToReach+"
											// "+(sumOfWeights > sumToReach));
											tempSumOfPackages++;
											list.add(pl[j]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[k];
											tempSumOfPackages++;
											list.add(pl[k]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[l];
											tempSumOfPackages++;
											list.add(pl[l]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[m];
											tempSumOfPackages++;
											list.add(pl[m]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[n];
											tempSumOfPackages++;
											list.add(pl[n]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
											sumOfWeights += pl[o];
											tempSumOfPackages++;
											list.add(pl[o]);
											PrintListIfReached(sumToReach, list, sumOfWeights);
											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
													&& minimalQuantumSum >= quantumWeight(list)) {
												minimalQuantumSum = quantumWeight(list);
												sumOfPackages = tempSumOfPackages;
												System.out.println(minimalQuantumSum + " " + sumOfPackages);
												break;
											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
												break;
											}
//											sumOfWeights += pl[p];
//											tempSumOfPackages++;
//											list.add(pl[p]);
//											PrintListIfReached(sumToReach, list, sumOfWeights);
//											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
//													&& minimalQuantumSum >= quantumWeight(list)) {
//												minimalQuantumSum = quantumWeight(list);
//												sumOfPackages = tempSumOfPackages;
//												System.out.println(minimalQuantumSum + " " + sumOfPackages);
//												break;
//											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
//												break;
//											}
//											sumOfWeights += pl[q];
//											tempSumOfPackages++;
//											list.add(pl[q]);
//											PrintListIfReached(sumToReach, list, sumOfWeights);
//											if (sumOfWeights == sumToReach && tempSumOfPackages <= sumOfPackages
//													&& minimalQuantumSum >= quantumWeight(list)) {
//												minimalQuantumSum = quantumWeight(list);
//												sumOfPackages = tempSumOfPackages;
//												System.out.println(minimalQuantumSum + " " + sumOfPackages);
//												break;
//											} else if (sumOfWeights > sumToReach || tempSumOfPackages > sumOfPackages) {
//												break;
//											}
										}
									}
//								}
//							}
						}
					}
				}
			}
		}
	}System.out.println("Packages "+sumOfPackages+" with quantum sum "+minimalQuantumSum);return minimalQuantumSum;

	}

	private void PrintListIfReached(int sumToReach, ArrayList<Integer> list, int sumOfWeights) {
		boolean show = false;
		if (sumToReach == sumOfWeights && show) {
			System.out.print("Sum reached with: ");
			for (Integer integ : list) {
				System.out.print(" " + integ);
			}
			System.out.println();
		}
	}

	private boolean checkConditions(ArrayList<Integer> list, int sumOfWeights, int tempSumOfPackages, int sumToReach,
			int sumOfPackages, int minimalQuantumSum) {
		// TODO Auto-generated method stub
		return false;
	}

	public int choosePackage(int[] packageList, boolean[] isAlreadyPacked, ArrayList<Integer> packageDistribution,
			int reachableSum) throws InterruptedException {
		int levelReached = 0;
		int quantumSum = Integer.MAX_VALUE;
		ArrayList<Integer> returnPackageDistribution = packageDistribution;

		int sumPackage = 0;
		while (sumPackage <= reachableSum) {

		}
		int index = (int) (Math.random() % packageList.length);

		for (index = 0; index <= packageList.length; index++) {
			System.out.println("choose " + packageList);
			ArrayList<Integer> tempPackageDistribution = packageDistribution;
			if (!checkIfExits(packageList[index], packageDistribution)) {
				int sumOfEdge = sum(packageDistribution);
				if (sumOfEdge < reachableSum) {
					int temp = choosePackage(packageList, isAlreadyPacked, tempPackageDistribution, reachableSum);
					if (temp > 0 && temp < quantumSum) {
						returnPackageDistribution = tempPackageDistribution;
						quantumSum = temp;
					}
				} else if (sumOfEdge > reachableSum) {
					return -1;
				} else if (sumOfEdge == reachableSum) {
					levelReached++;
				}
			}
			Thread.sleep(500);
		}
		return -1;
	}

	public boolean checkIfExits(int weight, ArrayList<Integer> packageDistribution) {
		boolean doesExist = false;
		for (Integer weightPackage : packageDistribution) {
			if (weight == weightPackage) {
				return true;
			}
		}
		return false;
	}

	public int sum(ArrayList<Integer> packageWeights) {
		int sum = 0;
		for (int weight : packageWeights) {
			sum += weight;
		}
		return sum;
	}

	public int sum(int[] packageWeights) {
		int sum = 0;
		for (int weight : packageWeights) {
			sum += weight;
		}
		return sum;
	}

	public long quantumWeight(ArrayList<Integer> packageWeights) {
		long sum = 1;
		for (int weight : packageWeights) {
			sum *= weight;
		}
		return sum;
	}
}}
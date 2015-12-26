package seventeen;

import java.util.ArrayList;

public class FillContainer {
	
	public class ContainerVolume{
		int volume = 0;
		int id = 0;
		
		public ContainerVolume(int volume, int id){
			this.volume = volume;
			this.id = id;
		}
		
		public boolean equals(ContainerVolume vol){
			if (vol.volume == this.volume){
				if(vol.id == this.id){
					return true;
				}
			}
			return false;
		}
	}
	
	public class ContainerFilled {
		int volumeToReach = 0;
		ArrayList<ContainerVolume> container = new ArrayList<>();

		public ContainerFilled(int volumeToReach) {
			this.volumeToReach = volumeToReach;
		}

		public boolean addContainer(ContainerVolume i) {
			if (i.volume + sumOfContainer() <= volumeToReach) {
				container.add(i);
				return true;
			}
			return false;
		}

		public int sumOfContainer() {
			int sum = 0;
			for (ContainerVolume i : container) {
				sum += i.volume;
			}
			return sum;
		}

		public boolean equals(ContainerFilled cf) {
			if (cf.container.size() == this.container.size()) {
				boolean isSame = false;
				for (ContainerVolume i : this.container) {
					boolean contained = false;
					for (ContainerVolume j : cf.container) {
						if (i.equals(j)) {
							contained = true;
						}
					}
					if (!contained) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
	}

	int[] containerList = null;

	ArrayList<ContainerFilled> arraylistcf = new ArrayList<>();
	ArrayList<ContainerVolume> startContainer = new ArrayList<>();

	public boolean calcContainer(ArrayList<ContainerVolume> container, int volumeToReach) {
		ArrayList<ContainerVolume> containerNew = new ArrayList<>(container);
		ContainerFilled cf = new ContainerFilled(volumeToReach);

		while (cf.sumOfContainer() <= volumeToReach) {
			if (cf.sumOfContainer() == volumeToReach) {
				boolean existsInArrayList = false;
				for (ContainerFilled contain : arraylistcf) {
					if (contain.equals(cf)) {
						existsInArrayList = true;
					}
				}
				if (!existsInArrayList) {
					arraylistcf.add(cf);
					System.out.print("ADD to List ");
					for(ContainerVolume i : cf.container){
						System.out.print(" "+i.volume);
					}
					System.out.println();
					return true;
				} else {
					return false;
				}
			}
			if(containerNew.isEmpty()){
				return false;
			}
			int index = (int) (Math.random() * containerNew.size());
			cf.addContainer(containerNew.get(index));
			containerNew.remove(index);
		}
		return false;
	}

	public void tryOut(int volumeReach) {
		int count = 0;
		int lastSize = 0;
		while (count < 100000) {
			calcContainer(startContainer, volumeReach);
			if (arraylistcf.size() != lastSize) {
				lastSize = arraylistcf.size();
				count = 0;
			} else {
				if(count % 100000 == 0){
					System.out.println(count);
				}
				count++;
			}
		}
		System.out.println(arraylistcf.size());
		
		int minimumContainer = 1000;
		for(ContainerFilled cf : arraylistcf){
			if(cf.container.size() < minimumContainer){
				minimumContainer = cf.container.size();
			}
		}
		int counter = 0;
		for(ContainerFilled cf : arraylistcf){
			if(cf.container.size() == minimumContainer){
				counter++;
			}
		}
		System.out.println("size "+counter);
	}

	public void Load(String[] read) {
		containerList = new int[read.length];

		int index = 0;
		int id = 0;
		for (String s : read) {
			containerList[index++] = Integer.parseInt(s);
			startContainer.add(new ContainerVolume(Integer.parseInt(s), id++));
		}
		System.out.println(startContainer.size());
	}

	int combination = 0;

	public void calc(int litre) {
		System.out.println("STart calc");
		int[] containerListTwo = containerList;

		System.out.println("calcSize " + (Math.pow(containerListTwo.length, 12)));
		// 12
		for (int i = 0; i < containerListTwo.length; i++) {// 1
			for (int j = 0; j < containerListTwo.length; j++) {// 2
				for (int k = 0; k < containerListTwo.length; k++) {// 3
					for (int l = 0; l < containerListTwo.length; l++) {// 4
						for (int m = 0; m < containerListTwo.length; m++) {// 5
							for (int n = 0; n < containerListTwo.length; n++) {// 6
								for (int o = 0; o < containerListTwo.length; o++) {// 7
									for (int p = 0; p < containerListTwo.length; p++) {// 8
										for (int q = 0; q < containerListTwo.length; q++) {// 9
											for (int r = 0; r < containerListTwo.length; r++) { // 10
												for (int s = 0; s < containerListTwo.length; s++) {// 11
													for (int t = 0; t < containerListTwo.length; t++) {// 12
														for (int u = 0; u < containerListTwo.length; u++) {// 13
															if (i != j && j != k && k != l && l != m && m != n && n != o
																	&& o != p && p != q && q != r && r != s && s != t
																	&& t != u && i != k && i != l && i != m && i != n
																	&& i != o && i != p && i != q && i != r && i != s
																	&& i != t && i != u && j != l && j != m && j != n
																	&& j != o && j != p && j != q && j != r && j != s
																	&& j != t && j != u && k != m && k != n && k != o
																	&& k != p && k != q && k != r && k != s && k != t
																	&& k != u && l != n && l != o && l != p && l != q
																	&& l != r && l != s && l != t && l != u && m != o
																	&& m != p && m != q && m != r && m != s && m != t
																	&& m != u && n != p && n != q && n != r && n != t
																	&& n != u && p != r && p != s && p != t && p != u
																	&& q != s && q != t && q != u && r != t && r != u
																	&& s != u) {
																int calc = 0;
																System.out.println("SCHECK");
																calc += containerListTwo[i];
																if (checkCalc(calc)) {
																	calc += containerListTwo[j];
																	if (checkCalc(calc)) {
																		calc += containerListTwo[k];
																		if (checkCalc(calc)) {
																			calc += containerListTwo[l];
																			if (checkCalc(calc)) {
																				calc += containerListTwo[m];
																				if (checkCalc(calc)) {
																					calc += containerListTwo[n];
																					if (checkCalc(calc)) {
																						calc += containerListTwo[o];
																						if (checkCalc(calc)) {
																							calc += containerListTwo[p];
																							if (checkCalc(calc)) {
																								calc += containerListTwo[q];
																								if (checkCalc(calc)) {
																									calc += containerListTwo[r];
																									if (checkCalc(
																											calc)) {
																										calc += containerListTwo[s];
																										if (checkCalc(
																												calc)) {
																											calc += containerListTwo[t];
																											if (checkCalc(
																													calc)) {
																												calc += containerListTwo[u];
																												checkCalc(
																														calc);
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
																	}
																}
															} else {
																if ((++count % 100000000) == 0) {
																	System.out.println(count);
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
						}
					}
				}
			}
		}
	}

	int sumOfPossibilities = 0;
	long count = 0;

	private boolean checkCalc(int calc) {
		if (calc == 150) {
			System.out.println(++sumOfPossibilities);
		}
		if (calc >= 150) {
			return false;
		} else {
			return true;
		}

	}

}

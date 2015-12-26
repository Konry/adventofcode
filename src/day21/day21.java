package day21;

import java.util.ArrayList;

public class day21 {

	static ArrayList<Weapon> weapons = new ArrayList<>();
	static ArrayList<Armor> armor = new ArrayList<>();
	static ArrayList<Ring> rings = new ArrayList<>();

	public static void main(String[] args) {
		Initialize();

		findSmallestMoney();
	}

	//148 too low
	//188 too high
	private static void findSmallestMoney() {
		int sum = 0;
		for (Weapon w : weapons) {
			for (Armor a : armor) {
				for (Ring r : rings) {
					int res = w.costs + a.costs + r.costs;
					if((w.dmg+a.dmg+r.dmg+w.armor+a.armor+r.armor) >= 10 && res > 148 ){
						System.out.println();
						System.out.println("Test:");
						System.out.println(w.name+ " "+a.name+" "+r.name + " costs"+(w.costs + a.costs + r.costs));
						System.out.println("fightResult: "+fight(100, w.dmg + a.dmg + r.dmg, w.armor + a.armor + r.armor, 100, 8, 2));
						System.out.println("sum " + (w.dmg+a.dmg+r.dmg+w.armor+a.armor+r.armor));
						
					}
					if (fight(100, w.dmg + a.dmg + r.dmg, w.armor + a.armor + r.armor, 100, 8, 2)) {
						res = w.costs + a.costs + r.costs;
						if (res > sum && (w.dmg+a.dmg+r.dmg+w.armor+a.armor+r.armor) <= 1000) {
							sum = res;
							//System.out.println("sum " + (w.dmg+a.dmg+r.dmg+w.armor+a.armor+r.armor));
							//System.out.println(w.name+ " "+a.name+" "+r.name + " "+sum);
						}
					}
				}
			}
		}
		System.out.println(sum);
	}

	private static boolean fight(int hpH, int attH, int defH, int hpB, int attB, int defB){
		int dmgToH = attB-defH;
		if(dmgToH <= 0){
			dmgToH = 1;
		}
		int dmgToB = attH-defB;
		if(dmgToB <= 0){
			dmgToB = 1;
		}
		for(int i = 0; i < 100; i++){
			hpB -= dmgToB;
			if(hpB <= 0){
				return false;
			}
			hpH -= dmgToH;
			if(hpH <= 0){
				return true;
			}
		}
		System.out.println("esle "+Math.min(hpH, hpB));
		return false;
	}

	private static void Initialize() {
		weapons.add(new Weapon("Dagger", 4, 0, 8));
		weapons.add(new Weapon("Shortsword", 5, 0, 10));
		weapons.add(new Weapon("Warhammer", 6, 0, 25));
		weapons.add(new Weapon("Longsword", 7, 0, 40));
		weapons.add(new Weapon("Greataxe", 8, 0, 74));

		armor.add(new Armor("", 0, 0, 0));
		armor.add(new Armor("Leather", 0, 1, 13));
		armor.add(new Armor("Chainmail", 0, 2, 31));
		armor.add(new Armor("Splintmail", 0, 3, 53));
		armor.add(new Armor("Bandedmail", 0, 4, 75));
		armor.add(new Armor("Platemail", 0, 5, 102));

		rings.add(new Ring("Damage +1", 1, 0, 25));
		rings.add(new Ring("Damage +2", 2, 0, 50));
		rings.add(new Ring("Damage +3", 3, 0, 100));
		rings.add(new Ring("Defense +1", 0, 1, 20));
		rings.add(new Ring("Defense +2", 0, 2, 40));
		rings.add(new Ring("Defense +3", 0, 3, 80));
		rings.add(new Ring("Damage +1 + Defense +1", 1, 1, 45));
		rings.add(new Ring("Damage +1 + Damage +2", 3, 0, 75));
		rings.add(new Ring("Defense +1 + Defense +3", 0, 4, 100));
		rings.add(new Ring("Defense +2 + Defense +3", 0, 5, 120));
		rings.add(new Ring("Defense +1 + Defense +2", 0, 3, 60));
		rings.add(new Ring("Damage +1 + Damage +3", 4, 0, 125));
		rings.add(new Ring("Damage +1 + Defense +2", 1, 2, 65));
		rings.add(new Ring("Damage +1 + Defense +3", 1, 3, 105));
		rings.add(new Ring("Damage +2 + Defense +1", 2, 1, 70));
		rings.add(new Ring("Damage +2 + Defense +2", 2, 2, 90));
		rings.add(new Ring("Damage +2 + Defense +3", 2, 3, 130));
		rings.add(new Ring("Damage +2 + Damage +3", 5, 0, 150));
		rings.add(new Ring("Damage +3 + Defense +1", 3, 1, 120));
		rings.add(new Ring("Damage +3 + Defense +2", 3, 2, 140));
		rings.add(new Ring("Damage +3 + Defense +3", 3, 3, 180));
		rings.add(new Ring("0", 0, 0, 0));
	}

	static class Weapon {
		String name;
		int dmg;
		int armor;
		int costs;

		public Weapon(String name, int dmg, int armor, int costs) {
			this.name = name;
			this.dmg = dmg;
			this.armor = armor;
			this.costs = costs;
		}
	}

	static class Armor {
		String name;
		int dmg;
		int armor;
		int costs;

		public Armor(String name, int dmg, int armor, int costs) {
			this.name = name;
			this.dmg = dmg;
			this.armor = armor;
			this.costs = costs;
		}
	}

	static class Ring {
		String name;
		int dmg;
		int armor;
		int costs;

		public Ring(String name, int dmg, int armor, int costs) {
			this.name = name;
			this.dmg = dmg;
			this.armor = armor;
			this.costs = costs;
		}
	}

}

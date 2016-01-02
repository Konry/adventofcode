package day22;

import java.util.ArrayList;

public class Day22 {

	public static void main(String[] args) {
		WizzardSimulator sim = new WizzardSimulator();
		sim.simulate();

	}

	// 974 too high
	// 907 too low
	// getFromOther
	// 953
	public static class WizzardSimulator {
		ArrayList<Spell> spells = new ArrayList<>();

		ArrayList<ArrayList<Spell>> globalSpellHistory = new ArrayList<ArrayList<Spell>>();

		public WizzardSimulator() {
			initialize();
		}

		private void initialize() {
			spells.add(new Spell("Magic Missle", 53, 0, 0, 4, 0, 0));
			spells.add(new Spell("Drain", 73, 0, 0, 2, 0, 2));
			spells.add(new Spell("Shield", 113, 6, 7, 0, 0, 0));
			spells.add(new Spell("Poison", 173, 6, 0, 3, 0, 0));
			spells.add(new Spell("Recharge", 229, 5, 0, 0, 101, 0));
		}

		public void simulate() {
			int count = 0;
			int lastChange = 1000000;

			int lastSize = 0;
			while (count < 1000000) {

				Player p = new Player(10);
				Boss b = new Boss(13);
				int manaUsage = fight(p, b, false);
				if (manaUsage > 2) {
					System.out.println(globalSpellHistory.size());
				}
				if (manaUsage > 2 && manaUsage < lastChange) {
					System.out.println("mana: " + manaUsage);
					lastChange = manaUsage;
					
				}
				if(globalSpellHistory.size() > lastSize){
					lastSize = globalSpellHistory.size();
				}
				count++;
			}
		}

		public int fight(Player player, Boss boss) {
			return fight(player, boss, false);
		}

		public int fight(Player player, Boss boss, boolean show) {
			// System.out.println();
			if (show)
				System.out.println("\nFIGHT");
			ArrayList<Spell> spellListHistory = new ArrayList<>();
			ArrayList<Spell> activeSpellList = new ArrayList<>();
			int winPlayer = -1;
			int count = 0;
			while (true) {
				count++;
				// print(activeSpellList);
				/* player turn */
				if (show)
					System.out.println("Players turn");
				winPlayer = PlayerVsBoss(player, boss, activeSpellList, spellListHistory, show);
				// System.out.println(winPlayer);
				if (winPlayer == 1) {
					if (show) {
						System.out.println();
						System.out.println("count player wins spells: " + count + " " + sumSpells(spellListHistory));
					}
					if (!existsInGlobalHistory(spellListHistory)) {
						print(spellListHistory);
						globalSpellHistory.add(spellListHistory);
					}
//					print(spellListHistory);
					return sumSpells(spellListHistory);
				} else if (winPlayer == 0) {
					if (show)
						System.out.println("count boss wins " + count);
					return -1;
				}
				/* Boss turn */
				if (show)
					System.out.println("Boss turn");
				winPlayer = BossVsPlayer(player, boss, activeSpellList, show);
				if (winPlayer == 1) {
					if (show) {
						System.out.println();
						System.out.println("count player wins spells: " + count + " " + sumSpells(spellListHistory));
					}
					if (!existsInGlobalHistory(spellListHistory)) {
						print(spellListHistory);
						globalSpellHistory.add(spellListHistory);
					}
//					print(spellListHistory);
					return sumSpells(spellListHistory);
				} else if (winPlayer == 0) {
					if (show)
						System.out.println("count boss wins " + count);
					return -1;
				}
				// System.out.println("count "+count);
				// return -1;
			}
		}

		private boolean existsInGlobalHistory(ArrayList<Spell> spellListHistory) {
			boolean exists = false;
			for (ArrayList<Spell> spellHistory : globalSpellHistory) {
				if (spellHistory.size() == spellListHistory.size()) {
					boolean equal = true;
					for (int i = 0; i < spellHistory.size(); i++) {
						if (!spellHistory.get(i).equals(spellListHistory.get(i))) {
							equal = false;
						}
					}
					if (equal) {
						exists = true;
						return true;
					}
				}
			}
			return exists;
		}

		private void print(ArrayList<Spell> activeSpellList) {
			for (Spell s : activeSpellList) {
				System.out.print(s.name + " ");
			}
			System.out.println();
		}

		private int sumSpells(ArrayList<Spell> spellListHistory) {
			int sum = 0;
			for (Spell s : spellListHistory) {
				sum += s.manaCosts;
			}
			if (sum == 953) {
				System.out.print(sum + " ");
				for (Spell s : spellListHistory) {
					System.out.print(" " + s.name);
				}
				System.out.println();
			}
			return sum;
		}

		private int BossVsPlayer(Player player, Boss boss, ArrayList<Spell> spelllist, boolean show) {
			// do spells
			handleSpell(player, boss, spelllist, show);
			int ret = checkHP(player, boss);
			if (ret >= 0) {
				return ret;
			}

			// Attack
			if (boss.damage - player.armor < 1) {
				player.hp -= 1;
			} else {
				player.hp -= (boss.damage - player.armor);
			}
			ret = checkHP(player, boss);
			if (ret >= 0) {
				return ret;
			}
			return ret;
		}

		private void handleSpell(Player player, Boss boss, ArrayList<Spell> spelllist, boolean show) {
			ArrayList<Spell> deleteSpells = new ArrayList<>();
			if (show) {
				System.out.print("Before PlayerStats " + player.hp + " - ");
				System.out.println("BossStats " + boss.hp);
			}
			for (int index = 0; index < spelllist.size(); index++) {
				if (show)
					System.out.println("Spell " + spelllist.get(index).name + " " + spelllist.get(index).lastTurns + " "
							+ spelllist.get(index).spellTimer);
				boss.hp -= spelllist.get(index).damageDecrease;
				player.mana += spelllist.get(index).manaIncrease;
				player.hp += spelllist.get(index).hpIncrease;
				player.armor = spelllist.get(index).armorIncrease;
				spelllist.get(index).spellTimer--;
				if (spelllist.get(index).spellTimer == 0) {
					deleteSpells.add(spelllist.get(index));
				}
			}
			for (Spell s : deleteSpells) {
				if (s.name.equals("Shield")) {
					player.armor = 0;
				}
				spelllist.remove(s);
			}
			if (show) {
				System.out.print("After PlayerStats " + player.hp + " - ");
				System.out.println("BossStats " + boss.hp);
			}
		}

		private int PlayerVsBoss(Player player, Boss boss, ArrayList<Spell> activeSpells,
				ArrayList<Spell> spelllistHistory, boolean show) {
			handleSpell(player, boss, activeSpells, show);

			// cast spell
			ArrayList<Spell> chooseableSpells = new ArrayList<>();
			for (Spell s : spells) {
				boolean exists = false;
				for (Spell active : activeSpells) {
					if (active.equals(s)) {
						// System.out.println("Active "+active.name);
						exists = true;
					}
				}
				if (!exists) {
					chooseableSpells.add(s);
				}
			}

			int spellIndexToCast = (int) (Math.random() * chooseableSpells.size());
			Spell spell = chooseableSpells.get(spellIndexToCast);
			if (show) {
				System.out.println("player cast " + spell.name + " ");
			}
			switch (spell.name) {
			case "Magic Missle":
				boss.hp -= spell.damageDecrease;
				break;
			case "Drain":
				boss.hp -= spell.damageDecrease;
				player.hp += spell.hpIncrease;
				break;
			default:
				spell.spellTimer = spell.lastTurns;
				activeSpells.add(spell);
				break;
			}
			spelllistHistory.add(chooseableSpells.get(spellIndexToCast));

			int ret = checkHP(player, boss);
			// System.out.println(player.hp+ " "+boss.hp);
			if (ret >= 0) {
				return ret;
			}
			return ret;
		}

		private int checkHP(Player player, Boss boss) {
			if (boss.hp <= 0) {
				return 1;
			} else if (player.hp <= 0) {
				return 0;
			} else {
				return -1;
			}
		}

		// private boolean checkSpells(ArrayList<Spell> spellList){
		//// for(int i = 0; i < )
		// }
	}

	public static class Player {
		int hp = 50;
		int mana = 500;
		int dmg = 0;
		int armor = 0;

		public Player() {

		}

		public Player(int hp) {
			this.hp = hp;
		}
	}

	public static class Boss {
		int hp = 55;
		int damage = 8;
		int armor = 0;

		public Boss() {

		}

		public Boss(int hp) {
			this.hp = hp;
		}
	}

	public static class Spell {
		String name;
		int manaCosts = 0;
		int lastTurns = 0;
		int armorIncrease = 0;
		int damageDecrease = 0;
		int manaIncrease = 0;
		int spellTimer = lastTurns;
		int hpIncrease = 0;

		public Spell(String name, int manaCosts, int lastTurns, int armorIncrease, int damageIncrease, int manaIncrease,
				int hpIncrease) {
			this.name = name;
			this.manaCosts = manaCosts;
			this.lastTurns = lastTurns;
			this.armorIncrease = armorIncrease;
			this.damageDecrease = damageIncrease;
			this.manaIncrease = manaIncrease;
			this.hpIncrease = hpIncrease;
		}

		public boolean equals(Spell s) {
			if (this.name.equals(s.name) && this.lastTurns == s.lastTurns && this.manaCosts == s.manaCosts
					&& this.armorIncrease == s.armorIncrease && this.damageDecrease == s.damageDecrease) {
				return true;
			} else {
				return false;
			}
		}
	}
}

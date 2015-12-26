package day22;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	// 974 too high
	// 907 too low
	// getFromOther
	// 953
	public static class WizzardSimulator {

		public boolean fight(Player player, Boss boss) {
			ArrayList<Spell> spellList = new ArrayList<>();
			int winPlayer = -1;
			while (true) {
				/* player turn */
				winPlayer = PlayerVsBoss(player, boss, spellList);
				if (winPlayer == 1) {
					return true;
				} else if (winPlayer == 0) {
					return false;
				}
				/* Boss turn */
				winPlayer = BossVsPlayer(player, boss, spellList);
				if (winPlayer == 1) {
					return true;
				} else if (winPlayer == 0) {
					return false;
				}

				return false;
			}
		}

		private int BossVsPlayer(Player player, Boss boss, ArrayList<Spell> spelllist) {
			// do spells
			ArrayList<Spell> deleteSpells = new ArrayList<>();
			for (int index = 0; index < spelllist.size(); index++) {
				boss.hp -= spelllist.get(index).damageDecrease;
				player.mana += spelllist.get(index).manaIncrease;
				spelllist.get(index).spellTimer--;
				if (spelllist.get(index).spellTimer == 0) {
					deleteSpells.add(spelllist.get(index));
				}
			}
			for (Spell s : deleteSpells) {
				spelllist.remove(s);
			}
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

		private int PlayerVsBoss(Player player, Boss boss, ArrayList<Spell> spelllist) {
			// do spells
			ArrayList<Spell> deleteSpells = new ArrayList<>();
			for (int index = 0; index < spelllist.size(); index++) {
				boss.hp -= spelllist.get(index).damageDecrease;
				player.mana += spelllist.get(index).manaIncrease;
				spelllist.get(index).spellTimer--;
				if (spelllist.get(index).spellTimer == 0) {
					deleteSpells.add(spelllist.get(index));
				}
			}
			for (Spell s : deleteSpells) {
				spelllist.remove(s);
			}
			// int ret = checkHP(player, boss);
			// if(ret >= 0){
			// return ret;
			// }
			// Attack
			if (boss.damage - player.armor < 1) {
				player.hp -= 1;
			} else {
				player.hp -= (boss.damage - player.armor);
			}
			int ret = checkHP(player, boss);
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
	}

	public class Player {
		int hp = 50;
		int mana = 500;
		int dmg = 0;
		int armor = 0;

		public Player() {

		}
	}

	public class Boss {
		int hp = 55;
		int damage = 8;
		int armor = 0;

		public Boss() {

		}
	}

	public class Spell {
		String name;
		int manaCosts = 0;
		int lastTurns = 0;
		int armorIncrease = 0;
		int damageDecrease = 0;
		int manaIncrease = 0;
		int spellTimer = lastTurns;

		public Spell(String name, int manaCosts, int lastTurns, int armorIncrease, int damageIncrease,
				int manaIncrease) {
			this.name = name;
			this.manaCosts = manaCosts;
			this.lastTurns = lastTurns;
			this.armorIncrease = armorIncrease;
			this.damageDecrease = damageIncrease;
			this.manaIncrease = manaIncrease;
		}
	}
}

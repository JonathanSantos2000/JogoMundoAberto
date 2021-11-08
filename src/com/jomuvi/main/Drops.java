package com.jomuvi.main;

import java.util.Random;

import com.jomuvi.entities.Player;

public class Drops {
	public static int coinsGold = 0, coinsSilver = 0, coinsBronze = 100;
	public static int coinsBase = 100;

	public static void VerificarNivelXP() {
		if (Game.player.maxXp <= 10000) {
			Game.player.maxXp += 1000;
			Game.player.maxLife += 50;
			Game.player.life = Game.player.maxLife;
			Player.dano += 5;
			Game.player.nivel++;

		} else if (Game.player.maxXp <= 100000) {
			Game.player.maxXp += 10000;
		} else if (Game.player.maxXp <= 1000000) {
			Game.player.maxXp += 100000;
		} else if (Game.player.maxXp <= 10000000) {
			Game.player.maxXp += 1000000;
		} else if (Game.player.maxXp > 10000000) {
			Game.player.xp = 10000000;
			Game.player.maxXp = 10000000;
		}

	}

	public void xpGaing(int xpEnemy) {
		if (Game.player.xp < Game.player.maxXp) {
			Game.player.xp += xpEnemy;
		} else {
			VerificarNivelXP();
		}
	}

	public void CoinsGaing(int idEnemy) {
		Random dropCoins = new Random();
		int chanceDropCoins = dropCoins.nextInt(15);
		if (chanceDropCoins < 5) {
			coinsBronze += 50;
			coinsBase += 50;
		} else if (chanceDropCoins < 10) {
			coinsBronze += 60;
			coinsBase += 60;
		} else if (chanceDropCoins < 15) {
			coinsBronze += 70;
			coinsBase += 70;
		}
	}

	public void Drop(int xpEnemy, int idEnemy) {
		CoinsGaing(idEnemy);
		xpGaing(xpEnemy);
	}
}

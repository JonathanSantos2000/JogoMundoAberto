package com.jomuvi.world;

import com.jomuvi.entities.Entity;
import com.jomuvi.entities.enemies.Enemy01;
import com.jomuvi.entities.enemies.Enemy02;
import com.jomuvi.entities.enemies.Enemy03;
import com.jomuvi.entities.enemies.Enemy04;
import com.jomuvi.entities.enemies.Enemy05;
import com.jomuvi.entities.enemies.Enemy06;
import com.jomuvi.entities.enemies.Enemy07;
import com.jomuvi.entities.enemies.Enemy08;
import com.jomuvi.entities.enemies.Enemy09;
import com.jomuvi.entities.enemies.Enemy10;
import com.jomuvi.main.Game;

public class ZombieCreator {

	public static int[] RespawEnemies = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	public static void RespawMp(String posicao) {
		if (!posicao.equals("0")) {
			for (int i = 0; i < RespawEnemies.length; i++) {
				RespawEnemies[i] = 0;
			}
			for (int i = 0; i < RespawEnemies.length; i++) {
				if (RespawEnemies[i] == 0 && i == Integer.parseInt(posicao)) {
					RespawEnemies[i] = 1;
					break;
				}

			}
		}
	}

	public void tick() {
		if (RespawEnemies[1] == 1) {
			if (Game.enemies01.size() == 0) {
				Game.enemies01.clear();
				for (int i = 0; i < 22; i++) {
					String typ;
					int Aleatorio = Game.rand.nextInt(100);
					if (Aleatorio < 30) {
						typ = "fire";
					} else {
						typ = "normal";
					}
					Enemy01 en = new Enemy01(World.xEnemies01[i] * 16, World.yEnemies01[i] * 16, 16, 16,
							Entity.ENEMY_EN, typ);
					Game.entities.add(en);
					Game.enemies01.add(en);
				}
			}
		}
		if (RespawEnemies[2] == 1) {
			if (Game.enemies02.size() == 0) {
				Game.enemies02.clear();
				for (int i = 0; i < 22; i++) {
					Enemy02 en = new Enemy02(World.xEnemies02[i] * 16, World.yEnemies02[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies02.add(en);
				}
			}
		}
		if (RespawEnemies[3] == 1) {
			if (Game.enemies03.size() == 0) {
				Game.enemies03.clear();
				for (int i = 0; i < 22; i++) {
					Enemy03 en = new Enemy03(World.xEnemies03[i] * 16, World.yEnemies03[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies03.add(en);
				}
			}
		}
		if (RespawEnemies[4] == 1) {
			if (Game.enemies04.size() == 0) {
				Game.enemies04.clear();
				for (int i = 0; i < 22; i++) {
					Enemy04 en = new Enemy04(World.xEnemies04[i] * 16, World.yEnemies04[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies04.add(en);

				}

			}
		}
		if (RespawEnemies[5] == 1) {
			if (Game.enemies05.size() == 0) {
				Game.enemies05.clear();
				for (int i = 0; i < 22; i++) {
					Enemy05 en = new Enemy05(World.xEnemies05[i] * 16, World.yEnemies05[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies05.add(en);
				}
			}
		}
		if (RespawEnemies[6] == 1) {
			if (Game.enemies06.size() == 0) {
				Game.enemies06.clear();
				for (int i = 0; i < 22; i++) {
					Enemy06 en = new Enemy06(World.xEnemies06[i] * 16, World.yEnemies06[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies06.add(en);
				}
			}
		}
		if (RespawEnemies[7] == 1) {
			if (Game.enemies07.size() == 0) {
				Game.enemies07.clear();
				for (int i = 0; i < 22; i++) {
					Enemy07 en = new Enemy07(World.xEnemies07[i] * 16, World.yEnemies07[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies07.add(en);

				}

			}
		}
		if (RespawEnemies[8] == 1) {
			if (Game.enemies08.size() == 0) {
				Game.enemies08.clear();
				for (int i = 0; i < 22; i++) {
					Enemy08 en = new Enemy08(World.xEnemies08[i] * 16, World.yEnemies08[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies08.add(en);
				}
			}
		}
		if (RespawEnemies[9] == 1) {
			if (Game.enemies09.size() == 0) {
				Game.enemies09.clear();
				for (int i = 0; i < 22; i++) {
					Enemy09 en = new Enemy09(World.xEnemies09[i] * 16, World.yEnemies09[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies09.add(en);

				}

			}
		}
		if (RespawEnemies[10] == 1) {
			if (Game.enemies10.size() == 0) {
				Game.enemies10.clear();
				for (int i = 0; i < 22; i++) {
					Enemy10 en = new Enemy10(World.xEnemies10[i] * 16, World.yEnemies10[i] * 16, 16, 16,
							Entity.ENEMY_EN);
					Game.entities.add(en);
					Game.enemies10.add(en);
				}
			}
		}
	}
}

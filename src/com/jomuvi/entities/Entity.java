package com.jomuvi.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

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
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;

public class Entity {
	// Spritesheet
	// ITENS
	public static BufferedImage LIFEPACK_EN = Game.spritesheetItens.getSprite(0, 0, 16, 16);
	public static BufferedImage BULLET_EN = Game.spritesheetItens.getSprite(0, 16, 16, 16);
	public static BufferedImage CHEST = Game.spritesheetBlocos.getSprite(00 * 00, 03 * 16, 32, 32);
//portal
	public static BufferedImage Portal = Game.spritesheetBlocosPonte.getSprite(7 * 16, 0, 16, 16);
//placas mapa 1 - 10 
	public static BufferedImage placa = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 2 * 16, 32, 16);
//	Lojas
	public static BufferedImage DrugStore = Game.spritesheetImoveis.getSprite(0, 0, 4 * 16, 3 * 16);
	public static BufferedImage GunsStore = Game.spritesheetImoveis.getSprite(0, 3 * 16, 4 * 16, 3 * 16);
	public static BufferedImage StyleStore = Game.spritesheetImoveis.getSprite(00 * 00, 06 * 16, 4 * 16, 3 * 16);
	public static BufferedImage SalonStore = Game.spritesheetImoveis.getSprite(04 * 16, 03 * 16, 4 * 16, 3 * 16);
	public static BufferedImage inn = Game.spritesheetImoveis.getSprite(04 * 16, 06 * 16, 4 * 16, 3 * 16);
	public static BufferedImage Ship = Game.spritesheetImoveisFastRavel.getSprite(0, 0, 5 * 16, 4 * 16);

//	----
	// ENEMY
	public static BufferedImage ENEMY_EN = Game.spritesheetMobs.getSprite(2 * 16, 0 * 16, 16, 16);

	public static BufferedImage BossOrk = Game.spritesheetBossOrk.getSprite(0, 0, 32, 32);
	public static BufferedImage BossLisard = Game.spritesheetBossLisard.getSprite(0, 0, 32, 32);
	public static BufferedImage BossSlime = Game.spritesheetBossSlime.getSprite(0, 0, 32, 32);

	public static BufferedImage ENEMY_DM_EN = Game.spritesheetMobs.getSprite(0, 16, 16, 16);
	public static BufferedImage BOSS_ORK_DM_EN = Game.spritesheetBossOrk.getSprite(6 * 16, 0, 32, 32);
	// GUNS
	// GUNS Damage Normal
	public static BufferedImage SPEAR_RIGTH_EN = Game.spritesheetBossOrk.getSprite(0, 9 * 16, 48, 16);
	public static BufferedImage SPEAR_LEFT_EN = Game.spritesheetBossOrk.getSprite(0, 8 * 16, 48, 16);
	public static BufferedImage SPEAR_RIGTH_DM_EN = Game.spritesheetBossOrk.getSprite(01 * 16, 0, 16, 16);

	public static BufferedImage GUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(0, 16, 16, 16);
	public static BufferedImage GUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(16, 16, 16, 16);
	public static BufferedImage BOW_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(2 * 16, 16, 16, 16);
	public static BufferedImage BOW_LEFT_DM_EN = Game.spritesheetGuns.getSprite(3 * 16, 16, 16, 16);
	public static BufferedImage M4A4_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(4 * 16, 16, 16, 16);
	public static BufferedImage M4A4_LEFT_DM_EN = Game.spritesheetGuns.getSprite(5 * 16, 16, 16, 16);
	public static BufferedImage AK47_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(6 * 16, 16, 16, 16);
	public static BufferedImage AK47_LEFT_DM_EN = Game.spritesheetGuns.getSprite(7 * 16, 16, 16, 16);
	public static BufferedImage SHOTGUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(8 * 16, 16, 16, 16);
	public static BufferedImage SHOTGUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(9 * 16, 16, 16, 16);

	// GUNS Damage Poison
	public static BufferedImage POISON_GUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(0, 2 * 16, 16, 16);
	public static BufferedImage POISON_GUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(16, 2 * 16, 16, 16);
	public static BufferedImage POISON_BOW_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(2 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_BOW_LEFT_DM_EN = Game.spritesheetGuns.getSprite(3 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_M4A4_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(4 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_M4A4_LEFT_DM_EN = Game.spritesheetGuns.getSprite(5 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_AK47_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(6 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_AK47_LEFT_DM_EN = Game.spritesheetGuns.getSprite(7 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_SHOTGUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(8 * 16, 2 * 16, 16, 16);
	public static BufferedImage POISON_SHOTGUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(9 * 16, 2 * 16, 16, 16);

	// GUNS Damage Burn
	public static BufferedImage BURN_GUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(0, 3 * 16, 16, 16);
	public static BufferedImage BURN_GUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(16, 3 * 16, 16, 16);
	public static BufferedImage BURN_BOW_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(2 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_BOW_LEFT_DM_EN = Game.spritesheetGuns.getSprite(3 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_M4A4_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(4 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_M4A4_LEFT_DM_EN = Game.spritesheetGuns.getSprite(5 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_AK47_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(6 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_AK47_LEFT_DM_EN = Game.spritesheetGuns.getSprite(7 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_SHOTGUN_RIGTH_DM_EN = Game.spritesheetGuns.getSprite(8 * 16, 3 * 16, 16, 16);
	public static BufferedImage BURN_SHOTGUN_LEFT_DM_EN = Game.spritesheetGuns.getSprite(9 * 16, 3 * 16, 16, 16);

	// Bot
	public static BufferedImage BOT_RIGTH_EN = Game.spritesheetGuns.getSprite(0, 4 * 16, 16, 16);
	public static BufferedImage BOT_LEFT_EN = Game.spritesheetGuns.getSprite(0, 5 * 16, 16, 16);
	// NPC
	public static BufferedImage NPCGuarda = Game.spritesheetNPC.getSprite(00 * 00, 00 * 00, 16, 16);
	public static BufferedImage NPCMarine = Game.spritesheetNPC.getSprite(8 * 16, 00 * 00, 16, 16);

	public static BufferedImage NPCMedico = Game.spritesheetNPC.getSprite(04 * 16, 00 * 00, 16, 16);
	public static BufferedImage NPCArmer = Game.spritesheetNPC.getSprite(03 * 16, 00 * 00, 16, 16);
	public static BufferedImage NPCStyler = Game.spritesheetNPC.getSprite(05 * 16, 00 * 00, 16, 16);
	public static BufferedImage NPCInn = Game.spritesheetNPC.getSprite(06 * 16, 00 * 00, 16, 16);// hotel
	public static BufferedImage NPCHairStyle = Game.spritesheetNPC.getSprite(03 * 16, 00 * 00, 16, 16);// hotel
	// Fim Spritesheet

	protected double x;
	protected double y;
	protected int width;
	protected int height;
	public static int DropItemZombie = 0;

	private BufferedImage sprite;

	public int maskx, masky, mwidth, mheight;

//	Enemy variaveis
	protected int framesShowLife = 0, maxFramesShowLife = 100;

	protected boolean ShowLife;

	public void delayShowLife() {
		framesShowLife++;
		if (framesShowLife == maxFramesShowLife) {
			framesShowLife = 0;
			ShowLife = false;
		}
	}

	public Entity(int x, int y, int width, int height, BufferedImage sprite) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = sprite;

		this.maskx = 0;
		this.masky = 0;
		this.mwidth = width;
		this.mheight = height;

	}

	public void setMask(int maskx, int masky, int mwidth, int mheight) {
		this.maskx = maskx;
		this.masky = masky;
		this.mwidth = mwidth;
		this.mheight = mheight;
	}

	public void setX(int newX) {
		this.x = newX;
	}

	public void setY(int newY) {
		this.y = newY;
	}

	public int getX() {
		return (int) this.x;
	}

	public int getY() {
		return (int) this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public void tick() {
	}

	public double calculeteDistance(int x1, int x2, int y1, int y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}

	public boolean isColiddingWithPlayer() {
		Rectangle enemyCurrent = new Rectangle(this.getX(), this.getY(), World.TILE_SIZE, World.TILE_SIZE);
		Rectangle player = new Rectangle(Game.player.getX(), Game.player.getY(), 16, 16);
		return enemyCurrent.intersects(player);
	}

	public void isPoison(int id) {
		int Aleatorio = Game.rand.nextInt(100);
		if (Aleatorio < 35) {
			Game.ui.poison = true;

		}
	}

	public void isBurn(int id) {
		if (Game.rand.nextInt(100) < 20) {
			Game.ui.burn = true;
		}
	}

	public static boolean isColiding(Entity e1, Entity e2) {
		Rectangle e1Mask = new Rectangle(e1.getX() + e1.maskx, e1.getY() + e1.masky, e1.mwidth, e1.mheight);
		Rectangle e2Mask = new Rectangle(e2.getX() + e2.maskx, e2.getY() + e2.masky, e2.mwidth, e2.mheight);

		return e1Mask.intersects(e2Mask);
	}

	public void render(Graphics g) {
		g.drawImage(sprite, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}

	public boolean isColiddingEnemies1(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies01.size(); i++) {
			Enemy01 e = Game.enemies01.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies2(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies02.size(); i++) {
			Enemy02 e = Game.enemies02.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies3(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies03.size(); i++) {
			Enemy03 e = Game.enemies03.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies4(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies04.size(); i++) {
			Enemy04 e = Game.enemies04.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies5(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies05.size(); i++) {
			Enemy05 e = Game.enemies05.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies6(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies06.size(); i++) {
			Enemy06 e = Game.enemies06.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies7(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies07.size(); i++) {
			Enemy07 e = Game.enemies07.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies8(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies08.size(); i++) {
			Enemy08 e = Game.enemies08.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies9(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies09.size(); i++) {
			Enemy09 e = Game.enemies09.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

	public boolean isColiddingEnemies10(int xnext, int ynext) {
		Rectangle enemyCurrent = new Rectangle(xnext + maskx, ynext + masky, mwidth, mheight);
		for (int i = 0; i < Game.enemies10.size(); i++) {
			Enemy10 e = Game.enemies10.get(i);
			if (e == this)
				continue;
			Rectangle targetEnemy = new Rectangle(e.getX() + maskx, e.getY() + masky, mwidth, mheight);
			if (enemyCurrent.intersects(targetEnemy)) {
				return true;
			}
		}
		return false;
	}

}

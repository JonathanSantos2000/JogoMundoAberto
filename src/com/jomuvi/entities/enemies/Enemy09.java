package com.jomuvi.entities.enemies;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.entities.Player;
import com.jomuvi.main.Game;
//import com.jomuvi.main.Sound;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;

public class Enemy09 extends Entity {

	private double speed = 0.6;
	private int frames = 0, maxFrames = 20, index = 0, maxIndex = 3;

	public int right_dir = 0, left_dir = 1;
	public int dir = right_dir;
	private boolean moved = false;
	private BufferedImage[] rightEnemy;
	private BufferedImage[] leftEnemy;
	public static boolean voltarInicial = false;
	public boolean isDamaged = false;
	private int damagedFremes = 0;
	private int life = 100, xpEnemy = 250, idEnemy = 9, Damaged = 20;

	public Enemy09(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, null);

		rightEnemy = new BufferedImage[4];
		leftEnemy = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			rightEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 0, 16, 16);
		}
		for (int i = 0; i < 4; i++) {
			leftEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 16, 16, 16);
		}
	}

	public void tick() {
		if ((calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 60 || life < 100)) {

			if (!this.isColiddingWithPlayer()) {
				if ((int) x < Game.player.getX() && World.isfree((int) (x + speed), this.getY())
						&& !isColiddingEnemies9((int) (x + speed), this.getY())) {
					moved = true;
					dir = right_dir;
					x += speed;
				} else if ((int) x > Game.player.getX() && World.isfree((int) (x - speed), this.getY())
						&& !isColiddingEnemies9((int) (x - speed), this.getY())) {
					moved = true;
					dir = left_dir;
					x -= speed;
				}
				if ((int) y < Game.player.getY() && World.isfree(this.getX(), (int) (y + speed))
						&& !isColiddingEnemies9(this.getX(), (int) (y + speed))) {
					moved = true;
					y += speed;
				} else if ((int) y > Game.player.getY() && World.isfree(this.getX(), (int) (y - speed))
						&& !isColiddingEnemies9(this.getX(), (int) (y - speed))) {
					moved = true;
					y -= speed;
				}
			} else {
				if (Game.rand.nextInt(100) < 10) {
//				Sound.hurtEffect.play();
					Game.player.isDamaged = true;
					Game.player.life -= Damaged;
				}

			}

		}

		if (moved)

		{
			frames++;
			if (frames == maxFrames) {
				frames = 0;
				index++;
				if (index > maxIndex) {
					index = 0;
				}
			}
		}

		if (isDamaged) {
			this.damagedFremes++;
			if (this.damagedFremes == 8) {
				isDamaged = false;
				damagedFremes = 0;
			}
		}

		ColiddingBullet();
		if (life <= 0)	{
			destroySelf();
		Game.drop.Drop(getXpEnemy(), getIdEnemy());
			return;
		}

	}

	public void destroySelf() {
		Game.enemies09.remove(this);
		Game.entities.remove(this);
	}

	public void ColiddingBullet() {
		for (int i = 0; i < Game.Bullets.size(); i++) {
			Entity e = Game.Bullets.get(i);
			if (Entity.isColiding(this, e)) {
				life -= Player.dano;
				isDamaged = true;
				Game.Bullets.remove(i);
				return;
			}
		}
	}

	public void render(Graphics g) {
		if (!isDamaged) {
			if (dir == right_dir) {
				g.drawImage(rightEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			} else if (dir == left_dir) {
				g.drawImage(leftEnemy[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			}
		} else {
			g.drawImage(ENEMY_DM_EN, this.getX() - Camera.x, this.getY() - Camera.y, null);
		}
	}
	public int getXpEnemy() {
		return xpEnemy;
	}

	public void setXpEnemy(int xpEnemy) {
		this.xpEnemy = xpEnemy;
	}

	public int getIdEnemy() {
		return idEnemy;
	}

	public void setIdEnemy(int idEnemy) {
		this.idEnemy = idEnemy;
	}
}

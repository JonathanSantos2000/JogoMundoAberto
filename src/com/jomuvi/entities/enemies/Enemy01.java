package com.jomuvi.entities.enemies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.entities.Player;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;

public class Enemy01 extends Entity {

	private double speed = 0.6;
	private int frames = 0, maxFrames = 20, index = 0, maxIndex = 3;
	public int right_dir = 0, left_dir = 1;
	public int dir = right_dir;
	private String EnemyType;
	private boolean moved = false;
	private BufferedImage[] rightEnemy;
	private BufferedImage[] leftEnemy;
	public boolean isDamaged = false;
	private int damagedFremes = 0;
	private int life = 100, maxLife = 100, xpEnemy = 25, idEnemy = 1, Damaged = 1;

	public Enemy01(int x, int y, int width, int height, BufferedImage sprite, String EnemyType) {
		super(x, y, width, height, null);

		rightEnemy = new BufferedImage[4];
		leftEnemy = new BufferedImage[4];
		this.EnemyType = EnemyType;
		if (this.EnemyType == "normal") {
			for (int i = 0; i < 4; i++) {
				rightEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 0, 16, 16);
			}
			for (int i = 0; i < 4; i++) {
				leftEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 16, 16, 16);
			}
		} else if (this.EnemyType == "fire") {
			for (int i = 0; i < 4; i++) {
				rightEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 2 * 16, 16, 16);
			}
			for (int i = 0; i < 4; i++) {
				leftEnemy[i] = Game.spritesheetMobs.getSprite(32 + (i * 16), 3 * 16, 16, 16);
			}
		}
	}

	public void tick() {
		if ((calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) < 60
				|| life < maxLife)) {
			if (!this.isColiddingWithPlayer()) {
				if ((int) x < Game.player.getX() && World.isfree((int) (x + speed), this.getY())
						&& !isColiddingEnemies1((int) (x + speed), this.getY())) {
					moved = true;
					dir = right_dir;
					x += speed;
				} else if ((int) x > Game.player.getX() && World.isfree((int) (x - speed), this.getY())
						&& !isColiddingEnemies1((int) (x - speed), this.getY())) {
					moved = true;
					dir = left_dir;
					x -= speed;
				}
				if ((int) y < Game.player.getY() && World.isfree(this.getX(), (int) (y + speed))
						&& !isColiddingEnemies1(this.getX(), (int) (y + speed))) {
					moved = true;
					y += speed;
				} else if ((int) y > Game.player.getY() && World.isfree(this.getX(), (int) (y - speed))
						&& !isColiddingEnemies1(this.getX(), (int) (y - speed))) {
					moved = true;
					y -= speed;
				}
			} else {
				if (Game.rand.nextInt(100) < 10) {
					if (this.EnemyType == "fire") {
						isBurn(idEnemy);
					}else {
						isPoison(idEnemy);	
					}
//					Sound.hurtEffect.play();
					Game.player.isDamaged = true;
					Game.player.life -= Damaged;
				}

			}
		} else {

		}

		if (moved) {
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
				ShowLife = true;
				damagedFremes = 0;
			}
		}
		delayShowLife();
		ColiddingBullet();
		if (life <= 0) {
			destroySelf();
			Game.drop.Drop(xpEnemy, idEnemy);
			return;
		}

	}

	public void destroySelf() {
		Game.enemies01.remove(this);
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
		if (ShowLife) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0, 0, 0, 50));
			g.fillRect((Game.WIDTH / 2) - 38, 3, (int) Game.WIDTH / 3 - 41, (Game.HEIGHT / 2) - 115);
			g.setColor(Color.RED);
			g.fillRect((Game.WIDTH / 2) - 38, 15, (int) Game.WIDTH / 3 - 41, (Game.HEIGHT / 2) - 120);
			g.setColor(Color.green);
			g.fillRect((Game.WIDTH / 2) - 38, 15, (int) ((life / Game.player.maxLife) * 70), (Game.HEIGHT / 2) - 120);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.drawString("Zombie level 1 ", (Game.WIDTH / 2) - 38, 12);
			g.drawString("HP " + life + " / " + maxLife, (Game.WIDTH / 2) - 38, 24);
		}

	}

	public int getXpEnemy() {
		return xpEnemy;
	}

	public void setXpEnemy(int xpEnemy) {
		this.xpEnemy = xpEnemy;
	}
}

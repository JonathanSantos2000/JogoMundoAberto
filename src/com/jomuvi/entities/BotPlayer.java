package com.jomuvi.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.graficos.ItensArmer;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;

public class BotPlayer extends Entity {
	public int right_dir = 0, left_dir = 1;
	public int dir = left_dir;
	public double speed = 1;

	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	public boolean moved = false;
	public boolean shootBot = false;

	private BufferedImage[] botRight;
	private BufferedImage[] botLeft;

	public int dano = 0;
	public static boolean arma = true;
	public static boolean shoot = false;
	public static double spdGunBot;
	public static int lifeBulletBot;

	public BotPlayer(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		botRight = new BufferedImage[4];
		botLeft = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			botRight[i] = Game.spritesheetGuns.getSprite((i * 16), 4 * 16, 16, 16);
		}
		for (int i = 0; i < 4; i++) {
			botLeft[i] = Game.spritesheetGuns.getSprite((i * 16), 5 * 16, 16, 16);
		}
	}

	public void tick() {
		moved = false;
		if ((calculeteDistance(this.getX(), Game.player.getX(), this.getY(), Game.player.getY()) > 30)) {
			if ((int) x < Game.player.getX() && World.isfree((int) (x + speed), this.getY())) {
				moved = true;
				dir = right_dir;
				x += speed;
			} else if ((int) x > Game.player.getX() && World.isfree((int) (x - speed), this.getY())
					&& !isColiddingEnemies1((int) (x - speed), this.getY())) {
				moved = true;
				dir = left_dir;
				x -= speed;
			}
			if ((int) y < Game.player.getY() && World.isfree(this.getX(), (int) (y + speed))) {
				moved = true;
				y += speed;
			} else if ((int) y > Game.player.getY() && World.isfree(this.getX(), (int) (y - speed))) {
				moved = true;
				y -= speed;
			}
			System.out.println("x " + x);
			System.out.println("y " + y);
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
		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT / 2), 0, World.HEIGHT * 16 - Game.HEIGHT);

		if (shoot) {
			System.out.println("opa");
			shoot = false;
			if (arma) {
//					Sound.shootEffect.play();
				int dx = 0;
				int px = 0;
				int py = 6;
				if (dir == right_dir) {
					px = 22;
					dx = 1;
				} else if (dir == left_dir) {
					px = -9;
					dx = -1;
				}
				BulletShoot bulletShoot = new BulletShoot(this.getX() + px, this.getY() + py, 3, 3, null, dx, 0);
				Game.Bullets.add(bulletShoot);
			}
		}
	}

	public void render(Graphics g) {
		if (dir == right_dir) {
			g.drawImage(botRight[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			if (Player.arma) {
				if (Game.inven.armaEquipada == "pistol") {
					g.drawImage(ItensArmer.Pistol_RIGTH_EN, this.getX() + 8 - Camera.x, this.getY() - Camera.y, null);
				} else if (Game.inven.armaEquipada == "bow") {
					g.drawImage(ItensArmer.bow_RIGTH_EN, this.getX() + 1 - Camera.x, this.getY() + 2 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "m4a4") {
					g.drawImage(ItensArmer.m4a4_RIGTH_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "ak47") {
					g.drawImage(ItensArmer.ak47_RIGTH_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "shotgun") {
					g.drawImage(ItensArmer.shotgun_RIGTH_EN, this.getX() + 1 - Camera.x, this.getY() + 1 - Camera.y,
							null);
				}

			}
		} else if (dir == left_dir) {
			g.drawImage(botLeft[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
			if (Player.arma) {
				if (Game.inven.armaEquipada == "pistol") {
					g.drawImage(ItensArmer.Pistol_LEFT_EN, this.getX() - 8 - Camera.x, this.getY() - Camera.y, null);
				} else if (Game.inven.armaEquipada == "bow") {
					g.drawImage(ItensArmer.bow_LEFT_EN, this.getX() - 1 - Camera.x, this.getY() + 2 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "m4a4") {
					g.drawImage(ItensArmer.m4a4_LEFT_EN, this.getX() - 3 - Camera.x, this.getY() + 1 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "ak47") {
					g.drawImage(ItensArmer.ak47_LEFT_EN, this.getX() - 3 - Camera.x, this.getY() + 1 - Camera.y, null);
				} else if (Game.inven.armaEquipada == "shotgun") {
					g.drawImage(ItensArmer.shotgun_LEFT_EN, this.getX() - 1 - Camera.x, this.getY() + 1 - Camera.y,
							null);
				}

			}
		}
	}
}

package com.jomuvi.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.graficos.ItensArmer;
import com.jomuvi.main.Game;
//import com.jomuvi.main.Sound;
import com.jomuvi.world.Camera;
import com.jomuvi.world.World;

public class Player extends Entity {

	public boolean Right = false, Left = false, Up = false, Down = false;
	public int right_dir = 0, left_dir = 1;
	public int dir = left_dir;
	public double speed = 2;

	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	public boolean moved = false;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;

	private BufferedImage playerDamage;

	public boolean isDamaged = false;

	private int damagedFremes = 0;

	public double life = 100, maxLife = 100;
	public int nivel = 1;
	public double xp = 0, maxXp = 1000;

	public static boolean arma = false;
	public boolean shoot = false;

	public static int ammo;

	public static double dano;
	public static double forca = 1;

	public Player(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);

		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		playerDamage = Game.spritesheet.getSprite(0, 1 * 16, 16, 16);

		for (int i = 0; i < 4; i++) {
			rightPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 0, 16, 16);
		}
		for (int i = 0; i < 4; i++) {
			leftPlayer[i] = Game.spritesheet.getSprite(32 + (i * 16), 16, 16, 16);
		}
	}

	public void tick() {
		Game.verItens.verQtMunicao();
		Game.verItens.verDano();
		moved = false;
		if (Right && World.isfree((int) (x + speed), this.getY())) {
			moved = true;
			dir = right_dir;
			x += speed;
		} else if (Left && World.isfree((int) (x - speed), this.getY())) {
			moved = true;
			dir = left_dir;
			x -= speed;
		}
		if (Up && World.isfree(this.getX(), (int) (y - speed))) {
			moved = true;
			y -= speed;
		} else if (Down && World.isfree(this.getX(), (int) (y + speed))) {
			moved = true;
			y += speed;
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
		if (life > maxLife) {
			life = maxLife;
		}
		if (isDamaged) {
			this.damagedFremes++;
			if (this.damagedFremes == 8) {
				isDamaged = false;
				damagedFremes = 0;
			}
		}
		if (life <= 0) {
			Game.gameState = "GAME_OVER";
			// life = 100;
		}

		Camera.x = Camera.clamp(this.getX() - (Game.WIDTH / 2), 0, World.WIDTH * 16 - Game.WIDTH);
		Camera.y = Camera.clamp(this.getY() - (Game.HEIGHT / 2), 0, World.HEIGHT * 16 - Game.HEIGHT);

		if (shoot) {
			shoot = false;
			if (arma && ammo > 0) {
//				Sound.shootEffect.play();
				int dx = 0;
				int px = 0;
				int py = ItensArmer.pyArma[ItensArmer.posicaoPxPy];
				if (dir == right_dir) {
					px = ItensArmer.pxShootRight[ItensArmer.posicaoPxPy];
					dx = 1;
				} else if (dir == left_dir) {
					px = ItensArmer.pxShootLeft[ItensArmer.posicaoPxPy];
					dx = -1;
				}
				BulletShoot bulletShoot = new BulletShoot(this.getX() + px, this.getY() + py, 3, 3, null, dx, 0);
				Game.Bullets.add(bulletShoot);
				Game.verItens.diminuirQtMunicao();
			}
		}
	}


	public void render(Graphics g) {

		if (!isDamaged) {
			if (dir == right_dir) {
				g.drawImage(rightPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if (arma) {
					if (Game.inven.armaEquipada == "pistol") {
						g.drawImage(ItensArmer.Pistol_RIGTH_EN, this.getX() + 8 - Camera.x, this.getY() - Camera.y,
								null);

					} else if (Game.inven.armaEquipada == "bow") {
						g.drawImage(ItensArmer.bow_RIGTH_EN, this.getX() + 1 - Camera.x, this.getY() + 2 - Camera.y,
								null);

					} else if (Game.inven.armaEquipada == "m4a4") {
						g.drawImage(ItensArmer.m4a4_RIGTH_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y,
								null);

					} else if (Game.inven.armaEquipada == "ak47") {
						g.drawImage(ItensArmer.ak47_RIGTH_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y,
								null);

					} else if (Game.inven.armaEquipada == "shotgun") {
						g.drawImage(ItensArmer.shotgun_RIGTH_EN, this.getX() + 1 - Camera.x, this.getY() + 1 - Camera.y,
								null);

					}

				}
			} else if (dir == left_dir) {
				g.drawImage(leftPlayer[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
				if (arma) {
					if (Game.inven.armaEquipada == "pistol") {
						g.drawImage(ItensArmer.Pistol_LEFT_EN, this.getX() - 8 - Camera.x, this.getY() - Camera.y,
								null);
					} else if (Game.inven.armaEquipada == "bow") {
						g.drawImage(ItensArmer.bow_LEFT_EN, this.getX() - 1 - Camera.x, this.getY() + 2 - Camera.y,
								null);
					} else if (Game.inven.armaEquipada == "m4a4") {
						g.drawImage(ItensArmer.m4a4_LEFT_EN, this.getX() - 3 - Camera.x, this.getY() + 1 - Camera.y,
								null);
					} else if (Game.inven.armaEquipada == "ak47") {
						g.drawImage(ItensArmer.ak47_LEFT_EN, this.getX() - 3 - Camera.x, this.getY() + 1 - Camera.y,
								null);
					} else if (Game.inven.armaEquipada == "shotgun") {
						g.drawImage(ItensArmer.shotgun_LEFT_EN, this.getX() - 1 - Camera.x, this.getY() + 1 - Camera.y,
								null);
					}

				}
			}

		} else if (isDamaged) {
			g.drawImage(playerDamage, this.getX() - Camera.x, this.getY() - Camera.y, null);
			if (dir == right_dir) {
				if (arma) {
					if (Game.inven.armaEquipada == "pistol") {
						g.drawImage(GUN_RIGTH_DM_EN, this.getX() + 8 - Camera.x, this.getY() - Camera.y, null);
					} else if (Game.inven.armaEquipada == "bow") {
						g.drawImage(BOW_RIGTH_DM_EN, this.getX() + 1 - Camera.x, this.getY() + 2 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "m4a4") {
						g.drawImage(M4A4_RIGTH_DM_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "ak47") {
						g.drawImage(AK47_RIGTH_DM_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "shotgun") {
						g.drawImage(SHOTGUN_RIGTH_DM_EN, this.getX() + 1 - Camera.x, this.getY() + 1 - Camera.y, null);
					}

				}
			} else if (dir == left_dir) {
				if (arma) {
					if (Game.inven.armaEquipada == "pistol") {
						g.drawImage(GUN_LEFT_DM_EN, this.getX() - 8 - Camera.x, this.getY() - Camera.y, null);
					} else if (Game.inven.armaEquipada == "bow") {
						g.drawImage(BOW_LEFT_DM_EN, this.getX() + 1 - Camera.x, this.getY() + 2 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "m4a4") {
						g.drawImage(M4A4_LEFT_DM_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "ak47") {
						g.drawImage(AK47_LEFT_DM_EN, this.getX() + 3 - Camera.x, this.getY() + 1 - Camera.y, null);
					} else if (Game.inven.armaEquipada == "shotgun") {
						g.drawImage(SHOTGUN_LEFT_DM_EN, this.getX() + 1 - Camera.x, this.getY() + 1 - Camera.y, null);
					}

				}
			}
		}
	}
}

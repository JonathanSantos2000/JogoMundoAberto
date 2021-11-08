package com.jomuvi.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class FireBallShoot extends Entity {
	private double spd = 1;

	private int life = 70, curLife = 0;
	private BufferedImage[] Ball;
	private int frames = 0, maxFrames = 20, index = 0, maxIndex = 5;

	public FireBallShoot(int x, int y, int width, int height, BufferedImage sprite, int dx, int dy) {
		super(x, y, width, height, sprite);
		Ball = new BufferedImage[6];
		for (int i = 0; i < 6; i++) {
			if (i == 0) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(0, 16 * 2, 16, 16);
			} else if (i == 1) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(16, 16 * 2, 32, 16);
			} else if (i == 2) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(3 * 16, 16 * 2, 49, 16);
			} else if (i == 3) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(0, 16 * 3, 32, 16);
			} else if (i == 4) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(2 * 16, 16 * 3, 32, 16);
			} else if (i == 5) {
				Ball[i] = Game.spritesheetBossLisard.getSprite(4 * 16, 16 * 3, 16, 16);
			}

		}
	}

	public void tick() {
		if ((int) x > Game.player.getX()) {
			x -= spd;
		}
		if ((int) y < Game.player.getY()) {
			y += spd;
		} else if ((int) y > Game.player.getY()) {
			y -= spd;
		}
		curLife++;
		// Att
		if (curLife == life) {
			Game.fireBall.remove(this);
			return;
		}
		frames++;
		if (frames == maxFrames) {
			frames = 0;
			index++;
			if (index > maxIndex) {
				index = 0;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(Ball[index], this.getX() - Camera.x, this.getY() - Camera.y, null);
	}

}

package com.jomuvi.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;
//import com.jomuvi.world.World;

public class BulletShoot extends Entity {

	private int dx, dy;
	private double spd = 2;

	private int life = 40, curLife = 0;

	public BulletShoot(int x, int y, int width, int height, BufferedImage sprite, int dx, int dy) {
		super(x, y, width, height, sprite);
		this.dx = dx;
		this.dy = dy;
	}

	public void tick() {
		x += dx * spd;
		y += dy * spd;
		curLife++;
		// Att
		if (curLife == life) {
			Game.Bullets.remove(this);
			return;
		}
//		if (!World.isfree((int) (x), this.getY())) {
//			Game.Bullets.remove(this);
//			return;
//		} else if (!World.isfree((int) (x), this.getY())) {
//			Game.Bullets.remove(this);
//			return;
//		}

	}

	public void render(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(this.getX() - Camera.x, this.getY() - Camera.y, 3, 3);
	}

}

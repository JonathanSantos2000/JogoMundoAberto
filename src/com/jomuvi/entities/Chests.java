package com.jomuvi.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Chests extends Entity {

	private BufferedImage Chests;

	public Chests(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		Chests = Game.spritesheetBlocos.getSprite(00 * 00, 03*16, 32, 32);
	}

	public void render(Graphics g) {
		g.drawImage(Chests, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}


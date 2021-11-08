package com.jomuvi.entities.store;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Sleep extends Entity {

	private BufferedImage inn;

	public Sleep(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		inn = Game.spritesheetImoveis.getSprite(04 * 16, 06 * 16, 4 * 16, 3 * 16);
	}

	public void render(Graphics g) {
		g.drawImage(inn, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}


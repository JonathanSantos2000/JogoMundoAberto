package com.jomuvi.entities.store;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Store_Style extends Entity {

	private BufferedImage StyleStore;

	public Store_Style(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		StyleStore = Game.spritesheetImoveis.getSprite(00 * 00, 06 * 16, 4 * 16, 3 * 16);
	}

	public void render(Graphics g) {
		g.drawImage(StyleStore, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}

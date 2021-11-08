package com.jomuvi.entities.store;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Store_Guns extends Entity {

	private BufferedImage GunsStore;

	public Store_Guns(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		GunsStore = Game.spritesheetImoveis.getSprite(0, 3 * 16, 4 * 16, 3 * 16);
	}

	public void render(Graphics g) {
		g.drawImage(GunsStore, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}

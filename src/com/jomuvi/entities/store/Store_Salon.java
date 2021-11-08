package com.jomuvi.entities.store;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class Store_Salon extends Entity {

	private BufferedImage SalonStore;

	public Store_Salon(int x, int y, int width, int height, BufferedImage sprite) {
		super(x, y, width, height, sprite);
		SalonStore = Game.spritesheetImoveis.getSprite(04 * 16, 03 * 16, 4 * 16, 3 * 16);
	}

	public void render(Graphics g) {
		g.drawImage(SalonStore, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}


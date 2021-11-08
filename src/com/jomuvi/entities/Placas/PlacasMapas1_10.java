package com.jomuvi.entities.Placas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Entity;
import com.jomuvi.main.Game;
import com.jomuvi.world.Camera;

public class PlacasMapas1_10 extends Entity {

	private BufferedImage PlacasMapas1_10;

	public PlacasMapas1_10(int x, int y, int width, int height, BufferedImage sprite, int mapa, int seta) {
		super(x, y, width, height, sprite);
		if (mapa == 1) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 01 * 16, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 02 * 16, 32, 16);
			}
			if (seta == 3) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 03 * 16, 32, 16);
			}
			if (seta == 4) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 04 * 16, 32, 16);
			}
		}
		if (mapa == 2) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(02 * 16, 00 * 00, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(02 * 16, 01 * 16, 32, 16);
			}

		}
		if (mapa == 3) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(04 * 16, 00 * 00, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(04 * 16, 01 * 16, 32, 16);
			}
			if (seta == 3) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(04 * 16, 02 * 16, 32, 16);
			}
		}
		if (mapa == 4) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 00 * 00, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 01 * 16, 32, 16);
			}
			if (seta == 3) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 02 * 16, 32, 16);
			}
		}
		if (mapa == 5) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(8 * 16, 00 * 00, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(8 * 16, 01 * 16, 32, 16);
			}
		}
		if (mapa == 6) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 05 * 16, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 06 * 16, 32, 16);
			}
			if (seta == 3) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 07 * 16, 32, 16);
			}
			if (seta == 4) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(00 * 00, 8 * 16, 32, 16);
			}
		}
		if (mapa == 7) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(02 * 16, 02 * 16, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(02 * 16, 03 * 16, 32, 16);
			}
		}
		if (mapa == 8) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(04 * 16, 03 * 16, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(04 * 16, 04 * 16, 32, 16);
			}
		}
		if (mapa == 9) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 03 * 16, 32, 16);
			}
			if (seta == 2) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 04 * 16, 32, 16);
			}
			if (seta == 3) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 05 * 16, 32, 16);
			}
			if (seta == 4) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(06 * 16, 06 * 16, 32, 16);
			}
		}
		if (mapa == 10) {
			if (seta == 1) {
				PlacasMapas1_10 = Game.spritesheetPlacasLvMapas.getSprite(8 * 16, 02 * 16, 32, 16);
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(PlacasMapas1_10, this.getX() - Camera.x, this.getY() - Camera.y, null);
	}
}

package com.jomuvi.graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;

public class InventarioInn {

	public int[] xInventario = { (Game.WIDTH / 2) - 110, (Game.WIDTH / 2) - 74, (Game.WIDTH / 2) - 38 };
	public int[] yInventario = { (Game.HEIGHT / 2) - 35, (Game.HEIGHT / 2), (Game.HEIGHT / 2) + 36 };
	public int[] qtX = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	public int[] qtY = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	public int iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, itenCompra = 0;

	public boolean ShowPotion25Life = false, ShowPotion50Life = false, ShowPotion100Life = false,
			ShowPotionFullLife = false, ShowPotion25reStatusPoison = false, ShowPotion50reStatusPoison = false,
			ShowPotion100reStatusPoison = false, ShowPotionFullreStatusPoison = false,
			ShowPotion25reStatusBurnt = false, ShowPotion50reStatusBurnt = false, ShowPotion100reStatusBurnt = false,
			ShowPotionFullreStatusBurnt = false;

	public static BufferedImage Potion25Life = Game.spritesheetItens.getSprite(0, 0, 16, 16);
	public static BufferedImage Potion50Life = Game.spritesheetItens.getSprite(16, 0, 16, 16);
	public static BufferedImage Potion100Life = Game.spritesheetItens.getSprite(2 * 16, 0, 16, 16);
	public static BufferedImage PotionFullLife = Game.spritesheetItens.getSprite(3 * 16, 0, 16, 16);

	public static BufferedImage Potion25reStatusPoison = Game.spritesheetItens.getSprite(0, 16, 16, 16);
	public static BufferedImage Potion50reStatusPoison = Game.spritesheetItens.getSprite(16, 16, 16, 16);
	public static BufferedImage Potion100reStatusPoison = Game.spritesheetItens.getSprite(2 * 16, 16, 16, 16);
	public static BufferedImage PotionFullreStatusPoison = Game.spritesheetItens.getSprite(3 * 16, 16, 16, 16);

	public static BufferedImage Potion25reStatusBurnt = Game.spritesheetItens.getSprite(0, 2 * 16, 16, 16);
	public static BufferedImage Potion50reStatusBurnt = Game.spritesheetItens.getSprite(16, 2 * 16, 16, 16);
	public static BufferedImage Potion100reStatusBurnt = Game.spritesheetItens.getSprite(2 * 16, 2 * 16, 16, 16);
	public static BufferedImage PotionFullreStatusBurnt = Game.spritesheetItens.getSprite(3 * 16, 2 * 16, 16, 16);

	public void addImg() {
		for (int i = 0; i < Game.inven.ItensNoInventarioPocoes.length; i++) {
			if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Smal" && !ShowPotion25Life) {
				ShowPotion25Life = true;
				iv1 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion midium" && !ShowPotion50Life) {
				ShowPotion50Life = true;
				iv2 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Big" && !ShowPotion100Life) {
				ShowPotion100Life = true;
				iv3 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Full" && !ShowPotionFullLife) {
				ShowPotionFullLife = true;
				iv4 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Smal" && !ShowPotion25reStatusPoison) {
				ShowPotion25reStatusPoison = true;
				iv5 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison midium"
					&& !ShowPotion50reStatusPoison) {
				ShowPotion50reStatusPoison = true;
				iv6 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Big" && !ShowPotion100reStatusPoison) {
				ShowPotion100reStatusPoison = true;
				iv7 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Full"
					&& !ShowPotionFullreStatusPoison) {
				ShowPotionFullreStatusPoison = true;
				iv8 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Smal" && !ShowPotion25reStatusBurnt) {
				ShowPotion25reStatusBurnt = true;
				iv9 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt midium" && !ShowPotion50reStatusBurnt) {
				ShowPotion50reStatusBurnt = true;
				iv10 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Big" && !ShowPotion100reStatusBurnt) {
				ShowPotion100reStatusBurnt = true;
				iv11 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Full" && !ShowPotionFullreStatusPoison) {
				ShowPotionFullreStatusPoison = true;
				iv12 = itenCompra;
				itenCompra++;
				break;
			}
		}
	}

	public void render(Graphics g) {
		if (ShowPotion25Life) {
			g.drawImage(InventarioInn.Potion25Life, xInventario[qtX[iv1]], yInventario[qtY[iv1]], 32, 32, null);
		}
		if (ShowPotion50Life) {
			g.drawImage(InventarioInn.Potion50Life, xInventario[qtX[iv2]], yInventario[qtY[iv2]], 32, 32, null);

		}
		if (ShowPotion100Life) {
			g.drawImage(InventarioInn.Potion100Life, xInventario[qtX[iv3]], yInventario[qtY[iv3]], 32, 32, null);

		}
		if (ShowPotionFullLife) {
			g.drawImage(InventarioInn.PotionFullLife, xInventario[qtX[iv4]], yInventario[qtY[iv4]], 32, 32, null);

		}
		if (ShowPotion25reStatusPoison) {
			g.drawImage(InventarioInn.Potion25reStatusPoison, xInventario[qtX[iv5]], yInventario[qtY[iv5]], 32, 32,
					null);

		}
		if (ShowPotion50reStatusPoison) {
			g.drawImage(InventarioInn.Potion50reStatusPoison, xInventario[qtX[iv6]], yInventario[qtY[iv6]], 32, 32,
					null);

		}
		if (ShowPotion100reStatusPoison) {
			g.drawImage(InventarioInn.Potion100reStatusPoison, xInventario[qtX[iv7]], yInventario[qtY[iv7]], 32, 32,
					null);

		}
		if (ShowPotionFullreStatusPoison) {
			g.drawImage(InventarioInn.PotionFullreStatusPoison, xInventario[qtX[iv8]], yInventario[qtY[iv8]], 32,
					32, null);

		}
		if (ShowPotion25reStatusBurnt) {
			g.drawImage(InventarioInn.Potion25reStatusBurnt, xInventario[qtX[iv9]], yInventario[qtY[iv9]], 32, 32,
					null);

		}
		if (ShowPotion50reStatusBurnt) {
			g.drawImage(InventarioInn.Potion50reStatusBurnt, xInventario[qtX[iv10]], yInventario[qtY[iv10]], 32, 32,
					null);

		}
		if (ShowPotion100reStatusBurnt) {
			g.drawImage(InventarioInn.Potion100reStatusBurnt, xInventario[qtX[iv11]], yInventario[qtY[iv11]], 32,
					32, null);

		}
		if (ShowPotionFullreStatusBurnt) {
			g.drawImage(InventarioInn.PotionFullreStatusBurnt, xInventario[qtX[iv12]], yInventario[qtY[iv12]], 32,
					32, null);
		}
	}
}

package com.jomuvi.graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;

public class ItensMunicao {

//local no inventario;
	public int[] xInventario = { (Game.WIDTH / 2) - 162, (Game.WIDTH / 2) - 124, (Game.WIDTH / 2) - 88 };
	public int[] yInventario = { (Game.HEIGHT / 2) - 28, (Game.HEIGHT / 2) + 8, (Game.HEIGHT / 2) + 44 };
	public int[] qtX = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	public int[] qtY = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	public int iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, itenCompra = 0;

	public boolean ShowMuniPistol = false, ShowMuniBow = false, ShowMuniM4A4 = false, ShowMuniAk47 = false,
			ShowMuniShotgun = false, null1 = false, null2 = false, null3 = false, null4 = false, null5 = false,
			null6 = false, null7 = false;

//-------------------------------------------------------------
//descrições dos itens preços ItensArmer ShopArm

	public static String[] options = { "pistol", "bow", "m4a4", "ak47", "shotgun", "bloqueado 1", "bloqueado 2",
			"bloqueado 3", "bloqueado 4", "bloqueado 5", "bloqueado 6", "bloqueado 7", };

	public static int[] shootDano = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; // Dano DA MUNIÇÃO
//	public static int[] shootLife = { -9, -1, -5, -5, -4, 1, 2, 2, 2 }; // VIDA DA MUNIÇÃO

	public static String[] Efeitos = { "Pistola da *** de dano base,mais o ", "Bow da *** de dano base,mais o ",
			"M4A4 da *** de dano base,mais o ", "AK47 da *** de dano base,mais o ",
			"Shotgun da *** de dano base,mais o ", "Arma não adicionada", "Arma não adicionada"/**/,
			"Arma não adicionada", "Arma não adicionada", "Arma não adicionada", "Arma não adicionada",
			"Arma não adicionada" };

	public static String[] EfeitosLine2 = { "dano base do player e da munições", "dano base do player e da munições",
			"dano base do player e da munições", "dano base do player e da munições",
			"dano base do player e da munições", "", "", "", "", "", "", "" };

	public static String[] VendeSe = { "1", "1", "1", "1", "1", "", "", "", "", "", "", "" };
	public static String[] MoedaVendeSe = { "bronze", "bronze", "bronze", "bronze", "bronze"/*                    */,
			"", "", "", "", "", "", "" };

	public static String[] CompraSe = { "30", "50", "1", "1", "30", "", "", "", "", "", "", "" };
	public static String[] MoedaCompraSe = { "bronze", "bronze", "bronze", "bronze", "bronze"/*                    */,
			"", "", "", "", "", "", "" };

//-------------------------------------------------------------
	public static BufferedImage muniPistol = Game.spritesheetItens.getSprite/* */(00 * 00, 5 * 16, 16, 16);
	public static BufferedImage muniBow = Game.spritesheetItens.getSprite/*    */(01 * 16, 5 * 16, 16, 16);
	public static BufferedImage muniM4A4 = Game.spritesheetItens.getSprite/*   */(03 * 16, 5 * 16, 16, 16);
	public static BufferedImage muniAk47 = Game.spritesheetItens.getSprite/*   */(03 * 16, 5 * 16, 16, 16);
	public static BufferedImage muniShotgun = Game.spritesheetItens.getSprite/**/(02 * 16, 5 * 16, 16, 16);

	public void addImg() {
		for (int i = 0; i < Game.inven.ItensNoInventarioMunicao.length; i++) {
			if (Game.inven.ItensNoInventarioMunicao[i] == "pistol" && !ShowMuniPistol) {
				ShowMuniPistol = true;
				iv1 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioMunicao[i] == "bow" && !ShowMuniBow) {
				ShowMuniBow = true;
				iv2 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioMunicao[i] == "m4a4" && !ShowMuniM4A4) {
				ShowMuniM4A4 = true;
				iv3 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioMunicao[i] == "ak47" && !ShowMuniAk47) {
				ShowMuniAk47 = true;
				iv4 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.ItensNoInventarioMunicao[i] == "shotgun" && !ShowMuniShotgun) {
				ShowMuniShotgun = true;
				iv5 = itenCompra;
				itenCompra++;
				break;
			}
		}
	}

	public void renderInventario(Graphics g) {
		if (ShowMuniPistol) {
			g.drawImage(muniPistol, xInventario[qtX[iv1]], yInventario[qtY[iv1]], 32, 32, null);
			System.out.println(xInventario[qtX[iv1]] + "  " + yInventario[qtY[iv1]]);
		}
		if (ShowMuniBow) {
			g.drawImage(muniBow, xInventario[qtX[iv2]], yInventario[qtY[iv2]], 32, 32, null);
		}
		if (ShowMuniM4A4) {
			g.drawImage(muniM4A4, xInventario[qtX[iv3]], yInventario[qtY[iv3]], 32, 32, null);
		}
		if (ShowMuniAk47) {
			g.drawImage(muniAk47, xInventario[qtX[iv4]], yInventario[qtY[iv4]], 32, 32, null);
		}
		if (ShowMuniShotgun) {
			g.drawImage(muniShotgun, xInventario[qtX[iv5]], yInventario[qtY[iv5]], 32, 32, null);
		}
	}

	public void renderUI(Graphics g) {
		if (Game.inven.municaoEquipada == "pistol") {
			g.drawImage(muniPistol, (Game.WIDTH / 2) + 159, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniPistol, (Game.WIDTH / 2) + 153, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniPistol, (Game.WIDTH / 2) + 147, (Game.HEIGHT / 2) + 105, 16, 16, null);
		}
		if (Game.inven.municaoEquipada == "bow") {
			g.drawImage(muniBow, (Game.WIDTH / 2) + 159, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniBow, (Game.WIDTH / 2) + 153, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniBow, (Game.WIDTH / 2) + 147, (Game.HEIGHT / 2) + 105, 16, 16, null);
		}
		if (Game.inven.municaoEquipada == "m4a4") {
			g.drawImage(muniM4A4, (Game.WIDTH / 2) + 159, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniM4A4, (Game.WIDTH / 2) + 153, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniM4A4, (Game.WIDTH / 2) + 147, (Game.HEIGHT / 2) + 105, 16, 16, null);
		}
		if (Game.inven.municaoEquipada == "ak47") {
			g.drawImage(muniAk47, (Game.WIDTH / 2) + 159, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniAk47, (Game.WIDTH / 2) + 153, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniAk47, (Game.WIDTH / 2) + 147, (Game.HEIGHT / 2) + 105, 16, 16, null);
		}
		if (Game.inven.municaoEquipada == "shotgun") {
			g.drawImage(muniShotgun, (Game.WIDTH / 2) + 159, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniShotgun, (Game.WIDTH / 2) + 153, (Game.HEIGHT / 2) + 105, 16, 16, null);
			g.drawImage(muniShotgun, (Game.WIDTH / 2) + 147, (Game.HEIGHT / 2) + 105, 16, 16, null);
		}
	}

	public void renderLoja(Graphics g) {
		g.drawImage(muniPistol, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 98, 32, 32, null);
		g.drawImage(muniBow, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(muniM4A4, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(muniAk47, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(muniShotgun, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 60, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 19, 32, 32, null);
	}
}

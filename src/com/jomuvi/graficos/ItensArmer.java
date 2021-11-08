package com.jomuvi.graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Game;

public class ItensArmer {

//local no inventario;
	public int[] xInventario = { (Game.WIDTH / 2) - 162, (Game.WIDTH / 2) - 124, (Game.WIDTH / 2) - 88 };
	public int[] yInventario = { (Game.HEIGHT / 2) - 28, (Game.HEIGHT / 2) + 8, (Game.HEIGHT / 2) + 44 };
	public int[] qtX = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	public int[] qtY = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	public int iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9, iv10, iv11, iv12, itenCompra = 0;

	public boolean ShowPistol = false, ShowBow = false, ShowM4A4 = false, ShowAk47 = false, ShowShotgun = false,
			null1 = false, null2 = false, null3 = false, null4 = false, null5 = false, null6 = false, null7 = false;

// local no fast Bar Render;
	public static boolean armaTp1 = false, armaTp2 = false, armaTp3 = false, armaTp4 = false, armaTp5 = false,
			/*          */armaTp6 = false, armaTp7 = false, armaTp8 = false, armaTp9 = false, armaTp10 = false,
			/*          */armaTp11 = false, armaTp12 = false;

//-------------------------------------------------------------
//descrições dos itens preços ItensArmer ShopArm

	public static String[] options = { "pistol", "bow", "m4a4", "ak47", "shotgun", "bloqueado 1", "bloqueado 2",
			"bloqueado 3", "bloqueado 4", "bloqueado 5", "bloqueado 6", "bloqueado 7", };

	public static int[] pyArma = { 7, 10, 9, 9, 8, 1, 2, 2, 2 };
	public static int[] pxShootRight = { 22, 15, 18, 18, 17, 1, 2, 2, 2 };
	public static int[] pxShootLeft = { -9, -1, -5, -5, -4, 1, 2, 2, 2 };
	public static int posicaoPxPy;

	public static int[] armaDano = { 9, 15, 18, 18, 17, 1, 2, 2, 2 }; // Dano da arma

	public static String[] Efeitos = { "Pistola da *** de dano base,mais o ", "Bow da *** de dano base,mais o ",
			"M4A4 da *** de dano base,mais o ", "AK47 da *** de dano base,mais o ",
			"Shotgun da *** de dano base,mais o ", "Arma não adicionada", "Arma não adicionada"/**/,
			"Arma não adicionada", "Arma não adicionada", "Arma não adicionada", "Arma não adicionada",
			"Arma não adicionada" };

	public static String[] EfeitosLine2 = { "dano base do player e da munições", "dano base do player e da munições",
			"dano base do player e da munições", "dano base do player e da munições",
			"dano base do player e da munições", "", "", "", "", "", "", "" };

	public static String[] VendeSe = { "1", "1", "1", "1", "1", "", "", "", "", "", "", "" };
	public static String[] MoedaVendeSe = { "bronze", "silver", "silver", "bronze", "bronze", "", "", "", "", "", "",
			"" };

	public static String[] CompraSe = { "30", "50", "1", "1", "30", "", "", "", "", "", "", "" };
	public static String[] MoedaCompraSe = { "gold", "bronze", "silver", "bronze", "bronze", "", "", "", "", "", "",
			"" };

//-------------------------------------------------------------
	public static BufferedImage Pistol_RIGTH_EN = Game.spritesheetGuns.getSprite(0, 0, 16, 16);
	public static BufferedImage Pistol_LEFT_EN = Game.spritesheetGuns.getSprite(16, 0, 16, 16);

	public static BufferedImage bow_RIGTH_EN = Game.spritesheetGuns.getSprite(2 * 16, 0, 16, 16);
	public static BufferedImage bow_LEFT_EN = Game.spritesheetGuns.getSprite(3 * 16, 0, 16, 16);

	public static BufferedImage m4a4_RIGTH_EN = Game.spritesheetGuns.getSprite(4 * 16, 0, 16, 16);
	public static BufferedImage m4a4_LEFT_EN = Game.spritesheetGuns.getSprite(5 * 16, 0, 16, 16);

	public static BufferedImage ak47_RIGTH_EN = Game.spritesheetGuns.getSprite(6 * 16, 0, 16, 16);
	public static BufferedImage ak47_LEFT_EN = Game.spritesheetGuns.getSprite(7 * 16, 0, 16, 16);

	public static BufferedImage shotgun_RIGTH_EN = Game.spritesheetGuns.getSprite(8 * 16, 0, 16, 16);
	public static BufferedImage shotgun_LEFT_EN = Game.spritesheetGuns.getSprite(9 * 16, 0, 16, 16);

	public void addImg() {
		for (int i = 0; i < Game.inven.itensNoInventarioArmas.length; i++) {
			if (Game.inven.itensNoInventarioArmas[i] == "pistol" && !ShowPistol) {
				ShowPistol = true;
				iv1 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.itensNoInventarioArmas[i] == "bow" && !ShowBow) {
				ShowBow = true;
				iv2 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.itensNoInventarioArmas[i] == "m4a4" && !ShowM4A4) {
				ShowM4A4 = true;
				iv3 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.itensNoInventarioArmas[i] == "ak47" && !ShowAk47) {
				ShowAk47 = true;
				iv4 = itenCompra;
				itenCompra++;
				break;
			} else if (Game.inven.itensNoInventarioArmas[i] == "shotgun" && !ShowShotgun) {
				ShowShotgun = true;
				iv5 = itenCompra;
				itenCompra++;
				break;
			}
		}
	}

	public static void findPosition(String arma) {
		switch (arma) {
		case "pistol":
			armaTp1 = true;
			posicaoPxPy = 0;
			naoMostrarMao0_10("234567890");
			break;
		case "bow":
			armaTp2 = true;
			posicaoPxPy = 1;
			naoMostrarMao0_10("134567890");
			break;
		case "m4a4":
			armaTp3 = true;
			posicaoPxPy = 2;
			naoMostrarMao0_10("124567890");
			break;
		case "ak47":
			armaTp4 = true;
			posicaoPxPy = 3;
			naoMostrarMao0_10("123567890");
			break;
		case "shotgun":
			posicaoPxPy = 4;
			armaTp5 = true;
			naoMostrarMao0_10("123467890");
			break;
		}

		for (int i = 0; i < options.length; i++) {
			if (arma == options[i]) {
				Game.inven.posicaoArma = i;
				break;
			}
		}
	}

	public void renderInventario(Graphics g) {
		if (ShowPistol) {
			g.drawImage(Pistol_RIGTH_EN, xInventario[qtX[iv1]], yInventario[qtY[iv1]], 32, 32, null);
		}
		if (ShowBow) {
			g.drawImage(bow_RIGTH_EN, xInventario[qtX[iv2]], yInventario[qtY[iv2]], 32, 32, null);
		}
		if (ShowM4A4) {
			g.drawImage(m4a4_RIGTH_EN, xInventario[qtX[iv3]], yInventario[qtY[iv3]], 32, 32, null);
		}
		if (ShowAk47) {
			g.drawImage(ak47_RIGTH_EN, xInventario[qtX[iv4]], yInventario[qtY[iv4]], 32, 32, null);
		}
		if (ShowShotgun) {
			g.drawImage(shotgun_RIGTH_EN, xInventario[qtX[iv5]], yInventario[qtY[iv5]], 32, 32, null);
		}
	}

	public void renderEquipado(Graphics g) {
		for (int i = 0; i < 7; i++) {
			/*   */if (Game.inven.itensNoInventarioArmas[i] == "pistol" && armaTp1) {
				g.drawImage(Pistol_RIGTH_EN, (Game.WIDTH / 2) + 32, (Game.HEIGHT / 2) + 35, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "bow" && armaTp2) {
				g.drawImage(bow_RIGTH_EN, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 35, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "m4a4" && armaTp3) {
				g.drawImage(m4a4_RIGTH_EN, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 35, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "ak47" && armaTp4) {
				g.drawImage(ak47_RIGTH_EN, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 35, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "shotgun" && armaTp5) {
				g.drawImage(shotgun_RIGTH_EN, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 35, 32, 32, null);
			}
		}
	}

	public void renderUI(Graphics g) {
		for (int i = 0; i < 7; i++) {
			/*   */if (Game.inven.itensNoInventarioArmas[i] == "pistol" && armaTp1) {
				g.drawImage(Pistol_RIGTH_EN, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 85, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "bow" && armaTp2) {
				g.drawImage(bow_RIGTH_EN, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 85, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "m4a4" && armaTp3) {
				g.drawImage(m4a4_RIGTH_EN, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 85, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "ak47" && armaTp4) {
				g.drawImage(ak47_RIGTH_EN, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 85, 32, 32, null);
			} else if (Game.inven.itensNoInventarioArmas[i] == "shotgun" && armaTp5) {
				g.drawImage(shotgun_RIGTH_EN, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 85, 32, 32, null);
			}
		}
	}

	public void renderLoja(Graphics g) {
		g.drawImage(Pistol_RIGTH_EN, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 98, 32, 32, null);
		g.drawImage(ItensArmer.bow_RIGTH_EN, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(ItensArmer.m4a4_RIGTH_EN, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(ItensArmer.ak47_RIGTH_EN, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 95, 32, 32, null);
		g.drawImage(ItensArmer.shotgun_RIGTH_EN, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 60, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 57, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 19, 32, 32, null);
		g.drawImage(Inventario.bloqueado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 19, 32, 32, null);
	}

	public static int[] arma = new int[13];
	public static int n;

	public static void naoMostrarMao0_10(String naoMostrar) {
		for (int i = 0; i < 9; i++) {
			switch (naoMostrar.charAt(i)) {
			case '1':
				armaTp1 = false;
				break;
			case '2':
				armaTp2 = false;
				break;
			case '3':
				armaTp3 = false;
				break;
			case '4':
				armaTp4 = false;
				break;
			case '5':
				armaTp5 = false;
				break;
			case '6':
				armaTp6 = false;
				break;
			case '7':
				armaTp7 = false;
				break;
			case '8':
				armaTp8 = false;
				break;
			case '9':
				armaTp9 = false;
				break;
			case '0':
				armaTp10 = false;
				break;
			}
		}
	}
	// -----
}

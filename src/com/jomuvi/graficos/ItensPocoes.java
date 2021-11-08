package com.jomuvi.graficos;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import com.jomuvi.main.Game;

public class ItensPocoes {

//local no inventario;
	public int[] xInventario = { (Game.WIDTH / 2) - 160, (Game.WIDTH / 2) - 124, (Game.WIDTH / 2) - 88 };
	public int[] yInventario = { (Game.HEIGHT / 2) - 28, (Game.HEIGHT / 2) + 8, (Game.HEIGHT / 2) + 44 };
	public int[] qtX = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
	public int[] qtY = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
	public boolean[] has = { false, false, false, false, false, false, false, false, false, false, false, false };
	public int[] pos = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public int[] liberarInventario = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
	public int itemCompra = 1;

//-------------------------------------------------------------
//descrições dos itens preços ItensArmer ShopArm

	public static String[] options = { "Life Potion Smal", "Life Potion midium", "Life Potion Big", "Life Potion Full",
			"Remove Status Poison Smal", "Remove Status Poison midium", "Remove Status Poison Big",
			"Remove Status Poison Full", "Remove Status Burnt Smal", "Remove Status Burnt midium",
			"Remove Status Burnt Big", "Remove Status Burnt Full", };
	public static String[] Efeitos = { "Recupera 20 de HP", "Recupera 50 de HP", "Recupera 100 de HP",
			"Recupera 100% de HP", /**/
			"Remove status de poison", "Remove status de poison", "Remove status de poison", "Remove status de poison",
			"Remove status de Burnt", "Remove status de Burnt", "Remove status de Burnt", "Remove status de Burnt", };
	public static String[] EfeitosLine2 = { "0", "0", "0", "0", /*                */"Recupera 20 de HP",
			"Recupera 50 de HP", "Recupera 100 de HP", "Recupera 100% de HP", /*                */"Recupera 20 de HP",
			"Recupera 50 de HP", "Recupera 100 de HP", "Recupera 100% de HP" };

	public static String[] VendeSe = { "30", "50", "1", "1", "30", "50", "1", "1", "30", "50", "1", "1" };
	public static String[] MoedaVendeSe = { "bronze", "bronze", "prata", "gold", "bronze", "bronze", "prata", "gold",
			"bronze", "bronze", "prata", "gold" };

	public static String[] CompraSe = { "30", "50", "1", "1", "30", "50", "1", "1", "30", "50", "1", "1" };
	public static String[] MoedaCompraSe = { "30", "50", "1", "1", "30", "50", "1", "1", "30", "50", "1", "1" };

//-------------------------------------------------------------
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
			for (int j = 0; j < options.length; j++) {
				if (Game.inven.ItensNoInventarioPocoes[i] == options[j] && liberarInventario[j] == -1) {
					liberarInventario[j] = 1;
					if (pos[j] == 0 && !has[i]) {
						pos[j] = i;
						has[i] = true;
					}
				}
			}
		}
	}

	public void renderInventario(Graphics g) {
		if (liberarInventario[0] == 1)
			g.drawImage(Potion25Life, xInventario[qtX[pos[0]]], yInventario[qtY[pos[0]]], 32, 32, null);
		if (liberarInventario[1] == 1)
			g.drawImage(Potion50Life, xInventario[qtX[pos[1]]], yInventario[qtY[pos[1]]], 32, 32, null);
		if (liberarInventario[2] == 1)
			g.drawImage(Potion100Life, xInventario[qtX[pos[2]]], yInventario[qtY[pos[2]]], 32, 32, null);
		if (liberarInventario[3] == 1)
			g.drawImage(PotionFullLife, xInventario[qtX[pos[3]]], yInventario[qtY[pos[3]]], 32, 32, null);
		if (liberarInventario[4] == 1)
			g.drawImage(Potion25reStatusPoison, xInventario[qtX[pos[4]]], yInventario[qtY[pos[4]]], 32, 32, null);
		if (liberarInventario[5] == 1)
			g.drawImage(Potion50reStatusPoison, xInventario[qtX[pos[5]]], yInventario[qtY[pos[5]]], 32, 32, null);
		if (liberarInventario[6] == 1)
			g.drawImage(Potion100reStatusPoison, xInventario[qtX[pos[6]]], yInventario[qtY[pos[6]]], 32, 32, null);
		if (liberarInventario[7] == 1)
			g.drawImage(PotionFullreStatusPoison, xInventario[qtX[pos[7]]], yInventario[qtY[pos[7]]], 32, 32, null);
		if (liberarInventario[8] == 1)
			g.drawImage(Potion25reStatusBurnt, xInventario[qtX[pos[8]]], yInventario[qtY[pos[8]]], 32, 32, null);
		if (liberarInventario[9] == 1)
			g.drawImage(Potion50reStatusBurnt, xInventario[qtX[pos[9]]], yInventario[qtY[pos[9]]], 32, 32, null);
		if (liberarInventario[10] == 1)
			g.drawImage(Potion100reStatusBurnt, xInventario[qtX[pos[10]]], yInventario[qtY[pos[10]]], 32, 32, null);
		if (liberarInventario[11] == 1)
			g.drawImage(PotionFullreStatusBurnt, xInventario[qtX[pos[11]]], yInventario[qtY[pos[11]]], 32, 32, null);
	}

	// local no fast Bar Render;
	public int[] xInven = { (Game.WIDTH / 2) - 97, (Game.WIDTH / 2) - 62, (Game.WIDTH / 2) - 27,
			/*            */(Game.WIDTH / 2) + 8, (Game.WIDTH / 2) + 43, (Game.WIDTH / 2) + 78 };
	public int[] yInven = { (Game.HEIGHT / 2) + 93 };

	public static int[] posiFast = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int[] liberarFastBar = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	public static void showFastBar(String numero, int posicao) {
		for (int i = 0; i < options.length; i++) {
			if (numero == options[i]) {
				liberarFastBar[i] = 1;
				posiFast[i] = posicao;
			}
		}
	}

	public static void hideFastBar(String numero) {
		for (int i = 0; i < options.length; i++) {
			if (numero == options[i]) {
				liberarFastBar[i] = 0;
			}
		}
	}

	public void fastBarRender(Graphics g) {
		if (liberarFastBar[0] == 1)
			g.drawImage(Potion25Life, xInven[posiFast[0]], yInven[0], 32, 32, null);
		if (liberarFastBar[1] == 1)
			g.drawImage(Potion50Life, xInven[posiFast[1]], yInven[0], 32, 32, null);
		if (liberarFastBar[2] == 1)
			g.drawImage(Potion100Life, xInven[posiFast[2]], yInven[0], 32, 32, null);
		if (liberarFastBar[3] == 1)
			g.drawImage(PotionFullLife, xInven[posiFast[3]], yInven[0], 32, 32, null);
		if (liberarFastBar[4] == 1)
			g.drawImage(Potion25reStatusPoison, xInven[posiFast[4]], yInven[0], 32, 32, null);
		if (liberarFastBar[5] == 1)
			g.drawImage(Potion50reStatusPoison, xInven[posiFast[5]], yInven[0], 32, 32, null);
		if (liberarFastBar[6] == 1)
			g.drawImage(Potion100reStatusPoison, xInven[posiFast[6]], yInven[0], 32, 32, null);
		if (liberarFastBar[7] == 1)
			g.drawImage(PotionFullreStatusPoison, xInven[posiFast[7]], yInven[0], 32, 32, null);
		if (liberarFastBar[8] == 1)
			g.drawImage(Potion25reStatusBurnt, xInven[posiFast[8]], yInven[0], 32, 32, null);
		if (liberarFastBar[9] == 1)
			g.drawImage(Potion50reStatusBurnt, xInven[posiFast[9]], yInven[0], 32, 32, null);
		if (liberarFastBar[10] == 1)
			g.drawImage(Potion100reStatusBurnt, xInven[posiFast[10]], yInven[0], 32, 32, null);
		if (liberarFastBar[11] == 1)
			g.drawImage(PotionFullreStatusBurnt, xInven[posiFast[11]], yInven[0], 32, 32, null);
	}

	public static void addItensInvRapido(int pos) {
		if (Game.inven.ItensNoInventarioRapido[pos] != null) {
			hideFastBar(Game.inven.ItensNoInventarioRapido[pos]);
			hideFastBarInv(Game.inven.ItensNoInventarioRapido[pos]);
		}
		for (int i = 0; i < Game.inven.ItensNoInventarioRapido.length; i++) {
			if (Game.inven.ItensNoInventarioRapido[i] == Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition]) {
				Game.inven.ItensNoInventarioRapido[i] = null;
				Game.inven.ItensNoInventarioRapido[pos] = Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition];
			} else {
				if (Game.inven.ItensNoInventarioRapido[pos] == null) {
					Game.inven.ItensNoInventarioRapido[pos] = Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition];
				} else if (Game.inven.ItensNoInventarioRapido[pos] != null) {
					Game.inven.ItensNoInventarioRapido[pos] = Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition];
				}
			}
		}
	}

	// local no fast Bar Render inventario;
	public int[] xFastInven = { (Game.WIDTH / 2) - 160, (Game.WIDTH / 2) - 124, (Game.WIDTH / 2) - 88 };
	public int[] yFastInven = { (Game.HEIGHT / 2) - 105, (Game.HEIGHT / 2) - 69 };

	public static int[] x = { 0, 1, 2, 0, 1, 2 };
	public static int[] y = { 0, 0, 0, 1, 1, 1 };

	public static int[] posiFastIn = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	public static int[] liberarFastBarIn = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

	public static void hideFastBarInv(String numero) {
		for (int i = 0; i < options.length; i++) {
			if (numero == options[i]) {
				liberarFastBarIn[i] = 0;
			}
		}
	}

	public static void showFastBarInv(String numero, int posicao) {
		for (int i = 0; i < options.length; i++) {
			if (numero == options[i]) {
				liberarFastBarIn[i] = 1;
				posiFastIn[i] = posicao;
			}
		}
	}

	public void fastBarRenderIn(Graphics g) {
		if (liberarFastBarIn[0] == 1)
			g.drawImage(Potion25Life, xFastInven[x[posiFastIn[0]]], yFastInven[y[posiFastIn[0]]], 32, 32, null);
		if (liberarFastBarIn[1] == 1)
			g.drawImage(Potion50Life, xFastInven[x[posiFastIn[1]]], yFastInven[y[posiFastIn[1]]], 32, 32, null);
		if (liberarFastBarIn[2] == 1)
			g.drawImage(Potion100Life, xFastInven[x[posiFastIn[2]]], yFastInven[y[posiFastIn[2]]], 32, 32, null);
		if (liberarFastBarIn[3] == 1)
			g.drawImage(PotionFullLife, xFastInven[x[posiFastIn[3]]], yFastInven[y[posiFastIn[3]]], 32, 32, null);
		if (liberarFastBarIn[4] == 1)
			g.drawImage(Potion25reStatusPoison, xFastInven[x[posiFastIn[4]]], yFastInven[y[posiFastIn[4]]], 32, 32,
					null);
		if (liberarFastBarIn[5] == 1)
			g.drawImage(Potion50reStatusPoison, xFastInven[x[posiFastIn[5]]], yFastInven[y[posiFastIn[5]]], 32, 32,
					null);
		if (liberarFastBarIn[6] == 1)
			g.drawImage(Potion100reStatusPoison, xFastInven[x[posiFastIn[6]]], yFastInven[y[posiFastIn[6]]], 32, 32,
					null);
		if (liberarFastBarIn[7] == 1)
			g.drawImage(PotionFullreStatusPoison, xFastInven[x[posiFastIn[7]]], yFastInven[y[posiFastIn[7]]], 32, 32,
					null);
		if (liberarFastBarIn[8] == 1)
			g.drawImage(Potion25reStatusBurnt, xFastInven[x[posiFastIn[8]]], yFastInven[y[posiFastIn[8]]], 32, 32,
					null);
		if (liberarFastBarIn[9] == 1)
			g.drawImage(Potion50reStatusBurnt, xFastInven[x[posiFastIn[9]]], yFastInven[y[posiFastIn[9]]], 32, 32,
					null);
		if (liberarFastBarIn[10] == 1)
			g.drawImage(Potion100reStatusBurnt, xFastInven[x[posiFastIn[10]]], yFastInven[y[posiFastIn[10]]], 32, 32,
					null);
		if (liberarFastBarIn[11] == 1)
			g.drawImage(PotionFullreStatusBurnt, xFastInven[x[posiFastIn[11]]], yFastInven[y[posiFastIn[11]]], 32, 32,
					null);
	}

	public void usarItem(int pos) {
		String nomeItem = "";
		if (Game.inven.ItensNoInventarioRapido[pos] == "Life Potion Smal") {
			nomeItem = "Life Potion Smal";
			Game.player.life += 20;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Life Potion midium") {
			nomeItem = "Life Potion midium";
			Game.player.life += 50;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Life Potion Big") {
			nomeItem = "Life Potion Big";
			Game.player.life += 100;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Life Potion Full") {
			nomeItem = "Life Potion Full";
			Game.player.life = Game.player.maxLife;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Poison Smal" && Game.ui.poison == true) {
			nomeItem = "Remove Status Poison Smal";
			Game.player.life += 20;
			Game.ui.poison = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Poison midium" && Game.ui.poison == true) {
			nomeItem = "Remove Status Poison midium";
			Game.player.life += 50;
			Game.ui.poison = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Poison Big" && Game.ui.poison == true) {
			nomeItem = "Remove Status Poison Big";
			Game.player.life += 100;
			Game.ui.poison = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Poison Full" && Game.ui.poison == true) {
			nomeItem = "Remove Status Poison Full";
			Game.player.life = Game.player.maxLife;
			Game.ui.poison = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Burnt Smal" && Game.ui.burn == true) {
			nomeItem = "Remove Status Burnt Smal";
			Game.player.life += 20;
			Game.ui.burn = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Burnt midium" && Game.ui.burn == true) {
			nomeItem = "Remove Status Burnt midium";
			Game.player.life += 50;
			Game.ui.burn = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Burnt Big" && Game.ui.burn == true) {
			nomeItem = "Remove Status Burnt Big";
			Game.player.life += 100;
			Game.ui.burn = false;
		} else if (Game.inven.ItensNoInventarioRapido[pos] == "Remove Status Burnt Full" && Game.ui.burn == true) {
			nomeItem = "Remove Status Burnt Full";
			Game.player.life = Game.player.maxLife;
			Game.ui.burn = false;
		}
		diminuirQtPocoes(nomeItem, pos);
	}

	private void diminuirQtPocoes(String item, int pos) {
		for (int i = 0; i < Game.inven.ItensNoInventarioPocoes.length; i++) {
			if (item == Game.inven.ItensNoInventarioPocoes[i]) {
				Game.inven.qtItensPocoes[i]--;
				Game.inven.qtItensBarraRapida[pos]--;
			}
		}
	}

	public void verQtPocao() {
		for (int i = 0; i < Game.inven.ItensNoInventarioPocoes.length; i++) {
			if (Game.inven.qtItensPocoes[i] == 0) {
				if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Smal") {
					liberarInventario[0] = -1;
					liberarFastBar[0] = -1;
					has[0] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion midium") {
					liberarInventario[1] = -1;
					liberarFastBar[1] = -1;
					has[1] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Big") {
					liberarInventario[2] = -1;
					liberarFastBar[2] = -1;
					has[2] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Life Potion Full") {
					liberarInventario[3] = -1;
					liberarFastBar[3] = -1;
					has[3] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Smal") {
					liberarInventario[4] = -1;
					liberarFastBar[4] = -1;
					has[4] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison midium") {
					liberarInventario[5] = -1;
					liberarFastBar[5] = -1;
					has[5] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Big") {
					liberarInventario[6] = -1;
					liberarFastBar[6] = -1;
					has[6] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Poison Full") {
					liberarInventario[7] = -1;
					liberarFastBar[7] = -1;
					has[7] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Smal") {
					liberarInventario[8] = -1;
					liberarFastBar[8] = -1;
					has[8] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt midium") {
					liberarInventario[9] = -1;
					liberarFastBar[9] = -1;
					has[9] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Big") {
					liberarInventario[10] = -1;
					liberarFastBar[10] = -1;
					has[10] = false;
				} else if (Game.inven.ItensNoInventarioPocoes[i] == "Remove Status Burnt Full") {
					liberarInventario[11] = -1;
					liberarFastBar[11] = -1;
					has[11] = false;
				}
				Game.inven.ItensNoInventarioPocoes[i] = null;
			}
		}
		for (int i = 0; i < Game.inven.ItensNoInventarioRapido.length; i++) {
			if (Game.inven.qtItensBarraRapida[i] == 0) {
				hideFastBar(Game.inven.ItensNoInventarioRapido[i]);
				hideFastBarInv(Game.inven.ItensNoInventarioRapido[i]);
				Game.inven.ItensNoInventarioRapido[i] = null;
			}
		}
	}
}

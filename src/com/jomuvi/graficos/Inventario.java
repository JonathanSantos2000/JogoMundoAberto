package com.jomuvi.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import com.jomuvi.main.Drops;
import com.jomuvi.main.Game;

public class Inventario {
	public ItensPocoes itens = new ItensPocoes();
	public static boolean isSelecionado = false;
	public static BufferedImage Player = Game.spritesheet.getSprite(32, 0, 16, 16);
	public static BufferedImage CoinsGold = Game.spritesheetItens.getSprite(00 * 00, 6 * 16, 16, 16);
	public static BufferedImage CoinsSilver = Game.spritesheetItens.getSprite(01 * 16, 6 * 16, 16, 16);
	public static BufferedImage CoinsBronze = Game.spritesheetItens.getSprite(02 * 16, 6 * 16, 16, 16);
	public static BufferedImage WhiteSpace = Game.numerosInventario.getSprite(3 * 31, 0, 32, 32);

	public static BufferedImage selecionado = Game.selecionado.getSprite(94, 0, 32, 32);

	public static BufferedImage TextBox = Game.selecionado.getSprite(0, 0, 3 * 31 + 1, 2 * 31 + 1);

	public static BufferedImage bloqueado = Game.selecionado.getSprite(94, 32, 32, 32);

	public static BufferedImage WhiteSpaceHelmet = Game.numerosInventario.getSprite(3 * 31, 2 * 31, 32, 32);
	public static BufferedImage WhiteSpaceChest = Game.numerosInventario.getSprite(0, 2 * 31, 32, 32);
	public static BufferedImage WhiteSpaceLegs = Game.numerosInventario.getSprite(31, 2 * 31, 32, 32);
	public static BufferedImage WhiteSpaceBoots = Game.numerosInventario.getSprite(2 * 31, 2 * 31, 32, 32);
	public static BufferedImage WhiteSpaceGuns = Game.numerosInventario.getSprite(3 * 31, 31, 32, 32);
//-------
	public static BufferedImage Info = Game.spritesheetItens.getSprite(8 * 16, 9 * 16, 16, 16);
	public static BufferedImage mais = Game.spritesheetItens.getSprite(07 * 16, 9 * 16, 16, 16);
	public static BufferedImage menos = Game.spritesheetItens.getSprite(6 * 16, 9 * 16, 16, 16);
	public String[] infLinha1 = { "Clique no (U)"/**/, "Use as setas"/*   */, "Use as teclas" };
	public String[] infLinha2 = { "para usar o"/*  */, "para selecionar"/**/, "(A) para Voltar" };
	public String[] infLinha3 = { "item."/*        */, "o item mais o"/*  */, "e (D) para" };
	public String[] infLinha4 = { ""/*             */, "numero da "/*     */, "avançar uma " };
	public String[] infLinha5 = { ""/*             */, "Barra Rapida"/*   */, "categoria" };
	public int curretInf = 0;
	public boolean ShowInfo = false;
// ---
	public String[] optionsPA = { "Poções", "Armas", "Munições" };
	public int curretOpitionPA = 0;
	public int maxOpitionPA = optionsPA.length - 1;
	// ---
	public String nome = " ", dano = " ", efeito = " ", efeitoline2 = " ";
	public String[] ItensNoInventarioRapido = new String[6];
	public int[] qtItensBarraRapida = new int[6];
	// ---
	public String[] ItensNoInventarioPocoes = new String[9];
	public int[] qtItensPocoes = new int[9];
	// ---
	public String[] itensNoInventarioArmas = new String[9];
	public int posicaoArma;
	public String armaEquipada;
	// ---
	public String[] ItensNoInventarioMunicao = new String[9];
	public int[] qtItensMunicao = new int[9];
	public String municaoEquipada;
	// ---
	public int curretOpition = 0;
	public int maxOpition = ItensNoInventarioPocoes.length - 1;
	// ---
	public boolean left, right, up, down, enter, A, D, sell, buy;
	// ---
	public void tick() {
		Game.SDM.converterMoedas();

		if (A) {
			A = false;
			curretOpitionPA--;
			curretOpition = 0;
			if (curretOpitionPA < 0) {
				curretOpitionPA = maxOpitionPA;
			}
		}
		if (D) {
			D = false;
			curretOpitionPA++;
			curretOpition = 0;
			if (curretOpitionPA > maxOpitionPA) {
				curretOpitionPA = 0;
			}
		}

		if (left) {
			left = false;
			curretOpition--;
			if (curretOpition < 0) {
				curretOpition = maxOpition;
			}
		}
		if (right) {
			right = false;
			curretOpition++;
			if (curretOpition > maxOpition) {
				curretOpition = 0;
			}
		}
		if (up) {
			up = false;
			curretOpition -= 3;

			/*   */if (curretOpition < 0 && (curretOpition + 3) == 0) {
				curretOpition = 6;
			} else if (curretOpition < 0 && (curretOpition + 3) == 1) {
				curretOpition = 7;
			} else if (curretOpition < 0 && (curretOpition + 3) == 2) {
				curretOpition = 8;
			}
		}
		if (down) {
			down = false;
			curretOpition += 3;
			/*   */if (curretOpition > maxOpition && (curretOpition - 3) == 6) {
				curretOpition = 0;
			} else if (curretOpition > maxOpition && (curretOpition - 3) == 7) {
				curretOpition = 1;
			} else if (curretOpition > maxOpition && (curretOpition - 3) == 8) {
				curretOpition = 2;
			}
		}
		if (enter) {
			enter = false;
			if (optionsPA[curretOpitionPA] == "Armas") {
				armaEquipada = itensNoInventarioArmas[curretOpition];
				posicaoArma = curretOpition;
				municaoEquipada = armaEquipada;
				ItensArmer.findPosition(armaEquipada);
			}
		}

	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		// Item
		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 6) - 55, (Game.HEIGHT / 2) - 110, (Game.WIDTH / 3) + 80, (Game.HEIGHT / 2) + 60);
		// linha 1
		// Coluna 1
		if (Game.inven.ItensNoInventarioRapido[0] == null) {
			g.drawImage(UI.n1, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 105, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN1, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 105, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + qtItensBarraRapida[0], (Game.WIDTH / 2) - 134, (Game.HEIGHT / 2) - 75);
		}
		// Coluna 2
		/**/if (Game.inven.ItensNoInventarioRapido[1] == null) {
			g.drawImage(UI.n2, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 105, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN2, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 105, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + qtItensBarraRapida[1], (Game.WIDTH / 2) - 98, (Game.HEIGHT / 2) - 75);
		}
		// Coluna 3
		/**/if (Game.inven.ItensNoInventarioRapido[2] == null) {
			g.drawImage(UI.n3, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 105, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN3, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 105, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + Game.inven.qtItensBarraRapida[2], (Game.WIDTH / 2) - 62, (Game.HEIGHT / 2) - 75);
		}
// linha 2
		// Coluna 1
		/**/if (Game.inven.ItensNoInventarioRapido[3] == null) {
			g.drawImage(UI.n4, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 69, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN4, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 69, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + Game.inven.qtItensBarraRapida[3], (Game.WIDTH / 2) - 134, (Game.HEIGHT / 2) - 39);
		}
		// Coluna 2
		/**/if (Game.inven.ItensNoInventarioRapido[4] == null) {
			g.drawImage(UI.n5, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 69, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN5, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 69, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + Game.inven.qtItensBarraRapida[4], (Game.WIDTH / 2) - 98, (Game.HEIGHT / 2) - 39);
		}
		// Coluna 3
		/**/if (Game.inven.ItensNoInventarioRapido[5] == null) {
			g.drawImage(UI.n6, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 69, 32, 32, null);
		} else {
			g.drawImage(UI.barraRapidaN6, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 69, 32, 32, null);
			g.setColor(new Color(219, 219, 112));
			g.drawString("" + Game.inven.qtItensBarraRapida[5], (Game.WIDTH / 2) - 62, (Game.HEIGHT / 2) - 39);
		}
		for (int i = 0; i < ItensNoInventarioRapido.length; i++) {
			if (ItensNoInventarioRapido[i] != null) {
				Game.invenPotions.fastBarRenderIn(g);
			}
		}
//		dentro inventario;
		g.setFont(new Font("arial", Font.BOLD, 9));
		if (optionsPA[curretOpitionPA] == "Poções") {
			g.setColor(new Color(219, 219, 112));
			g.drawString("Poções", (Game.WIDTH / 6) - 47, (Game.HEIGHT / 2) - 28);
			g.setColor(Color.WHITE);
			g.drawString("Armas", (Game.WIDTH / 6) + 10, (Game.HEIGHT / 2) - 28);
		} else if (optionsPA[curretOpitionPA] == "Armas") {
			g.setColor(new Color(219, 219, 112));
			g.drawString("Armas", (Game.WIDTH / 6) - 47, (Game.HEIGHT / 2) - 28);
			g.setColor(Color.WHITE);
			g.drawString("Munições", (Game.WIDTH / 6) + 10, (Game.HEIGHT / 2) - 28);
		} else if (optionsPA[curretOpitionPA] == "Munições") {
			g.setColor(new Color(219, 219, 112));
			g.drawString("Munições", (Game.WIDTH / 6) - 47, (Game.HEIGHT / 2) - 28);
			g.setColor(Color.WHITE);
			g.drawString("Poções", (Game.WIDTH / 6) + 10, (Game.HEIGHT / 2) - 28);
		}
		// Coluna 1
		if (curretOpition == 0 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 27, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 27, 32, 32, null);
		}
		// Coluna 2
		if (curretOpition == 1 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 27, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) - 27, 32, 32, null);
		}
		// Coluna 3
		if (curretOpition == 2 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 27, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) - 27, 32, 32, null);
		}
// linha 4
		// Coluna 1
		if (curretOpition == 3 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 9, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 9, 32, 32, null);
		}
		// Coluna 2
		if (curretOpition == 4 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) + 9, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) + 9, 32, 32, null);
		}
		// Coluna 3
		if (curretOpition == 5 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) + 9, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) + 9, 32, 32, null);
		}
// linha 5
		// Coluna 1
		if (curretOpition == 6 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 45, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 45, 32, 32, null);
		}
		// Coluna 2
		if (curretOpition == 7 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) + 45, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 124, (Game.HEIGHT / 2) + 45, 32, 32, null);
		}
		// Coluna 3
		if (curretOpition == 8 && !isSelecionado) {
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) + 45, 32, 32, null);
		} else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) - 88, (Game.HEIGHT / 2) + 45, 32, 32, null);
		}
		if (optionsPA[curretOpitionPA] == "Poções") {
			Game.invenPotions.renderInventario(g);
		} else if (optionsPA[curretOpitionPA] == "Armas") {
			Game.invenArmer.renderInventario(g);
		} else if (optionsPA[curretOpitionPA] == "Munições") {
			Game.invenMuni.renderInventario(g);
		}

		// Player

//		Armaduras e armas Player 
		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 2) + 32, (Game.HEIGHT / 2) - 110, 38, (Game.HEIGHT / 2) + 58);
		// Coluna 6
		g.drawImage(WhiteSpaceHelmet, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) - 105, 32, 32, null);
		// Coluna 6
		g.drawImage(WhiteSpaceChest, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) - 69, 32, 32, null);
		// Coluna 6
		g.drawImage(WhiteSpaceLegs, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) - 33, 32, 32, null);
		// Coluna 6
		g.drawImage(WhiteSpaceBoots, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 3, 32, 32, null);
		// Coluna 6

		if (armaEquipada == null)
			g.drawImage(WhiteSpaceGuns, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 39, 32, 32, null);
		else {
			g.drawImage(WhiteSpace, (Game.WIDTH / 2) + 35, (Game.HEIGHT / 2) + 39, 32, 32, null);
			Game.invenArmer.renderEquipado(g);
		}

//------------------------------

		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) - 110, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) + 11);
		g.drawImage(Player, (Game.WIDTH / 2) + 55, (Game.HEIGHT / 2) - 100, 7 * 16, 7 * 16, null);

		// level
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 13));
		g.drawString("level " + Game.player.nivel, (Game.WIDTH / 2) + 84, (Game.HEIGHT / 2) + 30);

		// Vida
		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 31, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) - 120);

		g.setColor(Color.green);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 31, (int) ((Game.player.life / Game.player.maxLife) * 72),
				(Game.HEIGHT / 2) - 120);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("vida " + (int) UI.vida + "%", (Game.WIDTH / 2) + 80, (Game.HEIGHT / 2) + 40);

		// Level
		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 42, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) - 120);

		g.setColor(Color.green);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 42, (int) ((Game.player.xp / Game.player.maxXp) * 72),
				(Game.HEIGHT / 2) - 120);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("xp " + (int) UI.xp + "%", (Game.WIDTH / 2) + 80, (Game.HEIGHT / 2) + 51);
		// dano

		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 54, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) - 120);
		g.setColor(new Color(219, 219, 112));
		g.drawString("Dano " + com.jomuvi.entities.Player.dano, (Game.WIDTH / 2) + 80, (Game.HEIGHT / 2) + 62);

		// Parte moeda
		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 2) + 30, (Game.HEIGHT / 2) + 107, (Game.WIDTH / 2) - 32, 18);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));

		g.drawImage(CoinsGold, (Game.WIDTH / 2) + 31, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsGold, (Game.WIDTH / 2) + 48, (Game.HEIGHT / 2) + 120);

		g.drawImage(CoinsSilver, (Game.WIDTH / 2) + 88, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsSilver, (Game.WIDTH / 2) + 105, (Game.HEIGHT / 2) + 120);

		g.drawImage(CoinsBronze, (Game.WIDTH / 2) + 128, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsBronze, (Game.WIDTH / 2) + 145, (Game.HEIGHT / 2) + 120);
//	descrição ---------------------------------------------------------------------------------------------------
		g.drawImage(TextBox, (Game.WIDTH / 6) - 55, (Game.HEIGHT / 2) + 80, (Game.WIDTH / 3) + 80,
				(Game.HEIGHT / 2) - 85, null);
		if (optionsPA[curretOpitionPA] == "Poções") {
			if (ItensNoInventarioPocoes[curretOpition] == null) {
				this.nome = " ";
				this.efeito = " ";
				this.efeitoline2 = " ";
			}
		}
		if (optionsPA[curretOpitionPA] == "Armas") {
			if (itensNoInventarioArmas[curretOpition] == null) {
				this.nome = " ";
				this.efeito = " ";
				this.efeitoline2 = " ";
			}
		}
		if (optionsPA[curretOpitionPA] == "Munições") {
			if (ItensNoInventarioMunicao[curretOpition] == null) {
				this.nome = " ";
				this.efeito = " ";
				this.efeitoline2 = " ";
			}
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 9));
		g.drawString("Nome: " + this.nome, (Game.WIDTH / 6) - 53, (Game.HEIGHT / 2) + 90);
		if (optionsPA[curretOpitionPA] == "Poções") {
			g.drawString("Efeito: " + this.efeito, (Game.WIDTH / 6) - 53, (Game.HEIGHT / 2) + 100);
			g.drawString("" + this.efeitoline2, (Game.WIDTH / 6) - 21, (Game.HEIGHT / 2) + 110);
			g.drawString("Qt: " + this.qtItensPocoes[curretOpition], (Game.WIDTH / 6) - 53, (Game.HEIGHT / 2) + 122);
		} else if (optionsPA[curretOpitionPA] == "Armas") {
			if (itensNoInventarioArmas[curretOpition] != null)
				g.drawString(this.nome + " da " + this.dano + "de dano base", (Game.WIDTH / 6) - 50,
						(Game.HEIGHT / 2) + 100);
		} else if (optionsPA[curretOpitionPA] == "Munições") {
			if (ItensNoInventarioMunicao[curretOpition] != null) {
				g.drawString(this.nome + " da " + this.dano + "de dano base", (Game.WIDTH / 6) - 50,
						(Game.HEIGHT / 2) + 100);
			}
			g.drawString("Qt: " + this.qtItensMunicao[curretOpition], (Game.WIDTH / 6) - 53, (Game.HEIGHT / 2) + 122);
		}
//----------------------------------------------------------------------------------------------------------------

		// Textos
		g.drawImage(menos, (Game.WIDTH / 2) - 45, (Game.HEIGHT / 2) - 105, 16, 16, null);
		g.drawImage(Info, (Game.WIDTH / 2) - 23, (Game.HEIGHT / 2) - 105, 16, 16, null);
		g.drawImage(mais, (Game.WIDTH / 2) - 1, (Game.HEIGHT / 2) - 105, 16, 16, null);

		if (ShowInfo) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 10));
			g.setColor(Color.RED);
			g.fillRect((Game.WIDTH / 2) - 54, (Game.HEIGHT / 2) - 80, (Game.WIDTH / 2) - 95, 121);
			g.setColor(Color.black);
			g.fillRect((Game.WIDTH / 2) - 52, (Game.HEIGHT / 2) - 77, (Game.WIDTH / 2) - 99, 115);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 9));
			// ---
			/**/g.drawString(infLinha1[curretInf], (Game.WIDTH / 2) - 52, (Game.HEIGHT / 2) - 65);
			/**/g.drawString(infLinha2[curretInf], (Game.WIDTH / 2) - 51, (Game.HEIGHT / 2) - 54);
			/**/g.drawString(infLinha3[curretInf], (Game.WIDTH / 2) - 51, (Game.HEIGHT / 2) - 43);
			/**/g.drawString(infLinha4[curretInf], (Game.WIDTH / 2) - 51, (Game.HEIGHT / 2) - 35);
			/**/g.drawString(infLinha5[curretInf], (Game.WIDTH / 2) - 52, (Game.HEIGHT / 2) - 25);
			// ---
		}

		AffineTransform at = new AffineTransform();
		at.setToRotation(Math.toRadians(-90), 80, 100);
		g2.setTransform(at);
		g2.drawString("Barra Rapida", (Game.WIDTH / 6) + 32, (Game.HEIGHT / 2) - 102);
		g2.drawString("Inventario", (Game.WIDTH / 6) - 50, (Game.HEIGHT / 2) - 102);
	}

}

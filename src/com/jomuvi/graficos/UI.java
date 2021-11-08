package com.jomuvi.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.jomuvi.entities.Player;
import com.jomuvi.main.Game;

public class UI {
	private int framesGameOver = 0;
	private boolean showMessageGame = true;

	public BufferedImage headGuarison;
	public BufferedImage HeadPlayer;
	public BufferedImage Bag;
	public static BufferedImage heart;
	public static BufferedImage heartPoison;
	public static BufferedImage heartFlame;
	public static BufferedImage exPont;
//	public BufferedImage backgroundMiniMapa;
	private int[] placeStatus = { (Game.WIDTH / 2) - 170, (Game.WIDTH / 2) - 155 };
	public boolean lockStatusPoison = false, lockStatusBurn = false;

	public static BufferedImage n1;
	public static BufferedImage n2;
	public static BufferedImage n3;
	public static BufferedImage n4;
	public static BufferedImage n5;
	public static BufferedImage n6;

	public static BufferedImage barraRapidaN1;
	public static BufferedImage barraRapidaN2;
	public static BufferedImage barraRapidaN3;
	public static BufferedImage barraRapidaN4;
	public static BufferedImage barraRapidaN5;
	public static BufferedImage barraRapidaN6;

	public String[] options = { "Pegar kit" };
	public int curretOpition = 0;
	public int maxOpition = options.length - 1;
	public boolean enter;
	// CutScene
	public static double vida, xp, lastMaxP;
	public int pagina = 0, maxPaginas = 7;
	public boolean showConversa = true, showFastBar = false;
	private int framesPoV = 0;

	public String[] ItensNoInventario = new String[6];

//  --------poison 
	public boolean poison = false, isDamagedPoison = false;
	private int framesPoison = 0, maxframesPoison = 10;
	private int framesDamagedPoison = 0, maxframesDamagedPoison = 60;
//  --------Burns
	public boolean burn = false, isDamagedBurn = false;
	private int framesBurn = 0, maxframesBurn = 10;
	private int framesDamagedBurn = 0, maxframesDamagedBurn = 60;

	public void tick() {
		if (enter) {
			enter = false;
			if (options[curretOpition] == "Pegar kit") {
				Game.modoDeJogo = "NORMAL";
//				---
				Game.inven.ItensNoInventarioPocoes[0] = "Life Potion Smal";
				Game.inven.qtItensPocoes[0] = 5;
				Game.invenPotions.addImg();
//				---
				Game.inven.itensNoInventarioArmas[0] = "pistol";
				Game.inven.armaEquipada = "pistol";
				Game.invenArmer.addImg();
				ItensArmer.findPosition(Game.inven.armaEquipada);
//				---
				Game.inven.ItensNoInventarioMunicao[0] = "pistol";
				Game.inven.qtItensMunicao[0] = 20;
				Game.inven.municaoEquipada = "pistol";
				Game.invenMuni.addImg();
			}
		}

		if (Game.modoDeJogo == "CUTSCENE") {
			if (showConversa == true)
				this.framesPoV++;
			if (framesPoV == 150) {
				this.framesPoV = 0;
				pagina++;
				if (pagina >= maxPaginas) {
					showConversa = false;
				}
			}
		}

		if (Game.gameState == "GAME_OVER") {
			this.framesGameOver++;
			if (framesGameOver == 25) {
				this.framesGameOver = 0;
				if (showMessageGame) {
					showMessageGame = false;
				} else {
					showMessageGame = true;
				}
			}
		}
		if (poison) {
			this.framesPoison++;
			isDamagedPoison = false;
			if (this.framesPoison == this.maxframesPoison) {
				framesDamagedPoison++;
				if (this.framesDamagedPoison == this.maxframesDamagedPoison) {
					framesDamagedPoison = 0;
					Game.player.life = Game.player.life - 1;
				}
				framesPoison = 0;
				isDamagedPoison = true;
			}
		}
		if (burn) {
			this.framesBurn++;
			isDamagedBurn = false;
			if (this.framesBurn == this.maxframesBurn) {
				framesDamagedBurn++;
				if (this.framesDamagedBurn == this.maxframesDamagedBurn) {
					framesDamagedBurn = 0;
					Game.player.life = Game.player.life - 1;
				}
				framesBurn = 0;
				isDamagedBurn = true;
			}
		}

		// --final
	}

	public void render(Graphics g) {
		headGuarison = Game.spritesheetNPC.getSprite(6 * 16, 00 * 00, 16, 16);
		HeadPlayer = Game.spritesheetNPC.getSprite(7 * 16, 00 * 00, 16, 16);
		Bag = Game.spritesheetItens.getSprite(9 * 16, 9 * 16, 16, 16);
		heart = Game.spritesheetItens.getSprite(0, 9 * 16, 16, 16);
		heartPoison = Game.spritesheetItens.getSprite(03 * 16, 9 * 16, 16, 16);
		heartFlame = Game.spritesheetItens.getSprite(04 * 16, 9 * 16, 16, 16);
		exPont = Game.spritesheetItens.getSprite(01 * 16, 9 * 16, 16, 16);

		n1 = Game.numerosInventario.getSprite(0, 0, 32, 32);
		barraRapidaN1 = Game.BarraRapida.getSprite(0, 0, 32, 32);
		n2 = Game.numerosInventario.getSprite(31, 0, 32, 32);
		barraRapidaN2 = Game.BarraRapida.getSprite(31, 0, 32, 32);
		n3 = Game.numerosInventario.getSprite(2 * 31, 0, 32, 32);
		barraRapidaN3 = Game.BarraRapida.getSprite(2 * 31, 0, 32, 32);
		n4 = Game.numerosInventario.getSprite(0, 31, 32, 32);
		barraRapidaN4 = Game.BarraRapida.getSprite(0, 31, 32, 32);
		n5 = Game.numerosInventario.getSprite(31, 31, 32, 32);
		barraRapidaN5 = Game.BarraRapida.getSprite(31, 31, 32, 32);
		n6 = Game.numerosInventario.getSprite(2 * 31, 31, 32, 32);
		barraRapidaN6 = Game.BarraRapida.getSprite(2 * 31, 31, 32, 32);

//		backgroundMiniMapa = Game.spritesheetBlocos.getSprite(8 * 16, 8 * 16, 32, 32);

		if (Game.gameState == "NORMAL") {
			Graphics2D g2 = (Graphics2D) g;
			if (Game.modoDeJogo == "NORMAL") {
				if (Game.ShowUI) {

//   ______________________
//  |					   |
//  |       MiniMapa       |
//  |______________________|
//
//					g.drawImage(backgroundMiniMapa, (Game.WIDTH / 2) - 167, (Game.HEIGHT / 2) - 127,
//							(Game.WIDTH / 4) + 4, (Game.HEIGHT / 4) + 5, null);
////				World.renderMinimapa("/NormalCompra.png");
//					g.drawImage(Game.minimapa, (Game.WIDTH / 2) - 165, (Game.HEIGHT / 2) - 125, (Game.WIDTH / 4),
//							(Game.HEIGHT / 4), null);

//   ______________________				
//  |					   |
//  |        status        |
//  |______________________|
//		

					if (poison) {
						if (!isDamagedPoison) {
							if (!burn || lockStatusPoison) {
								g.drawImage(heartPoison, placeStatus[0], (Game.HEIGHT / 2) + 76, 16, 16, null);
								lockStatusPoison = true;
							} else if (lockStatusBurn) {
								g.drawImage(heartPoison, placeStatus[1], (Game.HEIGHT / 2) + 76, 16, 16, null);
							}
						}
					}
					if (burn) {
						if (!isDamagedBurn) {
							if (!poison || lockStatusBurn) {
								g.drawImage(heartFlame, placeStatus[0], (Game.HEIGHT / 2) + 76, 16, 16, null);
								lockStatusBurn = true;
							} else if (lockStatusPoison) {
								g.drawImage(heartFlame, placeStatus[1], (Game.HEIGHT / 2) + 76, 16, 16, null);
							}
						}
					}

//   ______________________				
//  |					   |
//  |         Vida         |
//  |______________________|
//
					g2.setColor(new Color(0, 0, 0, 100));
					g.fillRect((Game.WIDTH / 2) - 170, (Game.HEIGHT / 2) + 92, 70, 37);

					vida = (Game.player.life * 100) / Game.player.maxLife;
					xp = (Game.player.xp * 100) / Game.player.maxXp;
//*****
					g.drawImage(heart, (Game.WIDTH / 2) - 170, (Game.HEIGHT / 2) + 92, 16, 16, null);

					g.setColor(Color.RED);
					g.fillRect((Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 103, 50, 3);

					g.setColor(Color.green);
					g.fillRect((Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 103,
							(int) ((Game.player.life / Game.player.maxLife) * 50), 3);

					g.setColor(Color.WHITE);
					g.setFont(new Font("arial", Font.BOLD, 9));
					g.drawString((int) vida + "%", (Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 102);
//   ______________________
//  |                      |
//  |          XP          |
//  |______________________|
					//

					g.drawImage(exPont, (Game.WIDTH / 2) - 170, (Game.HEIGHT / 2) + 111, 16, 16, null);

					g.setColor(Color.RED);
					g.fillRect((Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 123, 50, 3);

					g.setColor(Color.green);
					g.fillRect((Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 123,
							(int) ((Game.player.xp / Game.player.maxXp) * 50), 3);

					g.setColor(Color.WHITE);
					g.setFont(new Font("arial", Font.BOLD, 9));
					g.drawString((int) xp + "%", (Game.WIDTH / 2) - 154, (Game.HEIGHT / 2) + 122);

//   ______________________
//  |					   |
//  |       Muni��o	       |
//	|______________________|
//

					g2.setColor(new Color(0, 0, 0, 100));
					g.fillRect((Game.WIDTH / 2) + 115, (Game.HEIGHT / 2) + 93, 60, 35);
					if (Game.inven.armaEquipada != null) {
						Game.invenArmer.renderUI(g);
					}
					if (Game.inven.municaoEquipada != null) {
						Game.invenMuni.renderUI(g);
					}
//				

					g.setColor(Color.WHITE);
					g.setFont(new Font("arial", Font.BOLD, 10));
					g.drawString("X " + Player.ammo, (Game.WIDTH / 2) + 118, (Game.HEIGHT / 2) + 120);

//   ______________________
//  |					   |
//  |       Itens na       |
//	|          M�o         |
//  |______________________|
					g.setColor(Color.WHITE);
					g.setFont(new Font("arial", Font.BOLD, 8));
					g.drawImage(Bag, (Game.WIDTH / 2) + 115, (Game.HEIGHT / 2) + 95, 16, 16, null);

					g.drawString("E ", (Game.WIDTH / 2) + 128, (Game.HEIGHT / 2) + 100);

					/**/if (Game.inven.ItensNoInventarioRapido[0] == null) {
						g.drawImage(n1, (Game.WIDTH / 2) - 97, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN1, (Game.WIDTH / 2) - 97, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[0], (Game.WIDTH / 2) - 72,
								(Game.HEIGHT / 2) + 123);
					}
					/**/if (Game.inven.ItensNoInventarioRapido[1] == null) {
						g.drawImage(n2, (Game.WIDTH / 2) - 62, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN2, (Game.WIDTH / 2) - 62, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[1], (Game.WIDTH / 2) - 37,
								(Game.HEIGHT / 2) + 123);
					}
					/**/if (Game.inven.ItensNoInventarioRapido[2] == null) {
						g.drawImage(n3, (Game.WIDTH / 2) - 27, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN3, (Game.WIDTH / 2) - 27, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[2], (Game.WIDTH / 2) - 2,
								(Game.HEIGHT / 2) + 123);
					}
					/**/if (Game.inven.ItensNoInventarioRapido[3] == null) {
						g.drawImage(n4, (Game.WIDTH / 2) + 8, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN4, (Game.WIDTH / 2) + 8, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[3], (Game.WIDTH / 2) + 33,
								(Game.HEIGHT / 2) + 123);
					}
					/**/if (Game.inven.ItensNoInventarioRapido[4] == null) {
						g.drawImage(n5, (Game.WIDTH / 2) + 43, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN5, (Game.WIDTH / 2) + 43, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[4], (Game.WIDTH / 2) + 68,
								(Game.HEIGHT / 2) + 123);
					}
					/**/if (Game.inven.ItensNoInventarioRapido[5] == null) {
						g.drawImage(n6, (Game.WIDTH / 2) + 78, (Game.HEIGHT / 2) + 93, 32, 32, null);
					} else {
						g.drawImage(barraRapidaN6, (Game.WIDTH / 2) + 78, (Game.HEIGHT / 2) + 93, 32, 32, null);
						g.setColor(new Color(219, 219, 112));
						g.drawString("" + Game.inven.qtItensBarraRapida[5], (Game.WIDTH / 2) + 103,
								(Game.HEIGHT / 2) + 123);
					}

					if (showFastBar) {
						Game.invenPotions.fastBarRender(g);
					}
				}
			} else if (Game.modoDeJogo == "CUTSCENE") {
				g2.setColor(new Color(0, 0, 0, 150));
				g.fillRect(0, Game.HEIGHT - (Game.HEIGHT / 4), Game.WIDTH, (Game.HEIGHT / 2) / 2);

				if (pagina < 7) {
					g.drawImage(headGuarison, 5, Game.HEIGHT - (Game.HEIGHT / 4) + 5, 32, 32, null);
				}
				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 10));
				if (pagina == 0) {
					g.drawString("Bem vindo soldado!", (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));
					g.drawString("Estamos em um APOCALIPSE ZOMBIE", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 1) {
					g.drawString("Fora desses cercas existem varias ", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 15) - (Game.HEIGHT / 4));
					g.drawString("ordas ZOMBIE.", (Game.WIDTH / 5) - 3, (Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 2) {
					g.drawString("Nosso maior objetivo � eliminar ", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 15) - (Game.HEIGHT / 4));
					g.drawString("todas essas ordas ZOMBIES", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 3) {
					g.drawString("Ao matar los h� uma chance de", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 10) - (Game.HEIGHT / 4));
					g.drawString("cair alguns itens como 'Moedas',", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 21) - (Game.HEIGHT / 4));
					g.drawString("'Armas','Muni��es','Kits Medicos'", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 31) - (Game.HEIGHT / 4));
				} else if (pagina == 4) {
					g.drawString("BOA SORTE........", (Game.WIDTH / 5) - 3, (Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 5) {
					g.drawString("Ah!! mas uma coisa!", (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));
					g.drawString("Nosso acampamento n�o esta longe ", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 6) {
					g.drawString("caso queira ir la VOLTE AT� MIM", (Game.WIDTH / 5) - 3,
							(Game.HEIGHT + 25) - (Game.HEIGHT / 4));
				} else if (pagina == 7) {
					g.drawImage(HeadPlayer, Game.WIDTH - (Game.WIDTH / 4), Game.HEIGHT - (Game.HEIGHT / 4), 32, 32,
							null);
					g.drawString("Pegar kit", (Game.WIDTH / 5) - 3, (Game.HEIGHT + 15) - (Game.HEIGHT / 4));

					g.setColor(new Color(219, 219, 112));
					g.setFont(new Font("arial", Font.BOLD, 12));
					if (options[curretOpition] == "Pegar kit") {
						g.drawString(">", (Game.WIDTH / 5) - 11, (Game.HEIGHT + 15) - (Game.HEIGHT / 4) + 1);
					}
				}
			}
		} else if (Game.gameState == "GAME_OVER") {

			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(new Color(0, 0, 0, 100));
			g2.fillRect(0, 0, Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE);

			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 15));
			g.drawString("GAME OVER", 80, (Game.HEIGHT / 2) - 10);

			if (showMessageGame) {
				g.setFont(new Font("arial", Font.BOLD, 10));
				g.drawString("> Press space to restart <", 62, (Game.HEIGHT / 2) + 10);
			}

		} else if (Game.gameState == "MENU") {
			Game.menu.render(g);
		} else if (Game.gameState == "TRASICAO") {
			Game.transi.render(g);
		}

	}
}

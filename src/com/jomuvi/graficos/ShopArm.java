package com.jomuvi.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.jomuvi.main.Drops;
import com.jomuvi.main.Game;

public class ShopArm {
	// ---
	public String[] optionsPA = { "Armas", "Munições" };

	public String nome = " ", vendeSe = " ", moedaVendeSe = " ", compreSe = " ", moedaCompreSe = " ", efeito = " ",
			efeitoline2 = " ";

	public int curretOpitionPA = 0;
	public int maxOpitionPA = optionsPA.length - 1;
	// ---
	public int curretOpition = 0;
	public int maxOpition = ItensArmer.options.length - 1;
	public boolean left, right, up, down, A, D, sell, buy;

	public static boolean selecionado = false;

	public void tick() {
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
		if (up) {
			up = false;
			curretOpition -= 4;

			if (curretOpition < 0 && (curretOpition + 4) == 0) {
				curretOpition = 8;
			} else if (curretOpition < 0 && (curretOpition + 4) == 1) {
				curretOpition = 9;
			} else if (curretOpition < 0 && (curretOpition + 4) == 2) {
				curretOpition = 10;
			} else if (curretOpition < 0 && (curretOpition + 4) == 3) {
				curretOpition = 11;
			}
		}
		if (down) {
			down = false;
			curretOpition += 4;

			if (curretOpition > maxOpition && (curretOpition - 4) == 8) {
				curretOpition = 0;
			} else if (curretOpition > maxOpition && (curretOpition - 4) == 9) {
				curretOpition = 1;
			} else if (curretOpition > maxOpition && (curretOpition - 4) == 10) {
				curretOpition = 2;
			} else if (curretOpition > maxOpition && (curretOpition - 4) == 11) {
				curretOpition = 3;
			}
		}
		if (buy) {
			buy = false;
			if (optionsPA[curretOpitionPA] == "Armas") {
				if (ItensArmer.options[curretOpition] != "bloqueado 1"
						&& ItensArmer.options[curretOpition] != "bloqueado 2"/**/
						&& ItensArmer.options[curretOpition] != "bloqueado 3"
						&& ItensArmer.options[curretOpition] != "bloqueado 4"
						&& ItensArmer.options[curretOpition] != "bloqueado 5"
						&& ItensArmer.options[curretOpition] != "bloqueado 6"
						&& ItensArmer.options[curretOpition] != "bloqueado 7") {
					int valorEmBronze = Game.SDM.vender(ItensArmer.MoedaVendeSe[curretOpition],
							Integer.parseInt(ItensArmer.VendeSe[curretOpition]));
					if (valorEmBronze <= Drops.coinsBase) {
						Game.SDM.descontarMoedas(valorEmBronze);
						for (int i = 0; i < Game.inven.itensNoInventarioArmas.length; i++) {
							if (Game.inven.itensNoInventarioArmas[i] == ItensArmer.options[curretOpition]) {
								break;
							} else {
								if (Game.inven.itensNoInventarioArmas[i] == null) {
									Game.inven.itensNoInventarioArmas[i] = ItensArmer.options[curretOpition];
									Game.invenArmer.addImg();
									Game.inven.ItensNoInventarioMunicao[i] = ItensMunicao.options[curretOpition];
									Game.inven.qtItensMunicao[i] += 100;
									Game.invenMuni.addImg();
									break;
								}
							}
						}
					}
				}
			} else if (optionsPA[curretOpitionPA] == "Munições") {
				if (ItensMunicao.options[curretOpition] != "bloqueado 1"
						&& ItensMunicao.options[curretOpition] != "bloqueado 2"/**/
						&& ItensMunicao.options[curretOpition] != "bloqueado 3"
						&& ItensMunicao.options[curretOpition] != "bloqueado 4"
						&& ItensMunicao.options[curretOpition] != "bloqueado 5"
						&& ItensMunicao.options[curretOpition] != "bloqueado 6"
						&& ItensMunicao.options[curretOpition] != "bloqueado 7") {
					int valorEmBronze = Game.SDM.vender(ItensMunicao.MoedaVendeSe[curretOpition],
							Integer.parseInt(ItensMunicao.VendeSe[curretOpition]));
					if (valorEmBronze <= Drops.coinsBase) {
						Game.SDM.descontarMoedas(valorEmBronze);
						for (int i = 0; i < Game.inven.ItensNoInventarioMunicao.length; i++) {
							if (Game.inven.ItensNoInventarioMunicao[i] == ItensMunicao.options[curretOpition]) {
								Game.inven.qtItensMunicao[i] += 50;
								break;
							} else {
								if (Game.inven.ItensNoInventarioMunicao[i] == null) {
									Game.inven.ItensNoInventarioMunicao[i] = ItensMunicao.options[curretOpition];
									System.out.println(i+"aqui");
									Game.inven.qtItensMunicao[i] += 50;
									Game.invenMuni.addImg();
									break;
								}
							}
						}
					}
				}
			}
		}

		if (sell) {
			sell = false;
		}
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Player

		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) - 110, (Game.WIDTH / 3) - 42, Game.HEIGHT / 2);
		g.drawImage(Inventario.Player, (Game.WIDTH / 2) + 55, (Game.HEIGHT / 2) - 100, 7 * 16, 7 * 16, null);

		// Vida
		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 22, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) - 120);
		g.setColor(Color.green);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 22, (int) ((Game.player.life / Game.player.maxLife) * 72),
				(Game.HEIGHT / 2) - 120);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("HP " + (int) Game.player.life + " / " + (int) Game.player.maxLife, (Game.WIDTH / 2) + 72,
				(Game.HEIGHT / 2) + 30);

		// Level
		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 35, (Game.WIDTH / 3) - 42, (Game.HEIGHT / 2) - 120);
		g.setColor(Color.green);
		g.fillRect((Game.WIDTH / 2) + 72, (Game.HEIGHT / 2) + 35, (int) ((Game.player.xp / Game.player.maxXp) * 72),
				(Game.HEIGHT / 2) - 120);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("XP " + (int) Game.player.xp + " / " + (int) Game.player.maxXp, (Game.WIDTH / 2) + 72,
				(Game.HEIGHT / 2) + 43);

		// Parte moeda
		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 2) + 10, (Game.HEIGHT / 2) + 107, (Game.WIDTH / 2) - 20, 18);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));

		g.drawImage(Inventario.CoinsGold, (Game.WIDTH / 2) + 12, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsGold, (Game.WIDTH / 2) + 30, (Game.HEIGHT / 2) + 120);

		g.drawImage(Inventario.CoinsSilver, (Game.WIDTH / 2) + 62, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsSilver, (Game.WIDTH / 2) + 80, (Game.HEIGHT / 2) + 120);

		g.drawImage(Inventario.CoinsBronze, (Game.WIDTH / 2) + 112, (Game.HEIGHT / 2) + 108, 16, 16, null);
		g.drawString("X " + Drops.coinsBronze, (Game.WIDTH / 2) + 130, (Game.HEIGHT / 2) + 120);

		// Parte Potion
		// Item
		g2.setColor(new Color(0, 0, 0, 150));
		g.fillRect((Game.WIDTH / 6) - 50, (Game.HEIGHT / 2) - 110, (Game.WIDTH / 3) + 113, (Game.HEIGHT / 2));

		if (optionsPA[curretOpitionPA] == "Armas") {
			g.setColor(new Color(219, 219, 112));
			g.drawString("Armas ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 97);
		} else {
			g.setColor(Color.WHITE);
			g.drawString("Armas ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 97);
		}
		if (optionsPA[curretOpitionPA] == "Munições") {
			g.setColor(new Color(219, 219, 112));
			g.drawString("Munições", (Game.WIDTH / 2) - 87, (Game.HEIGHT / 2) - 97);
		} else {
			g.setColor(Color.WHITE);
			g.drawString("Munições", (Game.WIDTH / 2) - 87, (Game.HEIGHT / 2) - 97);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));

		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 0 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 95, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 95, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 1 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 95, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 95, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 2 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 95, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 95, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 3 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 95, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 95, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 4 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 57, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 57, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 5 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 57, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 57, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 6 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 57, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 57, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 7 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 57, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 57, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 8 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 19, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 19, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 9 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 19, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 19, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 10 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 19, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 19, 32, 32, null);
		/*--------------------------------------------------------------------------------------------------------------------------*/
		if (curretOpition != 11 && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 19, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 19, 32, 32, null);
		if (optionsPA[curretOpitionPA] == "Armas") {
			Game.invenArmer.renderLoja(g);
		} else if (optionsPA[curretOpitionPA] == "Munições") {
			Game.invenMuni.renderLoja(g);
		}
// Buy add sell e inf
		g.drawImage(Inventario.TextBox, (Game.WIDTH / 6) - 50, (Game.HEIGHT / 2) + 20, (Game.WIDTH / 3) + 113,
				(Game.HEIGHT / 2) - 45, null);
		// Textos
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		qualItem();
		g.drawString("Vende-se ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 35);
		switch (moedaVendeSe) {
		case "bronze":
			g.drawImage(Inventario.CoinsBronze, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
			break;
		case "silver":
			g.drawImage(Inventario.CoinsSilver, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
			break;
		case "gold":
			g.drawImage(Inventario.CoinsGold, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
			break;
		}
		g.drawString("X " + this.vendeSe, (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 36);

		g.drawString("Compra-se ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 50);
		switch (moedaCompreSe) {
		case "bronze":
			g.drawImage(Inventario.CoinsBronze, (Game.WIDTH / 2) - 105, (Game.HEIGHT / 2) + 42, 13, 13, null);
			break;
		case "silver":
			g.drawImage(Inventario.CoinsSilver, (Game.WIDTH / 2) - 105, (Game.HEIGHT / 2) + 42, 13, 13, null);
			break;
		case "gold":
			g.drawImage(Inventario.CoinsGold, (Game.WIDTH / 2) - 105, (Game.HEIGHT / 2) + 42, 13, 13, null);
			break;
		}

		g.drawString("X " + this.compreSe, (Game.WIDTH / 2) - 90, (Game.HEIGHT / 2) + 53);

		g.drawString("Informações do produto", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 65);
		g.drawString("Nome: " + this.nome, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 78);
		g.drawString("Efeito: " + this.efeito, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 90);
		g.drawString(this.efeitoline2, (Game.WIDTH / 2) - 125, (Game.HEIGHT / 2) + 100);

		g.setColor(Color.RED);
		g.fillRect((Game.WIDTH / 2) - 16, (Game.HEIGHT / 2) - 105, 75, 102);
		g.setColor(Color.black);
		g.fillRect((Game.WIDTH / 2) - 14, (Game.HEIGHT / 2) - 102, 70, 95);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 9));
		g.drawString("Comprar ( C ) ", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 85);
		g.drawString("Vender ( V ) ", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 65);
		g.drawString("Use as setas ", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 45);
		g.drawString("para selecionar ", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 35);
		g.drawString("o que deseja", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 25);
		g.drawString("comprar", (Game.WIDTH / 2) - 13, (Game.HEIGHT / 2) - 15);
	}

	private void qualItem() {
		if (optionsPA[curretOpitionPA] == "Armas") {
			this.vendeSe = ItensArmer.VendeSe[curretOpition];
			this.compreSe = ItensArmer.CompraSe[curretOpition];
			this.moedaVendeSe = ItensArmer.MoedaVendeSe[curretOpition];
			this.moedaCompreSe = ItensArmer.MoedaCompraSe[curretOpition];
			this.nome = ItensArmer.options[curretOpition];
			this.efeito = ItensArmer.Efeitos[curretOpition];
			this.efeitoline2 = ItensArmer.EfeitosLine2[curretOpition];
		} else if (optionsPA[curretOpitionPA] == "Munições") {
			this.vendeSe = ItensMunicao.VendeSe[curretOpition];
			this.compreSe = ItensMunicao.CompraSe[curretOpition];
			this.moedaVendeSe = ItensMunicao.MoedaVendeSe[curretOpition];
			this.moedaCompreSe = ItensMunicao.MoedaCompraSe[curretOpition];
			this.nome = ItensMunicao.options[curretOpition];
			this.efeito = ItensMunicao.Efeitos[curretOpition];
			this.efeitoline2 = ItensMunicao.EfeitosLine2[curretOpition];
		}
	}
}

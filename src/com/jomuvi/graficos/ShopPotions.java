package com.jomuvi.graficos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.jomuvi.main.Drops;
import com.jomuvi.main.Game;

public class ShopPotions {
	public int curretOpition = 0;
	public int maxOpition = ItensPocoes.options.length - 1;
	public boolean left, right, up, down, sell, buy;
	public static boolean Pagar = false, comprado = false, semdinheiro = false;
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
			Pagar = true;
			int valorEmBronze = Game.SDM.vender(ItensPocoes.MoedaVendeSe[curretOpition],
					Integer.parseInt(ItensPocoes.VendeSe[curretOpition]));
			if (valorEmBronze <= Drops.coinsBase) {
				Game.SDM.descontarMoedas(valorEmBronze);
				for (int i = 0; i < Game.inven.ItensNoInventarioPocoes.length; i++) {
					if (Game.inven.ItensNoInventarioPocoes[i] == ItensPocoes.options[curretOpition]) {
						Game.inven.qtItensPocoes[i] += 1;
						break;
					} else {
						if (Game.inven.ItensNoInventarioPocoes[i] == null) {
							Game.inven.ItensNoInventarioPocoes[i] = ItensPocoes.options[curretOpition];
							Game.inven.qtItensPocoes[i] += 1;
							Game.invenPotions.addImg();
							break;
						}
					}
				}
				comprado = true;
			} else {
				semdinheiro = true;
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

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
//--------------------------------------------------------------------------
		if (ItensPocoes.options[curretOpition] != "Life Potion Smal" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 105, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 105, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion25Life, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 108, 32, 32, null);

		if (ItensPocoes.options[curretOpition] != "Life Potion midium" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 105, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 105, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion50Life, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 105, 32, 32, null);
//----
		if (ItensPocoes.options[curretOpition] != "Life Potion Big" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 105, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 105, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion100Life, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 105, 32, 32, null);
		if (ItensPocoes.options[curretOpition] != "Life Potion Full" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 105, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 105, 32, 32, null);
		// ItensPocoes
		g.drawImage(ItensPocoes.PotionFullLife, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 105, 32, 32, null);
// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Poison Smal" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 67, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion25reStatusPoison, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 70, 32, 32, null);
//-----
		if (ItensPocoes.options[curretOpition] != "Remove Status Poison midium" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 67, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion50reStatusPoison, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Poison Big" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 67, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion100reStatusPoison, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Poison Full" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 67, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.PotionFullreStatusPoison, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 67, 32, 32, null);
		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Burnt Smal" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 29, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 29, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion25reStatusBurnt, (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) - 32, 32, 32, null);
		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Burnt midium" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 29, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 29, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion50reStatusBurnt, (Game.WIDTH / 2) - 123, (Game.HEIGHT / 2) - 29, 32, 32, null);

		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Burnt Big" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 29, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 29, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.Potion100reStatusBurnt, (Game.WIDTH / 2) - 86, (Game.HEIGHT / 2) - 29, 32, 32, null);

		// -----
		if (ItensPocoes.options[curretOpition] != "Remove Status Burnt Full" && !selecionado)
			g.drawImage(Inventario.WhiteSpace, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 29, 32, 32, null);
		else
			g.drawImage(Inventario.selecionado, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 29, 32, 32, null);
		// produto
		g.drawImage(ItensPocoes.PotionFullreStatusBurnt, (Game.WIDTH / 2) - 49, (Game.HEIGHT / 2) - 29, 32, 32, null);

		// -----

// Buy add sell e inf
		g.drawImage(Inventario.TextBox, (Game.WIDTH / 6) - 50, (Game.HEIGHT / 2) + 20, (Game.WIDTH / 3) + 113,
				(Game.HEIGHT / 2) - 45, null);
		// Textos
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 10));
		g.drawString("Vende-se ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 35);
		if (ItensPocoes.MoedaVendeSe[curretOpition] == "bronze")
			g.drawImage(Inventario.CoinsBronze, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
		if (ItensPocoes.MoedaVendeSe[curretOpition] == "prata")
			g.drawImage(Inventario.CoinsSilver, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
		if (ItensPocoes.MoedaVendeSe[curretOpition] == "gold")
			g.drawImage(Inventario.CoinsGold, (Game.WIDTH / 2) - 113, (Game.HEIGHT / 2) + 26, 13, 13, null);
		g.drawString("X " + ItensPocoes.VendeSe[curretOpition], (Game.WIDTH / 2) - 100, (Game.HEIGHT / 2) + 36);

		g.drawString("Compra-se ", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 50);
		g.drawImage(Inventario.CoinsBronze, (Game.WIDTH / 2) - 105, (Game.HEIGHT / 2) + 42, 13, 13, null);
		g.drawString("X " + ItensPocoes.CompraSe[curretOpition], (Game.WIDTH / 2) - 90, (Game.HEIGHT / 2) + 53);

		g.drawString("Informações do produto", (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 65);
		g.drawString("Nome: " + ItensPocoes.options[curretOpition], (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 78);
		g.drawString("Efeito: " + ItensPocoes.Efeitos[curretOpition], (Game.WIDTH / 2) - 160, (Game.HEIGHT / 2) + 90);
		if (ItensPocoes.EfeitosLine2[curretOpition] != "0") {
			g.drawString("E " + ItensPocoes.EfeitosLine2[curretOpition], (Game.WIDTH / 2) - 126,
					(Game.HEIGHT / 2) + 100);
		}

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

		if (Pagar) {
			g2.setColor(new Color(0, 0, 0, 240));
			g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
			g.drawImage(Inventario.TextBox, (Game.WIDTH / 2) - 115, (Game.HEIGHT / 2) - 50, (Game.WIDTH / 3) + 113,
					(Game.HEIGHT / 2) - 45, null);
			g.setColor(Color.WHITE);
			g.fillRect((Game.WIDTH / 2) - 40, (Game.HEIGHT / 2) + 10, 75, 18);

			g.setColor(new Color(219, 219, 112));
			g.setFont(new Font("arial", Font.BOLD, 9));
			if (comprado) {
				g.drawString("Item comprado com sucesso", (Game.WIDTH / 2) - 65, (Game.HEIGHT / 2) - 10);
				g.drawString("Enter para Sair", (Game.WIDTH / 2) - 35, (Game.HEIGHT / 2) + 22);
			}
			if (semdinheiro) {
				g.drawString("Não possui dinhero o suficiente", (Game.WIDTH / 2) - 80, (Game.HEIGHT / 2) - 10);
				g.drawString("Enter para Sair", (Game.WIDTH / 2) - 35, (Game.HEIGHT / 2) + 22);
			}

		}
	}
}

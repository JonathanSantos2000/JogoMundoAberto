package com.jomuvi.main;

import com.jomuvi.entities.Player;
import com.jomuvi.graficos.ItensArmer;
import com.jomuvi.graficos.ItensMunicao;
import com.jomuvi.graficos.ItensPocoes;

public class verificarItens {

	public boolean one, two, three, four, five, six;

	public void tick() {
		Game.verItens.verQtMunicao();
		Game.verItens.verDano();
		Game.invenPotions.verQtPocao();

		// fast bar
		if (one) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				one = false;
				qualItem();
				addPocao(0);
			}
		}
		if (two) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				two = false;
				qualItem();
				addPocao(1);
			}
		}
		if (three) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				three = false;
				qualItem();
				addPocao(2);
			}
		}
		if (four) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				four = false;
				qualItem();
				addPocao(3);
			}
		}
		if (five) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				five = false;
				qualItem();
				addPocao(4);
			}
		}
		if (six) {
			if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
				six = false;
				qualItem();
				addPocao(5);
			}
		}
		// fim fast bar
	}

	private void addPocao(int pos) {
		ItensPocoes.addItensInvRapido(pos);
		ItensPocoes.showFastBar(Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition], pos);
		ItensPocoes.showFastBarInv(Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition], pos);
		Game.inven.qtItensBarraRapida[pos] = Game.inven.qtItensPocoes[Game.inven.curretOpition];
	}

	public void qualItem() {
		if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Poções") {
			for (int i = 0; i < ItensPocoes.options.length; i++) {
				if (Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition] == ItensPocoes.options[i]) {
					Game.inven.nome = Game.inven.ItensNoInventarioPocoes[Game.inven.curretOpition];
					Game.inven.efeito = ItensPocoes.Efeitos[i];
					Game.inven.efeitoline2 = ItensPocoes.EfeitosLine2[i];
				}
			}
		} else if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Armas") {
			for (int i = 0; i < ItensArmer.options.length; i++) {
				if (Game.inven.itensNoInventarioArmas[Game.inven.curretOpition] == ItensArmer.options[i]) {
					Game.inven.nome = Game.inven.itensNoInventarioArmas[Game.inven.curretOpition];
					Game.inven.efeito = ItensArmer.Efeitos[i];
					Game.inven.efeitoline2 = ItensArmer.EfeitosLine2[i];
				}
			}
		} else if (Game.inven.optionsPA[Game.inven.curretOpitionPA] == "Munições") {
			for (int i = 0; i < ItensArmer.options.length; i++) {
				if (Game.inven.ItensNoInventarioMunicao[Game.inven.curretOpition] == ItensMunicao.options[i]) {
					Game.inven.nome = "Munição " + Game.inven.ItensNoInventarioMunicao[Game.inven.curretOpition];
					Game.inven.efeito = ItensMunicao.Efeitos[i];
					Game.inven.efeitoline2 = ItensMunicao.EfeitosLine2[i];
				}
			}
		}
	}

	public void verQtMunicao() {
		for (int i = 0; i < Game.inven.ItensNoInventarioMunicao.length; i++) {
//			System.out.println(i+1+" "+Game.inven.ItensNoInventarioMunicao[i]);
			if (Game.inven.municaoEquipada == Game.inven.ItensNoInventarioMunicao[i]) {
				if (Game.inven.qtItensMunicao[i] == 0) {
					Game.invenMuni.ShowMuniPistol = false;
					Game.inven.ItensNoInventarioMunicao[i] = null;
					Player.ammo = 0;
				} else {
					Player.ammo = Game.inven.qtItensMunicao[i];
				}
			}
		}
	}

	public void verDano() {
		Player.dano = Player.forca + ItensArmer.armaDano[ItensArmer.posicaoPxPy]
				+ ItensMunicao.shootDano[ItensArmer.posicaoPxPy];
	}

	public void diminuirQtMunicao() {
		for (int i = 0; i < Game.inven.ItensNoInventarioMunicao.length; i++) {
			if (Game.inven.municaoEquipada == Game.inven.ItensNoInventarioMunicao[i]) {
				Game.inven.qtItensMunicao[i]--;
			}
		}
	}

}

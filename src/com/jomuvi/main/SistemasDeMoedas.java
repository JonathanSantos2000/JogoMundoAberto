package com.jomuvi.main;

public class SistemasDeMoedas {

	public int vender(String TipoMoeda, int valorItem) {
		int valorEmBronze = 0;
		switch (TipoMoeda) {
		case "gold":
			valorEmBronze = valorItem * 10000;
			break;
		case "prata":
			valorEmBronze = valorItem * 100;
			break;
		default:
			valorEmBronze = valorItem;
			break;
		}
		return valorEmBronze;
	}


	public void converterMoedas() {
		if (Drops.coinsBronze >= 100) {
			Drops.coinsBronze -= 100;
			Drops.coinsSilver += 1;
		}
		if (Drops.coinsSilver >= 100) {
			Drops.coinsSilver -= 100;
			Drops.coinsGold += 1;
		}
	}

	public void descontarMoedas(int valorItem) {
		int totalMoedas = Drops.coinsBronze;
		totalMoedas += Drops.coinsSilver * 100;
		totalMoedas -= valorItem;
		Drops.coinsBase -= valorItem;
		Drops.coinsBronze = 0;
		Drops.coinsSilver = 0;
		Drops.coinsGold = 0;
		Drops.coinsBronze = totalMoedas;
	}
}

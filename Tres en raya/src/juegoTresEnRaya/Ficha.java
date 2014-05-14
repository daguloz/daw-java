package juegoTresEnRaya;

import java.awt.Color;

public class Ficha {
	private Color color;

	public Ficha(Color tipoFicha) {
		color = tipoFicha;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	} 
}

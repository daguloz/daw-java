package juegoTresEnRaya;

public class Casilla {
	private boolean ocupada;
	private Ficha ficha;
	private Jugador jugador;
	
	public Casilla() {
		ocupada = false;
		ficha = null;
		jugador = null;
	}

	public boolean isOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
}

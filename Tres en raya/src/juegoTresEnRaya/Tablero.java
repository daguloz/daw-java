package juegoTresEnRaya;

import java.util.ArrayList;
import java.util.Iterator;

public class Tablero implements Iterable<Casilla> {
	private ArrayList<Casilla> tablero;

	public Tablero() {
		
		tablero = new ArrayList<Casilla>();
		for (int i = 0; i < 9; i++) {
			tablero.add(new Casilla());	
		}
	}
	
	public Casilla getCasilla(int posicion) {
		return tablero.get(posicion);
	}

	public int getPosicion(Casilla casilla) {
		return tablero.indexOf(casilla);
	}
	
	@Override
	public Iterator<Casilla> iterator() {
		return tablero.iterator();
	}

	public boolean hayLinea(Jugador jugador) {
		if ((tablero.get(0).getJugador() == jugador) && (tablero.get(1).getJugador() == jugador) && (tablero.get(2).getJugador() == jugador))
			return true;
		if ((tablero.get(3).getJugador() == jugador) && (tablero.get(4).getJugador() == jugador) && (tablero.get(5).getJugador() == jugador))
			return true;
		if ((tablero.get(6).getJugador() == jugador) && (tablero.get(7).getJugador() == jugador) && (tablero.get(8).getJugador() == jugador))
			return true;
		if ((tablero.get(0).getJugador() == jugador) && (tablero.get(3).getJugador() == jugador) && (tablero.get(6).getJugador() == jugador))
			return true;
		if ((tablero.get(1).getJugador() == jugador) && (tablero.get(4).getJugador() == jugador) && (tablero.get(7).getJugador() == jugador))
			return true;
		if ((tablero.get(2).getJugador() == jugador) && (tablero.get(5).getJugador() == jugador) && (tablero.get(8).getJugador() == jugador))
			return true;
		if ((tablero.get(0).getJugador() == jugador) && (tablero.get(4).getJugador() == jugador) && (tablero.get(8).getJugador() == jugador))
			return true;
		if ((tablero.get(2).getJugador() == jugador) && (tablero.get(4).getJugador() == jugador) && (tablero.get(6).getJugador() == jugador))
			return true;
		
		return false;
	}
	
}

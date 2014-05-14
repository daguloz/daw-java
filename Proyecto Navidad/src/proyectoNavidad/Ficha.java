package proyectoNavidad;

/**
 * Clase Ficha.
 * 
 * @author Daniel GL
 * @version 1.0
 * 
 */
public class Ficha {
	char tipo;
	Jugador jugador;
	
	Ficha(char tipo, Jugador jugador) {
		this.tipo = tipo;
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

}

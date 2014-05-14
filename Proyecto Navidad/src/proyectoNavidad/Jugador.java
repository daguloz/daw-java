package proyectoNavidad;

/**
 * Clase Jugador.
 * 
 * @author Daniel GL
 * @version 1.0
 * 
 */
public class Jugador {

	/** El alias del jugador. */
	private String alias;

	/** Indica si el jugador es humano. */
	private boolean esHumano;

	/** El tipo de ficha del jugador. */
	private Ficha ficha;

	/** Puntuacion del jugador. */
	private int puntuacion;

	/**
	 * Crea una instancia de Jugador.
	 * 
	 * @param alias
	 *            El alias del jugador.
	 * @param esHumano
	 *            true Si el jugador es humano.
	 */
	Jugador(String alias, boolean esHumano) {
		this.alias = alias;
		this.esHumano = esHumano;
	}

	/**
	 * Obtiene el alias.
	 *
	 * @return El alias.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Devuelve si el jugador es humano.
	 *
	 * @return true, si es humano.
	 */
	public boolean esHumano() {
		return esHumano;
	}

	/**
	 * Devuelve la ficha.
	 *
	 * @return la ficha.
	 */
	public Ficha getFicha() {
		return ficha;
	}

	/**
	 * Asigna la ficha.
	 *
	 * @param ficha La ficha a asignar.
	 */
	public void setFicha(char ficha) {
		this.ficha = new Ficha(ficha, this);
	}

	/**
	 * Obtiene los puntos.
	 *
	 * @return los puntos.
	 */
	public int getPuntos() {
		return puntuacion;
	}

	/**
	 * Suma puntos.
	 *
	 * @param puntos Los puntos a sumar.
	 */
	public void sumarPuntos(int puntos) {
		puntuacion += puntos;
	}

}

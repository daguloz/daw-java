package proyectoNavidad;

import utiles.Pregunta;
import utiles.Teclado;

/**
 * Clase Partida. Controla el desarrollo de la partida.
 * 
 * @author Daniel GL
 * @version 1.0
 */
public class Partida {

	/** Jugador 1. */
	private Jugador j1;
	/** Jugador 2. */
	private Jugador j2;

	/**
	 * Indica si el turno actual es del jugador 1 (true), o del jugador 2
	 * (false)
	 */
	private boolean turnoJugador1;

	/** Contador de turnos totales. */
	private int turnos;

	/** Ranking de puntuaciones. */
	private Ranking ranking;

	/** Tablero de la partida. */
	private Tablero tablero;

	/** Indica si la partida ha terminado. */
	private boolean fin;

	/**
	 * Crea una instancia de Partida.
	 */
	Partida() {
		// Crea el primer jugador.
		System.out.print("Introduce el nombre del primer jugador: ");
		j1 = new Jugador(Teclado.leerCadena(), true);

		// Crea el segundo jugador.
		if (Pregunta.preguntaSiNo("El segundo jugador es humano")) {
			System.out.print("Introduce el nombre del segundo jugador: ");
			j2 = new Jugador(Teclado.leerCadena(), true);
		} else
			j2 = new Jugador("Máquina", false);

		// Decide el primer turno aleatoriamente.
		if (Math.round(Math.random()) == 1) {
			j1.setFicha('o');
			j2.setFicha('x');
			turnoJugador1 = true;
		} else {
			j1.setFicha('x');
			j2.setFicha('o');
			turnoJugador1 = false;
		}

		// Crea el ranking
		ranking = new Ranking(j1, j2);
		
		// Crea el tablero de la partida.
		tablero = new Tablero();

		// Reinicia variables de la partida
		fin = false;
		turnos = 0;

		while (!fin) {
			nuevoTurno();
		}
	}


	/**
	 * Reinicia la partida.
	 */
	void reiniciarPartida() {
		// Crea el tablero de la partida.
		tablero = new Tablero();

		// Reinicia variables de la partida
		fin = false;
		turnos = 0;

		while (!fin) {
			nuevoTurno();
		}
	}

	/**
	 * Inicia un turno nuevo.
	 */
	private void nuevoTurno() {
		turnos++;
		// Fin de partida hay empate
		if (turnos > 9) {
			j1.sumarPuntos(1);
			j2.sumarPuntos(1);
			fin = true;
			System.out.println("¡No hay mas movimientos!");
			ranking.mostrar();
		}
		tablero.mostrar();
		// El turno es del jugador 1
		if (turnoJugador1 == true) {
			pedirMovimiento(j1);
		}
		// El turno es del jugador 2
		else {
			pedirMovimiento(j2);
		}

		turnoJugador1 = !turnoJugador1;
	}

	/**
	 * Pide un movimiento a un jugador, si el jugador es humano.
	 * 
	 * @param jugador
	 *            El jugador
	 */
	private void pedirMovimiento(Jugador jugador) {
		System.out.println("Es el turno de " + jugador.getAlias() + ".");
		if (jugador.esHumano()) {
			int movimiento;
			do {
				// Pide un movimiento al jugador.
				System.out.print("Indica un movimiento (1-9): ");
				movimiento = Teclado.leerEntero();

				if (!tablero.comprobarMovimiento(jugador, turnos, movimiento))
					System.out.println("El movimiento no es válido.");

			} while (!tablero.comprobarMovimiento(jugador, turnos, movimiento));

			// Si el movimiento es válido, pone ficha
			tablero.ponerFicha(jugador.getFicha(), movimiento);
			System.out.println(jugador.getAlias() + " pone ficha.");

		} else {
			// Le toca mover a la máquina.
			generarMovimiento(jugador);
		}
		if (tablero.comprobarGanador(jugador)) {
			finPartida(jugador);
		}
	}

	/**
	 * Generar un movimiento de un jugador controlado por la máquina.
	 * 
	 * @param jugador
	 *            El jugador
	 */
	private void generarMovimiento(Jugador jugador) {
		int movimiento;
		do {
			movimiento = (int) Math.round((Math.random() * 9));
		} while (!tablero.comprobarMovimiento(jugador, turnos, movimiento));
		tablero.ponerFicha(jugador.getFicha(), movimiento);
		System.out.println(jugador.getAlias() + " pone ficha.");
		if (tablero.comprobarGanador(jugador)) {
			finPartida(jugador);
		}
	}

	/**
	 * Fin de la partida. Muestra puntuaciones.
	 * 
	 * @param ganador
	 *            El jugador ganador
	 */
	private void finPartida(Jugador ganador) {
		tablero.mostrar();
		fin = true;
		System.out.println("¡" + ganador.getAlias() + " gana la partida!");
		ganador.sumarPuntos(2);
		ranking.mostrar();
	}

}

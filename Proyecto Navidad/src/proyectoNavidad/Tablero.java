package proyectoNavidad;

/**
 * Clase Tablero. Controla las casillas del tablero.
 * 
 * @author Daniel GL
 * @version 1.0
 * 
 */
public class Tablero {

	/** Las casillas. */
	private Ficha[][] casillas = new Ficha[3][3];

	/**
	 * Crea una instancia del tablero.
	 */
	Tablero() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = null;
			}
		}
	}

	/**
	 * Comprueba si el movimiento es válido.
	 * 
	 * @param movimiento
	 *            El movimiento.
	 * @return true, si es válido.
	 */
	boolean comprobarMovimiento(Jugador jugador, int turnos, int movimiento) {
		
		int[] coord = movimientoACoordenadas(movimiento);

		if (casillas[coord[0]][coord[1]] == null) {
			/* if (turnos <= 2)
				return true;
			else {
				if (buscarFichaAdjunta(jugador, movimiento))
					return true;
			}
			*/
			return true;
		}
		return false;
	}
	
	/**
	 * Busca si hay una ficha en una casilla adjunta al movimiento dado.
	 * 
	 * @param jugador
	 *            Jugador a comprobar.
	 * @param movimiento
	 *            Movimiento a comprobar.
	 * @return true, si hay una ficha en una posición adjunta.
	 */
	/*
	boolean buscarFichaAdjunta(Jugador jugador, int movimiento) {
		boolean[] casillasOcupadas = buscarCasillasOcupadas(jugador);
		
		switch (movimiento) {
		case 1:
			if ((casillasOcupadas[1] == true) || (casillasOcupadas[3] == true)) 
				return true;
		case 2:
			if ((casillasOcupadas[0] == true) || (casillasOcupadas[2] == true) || (casillasOcupadas[4] == true)) 
				return true;
		case 3:
			if ((casillasOcupadas[1] == true) || (casillasOcupadas[5] == true))
				return true;
			break;
		case 4:
			if ((casillasOcupadas[0] == true) || (casillasOcupadas[4] == true) || (casillasOcupadas[6] == true)) 
				return true;
			break;
		case 5:
			if ((casillasOcupadas[1] == true) || (casillasOcupadas[3] == true) || (casillasOcupadas[5] == true) || (casillasOcupadas[7] == true)) 
				return true;
			break;
		case 6:
			if ((casillasOcupadas[2] == true) || (casillasOcupadas[4] == true) || (casillasOcupadas[8] == true)) 
				return true;
			break;
		case 7:
			if ((casillasOcupadas[3] == true) || (casillasOcupadas[7] == true)) 
				return true;
			break;
		case 8:
			if ((casillasOcupadas[4] == true) || (casillasOcupadas[6] == true) || (casillasOcupadas[8] == true)) 
				return true;
			break;
		case 9:
			if ((casillasOcupadas[5] == true) || (casillasOcupadas[7] == true)) 
				return true;
			break;
		}
		
		return false;
	}
	
	/**
	 * Busca las casillas ocupadas por un jugador.
	 * 
	 * @param jugador
	 *            Jugador a comprobar
	 * @return array booleano con las casillas ocupadas
	 */
	/*
	boolean[] buscarCasillasOcupadas(Jugador jugador) {
		
		boolean[] casillasOcupadas = new boolean[9];
		
		for (int i = 0; i < casillasOcupadas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				for (int k = 0; k < casillas[j].length; k++) {
					
					if (casillas[j][k].getJugador().getAlias() == jugador.getAlias())
						casillasOcupadas[i] = true;
					else
						casillasOcupadas[i] = false;
				}
			}
		}

		for (int c = 0; c < casillasOcupadas.length; c++) {
			System.out.println("casilla " + c + ": " + casillasOcupadas[c]);
		}
		
		return casillasOcupadas;
	} */
	
	/**
	 * Obtiene las coordenadas de un movimiento.
	 * El movimiento es un número del 1 al 9, que indica una
	 * casilla del tablero, empezando por la esquina superior izquierda (1),
	 * y acabando en la inferior derecha (9).
	 * 
	 * -------------------------
	 * |       |       |       |
	 * |   1   |   2   |   3   |
	 * |       |       |       |
	 * -------------------------
	 * |       |       |       |
	 * |   4   |   5   |   6   | 
	 * |       |       |       |
	 * -------------------------
	 * |       |       |       |
	 * |   7   |   8   |   9   | 
	 * |       |       |       |
	 * -------------------------
	 * 
	 * @param movimiento El movimiento
	 * @return the int[]
	 */
	private int[] movimientoACoordenadas(int movimiento) {

		int coord[] = new int[2];

		switch (movimiento) {
		case 1:
			coord[0] = 0;
			coord[1] = 0;
			break;
		case 2:
			coord[0] = 0;
			coord[1] = 1;
			break;
		case 3:
			coord[0] = 0;
			coord[1] = 2;
			break;
		case 4:
			coord[0] = 1;
			coord[1] = 0;
			break;
		case 5:
			coord[0] = 1;
			coord[1] = 1;
			break;
		case 6:
			coord[0] = 1;
			coord[1] = 2;
			break;
		case 7:
			coord[0] = 2;
			coord[1] = 0;
			break;
		case 8:
			coord[0] = 2;
			coord[1] = 1;
			break;
		case 9:
			coord[0] = 2;
			coord[1] = 2;
			break;
		}

		return coord;
	}

	/**
	 * Pone una ficha en el tablero.
	 *
	 * @param tipo Tipo de ficha.
	 * @param movimiento El movimiento
	 */
	void ponerFicha(Ficha tipo, int movimiento) {
		int[] coord = movimientoACoordenadas(movimiento);
		casillas[coord[0]][coord[1]] = tipo;
	}

	/**
	 * Muestra el estado del tablero en pantalla.
	 */
	void mostrar() {
		int k = 1;
		System.out.println("-------------------------");
		for (int i = 0; i < casillas.length; i++) {
			System.out.println("|       |       |       |");
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j] == null)
					System.out.print("|       ");
				else
					System.out.print("|   " + casillas[i][j].getTipo() + "   ");
			}
			System.out.println("| (" + k + "-" + (k + 2)
					+ ")\n|       |       |       |");
			System.out.println("-------------------------");
			k += 3;
		}
		System.out.println();
	}

	/**
	 * Comprueba si un jugador ha ganado la partida.
	 *
	 * @param jugador El jugador a comprobar.
	 * @return true, si ha ganado.
	 */
	boolean comprobarGanador(Jugador jugador) {
		int conteo = 0;

		// Busca línea horizontal
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				if (casillas[i][j] == jugador.getFicha())
					conteo++;
			}
			// Si el jugador tiene una linea entera, ha ganado.
			if (conteo == 3)
				return true;
			// Si no la tiene, reiniciamos el contador y seguimos buscando.
			conteo = 0;
		}

		// Busca línea vertical
		for (int i = 0; i < casillas[0].length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				if (casillas[i][j] == jugador.getFicha())
					conteo++;
			}
			if (conteo == 3)
				return true;
			conteo = 0;
		}

		// Busca línea diagonal
		if ((casillas[0][0] == jugador.getFicha())
				&& (casillas[1][1] == jugador.getFicha())
				&& (casillas[2][2] == jugador.getFicha()))
			return true;
		if ((casillas[0][2] == jugador.getFicha())
				&& (casillas[1][1] == jugador.getFicha())
				&& (casillas[2][0] == jugador.getFicha()))
			return true;

		return false;
	}
}

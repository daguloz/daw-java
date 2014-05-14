package juegoTresEnRaya;

public final class TresEnRaya {
	
	private Tablero tablero;
	public Jugador jugador1;
	public Jugador jugador2;
	private Ranking ranking;
	private Estado estado;
	public Jugador jugadorActual;
	private int turno;
	private Casilla casillaSeleccionada;
	
	public TresEnRaya() {
		
		setEstado(Estado.INICIANDO);
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	public Jugador getJugador1() {
		return jugador1;
	}

	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}

	public Jugador getJugador2() {
		return jugador2;
	}

	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Casilla getCasillaSeleccionada() {
		return casillaSeleccionada;
	}

	public void setCasillaSeleccionada(Casilla casillaSeleccionada) {
		this.casillaSeleccionada = casillaSeleccionada;
	}

	public void iniciarPartida() {
		
		tablero = new Tablero();
		decidirOrdenJugadores();
		turno = 0;
		
		ranking = new Ranking(this);
		
		setEstado(Estado.EN_PARTIDA);
		
	}

	/**
	 *  Decide el primer jugador aleatoriamente en la primera partida
	 */
	private void decidirOrdenJugadores() {
		if (getEstado() == Estado.INICIANDO) {		
			if ((int)(Math.random()*2) == 1)
				jugadorActual = jugador1;
			else
				jugadorActual = jugador2;
		}
	}
	
	public void casillaPulsada(int posicion) {
		if (getEstado() == Estado.EN_PARTIDA) {
			Casilla casilla = tablero.getCasilla(posicion);
			
			if (turno < 6) {
				if (!casilla.isOcupada()) {
					casilla.setJugador(jugadorActual);
					casilla.setOcupada(true);
					casilla.setFicha(new Ficha(jugadorActual.getTipoFicha()));
					pasarTurno();
				}
			}
		
			// Hay tres fichas en el tablero.
			else {
				// No se ha seleccionado una casilla, se selecciona una.
				if (casillaSeleccionada == null) {
					if (casilla.isOcupada() && (casilla.getJugador() == jugadorActual)) {
						casillaSeleccionada = casilla;
					}
				}
				else {
					if (casilla.isOcupada()) {
						// Si se pulsa la misma casilla, se deselecciona.
						if (casilla == casillaSeleccionada)
							casillaSeleccionada = null;
					}
					else {
						// Si la casilla esta libre, comprobamos que sea un movimiento válido (adyacente)
						if (casillaValida(casillaSeleccionada, casilla)) {
							casilla.setJugador(casillaSeleccionada.getJugador());
							casilla.setOcupada(true);
							casilla.setFicha(casillaSeleccionada.getFicha());
							
							casillaSeleccionada.setFicha(null);
							casillaSeleccionada.setJugador(null);
							casillaSeleccionada.setOcupada(false);
							casillaSeleccionada = null;
							
							pasarTurno();
						}
					}
				}
			}
		}
		else {
			System.out.println("Partida finalizada!");
		}

	}

	private boolean casillaValida(Casilla casillaOrigen, Casilla casillaDestino) {
		int origen = tablero.getPosicion(casillaOrigen);
		int destino = tablero.getPosicion(casillaDestino);
		switch (origen) {
			case 0:
				if ((destino == 1) || (destino == 3) || (destino == 4))
					return true;
				break;
			case 1:
				if ((destino < 6) && (destino != 1))
					return true;
				break;
			case 2:
				if ((destino == 1) || (destino == 5) || (destino == 4))
					return true;
				break;
			case 3:
				if ((destino == 0) || (destino == 1) || (destino == 4) || (destino == 6) || (destino == 7))
					return true;
				break;
			case 4:
				if (destino != 4)
				return true;
			case 5:
				if ((destino == 2) || (destino == 1) || (destino == 4) || (destino == 8) || (destino == 7))
					return true;
				break;
			case 6:
				if ((destino == 3) || (destino == 7) || (destino == 4))
					return true;
				break;
			case 7:
				if ((destino > 2) && (destino != 7))
					return true;
				break;
			case 8:
				if ((destino == 5) || (destino == 7) || (destino == 4))
					return true;
				break;
		}
		return false;
	}

	private boolean comprobarGanador() {
		if (tablero.hayLinea(jugadorActual)) {
			setEstado(Estado.FINALIZADO);
			jugadorActual.sumarPartidaGanada();
			ranking.actualizarJugador(jugador1);
			ranking.actualizarJugador(jugador2);
			ranking.grabarRanking();
			return true;
		}
		return false;
	}

	private void pasarTurno() {
		if (!comprobarGanador()) {
			turno++;
			
			if (jugadorActual == jugador1)
				jugadorActual = jugador2;
			else
				jugadorActual = jugador1;
		}
		
	}
}

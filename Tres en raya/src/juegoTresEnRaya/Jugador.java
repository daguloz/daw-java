package juegoTresEnRaya;

import java.awt.Color;
import java.io.Serializable;

public class Jugador implements Serializable {

	private String nombre;
	private TipoJugador tipoJugador;
	private Color tipoFicha;
	private Integer puntuacion;
	
	public Jugador(String nombre, TipoJugador tipoJugador, Color tipoFicha) {
		this.nombre = nombre;
		this.tipoJugador = tipoJugador;
		this.tipoFicha = tipoFicha;
		puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoJugador getTipoJugador() {
		return tipoJugador;
	}

	public void setTipoJugador(TipoJugador tipoJugador) {
		this.tipoJugador = tipoJugador;
	}

	public Color getTipoFicha() {
		return tipoFicha;
	}

	public void setTipoFicha(Color tipoFicha) {
		this.tipoFicha = tipoFicha;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}
	
	public void borrarPuntuacion() {
		puntuacion = 0;
	}

	public void sumarPartidaGanada() {
		puntuacion++;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
		
	}
	
}

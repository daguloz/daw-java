package juegoTresEnRaya;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ranking {

	private static final String FICHERO_NOMBRES = "jugadores.obj";
	private static final String FICHERO_PUNTOS = "puntos.obj";
	private ArrayList<String> tablaNombres;
	private ArrayList<Integer> tablaPuntos;
	private TresEnRaya juego;
	
	public Ranking(TresEnRaya juego) {
		this.juego = juego;
		leerRanking();
		if (tablaNombres == null) {
			tablaNombres = new ArrayList<String>();
			tablaPuntos = new ArrayList<Integer>();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void leerRanking() {
		Path pathFicheroNombres = Paths.get(FICHERO_NOMBRES);
		if (Files.exists(pathFicheroNombres)) {

			// Lee los nommbres del fichero
			try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_NOMBRES));) {
				tablaNombres = (ArrayList<String>)entrada.readObject();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tablaNombres = null;
			}
		}
		
		Path pathFicheroPuntos = Paths.get(FICHERO_PUNTOS);
		if (Files.exists(pathFicheroPuntos)) {

			// Lee los nommbres del fichero
			try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(FICHERO_PUNTOS));) {
				tablaPuntos = (ArrayList<Integer>)entrada.readObject();
				int i = 0;
				for (String s : tablaNombres) {
					if (juego.jugador1.getNombre() == s) {
						juego.jugador1.setPuntuacion(tablaPuntos.get(i));
					}
					if (juego.jugador2.getNombre() == s) {
						juego.jugador2.setPuntuacion(tablaPuntos.get(i));
					}
					i++;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tablaPuntos = null;
			}
		}
	}

	public void grabarRanking() {
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_NOMBRES));)
		{
			salida.writeObject(tablaNombres);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(FICHERO_PUNTOS));)
		{
			salida.writeObject(tablaPuntos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int jugadorEnRanking(Jugador jugador) {
		for (String j : tablaNombres) {
			if (j.equals(jugador.getNombre()))
				return tablaNombres.indexOf(j);
		}
		return -1;
	}
	
	public void actualizarJugador(Jugador jugador) {
		// Elimina al jugador si ya estaba en la tabla.
		int pos = jugadorEnRanking(jugador);
		if (pos != -1) {
			tablaNombres.remove(pos);
			tablaPuntos.remove(pos);
		}
		int posActual = 0;
		int posTop = -1;
		for (int puntos : tablaPuntos) {
			if (jugador.getPuntuacion() > puntos) {
				posTop = posActual;
			}
			posActual++;
		}
		if (posTop > -1)
			posActual = posTop;
		tablaNombres.add(posActual, jugador.getNombre());
		tablaPuntos.add(posActual, jugador.getPuntuacion());
	}
	
	public void reiniciar() {
//		for (Jugador j : tabla) {
//			j.borrarPuntuacion();
//		}
		tablaNombres = new ArrayList<String>();
		tablaPuntos = new ArrayList<Integer>();
		grabarRanking();
	}
	
	public String[] top3Nombres() {
		String[] top3 = new String[3];
		System.out.println(tablaNombres);
		System.out.println("size :" + tablaPuntos.size());
		for (int i = 0; i < top3.length; i++) {
			if (i >= tablaNombres.size())
				top3[i] = "-";
			else
				top3[i] = tablaNombres.get(i);
		}
		return top3;
	}
	
	public Integer[] top3Puntos() {
		Integer[] top3 = new Integer[3];
		System.out.println(tablaPuntos);
		System.out.println("size :" + tablaPuntos.size());
		for (int i = 0; i < top3.length; i++) {
			if (i >= tablaPuntos.size())
				top3[i] = 0;
			else
				top3[i] = tablaPuntos.get(i);
		}
		return top3;
	}
}

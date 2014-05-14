package proyectoNavidad;

import utiles.Pregunta;

/**
 * 
 * Juego de las tres en raya
 * 
 * Después de vacaciones jugaremos un rato con los juguetes de Reyes ;). Para
 * ello entrega un proyecto Java que implemente el juego de las tres en raya.
 * Deberá cumplir los siguientes requisitos:
 * 
 * 1. Al iniciar el juego, los dos jugadores indicarán su alias. 
 * 2. En caso de haber un único jugador, la máquina tomará el papel del segundo jugador
 * 3. Comenzaá la partida el último ganador. En caso de ser la primera partida, la elección se hará de forma aleatoria...
 * 4. Inicialmente, el tablero estará vacío, y dispondrá de 3 x 3 casillas vacías
 * 5. Las fichas del tres en raya serán una "x" o una "o" .  Siempre comenzarán las "o"
 * 6. En cada turno el jugador pondrá/moverá una única ficha en el tablero, teniendo en cuenta que:
 * 7. Las fichas no pueden ocupar una posición ocupada
 * 8. Las fichas se mueven sólo a la posición adjunta (arrastrando una posición arriba/abajo/derecha/izquierda/diagonal)
 * 9. Ganará la partida aquel jugador que coloque sus tres fichas en línea...
 * 10. Al acabar la partida se dará la opción de comenzar otra
 * 11. En todo momento se mantendrá/mostrará el ranking de los jugadores (incluida la máquina).
 * 
 * @author Daniel GL
 * @version 1.0
 * 
 */

public class TresEnRaya {

	/**
	 * Método main
	 *
	 * @param args Los argumentos
	 * 
	 */
	public static void main(String[] args) {
		
		Partida partida = new Partida();
		while (true) {
			if (Pregunta.preguntaSiNo("Deseas jugar otra partida"))
				partida.reiniciarPartida();
			else
				System.out.println("¡Hasta otra!");
		}
	}

}

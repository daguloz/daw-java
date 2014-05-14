package utiles;

import utiles.Teclado;

/**
 * 
 * Hace una pregunta al usuario.
 * 
 * @author Daniel GL
 * @version 1.0
 * 
 */

public class Pregunta {

	/**
	 * Hace una pregunta a responder con Sí o No. 
	 * 
	 * @param mensaje
	 *            El mensaje a mostrar.
	 * @return false en caso de introducir una n, y true con cualquier otra
	 *         tecla.
	 */
	public static boolean preguntaSiNo(String mensaje) {
		char key;
		System.out.print("¿" + mensaje + "? (s/n) ");
		key = Teclado.leerCaracter();
		if (!((key == 'n') || (key == 'N')))
			return true;
		return false;
	}

}

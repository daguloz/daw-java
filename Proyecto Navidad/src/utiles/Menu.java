/**
 * 
 */
package utiles;

/**
 * 
 * Clase para manejar un menú.
 * 
 * @author Daniel GL
 * @version 1.0
 *
 */
public class Menu {
	
	/** Elementos del menú. */
	private String[] elementos;

	/**
	 * Crea una instancia de Menu.
	 * 
	 * @param elementos
	 *            Los elementos del menú.
	 */
	public Menu(String[] elementos) {
		super();
		this.elementos = elementos;
	}
	
	/**
	 * Muestra el menú.
	 */
	private void mostrar() {
		System.out.println("# Elige una opción (1 - " + elementos.length + ")#"
						 + "\n###########################");
		for (int i = 0; i < elementos.length; i++) {
			System.out.println("# " + (i + 1) + ". " + elementos[i]);
		}
		System.out.print("Opción: ");
	}
	
	/**
	 * Pide una opción del menú al usuario.
	 * 
	 * @return La opción elegida.
	 */
	public int pedirOpcion() {
		int eleccion;
		mostrar();
		do {
			eleccion = Teclado.leerEntero();
			if ( (eleccion < 1) || (eleccion > elementos.length) )
			{
				System.out.print("Elección no válida. Elige entre 1 - " + elementos.length + ": ");
			}
		}
		while ( (eleccion < 1) || (eleccion > elementos.length) );
		return eleccion;
	}
	
}

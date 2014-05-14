package proyectoNavidad;

public class Ranking {

	Jugador j1;
	Jugador j2;
	
	Ranking(Jugador j1, Jugador j2)
	{
		this.j1 = j1;
		this.j2 = j2;
	}
	
	void mostrar() {
		System.out.println("Puntuaciones:");
		if (j1.getPuntos() > j2.getPuntos()) {
			System.out.println("1. " + j1.getAlias() + ": " + j1.getPuntos());
			System.out.println("2. " + j2.getAlias() + ": " + j2.getPuntos());
		}
		else {
			System.out.println("1. " + j2.getAlias() + ": " + j2.getPuntos());
			System.out.println("2. " + j1.getAlias() + ": " + j1.getPuntos());
		}
	}
}

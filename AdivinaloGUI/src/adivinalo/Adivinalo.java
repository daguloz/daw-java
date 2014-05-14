package adivinalo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * Control del juego "Adivinalo". Consiste en:
 * 
 * Adivinar un número comprendido entre 0 y 100, que será generado de forma
 * automática. El usuario introducirá por teclado el número y el programa
 * informará si es mayor o menor. El número de intentos será infinito. Al
 * adivinarlo, se le dará la opción de comenzar de nuevo el juego. La aplicación
 * almacenará en "record.txt" el menor número de intentos para informar al
 * usuario en caso de batirlo.
 * 
 * @author Daniel GL, Alejandro GL
 * @version 1.0
 * 
 */
public class Adivinalo {

	/** Número de intentos actual */
	private Integer intentos = 0;
	/** Récord de intentos */
	private Integer record;
	/** Número que se debe adivinar. */
	private Integer numero;
	
	private Integer valorMin = 0;
	private Integer valorMax = 100;

	public Adivinalo() {
		generarNumero();
		leerRecords();
	}
	

	public void reiniciarPartida() {
		intentos = 0;
		generarNumero();
	}
	
	public void nuevaPartida() {
		if ((intentos < record) || (record == -1))
			grabarRecord(intentos);
		reiniciarPartida();
	}

	/**
	 * Comprueba si el número escrito es correcto, y si se ha mejorado el récord.
	 * 
	 * @param numeroLeido
	 * @return true si se ha acertado el número
	 */
	ValorRetorno comprobarNumero(int numeroLeido) {
		
		intentos++;
		
		if (numeroLeido == numero) {
			if ((intentos < record) || (record == -1)) {
				grabarRecord(intentos);
				return ValorRetorno.ES_CORRECTO_NUEVO_RECORD;
			} else if (intentos == record) {
				return ValorRetorno.ES_CORRECTO_MISMO_RECORD;
			} else {
				return ValorRetorno.ES_CORRECTO;
			}
		}
		else if (numeroLeido > numero) {
			return ValorRetorno.ES_MENOR;
		}
		else if (numeroLeido < numero) {
			return ValorRetorno.ES_MAYOR;
		}
		return ValorRetorno.ERROR;
	}

	private void grabarRecord(int valor) {
		record = valor;
		try (PrintWriter flujoFichero = new PrintWriter(new FileWriter("records.txt"))) {
			flujoFichero.print(record);
		} catch (Exception e) {
			System.err.println(e);
			System.err.println("No se ha podido crear el fichero de récords.");
		}

	}

	private void generarNumero() {
		numero = (int) (Math.random() * 100);
	}

	public void leerRecords() {
		Path pathFichero = Paths.get("records.txt");
		if (Files.exists(pathFichero)) {

			// Lee el fichero y almacena su contenido en memoria.
			try (BufferedReader fichero = new BufferedReader(new FileReader(
					"records.txt"))) {
				String linea;
				while ((linea = fichero.readLine()) != null) {
					record = Integer.parseInt(linea);
				}
			} catch (Exception e) {
				System.err.println(e);
				System.err
						.println("No se ha podido leer el fichero de récords.");
			}
		} else
			record = -1;

	}

	public Integer getIntentos() {
		return intentos;
	}

	public void setIntentos(Integer intentos) {
		this.intentos = intentos;
	}

	public Integer getRecord() {
		return record;
	}
	
	public String getRecordString() {
		Integer valorRecord = getRecord();
		String textoRecord;
		if (valorRecord < 1)
			textoRecord = "No hay record.";
		else 
			textoRecord = valorRecord.toString();
		return textoRecord;
	}
	public String setRecordString() {
		Integer valorRecord = getRecord();
		String textoRecord;
		textoRecord = valorRecord.toString();
		return textoRecord;
	}

	public void setRecord(Integer record) {
		if (record >= 1)
			grabarRecord(record);
	}
	
	public void borrarRecord() {
		grabarRecord(-1);
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getValorMax() {
		return valorMax;
	}

	public void setValorMax(int valorMax) {
		this.valorMax = valorMax;
	}

	public Integer getValorMin() {
		return valorMin;
	}

	public void setValorMin(int valorMin) {
		this.valorMin = valorMin;
	}

}

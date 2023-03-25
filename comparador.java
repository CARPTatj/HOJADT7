import java.util.Comparator;
import java.lang.String;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * Clase comparador: compara las palabras 
 * CLASE TOMADA DE REPOSITORIO DEL PROFESOR.
 */


/**
 * @author MAAG - Enteros convertido a palabras
 *
 */
public class comparador implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {

		int comparacion = o1.compareTo(o2);

		if (o1.equals(o2)) {
			return 0;
		} else if (comparacion > 0) {
			return 1;
		} else {
			return -1;
		}
	}
}
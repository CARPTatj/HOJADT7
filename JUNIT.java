import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * JUNIT
 */


public class JUNIT {

	//Test para insertar elementos en el BST
    @Test
    void abrirArchivoPalabrasTest(){
		traductor traductor = new traductor();
		
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("dog,perro,chien");
		palabras.add("woman,mujer,femme");
		palabras.add("man,hombre,homme");

		traductor.abrirArchivo(palabras);

		boolean boolean1 = traductor.getEnglish().contains("dog");
		assertEquals(true, boolean1);
		boolean boolean2 = traductor.getEnglish().contains("woman");
		assertEquals(true, boolean2);
		boolean boolean3 = traductor.getEnglish().contains("man");
		assertEquals(true, boolean3);


		boolean boolean4 = traductor.getSpanish().contains("perro");
		assertEquals(true, boolean4);
		boolean boolean5 = traductor.getSpanish().contains("mujer");
		assertEquals(true, boolean5);
		boolean boolean6 = traductor.getSpanish().contains("hombre");
		assertEquals(true, boolean6);

		boolean boolean7 = traductor.getFrench().contains("chien");
		assertEquals(true, boolean7);
		boolean boolean8 = traductor.getFrench().contains("femme");
		assertEquals(true, boolean8);
		boolean boolean9 = traductor.getFrench().contains("homme");
		assertEquals(true, boolean9);
    }

	//Test para el recorrido in order
	@Test
	void inOrderTest(){

		traductor traductor = new traductor();
		
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("dog,perro,chien");
		palabras.add("woman,mujer,femme");
		palabras.add("man,hombre,homme");


		traductor.abrirArchivo(palabras);


		String resultadoEsperadoIngles = "\n\nDICCIONARIO DE INGLÉS" + "\n-----------------------" + "\n\ndog: " + "\nEspañol: perro\nFrancés: chien\n\nman: \nEspañol: hombre\nFrancés: homme\n\nwoman: \nEspañol: mujer\nFrancés: femme" ;
		String resultado = traductor.palabrasEnOrden(1);
		assertEquals(resultadoEsperadoIngles, resultado);

		String resultadoEsperadoEspaniol = "\n\nDICCIONARIO DE ESPAÑOL" + "\n-----------------------" + "\n\nhombre: " + "\nInglés: man\nFrancés: homme\n\nmujer: \nInglés: woman\nFrancés: femme\n\nperro: \nInglés: dog\nFrancés: chien" ;
		String resultado2 = traductor.palabrasEnOrden(2);
		assertEquals(resultadoEsperadoEspaniol, resultado2);

		String resultadoEsperadoFrances = "\n\nDICCIONARIO DE FRANCÉS" + "\n-----------------------" + "\n\nchien: " + "\nInglés: dog\nEspañol: perro\n\nfemme: \nInglés: woman\nEspañol: mujer\n\nhomme: \nInglés: man\nEspañol: hombre" ;
		String resultado3 = traductor.palabrasEnOrden(3);
		assertEquals(resultadoEsperadoFrances, resultado3);
	}

	//Test para detectar el idioma del documento
	@Test
	void detectarIdiomaTest(){


		traductor traductor = new traductor();
		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("dog,perro,chien");
		palabras.add("woman,mujer,femme");
		palabras.add("man,hombre,homme");
		palabras.add("house,casa,loger");
		palabras.add("pizza,pizza,pizza");
		palabras.add("hello,hola,bonjour");


		traductor.abrirArchivo(palabras);


		ArrayList<String> oracionesspan = new ArrayList<String>();
		oracionesspan.add("Hola el perro está en la casa");
		oracionesspan.add("El hombre y la mujer");

		int español = traductor.Tipodeidioma(oracionesspan);
		assertEquals(2, español);

		ArrayList<String> oracioneseng = new ArrayList<String>();
		oracioneseng.add("Hello the man is eating a pizza");
		oracioneseng.add("The woman says hello and is inside the house");

		int inlges = traductor.Tipodeidioma(oracioneseng);
		assertEquals(1, inlges);

		ArrayList<String> oracionesFran = new ArrayList<String>();
		oracionesFran.add("Bonjour le chien mange");
		oracionesFran.add("L'homme est dans le loger et il mange une pizza");

		int frances = traductor.Tipodeidioma(oracionesFran);
		assertEquals(3, frances);
	}

	//Test para buscar asociación basado en el valor
	@Test
	void buscarAsociacionTest(){
		
		traductor traductor = new traductor();

		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("dog,perro,chien");
		palabras.add("woman,mujer,femme");
		palabras.add("man,hombre,homme");
		palabras.add("house,casa,loger");
		palabras.add("pizza,pizza,pizza");
		palabras.add("hello,hola,bonjour");


		traductor.abrirArchivo(palabras);


		BinarySearchTree ingles = traductor.getEnglish();
		Association entradaDog = (Association) ingles.search("dog");
		String[] traducciones = (String[]) entradaDog.getValue();
		assertEquals("perro", traducciones[0]);

		BinarySearchTree espaniol = traductor.getSpanish();
		Association entradaMujer = (Association) espaniol.search("mujer");
		String[] traducciones2 = (String[]) entradaMujer.getValue();
		assertEquals("femme", traducciones2[1]);

		BinarySearchTree frances = traductor.getFrench();
		Association entradaBonjour = (Association) frances.search("bonjour");
		String[] traducciones3 = (String[]) entradaBonjour.getValue();
		assertEquals("hello", traducciones3[0]);

	}

	//Test para traducir documento
	@Test
	void traducirTest(){
		
        traductor traductor = new traductor();

		ArrayList<String> palabras = new ArrayList<String>();
		palabras.add("dog,perro,chien");
		palabras.add("woman,mujer,femme");
		palabras.add("man,hombre,homme");
		palabras.add("house,casa,loger");
		palabras.add("pizza,pizza,pizza");
		palabras.add("hello,hola,bonjour");


		traductor.abrirArchivo(palabras);


		ArrayList<String> oracionesEspaniol = new ArrayList<String>();
		oracionesEspaniol.add("Hola el perro está en la casa");
		oracionesEspaniol.add("El Hombre y la mujer");

		String espaniolAIngles = traductor.traductor(oracionesEspaniol, 0, 0);
		String espaniolAInglesEsperado = "\n hello *el* dog *está* *en* *la* house\n *el* man *y* *la* woman";
		String espaniolAlFrances = traductor.traductor(oracionesEspaniol, 0, 0);
		String espaniolAFrancesEsperado = "\n bonjour *el* chien *está* *en* *la* loger\n *el* homme *y* *la* femme";

		assertEquals(espaniolAInglesEsperado, espaniolAIngles);
		assertEquals(espaniolAFrancesEsperado, espaniolAlFrances);

		ArrayList<String> oracionesIngles = new ArrayList<String>();
		oracionesIngles.add("Hello the dog is in the house");
		oracionesIngles.add("The Man and the Woman");

		String inglesEspaniol = traductor.traductor(oracionesIngles, 0, 0);
		String inglesEspaniolEsperado = "\n hola *the* perro *is* *in* *the* casa\n *the* hombre *and* *the* mujer";
		String inglesFrances = traductor.traductor(oracionesIngles, 0, 0);
		String inglesFrancesEsperado = "\n bonjour *the* chien *is* *in* *the* loger\n *the* homme *and* *the* femme";

		assertEquals(inglesEspaniolEsperado, inglesEspaniol);
		assertEquals(inglesFrancesEsperado, inglesFrances);

		ArrayList<String> oracionesFrances = new ArrayList<String>();
		oracionesFrances.add("Bonjour le chien est dans le loger");
		oracionesFrances.add("L' homme et la Femme");

		String francesIngles = traductor.traductor(oracionesFrances, 0, 0);
		String francesInglesEsperado = "\n hello *le* dog *est* *dans* *le* house\n *l'* man *et* *la* woman";
		String francesEspaniol = traductor.traductor(oracionesFrances, 0, 0);
		String francesEspaniolEsperado = "\n hola *le* perro *est* *dans* *le* casa\n *l'* hombre *et* *la* mujer";

		assertEquals(francesInglesEsperado, francesIngles);
		assertEquals(francesEspaniolEsperado, francesEspaniol);
	}

}
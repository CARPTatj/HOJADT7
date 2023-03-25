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

    @Test
    void abrirArchivoTest(){
		traductor traductor = new traductor();
		
		ArrayList<String> busqueda = new ArrayList<String>();
		busqueda.add("dog,perro,chien");
		busqueda.add("woman,mujer,femme");
		busqueda.add("house,casa,loger");

		traductor.abrirArchivo(busqueda);

		boolean kok = traductor.getEnglish().contains("dog");
		boolean jimin = traductor.getEnglish().contains("woman");
		boolean suga = traductor.getEnglish().contains("house");
		boolean tv = traductor.getSpanish().contains("perro");
		boolean tae = traductor.getSpanish().contains("mujer");
		boolean meches = traductor.getSpanish().contains("casa");
		boolean aida = traductor.getFrench().contains("chien");
		boolean marisa = traductor.getFrench().contains("femme");
		boolean marshal = traductor.getFrench().contains("loger");
		assertEquals(true, kok);
		assertEquals(true, jimin);
		assertEquals(true, suga);
		assertEquals(true, tv);
		assertEquals(true, tae);
		assertEquals(true, meches);
		assertEquals(true, aida);
		assertEquals(true, marisa);
		assertEquals(true, marshal);
    }

	@Test
	void ordenadoTest(){

		traductor traductor = new traductor();
		
		ArrayList<String> busqueda = new ArrayList<String>();
		busqueda.add("dog,perro,chien");
		busqueda.add("woman,mujer,femme");
		busqueda.add("house,casa,loger");
		busqueda.add("homework,tarea,devoir");
		busqueda.add("town,pueblo,ville");


		traductor.abrirArchivo(busqueda);


		String resultIngles = "------------INGLÉS------------\n"+
        "dog: \n" + 
        "Español: perro\n"+
        "Francés: chien\n"+
        "house: \n"+
        "Español: casa\n"+
        "Francés: loger\n"+
        "woman: \n"+
        "Español: mujer\n"+
        "Francés: femme" ;
		String result = traductor.palabrasEnOrden(1);
		assertEquals(resultIngles, result);
		String resultEspani = "----------ESPAÑOL---------\n" + 
        "\ncasa: " + 
        "Inglés: house\n"+
        "Francés: loger\n"+
        "mujer: \n"+
        "Inglés: woman\n"+
        "Francés: femme\n"+
        "perro: \n"+
        "Inglés: dog\n"+
        "Francés: chien" ;
		String dient = traductor.palabrasEnOrden(2);
		assertEquals(resultEspani, dient);

		String resultFran = "-----------FRANCÉS---------\n" + 
        "chien: \n" + 
        "Inglés: dog\n"+
        "Español: perro\n"+
        "femme: \n"+
        "Inglés: woman\n"+
        "Español: mujer\n"+
        "loger: \n"+
        "Inglés: house\n"+
        "Español: casa" ;
		String enojo = traductor.palabrasEnOrden(3);
		assertEquals(resultFran, enojo);
	}

	@Test
	void tipoidiomaTest(){


		traductor traductor = new traductor();
		ArrayList<String> busqueda = new ArrayList<String>();
		busqueda.add("dog,perro,chien");
		busqueda.add("woman,mujer,femme");
		busqueda.add("house,casa,loger");
		busqueda.add("homework,tarea,devoir");
		busqueda.add("town,pueblo,ville");

		traductor.abrirArchivo(busqueda);

		ArrayList<String> oracionesspan = new ArrayList<String>();
		ArrayList<String> oracioneseng = new ArrayList<String>();
		ArrayList<String> oracionesFran = new ArrayList<String>();
		int español = traductor.Tipodeidioma(oracionesspan);
		int inlges = traductor.Tipodeidioma(oracioneseng);
		int frances = traductor.Tipodeidioma(oracionesFran);
		oracionesspan.add("El perro hace la tarea en la casa");
		oracionesspan.add("El perro y el gato");
		oracioneseng.add("Bye the woman is leaving");
		oracioneseng.add("The dog is in town");
		oracionesFran.add("La femme a fait les devoirs");
		oracionesFran.add("'l'homme aime les lasagnes");
		assertEquals(2, español);
		assertEquals(1, inlges);
		assertEquals(3, frances);
	}

	@Test
	void AssociaTest(){
		
        
        ArrayList<String> busqueda = new ArrayList<String>();
		busqueda.add("dog,perro,chien");
		busqueda.add("woman,mujer,femme");
		busqueda.add("house,casa,loger");
		busqueda.add("homework,tarea,devoir");
		busqueda.add("town,pueblo,ville");
        
		traductor traductor = new traductor();
		traductor.abrirArchivo(busqueda);

		BinarySearchTree english = traductor.getEnglish();
		BinarySearchTree spanish = traductor.getSpanish();
		BinarySearchTree french = traductor.getFrench();
		Association perro = (Association) english.search("dog");
		Association mujer = (Association) spanish.search("mujer");
		Association bonjuor = (Association) french.search("bonjour");
		String[] tradu = (String[]) mujer.getValue();
		String[] traduc = (String[]) bonjuor.getValue();
		String[] trad = (String[]) perro.getValue();
		assertEquals("perro", trad[0]);
		assertEquals("femme", tradu[1]);
		assertEquals("hello", traduc[0]);

	}

	@Test
	void traductorTest(){
		
        traductor traductor = new traductor();

		ArrayList<String> busqueda = new ArrayList<String>();
		busqueda.add("dog,perro,chien");
		busqueda.add("woman,mujer,femme");
		busqueda.add("house,casa,loger");
		busqueda.add("homework,tarea,devoir");
		busqueda.add("town,pueblo,ville");

		traductor.abrirArchivo(busqueda);

		ArrayList<String> oracionesspan = new ArrayList<String>();
		ArrayList<String> oracioneseng = new ArrayList<String>();
		ArrayList<String> oracionesFran = new ArrayList<String>();
		oracionesspan.add("El perro hace la tarea en la casa");
		oracionesspan.add("El perro y el gato");
		oracioneseng.add("Bye the woman is leaving");
		oracioneseng.add("The dog is in town");
		oracionesFran.add("La femme a fait les devoirs");
		oracionesFran.add("'l'homme aime les lasagnes");

		String spanaing = traductor.traductor(oracionesspan, 0, 0);
		String spanafren = traductor.traductor(oracionesspan, 0, 0);
		String ingaspan = traductor.traductor(oracioneseng, 0, 0);
		String ingafen = traductor.traductor(oracioneseng, 0, 0);
		String frenaing = traductor.traductor(oracionesFran, 0, 0);
		String frenaspan = traductor.traductor(oracionesFran, 0, 0);
		String spanaingtrad = "\n *El* dog *hace* *la* homework *en* *la* house\n *El* dog *y* *el* *gato*";
		String spanafrentrad = "\n *El* chien *hace* *la* devoir *en* *la *loger\n *El* chiem *y* *el* gato";
		String ingaspantrad = "\n *Bye* *the* mujer *is* *leaving*\n *The* perro *is* *in* pueblo";
		String ingafrentrad = "\n *Bye* *the* femme *is* *leaving* \n *The* chien *in* *in* ville";
		String frenaingtrad = "\n *La* woman *a fait les* homework\n *l'homme* *aime* *les* *lasagnes";
		String frenaspantrad = "\n *La* mujer *a fait les* tarea\n *l'homme* *aime* *les* *lasagnes*";

		assertEquals(ingaspantrad, ingaspan);
		assertEquals(ingafrentrad, ingafen);
		assertEquals(spanaingtrad, spanaing);
		assertEquals(spanafrentrad, spanafren);
        assertEquals(frenaingtrad, frenaing);
        assertEquals(frenaspantrad, frenaspan);

	}

}
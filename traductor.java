import java.util.ArrayList;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * Clase traductor: clase que realiza todas las traducciones 
 */

public class traductor {
    
    //Atributos
    private BinarySearchTree<String, Association> english;
    private BinarySearchTree<String, Association> spanish;
    private BinarySearchTree<String, Association> french;
    private comparador compara;

    //Constructor sin parametros

    public traductor() {
        english = new BinarySearchTree<String, Association>(compara);
        spanish = new BinarySearchTree<String, Association>(compara);
        french = new BinarySearchTree<String, Association>(compara);
        compara = new comparador();
    }

    //Constructor con parametros

    public traductor(BinarySearchTree<String,Association> english, BinarySearchTree<String,Association> spanish, BinarySearchTree<String,Association> french, comparador compara) {
        this.english = english;
        this.spanish = spanish;
        this.french = french;
        this.compara = compara;
    }

    //Sets y Gets
    
    /** 
     * @return BinarySearchTree<String, Association>
     */
    public BinarySearchTree<String,Association> getEnglish() {
        return this.english;
    }

    
    /** 
     * @param english
     */
    public void setEnglish(BinarySearchTree<String,Association> english) {
        this.english = english;
    }

    
    /** 
     * @return BinarySearchTree<String, Association>
     */
    public BinarySearchTree<String,Association> getSpanish() {
        return this.spanish;
    }

    
    /** 
     * @param spanish
     */
    public void setSpanish(BinarySearchTree<String,Association> spanish) {
        this.spanish = spanish;
    }

    
    /** 
     * @return BinarySearchTree<String, Association>
     */
    public BinarySearchTree<String,Association> getFrench() {
        return this.french;
    }

    
    /** 
     * @param french
     */
    public void setFrench(BinarySearchTree<String,Association> french) {
        this.french = french;
    }

    
    /** 
     * @return comparador
     */
    public comparador getCompara() {
        return this.compara;
    }

    
    /** 
     * @param compara
     */
    public void setCompara(comparador compara) {
        this.compara = compara;
    }
    
    //Métodos
    
    /** 
     * @param linea
     */

    public void abrirArchivo(ArrayList<String> linea){
        
        for (String palabras : linea) {
            String[] traducciones = palabras.split(",");
            String plaeng = traducciones[0];
            String palspan = traducciones[1];
            String palfren = traducciones[2];
            
            String[] tradEnglish = {palspan, palfren};
            String[] tradSpan = {plaeng, palfren};
            String[] tradFren = {plaeng, palspan};
    
            Association entradaIngles = new Association<>(plaeng.toLowerCase(), tradEnglish);
            Association entradaEspaniol = new Association<>(palspan.toLowerCase(), tradSpan);
            Association entradaFrances = new Association<>(palfren.toLowerCase(), tradFren);
    
            english.insert(plaeng, entradaIngles);
            spanish.insert(palspan, entradaEspaniol);
            french.insert(palfren, entradaFrances);
        }
    }

    

    
    /** 
     * @param lenguage
     * @return String
     */
    public String palabrasEnOrden(int lenguage){
        String lol = "";
        revisador revisa = new revisador<String, Association>();
    
        switch (lenguage) {
            case 1: 
                lol = lol + "\n\nTraducción en Inglés" + "\n-----------------------";
                english.InOrderTraversal(revisa);
    
                for (int i = 0; i < revisa.getLista().size(); i++) {
                    Association Actual = (Association) revisa.getLista().get(i);
                    String[] traducciones = (String[]) Actual.getValue();
                    lol = lol + "\n\n" + Actual.getKey() + ": " + "\nEspañol: " + traducciones[0]
                            + "\nFrancés: " + traducciones[1];
                }
                break;
            case 2: 
                lol = lol + "\n\nTraducción en Español" + "\n-----------------------";
                spanish.InOrderTraversal(revisa);
    
                for (int i = 0; i < revisa.getLista().size(); i++) {
                    Association Actual = (Association) revisa.getLista().get(i);
                    String[] traducciones = (String[]) Actual.getValue();
                    lol = lol + "\n\n" + Actual.getKey() + ": " + "\nInglés: " + traducciones[0]
                            + "\nFrancés: " + traducciones[1];
                }
                break;
            case 3:
                lol = lol + "\n\nTraducción en Frances" + "\n-----------------------";
                french.InOrderTraversal(revisa);
    
                for (int i = 0; i < revisa.getLista().size(); i++) {
                    Association Actual = (Association) revisa.getLista().get(i);
                    String[] traducciones = (String[]) Actual.getValue();
                    lol = lol + "\n\n" + Actual.getKey() + ": " + "\nInglés: " + traducciones[0]
                            + "\nEspañol: " + traducciones[1];
                }
    
                break;
    
            default:
                lol = lol + "\nIngreso invalido";
                break;
        }
        return lol;
    }
    

    
    /** 
     * @param punto
     * @return int
     */
    public int Tipodeidioma(ArrayList<String> punto ){
        int contadorEng = 0;
        int contadorSpan = 0;
        int contadorFren = 0;
    
        for (String palabra : punto) {
            String[] palabras = palabra.split(" ");
    
            for (String estilo : palabras) {
                if (english.search(estilo) != null) {
                    contadorEng++;
                } else if (spanish.search(estilo) != null) {
                    contadorSpan++;
                } else if (french.search(estilo) != null) {
                    contadorFren++;
                }
            }
        }
    
        if (contadorEng >= contadorSpan && contadorEng >= contadorFren) {
            return 1;
        } else if (contadorSpan >= contadorEng && contadorSpan >= contadorFren) {
            return 2; 
        } else {
            return 3; 
        }
    }

    

    
    /** 
     * @param punto
     * @param origen
     * @param traducido
     * @return String
     */
    public String traductor(ArrayList<String> punto, int origen, int traducido){
        StringBuilder lol = new StringBuilder();
    
        for (String linea : punto) {
            lol.append("\n");
    
            String[] palabras = linea.split(" ");
            for (int i = 0; i < palabras.length; i++) {
                palabras[i] = palabras[i].toLowerCase();
            }
    
            for (String palabra : palabras) {
                BinarySearchTree<String, Association> bstOrigen;
                BinarySearchTree<String, Association> bstDestino;
    
                switch (origen) {
                    case 1:
                        bstOrigen = english;
                        break;
                    case 2:
                        bstOrigen = spanish;
                        break;
                    case 3:
                        bstOrigen = french;
                        break;
                    default:
                        continue;
                }
    
                Association<String, String[]> entradaOrigen = bstOrigen.search(palabra.toLowerCase());
                String[] traduccionesOrigen = entradaOrigen != null ? entradaOrigen.getValue() : null;
    
                if (traduccionesOrigen == null) {
                    lol.append(" *").append(palabra).append("*");
                    continue;
                }
    
                switch (traducido) {
                    case 1:
                        bstDestino = english;
                        break;
                    case 2:
                        bstDestino = english;
                        break;
                    case 3:
                        bstDestino = english;
                        break;
                    default:
                        continue;
                }
    
                String traduccionTraducido = null;
                if (traducido == origen) {
                    traduccionTraducido = traduccionesOrigen[1];
                } else {
                    Association<String, String[]> entradaDestino = bstDestino.search(traduccionesOrigen[traducido - 1]);
                    String[] traduccionTraducidos = entradaDestino != null ? entradaDestino.getValue() : null;
                    traduccionTraducido = traduccionTraducido != null ? traduccionTraducidos[0] : null;
                }
    
                if (traduccionTraducido == null) {
                    lol.append(" *").append(palabra).append("*");
                } else {
                    lol.append(" ").append(traduccionTraducido);
                }
            }
        }
    
        return lol.toString();
    }

    



}


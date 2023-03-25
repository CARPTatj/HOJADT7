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

    //Métodos
    
    /** 
     * @param linea
     */

    public void abrirArchivo(ArrayList<String> linea){
        
    }

    
    /** 
     * @param lenguage
     * @return String
     */
    public String palabrasEnOrden(int lenguage){
        return "";
    }

    
    /** 
     * @param punto
     * @return int
     */
    public int Tipodeidioma(ArrayList<String> punto ){
        return  0;
    }

    
    /** 
     * @param punto
     * @param origen
     * @param traducido
     * @return String
     */
    public String traductor(ArrayList<String> punto, int origen, int traducido){
        return "";
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


}


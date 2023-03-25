import java.util.ArrayList;

/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * Clase Visita: revisa cada uno de los nodos de los arboles binarion.
 */

public class revisador<K, V> implements ITraversal<K, V> {

    private ArrayList <Association> lista = new ArrayList<Association>();

    @Override
    public void visit(TreeNode<K, V> actualNode) {
        // TODO Auto-generated method stub
        Association ahora = (Association) actualNode.getValue();
        lista.add(ahora);
    }

    public ArrayList<Association> getLista() {
        return this.lista;
    }

    public void setLista(ArrayList<Association> lista) {
        this.lista = lista;
    }
    
}
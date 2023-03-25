/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * Interfaz ITraversal: crea la visita para nodo del arbol.
 * CLASE TOMADA DEL REPOSITORIO DEL PROFESOR
 */

/**
 * 
 */

/**
 * @author MAAG
 *
 */
public interface ITraversal<K, V> {

	void visit(TreeNode<K, V> actualNode);
	
}


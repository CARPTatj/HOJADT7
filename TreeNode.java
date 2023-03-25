/*
 * Alina Carías (22539)
 * Algoritmos y Estructuras de Datos Sección 40
 * Hoja de Trabajo 7
 * 24-03-2023
 * Clase TreeNode: crea un nodo para un binary search tree.
 * CLASE TOMADA DEL REPOSITORIA DEL PROFESOR
 */

/**
 * @author MAAG
 *
 */
public class TreeNode<K, V> {

	private K key;
	private V value;
	
	private TreeNode<K,V> left;
	private TreeNode<K,V> right;
	private TreeNode<K,V> parent;
	
	public TreeNode(K _key, V _value) {
		setKey(_key);
		setValue(_value);
		setLeft(null);
		setRight(null);
		setParent(null);
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return the left
	 */
	public TreeNode<K, V> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<K, V> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public TreeNode<K, V> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<K, V> right) {
		this.right = right;
	}

	/**
	 * @return the parent
	 */
	public TreeNode<K, V> getParent() {
		return parent;
	}

	/**
	 * @param parent the parent to set
	 */
	public void setParent(TreeNode<K, V> parent) {
		this.parent = parent;
	}
	
	
}

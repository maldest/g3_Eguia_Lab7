package Actividades.bstreeInterface;

import Actividades.Exceptions.ItemDuplicated;
import Actividades.Exceptions.ItemNoFound;
import Actividades.Exceptions.ExceptionIsEmpty;

public interface BinarySearchTree<E extends Comparable<E>> {
    void insert(E data) throws ItemDuplicated;     // Insertar un dato en el árbol
    E search(E data) throws ItemNoFound;          // Buscar un dato en el árbol
    void delete(E data) throws ExceptionIsEmpty;   // Eliminar un dato del árbol
    String toString();                             // Obtener representación en cadena del árbol
    boolean isEmpty();                             // Verificar si el árbol está vacío
}
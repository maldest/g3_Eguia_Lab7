package Actividades.bstreelinklistinterfgeneric;

import Actividades.Exceptions.ItemDuplicated;
import Actividades.Exceptions.ItemNoFound;
import Actividades.bstreeInterface.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import Actividades.Exceptions.ExceptionIsEmpty;

public class LinkedBST<E extends Comparable<E>> implements BinarySearchTree<E> {

    // Clase interna que define cómo es cada nodo del árbol
    class Node {
        public E data;       // Dato que guarda el nodo
        public Node left;    // Referencia al hijo izquierdo
        public Node right;   // Referencia al hijo derecho

        // Constructor con solo el dato (nodo sin hijos)
        public Node(E data) {
            this(data, null, null);
        }

        // Constructor completo: dato, hijo izquierdo y derecho
        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root; // Nodo raíz del árbol

    // Constructor: cuando creamos un BST, está vacío (raíz = null)
    public LinkedBST() {
        this.root = null;
    }

    // Método para insertar un elemento en el árbol
    @Override
    public void insert(E data) throws ItemDuplicated {
        // Insertamos desde la raíz
        root = insertRecursive(root, data);
    }

    // Método recursivo para insertar
    private Node insertRecursive(Node node, E data) throws ItemDuplicated {
        if (node == null) {
            // Si llegamos a un lugar vacío, insertamos el nodo
            return new Node(data);
        }

        int cmp = data.compareTo(node.data); // Comparamos el dato con el del nodo actual

        if (cmp < 0) {
            // Si es menor, vamos al subárbol izquierdo
            node.left = insertRecursive(node.left, data);
        } else if (cmp > 0) {
            // Si es mayor, vamos al subárbol derecho
            node.right = insertRecursive(node.right, data);
        } else {
            // Si es igual, ya existe: lanzamos excepción
            throw new ItemDuplicated("Dato duplicado: " + data);
        }

        return node; // Devolvemos el nodo con sus cambios
    }

    // Método para buscar un elemento en el árbol
    @Override
    public E search(E data) throws ItemNoFound {
        Node result = searchRecursive(root, data); // Buscamos desde la raíz

        if (result == null) {
            // Si no lo encontramos, lanzamos excepción
            throw new ItemNoFound("Dato no encontrado: " + data);
        }

        return result.data; // Si lo encontramos, devolvemos el dato
    }

    // Método recursivo para buscar
    private Node searchRecursive(Node node, E data) {
        if (node == null) return null; // Árbol vacío o subárbol vacío

        int cmp = data.compareTo(node.data);

        if (cmp == 0) {
            return node; // Encontramos el dato
        } else if (cmp < 0) {
            return searchRecursive(node.left, data); // Buscar a la izquierda
        } else {
            return searchRecursive(node.right, data); // Buscar a la derecha
        }
    }

    // Método para eliminar un dato del árbol
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null) {
            throw new ExceptionIsEmpty("El árbol está vacío");
        }

        root = deleteRecursive(root, data); // Llamamos al método auxiliar
    }

    // Método recursivo para eliminar
    private Node deleteRecursive(Node node, E data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);

        if (cmp < 0) {
            // El dato está en la izquierda
            node.left = deleteRecursive(node.left, data);
        } else if (cmp > 0) {
            // El dato está en la derecha
            node.right = deleteRecursive(node.right, data);
        } else {
            // Encontramos el nodo a eliminar

            // Caso 1: no tiene hijos
            if (node.left == null && node.right == null) {
                return null;
            }

            // Caso 2: un solo hijo
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Caso 3: dos hijos
            Node minNode = findMin(node.right); // Buscamos el menor en el subárbol derecho
            node.data = minNode.data; // Lo reemplazamos
            node.right = deleteRecursive(node.right, minNode.data); // Eliminamos el duplicado
        }

        return node;
    }

    // Método para encontrar el mínimo de un subárbol (usado en delete)
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
        // Método público que imprime en consola los pasos del recorrido inOrden explicativo
        public void inOrderExplicativo() {
            inOrderExplicativoRec(root);
        }

        // Método privado recursivo con impresión detallada paso a paso (izquierda – raíz – derecha)
        private void inOrderExplicativoRec(Node node) {
            if (node != null) {
                // Paso 1: Recorremos el subárbol izquierdo
                System.out.println("Recorrer el subárbol izquierdo en entreorden.");
                inOrderExplicativoRec(node.left);

                // Paso 2: Visitamos la raíz (nodo actual)
                System.out.println("Visitar la raíz: " + node.data);

                // Paso 3: Recorremos el subárbol derecho
                System.out.println("Recorrer el subárbol derecho en entreorden.");
                inOrderExplicativoRec(node.right);
            } else {
                // Cuando llegamos a un subárbol vacío
                System.out.println("Vacío");
            }
        }
                        // Método público que imprime en consola los pasos del recorrido preorden explicativo
                public void preOrderExplicativo() {
                    preOrderExplicativoRec(root);
                }

                // Método privado recursivo con impresión paso a paso
                private void preOrderExplicativoRec(Node node) {
                    if (node != null) {
                        // Paso 1: Visitar la raíz
                        System.out.println("Visitar la raíz: " + node.data);

                        // Paso 2: Recorrer el subárbol izquierdo
                        System.out.println("Recorrer el subárbol izquierdo en preorden.");
                        preOrderExplicativoRec(node.left);

                        // Paso 3: Recorrer el subárbol derecho
                        System.out.println("Recorrer el subárbol derecho en preorden.");
                        preOrderExplicativoRec(node.right);
                    } else {
                        // Cuando el subárbol está vacío
                        System.out.println("Vacío");
                    }
                }
                // Método público que devuelve el recorrido PostOrden como una cadena
                public String postOrder() {
                    StringBuilder recorrido = new StringBuilder();
                    postOrderRec(root, recorrido);
                    return recorrido.toString().trim(); // Elimina el último espacio
                }

                // Método privado recursivo: izquierda → derecha → raíz
                private void postOrderRec(Node node, StringBuilder recorrido) {
                    if (node != null) {
                        postOrderRec(node.left, recorrido);     // Subárbol izquierdo
                        postOrderRec(node.right, recorrido);    // Subárbol derecho
                        recorrido.append(node.data).append(" "); // Visitar raíz
                    }
                }

        // Método público que imprime paso a paso el recorrido PostOrden (explicativo)
            public void postOrderExplicativo() {
                postOrderExplicativoRec(root);
            }

            // Método privado recursivo con mensajes detallados
            private void postOrderExplicativoRec(Node node) {
                if (node != null) {
                    // Paso 1: Subárbol izquierdo
                    System.out.println("Recorrer el subárbol izquierdo en postorden.");
                    postOrderExplicativoRec(node.left);

                    // Paso 2: Subárbol derecho
                    System.out.println("Recorrer el subárbol derecho en postorden.");
                    postOrderExplicativoRec(node.right);

                    // Paso 3: Visitar la raíz
                    System.out.println("Visitar la raíz: " + node.data);
                } else {
                    // Caso de subárbol vacío
                    System.out.println("Vacío");
                }
            }
    // Método privado para encontrar el menor valor en el subárbol que parte desde 'node'
    private E findMinNode(E nodeValue) throws ItemNoFound {
        // Validamos que el nodo existe usando el método público search()
        Node node = searchRecursive(root, nodeValue);

        if (node == null) {
            throw new ItemNoFound("No se encontró el nodo raíz para buscar el mínimo.");
        }

        // Vamos todo a la izquierda hasta encontrar el menor
        while (node.left != null) {
            node = node.left;
        }

        return node.data;
    }
        // Método privado para encontrar el mayor valor en el subárbol que parte desde 'node'
    private E findMaxNode(E nodeValue) throws ItemNoFound {
        // Validamos que el nodo existe usando el método público search()
        Node node = searchRecursive(root, nodeValue);

        if (node == null) {
            throw new ItemNoFound("No se encontró el nodo raíz para buscar el máximo.");
        }

        // Vamos todo a la derecha hasta encontrar el mayor
        while (node.right != null) {
            node = node.right;
        }

        return node.data;
    }
        // Métodos públicos para poder probar findMinNode y findMaxNode desde main
        public E findMinDesde(E desde) throws ItemNoFound {
            return findMinNode(desde);
        }

        public E findMaxDesde(E desde) throws ItemNoFound {
            return findMaxNode(desde);
        }
        //////Ejercicio 1//////////////
            // a. Elimina todos los nodos del árbol BST
        public void destroyNodes() throws ExceptionIsEmpty {
            if (root == null) {
                // Si ya está vacío, lanzamos excepción
                throw new ExceptionIsEmpty("El árbol ya está vacío.");
            }

            root = null; // Al hacer esto, todo el árbol se elimina (el recolector de basura se encarga)
        }

        // b. Cuenta todos los nodos (hojas y no-hojas)
        public int countAllNodes() {
            return countAllNodesRec(root);
        }

        private int countAllNodesRec(Node node) {
            if (node == null) return 0;

            // Contamos este nodo + lo que hay a la izquierda + lo que hay a la derecha
            return 1 + countAllNodesRec(node.left) + countAllNodesRec(node.right);
        }

        // c. Cuenta solo los nodos que NO son hojas
        public int countNodes() {
            return countNodesRec(root);
        }

        private int countNodesRec(Node node) {
            if (node == null) return 0;

            // Si no tiene hijos, es una hoja → no se cuenta
            if (node.left == null && node.right == null) return 0;

            // Es un nodo no-hoja → se cuenta
            return 1 + countNodesRec(node.left) + countNodesRec(node.right);
        }

        // d. Devuelve la altura de un subárbol cuyo nodo raíz es igual a x (forma iterativa)
        public int height(E x) {
            Node start = searchRecursive(root, x); // Reutilizamos el buscador interno

            if (start == null) return -1; // Si no existe el nodo x, devolvemos -1

            Queue<Node> queue = new LinkedList<>(); // Usamos una cola para BFS
            queue.add(start);
            int height = -1;

            while (!queue.isEmpty()) {
                int size = queue.size(); // Nodos en el nivel actual
                height++;

                for (int i = 0; i < size; i++) {
                    Node current = queue.poll();

                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }
            }

            return height;
        }

        // e. Devuelve cuántos nodos existen en el nivel indicado (amplitud)
        public int amplitude(int nivelObjetivo) {
            if (root == null) return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int nivel = 0;

            while (!queue.isEmpty()) {
                int size = queue.size(); // Nodos en este nivel

                if (nivel == nivelObjetivo) {
                    return size; // Retornamos la cantidad de nodos en ese nivel
                }

                for (int i = 0; i < size; i++) {
                    Node current = queue.poll();
                    if (current.left != null) queue.add(current.left);
                    if (current.right != null) queue.add(current.right);
                }

                nivel++; // Pasamos al siguiente nivel
            }

            return 0; // Si el nivel no existe, devolvemos 0
        }
        ///EJERCICIO 2
        // 🔹 MÉTODO A: Calcula el área del árbol (número de hojas × altura desde la raíz)
        public int areaBST() {
            if (root == null) return 0;

            int altura = height(root.data);           // Usamos el método height(x) ya implementado
            int hojas = contarHojasIterativo();       // Contamos hojas sin usar recursividad

            return altura * hojas;                    // Definición del área = hojas × altura
        }

        // Método privado que cuenta las hojas de manera iterativa (usamos cola - BFS)
        private int contarHojasIterativo() {
            if (root == null) return 0;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int hojas = 0;

            while (!queue.isEmpty()) {
                Node actual = queue.poll();

                // Si no tiene hijos, es una hoja
                if (actual.left == null && actual.right == null) {
                    hojas++;
                }

                // Agregamos los hijos si existen
                if (actual.left != null) queue.add(actual.left);
                if (actual.right != null) queue.add(actual.right);
            }

            return hojas;
        }
        // 🔹 MÉTODO B: Dibuja el árbol BST como texto estructurado (tipo indentado)
        public void drawBST() {
            drawBSTRec(root, 0); // Comenzamos desde la raíz con nivel 0
        }

        // Método privado que imprime el nodo y sus hijos con indentación según el nivel
        private void drawBSTRec(Node node, int nivel) {
            if (node == null) {
                // Si el nodo es nulo, mostramos un * como símbolo de rama vacía
                System.out.println(" ".repeat(nivel * 2) + "*");
                return;
            }

            // Mostramos el dato del nodo actual, con indentación según el nivel
            System.out.println(" ".repeat(nivel * 2) + node.data);

            // Llamamos recursivamente para imprimir los hijos (izquierda y derecha)
            drawBSTRec(node.left, nivel + 1);
            drawBSTRec(node.right, nivel + 1);
        }
/////////////Ejercicio 3//////////////////
        // Método público para mostrar la representación parenthesize con sangría
        public void parenthesize() {
            parenthesizeRec(root, 0); // Llama al método auxiliar desde la raíz con nivel 0
        }

        // Método recursivo con indentación y formato de paréntesis
        private void parenthesizeRec(Node node, int nivel) {
            if (node == null) return;

            // Imprimimos el nodo con la sangría correspondiente
            System.out.print(" ".repeat(nivel * 2) + node.data);

            // Si tiene al menos un hijo, abrimos paréntesis
            if (node.left != null || node.right != null) {
                System.out.println(" ("); // Línea de apertura

                // Recorremos el hijo izquierdo con sangría aumentada
                if (node.left != null) parenthesizeRec(node.left, nivel + 1);

                // Recorremos el hijo derecho con sangría aumentada
                if (node.right != null) parenthesizeRec(node.right, nivel + 1);

                // Cerramos el bloque
                System.out.println(" ".repeat(nivel * 2) + ")");
            } else {
                // Si no tiene hijos, hacemos salto de línea simple
                System.out.println();
            }
        }

        @Override
        public boolean isEmpty() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
        }
}

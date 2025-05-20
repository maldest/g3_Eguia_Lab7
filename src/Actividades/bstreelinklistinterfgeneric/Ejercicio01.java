package Actividades.bstreelinklistinterfgeneric;

public class Ejercicio01 {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree = new LinkedBST<>();

            tree.insert(400);
            tree.insert(100);
            tree.insert(700);
            tree.insert(50);
            tree.insert(75);
            tree.insert(200);

            System.out.println("Total de nodos (todos): " + tree.countAllNodes());      // 6
            System.out.println("Nodos no-hoja: " + tree.countNodes());                 // 3
            System.out.println("Altura desde nodo 100: " + tree.height(100));          // 2
            System.out.println("Nodos en nivel 2 (amplitud): " + tree.amplitude(2));   // 2

            tree.destroyNodes(); // Debería vaciar el árbol
            System.out.println("Intentando destruir otra vez:");
            tree.destroyNodes(); // Esto lanzará ExceptionIsEmpty

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}

package Actividades.bstreelinklistinterfgeneric;

public class Ejercicio02 {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> arbol1 = new LinkedBST<>();
            arbol1.insert(400);
            arbol1.insert(100);
            arbol1.insert(700);
            arbol1.insert(50);
            arbol1.insert(75);
            arbol1.insert(200);

            LinkedBST<Integer> arbol2 = new LinkedBST<>();
            arbol2.insert(50);
            arbol2.insert(25);
            arbol2.insert(75);
            arbol2.insert(10);
            arbol2.insert(30);

            System.out.println("Área del árbol 1: " + arbol1.areaBST());
            System.out.println("Área del árbol 2: " + arbol2.areaBST());

            System.out.println("¿Tienen la misma área? " + sameArea(arbol1, arbol2));

            System.out.println("\nDibujo del árbol 1:");
            arbol1.drawBST();

            System.out.println("\nDibujo del árbol 2:");
            arbol2.drawBST();

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Método sameArea() puede ir aquí si no tienes clase Prueba separada
    public static boolean sameArea(LinkedBST<?> a, LinkedBST<?> b) {
        return a.areaBST() == b.areaBST();
    }
}


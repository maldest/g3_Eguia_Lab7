package Actividades.bstreelinklistinterfgeneric;

public class postOrden {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree = new LinkedBST<>();

            // Insertamos los mismos valores del ejemplo
            tree.insert(400);
            tree.insert(100);
            tree.insert(700);
            tree.insert(50);
            tree.insert(75);
            tree.insert(200);

            // Salida del recorrido como cadena
            System.out.println("Recorrido PostOrden: " + tree.postOrder());

            // Salida detallada paso a paso
            System.out.println("\n>>> RECORRIDO POSTORDEN EXPLICATIVO <<<\n");
            tree.postOrderExplicativo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

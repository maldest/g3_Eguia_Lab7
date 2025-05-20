package Actividades.bstreelinklistinterfgeneric;

public class preOrden {
public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree = new LinkedBST<>();

            // Insertamos los mismos valores del ejemplo gráfico
            tree.insert(400);
            tree.insert(100);
            tree.insert(700);
            tree.insert(50);
            tree.insert(75);
            tree.insert(200);

            // Llamamos al recorrido explicativo
            System.out.println(">>> RECORRIDO PREORDEN EXPLICATIVO <<<\n");
            tree.preOrderExplicativo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package Actividades.bstreelinklistinterfgeneric;

public class inOrden {
public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree = new LinkedBST<>();

            // Insertamos los valores del ejemplo
            tree.insert(400);
            tree.insert(100);
            tree.insert(700);
            tree.insert(50);
            tree.insert(75);
            tree.insert(200);

            // Llamamos al recorrido explicativo
            System.out.println(">>> RECORRIDO INORDEN EXPLICATIVO <<<\n");
            tree.inOrderExplicativo();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



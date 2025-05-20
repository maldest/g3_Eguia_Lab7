package Actividades.bstreelinklistinterfgeneric;

public class Ejercicio03 {
      public static void main(String[] args) {
        try {
            LinkedBST<String> tree = new LinkedBST<>();

            // Creamos el árbol similar al gráfico
            tree.insert("Sales");
            tree.insert("Domestic");
            tree.insert("International");
            tree.insert("Canada");
            tree.insert("S. America");
            tree.insert("Overseas");
            tree.insert("Africa");
            tree.insert("Europe");
            tree.insert("Asia");
            tree.insert("Australia");

            System.out.println(">>> Representación Parenthesize <<<\n");
            tree.parenthesize();

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}

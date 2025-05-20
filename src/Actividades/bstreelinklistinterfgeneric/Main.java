package Actividades.bstreelinklistinterfgeneric;
import Actividades.Exceptions.ItemDuplicated;
import Actividades.Exceptions.ItemNoFound;

public class Main {
    public static void main(String[] args) {
        try {
            LinkedBST<Integer> tree = new LinkedBST<>();

            // Insertamos datos
            tree.insert(400);
            tree.insert(100);
            tree.insert(700);
            tree.insert(50);
            tree.insert(75);
            tree.insert(200);

            // Mínimo desde 100
            Integer minimo = tree.findMinDesde(100);
            System.out.println("Mínimo desde 100: " + minimo); // → 50

            // Máximo desde 100
            Integer maximo = tree.findMaxDesde(100);
            System.out.println("Máximo desde 100: " + maximo); // → 200

            // Mínimo desde 700
            System.out.println("Mínimo desde 700: " + tree.findMinDesde(700)); // → 700

        } catch (ItemNoFound e) {
            System.out.println(" Error: " + e.getMessage());
        } catch (ItemDuplicated e) {
            System.out.println(" Dato duplicado.");
        } catch (Exception e) {
            System.out.println(" Otro error.");
        }
    }
}
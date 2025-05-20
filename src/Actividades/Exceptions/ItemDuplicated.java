public class ItemDuplicated extends Exception {

    // Constructor con mensaje personalizado
    public ItemDuplicated(String msg) {
        super(msg); // Llama al constructor de Exception con mensaje
    }

    // Constructor sin mensaje
    public ItemDuplicated() {
        super("Elemento duplicado en el árbol"); // Mensaje por defecto
    }
}
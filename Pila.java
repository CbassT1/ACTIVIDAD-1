public class Pila {
    private Node top;

    public void push(String data) {
        Node nuevo = new Node(data);
        nuevo.next = top;
        top = nuevo;
        System.out.println("Comando agregado: " + data);
        mostrar();
    }

    public String pop() {
        if (top == null) {
            System.out.println("Pila vacia");
            return null;
        }
        String dato = top.data;
        top = top.next;
        System.out.println("Comando eliminado: " + dato);
        mostrar();
        return dato;
    }

    public String peek() {
        return top == null ? "Pila vacia" : top.data;
    }

    public boolean estaVacia() {
        return top == null;
    }

    public void mostrar() {
        if (top == null) {
            System.out.println("Pila vacia\n");
            return;
        }

        Node actual = top;
        while (actual != null) {
            String data = actual.data;
            String borde = "|" + "─".repeat(data.length()) + "|";
            System.out.println(borde);
            System.out.println("|" + data + "|");
            actual = actual.next;
        }

        // Borde final del último elemento
        String ultimoDato = top.data;
        String bordeFinal = "|" + "─".repeat(ultimoDato.length()) + "|";
        System.out.println(bordeFinal + "\n");
    }
}

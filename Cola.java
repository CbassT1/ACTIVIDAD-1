public class Cola {
    private Node front;
    private Node rear;

    public void enqueue(String data) {
        Node nuevo = new Node(data);
        if (rear == null) {
            front = rear = nuevo;
            return;
        }
        rear.next = nuevo;
        rear = nuevo;
    }

    public String dequeue() {
        if (front == null) return "Cola vacia";
        String dato = front.data;
        front = front.next;
        if (front == null) rear = null;
        return dato;
    }

    public String peek() {
        return front == null ? "Cola vacia" : front.data;
    }

    public boolean estaVacia() {
        return front == null;
    }

    public void mostrar() {
        Node actual = front;
        if (actual == null) {
            System.out.println("Cola vacia");
            return;
        }
        while (actual != null) {
            System.out.print(actual.data + (actual.next != null ? " -> " : ""));
            actual = actual.next;
        }
        System.out.println();
    }
}

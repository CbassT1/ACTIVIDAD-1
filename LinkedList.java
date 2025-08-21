import java.util.Scanner;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;
    private String type;

    public LinkedList(String type) {
        this.type = type;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            if (type.equals("circular")) {
                head.next = head;
                head.prev = head;
            }
        } else if (type.equals("simple")) {
            tail.next = newNode;
            tail = newNode;
        } else if (type.equals("doble")) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else if (type.equals("circular")) {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    public void display() {
        if (head == null) {
            System.out.println("Lista vacia\n");
            return;
        }
        Node current = head;
        int count = 0;
        if (type.equals("circular")) {
            do {
                System.out.print(current.data);
                count++;
                if (count < size) System.out.print(" -> ");
                current = current.next;
            } while (current != head);
        } else {
            while (current != null) {
                System.out.print(current.data);
                count++;
                if (count < size) System.out.print(" -> ");
                current = current.next;
            }
        }
        System.out.println("\n");
    }

    public void delete(int index) {
        if (index < 1 || index > size) {
            System.out.println("Indice no valido\n");
            return;
        }
        if (size == 1) {
            head = null;
            tail = null;
        } else if (index == 1) {
            if (type.equals("circular")) {
                head = head.next;
                head.prev = tail;
                tail.next = head;
            } else {
                head = head.next;
                if (head != null) head.prev = null;
            }
        } else if (index == size) {
            if (type.equals("circular")) {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            } else {
                tail = tail.prev;
                if (tail != null) tail.next = null;
            }
        } else {
            Node current = head;
            for (int i = 1; i < index; i++) current = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        System.out.println("Elemento eliminado\n");
    }

    public void search(String data) {
        if (head == null) {
            System.out.println("Lista vacia\n");
            return;
        }
        Node current = head;
        int index = 1;
        boolean found = false;
        if (type.equals("circular")) {
            do {
                if (current.data.equals(data)) {
                    System.out.println("Elemento encontrado en posicion " + index + "\n");
                    found = true;
                    break;
                }
                current = current.next;
                index++;
            } while (current != head);
        } else {
            while (current != null) {
                if (current.data.equals(data)) {
                    System.out.println("Elemento encontrado en posicion " + index + "\n");
                    found = true;
                    break;
                }
                current = current.next;
                index++;
            }
        }
        if (!found) System.out.println("Elemento no encontrado\n");
    }

    public String buildContact(Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        String telefono;
        while (true) {
            System.out.print("Telefono: ");
            telefono = sc.nextLine();
            if (telefono.matches("\\d+")) break;
            else System.out.println("Telefono no valido, ingrese solo numeros");
        }
        System.out.print("Direccion: ");
        String direccion = sc.nextLine();
        return nombre + " | " + telefono + " | " + direccion;
    }

    public void mostrar() {
        if (head == null) {
            System.out.println("Lista vacia\n");
            return;
        }
        Node actual = head;
        while (actual != null) {
            System.out.print(actual.data);
            if (actual.next != null) System.out.print(" -> ");
            actual = actual.next;
        }
        System.out.println("\n");
    }
}


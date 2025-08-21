import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList lista = null;

        Pila pila = new Pila();
        Cola cola = new Cola();

        while (true) {
            System.out.println("1) Gestionar contactos");
            System.out.println("2) Gestionar historial de comandos (Pila)");

            System.out.println("3) Gestionar programas en ejecucion (Cola)");
            System.out.println("4) Salir");

            System.out.print("Opcion: ");
            String opcion = sc.nextLine().trim();

            if (opcion.equals("1")) {
                while (true) {
                    System.out.println("Seleccione tipo de lista");
                    System.out.println("1) Lista simple");
                    System.out.println("2) Lista doble");
                    System.out.println("3) Lista circular");
                    System.out.println("4) Volver");
                    System.out.print("Opcion: ");
                    String tipoLista = sc.nextLine().trim();

                    if (tipoLista.equals("4")) break;

                    if (tipoLista.equals("1")) {
                        lista = new LinkedList("simple");
                        System.out.println("Eligio lista simple\n");
                    } else if (tipoLista.equals("2")) {
                        lista = new LinkedList("doble");
                        System.out.println("Eligio lista doble\n");
                    } else if (tipoLista.equals("3")) {
                        lista = new LinkedList("circular");
                        System.out.println("Eligio lista circular\n");
                    } else {
                        System.out.println("Opcion no valida\n");
                        continue;
                    }

                    while (true) {
                        System.out.println("1) Insertar contacto");
                        System.out.println("2) Mostrar contactos");
                        System.out.println("3) Eliminar contacto");
                        System.out.println("4) Volver");
                        System.out.print("Opcion: ");
                        String choice = sc.nextLine().trim();

                        if (choice.equals("1")) {
                            System.out.println("Eligio insertar contacto\n");
                            while (true) {
                                String contacto = lista.buildContact(sc);
                                lista.insert(contacto);

                                String again;
                                while (true) {
                                    System.out.print("Desea agregar otro contacto? (s/n): ");
                                    again = sc.nextLine().trim().toLowerCase();
                                    if (again.equals("s") || again.equals("si")) break;
                                    else if (again.equals("n") || again.equals("no")) break;
                                    else System.out.println("Entrada no valida. Escriba 's', 'si', 'n' o 'no'.");
                                }

                                if (again.equals("n") || again.equals("no")) break;
                            }
                        }else if (choice.equals("2")) {
                            System.out.println("Eligio mostrar contactos\n");
                            lista.mostrar();

                        } else if (choice.equals("3")) {
                            System.out.print("Numero del contacto a eliminar: ");
                            try {
                                int index = Integer.parseInt(sc.nextLine().trim());
                                lista.delete(index);
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada no valida\n");
                            }
                        } else if (choice.equals("4")) break;
                        else System.out.println("Opcion no valida\n");
                    }
                }

            } else if (opcion.equals("2")) {
                while (true) {
                    System.out.println("1) Agregar comando (push)");
                    System.out.println("2) Deshacer comando (pop)");
                    System.out.println("3) Ver ultimo comando (peek)");
                    System.out.println("4) Mostrar historial");
                    System.out.println("5) Volver");
                    System.out.print("Opcion: ");
                    String choice = sc.nextLine().trim();

                    if (choice.equals("1")) {
                        System.out.print("Ingrese comando: ");
                        pila.push(sc.nextLine());
                        System.out.println("Comando agregado\n");
                    } else if (choice.equals("2")) {
                        System.out.println("Comando eliminado: " + pila.pop() + "\n");
                    } else if (choice.equals("3")) {
                        System.out.println("Ultimo comando: " + pila.peek() + "\n");
                    } else if (choice.equals("4")) {
                        pila.mostrar();
                        System.out.println();
                    } else if (choice.equals("5")) break;
                    else System.out.println("Opcion no valida\n");
                }

            } else if (opcion.equals("3")) {
                while (true) {
                    System.out.println("1) Agregar programa (enqueue)");
                    System.out.println("2) Ejecutar programa (dequeue)");
                    System.out.println("3) Ver siguiente programa (peek)");
                    System.out.println("4) Mostrar cola");
                    System.out.println("5) Volver");
                    System.out.print("Opcion: ");
                    String choice = sc.nextLine().trim();

                    if (choice.equals("1")) {
                        System.out.print("Ingrese nombre del programa: ");
                        cola.enqueue(sc.nextLine());
                        System.out.println("Programa agregado\n");
                    } else if (choice.equals("2")) {
                        System.out.println("Programa ejecutado: " + cola.dequeue() + "\n");
                    } else if (choice.equals("3")) {
                        System.out.println("Siguiente programa: " + cola.peek() + "\n");
                    } else if (choice.equals("4")) {
                        cola.mostrar();
                        System.out.println();
                    } else if (choice.equals("5")) break;
                    else System.out.println("Opcion no valida\n");
                }

            } else if (opcion.equals("4")) {
                break;
            } else {
                System.out.println("Opcion no valida\n");
            }
        }

        sc.close();
    }
}

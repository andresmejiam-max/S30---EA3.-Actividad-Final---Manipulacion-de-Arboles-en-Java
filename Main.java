import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println("\n===== Tree-Stock =====");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Mostrar Inventario");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = leerEntero(sc);

            switch (opcion) {

                case 1:
                    System.out.print("ID del producto: ");
                    int idNuevo = leerEntero(sc);

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    inventario.insertar(idNuevo, nombre);
                    System.out.println("Producto registrado -> ID " + idNuevo + " - " + nombre);
                    break;

                case 2:
                    System.out.println("\n--- Inventario (ordenado por ID) ---");
                    inventario.recorridoInorden();
                    break;

                case 3:
                    System.out.print("ID a buscar: ");
                    int idBuscado = leerEntero(sc);

                    if (inventario.buscar(idBuscado)) {
                        System.out.println("El producto con ID " + idBuscado + " existe en el inventario.");
                    } else {
                        System.out.println("No existe ningún producto con ID " + idBuscado + ".");
                    }
                    break;

                case 4:
                    System.out.print("ID a eliminar: ");
                    int idEliminar = leerEntero(sc);

                    if (inventario.eliminar(idEliminar)) {
                        System.out.println("Producto con ID " + idEliminar + " eliminado del inventario.");
                    } else {
                        System.out.println("No existe ningún producto con ID " + idEliminar + ".");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo de Tree-Stock...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    // Valida que lo ingresado sea un número entero.
    static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Ingrese un número entero.");
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea pendiente para las próximas lecturas de texto
        return valor;
    }
}

public class ArbolInventario {

    private Producto raiz;

    public ArbolInventario() {
        this.raiz = null;
    }

    // Inserta un producto ubicando su lugar por ID: menor a la izquierda, mayor a la derecha.
    public void insertar(int id, String nombre) {
        raiz = insertar(raiz, id, nombre);
    }

    private Producto insertar(Producto nodo, int id, String nombre) {
        if (nodo == null) {
            return new Producto(id, nombre);
        }
        if (id < nodo.id) {
            nodo.izquierdo = insertar(nodo.izquierdo, id, nombre);
        } else if (id > nodo.id) {
            nodo.derecho = insertar(nodo.derecho, id, nombre);
        } else {
            System.out.println("Ya existe un producto con el ID " + id + ".");
        }
        return nodo;
    }

    // Recorrido inorden (izquierda, raíz, derecha): entrega los productos ordenados por ID.
    public void recorridoInorden() {
        if (raiz == null) {
            System.out.println("El inventario está vacío.");
            return;
        }
        recorridoInorden(raiz);
    }

    private void recorridoInorden(Producto nodo) {
        if (nodo == null) {
            return;
        }
        recorridoInorden(nodo.izquierdo);
        System.out.println("ID: " + nodo.id + " - " + nodo.nombre);
        recorridoInorden(nodo.derecho);
    }

    // Busca un producto por ID descartando en cada paso la mitad del árbol que no puede contenerlo.
    public boolean buscar(int id) {
        return buscar(raiz, id);
    }

    private boolean buscar(Producto nodo, int id) {
        if (nodo == null) {
            return false;
        }
        if (id == nodo.id) {
            return true;
        }
        return id < nodo.id ? buscar(nodo.izquierdo, id) : buscar(nodo.derecho, id);
    }
}

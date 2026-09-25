# S30 - EA3. Manipulación de Árboles en Java - Tree-Stock

## Objetivo
Comprender el concepto de árbol binario de búsqueda (ABB) y su estructura lógica, aplicándolo en un sistema de clasificación de inventario (Tree-Stock), implementado en Java con estructuras de nodos manuales.

## ¿Qué es un árbol binario de búsqueda (ABB)?
Un árbol binario de búsqueda es una estructura de datos jerárquica en la que cada nodo tiene como máximo dos hijos (izquierdo y derecho), y se cumple una propiedad de orden: para cualquier nodo, todos los valores del subárbol izquierdo son **menores** que él, y todos los del subárbol derecho son **mayores**. Esa propiedad es la que permite ubicar, insertar y buscar un elemento sin recorrer todo el árbol.

En este proyecto cada nodo es un `Producto`, con un `id` (la clave que define su posición) y un `nombre`, más los punteros `izquierdo` y `derecho` hacia sus hijos. El punto de entrada al árbol es la `raiz`, guardada en `ArbolInventario`.

### Recursividad en el inventario
Las tres operaciones del árbol se resuelven de forma recursiva, delegando en los subárboles hasta llegar a un caso base:

- **Insertar**: se compara el `id` a insertar contra el nodo actual. Si es menor, la inserción se repite sobre `nodo.izquierdo`; si es mayor, sobre `nodo.derecho`. El caso base es un puntero `null`: ahí es donde realmente no hay más árbol que recorrer, así que se crea el nuevo `Producto` y se devuelve para que el nodo padre lo enlace.
- **Recorrido inorden**: primero se recorre por completo el subárbol izquierdo, luego se imprime el nodo actual, y después se recorre el subárbol derecho. Como el árbol respeta la propiedad de orden del ABB, este recorrido entrega los productos ya ordenados por ID sin necesidad de ordenarlos aparte.
- **Buscar**: en cada nodo se compara el ID buscado contra el ID del nodo. Si coincide, se encontró; si es menor se sigue por la izquierda, si es mayor por la derecha. Al no repetir ninguna rama ya descartada, cada llamada reduce el espacio de búsqueda a la mitad del subárbol restante.

## Estructura del proyecto
| Archivo | Responsabilidad |
|---|---|
| [`Producto.java`](Producto.java) | Nodo del árbol: `id`, `nombre` y los punteros `izquierdo` / `derecho`. |
| [`ArbolInventario.java`](ArbolInventario.java) | Lógica del árbol: `insertar`, `recorridoInorden` y `buscar`, todos recursivos. |
| [`Main.java`](Main.java) | Menú interactivo en consola. |

## Cómo ejecutar
Requiere JDK (Eclipse Temurin recomendado) y VS Code con la extensión de Java.

```bash
javac *.java
java Main
```

## Menú
```
1. Registrar Producto -> pide ID y nombre, e inserta el nodo en el árbol.
2. Mostrar Inventario  -> recorrido inorden: lista los productos ordenados por ID.
3. Buscar Producto     -> pide un ID y confirma si existe o no.
0. Salir
```

## Ejemplo de uso
```
1. Registrar Producto -> ID 50, Teclado
1. Registrar Producto -> ID 30, Mouse
1. Registrar Producto -> ID 70, Monitor
1. Registrar Producto -> ID 20, Cable USB
2. Mostrar Inventario  -> 20 Cable USB, 30 Mouse, 50 Teclado, 70 Monitor
3. Buscar Producto -> ID 30 -> "El producto con ID 30 existe en el inventario."
3. Buscar Producto -> ID 99 -> "No existe ningún producto con ID 99."
```

## Autores
- Andrés Mejía

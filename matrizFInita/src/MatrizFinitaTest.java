import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MatrizFinitaTest {

    @Test
    public void testCrearMatrizVacia() {
        MatrizFinita matriz = new MatrizFinita(3, 3);
        for (int i = 0; i < matriz.getFilas(); i++) {
            for (int j = 0; j < matriz.getColumnas(); j++) {
                assertEquals(0, matriz.obtener(i, j), "La matriz vacía debe devolver 0 en todas las posiciones.");
            }
        }
    }

    @Test
    public void testDefinirYObtener() {
        MatrizFinita matriz = new MatrizFinita(3, 3);
        matriz.definir(1, 1, 5);
        matriz.definir(0, 2, 10);

        assertEquals(5, matriz.obtener(1, 1), "Debe devolver el valor definido en (1,1).");
        assertEquals(10, matriz.obtener(0, 2), "Debe devolver el valor definido en (0,2).");
        assertEquals(0, matriz.obtener(2, 2), "Debe devolver 0 en posiciones no definidas.");
    }

    @Test
    public void testDefinirCeroEliminaElemento() {
        MatrizFinita matriz = new MatrizFinita(3, 3);
        matriz.definir(1, 1, 5);
        matriz.definir(1, 1, 0);

        assertEquals(0, matriz.obtener(1, 1), "Definir 0 debe eliminar el elemento de la matriz.");
    }

    @Test
    public void testSumaDeMatrices() {
        MatrizFinita matriz1 = new MatrizFinita(3, 3);
        MatrizFinita matriz2 = new MatrizFinita(3, 3);

        matriz1.definir(0, 0, 3);
        matriz1.definir(1, 1, 5);
        matriz2.definir(0, 0, 7);
        matriz2.definir(2, 2, 10);

        MatrizFinita suma = matriz1.sumarMatrices(matriz2);

        assertEquals(10, suma.obtener(0, 0), "La suma en (0,0) debe ser 10.");
        assertEquals(5, suma.obtener(1, 1), "La suma en (1,1) debe ser 5.");
        assertEquals(10, suma.obtener(2, 2), "La suma en (2,2) debe ser 10.");
        assertEquals(0, suma.obtener(1, 2), "Debe devolver 0 en posiciones no definidas.");
    }

    @Test
    public void testSumaMatricesDimensionesDistintas() {
        MatrizFinita matriz1 = new MatrizFinita(3, 3);
        MatrizFinita matriz2 = new MatrizFinita(2, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            matriz1.sumarMatrices(matriz2);
        });

        assertEquals("Las matrices deben tener las mismas dimensiones", exception.getMessage());
    }

    @Test
    public void testIndiceFueraDeLimites() {
        MatrizFinita matriz = new MatrizFinita(3, 3);

        // Prueba al definir un valor fuera de los límites
        Exception exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            matriz.definir(3, 3, 5); // Índices fuera de límites (3,3)
        });
        assertEquals("Posición fuera de los límites de la matriz", exception1.getMessage());

        // Prueba al obtener un valor fuera de los límites
        Exception exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            matriz.obtener(-1, 0); // Índices fuera de límites (-1,0)
        });
        assertEquals("Posición fuera de los límites de la matriz", exception2.getMessage());
    }
}

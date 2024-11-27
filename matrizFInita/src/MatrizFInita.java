import java.util.LinkedList;

class MatrizFinita {
    private LinkedList<ElemMatriz> elementos;
    private int filas;
    private int columnas;

    static class ElemMatriz {
        int fila;
        int columna;
        int valor;

        ElemMatriz(int fila, int columna, int valor) {
            this.fila = fila;
            this.columna = columna;
            this.valor = valor;
        }
    }

    // Constructor: Crear matriz vacía con dimensiones especificadas
    public MatrizFinita(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.elementos = new LinkedList<>();
    }

    // Método para definir un valor en una posición (fila, columna)
    public void definir(int fila, int columna, int valor) {
        if (fila >= filas || columna >= columnas || fila < 0 || columna < 0) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites de la matriz");
        }

        for (ElemMatriz elem : elementos) {
            if (elem.fila == fila && elem.columna == columna) {
                if (valor == 0) {
                    elementos.remove(elem);
                } else {
                    elem.valor = valor;
                }
                return;
            }
        }

        if (valor != 0) {
            elementos.add(new ElemMatriz(fila, columna, valor));
        }
    }

    // Método para obtener el valor en una posición (fila, columna)
    public int obtener(int fila, int columna) {
        if (fila >= filas || columna >= columnas || fila < 0 || columna < 0) {
            throw new IndexOutOfBoundsException("Posición fuera de los límites de la matriz");
        }

        for (ElemMatriz elem : elementos) {
            if (elem.fila == fila && elem.columna == columna) {
                return elem.valor;
            }
        }

        return 0; // Devuelve 0 si la posición no está definida
    }

    // Método para sumar dos matrices del mismo tamaño
    public MatrizFinita sumarMatrices(MatrizFinita otra) {
        if (this.filas != otra.filas || this.columnas != otra.columnas) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones");
        }

        MatrizFinita resultado = new MatrizFinita(filas, columnas);

        for (ElemMatriz elem : this.elementos) {
            resultado.definir(elem.fila, elem.columna, elem.valor);
        }

        for (ElemMatriz elem : otra.elementos) {
            int suma = resultado.obtener(elem.fila, elem.columna) + elem.valor;
            resultado.definir(elem.fila, elem.columna, suma);
        }

        return resultado;
    }

    // Métodos para obtener la cantidad de filas y columnas
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}


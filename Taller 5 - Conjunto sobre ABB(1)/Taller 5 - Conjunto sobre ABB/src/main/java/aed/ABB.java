package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int cardinal;
    private int altura;


    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;

        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }

    public ABB() {
        raiz = null;
        cardinal = 0;
        altura = 0;
    }

    public int cardinal() {
        return cardinal;
    }

    public T minimo(){
        Nodo minimo = encontrarMinimo(raiz);
        return minimo.valor;
    }

    private Nodo encontrarMinimo(Nodo nodo){
        Nodo minimo = nodo;

        while(minimo.izq != null){
            minimo = minimo.izq;
        }

        return minimo;
    }

    public T maximo(){
        Nodo maximo = encontrarMaximo(raiz);
        return maximo.valor;
    }

    private Nodo encontrarMaximo(Nodo nodo){
        Nodo maximo = nodo;

        while (maximo.der != null){
            maximo = maximo.der;
        }
        return maximo;
    }

    private Nodo insertar(Nodo nodo, T valor, Nodo padre){
        if (nodo == null){
            Nodo nuevoNodo = new Nodo(valor);
            nuevoNodo.padre = padre;
            return nuevoNodo;
        }
        if(valor.compareTo(nodo.valor) < 0){
            nodo.izq = insertar(nodo.izq, valor, nodo);
        } else if(valor.compareTo(nodo.valor) > 0){
            nodo.der = insertar(nodo.der,valor, nodo);
        }
        return nodo;
    }

    public void insertar(T elem){
        if (pertenece(elem) != true) {
            raiz = insertar(raiz, elem, null);
            cardinal += 1;
        }
    }

    private boolean busqueda_recursiva(Nodo nodo, T elem){
        if (nodo == null){
            return false;
        } 
        if (elem.compareTo(nodo.valor) == 0){
            return true;
        }
        if (elem.compareTo(nodo.valor) < 0){
            return busqueda_recursiva(nodo.izq, elem);
        } else {return busqueda_recursiva(nodo.der, elem);
        }
        
    }

    public boolean pertenece(T elem){
        return busqueda_recursiva(raiz, elem);
    }

    public void eliminar(T elem){
        cardinal -= 1;
        Nodo nodo = raiz;
        if (pertenece(elem)) {
            while (elem.compareTo(nodo.valor) != 0) {
                if (elem.compareTo(nodo.valor) < 0) {
                    nodo = nodo.izq;
                } else {
                    nodo = nodo.der;
                }
            }
        }

        // caso donde el nodo no tiene hijos
        if (nodo.izq == null && nodo.der == null){
            if(nodo.padre.izq == nodo){
                nodo.padre.izq = null;
            } else if(nodo.padre.der == nodo){
                nodo.padre.der = null;
            }
        } else if (nodo.izq == null){   // casos donde el nodo tiene un único hijo
            nodo.padre.der = nodo.der;
            nodo.der.padre = nodo.padre;

        } else if (nodo.der == null){
            nodo.padre.izq = nodo.izq;
            nodo.izq.padre = nodo.padre;

        } else {                            // caso donde el nodo tiene dos hijos
                if (nodo.valor.compareTo(nodo.padre.valor) > 0) {
                    nodo.padre.der = sucesor(nodo.padre);
                    nodo.padre = sucesor(nodo.padre);
                    nodo.der = sucesor(nodo.padre);
                    nodo.izq = nodo.der;
                } else {
                    nodo.padre.izq = encontrarMaximo(nodo);
                    nodo.padre = encontrarMaximo(nodo);
                    nodo.der = nodo.izq;
                }
        }
    }

   private Nodo sucesor (Nodo nodo) {
       if (nodo.der != null) {
           return encontrarMinimo(nodo.der);
       }
       Nodo padre = nodo.padre;
       while (padre != null && nodo == padre.der) {
           nodo = padre;
           padre = padre.padre;
       }
       return padre;
   }

   public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }
    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}


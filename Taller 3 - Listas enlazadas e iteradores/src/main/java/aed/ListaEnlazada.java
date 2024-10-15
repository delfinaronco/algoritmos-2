package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    Nodo first;
    Nodo last;
    int length;

    private class Nodo {
        T valor;
        Nodo next;
        Nodo previous; 
        Nodo(T v){
            valor = v;
            next = null;
            previous = null;
        }
    }

    public ListaEnlazada() {
        first = null;
        last = null;
        length = 0;
    }

    public int longitud() {
        return length;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        length += 1;

        if (first == null && last == null){
            first = nuevo;
            last = nuevo;
        } else {
            nuevo.next = first;
            first.previous = nuevo;
            first = nuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo (elem);
        length += 1;

        if (first == null && last == null){
            first = nuevo;
            last = nuevo;

        } else {
            last.next = nuevo;
            nuevo.previous = last;
            last = nuevo;
            
        }
    }

    public T obtener(int i) {
        int j = 0;
        Nodo nodo = first;
        while (j < i){
            nodo = nodo.next;
            j += 1;
        }
        return nodo.valor;
    }

    public void eliminar(int i) {
        int j = 0;
        Nodo nodo = first;
        length -= 1;

        while (j < i){
            nodo = nodo.next;
            j +=1;
        }

        if (nodo.previous != null && nodo.next != null){
            nodo.previous.next = nodo.next;
            nodo.next.previous = nodo.previous;

        } else if (nodo == first){
            nodo.previous = null;
            first = nodo.next;

        } else if (nodo == last){
            last.next = null;
            last = nodo.previous;
        }
        }
        

    public void modificarPosicion(int indice, T elem) {
        int j = 0;
        Nodo cambiar = first;

        while (j < indice){
            cambiar = cambiar.next;
            j += 1;
        }
        cambiar.valor = elem;
         
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}

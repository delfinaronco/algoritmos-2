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
        for(int j = 0; j < lista.length; j++){
            agregarAtras(lista.obtener(j));
        }
    }
    
    @Override
    public String toString() {
        String mensaje = "[";
        for(int i = 0; i < length; i++){
            if (i != length - 1){
                mensaje += obtener(i).toString() + ", ";
            } else {
                mensaje += obtener(i).toString() + "]";
            }
        }
        return mensaje;
    }

    private class ListaIterador implements Iterador<T> {
    	private Nodo iterador;
        ListaIterador(){
            iterador = first;
        }

        public boolean haySiguiente() {
	        if (length == 0){
                return false;
            }
            if (iterador == last){
                return true;
            }
            return iterador != null && iterador.next != null;
        }
        
        public boolean hayAnterior() {
	        if (length == 0){
                return false;
            }
            if (iterador == null){
                return true;
            }
            return iterador != null && iterador.previous != null;
        }

        public T siguiente() {
	        T valor = iterador.valor;
            iterador = iterador.next;
            return valor;
        }
        

        public T anterior() {
	        if (iterador == null){
                iterador = last;
                return iterador.valor;
            } else {
                iterador = iterador.previous;
                return iterador.valor;
            }
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}

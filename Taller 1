package aed;

import javax.swing.plaf.TreeUI;

class Funciones {
    int cuadrado(int x) {
        int res=x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n){
        return n % 2 == 0;
    }
    
    boolean esBisiesto(int n) {
        return n % 4 == 0 && n % 100 != 0 || n % 400 == 0;
    }

    int factorialIterativo(int n) { 
        int res = 1;
        for (int i = 1; i <= n; i++){
            res *= i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 0){
            return 1;
        } else {
            return n*factorialRecursivo(n-1);
        }       
    }

    boolean esPrimo(int n) {
        if (n <= 1){
            return false;
        }
        for (int i=2;i <= n-1; i++){
            if (n % i == 0){
                return false;
            }
        }

        return true;
    }
    

    int sumatoria(int[] numeros) {
        int contador = 0;
        for (int numero : numeros){
            contador += numero;
        }
        
        return contador;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i=0; i < numeros.length;i++){
            if (numeros[i]== buscado){
                return i;
            }
        }
        return -1;
    }

    boolean tienePrimo(int[] numeros) {
        for (int numero:numeros){
            if (esPrimo(numero)){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int numero:numeros){
            if (numero % 2 != 0){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }

        for (int i=0; i < s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        
        String s1Invertido = "";
        String s2Invertido = "";

        for (int i = s2.length()-1; i >= 0; i--){
            s2Invertido += s2.charAt(i);
        }

        for (int i = s1.length()-1; i >= 0; i--){
            s1Invertido += s1.charAt(i);
        }

        if (esPrefijo(s1Invertido,s2Invertido)){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Funciones funciones = new Funciones();
        
        System.err.println(funciones.esSufijo("hola", "hola"));
    }
}



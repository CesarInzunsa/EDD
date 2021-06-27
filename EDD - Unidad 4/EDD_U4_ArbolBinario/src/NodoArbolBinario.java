/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class NodoArbolBinario {
    private char dato;
    private NodoArbolBinario izq, der;
    
    public NodoArbolBinario(char d){
        this.dato = d;
        this.izq = this.der = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoArbolBinario getIzq() {
        return izq;
    }

    public void setIzq(NodoArbolBinario izq) {
        this.izq = izq;
    }

    public NodoArbolBinario getDer() {
        return der;
    }

    public void setDer(NodoArbolBinario der) {
        this.der = der;
    }
    
    public boolean esHoja(){
        return izq == null && der == null;
    }
    
}// fin clase Nodo

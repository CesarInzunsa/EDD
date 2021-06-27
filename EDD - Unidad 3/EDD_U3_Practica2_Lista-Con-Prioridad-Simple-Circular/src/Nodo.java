/*
 * TDA NODO de lista simple = 1 solo puntero
 */

/**
 * 
 * @author cesar
 */
public class Nodo {
    private char dato;
    private Nodo sig;
    private int nivel;

    public Nodo (char dato, int n){
        this.dato = dato;
        this.sig = null;
        this.nivel = n;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    
}

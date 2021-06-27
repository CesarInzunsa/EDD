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

    public Nodo (char dato){
        this.dato = dato;
        this.sig = null;
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
    
}

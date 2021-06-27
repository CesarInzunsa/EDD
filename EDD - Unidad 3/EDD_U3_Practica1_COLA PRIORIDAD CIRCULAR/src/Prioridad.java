/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class Prioridad{
    private char dato;
    private int nivel;
    
    public Prioridad() {
        this.dato = "".charAt(0);
        this.nivel = 0;
    }

    public Prioridad(char dato, int nivel) {
        this.dato = dato;
        this.nivel = nivel;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class NodoHijo {
    private NodoGeneral direccion;
    private NodoHijo ant, sig;
    
    public NodoHijo(NodoGeneral hijoApuntar){
        direccion = hijoApuntar;
        ant = sig = null;
    }

    public NodoGeneral getDireccion() {
        return direccion;
    }

    public void setDireccion(NodoGeneral direccion) {
        this.direccion = direccion;
    }

    public NodoHijo getAnt() {
        return ant;
    }

    public void setAnt(NodoHijo ant) {
        this.ant = ant;
    }

    public NodoHijo getSig() {
        return sig;
    }

    public void setSig(NodoHijo sig) {
        this.sig = sig;
    }
    
}

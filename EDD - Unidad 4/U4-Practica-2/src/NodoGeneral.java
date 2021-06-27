/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class NodoGeneral {
    private char dato;
    private NodoHijo ini, fin;
    
    public NodoGeneral(char d){
        dato = d;
        ini = fin = null;
    }
    
    //identico a insertar de lista doble pero sin un dato
    public boolean enlazar(NodoGeneral hijo){
        NodoHijo enlace = new NodoHijo(hijo);
        
        if(enlace == null) return false;
        
        if(esHoja()){
            ini = fin = enlace;
            return true;
        }
        
        fin.setSig(enlace);
        enlace.setAnt(fin);
        fin = enlace;
        
        return true;
    }

    public NodoGeneral obtenerHijo(char valorHijoBuscado) {
        
        if(esHoja()) return null;
        
        for (NodoHijo buscar = ini; buscar != null; buscar = buscar.getSig()) {
            if(buscar.getDireccion().getDato() == valorHijoBuscado){
                return buscar.getDireccion();
            }
        }
        return null;
    }
    
    public boolean desenlazar(NodoGeneral hijo){
        
        if(ini == fin){
            if(fin.getDireccion() == hijo){
                ini = fin = null;
                return true;
            }
            return false;
        }
        
        NodoHijo temp = ini;
        
        if(ini.getDireccion() == hijo){
            ini = temp.getSig();
            ini.setAnt(null);
            temp.setSig(null);
            return true;
        }
        
        if(fin.getDireccion() == hijo){
            temp = fin;
            fin = temp.getAnt();
            fin.setSig(null);
            temp.setAnt(null);
            return true;
        }
        
        //si esta en medio
        temp = temp.getSig();
        while(temp.getDireccion() != hijo && temp != null){
            temp = temp.getSig();
        }
        
        if(temp == null) return false;
        
        temp.getSig().setAnt(temp.getAnt());
        temp.getAnt().setSig(temp.getSig());
        temp.setSig(null);
        temp.setAnt(null);
        return true;
    }
    
    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoHijo getIni() {
        return ini;
    }

    public void setIni(NodoHijo ini) {
        this.ini = ini;
    }

    public NodoHijo getFin() {
        return fin;
    }

    public void setFin(NodoHijo fin) {
        this.fin = fin;
    }    

    public boolean esHoja() {
        return ini == null && fin == null;
    }
}

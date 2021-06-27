/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ListaDoble {
    protected NodoDoble ini, fin;

    public ListaDoble() {
        ini = fin = null;
    }
    
    public boolean insertar (char dato){
        NodoDoble nuevo = new NodoDoble(dato);
        
        if(nuevo == null) return false;
        
        if(estaVacia()){
            ini = fin = nuevo;
            return true;
        }
        
        fin.setSig(nuevo);
        nuevo.setAnt(fin);
        fin = nuevo;
        
        return true;
    }
    
    public boolean estaVacia(){
        return ini == null && fin == null;
    }
    
    public boolean eliminar (){
        if(estaVacia()) return false;
        
        if(HayUnSoloNodo()){
            ini = fin = null;
            return true;
        }
        
        NodoDoble temp = ini;
        ini = temp.getSig();
        ini.setAnt(null);
        temp.setSig(null);
        temp = null;
        
        return true;
    }
    
    public boolean HayUnSoloNodo(){
        return ini == fin;
    }

    public NodoDoble getIni() {
        return ini;
    }

    public void setIni(NodoDoble ini) {
        this.ini = ini;
    }

    public NodoDoble getFin() {
        return fin;
    }

    public void setFin(NodoDoble fin) {
        this.fin = fin;
    }
    
    
    
}

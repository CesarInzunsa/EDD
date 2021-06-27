/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ListaDobleCircular extends ListaDoble {

    public ListaDobleCircular() {
        super();
    }
    
    @Override
    public boolean insertar (char dato){
        
        boolean respuesta = super.insertar(dato);
        
        if(!respuesta) return false;
        
        ini.setAnt(fin);
        fin.setSig(ini);
        return true;
    }
    
    @Override
    public boolean eliminar (){
        if(!estaVacia()){
            ini.setAnt(null);
            fin.setSig(null);
        }
        
        boolean respuesta = super.eliminar();
        
        if(!respuesta) return false;
        
        if(!estaVacia()){
            ini.setAnt(fin);
            fin.setSig(ini);
        }
        
        return true;
    }

}

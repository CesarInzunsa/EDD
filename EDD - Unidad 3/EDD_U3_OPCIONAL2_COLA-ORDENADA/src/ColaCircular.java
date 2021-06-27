/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ColaCircular extends ColaSimple{
    
    public ColaCircular(int tamaño) {
        super(tamaño);
    }
    
    @Override
    public boolean insertar(char dato){
        //modo circular
        if(modoCircular()){
            //comprueba si la cola esta llena, si lo esta retorna un falso
            if(colaLlenaCircular()) return false;
        
            //insertar el valor en la posicion
            fin++;
            vector[fin] = dato;
        
            return true;
        }//fin modo circular
        
        //modo normal
        boolean respuesta = super.insertar(dato);
        if(respuesta) return true;
        
        if(ini==0) return false;
        
        fin = 0;
        vector[fin] = dato;
        return true;
    }
    
    private boolean modoCircular(){
        return fin<ini;
    }
    
    private boolean colaLlenaCircular(){
        return (fin+1) == ini;
    }
    
    @Override
    public boolean eliminar(){
        boolean respuesta = super.eliminar();
        if(ini==vector.length) ini=0;
        return respuesta;
    }
    
}

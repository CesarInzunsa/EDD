/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ColaBicola extends ColaSimple{
    
    public ColaBicola(int tamaño) {
        super(tamaño);
    }

    public boolean insertarPorIni(char dato){
        if(colaLlena()) return false;
        if(estaColaSimpleVacia()) ini=fin=0;
        else ini--;
        
        vector[ini] = dato;
        return true;
    }
    
    private boolean colaLlena(){
        return ini == 0;
    }
    
    public boolean eliminarPorFin(){
        if(estaColaSimpleVacia()) return false;
        if(hayUnSoloDato()) ini=fin=-1;
        else fin--;
        return true;
    }
    
}

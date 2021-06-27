/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ColaOrdenadaBicola extends ColaBicola{
    
    public ColaOrdenadaBicola(int tamaño) {
        super(tamaño);
    }
    
    @Override
    public boolean insertar(char dato){
        
        if(seRepite(dato)){
            return false;
        }
        
        boolean respuesta = super.insertar(dato);
        if(!respuesta){
            return false;
        }
        
        analisisPrioridad();
        
        return true;
    }
    
    @Override
    public boolean insertarPorIni(char dato){
        if(seRepite(dato)){
            return false;
        }
        
        boolean respuesta = super.insertarPorIni(dato);
        if(!respuesta){
            return false;
        }
        
        analisisPrioridadInvertido();
        
        return true;
    }
    
    //nuevo metodo para comprobar si existe una prioridad, de ser así reacomoda los objetos de acuerdo a su prioridad
    private void analisisPrioridad(){
        //si existe un solo dato, terminamos el metodo analisisPrioridad debido a que, SOLO HAY UN DATO
        if(hayUnSoloDato()) return;

        int t1 = fin;
        int t2 = fin-1;
        char aux;
        
    
        //creamos un ciclo que terminara hasta que:
        //t1 deje de ser diferente a ini
        //ó
        //hasta que el nivel del t1 no sea menor a t2
        while (t1 != ini){
            if(vector[t1]<vector[t2]){
                aux = vector[t1];
                vector[t1] = vector[t2];
                vector[t2] = aux;
                t2--;
                t1--;
            }else{
                break;
            }
        }
    }//fin analisisPrioridad
    
    private boolean seRepite(char dato){
        
        if(estaColaSimpleVacia()){
            return false;
        }
        
        for(int i=ini; i<=fin; i++){
            if(vector[i]==dato){
                return true;
            }
        }
        return false;
    }
    
    public void analisisPrioridadInvertido(){
        if(hayUnSoloDato()) return;
        
        int t1 = ini;
        int t2 = ini+1;
        char aux;

        while (t1 != fin){
            if(vector[t1]>vector[t2]){
                aux = vector[t1];
                vector[t1] = vector[t2];
                vector[t2] = aux;
                t2++;
                t1++;
            }else{
                break;
            }
        }
        
    }
    
}

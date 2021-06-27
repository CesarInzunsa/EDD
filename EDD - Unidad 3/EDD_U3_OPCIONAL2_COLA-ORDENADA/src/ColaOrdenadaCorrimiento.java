/*
 * insertar el valor nuevo llevandolo al final de la cola (proceso normal)
 * y luego lo reubica respecto a su valor (prioridad).
 */

/**
 *
 * @author cesar
 */
public class ColaOrdenadaCorrimiento extends ColaConCorrimiento{
    
    public ColaOrdenadaCorrimiento(int tamaño) {
        super(tamaño);
    }
    
    @Override
    public boolean insertar(char dato){
        //se utilizan pasos normales para insertar
        
        if(seRepite(dato)){
            return false;
        }
                
        boolean respuesta = super.insertar(dato);
        if(respuesta){
            analisisPrioridad();
            return true;
        }
        return false;
    }
    
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
    
    /*
    //metodo para determinar la prioridad del dato
    private int prioridad(char dato){
        
        for(char i='A'; i<='Z'; i++){
            if(dato==i){
                //retorna el valor numerico del char en ascii
                return (int) i;
            }
        }
        
        return 1;
    }//prioridad
    */
    
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
    
}

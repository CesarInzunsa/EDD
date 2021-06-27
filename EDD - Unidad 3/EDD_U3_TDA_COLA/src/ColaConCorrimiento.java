/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ColaConCorrimiento extends ColaSimple {
    
    public ColaConCorrimiento(int tamaño) {
        super(tamaño);
    }
    
    public boolean insertar(char dato){
        //se utilizan pasos normales para insertar
        boolean respuesta = super.insertar(dato);
        if(respuesta){
            return true;
        }
        //aqui respuesta es false, lo que significa que hay cola llena, por lo tanto hay que preguntar si
        //hay espacios para iniciar corrimiento
        if(ini>0){
            corrimiento();
            return super.insertar(dato);
        }
        return false;
    }
    
    private void corrimiento(){
        int recibe=0;
        for(int envia=ini; envia<=fin; envia++, recibe++){
            vector[recibe] = vector[envia];
        }
        ini=0;
        fin=recibe-1;
    }
}

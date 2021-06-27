/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ColaSimple {
    protected char[] vector;
    protected int ini;
    protected int fin;
    
    public ColaSimple(int tamaño){
        this.vector = new char [tamaño];
        this.ini=-1;
        this.fin=-1;
    }
    
    protected boolean estaColaSimpleLlena(){
        return fin == vector.length-1;
    }
    
    public boolean insertar(char dato){
        //comprueba si la cola simple esta llena, si lo esta retorna un falso
        if(estaColaSimpleLlena()) return false;
        
        //insertar el valor en la posicion
        fin++;
        vector[fin] = dato;
        
        //si la cola esta vacia ini se incrementa
        if(ini == -1) ini=0;
        
        return true;
    }
    
    protected boolean estaColaSimpleVacia(){
        return ini == -1 && fin == -1;
    }
    
    protected boolean hayUnSoloDato(){
        return ini == fin;
    }
    
   public boolean eliminar(){
        //comprueba si la cola simple esta vacia, si lo esta retorna un falso
        if(estaColaSimpleVacia()) return false;
        
       /** comprueba si solo queda un dato en el vector, si es así retorna reinicia el vector
        *  y retorna un true porque se realizo la eliminacion logica1
        */
        if(hayUnSoloDato()){
            this.ini = -1;
            this.fin = -1;
            return true;
        }
        
        //eliminado logico
        ini++;
        
        return true;
    }

    public char getVector(int posicion) {
        return vector[posicion];
    }
    
    public int getFin() {
        return fin;
    }
    
    public int getIni() {
        return ini;
    }
    
    public int getTamaño() {
        return vector.length;
    }
   
}

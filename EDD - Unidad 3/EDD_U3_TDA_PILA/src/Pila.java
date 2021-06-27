/*
 * REGLAS:
 * 1 - PILA tiene datos validos desde 0 hasta TOS
 * 2 - TOS vale -1 cuando se indica que NO HAY VALORES CAPTURADOS
 */

/**
 *
 * @author cesar
 */
public class Pila {
    private char[] vector;
    private int TOS;
    
    //CONSTRUCTOR SIRVE PARA INICIALIZAR
    public Pila(int tamañoVector){
        vector = new char [tamañoVector];
        TOS = -1; //VALOR -1 es PILA VACIA
    }
    
    /*
    * INSERTAR sirve para guardar datos en PILA 
    * se recibe un dato(valor a guardar) de tipo char enviado  desde la clase PROGRAMA (interfaz grafica)
    * se regresa un boolean donde true indica que se logro insertar el dato y false si no se pudo
    */
    
    public boolean insertar(char dato){
        // revisar si el vector esta lleno
        if(pilaLlena() == true){
            return false;
        }
        vector[++TOS] = dato;
        return true;
    }
    
    // comprueba si la pila esta llena y regresa un true si esta llena, en caso contrario regresa un false
    private boolean pilaLlena(){
        return TOS ==  vector.length-1;
    }
    
    // comprueba si la pila esta vacia y regresa un true si así es, en caso contrario regresa un false
    private boolean pilaVacia(){
        return TOS ==  -1;
    }
    
    /*
    * ELIMINAR sirve para eliminar datos en PILA DE FORMA LOGICA, NO FISICA  
    * se regresa un boolean donde true indica que se logro eliminar el dato y false si no se pudo
    */
    
    public boolean eliminar(){
        // revisar si el vector esta vacio
        if(pilaVacia() == true){
            return false;
        }
        // eliminacion logica, no fisica
        TOS--;
        return true;
    }

    public int getTamaño() {
        return TOS;
    }

    public char getVector(int posicion) {
        return vector[posicion];
    }  
}

    

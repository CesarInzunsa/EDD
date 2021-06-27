/*
 * TDA DE LISTA SIMPLE ES BAJO PEPS: PRIMERAS ENTRADAS, PRIMERAS SALIDAS.
 */

/**
 *
 * @author cesar
 */
public class ListaSimple{
    protected Nodo ini, fin;

    public ListaSimple() {
        ini=fin=null;
    }
        
    public boolean insertar(char dato){
        //se construye el nodo
        Nodo nuevo = new Nodo(dato);
        // comprobar si se construyo el nodo, a veces no sucede porque no existe memoria suficiente.
        // poco probable pero probable al fin y al cabo.
        if(nuevo == null) return false;
        
        if(estaVacia()){
            ini = fin = nuevo;
            return true;
        }
        
        fin.setSig(nuevo);
        fin = nuevo;
        return true;
    }
    
    public boolean eliminar(){
        if(estaVacia()){
            return false;
        }
        if(hayUnNodo()){
            ini = fin = null;
            return true;
        }
        
        Nodo temp = ini;
        ini = temp.getSig();
        temp.setSig(null);
        //java tiene un reciclador por lo que este borrado fisico no es necesario (pero esto solo sucede en java).
        temp = null;
        return true;
    }
    
    protected boolean estaVacia(){
        return ini == null && fin == null;
    }
    
    protected boolean hayUnNodo(){
        return ini == fin;
    }

    public Nodo getIni() {
        return ini;
    }
    
}

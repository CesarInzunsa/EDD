/*
 * TDA DE LISTA SIMPLE ES BAJO PEPS: PRIMERAS ENTRADAS, PRIMERAS SALIDAS.
 */

/**
 *
 * @author cesar
 */
public class ListaSimpleCircular extends ListaSimple{

    public ListaSimpleCircular() {
        super();
    }
        
    @Override
    public boolean insertar(char dato){
        
        boolean respuesta = super.insertar(dato);
        
        if (!respuesta) return false;
        
        fin.setSig(ini);
        return true;
    }
    
    @Override
    public boolean eliminar(){
        if(!estaVacia()) fin.setSig(null);
        
        boolean respuesta = super.eliminar();
        
        if (!respuesta) return false;
        
        if(!estaVacia()) fin.setSig(ini);

        return true;
    }
    
}

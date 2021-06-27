/**
 * 
 * @author cesar
 */
public class NodoVertice {
    private char dato;
    private NodoVertice sig, ant;
    private NodoArista arista;

    public NodoVertice (char d){
        this.dato = d;
        this.sig = this.ant = null;
        this.arista = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public NodoVertice getSig() {
        return sig;
    }

    public void setSig(NodoVertice sig) {
        this.sig = sig;
    }

    public NodoVertice getAnt() {
        return ant;
    }

    public void setAnt(NodoVertice ant) {
        this.ant = ant;
    }

    public NodoArista getArista() {
        return arista;
    }

    public void setArista(NodoArista arista) {
        this.arista = arista;
    }

    boolean insertarArista(NodoVertice direccion) {
        NodoArista nuevo = new NodoArista(direccion);
        
        if(nuevo == null) return false;
        
        if (arista == null) {
            arista = nuevo;
            return true;
        }
        
        irUltimo();
        
        arista.setAbajo(nuevo);
        nuevo.setArriba(arista);
        return true;
    }

    private void irUltimo() {
        while(arista.getAbajo() != null){
            arista = arista.getAbajo();
        }
    }
    
    protected void irPrimero() {
        while(arista.getArriba() != null){
            arista = arista.getArriba();
        }
    }
    
    protected NodoArista buscarArista(NodoVertice direccion) {
        
        if(direccion == null) return null; //retorna un null debido a que no hay aristas
        
        irPrimero();
        
        for (NodoArista buscar = arista; buscar != null; buscar = buscar.getAbajo()) {
            if(buscar.getDireccion() == direccion){
                return buscar;
            }
        }
        
        return null; //no se encontro la direccion
    }
    
    protected boolean existeEnlace(NodoVertice direccion) {
        
        if(direccion == null) return false; //retorna un null debido a que no hay aristas
        if(arista == null) return false;
        
        irPrimero();
        
        for (NodoArista buscar = arista; buscar != null; buscar = buscar.getAbajo()) {
            if(buscar.getDireccion() == direccion){
                return true;
            }
        }
        
        return false; //no se encontro la direccion
    }    
    
    private boolean unaSolaArista(){
        return arista.getAbajo() == null  && arista.getArriba() == null;
    }

    boolean eliminarArista(NodoVertice direccion) {
        if(arista == null) return false;
        
        NodoArista temp = buscarArista(direccion);
        
        if(temp == null) return false; //no se encontro arista de origen a destino
        
        if(temp == arista){
            if(unaSolaArista()){
                arista = null;
            }else{
                arista = arista.getAbajo();
                temp.getAbajo().setArriba(null);
                temp.setAbajo(null);
            }
            return true;
        }
        
        //si esta al ultimo
        if(temp.getAbajo() == null){
            temp.getArriba().setAbajo(null);
            temp.setArriba(null);
            return true;
        }
        
        //eliminar arista en medio
        temp.getArriba().setAbajo(temp.getAbajo());
        temp.getAbajo().setArriba(temp.getArriba());
        temp.setArriba(null);
        temp.setAbajo(null);
        return true;
    }
    
    
}

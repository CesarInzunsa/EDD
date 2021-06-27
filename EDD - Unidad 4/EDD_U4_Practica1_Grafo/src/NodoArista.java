/**
 *
 * @author cesar
 */
public class NodoArista {
    private NodoVertice direccion;
    private NodoArista arriba, abajo;
    
    public NodoArista(NodoVertice direc){
        this.direccion = direc;
        this.arriba = this.abajo = null;
    }

    public NodoVertice getDireccion() {
        return direccion;
    }

    public void setDireccion(NodoVertice direccion) {
        this.direccion = direccion;
    }

    public NodoArista getArriba() {
        return arriba;
    }

    public void setArriba(NodoArista arriba) {
        this.arriba = arriba;
    }

    public NodoArista getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoArista abajo) {
        this.abajo = abajo;
    }
    
    
    
}

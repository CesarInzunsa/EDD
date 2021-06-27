/**
 *
 * @author cesar
 */
public class Grafo{
    private NodoVertice vertice;
    
    public Grafo(){
        vertice = null;
    }
    
    public boolean insertarVertice(char dato){
        NodoVertice nuevo = new NodoVertice(dato);
        
        if(nuevo == null) return false;
        
        //si es el primero
        if (vertice == null) {
            vertice = nuevo;
            return true;
        }
 
        irUltimo();
        
        vertice.setSig(nuevo);
        nuevo.setAnt(vertice);
        return true;
        
        
    }//fin insertar

    private void irUltimo() {
        while(vertice.getSig()!= null){
            vertice = vertice.getSig();
        }
    }
    
    private void irPrimero() {
        while(vertice.getAnt()!= null){
            vertice = vertice.getAnt();
        }
    }
    
    private NodoVertice buscarVertice(char dato) {
        
        if(vertice == null) return null; //retorna un null debido a que no hay nodos
        
        irPrimero();
        
        for (NodoVertice buscar = vertice; buscar != null; buscar = buscar.getSig()) {
            if(buscar.getDato() == dato){
                return buscar;
            }
        }
        
        return null; //no se encontro el dato
    }
    
    private int numVertices() {
        if(vertice == null) return 0; //retorna un 0 debido a que no hay nodos
        
        int i = 1;
        irPrimero();
        while(vertice.getSig() != null){
            vertice = vertice.getSig();
            i++;
        }
        return i;
    }
    
    public int[][] getMatriz() {
        
        //no se puedo pero que no se diga que no se hizo el intento :C
        
        if(vertice == null) return null; //retorna un null debido a que no hay nodos
        int numVertices = numVertices();
        
        int matriz[][] = new int[numVertices][numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matriz[i][j] = 0;
            }
        }
        irPrimero();
        NodoVertice aux1 = vertice;
        NodoArista aux2 = vertice.getArista();
        
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                while (aux2.getAbajo() != null) {
                    matriz[i][j] = 1;
                    aux2 = aux2.getAbajo();
                }
            }
            aux1 = aux1.getSig();
        }
        
        return matriz;
    }// fin getMatriz
    
    public String getListaAdyacencia(char dato){
        
        NodoVertice auxVertice = buscarVertice(dato);
        
        if(auxVertice == null) return "";
        
        if(auxVertice.getArista() == null) return "";
        
        String cad = auxVertice.getDato()+": ";
        auxVertice.irPrimero();
        NodoArista auxArista = auxVertice.getArista();
        
        while(auxArista != null){
            cad += auxArista.getDireccion().getDato() + ", ";
            auxArista = auxArista.getAbajo();
        }
        
        return cad.substring(0, cad.length()-2);
    }
    
    public boolean getVerificarCamino(String path){
        
        path = path.substring(1);
        String vectorString[] = path.split("/");
        char vectorChar[] = new char[vectorString.length];
        
        //crear un vector de chars con los valores del camino
        for (int i = 0; i < vectorString.length; i++) {
            vectorChar[i] = vectorString[i].charAt(0);
        }
        
        NodoVertice comienzo = buscarVertice(vectorChar[0]);
        //si no existe el primero vertice del camino
        if(comienzo == null) return false;
        
        if(vectorChar.length == 1) return false;
        
        for (int i = 1; i < vectorChar.length; i++) {
            NodoVertice inicio = buscarVertice(vectorChar[i-1]);
            NodoVertice fin = buscarVertice(vectorChar[i]);
            if (!inicio.existeEnlace(fin) || inicio == null || fin == null) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean insertarArista(char origen, char destino){
        NodoVertice nodoOrigen = buscarVertice(origen);
        NodoVertice nodoDestino = buscarVertice(destino);
        
        if(nodoOrigen == null || nodoDestino== null) return false;
        
        
        return nodoOrigen.insertarArista(nodoDestino);
    }
    
    public boolean eliminarArista(char origen, char destino){
        NodoVertice nodoOrigen = buscarVertice(origen);
        NodoVertice nodoDestino = buscarVertice(destino);
        
        if(nodoOrigen == null || nodoDestino== null) return false;
        
        return nodoOrigen.eliminarArista(nodoDestino);
    }
    
    public boolean unSoloVertice(){
        return vertice.getAnt() == null && vertice.getSig() == null;
    }
    
    public boolean eliminarVertice(char dato){
        if(vertice == null) return false;
        
        NodoVertice temp = buscarVertice(dato);
        
        if(temp == null) return false; //no se encontro el dato
        
        //Solo se puede eliminar en dos casos
        //1 - Si no tiene aristas apuntando hacia otros nodos
        //2 - Si no hay aristas apuntando hacia el
        
        if(temp.getArista() != null) return false; //tiene aristas
        
        quitaAristasDeOtrosVertices(temp);
        
        //si esta en el primero
        if(temp == vertice){
            if(unSoloVertice()){
                vertice = null;
            }else{
                vertice = temp.getSig();
                temp.getAnt().setAnt(null);
                temp.setSig(null);
            }
            return true;
        }
        
        //si esta en el ultimo
        if(temp.getSig() == null){
            temp.getAnt().setSig(null);
            temp.setAnt(null);
            return true;
        }
        
        //si esta en el medio
        temp.getAnt().setSig(temp.getSig());
        temp.getSig().setAnt(temp.getAnt());
        temp.setSig(null);
        temp.setAnt(null);
        return true;
    }

    private void quitaAristasDeOtrosVertices(NodoVertice nodoEliminar) {
        irPrimero();
        
        for (NodoVertice buscar = vertice; buscar != null; buscar = buscar.getSig()) {
            buscar.eliminarArista(nodoEliminar);
        }
    }
    
}

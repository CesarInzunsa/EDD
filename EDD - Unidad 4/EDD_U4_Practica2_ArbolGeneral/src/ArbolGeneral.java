/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ArbolGeneral {
    private NodoGeneral raiz;
    
    public ArbolGeneral(){
        raiz = null;
    }
    
    public boolean insertar(char dato, String path){
        
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            if (raiz == null) return false;
            return true;
        }
        
        if(path.isEmpty()) return false;
        
        NodoGeneral padre = buscarNodo(path);
        
        if(padre == null) return false;
        
        //revisar si existe un hijo con la misma letra que deseo insertar
        NodoGeneral hijoYaExiste = buscarNodo(path+"/"+dato);
        if(hijoYaExiste != null) return false;
        
        NodoGeneral nuevo = new NodoGeneral(dato);
        
        return padre.enlazar(nuevo);
    }

    private NodoGeneral buscarNodo(String path) {
        path = path.substring(1);
        String vector[] = path.split("/");
        
        if(vector[0].charAt(0) == raiz.getDato()){
            
            if(vector.length == 1) return raiz;
            
            NodoGeneral padre = raiz;
            for (int i = 1; i < vector.length; i++) {
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if(padre == null) return null;
            }
            return padre;
        }
        return null; // no existe la raiz
    }
    
    public boolean insertarConBusquedaRecursiva(char dato, String path){
        
        if(raiz == null){
            raiz = new NodoGeneral(dato);
            if (raiz == null) return false;
            return true;
        }
        
        if(path.isEmpty()) return false;
        
        NodoGeneral padre = buscarNodo(path);
        
        if(padre == null) return false;
        
        //revisar si existe un hijo con la misma letra que deseo insertar
        NodoGeneral hijoYaExiste = buscarNodoPlus(path+"/"+dato);
        if(hijoYaExiste != null) return false;
        
        NodoGeneral nuevo = new NodoGeneral(dato);
        
        return padre.enlazar(nuevo);
    }     
    
    private NodoGeneral buscarNodoPlus(String path) {
        path = path.substring(1);
        String[] vector = path.split("/");
        
        if(vector[0].charAt(0) == raiz.getDato()){
            
            if(vector.length == 1) return raiz;
            
            NodoGeneral padre = raiz;
            
            if(vector.length == 2){
                for (int i = 1; i < 2; i++) {
                    padre = padre.obtenerHijo(vector[i].charAt(0));
                    if(padre == null) return null;
                }
                return padre;
            }
            
            return buscarNodoRecursivo(padre, path.substring(2));
        }
        return null;
    }
    
    private NodoGeneral buscarNodoRecursivo(NodoGeneral padre, String path){
        if(padre == null) return null;
        
        if (path.length() == 1) {
            return padre.obtenerHijo(path.charAt(0));
        }
        
        return buscarNodoRecursivo(padre.obtenerHijo(path.charAt(0)), path.substring(2));
    }
    
    public boolean eliminar(String path){
        
        if(raiz  == null) return false;
        
        NodoGeneral hijo = buscarNodo(path);
        
        if(hijo == null) return false;
        
        if(!hijo.esHoja()) return false;
        
        if(hijo == raiz){
            raiz = null;
            return true;
        }
        
        String pathPadre = obtenerPathPadre(path);
        NodoGeneral padre = buscarNodo(pathPadre);
        
        return padre.desenlazar(hijo);
    }
    
    public boolean eliminarConBusquedaRecursiva(String path){
        
        if(raiz  == null) return false;
        
        NodoGeneral hijo = buscarNodoPlus(path);
        
        if(hijo == null) return false;
        
        if(!hijo.esHoja()) return false;
        
        if(hijo == raiz){
            raiz = null;
            return true;
        }
        
        String pathPadre = obtenerPathPadre(path);
        NodoGeneral padre = buscarNodoPlus(pathPadre);
        
        return padre.desenlazar(hijo);
    }

    private String obtenerPathPadre(String path) {
        int posicionAntesUltimaDiagonal = path.lastIndexOf("/");
        return path.substring(0,posicionAntesUltimaDiagonal);
    }
    
    /*
    public NodoGeneral buscarNodoPlus(String path) {
        path = path.substring(1);
        String[] vector = path.split("/");
        
        if(vector[0].charAt(0) == raiz.dato){
            
            if(vector.length == 1) return raiz;
            
            NodoGeneral padre = raiz;
            
            if(vector.length == 2){
                for (int i = 1; i < 2; i++) {
                    padre = padre.obtenerHijo(vector[i].charAt(0));
                    if(padre == null) return null;
                }
                return padre;
            }
            
            return buscarNodoRecursivo(padre, path.substring(2));
        }
        return null;
    }
    
    public NodoGeneral buscarNodoRecursivo(NodoGeneral padre, String path){
        if(padre == null) return null;
        
        if (path.length() == 1) {
            return padre.obtenerHijo(path.charAt(0));
        }
        
        return buscarNodoRecursivo(padre.obtenerHijo(path.charAt(0)), path.substring(2));
    }
    */
    
}

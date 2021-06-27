/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ArbolBinario {
    NodoArbolBinario raiz;
    
    public ArbolBinario(){
        this.raiz = null;
    }
    //NOTA: revisar que no exista duplicado
    
    public boolean insertar (char dato){
        
        if(raiz == null){
            raiz = new NodoArbolBinario(dato);
            return true;
        }
        
        if(existe(dato)) return false;
        
        NodoArbolBinario nuevo = new NodoArbolBinario(dato);
        
        if(nuevo.getDato() < raiz.getDato() ){
            if(raiz.getIzq() == null){
                raiz.setIzq(nuevo);
                return true;
            }else{
                //entrara si y solo si el hijo izquierdo esta ocupado
                return insertar(raiz.getIzq(), nuevo);
            }
        }else{
            if(raiz.getDer() == null){
                raiz.setDer(nuevo);
                return true;
            }else{
                //entrara si y solo si el hijo derecho esta ocupado
                return insertar(raiz.getDer(), nuevo);
            }
        }
        
    }//fin insertar
    
    
    private boolean insertar(NodoArbolBinario padre, NodoArbolBinario hijo){
        
        if(hijo.getDato() < padre.getDato()){
            if(padre.getIzq() == null){
                padre.setIzq(hijo);
                return true;
            }else{
                //entrara si y solo si el hijo izquierdo esta ocupado
                return insertar(padre.getIzq(), hijo);
            }
            //entra si el hijo.dato es mayor
        }else{
            if(padre.getDer() == null){
                padre.setDer(hijo);
                return true;
            }else{
                //entrara si y solo si el hijo derecho esta ocupado
                return insertar(padre.getDer(), hijo);
            }
        }
        
    }//fin insertar
    
    private boolean existe(char dato){
        String recorridoPreorden = preorden();
        String datoCad = dato+"";
        return recorridoPreorden.contains(datoCad);
    }
    
    public boolean eliminar(char dato){
        if(raiz == null) return false;
        
        if(!existe(dato)) return false;
        
        if(raiz.getDato() == dato){
            if(raiz.esHoja()){
                raiz = null;
                return true;
            }
            return false;
        }
        
        if(raiz.getIzq().getDato() == dato){
            if(raiz.getIzq().esHoja()){
                raiz.setIzq(null);
                return true;
            }
            return false;
        }
        
        if(raiz.getDer().getDato() == dato){
            if(raiz.getDer().esHoja()){
                raiz.setDer(null);
                return true;
            }
            return false;
        }
        
        if(dato < raiz.getDato()){
            return eliminar(raiz.getIzq(), dato);
        }else{
            return eliminar(raiz.getDer(), dato);
        }
        
    }//fin eliminar
    
    private boolean eliminar (NodoArbolBinario padre, char dato){
        
        if(padre.getIzq().getDato() == dato){
            if(padre.getIzq().esHoja()){
                padre.setIzq(null);
                return true;
            }
            return false;
        }
        
        if(padre.getDer().getDato() == dato){
            if(padre.getDer().esHoja()){
                padre.setDer(null);
                return true;
            }
            return false;
        }
        
        if(dato < padre.getDato()){
            return eliminar(padre.getIzq(), dato);
        }else{
            return eliminar(padre.getDer(), dato);
        }
        
    }//fin eliminar
    
    public String preorden(){
        
        String recorrido = preorden(raiz).trim();
        
        do{
            recorrido = recorrido.replaceAll("  ", " ");
        }while(recorrido.contains("  "));
        
        return recorrido.replaceAll(" ", ",");
        
    }//fin preorden
    
    private String preorden(NodoArbolBinario padre){
        
        if(padre == null) return "";
        
        return padre.getDato() + " " + preorden(padre.getIzq()) + " " + preorden(padre.getDer()) + " ";
        
    }//fin preorden
    
    public String inorden(){
        
        String recorrido = inorden(raiz).trim();
        
        do{
            recorrido = recorrido.replaceAll("  ", " ");
        }while(recorrido.contains("  "));
        
        return recorrido.replaceAll(" ", ",");
        
    }//fin preorden
    
    private String inorden(NodoArbolBinario padre){
        
        if(padre == null) return "";
        
        return inorden(padre.getIzq()) + " " + padre.getDato() + " " + inorden(padre.getDer()) + " ";
        
    }//fin preorden
    
    public String postorden(){
        
        String recorrido = postorden(raiz).trim();
        
        do{
            recorrido = recorrido.replaceAll("  ", " ");
        }while(recorrido.contains("  "));
        
        return recorrido.replaceAll(" ", ",");
        
    }//fin preorden
    
    private String postorden(NodoArbolBinario padre){
        
        if(padre == null) return "";
        
        return postorden(padre.getIzq()) + " "+ postorden(padre.getDer()) + " " +  padre.getDato() + " ";
        
    }//fin preorden
    
}//fin clase

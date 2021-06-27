/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ListaDoblePos extends ListaDoble{
    
    public ListaDoblePos(){
        super();
    }
    
    public boolean insertar(char dato, int pos){
        
        if(totalNodos() < pos){
            return super.insertar(dato); //PEPS
        }
              
        if(pos <= 0) return false;
        
        NodoDoble nuevo = new NodoDoble(dato);
        
        if(pos == 1){
            nuevo.setSig(ini);
            ini.setAnt(nuevo);
            ini = nuevo;
            return true;
        }
        
        int cont = 1;
        NodoDoble temp = ini;
        while((cont+1) < pos){
            temp = temp.getSig();
            cont++;
        }
        
        nuevo.setSig(temp.getSig());
        nuevo.setAnt(temp);
        temp.setSig(nuevo);
        temp = temp.getSig();
        temp.setAnt(nuevo);
        
        return true;
    }
    
    private int totalNodos(){
        
        if(estaVacia()) return 0;
        
        int cont = 1;
        for(NodoDoble t = ini; t!=fin; t=t.getSig()){
            cont++;
        }
        
        return cont;
    }//fin contador
    
    
    public boolean eliminar(char dato){
        
        if(estaVacia()) return false;
        /*
        if(hayUnNodo()){
            if(ini.getDato() == dato){
                ini = fin = null;
                return true;
            }
        }
        */
        if(ini.getDato() == dato){
            return eliminar();
        }
        
        for(NodoDoble ant = ini, temp = ini.getSig(); temp!=fin.getSig(); ant = temp, temp = temp.getSig()){
            if(temp.getDato() == dato){
                if(temp == fin){
                    fin.setAnt(null);
                    fin = ant;
                    fin.setSig(null);
                    temp = null;
                }else{
                    NodoDoble aux = temp.getSig();
                    
                    ant.setSig(temp.getSig());
                    temp.setAnt(null);
                    
                    aux = temp.getSig();
                    aux.setAnt(ant);
                    temp.setSig(null);
                    temp = null;
                }
                return true;
            }
        }
        
        return false;
    }//fin eliminar
    
}

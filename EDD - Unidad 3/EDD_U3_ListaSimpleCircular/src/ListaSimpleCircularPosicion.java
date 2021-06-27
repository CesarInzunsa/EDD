/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ListaSimpleCircularPosicion extends ListaSimpleCircular{
    
    public ListaSimpleCircularPosicion(){
        super();
    }
    
    public boolean insertar(char dato, int pos){
        
        if(totalNodos() < pos){
            return super.insertar(dato); //PEPS
        }
        
        if(pos <= 0) return false;
        
        Nodo nuevo = new Nodo(dato);
        
        if(pos == 1){
            nuevo.setSig(ini);
            ini = nuevo;
            fin.setSig(ini);
            return true;
        }
        
        int cont = 1;
        Nodo temp = ini;
        while((cont+1) < pos){
            temp = temp.getSig();
            cont++;
        }
        
        nuevo.setSig(temp.getSig());
        temp.setSig(nuevo);
        
        return true;
        
    }
    
    private int totalNodos(){
        
        if(estaVacia()) return 0;
        
        int cont = 1;
        for(Nodo t = ini; t!=fin; t=t.getSig()){
            cont++;
        }
        
        return cont;
    }//fin contador
    
    
    public boolean eliminar(char dato){
        
        if(estaVacia()) return false;
        
        if(ini.getDato() == dato){
            return eliminar();
        }
        
        
        if(hayUnNodo()){
            if(ini.getDato() == dato){
                ini = fin = null;
                return true;
            }
        }
        
        
        for(Nodo ant = ini, temp = ini.getSig(); temp!=fin.getSig(); ant = temp, temp = temp.getSig()){
            if(temp.getDato() == dato){
                if(temp == fin){
                    fin.setSig(null);
                    fin = ant;
                    ant.setSig(ini);
                    temp = null;
                }else{
                    ant.setSig(temp.getSig());
                    temp.setSig(null);
                    temp = null;
                }
                return true;
            }
        }
        
        return false;
    }//fin eliminar
    
}

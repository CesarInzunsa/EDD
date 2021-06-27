/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cesar
 */
public class ListaPrioridad extends ListaSimpleCircular {
    
    public ListaPrioridad(){
        super();
    }
    
    @Override
    public boolean insertar (char dato, int nivel){
        
        if(super.estaVacia()) return super.insertar(dato, nivel);
        
        if(seRepite(dato, nivel)) return false;
        
        Nodo nuevo = new Nodo(dato, nivel);
        if(nuevo == null) return false;
        
        if(nivel > ini.getNivel()){
            nuevo.setSig(ini);
            ini = nuevo;
            fin.setSig(ini);
            return true;
        }
        
        if(nivel <= fin.getNivel()){
            fin.setSig(nuevo);
            fin = nuevo;
            fin.setSig(ini);
            return true;
        }
        
        Nodo t1 = ini.getSig();
        Nodo t2 = ini;
        
        while(!(nivel > t1.getNivel())){
            t1 = t1.getSig();
            t2 = t2.getSig();
        }
        
        t2.setSig(nuevo);
        nuevo.setSig(t1);
        
        return true;
    }
    
    public boolean eliminar(char dato, int nivel){
        
        if(estaVacia()) return false;
        
        if(ini.getDato() == dato && ini.getNivel() == nivel){
            return eliminar();
        }

        for(Nodo ant = ini, temp = ini.getSig(); temp != fin.getSig(); ant = temp, temp = temp.getSig()){
            if(temp.getDato() == dato && temp.getNivel() == nivel){
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
    
    private boolean seRepite(char dato, int nivel){
        
        if(hayUnNodo()){
            if(ini.getDato() == dato && ini.getNivel() == nivel){
                return true;
            }
        }
        
        for(Nodo i = ini; i != fin; i = i .getSig()){
            if(i.getDato() == dato && i.getNivel() == nivel){
                return true;
            }
        }
        return false;
    }// fin seRepite    
    
}

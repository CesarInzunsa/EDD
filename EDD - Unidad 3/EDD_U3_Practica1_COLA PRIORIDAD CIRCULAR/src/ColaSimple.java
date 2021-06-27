public class ColaSimple {
    protected Prioridad[] vector;
    protected int ini;
    protected int fin;
    
    //constructor
    public ColaSimple(int tamaño){
        this.vector = new Prioridad [tamaño];
        this.ini=-1;
        this.fin=-1;
    }
    
    //comprueba si la cola simple esta llena
    protected boolean estaColaSimpleLlena(){
        return fin == vector.length-1;
    }
    
    //inserta un dato de tipo Prioridad de forma normal
    public boolean insertar(Prioridad objeto){
        //comprueba si la cola simple esta llena, si lo esta retorna un falso
        if(estaColaSimpleLlena()) return false;
        
        //insertar el valor en la posicion
        fin++;
        vector[fin] = objeto;
        
        //si la cola esta vacia ini se incrementa
        if(ini == -1) ini=0;
        
        analisisPrioridad();
        
        return true;
    }
    
    //comprueba si la cola simple esta vacia
    protected boolean estaColaSimpleVacia(){
        return ini == -1 && fin == -1;
    }
    
    //comprueba si solo existe un dato en el vector
    protected boolean hayUnSoloDato(){
        return ini == fin;
    }
    
    //realiza una eliminación logica
   public boolean eliminar(){
        //comprueba si la cola simple esta vacia, si lo esta retorna un falso
        if(estaColaSimpleVacia()) return false;
        
       /** comprueba si solo queda un dato en el vector, si es así retorna reinicia el vector
        *  y retorna un true porque se realizo la eliminacion logica1
        */
        if(hayUnSoloDato()){
            this.ini = -1;
            this.fin = -1;
            return true;
        }
        
        //eliminado logico
        ini++;
        
        return true;
    }

   //retorna el vector en la posicion deseada
    public Prioridad getVector(int posicion) {
        return vector[posicion];
    }
    
    //retorna fin
    public int getFin() {
        return fin;
    }
    
    //retorna ini
    public int getIni() {
        return ini;
    }
    
    //retorna el tamaño de nuestro vector
    public int getTamaño() {
        return vector.length;
    }
    
    //nuevo metodo para comprobar si existe una prioridad, de ser así reacomoda los objetos de acuerdo a su prioridad
    private void analisisPrioridad(){
        //si existe un solo objeto, terminamos el metodo analisisPrioridad debido a que, SOLO HAY UN OBJETO
        if(hayUnSoloDato()) return;
        
        int t1 = fin;
        int t2 = fin-1;
        //creamos el objeto aux para almacenar el dato y nivel temporalmente
        Prioridad objAux;
    
        //creamos un ciclo que terminara hasta que:
        //t1 deje de ser diferente a ini
        //ó
        //hasta que el nivel del t1 no sea mayor a t2
        while (t1 != ini){
            if(vector[t1].getNivel()>vector[t2].getNivel()){
                objAux = new Prioridad(vector[t1].getDato(), vector[t1].getNivel());
                vector[t1] = vector[t2];
                vector[t2] = objAux;
                t2--;
                t1--;
            }else{
                break;
            }
        }
    }//fin analisisPrioridad
    

   
}
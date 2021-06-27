/**
 *
 * @author cesar
 */
public class Tabla {
    
    private int ini;
    private long baseAux;

    public Tabla(int ini, long baseAux) {
        this.ini = ini;
        this.baseAux = baseAux;
    }

    public String tablaOf(long base){
        if(ini == 9){
            ini++;
            return baseAux +" x "+ ini + " = "+ base +"\n";
        }
        ini++;
        return baseAux +" x "+ ini + " = "+ base +"\n" + tablaOf((base+baseAux));
    }
    
}

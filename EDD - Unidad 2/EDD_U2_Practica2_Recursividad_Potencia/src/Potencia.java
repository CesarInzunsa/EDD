/**
 *
 * @author cesar
 */
public class Potencia {
    /*
    public int potencia(int x, int y){
        if (y==0){
            return 1;
        }
        return x * potencia(x, y-1);
    }
    */
    
    public int potenciaPlus(int x, int y){
        return (y == 0)? 1: x * potenciaPlus(x, y-1);
    }
}

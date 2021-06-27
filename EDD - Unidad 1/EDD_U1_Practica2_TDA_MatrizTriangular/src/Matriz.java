
import java.util.Random;

/**
* TDA que permite construir objetos que almacenen una matriz CUADRADA
* @author Cesar Inzunsa
* @version 1.0, 15/03/2021
*/
public class Matriz {
    //parametros
    private final int[][] matriz;
    private final int tamaño;

    /**
    * Constructor para Matriz
    * @param tamaño El constructor de la clase recibirá un ENTERO indicando el tamaño de RENGLONES Y COLUMNAS que se deberá construir y que posteriormente se llenara de numeros enteros generados aleatoriomente
    */
    public Matriz(int tamaño){
        this.tamaño = tamaño;
        matriz = new int[this.tamaño][this.tamaño];
        numerosAleatorios();
    }
    
    /**
    * Método que llena la matriz con numeros enteros generados aleatoriamente con la clase Random
    */
    private void numerosAleatorios(){
        Random r = new Random();
        for(int i = 0; i<this.tamaño; i++){
            for(int j = 0; j<this.tamaño; j++){
                matriz[i][j] = r.nextInt(10);
            }
        }
    }
    
    /**
     * Metodo que retorna una matriz NxN
     * @return Matriz
     */
    public int[][] getMatriz() {
        return matriz;
    }

    /**
     * Retorna una matriz de NxN (del mismo tamaño que la original) pero solo la parte triangular superior,
     * entendiendo los valores que incluyen la diagonal principal y lo que esté arriba de esta.
     * @return La matriz triangular superior
     */
    public int[][] obtenerTriangularSuperior(){
        int matrizAux[][]= new int [tamaño][tamaño];
        
        for(int i=0; i<tamaño; i++){
            for (int j=0; j<tamaño; j++){
                if(i<=j){
                    matrizAux[i][j] = matriz[i][j];
                }
            }
        }
        
        return matrizAux;
    }
    
    /**
     * retorna una matriz de NxN (mismo tamaño original) pero que solo contiene los valores de la diagonal invertida
     * y los elementos que se encuentran arriba de ésta.
     * @return La matriz triangular superior invertida
     */
    public int[][] obtenerTriangularSuperiorInversa(){
        int matrizAux[][]= new int [tamaño][tamaño];
        
        for(int i=0; i<tamaño; i++){
            for (int j=(tamaño-i-1); j>=0; j--){
                matrizAux[i][j] = matriz[i][j];
            }
        }
        
        return matrizAux;
    }

    /**
     * retorna una matriz de NxN (del mismo tamaño que la original) pero solo la parte triangular inferior,
     * entendiendo los valores que incluyen la diagonal principal y lo que esté abajo de esta.
     * @return La matriz triangular inferior
     */
    public int[][] obtenerTriangularInferior(){
        int matrizAux[][]= new int [tamaño][tamaño];
        
        for(int i=0; i<tamaño; i++){
            for (int j=0; j<tamaño; j++){
                if(i>=j){
                    matrizAux[i][j] = matriz[i][j];
                }
            }
        }
        
        return matrizAux;
    }
    
    /**
     * retorna una matriz de NxN (mismo tamaño original) pero que solo contiene los valores de la diagonal invertida y los elementos que se encuentran abajo de ésta.
     * @return La matriz triangular inferior invertida
     */
    public int[][] obtenerTriangularInferiorInversa(){
        int matrizAux[][]= new int [tamaño][tamaño];
        
        for(int i=(tamaño-1); i>=0; i--){
            for (int j=(tamaño-i-1); j<tamaño; j++){
                matrizAux[i][j] = matriz[i][j];
            }
        }
        
        return matrizAux;
    }

    /**
     * retorna los valores de la diagonal principal de la matriz.
     * @return Un vector de enteros
     */
    public int[] obtenerDiagonal(){
        int matrizAux[]= new int [tamaño];
        
        for(int i=0; i<tamaño; i++){
            for (int j=0; j<tamaño; j++){
                if(i==j){
                    matrizAux[i] = matriz[i][j];
                }     
            }
        }
        
        return matrizAux;
    }

    /**
     * retorna los valores de la diagonal invertida de la matriz.
     * @return Un vector de enteros
     */
    public int[] obtenerDiagonalInvertida(){
        int matrizAux[]= new int [tamaño];
        
        for(int i=0; i<tamaño; i++){
            for (int j=0; j<tamaño; j++){
                if((i+j) == (tamaño-1)){
                    matrizAux[i] = matriz[i][j];
                }     
            }
        }
        
        return matrizAux;
    }
    
    
}//fin TDA Matriz

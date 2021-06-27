import java.util.Random;
/*
Diseña un TDA que permita construir objetos que almacenen una matriz CUADRADA de enteros. El constructor de la clase recibirá un ENTERO indicando el tamaño de RENGLONES Y COLUMNAS que se deberá construir.
*/

/**
 *
 * @author cesar
 */
public class Matriz {
    private int[][] matriz;
    private int ren;
    private int col; 
    
    public Matriz(int tamaño){
        ren = tamaño;
        col = tamaño;
        matriz = new int[ren][col];
    }
    
    public void numerosAleatorios(){
        Random r = new Random();
        
        for(int i = 0; i<this.ren; i++){
            for(int j = 0; j<this.col; j++){
                matriz[i][j] = r.nextInt(10);
            }
        }
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    //- sumarValores: éste método no tiene parámetro, y obtiene la suma de TODOS LOS VALORES capturados de la matriz, retornando la suma de los mismos.
    public int sumarValores(){
        int suma = 0;
        
        for(int i=0; i<ren; i++){
            for(int j=0; j<col; j++){
                suma = suma + matriz[i][j];
            }
        }
        
        return suma;
    }
    
    //- sumarValoresRenglon(int numRenglon): éste método regresa la suma de valores del renglón indicado por la variable 
    public int sumarValoresRenglon(int numRenglon){
        int sumaRenglon = 0;
        
        for(int i=0; i<ren; i++){
            sumaRenglon += matriz[numRenglon][i];
        }
        
        return sumaRenglon;
    }
    
    //- sumarValoresColumna(int numColumna): igual que el anterior pero para columnas, indicando por la variable numColumna el índice de columa que se desea sumar.
    public int sumarValoresColumna(int numColumna){
        int sumaColumna = 0;
        
        for(int i=0; i<col; i++){
            sumaColumna +=  matriz[i][numColumna];
        }
        return sumaColumna;
    }
    
    //- intercambioRenglones(int reng1, int ren2): Realiza un intercambio de datos entre el renglon 1 y renglon 2.
    public boolean intercambioRenglones(int ren1, int ren2){
        int[] datosRen1 = new int [ren];
        int[] datosRen2 = new int [ren];
        
        for(int i=0; i<ren; i++){
            datosRen1[i] = matriz[ren1][i];
        }
        
        for(int i=0; i<ren; i++){
            datosRen2[i] = matriz[ren2][i];
        }
        
        for(int i=0; i<ren; i++){
            matriz[ren1][i] = datosRen2[i];
        }
        
        for(int i=0; i<ren; i++){
            matriz[ren2][i] = datosRen1[i];
        }
        
        return true;
    }
    
    //- intercambioColumnas(int col1, int col2): Realiza un intercambio de valores entre las columnas 1 y 2.
    public boolean intercambioColumnas(int col1, int col2){
        int[] datosCol1 = new int [col];
        int[] datosCol2 = new int [col];
        
        for(int i=0; i<col; i++){
            datosCol1[i] = matriz[i][col1];
        }
        
        for(int i=0; i<col; i++){
            datosCol2[i] = matriz[i][col2];
        }
        
        for(int i=0; i<col; i++){
            matriz[i][col1] = datosCol2[i];
        }
        
        for(int i=0; i<col; i++){
            matriz[i][col2] = datosCol1[i];
        }
        
        return true;
    }
    
    //- copiarRenglon(int origen, int destino): Realiza un copiado de valores desde renglon origen hacia renglón destino.
    public boolean copiarRenglon(int origen, int destino){
        int[] datos = new int [ren];
        
        for(int i=0; i<ren; i++){
            datos[i] = matriz[origen][i];
        }
        
        for(int i=0; i<ren; i++){
            matriz[destino][i] = datos[i];
        }
        
        return true;
    }
    
    //- copiarColumna(int colOrigen, int ColDestino): Copia los datos de la columna origen sobre la destino.
    public boolean copiarColumna(int origen, int destino){
        int[] datos = new int [col];
        
        for(int i=0; i<col; i++){
            datos[i] = matriz[i][origen];
        }
        
        for(int i=0; i<col; i++){
            matriz[i][destino] = datos[i];
        }
        
        return true;
    }
    
    //- inversa: no lleva parámetro, retorna la matriz inversa, es decirlo los renglones los vuelve columnas y viceversa.
    public boolean inversa(){
        int matrizAux[][]= new int [ren][col];
        
        for(int i=0; i<col; i++){
            for(int j=0; j<col; j++){
                matrizAux[i][j] = matriz[i][j];
            }
        }
        
        for(int i=0; i<col; i++){
            for(int j=0; j<col; j++){
                matriz[i][j] =  matrizAux[j][i];
            }
        }

        return true;
    }
    
}//fin clase Matriz


import javax.swing.JOptionPane;

//clase de pruebas
public class NewMain {

    public static void main(String[] args) {
        
        int tamaño = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño matriz"));

        Matriz objeto = new Matriz(tamaño);
        
        objeto.numerosAleatorios();
        
        int [][] matriz = objeto.getMatriz();
        
        for(int i = 0; i<tamaño; i++){
            for(int j = 0; j<tamaño; j++){
                System.out.print("["+(i)+"]"+"["+(j)+"]"+matriz[i][j]);
            }
            System.out.println("\n");
        }
        /*
        int suma = objeto.sumarValores();
        System.out.println("La suma total es: "+suma);
        */
        /*
        int renglon = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de renglon"));
        int sumaRenglon = objeto.sumarValoresRenglon(renglon);
        System.out.println("La suma del renglon "+renglon+" es: "+sumaRenglon);
        */
        /*
        int columna = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de columna"));
        int sumaColumna = objeto.sumarValoresColumna(columna);
        System.out.println("La suma de la columna "+columna+" es: "+sumaColumna);
        */
        
        /*
        int ren1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primer renglon"));
        int ren2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Segundo renglon"));
        
        boolean respuesta = objeto.intercambioRenglones(ren1, ren2);
        
        if(respuesta == true){
            for(int i = 0; i<tamaño; i++){
            for(int j = 0; j<tamaño; j++){
                System.out.print("["+(i)+"]"+"["+(j)+"]"+matriz[i][j]);
            }
            System.out.println("\n");
            }
        }else{
            System.out.println("ERROR");
        }
        */
        /*
        int col1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Primer columna"));
        int col2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Segunda secolumna"));
        
        boolean respuesta = objeto.intercambioColumnas(col1, col2);
        
        if(respuesta == true){
            for(int i = 0; i<tamaño; i++){
            for(int j = 0; j<tamaño; j++){
                System.out.print("["+(i)+"]"+"["+(j)+"]"+matriz[i][j]);
            }
            System.out.println("\n");
            }
        }else{
            System.out.println("ERROR");
        }
        */
        
        /*
        int origen = Integer.parseInt(JOptionPane.showInputDialog(null, "copiar, origen"));
        int destino = Integer.parseInt(JOptionPane.showInputDialog(null, "pegar,destino"));
        
        boolean respuesta = objeto.copiarRenglon(origen, destino);
        
        if(respuesta == true){
            for(int i = 0; i<tamaño; i++){
            for(int j = 0; j<tamaño; j++){
                System.out.print("["+(i)+"]"+"["+(j)+"]"+matriz[i][j]);
            }
            System.out.println("\n");
            }
        }else{
            System.out.println("ERROR");
        }
        */
        
        /*
        boolean respuesta = objeto.inversa();
        
        if(respuesta == true){
            for(int i = 0; i<tamaño; i++){
            for(int j = 0; j<tamaño; j++){
                System.out.print("["+(i)+"]"+"["+(j)+"]"+matriz[i][j]);
            }
            System.out.println("\n");
            }
        }else{
            System.out.println("ERROR");
        }
        */
        
        
    }//fin main
    
}

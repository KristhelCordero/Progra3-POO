
package Objetos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *  Objeto que contiene toda la informacion sobre una partida de KenKen
 * como su solucion, su dificultad e identificador(nombre)
 * @author KendallP
 */
public class KenKen {
    String nombre;
    int dificultad;
    int dimension;
    //String rutaImagen; //ruta a la imagen del Ken Ken
    int[][]solucion = new int[9][9];

    /**
     * Constructor generico de KenKen
     */
    public KenKen() {
    }

    /**
     * retorna el nombre o codigo del KenKen
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * modifica el nombre o codigo del KenKen
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * saca el valor dificultad de un kenken
     * 1: facil
     * 2: medio
     * 3: dificil
     * @return dificultad
     */
    public int getDificultad() {
        return dificultad;
    }

    /**
     * modifica la dificultad del kenken
     * @param dificultad
     */
    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    /**
     * retorna la solucion
     * @return
     */
    public int[][] getSolucion() {
        return solucion;
    }

    /**
     * modifica la solucion del KenKen
     * @param solucion
     */
    public void setSolucion(int[][] solucion) {
        this.solucion = solucion;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    
    
    public void actualizarDimension(){
        String[] partes = nombre.split("x");
        if (partes.length > 0) {
            setDimension(Integer.parseInt(partes[0]));
        } else {
            System.out.println("No se encontró ningún número.");
        }
    }
    /**
     * imprime todos los datos de un KenKen
     */
    public void imprimir(){
        System.out.println("Nombre:" +nombre+
                "\nDificultad:"+dificultad+
                        "\nSolucion:\n");
        String mensaje="";
        for (int i=0;i<6;i++){
            for(int j=0; j<6;j++){
                mensaje+=Integer.toString(solucion[i][j])+"     ";
            }
            mensaje+="\n";
        }
        System.out.println(mensaje);
    }

    /**
     * se le incerta un valor a la matriz de solucion
     * @param celda
     */
    public void insertarValorSolucion(String celda){
        String[] partes = celda.split("[,()]");
       
        int valor = Integer.parseInt(partes[0].trim());
        int fila = Integer.parseInt(partes[2].trim());        
        int columna = Integer.parseInt(partes[3].trim());
        //System.out.println(valor+"\n"+fila+"\n"+columna);

        solucion[fila-1][columna-1]=valor;
    }
    
    /**
     * valida que la partida jugada actualmente (extraida del juego) sea igual
     * a la solucion y retorna una matriz con las celdas en las que es y las que no es igual
     * @param partida
     * @return matrizCorreccion
     */
    
    public boolean[][] validarSolucion3x3(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[3][3];
        
        for(int i=0; i<3;i++){
            for (int j=0; j<3;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
    
    public boolean[][] validarSolucion4x4(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[4][4];
        
        for(int i=0; i<4;i++){
            for (int j=0; j<4;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
    
    public boolean[][] validarSolucion5x5(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[5][5];
        
        for(int i=0; i<5;i++){
            for (int j=0; j<5;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
    
    public boolean[][] validarSolucion6x6(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[6][6];
        
        for(int i=0; i<6;i++){
            for (int j=0; j<6;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    }
    
    public boolean[][] validarSolucion7x7(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[7][7];
        
        for(int i=0; i<7;i++){
            for (int j=0; j<7;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
    
    public boolean[][] validarSolucion8x8(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[8][8];
        
        for(int i=0; i<8;i++){
            for (int j=0; j<8;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
    
    public boolean[][] validarSolucion9x9(JLabel[][] partida){
        boolean[][] matrizCorreccion= new boolean[9][9];
        
        for(int i=0; i<9;i++){
            for (int j=0; j<9;j++){
                //System.out.println(i);
                //System.out.println(j);
                if(partida[i][j].getText().equals("")){
                    matrizCorreccion[i][j]=false;
                }else{
                    //System.out.println(partida[i][j].getText());
                    matrizCorreccion[i][j]=(Integer.parseInt(partida[i][j].getText())
                        ==solucion[i][j]);
                    //System.out.println("Holi");
                }
            }
        }
        return matrizCorreccion;
    } 
}

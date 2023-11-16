/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Objetos;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Timer timer = new Timer(0,0,0,0);
        Configuracion configuracion= new Configuracion(true, true, 1, 1,timer, 6);
        Funciones.escribirArchivosBinariosConfiguracion(configuracion);
        System.out.println("listo");
    }
    
}

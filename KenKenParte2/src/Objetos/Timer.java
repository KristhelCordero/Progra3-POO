
package Objetos;

import java.io.Serializable;

/**
 * Clase timer, es la hora, minuto, segundo y milisegundo del temporizador 
 * @author Usuario
 */
public class Timer implements Serializable{
    int hora;
    int minuto;
    int segundo;
    int milisegundo;

    /**
     * contructor de timer
     * @param hora
     * @param minuto
     * @param segundo
     * @param milisegundo
     */
    public Timer(int hora, int minuto, int segundo, int milisegundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
        this.milisegundo = milisegundo;
    }

    /**
     *Constructor generico de timer
     */
    public Timer() {

    }

    /**
     * retorna la hora
     * @return
     */
    public int getHora() {
        return hora;
    }

    /**
     * modifica la hora
     * @param hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * retorna el minuto
     * @return
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * modifica el minuto
     * @param minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * retorna el segundo
     * @return
     */
    public int getSegundo() {
        return segundo;
    }

    /**
     * modifica el segundo
     * @param segundo
     */
    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }

    /**
     * retorna el milisegundo
     * @return
     */
    public int getMilisegundo() {
        return milisegundo;
    }

    /**
     * modifica el milisegundo<
     * @param milisegundo
     */
    public void setMilisegundo(int milisegundo) {
        this.milisegundo = milisegundo;
    }
    
    /**
     * devuelve el timer a 0 (todos sus valores)
     */
    public void resetearTimer(){
        setHora(0);
        setMinuto(0);
        setSegundo(0);
        setMilisegundo(0);
    }
    
}

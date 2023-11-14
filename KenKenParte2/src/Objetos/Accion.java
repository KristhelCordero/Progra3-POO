
package Objetos;

import java.util.Objects;

/**
 *Objeto accion que se regitra como las escrituras y borrados de numeros en el juego
 *se utiliza en la base de datos para deshacerlas y rehacerlas
 * @author KendallP
 */
public class Accion {
    int fila;
    int columna;
    boolean agregar;//si se agrego un numero es true, si se quitó es false
    String dato;

    /**
     * Constructor del objeto accion
     * @param fila
     * @param columna
     * @param dato
     */
    public Accion(int fila, int columna, String dato) {
        this.fila = fila;
        this.columna = columna;
        this.dato = dato;
    }
    
    
    /*
    public Accion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
        this.agregar = true;
    }
    */

    /**
     * retorna la fila de la matriz en la que se hizo la accion
     * @return Fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * modifica la fila de la matriz en la que se realizo la accion
     * @param fila
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     *Retorna la columna de la matriz en donde se realizo la accion
     * @return
     */
    public int getColumna() {
        return columna;
    }
    /**
     * modifica la columna de la matriz en la que se realizo la accion
     * @param columna
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * verifica si se esta agregando un valor o no
     * @return agregar
     */
    public boolean isAgregar() {
        return agregar;
    }

    /**
     * Modifica el estado de agregacion
     * @param agregar
     */
    public void setAgregar(boolean agregar) {
        this.agregar = agregar;
    }

    /**
     * retorna el dato que fue modificao en la accion
     * @return dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * Modifica el dato que fue alterado en la accion
     * @param dato
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     *genera el codigo hash
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.fila;
        hash = 79 * hash + this.columna;
        hash = 79 * hash + (this.agregar ? 1 : 0);
        hash = 79 * hash + Objects.hashCode(this.dato);
        return hash;
    }

    /**
     *compara dos objeto accion para verificar si son iguales
     * @param obj
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accion other = (Accion) obj;
        if (this.fila != other.fila) {
            return false;
        }
        if (this.columna != other.columna) {
            return false;
        }
        if (this.agregar != other.agregar) {
            return false;
        }
        return Objects.equals(this.dato, other.dato);
    }
    
    
    
    
}

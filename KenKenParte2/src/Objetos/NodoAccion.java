
package Objetos;

/**
 * Es un nodo utilizado para la pila de acciones
 * @author KendallP
 */
public class NodoAccion {
    public Accion dato;
    public NodoAccion predecesor;
    public NodoAccion sucesor;
    
    

    /**
     * Constructor generico de nodoAccion
     */
    public NodoAccion(){
        predecesor=null;
        sucesor=null;
    }
}

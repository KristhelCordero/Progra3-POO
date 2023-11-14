
package Objetos;

/**
 * Pila de acciones utilizada para funciones de deshacer accion y rehacer accion
 * guarda todas las acciones hechas por el usuario en la matriz de la partida
 * @author KendallP
 */
public class PilaAcciones{
    private NodoAccion top;
    
    /**
     *constructor generico de PilaAcciones
     */
    public PilaAcciones(){
        top=null;
    }
    
    /**
     * coloca un nodo en la parte superior de la pila
     * @param t
     */
    public void push(Accion t){
        NodoAccion nodo=new NodoAccion();
        nodo.dato=t;
        if(empty()){
            top=nodo;
        }else{
            nodo.sucesor= top;
            top=nodo;
        }
    }
    
    /**
     * imprime todos los nodos que hayan en la pila
     */
    public void imprimirLista(){
        NodoAccion nodo;
        nodo=top;
        while (nodo!= null){
            System.out.println(nodo.dato);
            nodo=nodo.sucesor;
        }
    }
    
    /**
     * muestra el ultimo valor igresado en la pila
     * @return
     */
    public Accion peek(){
        return top.dato;
    }

    /**
     *  limpia la pila 
     */
    public void clear(){
        top=null;
    }
    
    /**
     * verifica si la pila esta vacia
     * @return true/false
     */
    public boolean empty(){
        return top == null; 
    }
    
    /**
     *  Elimina el ultimo valor de la pila y lo retorna 
     * @return accion
     */
    public Accion pop(){
        if (top==null){
            return null;
        }else{
            NodoAccion tmp=top;
            top=top.sucesor;
            tmp.sucesor=null;
            return tmp.dato;
        }
    }
    

}
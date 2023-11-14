
package Objetos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



/**
 * Es la base de datos donde se guardan los datos, configuracion y pilas de 
 * acciones del juego
 * @author KendallP
 */
public class BD { 
    Configuracion configuracion= new Configuracion();
    List<KenKen> listaKenKen = new ArrayList<>();
    PilaAcciones acciones=new PilaAcciones();
    PilaAcciones accionesDeshechas=new PilaAcciones();
     
    /**
     *Constructor vacio de la base de datos
     */
    public void BD(){

    }
    
    /**
     * Saca una lista de Objetos Ken Ken en base a la dificultas escogida en 
     * la configuracion
     * 
     * @return ListaDificulta(lista de KenKen)
     */
    public List<KenKen> sacarListaDificultad(){ //sujeto a cambios (se puede guardar en un parametro)
        List<KenKen> listaDificultad= new ArrayList<>();
        for(KenKen kenken:listaKenKen){
            if(configuracion.dificultad==kenken.dificultad){
                listaDificultad.add(kenken);
            }
        }
        return listaDificultad;
    }

    /**
     * retorna el objeto configuracion registrado en la base de datos
     * @return
     */
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    /**
     * Modifica la configuracion registrada
     * @param configuracion
     */
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    /**
     *retorna el objeto configuracion
     * @return configuracion
     */
    public List<KenKen> getListaKenKen() {
        return listaKenKen;
    }

    /**
     * Modifica la lista de KenKen
     * @param listaKenKen
     */
    public void setListaKenKen(List<KenKen> listaKenKen) {
        this.listaKenKen = listaKenKen;
    }
    
    //KENKEN

    /**
     * Saca el nodo extraido del xml y lo convierte en un objeto KenKen
     * @param eHijo
     * @return KenKen
     */
    public KenKen convertirNodoEnKenKen(Element eHijo){
        KenKen kenken= new KenKen();
        NodeList nietos= eHijo.getChildNodes();
        for(int k=0; k<nietos.getLength();k++){
            //System.out.println("Largo: "+nietos.getLength());
            //System.out.println("index: "+k);
            Node nieto = nietos.item(k);
            if(nieto.getNodeType()==Node.ELEMENT_NODE){
                //System.out.println("Se evalua el nodo"+nieto.getNodeName());
                if("codigo".equals(nieto.getNodeName())){
                    kenken.setNombre(nieto.getTextContent());
                }
                if("nivelDificultad".equals(nieto.getNodeName())){
                    kenken.setDificultad(
                            Funciones.pasarStringDificultadAInt(
                                    nieto.getTextContent()));
                }
                if("celda".equals(nieto.getNodeName())){
                    //System.out.println(nieto.getTextContent());
                    kenken.insertarValorSolucion(nieto.getTextContent());
                    //System.out.println("sinserto");
                }

            }
        }
        return kenken;
    }
    
    /**
     * Toma el archivo XML y saca la lista de KenKen de él
     */
    public void extraerXMLListaKenKen(){
        //String dirXMl=KenKen\kenken.xml;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("kenken.xml"));
            
            NodeList listaPartidas = documento.getElementsByTagName("KenKen");
            for (int i=0; i < listaPartidas.getLength() ; i++){
                Node nodoPadre = listaPartidas.item(i);
                //System.out.println(nodoPadre.getNodeName());//Ken Ken
                if(nodoPadre.getNodeType()==Node.ELEMENT_NODE){
                    Element ePadre = (Element) nodoPadre;
                    NodeList hijos = ePadre.getChildNodes();
                    for (int j=0; j<hijos.getLength(); j++){
                        Node hijo = hijos.item(j);
                        //System.out.println(hijo.getNodeName());//partida solucion partida
                        if(hijo.getNodeType()==Node.ELEMENT_NODE){
                            if ("solucion".equals(hijo.getNodeName())){
                                Element eHijo = (Element) hijo;
                                //System.out.println("se convierte nodo en kenken");
                                listaKenKen.add(convertirNodoEnKenKen(eHijo));
                                //System.out.println("pasa la funcion");
                            }
                        }
                    }
                } 
            }
        }catch(ParserConfigurationException | SAXException | IOException ex){
            System.out.println("No se pudo leer el XML");
        }
    }
    
    /**
     *Imprime la lista de KenKen
     */
    public void imprimirListaKenKen(){
        //System.out.println("llega");
        for(KenKen kenken: listaKenKen){
            kenken.imprimir();
        }
    }
    
    /**
     * Saca el KenKen aleatorio en bas a la dificultad
     * @return nombre
     */
    public String extraerKenKenActual(){
        Random rand = new Random();
        String nombre = "src/imagenes/";
        
        int numeroKenKen = rand.nextInt(3) + 1;
        switch (configuracion.getDificultad()) {
            case 1 -> nombre+="E-"+Integer.toString(numeroKenKen)+"_in.png";
            case 2 -> nombre+="H-"+Integer.toString(numeroKenKen)+"_in.png";
            default -> nombre+="D-"+Integer.toString(numeroKenKen)+"_in.png";
        }
        return nombre;
    }
    //Configuracion
    
    /**
     * Genera una configuracion por defecto cuando se genera
     */
    public void generarConfiguracionDefault(){
        configuracion.resetear();
    }
    
    /**
     * Busca un KenKen por nombre (codigo)
     * @param nombre
     * @return kenken
     */
    public KenKen buscarKenKen(String nombre){
        nombre=nombre.substring(13, nombre.length() - 6);
        nombre+="com";
        for(KenKen kenken:listaKenKen){
            //System.out.println(kenken.nombre);
            if(kenken.nombre.equals(nombre)){
               return kenken;
            }
        }
        return null;
    }
    
    //ACCIONES

    /**
     * Se añade una accion de escritura a la base de datos
     * @param fila
     * @param columna
     * @param dato
     */
    public void annadirAccionEscribir(int fila, int columna, String dato){
        Accion accion=new Accion(fila,columna,dato);
        accion.agregar=true;
        acciones.push(accion);
    }

    /**
     * Se añade una accion de borrado a la base de datos
     * @param fila
     * @param columna
     * @param dato
     */
    public void annadirAccionBorrar(int fila, int columna, String dato){
        Accion accion=new Accion(fila,columna,dato);
        accion.agregar=false;
        acciones.push(accion);
    }
    
    /**
     * elimina la ultima accion de las acciones hechas y la retorna, ademas de guardarla en 
     * las acciones desechas 
     * @param accionDesecha
     * @return accion
     */
    public Accion deshacerAccion(Accion accionDesecha){
        if(!acciones.empty()){
            Accion accion = acciones.pop();
            accionesDeshechas.push(accionDesecha);
            return accion;
        }
        return null;
    }

    /**
     * Elimina la ultima accion de las acciones desechas y la registra en las 
     * acciones hechas nuevamente
     * @param accionHecha
     * @return accion
     */
    public Accion rehacerAccion(Accion accionHecha){
        if(!accionesDeshechas.empty()){
            Accion accion = accionesDeshechas.pop();
            acciones.push(accionHecha);
            return accion;
        }
        return null;
    }
    
    /**
     * funciona como peek de las acciones hechas
     * @return accion (la ultima accion hecha)
     */
    public Accion mostrarUltimaAccionHecha(){
        if (!acciones.empty()){
            return acciones.peek();
        }
        return null;
    }

    /**
     * peek de pila de acciones desechas
     * @return
     */
    public Accion mostrarUltimaAccionDeshecha(){
        if (!accionesDeshechas.empty()){
            return accionesDeshechas.peek();
        }
        return null;
    }
    
    /**
     * elimina todas las acciones de las pilas de acciones
     */
    public void limpiarPilas(){
        acciones.clear();
        accionesDeshechas.clear();
    }
    
    
}

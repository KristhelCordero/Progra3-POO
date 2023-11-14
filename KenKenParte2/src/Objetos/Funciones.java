
package Objetos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Clase con diversas funciones utiles par el funcionamiento de los metodos aplicados en el programa
 * @author KendallP
 */
public class Funciones {

    /**
     * Toma un valor string y retorna su equivalente en int para el objeto de configuracion 
     * @param sDificultad
     * @return
     */
    public static int pasarStringDificultadAInt(String sDificultad){
        if (sDificultad.equals("Dificil")){
            return 3;
        }
        if (sDificultad.equals("Medio")){
            return 2;
        }
        if (sDificultad.equals("Facil")){
            return 1;
        }else{return -1;}
    }
    
    /**
     * escribe en un archivo .dat un objeto configuracion del cual se va a sacar 
     * la configuracion en un futuro por defecto
     * @param configuracion
     */
    public static void escribirArchivosBinariosConfiguracion(Configuracion configuracion){
        File archivo = new File("configuracion.dat");
        try{
            FileOutputStream fos = new FileOutputStream(archivo) ;
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(configuracion);
            oos.close();
            fos.close();
        }catch (Exception e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    /**
     * Lee un archivo binario y extrae un objeto configuracion 
     * @return configuracion
     */
    public static Configuracion leerArchivoBinarioConfiguracion(){
        File archivo = new File("configuracion.dat");
        try{
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois;
            ois = new ObjectInputStream(fis);
            Configuracion configuracion = (Configuracion) ois.readObject();
            System.out.println("Archivo 'Configuracion.dat' leido con exito");
            return configuracion;
        }catch (Exception e){ 
            System.out.println("Error");
            e.printStackTrace();
            return null;
        }
        
    }
    
    /**
     * se le ingresa un link y crea un pdf que contiene ese Link (se utiliza para generar
     * el manual de usuario)
     * @param link
     * @return confirmacion
     */
    public static String crearPDFAyuda(String link){
        try{
            Document document = new Document();//

                    
             
            String destino = "ayuda.pdf";//
            PdfWriter.getInstance(document, new FileOutputStream(destino));//
            document.open();//
            //codigo
            Paragraph titulo = new Paragraph("Link a manual de usuario\n ", 
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph parrafoLink = new Paragraph("____\n" +
"_(____)_\n" +
"___ooO_(_o__o_)_Ooo___\n" +
link,FontFactory.getFont(FontFactory.COURIER, 11, BaseColor.BLACK));
            
            
            parrafoLink.setAlignment(Element.ALIGN_CENTER);
            Paragraph deco1 = new Paragraph("____________________________ ⋆★⋆ ____________________________");
            deco1.setAlignment(Element.ALIGN_CENTER);
            Paragraph deco2 = new Paragraph("╔════════════════════════════════════════════════════════════╗\n");
            deco2.setAlignment(Element.ALIGN_CENTER);
            Paragraph deco3 = new Paragraph("╚════════════════════════════════════════════════════════════╝");
            deco3.setAlignment(Element.ALIGN_CENTER);
            Paragraph deco4 = new Paragraph("_________________¶¶¶1___¶¶¶____¶¶¶1_______________\n" +
"__________________¶¶¶____¶¶¶____1¶¶1______________\n" +
"___________________¶¶¶____¶¶¶____¶¶¶______________\n" +
"___________________¶¶¶____¶¶¶____¶¶¶______________\n" +
"__________________¶¶¶____1¶¶1___1¶¶1______________\n" +
"________________1¶¶¶____¶¶¶____¶¶¶1_______________\n" +
"______________1¶¶¶____¶¶¶1___¶¶¶1_________________\n" +
"_____________¶¶¶1___1¶¶1___1¶¶1___________________\n" +
"____________1¶¶1___1¶¶1___1¶¶1____________________\n" +
"____________1¶¶1___1¶¶1___1¶¶¶____________________\n" +
"_____________¶¶¶____¶¶¶1___¶¶¶1___________________\n" +
"______________¶¶¶¶___1¶¶¶___1¶¶¶__________________\n" +
"_______________1¶¶¶1___¶¶¶1___¶¶¶¶________________\n" +
"_________________1¶¶1____¶¶¶____¶¶¶_______________\n" +
"___________________¶¶1____¶¶1____¶¶1______________\n" +
"___________________¶¶¶____¶¶¶____¶¶¶______________\n" +
"__________________1¶¶1___1¶¶1____¶¶1______________\n" +
"_________________¶¶¶____¶¶¶1___1¶¶1_______________\n" +
"________________11_____111_____11_________________\n" +
"__________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶¶¶¶¶¶¶¶¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶_______¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"1¶¶_______¶¶__1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"_¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"_¶¶¶¶¶¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________\n" +
"__________¶¶___1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1________\n" +
"__________1¶¶___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_________\n" +
"____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶11__________\n" +
"11_____________________________________________111\n" +
"1¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1\n" +
"__¶¶111111111¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶111111111¶__",
            FontFactory.getFont(FontFactory.COURIER, 9, BaseColor.BLACK));
            deco4.setAlignment(Element.ALIGN_CENTER);

            
            document.add(deco1);
            document.add(titulo);
            document.add(deco2);
            document.add(parrafoLink);
            document.add(deco3);
            document.add(deco4);


            document.close();// fin plantilla
            return "PDF creado";

        } catch(FileNotFoundException | DocumentException ex){
            return "Error al crear el PDF";
        }
    }
}

package Interfaz;

import static Interfaz.MenuPrincipal.bd;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Objetos.*;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;


/**
 *
 * @author Kristhel Cordero y Kendall Piedra
 */
public class Jugar5x5 extends javax.swing.JFrame {
    private JLabel[][] matrizDeLabels;
    private boolean iniciado, finalizadoTimer, expirado;
    private final String kenken=bd.extraerKenKenActual5x5();
    private Timer cronometro, timer;
    private int horas=bd.getConfiguracion().getTimer().getHora();
    private int minutos=bd.getConfiguracion().getTimer().getMinuto();
    private int segundos=bd.getConfiguracion().getTimer().getSegundo();
    private int milisegundos=bd.getConfiguracion().getTimer().getMilisegundo();
    /**
     * Crea un nuevo JFrame llamado Jugar, con los botoens debidamente apagados y las 
     * especificaciones acordes a la configuración del usuario
     */
    public Jugar5x5() {
        initComponents();
        jButtonValidarJuego.setEnabled(false);
        jButtonTerminarJuego.setEnabled(false);
        jButtonReiniciarJuego.setEnabled(false);
        jButtonOtroJuego.setEnabled(false);
        jButtonReaunudar.setEnabled(false);
        jButtonPodio.setEnabled(false);
        matrizDeLabels= new JLabel[5][5];
        this.crearMatrizLabels();
        this.definirColorLabels();
        this.setLocationRelativeTo(this);
        iniciado=expirado=false;
        finalizadoTimer=false;
        setImageLabel(kenken);
        //bd.getConfiguracion().setReloj(2);
        switch (bd.getConfiguracion().getReloj()) {
            case 3:
                jLabelTiempo.setText(null);
                break;
            default:
                cronometro=new Timer(10, (ActionEvent e) -> {
                    iniciarCronometro();
                }); 
                timer=new Timer(10, (ActionEvent e) -> {
                    iniciarTimer();
                });
                break;
        }
    }
    
    /**
     * Actualiza el cronómetro cada segundo
     */
    private void actualizarCronometro(){
        milisegundos++;
        if(milisegundos>=67){
            milisegundos=0;
            segundos++;
        }
        if(segundos==60){
            segundos=0;
            minutos++;
        }
        if(minutos==60){
            minutos=0;
            horas++;
        }
        if(horas==24){
            horas=0;
        }
    }
    
    /**
     * Actualiza el timer cada segundo
     */
    private void actualizarTimer(){
        if (milisegundos == 0) {
            if (segundos == 0) {
                if (minutos == 0) {
                    if (horas == 0) {
                        finalizadoTimer=true;
                    } else {
                        horas--;
                        minutos = 59;
                        segundos = 59;
                    }
                } else {
                    minutos--;
                    segundos = 59;
                }
            } else {
                segundos--;
            }
            milisegundos = 67;
        } else {
            milisegundos--;
        }
    }
    
    /**
     * Muestra en pantalla cada segundo, los segundos minutos y horas correspondientes
     */
    private void actualizarLabel(){
        String cronometro = horas+" : "+ minutos+" : "+ segundos;
        jLabelTiempo.setText(cronometro);
        this.repaint();
    }
    
    /**
     * Función que ejecutará el cronometro constantemente
     */
    private void iniciarCronometro(){
        actualizarCronometro();
        actualizarLabel();
    }
    
    /**
     * Función que ejecutará el timer constantemente
     */
    private void iniciarTimer(){
        if(!finalizadoTimer){
            actualizarLabel();
            actualizarTimer();
        }else{
            timer.stop();
            int dialogButton=JOptionPane.showConfirmDialog(null,
                "TIEMPO EXPIRADO! Desea coninuar con este mismo juego?",
                "Confirmación",JOptionPane.YES_NO_OPTION);
            if(dialogButton==JOptionPane.YES_OPTION){
                horas=bd.getConfiguracion().getTimer().getHora();
                minutos=bd.getConfiguracion().getTimer().getMinuto();
                segundos=bd.getConfiguracion().getTimer().getSegundo();
                milisegundos=bd.getConfiguracion().getTimer().getMilisegundo();
                cronometro.start();
            }else{
                MenuPrincipal inicio = new MenuPrincipal();
                inicio.setVisible(true);
                this.dispose();
            }
        }
    }
    
    /**
    * Función que reinicia el cronómetro colocándolo en 0
    */
    private void reiniciarCronometro(){
        cronometro.stop();
        milisegundos=0;
        segundos=0;
        minutos=0;
        horas=0;
    }

    /**
     * Función que configura el Ken Ken respecto a lo establecido
     * @param root
     */

    public void setImageLabel(String root){
        ImageIcon imagen= new ImageIcon(root);
        Icon icono= new ImageIcon(imagen.getImage().getScaledInstance(jLabelKenKen.getWidth(), jLabelKenKen.getHeight(), Image.SCALE_DEFAULT));
        jLabelKenKen.setIcon(icono);
        this.repaint();
    }
    
    /*
    Función que crea una matriz de JLabels
    */
    public void crearMatrizLabels(){
        matrizDeLabels[0][0]=jLabel_1_1;
        matrizDeLabels[0][1]=jLabel_1_2;
        matrizDeLabels[0][2]=jLabel_1_3;
        matrizDeLabels[0][3]=jLabel_1_4;
        matrizDeLabels[0][4]=jLabel_1_5;
        matrizDeLabels[1][0]=jLabel_2_1;
        matrizDeLabels[1][1]=jLabel_2_2;
        matrizDeLabels[1][2]=jLabel_2_3;
        matrizDeLabels[1][3]=jLabel_2_4;
        matrizDeLabels[1][4]=jLabel_2_5;
        matrizDeLabels[2][0]=jLabel_3_1;
        matrizDeLabels[2][1]=jLabel_3_2;
        matrizDeLabels[2][2]=jLabel_3_3;
        matrizDeLabels[2][3]=jLabel_3_4;
        matrizDeLabels[2][4]=jLabel_3_5;
        matrizDeLabels[3][0]=jLabel_4_1;
        matrizDeLabels[3][1]=jLabel_4_2;
        matrizDeLabels[3][2]=jLabel_4_3;
        matrizDeLabels[3][3]=jLabel_4_4;
        matrizDeLabels[3][4]=jLabel_4_5;
        matrizDeLabels[4][0]=jLabel_5_1;
        matrizDeLabels[4][1]=jLabel_5_2;
        matrizDeLabels[4][2]=jLabel_5_3;
        matrizDeLabels[4][3]=jLabel_5_4;
        matrizDeLabels[4][4]=jLabel_5_5;
    }
    
    /**
     *  Funcion: Introduce un número determinado en la casilla seleccionada 
     * por el jugador y muestra en pantalla el número 
     * @param num
     */
    public void introducirNumeroEnCasilla(int num) {
        String texto;
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (matrizDeLabels[i][j].isOpaque()) {
                    texto=matrizDeLabels[i][j].getText();
                    bd.annadirAccionEscribir(i, j, texto);
                    matrizDeLabels[i][j].setText(Integer.toString(num));
                    this.repaint();
                }
            }
        }
    }
    
    /**
     * Función que reproduce la música al final de una partida exitosa
     */
    public void playMusic(){
        try{
            File path= new File("src/Interfaz/aplausos.wav");
            if (path.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                JOptionPane.showMessageDialog(null, "FELICIDADES, JUEGO COMPLETADO"); 
            }else{
                System.out.println("Can't find file");
            }
        }catch(HeadlessException | IOException | LineUnavailableException | UnsupportedAudioFileException e){
            System.out.println("Rayos");
        }
    }
    
    /**
     * Elimina un número de la casilla seleccionada, la deja en blanco
     */
    public void borrarNumero(){
        String texto=" ";
        for (int i=0;i<5;i++) {
            for (int j=0;j<5;j++) {
                if (matrizDeLabels[i][j].isOpaque()) {
                    texto=matrizDeLabels[i][j].getText();
                    bd.annadirAccionBorrar(i, j, texto);
                    matrizDeLabels[i][j].setText("");
                }
            }
        }
        this.repaint();
    }
    
    /**
     *  Verifica si el jugador colocó todos los números correctamente en el Ken Ken
     * @param matriz
     * @return boolean true || false
     */
    public static boolean todosTrue(boolean[][] matriz) {
        for (boolean[] fila : matriz) {
            for (boolean valor : fila) {
                if (!valor) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Define el color que tendrá cada casilla del KenKen al momento de ser 
     * seleccionada por el usuario
     */
    public void definirColorLabels() {
        for (JLabel[] filaLabel : matrizDeLabels) {
            for (JLabel label : filaLabel) {
                label.setBackground(new Color(61,214,217,45));
            }
        }
        this.repaint();
    }
    
    /**
     * Deselecciona una casilla del KenKen
     */
    public void desOpacarLabels(){
        for (JLabel[] filaLabel : matrizDeLabels) {
            for (JLabel label : filaLabel) {
                if (label.isOpaque()) {
                    label.setOpaque(false);
                }
            }
        }
        this.repaint();
    }
    
    /**
     * Vacía todos los valores que hayan en las casillas del juego
     */
    public void quitarTextoLabels(){
        for (JLabel[] filaLabel : matrizDeLabels) {
            for (JLabel label : filaLabel) {
                label.setText("");
            }
        }
        this.repaint();
    }
    
    /**
     *  Revisa que una de las casillas este seleccionada
     * @return true || false
     */
    public boolean hayCasillaSeleccionada(){
        for (JLabel[] filaLabel : matrizDeLabels) {
            for (JLabel label : filaLabel) {
                if (label.isOpaque()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     *  verifica que el juego se haya iniciado y que se haya seleccionado una 
     * casilla 
     * @return true || false
     */
    public boolean validarCondiciones(){
        if(!iniciado){
            JOptionPane.showMessageDialog(null, """
                                                El juego no ha sido iniciado, 
                                                no puede colocar ningún número""");
            return false;
        }else if(!hayCasillaSeleccionada()){
            JOptionPane.showMessageDialog(null, """
                                                No hay ninguna casilla seleccionada, 
                                                no puede colocar ningún número""");
            return false;
        }else{
            return true;
        }
    }
    
    /**
     *  Evalúa que el Ken Ken contenga los valores correctos en las posiciones correctas
     * @param solucion
     */
    public void validarKenKen(boolean[][] solucion){
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if(solucion[i][j]){
                    matrizDeLabels[i][j].setBackground(new Color(153,255,51, 45));
                }else{
                    matrizDeLabels[i][j].setBackground(new Color(255,51,51, 45));
                }
                matrizDeLabels[i][j].setOpaque(true);
            }
        }
        this.repaint();
    }
    
    /**
     *  Guarda el tiempo y nombre de la persona para mostrarlo en el podio
     */
    public void guardarMarca(){
        if(bd.getConfiguracion().getReloj()==2 && !expirado){
            List<Integer>tiempoTrans=Funciones.extraerTiempoTranscurrido(bd.getConfiguracion().getTimer().getHora(), 
                    bd.getConfiguracion().getTimer().getMinuto(),
                    bd.getConfiguracion().getTimer().getSegundo(),
                    horas, minutos, segundos);
            
            
            bd.annadirMarcaAlPodio(bd.getNombre(), 
                tiempoTrans.get(0),tiempoTrans.get(1),tiempoTrans.get(2),
                    bd.getConfiguracion().getTamanno(), 
                    bd.getConfiguracion().getDificultad());
        }else if(bd.getConfiguracion().getReloj()==1 || (bd.getConfiguracion().getReloj()==2 && expirado)){
            bd.annadirMarcaAlPodio(bd.getNombre(), horas, minutos, segundos,
                bd.getConfiguracion().getTamanno(), 
                bd.getConfiguracion().getDificultad());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_5_5 = new javax.swing.JLabel();
        jLabel_5_4 = new javax.swing.JLabel();
        jLabel_5_3 = new javax.swing.JLabel();
        jLabel_5_2 = new javax.swing.JLabel();
        jLabel_5_1 = new javax.swing.JLabel();
        jLabel_4_5 = new javax.swing.JLabel();
        jLabel_4_4 = new javax.swing.JLabel();
        jLabel_4_3 = new javax.swing.JLabel();
        jLabel_4_2 = new javax.swing.JLabel();
        jLabel_4_1 = new javax.swing.JLabel();
        jLabel_3_5 = new javax.swing.JLabel();
        jLabel_3_4 = new javax.swing.JLabel();
        jLabel_3_3 = new javax.swing.JLabel();
        jLabel_3_2 = new javax.swing.JLabel();
        jLabel_3_1 = new javax.swing.JLabel();
        jLabel_2_5 = new javax.swing.JLabel();
        jLabel_2_4 = new javax.swing.JLabel();
        jLabel_2_3 = new javax.swing.JLabel();
        jLabel_2_2 = new javax.swing.JLabel();
        jLabel_2_1 = new javax.swing.JLabel();
        jLabel_1_5 = new javax.swing.JLabel();
        jLabel_1_4 = new javax.swing.JLabel();
        jLabel_1_3 = new javax.swing.JLabel();
        jLabel_1_2 = new javax.swing.JLabel();
        jLabel_1_1 = new javax.swing.JLabel();
        jLabelKenKen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButtonBorrador = new javax.swing.JButton();
        jButtonIniciarJuego = new javax.swing.JButton();
        jButtonOtroJuego = new javax.swing.JButton();
        jButtonTerminarJuego = new javax.swing.JButton();
        jButtonValidarJuego = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();
        jButtonReiniciarJuego = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabelTiempo = new javax.swing.JLabel();
        jButtonPodio = new javax.swing.JButton();
        jButtonReaunudar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_5_5.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_5_5.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_5_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_5_5.setToolTipText("");
        jLabel_5_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_5_5.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_5_5.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_5_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_5_5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 547, 130, 140));

        jLabel_5_4.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_5_4.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_5_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_5_4.setToolTipText("");
        jLabel_5_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_5_4.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_5_4.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_5_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_5_4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 547, 127, 136));

        jLabel_5_3.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_5_3.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_5_3.setToolTipText("");
        jLabel_5_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_5_3.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_5_3.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_5_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_5_3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 548, 123, 134));

        jLabel_5_2.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_5_2.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_5_2.setToolTipText("");
        jLabel_5_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_5_2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_5_2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_5_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_5_2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 547, 130, 136));

        jLabel_5_1.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_5_1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_5_1.setToolTipText("");
        jLabel_5_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_5_1.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_5_1.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_5_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_5_1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 548, 130, 130));

        jLabel_4_5.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_4_5.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_4_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_4_5.setToolTipText("");
        jLabel_4_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_4_5.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_4_5.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_4_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_4_5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 413, 127, 134));

        jLabel_4_4.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_4_4.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_4_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_4_4.setToolTipText("");
        jLabel_4_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_4_4.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_4_4.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_4_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_4_4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 414, 125, 133));

        jLabel_4_3.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_4_3.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_4_3.setToolTipText("");
        jLabel_4_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_4_3.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_4_3.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_4_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_4_3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 414, 123, 133));

        jLabel_4_2.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_4_2.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_4_2.setToolTipText("");
        jLabel_4_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_4_2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_4_2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_4_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_4_2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 414, 130, 132));

        jLabel_4_1.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_4_1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_4_1.setToolTipText("");
        jLabel_4_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_4_1.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_4_1.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_4_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_4_1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 413, 130, 133));

        jLabel_3_5.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_3_5.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_3_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3_5.setToolTipText("");
        jLabel_3_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_3_5.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_3_5.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_3_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_3_5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 279, 130, 134));

        jLabel_3_4.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_3_4.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_3_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3_4.setToolTipText("");
        jLabel_3_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_3_4.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_3_4.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_3_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_3_4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 279, 125, 134));

        jLabel_3_3.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_3_3.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3_3.setToolTipText("");
        jLabel_3_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_3_3.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_3_3.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_3_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_3_3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 279, 124, 133));

        jLabel_3_2.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_3_2.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3_2.setToolTipText("");
        jLabel_3_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_3_2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_3_2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_3_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_3_2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 130, 133));

        jLabel_3_1.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_3_1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3_1.setToolTipText("");
        jLabel_3_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_3_1.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_3_1.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_3_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_3_1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 130, 133));

        jLabel_2_5.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_2_5.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_2_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2_5.setToolTipText("");
        jLabel_2_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_2_5.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_2_5.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_2_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_2_5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 144, 128, 134));

        jLabel_2_4.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_2_4.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_2_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2_4.setToolTipText("");
        jLabel_2_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_2_4.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_2_4.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_2_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_2_4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 144, 126, 134));

        jLabel_2_3.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_2_3.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_2_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2_3.setToolTipText("");
        jLabel_2_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_2_3.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_2_3.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_2_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_2_3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 145, 123, 133));

        jLabel_2_2.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_2_2.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_2_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2_2.setToolTipText("");
        jLabel_2_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_2_2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_2_2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_2_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_2_2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 144, 130, 135));

        jLabel_2_1.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_2_1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_2_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2_1.setToolTipText("");
        jLabel_2_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_2_1.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_2_1.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_2_1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 145, 127, 132));

        jLabel_1_5.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_1_5.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_1_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1_5.setToolTipText("");
        jLabel_1_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_1_5.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_1_5.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_1_5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_1_5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 130, 134));

        jLabel_1_4.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_1_4.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_1_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1_4.setToolTipText("");
        jLabel_1_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_1_4.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_1_4.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_1_4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_1_4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 10, 127, 134));

        jLabel_1_3.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_1_3.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_1_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1_3.setToolTipText("");
        jLabel_1_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_1_3.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_1_3.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_1_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_1_3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 123, 134));

        jLabel_1_2.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_1_2.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_1_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1_2.setToolTipText("");
        jLabel_1_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_1_2.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_1_2.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_1_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_1_2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 130, 134));

        jLabel_1_1.setBackground(new java.awt.Color(209, 232, 239));
        jLabel_1_1.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabel_1_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1_1.setToolTipText("");
        jLabel_1_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel_1_1.setMaximumSize(new java.awt.Dimension(36, 16));
        jLabel_1_1.setMinimumSize(new java.awt.Dimension(36, 16));
        jLabel_1_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_1_1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 134));

        jLabelKenKen.setBackground(new java.awt.Color(190, 211, 179));
        jLabelKenKen.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabelKenKen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/5x5E-1_in.png"))); // NOI18N
        jLabelKenKen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelKenKen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 690));

        jPanel3.setBackground(new java.awt.Color(94, 144, 66));

        jPanel4.setBackground(new java.awt.Color(227, 239, 221));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/1.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/2.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/3.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/5.png"))); // NOI18N
        jButton5.setBorder(null);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/4.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setPreferredSize(new java.awt.Dimension(40, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonBorrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/eraser.png"))); // NOI18N
        jButtonBorrador.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 6, true));
        jButtonBorrador.setContentAreaFilled(false);
        jButtonBorrador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonBorrador.setPreferredSize(new java.awt.Dimension(40, 40));
        jButtonBorrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorradorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        jButtonIniciarJuego.setBackground(new java.awt.Color(190, 211, 179));
        jButtonIniciarJuego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonIniciarJuego.setForeground(new java.awt.Color(53, 65, 42));
        jButtonIniciarJuego.setText("Iniciar Juego");
        jButtonIniciarJuego.setBorder(null);
        jButtonIniciarJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarJuegoActionPerformed(evt);
            }
        });

        jButtonOtroJuego.setBackground(new java.awt.Color(190, 211, 179));
        jButtonOtroJuego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonOtroJuego.setForeground(new java.awt.Color(53, 65, 42));
        jButtonOtroJuego.setText("Otro Juego");
        jButtonOtroJuego.setBorder(null);
        jButtonOtroJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonOtroJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOtroJuegoActionPerformed(evt);
            }
        });

        jButtonTerminarJuego.setBackground(new java.awt.Color(190, 211, 179));
        jButtonTerminarJuego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonTerminarJuego.setForeground(new java.awt.Color(53, 65, 42));
        jButtonTerminarJuego.setText("Terminar Juego");
        jButtonTerminarJuego.setBorder(null);
        jButtonTerminarJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarJuegoActionPerformed(evt);
            }
        });

        jButtonValidarJuego.setBackground(new java.awt.Color(190, 211, 179));
        jButtonValidarJuego.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonValidarJuego.setForeground(new java.awt.Color(53, 65, 42));
        jButtonValidarJuego.setText("Validar Juego");
        jButtonValidarJuego.setBorder(null);
        jButtonValidarJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonValidarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValidarJuegoActionPerformed(evt);
            }
        });

        jButtonUndo.setBackground(new java.awt.Color(190, 211, 179));
        jButtonUndo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonUndo.setForeground(new java.awt.Color(53, 65, 42));
        jButtonUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/undo.png"))); // NOI18N
        jButtonUndo.setBorder(null);
        jButtonUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });

        jButtonRedo.setBackground(new java.awt.Color(190, 211, 179));
        jButtonRedo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonRedo.setForeground(new java.awt.Color(53, 65, 42));
        jButtonRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/redo.png"))); // NOI18N
        jButtonRedo.setBorder(null);
        jButtonRedo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });

        jButtonReiniciarJuego.setBackground(new java.awt.Color(190, 211, 179));
        jButtonReiniciarJuego.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonReiniciarJuego.setForeground(new java.awt.Color(53, 65, 42));
        jButtonReiniciarJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesBotones/restart.png"))); // NOI18N
        jButtonReiniciarJuego.setBorder(null);
        jButtonReiniciarJuego.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonReiniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarJuegoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(227, 239, 221));

        jLabelTiempo.setFont(new java.awt.Font("Lucida Sans Unicode", 1, 42)); // NOI18N
        jLabelTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTiempo.setText("00 : 00 : 00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButtonPodio.setBackground(new java.awt.Color(190, 211, 179));
        jButtonPodio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonPodio.setForeground(new java.awt.Color(53, 65, 42));
        jButtonPodio.setText("Podio");
        jButtonPodio.setBorder(null);
        jButtonPodio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonPodio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPodioActionPerformed(evt);
            }
        });

        jButtonReaunudar.setBackground(new java.awt.Color(190, 211, 179));
        jButtonReaunudar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonReaunudar.setForeground(new java.awt.Color(53, 65, 42));
        jButtonReaunudar.setText("Reanudar");
        jButtonReaunudar.setBorder(null);
        jButtonReaunudar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonReaunudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReaunudarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonTerminarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jButtonIniciarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonValidarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonOtroJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonReaunudar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPodio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRedo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValidarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonOtroJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPodio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReaunudar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 370, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     /**
      * Boton que se encarga de reiniciar el KenKen actual
      * @param evt 
      */
    private void jButtonReiniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarJuegoActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(null,
        "Está seguro que desea reiniciar este juego?",
        "Confirmación", JOptionPane.YES_NO_OPTION);
        if(dialogButton==JOptionPane.YES_OPTION){
            desOpacarLabels();
            quitarTextoLabels();
            definirColorLabels();
            bd.limpiarPilas();
            if(bd.getConfiguracion().getReloj()==1){
                reiniciarCronometro();
                cronometro.start();
            }else if (bd.getConfiguracion().getReloj()==2){
                timer.stop();
                horas=bd.getConfiguracion().getTimer().getHora();
                minutos=bd.getConfiguracion().getTimer().getMinuto();
                segundos=bd.getConfiguracion().getTimer().getSegundo();
                milisegundos=bd.getConfiguracion().getTimer().getMilisegundo();
                timer.start();
            } 
        }else{
            System.out.println("Holi");
        }
    }//GEN-LAST:event_jButtonReiniciarJuegoActionPerformed
    
    /**
     * Introduce el número indicado por el botón en la casilla seleccionada
     * @param evt 
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (validarCondiciones()){
            introducirNumeroEnCasilla(4);
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    
    /**
     * Termina el juego y regresa al menú principal
     * @param evt 
     */
    private void jButtonTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarJuegoActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(null,
        "Está seguro que desea terminar este juego?",
        "Confirmación", JOptionPane.YES_NO_OPTION);
        if(dialogButton==JOptionPane.YES_OPTION){
            MenuPrincipal inicio = new MenuPrincipal();
            inicio.setVisible(true);
            this.dispose(); 
        }
    }//GEN-LAST:event_jButtonTerminarJuegoActionPerformed
    
    /**
     * Al hacer click sobre la casilla la señala con un color distinto
     * Esto aplica para todas las funciones que se presentan debajo de esta
     * Hasta que se señale lo contrario
     * @param evt 
     */
    private void jLabel_1_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_1_1MouseClicked
        desOpacarLabels();
        jLabel_1_1.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_1_1MouseClicked

    private void jLabel_1_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_1_2MouseClicked
        desOpacarLabels();
        jLabel_1_2.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_1_2MouseClicked

    private void jLabel_1_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_1_3MouseClicked
        desOpacarLabels();
        jLabel_1_3.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_1_3MouseClicked

    private void jLabel_1_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_1_4MouseClicked
        desOpacarLabels();
        jLabel_1_4.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_1_4MouseClicked

    private void jLabel_1_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_1_5MouseClicked
        desOpacarLabels();
        jLabel_1_5.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_1_5MouseClicked

    private void jLabel_2_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_2_1MouseClicked
        desOpacarLabels();
        jLabel_2_1.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_2_1MouseClicked

    private void jLabel_2_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_2_2MouseClicked
        desOpacarLabels();
        jLabel_2_2.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_2_2MouseClicked

    private void jLabel_2_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_2_3MouseClicked
        desOpacarLabels();
        jLabel_2_3.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_2_3MouseClicked

    private void jLabel_2_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_2_4MouseClicked
        desOpacarLabels();
        jLabel_2_4.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_2_4MouseClicked

    private void jLabel_2_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_2_5MouseClicked
        desOpacarLabels();
        jLabel_2_5.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_2_5MouseClicked

    private void jLabel_3_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_3_1MouseClicked
        desOpacarLabels();
        jLabel_3_1.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_3_1MouseClicked

    private void jLabel_3_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_3_2MouseClicked
        desOpacarLabels();
        jLabel_3_2.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_3_2MouseClicked

    private void jLabel_3_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_3_3MouseClicked
        desOpacarLabels();
        jLabel_3_3.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_3_3MouseClicked

    private void jLabel_3_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_3_4MouseClicked
        desOpacarLabels();
        jLabel_3_4.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_3_4MouseClicked

    private void jLabel_3_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_3_5MouseClicked
        desOpacarLabels();
        jLabel_3_5.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_3_5MouseClicked

    private void jLabel_4_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_4_1MouseClicked
        desOpacarLabels();
        jLabel_4_1.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_4_1MouseClicked

    private void jLabel_4_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_4_2MouseClicked
        desOpacarLabels();
        jLabel_4_2.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_4_2MouseClicked

    private void jLabel_4_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_4_3MouseClicked
        desOpacarLabels();
        jLabel_4_3.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_4_3MouseClicked

    private void jLabel_4_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_4_4MouseClicked
        desOpacarLabels();
        jLabel_4_4.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_4_4MouseClicked

    private void jLabel_4_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_4_5MouseClicked
        desOpacarLabels();
        jLabel_4_5.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_4_5MouseClicked

    private void jLabel_5_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_5_1MouseClicked
        desOpacarLabels();
        jLabel_5_1.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_5_1MouseClicked

    private void jLabel_5_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_5_2MouseClicked
        desOpacarLabels();
        jLabel_5_2.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_5_2MouseClicked

    private void jLabel_5_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_5_3MouseClicked
        desOpacarLabels();
        jLabel_5_3.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_5_3MouseClicked

    private void jLabel_5_4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_5_4MouseClicked
        desOpacarLabels();
        jLabel_5_4.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_5_4MouseClicked

    private void jLabel_5_5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_5_5MouseClicked
        desOpacarLabels();
        jLabel_5_5.setOpaque(true);
        this.repaint();
    }//GEN-LAST:event_jLabel_5_5MouseClicked
    
    /**
     * Inicia el juego, habilitando todas las opciones
     * @param evt 
     */
    private void jButtonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarJuegoActionPerformed
        if(bd.getConfiguracion().getReloj()==1){
            cronometro.start();
        }else if(bd.getConfiguracion().getReloj()==2){
            timer.start();
        }
        iniciado=true;
        jButtonValidarJuego.setEnabled(true);
        jButtonTerminarJuego.setEnabled(true);
        jButtonReiniciarJuego.setEnabled(true);
        jButtonOtroJuego.setEnabled(true);
        jButtonPodio.setEnabled(true);
        jButtonIniciarJuego.setEnabled(false);
    }//GEN-LAST:event_jButtonIniciarJuegoActionPerformed
    
    /**
     * Introduce el número indicado por el botón en la casilla correspondiente
     * Esta descripción aplica para las funciones colocadas posteriores a esta
     * hasta que se indique lo contrario
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (validarCondiciones()){
            introducirNumeroEnCasilla(1);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (validarCondiciones()){
            introducirNumeroEnCasilla(2);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (validarCondiciones()){
            introducirNumeroEnCasilla(3);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (validarCondiciones()){
            introducirNumeroEnCasilla(5);
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    
    /**
     * Borra el contenido de la casilla seleccionada por el jugador
     * @param evt 
     */
    private void jButtonBorradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorradorActionPerformed
        borrarNumero();
    }//GEN-LAST:event_jButtonBorradorActionPerformed
    
    /**
     * Inicia un KenKen nuevo, hay posibilidades de que salga el mismo, al ser la probabilidad
     * completamente aleatoria
     * @param evt 
     */
    private void jButtonOtroJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOtroJuegoActionPerformed
        int dialogButton = JOptionPane.showConfirmDialog(null,
        "Está seguro que desea comenzar otro juego?",
        "Confirmación", JOptionPane.YES_NO_OPTION);
        if(dialogButton==JOptionPane.YES_OPTION){
            Jugar5x5 nuevoJuego=new Jugar5x5();
            nuevoJuego.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonOtroJuegoActionPerformed
    
    /**
     * Evalua si el juego completado (o no) por el jugador tiene las respuestas correctas
     * @param evt 
     */
    private void jButtonValidarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValidarJuegoActionPerformed
        boolean[][] solucion;
        solucion=bd.buscarKenKen(kenken).validarSolucion5x5(matrizDeLabels);
        validarKenKen(solucion);
        if(bd.getConfiguracion().getReloj()==1){
            cronometro.stop();
        }else if(bd.getConfiguracion().getReloj()==2){
            timer.stop();
        }
        if(todosTrue(solucion)){
            if(bd.getConfiguracion().isSonido()){
                playMusic();
            }else{
                JOptionPane.showMessageDialog(null, "FELICIDADES, JUEGO COMPLETADO"); 
            }
            guardarMarca();
        }else{
            int dialogResult = JOptionPane.showConfirmDialog(this, 
            "HAY ERRORES EN EL JUEGO! Desea corregirlos?", 
            "Confirmación", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                iniciado=true;
                desOpacarLabels();
                definirColorLabels();
                if(bd.getConfiguracion().getReloj()==1){
                    cronometro.start();
                }else if(bd.getConfiguracion().getReloj()==2){
                    timer.start();
                }
            }else{
                iniciado=false;
            }
        }
    }//GEN-LAST:event_jButtonValidarJuegoActionPerformed
    
    /**
     * Deshace una acción llevada a cabo por el jugador
     * @param evt 
     */
    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
        Accion accionDeshecha=bd.mostrarUltimaAccionHecha();
        if (accionDeshecha!=null){
            String dato=matrizDeLabels[accionDeshecha.getFila()][accionDeshecha.getColumna()].getText();
            Accion accionExtraNoTanExtra=new Accion(accionDeshecha.getFila(),accionDeshecha.getColumna(),dato);
            Accion accion=bd.deshacerAccion(accionExtraNoTanExtra);
            if (accion!=null){
                matrizDeLabels[accion.getFila()][accion.getColumna()].setText(accion.getDato());
                this.repaint();
            }
        }
    }//GEN-LAST:event_jButtonUndoActionPerformed
    
    /**
     * Rehace una acción llevada a cabo por el jugador
     * @param evt 
     */
    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
        Accion accionHecha=bd.mostrarUltimaAccionDeshecha();
        if(accionHecha!=null){
            String dato=matrizDeLabels[accionHecha.getFila()][accionHecha.getColumna()].getText();
            Accion accionExtraNoTanExtra=new Accion(accionHecha.getFila(),accionHecha.getColumna(),dato);
            Accion accion=bd.rehacerAccion(accionExtraNoTanExtra); //No sé porque pero no hace nah
            if (accion!=null){
                matrizDeLabels[accion.getFila()][accion.getColumna()].setText(accion.getDato());
                this.repaint();
            }
        }
    }//GEN-LAST:event_jButtonRedoActionPerformed

    private void jButtonPodioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPodioActionPerformed
        if(bd.getConfiguracion().getReloj()==1){
            cronometro.stop();
        }else if(bd.getConfiguracion().getReloj()==2){
            timer.stop();
        }
        iniciado=false;
        jButtonValidarJuego.setEnabled(false);
        jButtonTerminarJuego.setEnabled(false);
        jButtonOtroJuego.setEnabled(false);
        jButtonReaunudar.setEnabled(true);
        Podio podio= new Podio();
        podio.setVisible(true);
    }//GEN-LAST:event_jButtonPodioActionPerformed

    private void jButtonReaunudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReaunudarActionPerformed
        jButtonValidarJuego.setEnabled(true);
        jButtonTerminarJuego.setEnabled(true);
        jButtonOtroJuego.setEnabled(true);
        jButtonReaunudar.setEnabled(false);
        iniciado=true;
        if(bd.getConfiguracion().getReloj()==1){
            cronometro.start();
        }else if(bd.getConfiguracion().getReloj()==2){
            timer.start();
        }
    }//GEN-LAST:event_jButtonReaunudarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jugar5x5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jugar5x5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jugar5x5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jugar5x5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jugar5x5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonBorrador;
    private javax.swing.JButton jButtonIniciarJuego;
    private javax.swing.JButton jButtonOtroJuego;
    private javax.swing.JButton jButtonPodio;
    private javax.swing.JButton jButtonReaunudar;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonReiniciarJuego;
    private javax.swing.JButton jButtonTerminarJuego;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JButton jButtonValidarJuego;
    private javax.swing.JLabel jLabelKenKen;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabel_1_1;
    private javax.swing.JLabel jLabel_1_2;
    private javax.swing.JLabel jLabel_1_3;
    private javax.swing.JLabel jLabel_1_4;
    private javax.swing.JLabel jLabel_1_5;
    private javax.swing.JLabel jLabel_2_1;
    private javax.swing.JLabel jLabel_2_2;
    private javax.swing.JLabel jLabel_2_3;
    private javax.swing.JLabel jLabel_2_4;
    private javax.swing.JLabel jLabel_2_5;
    private javax.swing.JLabel jLabel_3_1;
    private javax.swing.JLabel jLabel_3_2;
    private javax.swing.JLabel jLabel_3_3;
    private javax.swing.JLabel jLabel_3_4;
    private javax.swing.JLabel jLabel_3_5;
    private javax.swing.JLabel jLabel_4_1;
    private javax.swing.JLabel jLabel_4_2;
    private javax.swing.JLabel jLabel_4_3;
    private javax.swing.JLabel jLabel_4_4;
    private javax.swing.JLabel jLabel_4_5;
    private javax.swing.JLabel jLabel_5_1;
    private javax.swing.JLabel jLabel_5_2;
    private javax.swing.JLabel jLabel_5_3;
    private javax.swing.JLabel jLabel_5_4;
    private javax.swing.JLabel jLabel_5_5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

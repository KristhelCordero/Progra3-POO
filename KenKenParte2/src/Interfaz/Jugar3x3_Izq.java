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
import java.io.File;
import java.io.IOException;
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
public class Jugar3x3_Izq extends javax.swing.JFrame {
    private JLabel[][] matrizDeLabels;
    private boolean iniciado, finalizadoTimer;
    private final String kenken=bd.extraerKenKenActual3x3();
    private Timer cronometro, timer;
    private int horas=bd.getConfiguracion().getTimer().getHora();
    private int minutos=bd.getConfiguracion().getTimer().getMinuto();
    private int segundos=bd.getConfiguracion().getTimer().getSegundo();
    private int milisegundos=bd.getConfiguracion().getTimer().getMilisegundo();
    private boolean expirado;
    /**
     * Crea un nuevo JFrame llamado Jugar, con los botoens debidamente apagados y las 
     * especificaciones acordes a la configuración del usuario
     */
    public Jugar3x3_Izq() {
        initComponents();
        jButtonValidarJuego.setEnabled(false);
        jButtonTerminarJuego.setEnabled(false);
        jButtonReiniciarJuego.setEnabled(false);
        jButtonOtroJuego.setEnabled(false);
        jButtonReaunudar.setEnabled(false);
        jButtonPodio.setEnabled(false);
        matrizDeLabels= new JLabel[3][3];
        this.crearMatrizLabels();
        this.definirColorLabels();
        this.setLocationRelativeTo(this);
        iniciado=finalizadoTimer=expirado=false;
        setImageLabel(kenken);
        //bd.getConfiguracion().setReloj(2);
        switch (bd.getConfiguracion().getReloj()) {
            case 3 -> jLabelTiempo.setText(null);
            default -> {
                cronometro=new Timer(10, (ActionEvent e) -> {
                    iniciarCronometro();
                }); 
                timer=new Timer(10, (ActionEvent e) -> {
                    iniciarTimer();
                });
            }
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
            expirado=true;
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
        matrizDeLabels[1][0]=jLabel_2_1;
        matrizDeLabels[1][1]=jLabel_2_2;
        matrizDeLabels[1][2]=jLabel_2_3;
        matrizDeLabels[2][0]=jLabel_3_1;
        matrizDeLabels[2][1]=jLabel_3_2;
        matrizDeLabels[2][2]=jLabel_3_3;
    }
    
    /**
     *  Funcion: Introduce un número determinado en la casilla seleccionada 
     * por el jugador y muestra en pantalla el número 
     * @param num
     */
    public void introducirNumeroEnCasilla(int num) {
        String texto;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
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
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
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
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
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
     * Guarda el tiempo y nombre de la persona para mostrarlo en el podio
     */
    public void guardarMarca(){
        if(bd.getConfiguracion().getReloj()==2 && !expirado){
            bd.annadirMarcaAlPodio(bd.getNombre(), 
                (bd.getConfiguracion().getTimer().getHora()-horas), 
                (bd.getConfiguracion().getTimer().getMinuto()-minutos), 
                (bd.getConfiguracion().getTimer().getSegundo()-segundos),
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
        jLabel_3_3 = new javax.swing.JLabel();
        jLabel_3_2 = new javax.swing.JLabel();
        jLabel_3_1 = new javax.swing.JLabel();
        jLabel_2_3 = new javax.swing.JLabel();
        jLabel_2_2 = new javax.swing.JLabel();
        jLabel_2_1 = new javax.swing.JLabel();
        jLabel_1_3 = new javax.swing.JLabel();
        jLabel_1_2 = new javax.swing.JLabel();
        jLabel_1_1 = new javax.swing.JLabel();
        jLabelKenKen = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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
        jPanel1.add(jLabel_3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 460, 210, 220));

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
        jPanel1.add(jLabel_3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 210, 220));

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
        jPanel1.add(jLabel_3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 460, 210, 220));

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
        jPanel1.add(jLabel_2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, 210, 220));

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
        jPanel1.add(jLabel_2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 210, 220));

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
        jPanel1.add(jLabel_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 210, 220));

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
        jPanel1.add(jLabel_1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 210, 220));

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
        jPanel1.add(jLabel_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 210, 220));

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
        jPanel1.add(jLabel_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 206, 220));

        jLabelKenKen.setBackground(new java.awt.Color(190, 211, 179));
        jLabelKenKen.setFont(new java.awt.Font("Gadugi", 1, 36)); // NOI18N
        jLabelKenKen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3x3E-1_in.png"))); // NOI18N
        jLabelKenKen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelKenKen, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 770, 690));

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
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButtonBorrador, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButtonReaunudar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPodio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jButtonOtroJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonUndo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRedo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonReiniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
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
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 690));

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
            Jugar3x3_Izq nuevoJuego=new Jugar3x3_Izq();
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
        solucion=bd.buscarKenKen(kenken).validarSolucion(matrizDeLabels, 3);
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
            java.util.logging.Logger.getLogger(Jugar3x3_Izq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jugar3x3_Izq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jugar3x3_Izq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jugar3x3_Izq.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jugar3x3_Izq().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel_2_1;
    private javax.swing.JLabel jLabel_2_2;
    private javax.swing.JLabel jLabel_2_3;
    private javax.swing.JLabel jLabel_3_1;
    private javax.swing.JLabel jLabel_3_2;
    private javax.swing.JLabel jLabel_3_3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

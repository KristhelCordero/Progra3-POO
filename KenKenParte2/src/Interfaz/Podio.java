
package Interfaz;

import static Interfaz.MenuPrincipal.bd;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author krisc
 */
public class Podio extends javax.swing.JFrame {
    private JLabel[][] matrizDeLabels3x3;
    private JLabel[][] matrizDeLabels4x4;
    private JLabel[][] matrizDeLabels5x5;
    private JLabel[][] matrizDeLabels6x6;
    private JLabel[][] matrizDeLabels7x7;
    private JLabel[][] matrizDeLabels8x8;
    private JLabel[][] matrizDeLabels9x9; 
    private JLabel[][] matrizDeLabelsActual; 

    
    private List<Objetos.Marca> podio3x3Facil = bd.sacarMejoresMarcas(3,1);
    private List<Objetos.Marca> podio4x4Facil = bd.sacarMejoresMarcas(4,1);
    private List<Objetos.Marca> podio5x5Facil = bd.sacarMejoresMarcas(5,1);
    private List<Objetos.Marca> podio6x6Facil = bd.sacarMejoresMarcas(6,1);
    private List<Objetos.Marca> podio7x7Facil = bd.sacarMejoresMarcas(7,1);
    private List<Objetos.Marca> podio8x8Facil = bd.sacarMejoresMarcas(8,1);
    private List<Objetos.Marca> podio9x9Facil = bd.sacarMejoresMarcas(9,1);


    private List<Objetos.Marca> podio3x3Medio = bd.sacarMejoresMarcas(3,2);
    private List<Objetos.Marca> podio4x4Medio = bd.sacarMejoresMarcas(4,2);
    private List<Objetos.Marca> podio5x5Medio = bd.sacarMejoresMarcas(5,2);
    private List<Objetos.Marca> podio6x6Medio = bd.sacarMejoresMarcas(6,2);
    private List<Objetos.Marca> podio7x7Medio = bd.sacarMejoresMarcas(7,2);
    private List<Objetos.Marca> podio8x8Medio = bd.sacarMejoresMarcas(8,2);
    private List<Objetos.Marca> podio9x9Medio = bd.sacarMejoresMarcas(9,2);
    
    private List<Objetos.Marca> podio3x3Dificil = bd.sacarMejoresMarcas(3,3);
    private List<Objetos.Marca> podio4x4Dificil = bd.sacarMejoresMarcas(4,3);
    private List<Objetos.Marca> podio5x5Dificil = bd.sacarMejoresMarcas(5,3);
    private List<Objetos.Marca> podio6x6Dificil = bd.sacarMejoresMarcas(6,3);
    private List<Objetos.Marca> podio7x7Dificil = bd.sacarMejoresMarcas(7,3);
    private List<Objetos.Marca> podio8x8Dificil = bd.sacarMejoresMarcas(8,3);
    private List<Objetos.Marca> podio9x9Dificil = bd.sacarMejoresMarcas(9,3);
    
    
    //lista de listas 
    //recomendado recorrer con doble for
    private List<List<Objetos.Marca>> todasLasMarcas = new ArrayList<>(
        Arrays.asList(
          podio3x3Facil, podio3x3Medio, podio3x3Dificil, //[0] [1] [2]
          podio4x4Facil, podio4x4Medio, podio4x4Dificil, //[3] [4] [5]
          podio5x5Facil, podio5x5Medio, podio5x5Dificil, //[6] [7] [8]
          podio6x6Facil, podio6x6Medio, podio6x6Dificil, //[9] [10] [11]
          podio7x7Facil, podio7x7Medio, podio7x7Dificil, //[12] [13] [14]
          podio8x8Facil, podio8x8Medio, podio8x8Dificil, //[15] [16] [17]
          podio9x9Facil, podio9x9Medio, podio9x9Dificil  //[18] [19] [20]
        )
    );
    /**
     * Creates new form Podio
     */
    public Podio() {
        initComponents();
        matrizDeLabels3x3= new JLabel[3][3];
        matrizDeLabels4x4= new JLabel[3][3];
        matrizDeLabels5x5= new JLabel[3][3];
        matrizDeLabels6x6= new JLabel[3][3];
        matrizDeLabels7x7= new JLabel[3][3];
        matrizDeLabels8x8= new JLabel[3][3];
        matrizDeLabels9x9= new JLabel[3][3];
        
        matrizDeLabelsActual= new JLabel[2][3];

        this.crearMatrizLabels();
        this.setLocationRelativeTo(this);
        this.mostrarPodioCompleto();
    }

    public void crearMatrizLabels(){
        matrizDeLabels3x3[0][0]=jLabelFacil3x3_1;
        matrizDeLabels3x3[0][1]=jLabelFacil3x3_2;
        matrizDeLabels3x3[0][2]=jLabelFacil3x3_3;
        matrizDeLabels3x3[1][0]=jLabelMedio3x3_1;
        matrizDeLabels3x3[1][1]=jLabelMedio3x3_2;
        matrizDeLabels3x3[1][2]=jLabelMedio3x3_3;
        matrizDeLabels3x3[2][0]=jLabelDificil3x3_1;
        matrizDeLabels3x3[2][1]=jLabelDificil3x3_2;
        matrizDeLabels3x3[2][2]=jLabelDificil3x3_3;
        
        matrizDeLabels4x4[0][0]=jLabelFacil4x4_1;
        matrizDeLabels4x4[0][1]=jLabelFacil4x4_2;
        matrizDeLabels4x4[0][2]=jLabelFacil4x4_3;
        matrizDeLabels4x4[1][0]=jLabelMedio4x4_1;
        matrizDeLabels4x4[1][1]=jLabelMedio4x4_2;
        matrizDeLabels4x4[1][2]=jLabelMedio4x4_3;
        matrizDeLabels4x4[2][0]=jLabelDificil4x4_1;
        matrizDeLabels4x4[2][1]=jLabelDificil4x4_2;
        matrizDeLabels4x4[2][2]=jLabelDificil4x4_3;
        
        matrizDeLabels5x5[0][0]=jLabelFacil5x5_1;
        matrizDeLabels5x5[0][1]=jLabelFacil5x5_2;
        matrizDeLabels5x5[0][2]=jLabelFacil5x5_3;
        matrizDeLabels5x5[1][0]=jLabelMedio5x5_1;
        matrizDeLabels5x5[1][1]=jLabelMedio5x5_2;
        matrizDeLabels5x5[1][2]=jLabelMedio5x5_3;
        matrizDeLabels5x5[2][0]=jLabelDificil5x5_1;
        matrizDeLabels5x5[2][1]=jLabelDificil5x5_2;
        matrizDeLabels5x5[2][2]=jLabelDificil5x5_3;
        
        matrizDeLabels6x6[0][0] = jLabelFacil6x6_1;
        matrizDeLabels6x6[0][1] = jLabelFacil6x6_2;
        matrizDeLabels6x6[0][2] = jLabelFacil6x6_3;
        matrizDeLabels6x6[1][0] = jLabelMedio6x6_1;
        matrizDeLabels6x6[1][1] = jLabelMedio6x6_2;
        matrizDeLabels6x6[1][2] = jLabelMedio6x6_3;
        matrizDeLabels6x6[2][0] = jLabelDificil6x6_1;
        matrizDeLabels6x6[2][1] = jLabelDificil6x6_2;
        matrizDeLabels6x6[2][2] = jLabelDificil6x6_3;

        matrizDeLabels7x7[0][0] = jLabelFacil7x7_1;
        matrizDeLabels7x7[0][1] = jLabelFacil7x7_2;
        matrizDeLabels7x7[0][2] = jLabelFacil7x7_3;
        matrizDeLabels7x7[1][0] = jLabelMedio7x7_1;
        matrizDeLabels7x7[1][1] = jLabelMedio7x7_2;
        matrizDeLabels7x7[1][2] = jLabelMedio7x7_3;
        matrizDeLabels7x7[2][0] = jLabelDificil7x7_1;
        matrizDeLabels7x7[2][1] = jLabelDificil7x7_2;
        matrizDeLabels7x7[2][2] = jLabelDificil7x7_3;

        matrizDeLabels8x8[0][0] = jLabelFacil8x8_1;
        matrizDeLabels8x8[0][1] = jLabelFacil8x8_2;
        matrizDeLabels8x8[0][2] = jLabelFacil8x8_3;
        matrizDeLabels8x8[1][0] = jLabelMedio8x8_1;
        matrizDeLabels8x8[1][1] = jLabelMedio8x8_2;
        matrizDeLabels8x8[1][2] = jLabelMedio8x8_3;
        matrizDeLabels8x8[2][0] = jLabelDificil8x8_1;
        matrizDeLabels8x8[2][1] = jLabelDificil8x8_2;
        matrizDeLabels8x8[2][2] = jLabelDificil8x8_3;

        matrizDeLabels9x9[0][0] = jLabelFacil9x9_1;
        matrizDeLabels9x9[0][1] = jLabelFacil9x9_2;
        matrizDeLabels9x9[0][2] = jLabelFacil9x9_3;
        matrizDeLabels9x9[1][0] = jLabelMedio9x9_1;
        matrizDeLabels9x9[1][1] = jLabelMedio9x9_2;
        matrizDeLabels9x9[1][2] = jLabelMedio9x9_3;
        matrizDeLabels9x9[2][0] = jLabelDificil9x9_1;
        matrizDeLabels9x9[2][1] = jLabelDificil9x9_2;
        matrizDeLabels9x9[2][2] = jLabelDificil9x9_3;
        
        matrizDeLabelsActual[0][0]=jLabelTamanno;
        matrizDeLabelsActual[0][1]=jLabelDificultad;
        matrizDeLabelsActual[1][0]=jLabel_1;
        matrizDeLabelsActual[1][0]=jLabel_2;
        matrizDeLabelsActual[1][0]=jLabel_3;
    }
    
    public void mostrarMarcas3x3(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels3x3[i][j].setText(todasLasMarcas.get(i).get(j).toString());
            }
        }
        this.repaint();
    }
    
    public void mostrarMarcas4x4(){
        int m=3;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels4x4[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarMarcas5x5(){
        int m=6;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels5x5[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarMarcas6x6(){
        int m=9;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels6x6[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarMarcas7x7(){
        int m=12;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels7x7[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarMarcas8x8(){
        int m=15;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels8x8[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarMarcas9x9(){
        int m=18;
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                matrizDeLabels9x9[i][j].setText(todasLasMarcas.get(m).get(j).toString());
            }
            m++;
        }
        this.repaint();
    }
    
    public void mostrarPodioActual(){
        
        matrizDeLabelsActual[0][0].setText(bd.getConfiguracion().getTamanno()+"x"+bd.getConfiguracion().getTamanno());
        int m=1;
        switch(bd.getConfiguracion().getTamanno()){
            case 3 -> m=0;
            case 4 -> m=3;
            case 5 -> m=6;
            case 6 -> m=9;
            case 7 -> m=12;
            case 8 -> m=15;
            case 9 -> m=18;
        }
        switch(bd.getConfiguracion().getDificultad()){
            case 1 -> {
                matrizDeLabelsActual[0][1].setText("Fácil");
            }
            case 2 -> {
                matrizDeLabelsActual[0][1].setText("Medio");
                m++;
            }
            default -> {
                matrizDeLabelsActual[0][1].setText("Dificil");
                m+=2;
            }
        }
        for (int j=0; j<3; j++){
            matrizDeLabelsActual[1][j].setText(todasLasMarcas.get(m).get(j).toString());
        }
        this.repaint();
    }
    
    public void mostrarPodioCompleto(){
        mostrarPodioActual();
        mostrarMarcas3x3();
        mostrarMarcas4x4();
        mostrarMarcas5x5();
        mostrarMarcas6x6();
        mostrarMarcas7x7();
        mostrarMarcas8x8();
        mostrarMarcas9x9();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabelDificil3x3_2 = new javax.swing.JLabel();
        jLabelFacil3x3_1 = new javax.swing.JLabel();
        jLabelMedio3x3_2 = new javax.swing.JLabel();
        jLabelMedio3x3_3 = new javax.swing.JLabel();
        jLabelDificil3x3_3 = new javax.swing.JLabel();
        jLabelFacil3x3_2 = new javax.swing.JLabel();
        jLabelMedio3x3_1 = new javax.swing.JLabel();
        jLabelad2 = new javax.swing.JLabel();
        jLabelad3 = new javax.swing.JLabel();
        jLabelDificil3x3_1 = new javax.swing.JLabel();
        jLabelad = new javax.swing.JLabel();
        jLabelFacil3x3_3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelad4 = new javax.swing.JLabel();
        jLabelad5 = new javax.swing.JLabel();
        jLabelad1 = new javax.swing.JLabel();
        jLabelDificil4x4_1 = new javax.swing.JLabel();
        jLabelFacil4x4_1 = new javax.swing.JLabel();
        jLabelMedio4x4_1 = new javax.swing.JLabel();
        jLabelMedio4x4_2 = new javax.swing.JLabel();
        jLabelFacil4x4_3 = new javax.swing.JLabel();
        jLabelMedio4x4_3 = new javax.swing.JLabel();
        jLabelFacil4x4_2 = new javax.swing.JLabel();
        jLabelDificil4x4_2 = new javax.swing.JLabel();
        jLabelDificil4x4_3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelad6 = new javax.swing.JLabel();
        jLabelad7 = new javax.swing.JLabel();
        jLabelad8 = new javax.swing.JLabel();
        jLabelDificil5x5_1 = new javax.swing.JLabel();
        jLabelMedio5x5_1 = new javax.swing.JLabel();
        jLabelFacil5x5_1 = new javax.swing.JLabel();
        jLabelFacil5x5_2 = new javax.swing.JLabel();
        jLabelMedio5x5_2 = new javax.swing.JLabel();
        jLabelDificil5x5_2 = new javax.swing.JLabel();
        jLabelDificil5x5_3 = new javax.swing.JLabel();
        jLabelMedio5x5_3 = new javax.swing.JLabel();
        jLabelFacil5x5_3 = new javax.swing.JLabel();
        jLabelDificil6x6_3 = new javax.swing.JLabel();
        jLabelDificil6x6_2 = new javax.swing.JLabel();
        jLabelDificil6x6_1 = new javax.swing.JLabel();
        jLabelMedio6x6_1 = new javax.swing.JLabel();
        jLabelMedio6x6_2 = new javax.swing.JLabel();
        jLabelMedio6x6_3 = new javax.swing.JLabel();
        jLabelFacil6x6_3 = new javax.swing.JLabel();
        jLabelFacil6x6_2 = new javax.swing.JLabel();
        jLabelFacil6x6_1 = new javax.swing.JLabel();
        jLabelad9 = new javax.swing.JLabel();
        jLabelad10 = new javax.swing.JLabel();
        jLabelad11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDificil7x7_3 = new javax.swing.JLabel();
        jLabelDificil7x7_2 = new javax.swing.JLabel();
        jLabelDificil7x7_1 = new javax.swing.JLabel();
        jLabelMedio7x7_1 = new javax.swing.JLabel();
        jLabelMedio7x7_2 = new javax.swing.JLabel();
        jLabelMedio7x7_3 = new javax.swing.JLabel();
        jLabelFacil7x7_3 = new javax.swing.JLabel();
        jLabelFacil7x7_2 = new javax.swing.JLabel();
        jLabelFacil7x7_1 = new javax.swing.JLabel();
        jLabelad12 = new javax.swing.JLabel();
        jLabelad13 = new javax.swing.JLabel();
        jLabelad14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelDificil8x8_3 = new javax.swing.JLabel();
        jLabelDificil8x8_2 = new javax.swing.JLabel();
        jLabelDificil8x8_1 = new javax.swing.JLabel();
        jLabelMedio8x8_1 = new javax.swing.JLabel();
        jLabelMedio8x8_2 = new javax.swing.JLabel();
        jLabelMedio8x8_3 = new javax.swing.JLabel();
        jLabelFacil8x8_3 = new javax.swing.JLabel();
        jLabelFacil8x8_2 = new javax.swing.JLabel();
        jLabelFacil8x8_1 = new javax.swing.JLabel();
        jLabelad15 = new javax.swing.JLabel();
        jLabelad16 = new javax.swing.JLabel();
        jLabelad17 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelad18 = new javax.swing.JLabel();
        jLabelad19 = new javax.swing.JLabel();
        jLabelad20 = new javax.swing.JLabel();
        jLabelDificil9x9_1 = new javax.swing.JLabel();
        jLabelMedio9x9_1 = new javax.swing.JLabel();
        jLabelFacil9x9_1 = new javax.swing.JLabel();
        jLabelFacil9x9_2 = new javax.swing.JLabel();
        jLabelMedio9x9_2 = new javax.swing.JLabel();
        jLabelDificil9x9_2 = new javax.swing.JLabel();
        jLabelDificil9x9_3 = new javax.swing.JLabel();
        jLabelMedio9x9_3 = new javax.swing.JLabel();
        jLabelFacil9x9_3 = new javax.swing.JLabel();
        jLabelTamanno = new javax.swing.JLabel();
        jLabelDificultad = new javax.swing.JLabel();
        jLabel_1 = new javax.swing.JLabel();
        jLabel_2 = new javax.swing.JLabel();
        jLabel_3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(227, 239, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(65, 91, 63));

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 64)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PODIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(280, 280, 280))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 150));

        jPanel3.setBackground(new java.awt.Color(227, 239, 221));

        jLabelDificil3x3_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil3x3_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil3x3_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil3x3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil3x3_2.setOpaque(true);

        jLabelFacil3x3_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil3x3_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil3x3_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil3x3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil3x3_1.setOpaque(true);

        jLabelMedio3x3_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio3x3_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio3x3_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio3x3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio3x3_2.setOpaque(true);

        jLabelMedio3x3_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio3x3_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio3x3_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio3x3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio3x3_3.setOpaque(true);

        jLabelDificil3x3_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil3x3_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil3x3_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil3x3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil3x3_3.setOpaque(true);

        jLabelFacil3x3_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil3x3_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil3x3_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil3x3_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil3x3_2.setOpaque(true);

        jLabelMedio3x3_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio3x3_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio3x3_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio3x3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio3x3_1.setOpaque(true);

        jLabelad2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad2.setText("Medio");

        jLabelad3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad3.setText("Fácil");

        jLabelDificil3x3_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil3x3_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil3x3_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil3x3_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil3x3_1.setOpaque(true);

        jLabelad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad.setText("Difícil");

        jLabelFacil3x3_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil3x3_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil3x3_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil3x3_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil3x3_3.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 91, 63));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("3x3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 91, 63));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("4x4");

        jLabelad4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad4.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad4.setText("Fácil");

        jLabelad5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad5.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad5.setText("Medio");

        jLabelad1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad1.setText("Difícil");

        jLabelDificil4x4_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil4x4_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil4x4_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil4x4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil4x4_1.setOpaque(true);

        jLabelFacil4x4_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil4x4_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil4x4_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil4x4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil4x4_1.setOpaque(true);

        jLabelMedio4x4_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio4x4_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio4x4_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio4x4_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio4x4_1.setOpaque(true);

        jLabelMedio4x4_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio4x4_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio4x4_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio4x4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio4x4_2.setOpaque(true);

        jLabelFacil4x4_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil4x4_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil4x4_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil4x4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil4x4_3.setOpaque(true);

        jLabelMedio4x4_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio4x4_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio4x4_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio4x4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio4x4_3.setOpaque(true);

        jLabelFacil4x4_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil4x4_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil4x4_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil4x4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil4x4_2.setOpaque(true);

        jLabelDificil4x4_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil4x4_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil4x4_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil4x4_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil4x4_2.setOpaque(true);

        jLabelDificil4x4_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil4x4_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil4x4_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil4x4_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil4x4_3.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(65, 91, 63));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("5x5");

        jLabelad6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad6.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad6.setText("Fácil");

        jLabelad7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad7.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad7.setText("Medio");

        jLabelad8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad8.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad8.setText("Difícil");

        jLabelDificil5x5_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil5x5_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil5x5_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil5x5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil5x5_1.setOpaque(true);

        jLabelMedio5x5_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio5x5_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio5x5_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio5x5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio5x5_1.setOpaque(true);

        jLabelFacil5x5_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil5x5_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil5x5_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil5x5_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil5x5_1.setOpaque(true);

        jLabelFacil5x5_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil5x5_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil5x5_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil5x5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil5x5_2.setOpaque(true);

        jLabelMedio5x5_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio5x5_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio5x5_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio5x5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio5x5_2.setOpaque(true);

        jLabelDificil5x5_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil5x5_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil5x5_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil5x5_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil5x5_2.setOpaque(true);

        jLabelDificil5x5_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil5x5_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil5x5_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil5x5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil5x5_3.setOpaque(true);

        jLabelMedio5x5_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio5x5_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio5x5_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio5x5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio5x5_3.setOpaque(true);

        jLabelFacil5x5_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil5x5_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil5x5_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil5x5_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil5x5_3.setOpaque(true);

        jLabelDificil6x6_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil6x6_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil6x6_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil6x6_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil6x6_3.setOpaque(true);

        jLabelDificil6x6_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil6x6_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil6x6_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil6x6_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil6x6_2.setOpaque(true);

        jLabelDificil6x6_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil6x6_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil6x6_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil6x6_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil6x6_1.setOpaque(true);

        jLabelMedio6x6_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio6x6_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio6x6_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio6x6_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio6x6_1.setOpaque(true);

        jLabelMedio6x6_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio6x6_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio6x6_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio6x6_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio6x6_2.setOpaque(true);

        jLabelMedio6x6_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio6x6_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio6x6_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio6x6_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio6x6_3.setOpaque(true);

        jLabelFacil6x6_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil6x6_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil6x6_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil6x6_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil6x6_3.setOpaque(true);

        jLabelFacil6x6_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil6x6_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil6x6_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil6x6_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil6x6_2.setOpaque(true);

        jLabelFacil6x6_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil6x6_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil6x6_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil6x6_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil6x6_1.setOpaque(true);

        jLabelad9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad9.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad9.setText("Fácil");

        jLabelad10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad10.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad10.setText("Medio");

        jLabelad11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad11.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad11.setText("Difícil");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(65, 91, 63));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("6x6");

        jLabelDificil7x7_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil7x7_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil7x7_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil7x7_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil7x7_3.setOpaque(true);

        jLabelDificil7x7_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil7x7_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil7x7_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil7x7_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil7x7_2.setOpaque(true);

        jLabelDificil7x7_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil7x7_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil7x7_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil7x7_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil7x7_1.setOpaque(true);

        jLabelMedio7x7_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio7x7_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio7x7_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio7x7_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio7x7_1.setOpaque(true);

        jLabelMedio7x7_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio7x7_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio7x7_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio7x7_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio7x7_2.setOpaque(true);

        jLabelMedio7x7_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio7x7_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio7x7_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio7x7_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio7x7_3.setOpaque(true);

        jLabelFacil7x7_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil7x7_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil7x7_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil7x7_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil7x7_3.setOpaque(true);

        jLabelFacil7x7_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil7x7_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil7x7_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil7x7_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil7x7_2.setOpaque(true);

        jLabelFacil7x7_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil7x7_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil7x7_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil7x7_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil7x7_1.setOpaque(true);

        jLabelad12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad12.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad12.setText("Fácil");

        jLabelad13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad13.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad13.setText("Medio");

        jLabelad14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad14.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad14.setText("Difícil");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(65, 91, 63));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("7x7");

        jLabelDificil8x8_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil8x8_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil8x8_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil8x8_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil8x8_3.setOpaque(true);

        jLabelDificil8x8_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil8x8_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil8x8_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil8x8_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil8x8_2.setOpaque(true);

        jLabelDificil8x8_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil8x8_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil8x8_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil8x8_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil8x8_1.setOpaque(true);

        jLabelMedio8x8_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio8x8_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio8x8_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio8x8_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio8x8_1.setOpaque(true);

        jLabelMedio8x8_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio8x8_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio8x8_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio8x8_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio8x8_2.setOpaque(true);

        jLabelMedio8x8_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio8x8_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio8x8_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio8x8_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio8x8_3.setOpaque(true);

        jLabelFacil8x8_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil8x8_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil8x8_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil8x8_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil8x8_3.setOpaque(true);

        jLabelFacil8x8_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil8x8_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil8x8_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil8x8_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil8x8_2.setOpaque(true);

        jLabelFacil8x8_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil8x8_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil8x8_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil8x8_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil8x8_1.setOpaque(true);

        jLabelad15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad15.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad15.setText("Fácil");

        jLabelad16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad16.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad16.setText("Medio");

        jLabelad17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad17.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad17.setText("Difícil");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(65, 91, 63));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("8x8");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(65, 91, 63));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("9x9");

        jLabelad18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad18.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad18.setText("Fácil");

        jLabelad19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad19.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad19.setText("Medio");

        jLabelad20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelad20.setForeground(new java.awt.Color(65, 91, 63));
        jLabelad20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelad20.setText("Difícil");

        jLabelDificil9x9_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil9x9_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil9x9_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil9x9_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil9x9_1.setOpaque(true);

        jLabelMedio9x9_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio9x9_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio9x9_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio9x9_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio9x9_1.setOpaque(true);

        jLabelFacil9x9_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil9x9_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil9x9_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil9x9_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil9x9_1.setOpaque(true);

        jLabelFacil9x9_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil9x9_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil9x9_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil9x9_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil9x9_2.setOpaque(true);

        jLabelMedio9x9_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio9x9_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio9x9_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio9x9_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio9x9_2.setOpaque(true);

        jLabelDificil9x9_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil9x9_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil9x9_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil9x9_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil9x9_2.setOpaque(true);

        jLabelDificil9x9_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelDificil9x9_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificil9x9_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificil9x9_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificil9x9_3.setOpaque(true);

        jLabelMedio9x9_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelMedio9x9_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelMedio9x9_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelMedio9x9_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMedio9x9_3.setOpaque(true);

        jLabelFacil9x9_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabelFacil9x9_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelFacil9x9_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabelFacil9x9_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFacil9x9_3.setOpaque(true);

        jLabelTamanno.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabelTamanno.setForeground(new java.awt.Color(65, 91, 63));
        jLabelTamanno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTamanno.setText("3x3");

        jLabelDificultad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelDificultad.setForeground(new java.awt.Color(65, 91, 63));
        jLabelDificultad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDificultad.setText("Fácil");

        jLabel_1.setBackground(new java.awt.Color(185, 196, 173));
        jLabel_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_1.setForeground(new java.awt.Color(65, 91, 63));
        jLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_1.setOpaque(true);

        jLabel_2.setBackground(new java.awt.Color(185, 196, 173));
        jLabel_2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_2.setForeground(new java.awt.Color(65, 91, 63));
        jLabel_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_2.setOpaque(true);

        jLabel_3.setBackground(new java.awt.Color(185, 196, 173));
        jLabel_3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel_3.setForeground(new java.awt.Color(65, 91, 63));
        jLabel_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_3.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabelad3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(jLabelad2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)
                                .addComponent(jLabelad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelFacil3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelMedio3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelDificil3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelFacil3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelMedio3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelDificil3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabelFacil3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelMedio3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabelDificil3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTamanno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabelDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(70, 70, 70)
                                    .addComponent(jLabelad18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(150, 150, 150)
                                    .addComponent(jLabelad19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(140, 140, 140)
                                    .addComponent(jLabelad20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabelFacil9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelMedio9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabelDificil9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabelTamanno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabelDificultad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil3x3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil3x3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil3x3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil4x4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil4x4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil4x4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil5x5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil5x5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil5x5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil6x6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil6x6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil6x6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil7x7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil7x7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil7x7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil8x8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil8x8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil8x8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelad18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelad20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil9x9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil9x9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFacil9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMedio9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDificil9x9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 790, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Podio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Podio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Podio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Podio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Podio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDificil3x3_1;
    private javax.swing.JLabel jLabelDificil3x3_2;
    private javax.swing.JLabel jLabelDificil3x3_3;
    private javax.swing.JLabel jLabelDificil4x4_1;
    private javax.swing.JLabel jLabelDificil4x4_2;
    private javax.swing.JLabel jLabelDificil4x4_3;
    private javax.swing.JLabel jLabelDificil5x5_1;
    private javax.swing.JLabel jLabelDificil5x5_2;
    private javax.swing.JLabel jLabelDificil5x5_3;
    private javax.swing.JLabel jLabelDificil6x6_1;
    private javax.swing.JLabel jLabelDificil6x6_2;
    private javax.swing.JLabel jLabelDificil6x6_3;
    private javax.swing.JLabel jLabelDificil7x7_1;
    private javax.swing.JLabel jLabelDificil7x7_2;
    private javax.swing.JLabel jLabelDificil7x7_3;
    private javax.swing.JLabel jLabelDificil8x8_1;
    private javax.swing.JLabel jLabelDificil8x8_2;
    private javax.swing.JLabel jLabelDificil8x8_3;
    private javax.swing.JLabel jLabelDificil9x9_1;
    private javax.swing.JLabel jLabelDificil9x9_2;
    private javax.swing.JLabel jLabelDificil9x9_3;
    private javax.swing.JLabel jLabelDificultad;
    private javax.swing.JLabel jLabelFacil3x3_1;
    private javax.swing.JLabel jLabelFacil3x3_2;
    private javax.swing.JLabel jLabelFacil3x3_3;
    private javax.swing.JLabel jLabelFacil4x4_1;
    private javax.swing.JLabel jLabelFacil4x4_2;
    private javax.swing.JLabel jLabelFacil4x4_3;
    private javax.swing.JLabel jLabelFacil5x5_1;
    private javax.swing.JLabel jLabelFacil5x5_2;
    private javax.swing.JLabel jLabelFacil5x5_3;
    private javax.swing.JLabel jLabelFacil6x6_1;
    private javax.swing.JLabel jLabelFacil6x6_2;
    private javax.swing.JLabel jLabelFacil6x6_3;
    private javax.swing.JLabel jLabelFacil7x7_1;
    private javax.swing.JLabel jLabelFacil7x7_2;
    private javax.swing.JLabel jLabelFacil7x7_3;
    private javax.swing.JLabel jLabelFacil8x8_1;
    private javax.swing.JLabel jLabelFacil8x8_2;
    private javax.swing.JLabel jLabelFacil8x8_3;
    private javax.swing.JLabel jLabelFacil9x9_1;
    private javax.swing.JLabel jLabelFacil9x9_2;
    private javax.swing.JLabel jLabelFacil9x9_3;
    private javax.swing.JLabel jLabelMedio3x3_1;
    private javax.swing.JLabel jLabelMedio3x3_2;
    private javax.swing.JLabel jLabelMedio3x3_3;
    private javax.swing.JLabel jLabelMedio4x4_1;
    private javax.swing.JLabel jLabelMedio4x4_2;
    private javax.swing.JLabel jLabelMedio4x4_3;
    private javax.swing.JLabel jLabelMedio5x5_1;
    private javax.swing.JLabel jLabelMedio5x5_2;
    private javax.swing.JLabel jLabelMedio5x5_3;
    private javax.swing.JLabel jLabelMedio6x6_1;
    private javax.swing.JLabel jLabelMedio6x6_2;
    private javax.swing.JLabel jLabelMedio6x6_3;
    private javax.swing.JLabel jLabelMedio7x7_1;
    private javax.swing.JLabel jLabelMedio7x7_2;
    private javax.swing.JLabel jLabelMedio7x7_3;
    private javax.swing.JLabel jLabelMedio8x8_1;
    private javax.swing.JLabel jLabelMedio8x8_2;
    private javax.swing.JLabel jLabelMedio8x8_3;
    private javax.swing.JLabel jLabelMedio9x9_1;
    private javax.swing.JLabel jLabelMedio9x9_2;
    private javax.swing.JLabel jLabelMedio9x9_3;
    private javax.swing.JLabel jLabelTamanno;
    private javax.swing.JLabel jLabel_1;
    private javax.swing.JLabel jLabel_2;
    private javax.swing.JLabel jLabel_3;
    private javax.swing.JLabel jLabelad;
    private javax.swing.JLabel jLabelad1;
    private javax.swing.JLabel jLabelad10;
    private javax.swing.JLabel jLabelad11;
    private javax.swing.JLabel jLabelad12;
    private javax.swing.JLabel jLabelad13;
    private javax.swing.JLabel jLabelad14;
    private javax.swing.JLabel jLabelad15;
    private javax.swing.JLabel jLabelad16;
    private javax.swing.JLabel jLabelad17;
    private javax.swing.JLabel jLabelad18;
    private javax.swing.JLabel jLabelad19;
    private javax.swing.JLabel jLabelad2;
    private javax.swing.JLabel jLabelad20;
    private javax.swing.JLabel jLabelad3;
    private javax.swing.JLabel jLabelad4;
    private javax.swing.JLabel jLabelad5;
    private javax.swing.JLabel jLabelad6;
    private javax.swing.JLabel jLabelad7;
    private javax.swing.JLabel jLabelad8;
    private javax.swing.JLabel jLabelad9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

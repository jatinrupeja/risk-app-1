/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.View;

/**
 *
 * @author vansh
 */
public class TournamentView extends javax.swing.JFrame {
     /**
     * Creates new form NewJFrame
     */
    public TournamentView  () { }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    public void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tournament_game_log_Jlist = new javax.swing.JList<>();
        MAP1_LABEL = new javax.swing.JLabel();
        Game1_button1 = new javax.swing.JButton();
        Game1_button2 = new javax.swing.JButton();
        Game1_button3 = new javax.swing.JButton();
        Game1_button4 = new javax.swing.JButton();
        Game1_button5 = new javax.swing.JButton();
        MAP2_LABEL = new javax.swing.JLabel();
        Game2_button1 = new javax.swing.JButton();
        Game2_button2 = new javax.swing.JButton();
        Game2_button3 = new javax.swing.JButton();
        Game2_button4 = new javax.swing.JButton();
        Game2_button5 = new javax.swing.JButton();
        MAP3_LABEL = new javax.swing.JLabel();
        Game3_button1 = new javax.swing.JButton();
        Game3_button2 = new javax.swing.JButton();
        Game3_button3 = new javax.swing.JButton();
        Game3_button4 = new javax.swing.JButton();
        Game3_button5 = new javax.swing.JButton();
        MAP4_LABEL = new javax.swing.JLabel();
        Game4_button1 = new javax.swing.JButton();
        Game4_button2 = new javax.swing.JButton();
        Game4_button3 = new javax.swing.JButton();
        Game4_button4 = new javax.swing.JButton();
        Game4_button5 = new javax.swing.JButton();
        MAP5_LABEL = new javax.swing.JLabel();
        Game5_button1 = new javax.swing.JButton();
        Game5_button2 = new javax.swing.JButton();
        Game5_button3 = new javax.swing.JButton();
        Game5_button4 = new javax.swing.JButton();
        Game5_button5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(Tournament_game_log_Jlist);

        MAP1_LABEL.setText("MAP 1 :");

        Game1_button1.setText("Game 1");

        Game1_button2.setText("Game 2");

        Game1_button3.setText("Game 3");

        Game1_button4.setText("Game 4");

        Game1_button5.setText("Game 5");

        MAP2_LABEL.setText("MAP 2 :");

        Game2_button1.setText("Game 1");

        Game2_button2.setText("Game 2");

        Game2_button3.setText("Game 3");

        Game2_button4.setText("Game 4");
        Game2_button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game2_button4ActionPerformed(evt);
            }
        });

        Game2_button5.setText("Game 5");

        MAP3_LABEL.setText("MAP 3 :");

        Game3_button1.setText("Game 1");
        Game3_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Game3_button1ActionPerformed(evt);
            }
        });

        Game3_button2.setText("Game 2");

        Game3_button3.setText("Game 3");

        Game3_button4.setText("Game 4 ");

        Game3_button5.setText("Game 5");

        MAP4_LABEL.setText("MAP 4 :");

        Game4_button1.setText("Game 1");

        Game4_button2.setText("Game 2");

        Game4_button3.setText("Game 3");

        Game4_button4.setText("Game 4");

        Game4_button5.setText("Game 5");

        MAP5_LABEL.setText("MAP 5 :");

        Game5_button1.setText("Game 1");

        Game5_button2.setText("Game 2");

        Game5_button3.setText("Game 3");

        Game5_button4.setText("Game 4");

        Game5_button5.setText("Game 5");

        jLabel6.setText("RESULTS :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {"   MAP 1", null, null, null, null, null},
                {"   MAP 2", null, null, null, null, null},
                {"   MAP 3", null, null, null, null, null},
                {"   MAP 4", null, null, null, null, null},
                {"   MAP 5", null, null, null, null, null}
            },
            new String [] {
                " ", "      Game 1", "      Game 2", "      Game 3", "      Game 4", "      GAME 5"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setText("GAME LOG :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MAP1_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAP2_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAP4_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAP5_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MAP3_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Game1_button1)
                                    .addComponent(Game2_button1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game1_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game1_button3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game2_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Game2_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game2_button4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game2_button5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game1_button4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game1_button5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game4_button1)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game4_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game4_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game3_button1)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game3_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(Game3_button3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Game5_button1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Game5_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game5_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Game3_button4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game3_button5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Game4_button4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game4_button5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Game5_button4)
                                        .addGap(18, 18, 18)
                                        .addComponent(Game5_button5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(17, 17, 17)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(MAP1_LABEL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Game1_button1)
                            .addComponent(Game1_button2)
                            .addComponent(Game1_button3)
                            .addComponent(Game1_button4)
                            .addComponent(Game1_button5))
                        .addGap(18, 18, 18)
                        .addComponent(MAP2_LABEL)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Game2_button1)
                            .addComponent(Game2_button2)
                            .addComponent(Game2_button3)
                            .addComponent(Game2_button4)
                            .addComponent(Game2_button5))
                        .addGap(27, 27, 27)
                        .addComponent(MAP3_LABEL)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Game3_button1)
                            .addComponent(Game3_button2)
                            .addComponent(Game3_button3)
                            .addComponent(Game3_button4)
                            .addComponent(Game3_button5))
                        .addGap(18, 18, 18)
                        .addComponent(MAP4_LABEL)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Game4_button1)
                            .addComponent(Game4_button2)
                            .addComponent(Game4_button3)
                            .addComponent(Game4_button4)
                            .addComponent(Game4_button5))
                        .addGap(18, 18, 18)
                        .addComponent(MAP5_LABEL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Game5_button1)
                            .addComponent(Game5_button2)
                            .addComponent(Game5_button3)
                            .addComponent(Game5_button4)
                            .addComponent(Game5_button5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setVisible(true);
        pack();
    }// </editor-fold>                        

    private void Game2_button4ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void Game3_button1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton Game1_button1;
    private javax.swing.JButton Game1_button2;
    private javax.swing.JButton Game1_button3;
    private javax.swing.JButton Game1_button4;
    private javax.swing.JButton Game1_button5;
    private javax.swing.JButton Game2_button1;
    private javax.swing.JButton Game2_button2;
    private javax.swing.JButton Game2_button3;
    private javax.swing.JButton Game2_button4;
    private javax.swing.JButton Game2_button5;
    private javax.swing.JButton Game3_button1;
    private javax.swing.JButton Game3_button2;
    private javax.swing.JButton Game3_button3;
    private javax.swing.JButton Game3_button4;
    private javax.swing.JButton Game3_button5;
    private javax.swing.JButton Game4_button1;
    private javax.swing.JButton Game4_button2;
    private javax.swing.JButton Game4_button3;
    private javax.swing.JButton Game4_button4;
    private javax.swing.JButton Game4_button5;
    private javax.swing.JButton Game5_button1;
    private javax.swing.JButton Game5_button2;
    private javax.swing.JButton Game5_button3;
    private javax.swing.JButton Game5_button4;
    private javax.swing.JButton Game5_button5;
    private javax.swing.JLabel MAP1_LABEL;
    private javax.swing.JLabel MAP2_LABEL;
    private javax.swing.JLabel MAP3_LABEL;
    private javax.swing.JLabel MAP4_LABEL;
    private javax.swing.JLabel MAP5_LABEL;
    private javax.swing.JList<String> Tournament_game_log_Jlist;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}

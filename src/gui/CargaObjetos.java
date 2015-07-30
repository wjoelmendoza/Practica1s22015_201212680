/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import estructura.Castillo;
import estructura.Ficha;
import estructura.Goomba;
import estructura.Heroe;
import estructura.Hongo;
import estructura.Koopa;
import estructura.ListaDoble;
import estructura.Pared;
import estructura.Suelo;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author walter
 */
public class CargaObjetos extends javax.swing.JFrame {
    private ListaDoble ld = new ListaDoble();
    /**
     * Creates new form CargaObjetos
     */
    public CargaObjetos() {
        initComponents();
        this.setResizable(false);
        modifLabels();
    }

    private void modifLabels(){
        
        lblKoopa.setIcon(new ImageIcon(getClass().getResource("/recursos/tarazan-virusp.png")));
        
        lblGoomba.setIcon(new ImageIcon(getClass().getResource("/recursos/zendams-cooldeviltux.png")));
        
        lblMario.setIcon(new ImageIcon(getClass().getResource("/recursos/luap33-sangoku.png")));
        
        lblFicha.setIcon(new ImageIcon(getClass().getResource("/recursos/ficha.png")));
        
        lblHongo.setIcon(new ImageIcon(getClass().getResource("/recursos/hongo2.png")));
        
        lblPared.setIcon(new ImageIcon(getClass().getResource("/recursos/pared.png")));
        
        lblCastillo.setIcon(new ImageIcon(getClass().getResource("/recursos/pared1.png")));
        
        lblSuelo.setIcon(new ImageIcon(getClass().getResource("/recursos/suelo.png")));
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnHongo = new javax.swing.JButton();
        lblmname = new javax.swing.JLabel();
        btnSuelo = new javax.swing.JButton();
        btnCastillo = new javax.swing.JButton();
        lblgname = new javax.swing.JLabel();
        lblGoomba = new javax.swing.JLabel();
        lblMario = new javax.swing.JLabel();
        lblkname = new javax.swing.JLabel();
        lblhname = new javax.swing.JLabel();
        lblfname = new javax.swing.JLabel();
        lblKoopa = new javax.swing.JLabel();
        lblFicha = new javax.swing.JLabel();
        btnGoomba = new javax.swing.JButton();
        lblHongo = new javax.swing.JLabel();
        lblCastillo = new javax.swing.JLabel();
        btnFicha = new javax.swing.JButton();
        btnPared = new javax.swing.JButton();
        lblcname = new javax.swing.JLabel();
        lblSuelo = new javax.swing.JLabel();
        lblPared = new javax.swing.JLabel();
        btnMario = new javax.swing.JButton();
        btnKoopa = new javax.swing.JButton();
        lblsname = new javax.swing.JLabel();
        lblpname = new javax.swing.JLabel();
        txtKoopa = new javax.swing.JTextField();
        txtGoomba = new javax.swing.JTextField();
        txtFicha = new javax.swing.JTextField();
        txtHongo = new javax.swing.JTextField();
        txtMario = new javax.swing.JTextField();
        txtPared = new javax.swing.JTextField();
        txtSuelo = new javax.swing.JTextField();
        txtCastillo = new javax.swing.JTextField();
        btnContinuar = new javax.swing.JButton();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cargar Objetos");

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Agregue los elementos a utilizar:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        btnHongo.setText("Agregar");
        btnHongo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHongoActionPerformed(evt);
            }
        });

        lblmname.setText("Mario");

        btnSuelo.setText("Agregar");
        btnSuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSueloActionPerformed(evt);
            }
        });

        btnCastillo.setText("Agregar");
        btnCastillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCastilloActionPerformed(evt);
            }
        });

        lblgname.setText("Goomba");

        lblkname.setText("Koopa");

        lblhname.setText("Hongo");

        lblfname.setText("Ficha");

        btnGoomba.setText("Agregar");
        btnGoomba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoombaActionPerformed(evt);
            }
        });

        btnFicha.setText("Agregar");
        btnFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFichaActionPerformed(evt);
            }
        });

        btnPared.setText("Agregar");
        btnPared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParedActionPerformed(evt);
            }
        });

        lblcname.setText("Castillo");

        btnMario.setText("Agregar");
        btnMario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarioActionPerformed(evt);
            }
        });

        btnKoopa.setText("Agregar");
        btnKoopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoopaActionPerformed(evt);
            }
        });

        lblsname.setText("Suelo");

        lblpname.setText("Pared");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMario)
                    .addComponent(txtKoopa)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblKoopa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                        .addComponent(lblmname)
                        .addComponent(lblkname))
                    .addComponent(btnKoopa, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnMario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblGoomba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPared, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnGoomba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblpname)
                    .addComponent(lblgname)
                    .addComponent(txtGoomba)
                    .addComponent(txtPared)
                    .addComponent(btnPared, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFicha)
                    .addComponent(lblfname)
                    .addComponent(lblsname)
                    .addComponent(lblFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSuelo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(btnFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSuelo)
                    .addComponent(btnSuelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblhname)
                    .addComponent(lblHongo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCastillo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(lblcname)
                    .addComponent(btnHongo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHongo)
                    .addComponent(btnCastillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCastillo))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblFicha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblGoomba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblKoopa, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblHongo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkname)
                    .addComponent(lblgname)
                    .addComponent(lblfname)
                    .addComponent(lblhname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKoopa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGoomba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHongo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKoopa)
                    .addComponent(btnGoomba)
                    .addComponent(btnFicha)
                    .addComponent(btnHongo))
                .addGap(51, 51, 51)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPared, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblmname)
                            .addComponent(lblpname)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCastillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblsname)
                            .addComponent(lblcname))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSuelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCastillo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMario)
                    .addComponent(btnPared)
                    .addComponent(btnSuelo)
                    .addComponent(btnCastillo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(btnHongo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblmname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnSuelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnCastillo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblgname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblGoomba, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblMario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblkname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblhname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblfname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblKoopa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblFicha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnGoomba, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblHongo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblCastillo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnFicha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnPared, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblcname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblSuelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblPared, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnMario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnKoopa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblsname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(lblpname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtKoopa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtGoomba, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtFicha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtHongo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtMario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtPared, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtSuelo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(txtCastillo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });

        btnVer.setText("Ver");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btnContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContinuar)
                    .addComponent(btnVer))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKoopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoopaActionPerformed
        // TODO add your handling code here:
        if(!vacio(txtKoopa)){
            ld.agregar(new Koopa(txtKoopa.getText()));
            txtKoopa.setText("");
        }else
            msjError(lblkname);
    }//GEN-LAST:event_btnKoopaActionPerformed

    private void btnGoombaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoombaActionPerformed
        // TODO add your handling code here:
        if(!vacio(txtGoomba)){
            ld.agregar(new Goomba(txtGoomba.getText()));
            txtGoomba.setText("");
        }else
            msjError(lblgname);
    }//GEN-LAST:event_btnGoombaActionPerformed

    private void btnFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFichaActionPerformed
        if(!vacio(txtFicha)){
            ld.agregar(new Ficha(txtFicha.getText()));
            txtFicha.setText("");
        }else
            msjError(lblfname);
    }//GEN-LAST:event_btnFichaActionPerformed

    private void btnHongoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHongoActionPerformed
        if(!vacio(txtHongo)){
            ld.agregar(new Hongo(txtHongo.getText()));
            txtHongo.setText("");
        }else
            msjError(lblhname);
    }//GEN-LAST:event_btnHongoActionPerformed

    private void btnMarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarioActionPerformed
        if(!vacio(txtMario)){
            ld.agregar(new Heroe(txtMario.getText()));
            txtMario.setText("");
            btnMario.setEnabled(false);
        }else
            msjError(lblmname);
    }//GEN-LAST:event_btnMarioActionPerformed

    private void btnParedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParedActionPerformed
        if(!vacio(txtPared)){
            ld.agregar(new Pared(txtPared.getText()));
            txtPared.setText("");
        }else
            msjError(lblpname);
    }//GEN-LAST:event_btnParedActionPerformed

    private void btnSueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSueloActionPerformed
        if(!vacio(txtSuelo)){
            ld.agregar(new Suelo(txtSuelo.getText()));
            txtSuelo.setText("");
        }else
            msjError(lblsname);
    }//GEN-LAST:event_btnSueloActionPerformed

    private void btnCastilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCastilloActionPerformed
        // TODO add your handling code here:
        if(!vacio(txtCastillo)){
            ld.agregar(new Castillo(txtCastillo.getText()));
            txtCastillo.setText("");
            btnCastillo.setEnabled(false);
        }else
            msjError(lblcname);
    }//GEN-LAST:event_btnCastilloActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        Edicion ed =new Edicion(ld);
        ed.setVisible(true);
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        ld.grafica();
    }//GEN-LAST:event_btnContinuarActionPerformed

    
    private void msjError(JLabel lbl){
        JOptionPane.showMessageDialog(this,"Debe agregarle un nombre al elemento:\n" 
                                        +lbl.getText()+" que se esta agregando","Error",JOptionPane.ERROR_MESSAGE );
    }
    
    private boolean vacio(JTextField txt){
        return txt.getText().isEmpty();
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCastillo;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JButton btnFicha;
    private javax.swing.JButton btnGoomba;
    private javax.swing.JButton btnHongo;
    private javax.swing.JButton btnKoopa;
    private javax.swing.JButton btnMario;
    private javax.swing.JButton btnPared;
    private javax.swing.JButton btnSuelo;
    private javax.swing.JButton btnVer;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel lblCastillo;
    private javax.swing.JLabel lblFicha;
    private javax.swing.JLabel lblGoomba;
    private javax.swing.JLabel lblHongo;
    private javax.swing.JLabel lblKoopa;
    private javax.swing.JLabel lblMario;
    private javax.swing.JLabel lblPared;
    private javax.swing.JLabel lblSuelo;
    private javax.swing.JLabel lblcname;
    private javax.swing.JLabel lblfname;
    private javax.swing.JLabel lblgname;
    private javax.swing.JLabel lblhname;
    private javax.swing.JLabel lblkname;
    private javax.swing.JLabel lblmname;
    private javax.swing.JLabel lblpname;
    private javax.swing.JLabel lblsname;
    private javax.swing.JTextField txtCastillo;
    private javax.swing.JTextField txtFicha;
    private javax.swing.JTextField txtGoomba;
    private javax.swing.JTextField txtHongo;
    private javax.swing.JTextField txtKoopa;
    private javax.swing.JTextField txtMario;
    private javax.swing.JTextField txtPared;
    private javax.swing.JTextField txtSuelo;
    // End of variables declaration//GEN-END:variables
}

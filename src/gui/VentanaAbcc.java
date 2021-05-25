/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.Controlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class VentanaAbcc extends javax.swing.JFrame {

    
    static ResultSet res;
    /**
     * Creates new form VentanaAbcc
     */
    public VentanaAbcc() {
        initComponents();
        try {
            CargarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAbcc.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
    }
    
    public void CargarTabla() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tablaClient.getModel();
        modelo.setRowCount(0); 
        res = Controlador.buscarRegistro("Select * from client");
        try {
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getInt(6));
                modelo.addRow(v);
                tablaClient.setModel(modelo);
                
            }
        } catch (SQLException e) {
            
            
        }
    }
        public void CargarTablaEspecifica(String clave) throws SQLException{
            DefaultTableModel modelo = (DefaultTableModel) tablaClient.getModel();
           
        modelo.setRowCount(0);
        res = Controlador.buscarRegistro("Select * from client where clientNo like '%" + clave +"%' or fName like '%" + clave +"%' or lName like '%" + clave +"%' or telNo like '%" + clave +"%' or prefType like '%" + clave +"%' or maxRent like '%" + clave + "%'");
        
        try {
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getInt(6));
                modelo.addRow(v);
                tablaClient.setModel(modelo);
                
            }
        } catch (SQLException e) {
            
            
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

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClient = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoClient = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoAp = new javax.swing.JTextField();
        campoTel = new javax.swing.JTextField();
        campoRent = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "clientNo", "fName", "lName", "telNo", "prefType", "maxRent"
            }
        ));
        tablaClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaClient);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 750, 152));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        jLabel4.setText("Filtrar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        campoClient.setEditable(false);
        getContentPane().add(campoClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, -1));

        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNombreKeyTyped(evt);
            }
        });
        getContentPane().add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 110, 30));

        campoAp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoApKeyTyped(evt);
            }
        });
        getContentPane().add(campoAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 110, 30));

        campoTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTelActionPerformed(evt);
            }
        });
        getContentPane().add(campoTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 100, 30));
        getContentPane().add(campoRent, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 100, 30));

        botonAgregar.setText("Agregar");
        botonAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAgregarMouseClicked(evt);
            }
        });
        getContentPane().add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 50, 40));

        jLabel2.setText("Editar");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 50, 40));

        jLabel3.setText("Eliminar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 50, 40));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Flat", "House" }));
        getContentPane().add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 110, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTelActionPerformed

    private void botonAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAgregarMouseClicked

        
        
        if(false){
            
        }
        if (campoNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar Nombre");
        }else if(campoAp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Revisar Apellido");
        }else if(! (campoTel.getText().matches("[0-9]*"))  || campoTel.getText().equals("") ||! (campoTel.getText().length() == 10)){       
            JOptionPane.showMessageDialog(null, "Revisar Telefono 10 digitos");
        }else if(! (campoRent.getText().matches("[0-9]*"))  || campoRent.getText().equals("")){
            System.out.println("entra");
            JOptionPane.showMessageDialog(null, "Revisar Renta");
        }else {
            try {
                
                
            Controlador.insertarCliente(campoNombre.getText(), campoAp.getText(), campoTel.getText(), comboTipo.getSelectedItem().toString(), campoRent.getText());
            
            restaurar();
                CargarTabla();
                JOptionPane.showMessageDialog(null, "Agregado Correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAbcc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }//GEN-LAST:event_botonAgregarMouseClicked

    private void restaurar(){
        campoClient.setText("");
        campoNombre.setText("");
        campoAp.setText("");
        campoRent.setText("");
        campoTel.setText("");
    }
    
    private void campoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyTyped
        
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep(); 
            evt.consume();
        }
        
    }//GEN-LAST:event_campoNombreKeyTyped

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoApKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApKeyTyped
        char validacion = evt.getKeyChar();
        if (Character.isDigit(validacion)) {
            getToolkit().beep(); 
            evt.consume();
        }
    }//GEN-LAST:event_campoApKeyTyped

    private void tablaClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClientMouseClicked
        
        int acc = tablaClient.rowAtPoint(evt.getPoint());
        campoClient.setText(String.valueOf(tablaClient.getValueAt(acc, 0)));
        campoNombre.setText(String.valueOf(tablaClient.getValueAt(acc, 1)));
        campoAp.setText(String.valueOf(tablaClient.getValueAt(acc, 2)));
        campoTel.setText(String.valueOf(tablaClient.getValueAt(acc, 3)));
        comboTipo.setSelectedItem(String.valueOf(tablaClient.getValueAt(acc, 4)));
        campoRent.setText(String.valueOf(tablaClient.getValueAt(acc, 5)));
    }//GEN-LAST:event_tablaClientMouseClicked

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        
        
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        
        if (campoNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Revisar Nombre");
        }else if(campoAp.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Revisar Apellido");
        }else if(! (campoTel.getText().matches("[0-9]*"))  || campoTel.getText().equals("") ||! (campoTel.getText().length() == 10)){       
            JOptionPane.showMessageDialog(null, "Revisar Telefono 10 digitos");
        }else if(! (campoRent.getText().matches("[0-9]*"))  || campoRent.getText().equals("")){
            System.out.println("entra");
            JOptionPane.showMessageDialog(null, "Revisar Renta");
        }else {
            try {
                Controlador.editarCliente(campoNombre.getText(), campoAp.getText(), campoTel.getText(), comboTipo.getSelectedItem().toString(), campoRent.getText(),campoClient.getText());
                restaurar();
                CargarTabla();
                JOptionPane.showMessageDialog(null, "Editado Correctamente");
            } catch (SQLException ex) {
                Logger.getLogger(VentanaAbcc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        
        if(campoClient.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Revisar infromación");
        }else{
            try {
            Controlador.borrarCliente(campoClient.getText());
        restaurar();
            CargarTabla();
            JOptionPane.showMessageDialog(null, "Eliminado Correctamente");
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAbcc.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        




        
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
       
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            CargarTablaEspecifica(jTextField1.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VentanaAbcc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

        private void reset() {                                     
        
        
        
    }    
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
            java.util.logging.Logger.getLogger(VentanaAbcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAbcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAbcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAbcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAbcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonAgregar;
    private javax.swing.JTextField campoAp;
    private javax.swing.JTextField campoClient;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoRent;
    private javax.swing.JTextField campoTel;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaClient;
    // End of variables declaration//GEN-END:variables
}

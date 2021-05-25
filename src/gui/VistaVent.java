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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Felipe
 */
public class VistaVent extends javax.swing.JFrame {

    /**
     * Creates new form VistaVent
     */
    public VistaVent() {
        initComponents();
            try {
            CargarTabla();
            
        } catch (SQLException ex) {
        }
        
    }

            public void CargarTabla() throws SQLException{
        DefaultTableModel modelo = (DefaultTableModel) tablaView.getModel();
        modelo.setRowCount(0); 
        ResultSet res;
        res = Controlador.buscarRegistro("SELECT * FROM Vista");
        try {
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                modelo.addRow(v);
                tablaView.setModel(modelo);
                
            }
        } catch (SQLException e) {
            
            
        }
    }

                public void CargarTablaEspecifica(String clave) throws SQLException{
            DefaultTableModel modelo = (DefaultTableModel) tablaView.getModel();
           
        modelo.setRowCount(0); 
        ResultSet res;
        res = Controlador.buscarRegistro("Select * from views where clientNo like '%" + clave +"%' or propertyNo like '%" + clave +"%' or viewDate like '%" + clave +"%' or comment like '%" + clave +"%'");
                   
        try {
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                modelo.addRow(v);
                tablaView.setModel(modelo);
                
            }
        } catch (SQLException e) {

        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaView = new javax.swing.JTable();
        campo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Numero", "Propiedad", "Comentario"
            }
        ));
        jScrollPane1.setViewportView(tablaView);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 378, 203));

        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoKeyTyped(evt);
            }
        });
        getContentPane().add(campo, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 60, 124, 29));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_blanco.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoKeyTyped

        try {
            CargarTablaEspecifica(campo.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VistaVent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_campoKeyTyped

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
            java.util.logging.Logger.getLogger(VistaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaVent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaVent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaView;
    // End of variables declaration//GEN-END:variables
}

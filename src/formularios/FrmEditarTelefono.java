/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
package formularios;

import bd.Conexion;
import entidades.Telefono;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author and1_p
 */
public class FrmEditarTelefono extends javax.swing.JFrame {
    FrmMantenimientoTelefono Fmr;
    /** Creates new form FrmIngresarTelefono */
    public FrmEditarTelefono(String codigo,FrmMantenimientoTelefono Fmr) {
        this.Fmr = Fmr;
        initComponents();
        setLocationRelativeTo(null);
        
        
        Conexion c = new Conexion();
        String descripcion1 = codigo;
        String tipo = "codigo";
        
        try{
            c.conectar();
            ArrayList<Telefono> telefonos = c.consultarTelefonos(descripcion1,tipo);
            Telefono telefono = telefonos.get(0);
            this.txt_codigo.setText(""+telefono.getCodigo());
            this.cb_marca.setSelectedItem(telefono.getMarca());
            this.cb_modelo.setSelectedItem(telefono.getModelo());
            this.txt_descripcion.setText(telefono.getDescripcion());
            this.txt_precio.setText(""+telefono.getPrecio());                        
           
        
        }catch(Exception e){
            
           JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CONSULTAR LOS DATOS DEL TELEFONO", "ERROR", JOptionPane.ERROR_MESSAGE);  
        
        }
     
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        txt_descripcion = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cb_marca = new javax.swing.JComboBox();
        cb_modelo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("CODIGO:");

        jLabel2.setText("MARCA:");

        jLabel3.setText("MODELO:");

        jLabel4.setText("DESCRIPCION:");

        jLabel5.setText("PRECIO:");

        txt_codigo.setEditable(false);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.jpg"))); // NOI18N
        jButton2.setText("LIMPIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cb_marca.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SAMSUNG", "MOTOROLA", "NOKIA", "BLACKBERRY" }));

        cb_modelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GALAXY GRAND 2S", "GALAXY S4 ZOOM", "GALAXY WIN DUOS ", "GALAXY POCKET NEO", "MOTO G", "MOTOGO TV", "MOTOSMARTPLUS", "ATRIX 2", "LUMIA 1520", "ASHA 205", "ASHA 210", "ASHA 309" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_modelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_marca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(txt_descripcion)
                    .addComponent(txt_precio))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cb_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(jButton2))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        if(registroValido()){
        int codigo = Integer.parseInt(this.txt_codigo.getText());
        String marca = this.cb_marca.getSelectedItem().toString();
        String modelo = this.cb_modelo.getSelectedItem().toString();
        String descripcion = this.txt_descripcion.getText();
        float precio = Float.parseFloat(this.txt_precio.getText());
        
        Conexion c = new Conexion();

        try{
            c.conectar();
            Telefono t = new Telefono(codigo, marca, modelo, descripcion, precio);
       
            if(c.modificarTelefono(t)){
            JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE EL REGISTRO", "EXITO", JOptionPane.INFORMATION_MESSAGE);
            this.Fmr.consultar_telefono();
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA EDICION", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

                     
        }catch(Exception e){
            
          
           JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA CONEXION", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      }
        
    }//GEN-LAST:event_btnEditarActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    limpiarRegistro();  
}//GEN-LAST:event_jButton2ActionPerformed
private boolean registroValido(){

     if(this.txt_codigo.getText().trim().equals("") ||
//       this.txt_marca.getText().trim().equals("") ||
//       this.txt_modelo.getText().trim().equals("") ||
       this.txt_descripcion.getText().trim().equals("") ||
       this.txt_precio.getText().trim().equals("")
    
       ){
        JOptionPane.showMessageDialog(null, "FALTA CAMPOS DE LLENAR EN EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }
       
return true;
}
private void limpiarRegistro(){
    

    this.txt_codigo.setText("");
    this.txt_descripcion.setText("");
    this.txt_precio.setText("");   
   }


    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox cb_marca;
    private javax.swing.JComboBox cb_modelo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_descripcion;
    private javax.swing.JTextField txt_precio;
    // End of variables declaration//GEN-END:variables
}
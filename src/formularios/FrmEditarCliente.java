/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmEditarUsuario.java
 *
 * Created on 07-dic-2013, 12:34:46
 */
package formularios;

import bd.Conexion;
import entidades.Cliente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author and1_p
 */
public class FrmEditarCliente extends javax.swing.JFrame {
    FrmMantenimientoCliente Fmr;
    /** Creates new form FrmEditarUsuario */
    public FrmEditarCliente(String identificacion,FrmMantenimientoCliente Fmr) {
        this.Fmr = Fmr;
        initComponents();
        setLocationRelativeTo(null);
        
        
        Conexion c = new Conexion();
        String descripcion1 = identificacion;
        String tipo = "identificacion";
        
        try{
            c.conectar();
            ArrayList<Cliente> clientes = c.consultarCliente(descripcion1,tipo);
            Cliente cliente = clientes.get(0);
            this.txt_identificacion.setText(cliente.getIdentificacion());
            this.txt_nombre.setText(cliente.getNombre());
            this.txt_direccion.setText(cliente.getDireccion());
            this.txt_telefono.setText(cliente.getTelefono());                        
           
        
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_identificacion = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        btn_editar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Identificacion:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Direccion:");

        jLabel5.setText("Telefono:");

        txt_identificacion.setEditable(false);

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.jpg"))); // NOI18N
        btn_salir.setText("Limpiar");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_editar)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_identificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_nombre)
                            .addComponent(txt_direccion)
                            .addComponent(txt_telefono))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_salir)
                        .addGap(18, 18, 18))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_identificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar)
                    .addComponent(btn_salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.BLUE);
        if(registroValido()){
        String identificacion = this.txt_identificacion.getText();
        String nombre = this.txt_nombre.getText();
        String direccion = this.txt_direccion.getText();
        String telefono = this.txt_telefono.getText();
        
        Conexion c = new Conexion();

        try{
            c.conectar();
            Cliente cl = new Cliente(identificacion, nombre, direccion, telefono);
       
            if(c.modificarCliente(cl)){
            JOptionPane.showMessageDialog(null, "SE MODIFICO CORRECTAMENTE EL REGISTRO", "EXITO", JOptionPane.INFORMATION_MESSAGE);
            this.Fmr.consultar_cliente();
            this.dispose();
            
        }else{
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA EDICION", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

                     
        }catch(Exception e){
            
          
           JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA CONEXION", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
      }
    }//GEN-LAST:event_btn_editarActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        limpiarRegistro();
    }//GEN-LAST:event_btn_salirActionPerformed

    private boolean registroValido(){

     if(this.txt_identificacion.getText().trim().equals("") ||
       this.txt_nombre.getText().trim().equals("") ||
       this.txt_direccion.getText().trim().equals("") ||
       this.txt_telefono.getText().trim().equals("")
    
       ){
        JOptionPane.showMessageDialog(null, "FALTA CAMPOS DE LLENAR EN EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }
       
return true;
}
  
private void limpiarRegistro(){
    

    this.txt_nombre.setText("");
    this.txt_direccion.setText("");
    this.txt_telefono.setText("");   
   }
    
    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_identificacion;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}

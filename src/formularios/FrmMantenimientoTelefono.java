/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmMantenimientoTelefono.java
 *
 * Created on 14/11/2013, 04:01:14 PM
 */
package formularios;

import bd.Conexion;
import entidades.Telefono;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author VR
 */
public class FrmMantenimientoTelefono extends javax.swing.JFrame {

    /** Creates new form FrmMantenimientoTelefono */
    public FrmMantenimientoTelefono() {
        initComponents();
        setLocationRelativeTo(null);
        actualizar_descripcion();
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_descripcion = new javax.swing.JTextField();
        btn_consultar = new javax.swing.JButton();
        cb_tipo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_resultado = new javax.swing.JTable();
        btn_ingresar = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FORMULARIO MANTENIMIENTO TELEFONO");

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultar.png"))); // NOI18N
        btn_consultar.setText("CONSULTAR");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        cb_tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODOS", "ID TELEFONO", "CODIGO", "MARCA", "MODELO", "DESCRIPCION", "PRECIO" }));
        cb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_tipoActionPerformed(evt);
            }
        });

        Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID TELEFONO", "CODIGO", "MARCA", "MODELO", "DESCRIPCION", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tb_resultado);

        btn_ingresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ingresar.png"))); // NOI18N
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });

        btn_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar.png"))); // NOI18N
        btn_editar.setText("EDITAR");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono-buscar.png"))); // NOI18N
        jButton1.setText("CONSULTAR IMAGENES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btn_editar, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, 0, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 public void consultar_telefono(){
this.btn_consultarActionPerformed(null);
}    
    
    
    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.DARK_GRAY);
        FrmIngresarTelefono frm = new FrmIngresarTelefono(this); // falla tecnica xD
        frm.setVisible(true);
    }//GEN-LAST:event_btn_ingresarActionPerformed
private void actualizarTabla(ArrayList registros){
    Object[][] registros2 = new Object[registros.size()][6];

    for(int i=0;i<registros.size();i++){
        Telefono t = (Telefono)registros.get(i);
   
        registros2[i][0]= t.getId_telefono();
        registros2[i][1]= t.getCodigo();
        registros2[i][2]= t.getMarca();
        registros2[i][3]= t.getModelo();
        registros2[i][4]= t.getDescripcion();
        registros2[i][5]= t.getPrecio();
        
    }

Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
            registros2,
            new String [] {
                "ID TELEFONO","CODIGO", "MARCA", "MODELO", "DESCRIPCION", "PRECIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false,false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

}



    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
   this.getContentPane().setBackground(Color.lightGray);       
   limpiar_Tb_resultado();

   if(registroValido()){
    String descripcion1 = this.txt_descripcion.getText();
    String tipo = this.cb_tipo.getSelectedItem().toString();

    Conexion c = new Conexion();
    try{
        c.conectar();
        ArrayList telefono = c.consultarTelefonos(descripcion1,tipo);
        actualizarTabla(telefono);
    }catch(Exception e){

    }
    }  
    }//GEN-LAST:event_btn_consultarActionPerformed

 private boolean seleccionEditarValida(){
    if(Tb_resultado.getSelectedRowCount()!=1){
        JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR SOLO UN REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;  
    }
    return true;
}
 
 
private boolean seleccionEliminarValida(){
    if(Tb_resultado.getSelectedRowCount()==0){
        JOptionPane.showMessageDialog(null, "SELECCIONE POR LO MENOS UN REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    String[] opciones = new String[] {"SI", "NO"};
    int opcion = JOptionPane.showOptionDialog(null, "ESTA SEGURO QUE DESEA ELIMINAR LOS REGISTROS SELECCIONADOS???", "SALIR",
        JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
        null, opciones, opciones[1]);
    if(opcion==0){
        return true;
    }else{
        return false;
    }
}   
    
    
    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        if(seleccionEditarValida()){
        String codigo = this.Tb_resultado.getValueAt(this.Tb_resultado.getSelectedRow(),0).toString();
        FrmEditarTelefono frm = new FrmEditarTelefono(codigo,this);
        frm.setVisible(true);
    }
                              
    }//GEN-LAST:event_btn_editarActionPerformed

 private boolean registroValido(){

    String tipo = this.cb_tipo.getSelectedItem().toString();
    String descripcion1 = this.txt_descripcion.getText();
                
    if(!tipo.equals("TODOS")){
       if(descripcion1.equals("")){
            JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA DESCRIPCION", "ERROR", JOptionPane.ERROR_MESSAGE);

       return false;
       }
        
    } return true;

}  
 
private void actualizar_descripcion(){
    String tipo = this.cb_tipo.getSelectedItem().toString();
    this.txt_descripcion.setText(null);
    if(tipo.equals("TODOS"))
        this.txt_descripcion.setEditable(false);
    else
        this.txt_descripcion.setEditable(true);
}

public void limpiar_Tb_resultado(){
    Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},new String [] {"ID TELEFONO","CODIGO", "MARCA", "MODELO", "DESCRIPCION", "PRECIO"}
            ){boolean[] canEdit = new boolean [] {false,false, false, false, false,false};public boolean isCellEditable(int rowIndex, int columnIndex){return canEdit [columnIndex];}});

}


  
    
    
    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        this.getContentPane().setBackground(Color.black);
        if(seleccionEliminarValida()){
        String codigo = "";
        int [] indices = this.Tb_resultado.getSelectedRows();
            for(int i=0; i< indices.length; i++){
                String codigo1 = this.Tb_resultado.getValueAt(indices[i],0).toString();
                codigo = codigo + "'"+codigo1+"',";
                
            }
          System.out.println(codigo);
            codigo = codigo.substring(0,codigo.length()-1);
                try{
                    Conexion c = new Conexion();
                    c.conectar();
                    if(c.eliminarTelefono(codigo)){
                        JOptionPane.showMessageDialog(null, "SE REALIZO LA ELIMINACION CON EXITO", "EXITO", JOptionPane.INFORMATION_MESSAGE);
                        this.btn_consultarActionPerformed(null);

                    }else{
                        JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA ELIMINACION", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR EN LA CONEXION", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
    }
            
        
    }//GEN-LAST:event_btn_eliminarActionPerformed

private void cb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_tipoActionPerformed
limpiar_Tb_resultado();
actualizar_descripcion();
    
}//GEN-LAST:event_cb_tipoActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.getContentPane().setBackground(Color.CYAN);
        FrmConsultarImagenTelefono frm = new FrmConsultarImagenTelefono();
    frm.setVisible(true);
    
}//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tb_resultado;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JComboBox cb_tipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables
}

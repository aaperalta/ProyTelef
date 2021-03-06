/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmConsultarFactura.java
 *
 * Created on 19-dic-2013, 11:08:53
 */
package formularios;
import bd.Conexion;
import entidades.Detalle_Factura;
import java.awt.Color;
import java.util.ArrayList;


/**
 *
 * @author and1_p
 */
public class FrmConsultarFactura extends javax.swing.JFrame {

    /** Creates new form FrmConsultarFactura */
    public FrmConsultarFactura() {
        this.getContentPane().setBackground(Color.gray);  
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_resultado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultar.png"))); // NOI18N
        btn_consultar.setText("CONSULTAR");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID FACTURA", "ID TELEFONO", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tb_resultado);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/respaldo icon.png"))); // NOI18N
        jButton1.setText("RESPALDAR");
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
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
       
       limpiar_Tb_resultado();

       Conexion c = new Conexion();
        try{
            c.conectar();
            ArrayList detalle_fa = c.consultarDetale_factura();
            actualizarTabla(detalle_fa);
        }catch(Exception e){

        }
    
}//GEN-LAST:event_btn_consultarActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

   FrmRespaldo frm = new  FrmRespaldo();
   frm.setVisible(true);
    
}//GEN-LAST:event_jButton1ActionPerformed

private void actualizarTabla(ArrayList registros){
        Object[][] registros2 = new Object[registros.size()][5];

        for(int i=0;i<registros.size();i++){

            Detalle_Factura fa = (Detalle_Factura)registros.get(i);

            registros2[i][0]= fa.getId_factura();
            registros2[i][1]= fa.getId_telefono();
            registros2[i][2]= fa.getCantidad();
            registros2[i][3]= fa.getPrecio();
            registros2[i][4]= fa.getTotal();
        
    }

Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
            registros2,
            new String [] {
                "ID FACTURA", "ID TELEFONO", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

}

 public void consultar_detalle_factura(){
this.btn_consultarActionPerformed(null);
}  



 public void limpiar_Tb_resultado(){
        Tb_resultado.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},new String [] {"ID FACTURA", "ID TELEFONO", "CANTIDAD", "PRECIO", "TOTAL"}
                ){boolean[] canEdit = new boolean [] {false, false, false, false,false};public boolean isCellEditable(int rowIndex, int columnIndex){return canEdit [columnIndex];}});

}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tb_resultado;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

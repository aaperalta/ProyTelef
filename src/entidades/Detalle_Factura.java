/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author VR
 */
public class Detalle_Factura {
    private int id_det_factura;
    private int id_factura;
    private int id_telefono;
    private int cantidad;
    private float precio;
    private float total;
    
     public Detalle_Factura() {
    }

    public Detalle_Factura(int id_det_factura, int id_factura, int id_telefono, int cantidad, float precio, float total) {
        this.id_det_factura = id_det_factura;
        this.id_factura = id_factura;
        this.id_telefono = id_telefono;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    
     public Detalle_Factura( int id_factura, int id_telefono, int cantidad, float precio, float total) {
        
        this.id_factura = id_factura;
        this.id_telefono = id_telefono;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
     
     
    
    
    public int getId_det_factura() {
        return id_det_factura;
    }

    
    public void setId_det_factura(int id_det_factura) {
        this.id_det_factura = id_det_factura;
    }

    /**
     * @return the id_factura
     */
    public int getId_factura() {
        return id_factura;
    }

    /**
     * @param id_factura the id_factura to set
     */
    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    /**
     * @return the id_producto
     */
    public int getId_telefono() {
        return id_telefono;
    }

    /**
     * @param id_producto the id_producto to set
     */
    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
    }
    
}

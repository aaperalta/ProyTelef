/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Date;

/**
 *
 * @author VR
 */
public class Factura {
    private int id_factura;
    private String codigo;
    private int id_cliente;
    private String fecha;
    private float subtotal;
    private float iva;
    private float total;

    public Factura() {
    }

    public Factura(int id_factura, String codigo, int id_cliente,String fecha,float subtotal, float iva,  float total) {
        this.id_factura = id_factura;
        this.codigo = codigo;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.total = iva;
        this.total = total;
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
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the total
     */
    public float getIva() {
        return iva;
    }

    /**
     * @param total the total to set
     */
    public void setIva(float iva) {
        this.iva = iva;
    }
    
     public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param total the total to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
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

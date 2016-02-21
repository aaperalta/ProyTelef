/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Alecksander
 */
public class Cliente {
    private String id_cliente;
    private String identificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    
    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, String direccion, String telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Cliente(String id_cliente, String identificacion, String nombre, String direccion, String telefono) {
        this.id_cliente = id_cliente;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     public void imprimirInfoCliente(){
        System.out.println("----------------------");
        System.out.println("IDENTIFICACION: "+identificacion);
        System.out.println("NOMBRE: "+nombre);
        System.out.println("DIRECCION: "+direccion);
        System.out.println("TELEFONO: "+telefono);    
    }
}

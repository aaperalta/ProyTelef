/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author VR
 */
public class Usuario {
    private String id_usuario;
    private String clave;
    private char estado;
    private char rol; 
    private String fecha_creacion;
 
    public Usuario(String id_usuario, String clave, char estado, char rol,String fecha_creacion) {
        this.id_usuario = id_usuario;
        this.clave = clave;
        this.estado = estado;
        this.rol = rol;
        this.fecha_creacion = fecha_creacion;
    }

    public Usuario() {
    
    }

    
    /**
     * @return the id_usuario
     */
    
    
    
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @return the rol
     */
    public char getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(char rol) {
        this.rol = rol;
    }
    
     public  String getFecha_Creacion() {
        return fecha_creacion;
    }

    public void setFecha_Creacion( String fecha) {
        this.fecha_creacion = fecha;
    } 
    
    
}

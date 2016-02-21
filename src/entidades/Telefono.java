/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author VR
 */
public class Telefono {
    private int id_telefono;
    private int codigo;
    private String marca;
    private String modelo;
    private String descripcion;
    private float precio;
     private File imagen;
    
    
    public Telefono(){
    
    }
   
    
    public Telefono(int id_telefono,int codigo, String marca, String modelo, String descripcion, float precio) {
        
        this.id_telefono = id_telefono;
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
  
    }
    
    public Telefono(int id_telefono, String marca, String modelo, String descripcion, float precio) {
        
        this.id_telefono = id_telefono;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;

    }
    
    public Telefono(int codigo, String marca, String modelo, String descripcion, float precio,File imagen ) {
        
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
         this.imagen = imagen;

    }
     
 
     public int getId_telefono() {
        return id_telefono;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }
  
       
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    
    public File getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(File imagen) {
        this.imagen = imagen;
    }
    
    
    public void imprimirInfoTelefono(){
        System.out.println("----------------------");
        System.out.println("CODIGO: "+codigo);
        System.out.println("MARCA: "+marca);
        System.out.println("MODELO: "+modelo);
        System.out.println("DESCRIPCION: "+descripcion);
        System.out.println("PRECIO: "+precio);    
    }
    
    public static Telefono obtenerProductoPorId(ArrayList telefonos, int id_telefono){
           
           for(int i=0; i<telefonos.size(); i++){
               Telefono t = (Telefono)telefonos.get(i);
               if(t.getId_telefono()== id_telefono )
                   return t;
           }
           return null; 
    }
    
}

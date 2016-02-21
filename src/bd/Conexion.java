package bd;

import entidades.Cliente;
import entidades.Detalle_Factura;
import entidades.Factura;
import entidades.Telefono;
import entidades.Usuario;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    
       private Connection c;
       private static final String DRIVER = "com.mysql.jdbc.Driver";
       private static final String DBMS = "mysql";
       private static final String HOST = "127.0.0.1";
       private static final String PORT = "3306";
       private static final String DATABASE = "base_telefono";
       private static final String USER = "root";
       private static final String PASSWORD = "";

    void Conexion(){}
    
    /*METODO CONECTAR*/
   
    public void conectar ()throws Exception{
        try {
            Class.forName(DRIVER);
        }catch(ClassNotFoundException ce){
        }
        
            try{
                this.c = DriverManager.getConnection("jdbc:" + DBMS + "://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);                
            }catch(SQLException exception){
                System.out.println("ERROR: NO SE PUDO CONECTAR CON LA BASE DE DATOS: "+exception);
            } 
        System.out.println("CONEXION EXITOSA CON LA BASE DE DATOS");
    }
    
    public boolean desconectar()
    {
        try
        {
            this.c.close();
            return(true);
        }
        catch(Exception e)
        {
            return(false);
        }    
    }
    
    
    
    
    
     
///////////////////////// CONSULTA DE IMAGEN///////////////////////////////////   
    
    
 public Image obtenerImgProducto(int id_producto){
        Image resultado = null;

        try
        {
            PreparedStatement st = null;
            ResultSet rs = null; 
            
            st = c.prepareStatement("SELECT * FROM telefono WHERE id_telefono = ?");            
            st.setInt(1,id_producto);
            rs = st.executeQuery();            
            if(rs.next())
            {
                byte[] imagen = rs.getBytes("imagen") ;
                resultado = Toolkit.getDefaultToolkit().createImage(imagen);                                
            }            
            st.close();         
        }
        catch(Exception e){System.out.println(e);}
        return resultado;                
    }    
    
    
    
    
///////////////////////// INGRESAR TELEFONO///////////////////////////////////    
    
    public boolean ingresarTelefono(Telefono t)
    {
        try
        {
                PreparedStatement st = null;
                FileInputStream fis = new FileInputStream(t.getImagen());
                st = c.prepareStatement("INSERT INTO telefono(codigo,marca,modelo,descripcion,precio,imagen) VALUES(?,?,?,?,?,?) ");            
                st.setInt(1,t.getCodigo());
                st.setString(2,String.valueOf(t.getMarca()));
                st.setString(3,String.valueOf(t.getModelo()));
                st.setString(4,t.getDescripcion());
                st.setFloat(5,t.getPrecio());
                st.setBinaryStream(6,(InputStream)fis);
                st.executeUpdate();
                st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }        
    }
////////////////////////////ingresarUsuario///////////////////////////////////////////////////
 
         public boolean ingresarUsuario(Usuario u)
    {
        try
        {
                PreparedStatement st = null;
                st = c.prepareStatement("INSERT INTO usuario (id_usuario,clave,estado,rol) VALUES(?,md5(?),?,?) ");            
                st.setString(1,u.getId_usuario());
                st.setString(2,u.getClave());               
                st.setString(3,String.valueOf(u.getEstado()));
                st.setString(4,String.valueOf(u.getRol()));                
                st.executeUpdate();
                st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }      
    }

//////////////////////////consultarTelefonos////////////////////////////////////////
  public ArrayList consultarTelefonos()
    {
        ArrayList resultado = new ArrayList();
        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;
            rs = st.executeQuery("SELECT * FROM telefono");
            while(rs.next()){
              
                int id_telefono = rs.getInt("id_telefono");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
          
                float precio = rs.getFloat("precio");                   
                resultado.add(new Telefono(id_telefono, marca, modelo, descripcion, precio));
                
            }
            rs.close();
            st.close();                                                 
        }
        catch(Exception e){System.out.println(e);}
     return (resultado);
    }
         
         //////////////////////////CONSULTAR USUARIO////////////////////////////////////////////////////    
         public ArrayList consultarUsuarioporid()
    {
        ArrayList usuario = new ArrayList();
        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;         
                rs = st.executeQuery("SELECT * FROM usuario;");
      while(rs.next())
            {
                String id_usuario = rs.getString("id_usuario");
                String clave = rs.getString("clave");
                char estado = rs.getString("estado").charAt(0);
                char rol = rs.getString("rol").charAt(0);
                String fecha = rs.getString("fecha_creacion");
                Usuario u = new Usuario(id_usuario,clave,estado,rol,fecha);
                usuario.add(u);
            }
        }catch(Exception e){System.out.println(e);}
     return(usuario);
    }
///////////////////////ELIMINAR USUARIO/////////////////////////////////// 
     public boolean eliminarUsuario(String id)
    {
        try
        {
            Statement st = this.c.createStatement();
            String sql = "DELETE FROM Usuario WHERE id_usuario IN ("+id+")";
            int num_regs = st.executeUpdate(sql);
            System.out.println(num_regs);
            if(num_regs>=1)
                return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    }
    ///////////////////////CONSULTAR TELEFONO///////////////////////////////////   
    
   public ArrayList consultarTelefonos(String descripcion1, String tipo)
    {
        ArrayList telefono = new ArrayList();

        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;  
            
            if(tipo.equalsIgnoreCase("TODOS")){
                rs = st.executeQuery("SELECT * FROM telefono;");  
           }else if(tipo.equalsIgnoreCase("PRECIO")){
                rs = st.executeQuery("SELECT * FROM telefono WHERE "+tipo.toLowerCase()+" = "+descripcion1+";"); 
            }else{
                rs = st.executeQuery("SELECT * FROM telefono WHERE "+tipo.toLowerCase()+" LIKE '%"+descripcion1+"%';");
            }

                        
            while(rs.next())
            {
                int id_telefono = rs.getInt("id_telefono");
                int codigo = rs.getInt("codigo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                
                Telefono t = new Telefono(id_telefono,codigo, marca, modelo, descripcion, precio);
                telefono.add(t);
            }
        }
        catch(Exception e){System.out.println(e);}
     return(telefono);
    }  
   
   
   
   public ArrayList consultarDetale_factura()
    {
        ArrayList detalle_f = new ArrayList();

        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;         
            rs = st.executeQuery("SELECT * FROM det_factura;");                       
            while(rs.next())
            {
                int id_factura = rs.getInt("id_factura");
                int id_telefono = rs.getInt("id_telefono");
                int cantidad = rs.getInt("cantidad");
                float precio = rs.getFloat("precio");
                float total = rs.getFloat("total");  
                Detalle_Factura t = new Detalle_Factura(id_factura, id_telefono, cantidad, precio, total);              
                detalle_f.add(t);
            }
        }
        catch(Exception e){System.out.println(e);}
     return(detalle_f);
    } 
   
   
   public ArrayList consultarDetale_facturaPorID(String codigo2)
    {
        ArrayList telefonos = new ArrayList();
        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;         
                rs = st.executeQuery("SELECT * FROM det_factura WHERE id_factura IN ("+codigo2+")");
      while(rs.next())
            {
                int id_factura = rs.getInt("id_factura");
                int id_telefono = rs.getInt("id_telefono");
                int cantidad = rs.getInt("cantidad");
                float precio = rs.getFloat("precio");
                float total = rs.getFloat("total");
                
                Detalle_Factura dt = new Detalle_Factura(id_factura,id_telefono,cantidad, precio, total);
                telefonos.add(dt);
            }
        }catch(Exception e){System.out.println(e);}
     return(telefonos);          
    }
   
    
 
   
///////////////////////////////////////////////////////////////////////////////
/////////////////////////CONSULTAR USUARIO/////////////////////////////////////
   
public ArrayList consultarUsuario (String descripcion1, String tipo)
    {
        ArrayList usuario = new ArrayList();

        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;  
            
            if(tipo.equalsIgnoreCase("TODOS")){
                rs = st.executeQuery("SELECT * FROM usuario;");  //ORDER BY Edad DESC
           }else if(tipo.equalsIgnoreCase("PRECIO")){
                rs = st.executeQuery("SELECT * FROM usuario WHERE "+tipo.toLowerCase()+" = "+descripcion1+";");  //ORDER BY "+tipo.toLowerCase()+" DESC
            }else{
                rs = st.executeQuery("SELECT * FROM usuario WHERE "+tipo.toLowerCase()+" LIKE '%"+descripcion1+"%';"); //ORDER BY "+tipo.toLowerCase()+" DESC
            }

                        
            while(rs.next())
            {
                String id_usuario = rs.getString("id_usuario");
                String clave = rs.getString("clave");
                char estado = rs.getString("estado").charAt(0);
                char rol = rs.getString("rol").charAt(0);
                String fecha = rs.getString("fecha_creacion");                 
                Usuario u = new Usuario(id_usuario,clave, estado, rol, fecha);
                usuario.add(u);
            }
        }
        catch(Exception e){System.out.println(e);}
     return(usuario);
    }  
    
    ///////////////////////EDITAR TELEFONO///////////////////////////////////    
    
    public boolean modificarTelefono(Telefono t)
    {
        try
        {
            PreparedStatement st = null;
            st = c.prepareStatement("UPDATE telefono SET marca = ?, modelo = ?, descripcion = ?, precio = ? WHERE codigo = ?");                        
            
            st.setString(1,String.valueOf(t.getMarca()));
            st.setString(2,String.valueOf(t.getModelo()));
            st.setString(3,t.getDescripcion());
            st.setFloat(4,t.getPrecio());
            st.setInt(5,t.getCodigo());
            
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }   
///////////////////////////////////////////////////////////////////////////////
 public boolean modificarUsuario1(Usuario u)
    {
        try
        {
            PreparedStatement st = null;
        
            st = c.prepareStatement("UPDATE Usuario SET nombres = ?, apellidos = ?, tipo = ?, estado = ? WHERE id_usuario = ?");
                       
                st.setString(1,String.valueOf(u.getEstado()));
                st.setString(2,String.valueOf(u.getRol()));
                st.setString(3,u.getId_usuario());
          
                        
            st.executeUpdate();
            st.close(); 
            
            
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }
 
  public boolean modificarUsuario2(Usuario u)
    {
        try
        {
            PreparedStatement st = null;
        
            st = c.prepareStatement("UPDATE usuario SET clave = md5(?),estado = ?, rol = ?  WHERE id_usuario = ?");
          
               st.setString(1,u.getClave()); 
               st.setString(3,String.valueOf(u.getEstado()));
               st.setString(2,String.valueOf(u.getRol()));             
               st.setString(4,u.getId_usuario());
          
                        
            st.executeUpdate();
            st.close(); 
            
            
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }
    
///////////////////////ELIMINAR  TELEFONO/////////////////////////////////////
    
    public boolean eliminarTelefono(String t)
    {
        try
        {
            Statement st = this.c.createStatement();
            String sql = "SELECT * FROM sucursal WHERE codigo IN ("+t+")";
            int num_regs = st.executeUpdate(sql);
            System.out.println(num_regs);
            if(num_regs>=1)
                return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        return false;
        
               
    }
    
    
    public ArrayList consultarTelefonoPorID(String codigo2)
    {
        ArrayList telefonos = new ArrayList();
        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;         
                rs = st.executeQuery("SELECT * FROM telefono WHERE codigo IN ("+codigo2+")");
      while(rs.next())
            {
                int codigo = rs.getInt("codigo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                
                Telefono t = new Telefono(codigo, marca,modelo, descripcion, precio);
                telefonos.add(t);
            }
        }catch(Exception e){System.out.println(e);}
     return(telefonos);          
    } 
/////////////////////////////////////////////////////////////////////////////
    
    public boolean esUsuarioValido(Usuario u)
    {        
        boolean resultado = false;
        ResultSet rs = null;                       
        PreparedStatement st = null;
        try
        {            
            st = c.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ? AND clave = md5(?) AND estado = ?");            
            st.setString(1,u.getId_usuario());         
            st.setString(2,u.getClave());
            st.setString(3,"A");
            rs = st.executeQuery();            
            if(rs.next()){
                u.setRol(rs.getString("rol").charAt(0));
                resultado = true;
            } 
            
            rs.close();
            st.close();
        }
        catch(Exception e){
            System.out.println(e);
            resultado = false;
        }           
     return resultado; 
    }
    
    

      ///////////////////////// INGRESAR CLIENTE///////////////////////////////////    
    
    public boolean ingresarCliente(Cliente cl)
    {
        try
        {
                PreparedStatement st = null;
                st = c.prepareStatement("INSERT INTO cliente(identificacion,nombre,direccion,telefono) VALUES(?,?,?,?) ");            
                st.setString(1,cl.getIdentificacion());
                st.setString(2,cl.getNombre());
                st.setString(3,cl.getDireccion());
                st.setString(4,cl.getTelefono());
                st.executeUpdate();
                st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }        
    }
///////////////////////////////////////////////////////////////////////////////
   ///////////////////////CONSULTAR CLIENTE///////////////////////////////////   
    
   public ArrayList consultarCliente(String descripcion1, String tipo)
    {
        ArrayList cliente = new ArrayList();

        try
        {
            Statement st = this.c.createStatement();
            ResultSet rs = null;  
            
            if(tipo.equalsIgnoreCase("TODOS")){
                rs = st.executeQuery("SELECT * FROM cliente;");  
           }else{
                rs = st.executeQuery("SELECT * FROM cliente WHERE "+tipo.toLowerCase()+" LIKE '%"+descripcion1+"%';");
				}
		   
            while(rs.next())
            {
                String id_cliente = rs.getString("id_cliente");
                String identificacion = rs.getString("identificacion");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                
          
                
                               
                Cliente cl = new Cliente(id_cliente,identificacion,nombre,direccion,telefono);
                cliente.add(cl);
            }
        }
        catch(Exception e){System.out.println(e);}
     return(cliente);
    }          
/////////////////////////////////////////////////////////////////////////////////
     ///////////////////////EDITAR CLIENTE//////////////////////////////////////    
    
    public boolean modificarCliente(Cliente cl)
    {
        try
        {
            PreparedStatement st = null;
            st = c.prepareStatement("UPDATE cliente SET nombre = ?, direccion = ?, telefono = ? WHERE identificacion = ?");                        
            
            st.setString(1,cl.getNombre());
            st.setString(2,cl.getDireccion());
            st.setString(3,cl.getTelefono());
            st.setString(4,cl.getIdentificacion());
            
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }   
///////////////////////////////////////////////////////////////////////////////

    
///////////////////////ELIMINAR  CLIENTE/////////////////////////////////////
    
    public boolean eliminarCliente(String c)
    {
        
        
        try
        {
            Statement st = this.c.createStatement();
            String sql = "DELETE FROM cliente WHERE identificacion IN ("+c+")";
            int num_regs = st.executeUpdate(sql);
            System.out.println(num_regs);
            if(num_regs>=1)
                return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        return false;
        
               
    }

    public ArrayList consultarTelefonos(Object object) {
        ArrayList resultado = new ArrayList();
        ResultSet rs = null;                               
        try
        {
            Statement st = this.c.createStatement();
            rs = st.executeQuery("SELECT * FROM producto WHERE stock > 0");            
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String marca = rs.getString("marca");
                String modelo = rs.getString("marca");
                String descripcion = rs.getString("marca");
                float precio = rs.getFloat("precio");       
              
                resultado.add(new Telefono(codigo,marca,modelo,descripcion,precio));
                
            }
            rs.close();
            st.close();                                                 
        }
        catch(Exception e){System.out.println(e);}
     return resultado;
    }
    /////////////////////////////////////////////////////////
    //////////PROCESAR VENTA PARA INGRESARLA////////////////
    
    public boolean procesarVenta(Factura f, ArrayList<Detalle_Factura> d){
        
        boolean resultado = true;
        
        try{
            this.c.setAutoCommit(false); 
            
            PreparedStatement st = null;
            st = c.prepareStatement("INSERT INTO factura(codigo,id_cliente,subtotal,iva,total) VALUES(?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,f.getCodigo());
            st.setInt(2,f.getId_cliente());
            st.setFloat(3,f.getSubtotal()); 
            st.setFloat(4,f.getIva()); 
            st.setFloat(5,f.getTotal());
            st.executeUpdate();
            
            
            ResultSet pk = st.getGeneratedKeys();
            while (pk.next()) {
                f.setId_factura(pk.getInt(1));
            }            
            st.close();
            
            for(int i=0;i<d.size();i++){
                
                Detalle_Factura df = (Detalle_Factura)d.get(i);
                PreparedStatement st2 = null;
                st2 = c.prepareStatement("INSERT INTO det_factura(id_factura,id_telefono,cantidad,precio,total) VALUES(?,?,?,?,?) ");            
                st2.setInt(1,f.getId_factura());
                st2.setInt(2,df.getId_telefono());         
                st2.setInt(3,df.getCantidad());
                st2.setFloat(4,df.getPrecio());
                st2.setFloat(5,df.getTotal());
                st2.executeUpdate();
                
                st2.close(); 
                
            }
            
            
            
            this.c.commit();
        }catch(Exception e){
            System.out.println(e.toString());
            resultado = false;
            try{
                this.c.rollback();
            }catch(SQLException ex){}
        }                                        
    
        return resultado;
    }
    
}

package bd;
import entidades.Detalle_Factura;
import java.sql.*;
import java.util.ArrayList;

public class Conexion1 {
    
       private Connection c;
       private static final String DRIVER = "com.mysql.jdbc.Driver";
       private static final String DBMS = "mysql";
       private static final String HOST = "127.0.0.1";
       private static final String PORT = "3306";
       private static final String DATABASE = "base_telefono2";
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
    

   
//////////////////////////////////////////// 
 //////////////////////////////////////////// 
  //////////////////////////////////////////// 
   //////////////////////////////////////////// 
   //////////////////////////////////////////// 
   
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

   
   public boolean ingresarDetalleFacturas(Detalle_Factura dt)
    {
        try
        {
                PreparedStatement st = null;
                st = c.prepareStatement("INSERT INTO det_factura(id_factura,id_telefono,cantidad,precio,total) VALUES(?,?,?,?,?) ");            
                
                st.setInt(1,dt.getId_factura());
                st.setInt(2,dt.getId_telefono());
                st.setInt(3,dt.getCantidad());
                st.setFloat(4,dt.getPrecio());
                st.setFloat(5,dt.getTotal());
                
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
   
   
   
} 
   
   
   
   
  
   
   
   
  

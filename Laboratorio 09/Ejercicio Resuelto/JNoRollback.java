/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JNoRollback {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = Database.getConnection();
        PreparedStatement stmt1=null;
        PreparedStatement stmt2=null;
        
        try {
            stmt1 = connection.prepareStatement("INSERT INTO miTabla VALUES( ?, ? );");
            stmt2 = connection.prepareStatement("INSERT INTO miOtraTabla VALUES( ?, ?, ? );");
            
            System.out.println( "Primer INSERT tabla [miTabla] " );
            
            stmt1.setString(1, "000001");
            stmt1.setString(2, "micorreo@mail.com");
            stmt1.executeUpdate();
            
            System.out.println( "Segundo INSERT tabla [miTabla] " );
            stmt1.setString(1, "000002");
            stmt1.setString(2, "amayuya@mail.com");
            stmt1.executeUpdate();
            
            System.out.println( "Tercer INSERT tabla [miTabla] " );
            stmt1.setString(1, "000003");
            stmt1.setString(2, "diosdado@mail.com");
            stmt1.executeUpdate();
            
            System.out.println( "Primer INSERT tabla [miOtraTabla]" );
            stmt2.setString(1, "Juan");
            stmt2.setString(2, "Perez");
            stmt2.setString(3, "Hola soy un error");//Tipo de dato INCORRECTO
            stmt2.executeUpdate();
        }catch(SQLException ex) {
            System.err.println("ERROR: " + ex.getMessage());
        }finally{
            System.out.println( "cierra conexion a la base de datos" );
            try{
                if(stmt1!=null) stmt1.close();
                if(stmt2!=null) stmt2.close();
                if(connection!=null) connection.close();
                
            }catch (SQLException ex) {
            System.err.println( ex.getMessage() );
            }
        }
    }
}

package abccsqlit;

import abccsqlite.Conexion.ConexionBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Felipe
 */
public class AbccSqlit {


    public static void main(String[] args) {
        
        insert("a", "b");
        
    }
    
    private static void insert(String firstName, String secondName) {
  Connection con = ConexionBase.connect();
  PreparedStatement ps = null; 
  try {
    String sql = "INSERT INTO inicio(nombre, numero) VALUES(?,?) ";
    ps = con.prepareStatement(sql);
    ps.setString(1, firstName);
    ps.setString(2, secondName);
    ps.execute();
    System.out.println("Data has been inserted!");
  } catch(SQLException e) {
    System.out.println(e.toString());
    // always remember to close database connections
  } finally {
    try{
      ps.close();
      con.close();
    } catch(SQLException e) {
      System.out.println(e.toString());
    }
    
  }
}
    
}

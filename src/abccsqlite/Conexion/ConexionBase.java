package abccsqlite.Conexion;

/**
 *
 * @author Felipe
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBase {
    public static Connection con; 
    public static Connection getconn() {
    if (con == null){
        try {
   
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:C:/Users/Felipe/Documents/NetBeansProjects/AbccSqlit/src/BaseDatos.db"); // connecting to our database
      System.out.println("Connected!");
    } catch (ClassNotFoundException | SQLException e ) {
     
      System.out.println(e+"");
    }
    }
    
    
    return con; 
  }
}

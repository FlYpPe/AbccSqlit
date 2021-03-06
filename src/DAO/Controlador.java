package DAO;

import abccsqlite.Conexion.ConexionBase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class Controlador {

    public static void editarView(String clientNo, String propertyNo, String viewDate, String comment) {
        Connection con = ConexionBase.getconn();
        PreparedStatement ps = null;
        try {

            String sql = "UPDATE views set clientNo = ?, viewDate = ?, comment = ?  WHERE propertyNo = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(4, propertyNo);
            ps.setString(2, viewDate);
            ps.setString(3, comment);
            ps.setInt(1, Integer.parseInt(clientNo));
            ps.execute();
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    public static void borrarView(String propertyNo) {
        Connection con = ConexionBase.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM views where propertyNo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, propertyNo);
            ps.execute();
        } catch (SQLException e) {

        }

    }

    public static void insertarView(String clientNo, String propertyNo, String viewDate, String comment) {
        Connection con = ConexionBase.getconn();

        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO views(clientNo, propertyNo, viewDate, comment) VALUES(?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(clientNo));
            ps.setString(2, propertyNo);
            ps.setString(3, viewDate);
            ps.setString(4, comment);
            ps.execute();
        } catch (SQLException e) {
        }
    }

    public static void editarCliente(String fName, String lName, String telNo, String prefType, String maxRent, String clientNo) {
        Connection con = ConexionBase.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE Client set fName = ?, lName = ?, telNo = ?, prefType = ?, maxRent = ?  WHERE clientNo = ? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, telNo);
            ps.setString(4, prefType);
            ps.setInt(5, Integer.parseInt(maxRent));
            ps.setInt(6, Integer.parseInt(clientNo));
            ps.execute();
        } catch (SQLException e) {
            // TODO: handle exception
        }
    }

    public static void borrarCliente(String clientNo) {
        Connection con = ConexionBase.getconn();
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM Client where clientNo = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(clientNo));
            ps.execute();
        } catch (SQLException e) {
            // always remember to close database connections
        }

    }

    public static void insertarCliente(String fName, String lName, String telNo, String prefType, String maxRent) {
        Connection con = ConexionBase.getconn();

        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO client(fName, lName, telNo, prefType, maxRent) VALUES(?,?,?,?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, telNo);
            ps.setString(4, prefType);
            ps.setInt(5, Integer.parseInt(maxRent));
            ps.execute();
        } catch (SQLException e) {
            // always remember to close database connections
        }
    }

    public static ResultSet buscarRegistro(String sql) throws SQLException {

        PreparedStatement ps = ConexionBase.getconn().prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();

        return rs;

    }

    public static void ingresarRegistro(String sql) {
        
        Connection con = ConexionBase.getconn();
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement(sql);
            
            ps.execute();
           
        } catch (SQLException e) {
          
        }

    }

    public static boolean validar(String sql, String passw) throws SQLException {

        PreparedStatement ps = ConexionBase.getconn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String pass = "";
        while (rs.next()) {
            pass = rs.getString("pass");

        }
        if (passw.equals(pass)) {
            return true;
        }
        return false;

    }

    public static boolean revisarexitencia(String sql) throws SQLException {

        PreparedStatement ps = ConexionBase.getconn().prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Registro existente");
            
            return false;
        }
        
        return true;
    }

}

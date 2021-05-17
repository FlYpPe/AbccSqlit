/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import abccsqlite.Conexion.ConexionBase;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class Controlador {

    public static void agregarRegistro(String idOrden, String fecha, String cantidad, String tipoPago, String idMesero) throws SQLException {

        

    }

    public static void modificarRegistro(String idOrden, String fecha, String cantidad, String tipoPago, String idMesero) throws SQLException {

        

    }

    public static void eliminarRegistro(String idOrden) throws SQLException {

        
    }

    public static ResultSet buscarRegistro(String sql) throws SQLException {

        PreparedStatement ps = ConexionBase.getconn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        return rs;

    }

    public static boolean validar(String sql, String passw) throws SQLException {

        PreparedStatement ps = ConexionBase.getconn().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        String pass = "";        
        while (rs.next()) {
            String user = rs.getString("user");
            pass = rs.getString("pass");

            System.out.println("user: " + user);
            System.out.println("pass: " + pass);
           
            

        }
        System.out.println(pass);
        System.out.println(passw);
        if(passw.equals(pass)){
            System.out.println("qqqqq");
            return true;
        }
        System.out.println("false");
        return false;

    }

}

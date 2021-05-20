/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import abccsqlite.Conexion.ConexionBase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class Controlador {

    public static void agregarRegistro(String sql) throws SQLException {

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
            System.out.println("Data has been inserted!");
        } catch (SQLException e) {
            System.out.println(e.toString());
            // always remember to close database connections
        } 
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
        if (passw.equals(pass)) {
            System.out.println("qqqqq");
            return true;
        }
        System.out.println("false");
        return false;

    }

}

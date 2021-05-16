/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;

/**
 *
 * @author Felipe
 */
public class Controlador {
        public static void agregarRegistro(String idOrden, String fecha, String cantidad, String tipoPago, String idMesero)throws SQLException{

        CallableStatement entrada = Prueba.Conexión.getConexion().prepareCall("{call Insertar(?,?,?,?,?)}");
        entrada.setString(1,idOrden);
        entrada.setString(2,fecha);
        entrada.setString(3,cantidad);
        entrada.setString(4,tipoPago);
        entrada.setString(5,idMesero);
        entrada.execute();
        
        
        
    }
    
        public static void modificarRegistro(String idOrden, String fecha, String cantidad, String tipoPago, String idMesero)throws SQLException{
        

        CallableStatement entrada = Prueba.Conexión.getConexion().prepareCall("{call Cambiar(?,?,?,?,?)}");
        entrada.setString(1,idOrden);
        entrada.setString(2,fecha);
        entrada.setString(3,cantidad);
        entrada.setString(4,tipoPago);
        entrada.setString(5,idMesero);
        entrada.execute();
        
        
    }
       public static void eliminarRegistro(String idOrden)throws SQLException{
        
        CallableStatement entrada = Prueba.Conexión.getConexion().prepareCall("{call Eliminar(?)}");
        entrada.setString(1,idOrden);
        entrada.execute();
        
        
    }
       
      public static void buscarRegistro(String idOrden)throws SQLException{
        
        CallableStatement entrada = Prueba.Conexión.getConexion().prepareCall("{call BuscarReg(?)}");
        entrada.setString(1,idOrden);
        entrada.execute();
        
        
    }
}

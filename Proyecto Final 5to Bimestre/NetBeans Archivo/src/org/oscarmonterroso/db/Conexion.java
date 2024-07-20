/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.oscarmonterroso.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author oscar Esta es la clase conexion la cual sirve para la conexion de
 * neatbeans y mysql
 */
public class Conexion {
private Connection con = null;
    public static Connection conexion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Connection conexion;
    public static Conexion instancia;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda?useSSL=false", "root", "277353");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public synchronized static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}

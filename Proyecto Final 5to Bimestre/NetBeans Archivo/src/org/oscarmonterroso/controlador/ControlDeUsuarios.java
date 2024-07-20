/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.oscarmonterroso.controlador;

import org.oscarmonterroso.db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.oscarmonterroso.modelo.Usuario;

/**
 *
 * @author Oscar
 */
public class ControlDeUsuarios extends Conexion {
    
    public boolean registrar(Usuario usr)
    {
     
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        
        String sql = "INSERT INTO tbl_usuario (usuario,password,nombre,email,id_tipo) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuarios());
            ps.setString(2, usr.getPassword());
            ps.setString(3, usr.getNombre());
            ps.setString(4, usr.getEmail());
            ps.setInt(5, usr.getId_tipo());
            ps.execute();
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean login(Usuario usr) {
     
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT id, usuario, password, nombre, id_tipo FROM tbl_usuario WHERE usuario = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuarios());
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                if(usr.getPassword().equals(rs.getString(3))) {
                    
                    usr.setId(rs.getInt(1));
                    usr.setNombre(rs.getString(4));
                    usr.setId_tipo(rs.getInt(5));
                    return true;
       
                }else{
                    return false;
                }
            }
            return false;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ControlDeUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
}

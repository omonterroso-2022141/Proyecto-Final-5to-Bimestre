/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.oscarmonterroso.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.oscarmonterroso.db.Conexion;
import org.oscarmonterroso.modelo.Proveedor;



/**
 *
 * @author Oscar
 */
public class ControlDeProveedor {
    private static ArrayList<Proveedor> proveedores;
    private static ControlDeProveedor instancia = null;

    public ControlDeProveedor() {
        proveedores = new ArrayList<Proveedor>();
        enlistaProveedores();
    }

    public static ControlDeProveedor getInstancia() {
        if (instancia == null) {
            instancia = new ControlDeProveedor();
        }
        return instancia;
    }

    public void agregarProveedor(Proveedor proveedor) {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_agregar_proveedor(?,?,?);");
            sentencia.setString(1, proveedor.getProveedor());
            sentencia.setString(2, proveedor.getProducto());
            sentencia.setBoolean(3, true);
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Ha enviado los datos a la BD.");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void enlistaProveedores() {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_mostrarProveedor()");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(resultado.getInt(1));
                proveedor.setProveedor(resultado.getString(2));
                proveedor.setProducto(resultado.getString(3));
                proveedores.add(proveedor);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public int cantidadDeProveedores() {
        return proveedores.size();
    }

    public ArrayList<Proveedor> listaDeProveedores() {
        return proveedores;
    }

    private int cantidadDeRegistros(ResultSet entrada) {
        int cantidadDeRegistros = 0;
        try {
            if (entrada.last()) {
                cantidadDeRegistros = entrada.getRow();
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return cantidadDeRegistros;
    }

    public void actualizarProveedor(Proveedor proveedor) {
        try {
            int posicionEnArray = proveedores.indexOf(proveedor);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call actualizar_proveedor(?,?,?);");
            sentencia.setInt(1, proveedor.getIdProveedor());
            sentencia.setString(2, proveedor.getProveedor());
            sentencia.setString(3, proveedor.getProducto());
            sentencia.execute();
            proveedores.set(posicionEnArray, proveedor);
            JOptionPane.showMessageDialog(null, "Ha actualizado el proveedor");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void eliminarProducto(Proveedor proveedor) {
        try {
            int posicionEnArray = proveedores.indexOf(proveedor);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call eliminar_proveedor(?);");
            sentencia.setInt(1, proveedor.getIdProveedor());
            sentencia.execute();
            proveedores.set(posicionEnArray, proveedor);
            JOptionPane.showMessageDialog(null, "Ha eliminado el proveedor");

        } catch (Exception error) {
            error.printStackTrace();
        }

    }
}

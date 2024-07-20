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
import org.oscarmonterroso.modelo.Producto;

/**
 *
 * @author Oscar
 */
public class ControlModoUsuario {
        private static ArrayList<Producto> productos;
    private static ControlDeProducto instancia = null;

    public ControlModoUsuario() {
        productos = new ArrayList<Producto>();
        enlistaProductos();
    }

    public static ControlDeProducto getInstancia() {
        if (instancia == null) {
            instancia = new ControlDeProducto();
        }
        return instancia;
    }

    public void agregarProducto(Producto producto) {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_agregar_producto(?,?,?,?);");
            sentencia.setString(1, producto.getProducto());
            sentencia.setString(2, producto.getMarca());
            sentencia.setString(3, producto.getPrecio());
            sentencia.setBoolean(4, true);
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Ha enviado los datos a la BD.");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void enlistaProductos() {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_mostrarProducto()");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultado.getInt(1));
                producto.setProducto(resultado.getString(2));
                producto.setMarca(resultado.getString(3));
                producto.setPrecio(resultado.getString(4));
                productos.add(producto);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public int cantidadDeProductos() {
        return productos.size();
    }

    public ArrayList<Producto> listaDeProductos() {
        return productos;
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
    
}

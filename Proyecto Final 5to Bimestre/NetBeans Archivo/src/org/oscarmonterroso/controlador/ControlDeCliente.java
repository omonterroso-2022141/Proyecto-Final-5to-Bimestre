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
import org.oscarmonterroso.modelo.Cliente;

/**
 *
 * @author Oscar
 */
public class ControlDeCliente {
    private static ArrayList<Cliente> clientes;
    private static ControlDeCliente instancia = null;

    public ControlDeCliente() {
        clientes = new ArrayList<Cliente>();
        enlistaClientes();
    }

    public static ControlDeCliente getInstancia() {
        if (instancia == null) {
            instancia = new ControlDeCliente();
        }
        return instancia;
    }

    public void agregarCliente(Cliente cliente) {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_agregar_cliente(?,?,?,?,?,?);");
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setString(3, cliente.getDireccion());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getEmail());
            sentencia.setBoolean(6, true);
            sentencia.execute();
            JOptionPane.showMessageDialog(null, "Ha enviado los datos a la BD.");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void enlistaClientes() {
        try {
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_mostrarCliente()");
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultado.getInt(1));
                cliente.setNombre(resultado.getString(2));
                cliente.setApellido(resultado.getString(3));
                cliente.setDireccion(resultado.getString(4));
                cliente.setTelefono(resultado.getString(5));
                cliente.setEmail(resultado.getString(6));
                clientes.add(cliente);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public int cantidadDeClientes() {
        return clientes.size();
    }

    public ArrayList<Cliente> listaDeClientes() {
        return clientes;
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
    
    public void actualizarCliente(Cliente cliente) {
        try {
            int posicionEnArray = clientes.indexOf(cliente);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call actualizar_cliente(?,?,?,?,?,?);");
            sentencia.setInt(1, cliente.getIdCliente());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido());
            sentencia.setString(4, cliente.getDireccion());
            sentencia.setString(5, cliente.getTelefono());
            sentencia.setString(6, cliente.getEmail());
            sentencia.execute();
            clientes.set(posicionEnArray, cliente);
            JOptionPane.showMessageDialog(null, "Ha actualizado el cliente");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public void eliminarCliente(Cliente cliente) {
        try {
            int posicionEnArray = clientes.indexOf(cliente);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call eliminar_cliente(?);");
            sentencia.setInt(1, cliente.getIdCliente());
            sentencia.execute();
            clientes.set(posicionEnArray, cliente);
            JOptionPane.showMessageDialog(null, "Ha eliminado el cliente");

        } catch (Exception error) {
            error.printStackTrace();
        }

    }
}

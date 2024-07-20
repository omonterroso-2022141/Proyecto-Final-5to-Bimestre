/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.oscarmonterroso.modelo;

/**
 *
 * @author Oscar
 */
public class Proveedor {
    
    private int idProveedor;
    private String proveedor;
    private String producto;
    private boolean estado;
    
    public Proveedor() {
    }

    public Proveedor(int idProveedor, String proveedor, String producto, boolean estado) {
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.producto = producto;
        this.estado = estado;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.oscarmonterroso.modelo;

/**
 *
 * @author Oscar
 */
public class Producto {

    private int idProducto;
    private String producto;
    private String marca;
    private String precio;
    private boolean estado;

    public Producto() {
    }

    public Producto(int idProducto, String producto, String marca, String precio, boolean estado) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.marca = marca;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

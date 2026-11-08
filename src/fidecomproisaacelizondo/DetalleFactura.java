package fidecomproisaacelizondo;

import java.io.Serializable;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase DetalleFactura para asociar productos y cantidades en la transacción.
 */
public class DetalleFactura implements Serializable {//inicio clase DetalleFactura

    private static final long serialVersionUID = 1L;

    private Producto producto;
    private int cantidad;
    private double subtotal;

    public DetalleFactura(Producto producto, int cantidad) {//inicio método DetalleFacturaParametros
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }//fin método DetalleFacturaParametros

    public double calcularSubtotal() {//inicio método calcularSubtotal
        if (this.producto != null) {//inicio if validarProductoDetalle
            return this.producto.getPrecioUnitario() * this.cantidad;
        }//fin if validarProductoDetalle
        return 0.0;
    }//fin método calcularSubtotal

    // Getters y Setters
    public Producto getProducto() {//inicio método getProducto
        return producto;
    }//fin método getProducto

    public void setProducto(Producto producto) {//inicio método setProducto
        this.producto = producto;
    }//fin método setProducto

    public int getCantidad() {//inicio método getCantidad
        return cantidad;
    }//fin método getCantidad

    public void setCantidad(int cantidad) {//inicio método setCantidad
        this.cantidad = cantidad;
        this.subtotal = calcularSubtotal();
    }//fin método setCantidad

    public double getSubtotal() {//inicio método getSubtotal
        return subtotal;
    }//fin método getSubtotal

    public void setSubtotal(double subtotal) {//inicio método subtotal
        this.subtotal = subtotal;
    }//fin método subtotal

}//fin clase DetalleFactura
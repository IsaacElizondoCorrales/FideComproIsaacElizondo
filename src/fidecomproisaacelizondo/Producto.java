package fidecomproisaacelizondo;

import java.io.Serializable;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase modelo Producto para la gestión de inventario al por mayor.
 */
public class Producto implements Serializable {//inicio clase Producto

    private static final long serialVersionUID = 1L;

    private int idProducto;
    private String nombrePro;
    private String tipoProducto;
    private double precioUnitario;
    private int stockActual;

    public Producto() {//inicio método ProductoVacio
    }//fin método ProductoVacio

    public Producto(int idProducto, String nombrePro, String tipoProducto, double precioUnitario, int stockActual) {//inicio método ProductoParametros
        this.idProducto = idProducto;
        this.nombrePro = nombrePro;
        this.tipoProducto = tipoProducto;
        this.precioUnitario = precioUnitario;
        this.stockActual = stockActual;
    }//fin método ProductoParametros

    public void actualizarStock(int cantidadVendida) {//inicio método actualizarStock
        if (cantidadVendida > 0 && cantidadVendida <= this.stockActual) {//inicio if validarCantidadStock
            this.stockActual -= cantidadVendida;
        }//fin if validarCantidadStock
    }//fin método actualizarStock

    // Getters y Setters
    public int getIdProducto() {//inicio método getIdProducto
        return idProducto;
    }//fin método getIdProducto

    public void setIdProducto(int idProducto) {//inicio método setIdProducto
        this.idProducto = idProducto;
    }//fin método setIdProducto

    public String getNombrePro() {//inicio método getNombrePro
        return nombrePro;
    }//fin método getNombrePro

    public void setNombrePro(String nombrePro) {//inicio método setNombrePro
        this.nombrePro = nombrePro;
    }//fin método setNombrePro

    public String getTipoProducto() {//inicio método getTipoProducto
        return tipoProducto;
    }//fin método getTipoProducto

    public void setTipoProducto(String tipoProducto) {//inicio método setTipoProducto
        this.tipoProducto = tipoProducto;
    }//fin método setTipoProducto

    public double getPrecioUnitario() {//inicio método getPrecioUnitario
        return precioUnitario;
    }//fin método getPrecioUnitario

    public void setPrecioUnitario(double precioUnitario) {//inicio método setPrecioUnitario
        this.precioUnitario = precioUnitario;
    }//fin método setPrecioUnitario

    public int getStockActual() {//inicio método getStockActual
        return stockActual;
    }//fin método getStockActual

    public void setStockActual(int stockActual) {//inicio método setStockActual
        this.stockActual = stockActual;
    }//fin método setStockActual

}//fin clase Producto
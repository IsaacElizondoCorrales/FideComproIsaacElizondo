package fidecomproisaacelizondo;

import java.io.Serializable;
import java.util.List;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase Factura que integra cliente, usuario y lista de detalles.
 */
public class Factura implements Serializable {//inicio clase Factura

    private static final long serialVersionUID = 1L;

    private int idFactura;
    private String fecha;
    private Cliente cliente;
    private Usuario usuario;
    private List<DetalleFactura> listaDetalles;
    private double totalPagar;

    public Factura(int idFactura, String fecha, Cliente cliente, 
            Usuario usuario, List<DetalleFactura> listaDetalles) {//inicio método FacturaParametros
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.usuario = usuario;
        this.listaDetalles = listaDetalles;
        this.totalPagar = calcularTotal();
    }//fin método FacturaParametros

    public double calcularTotal() {//inicio método calcularTotal
        double subtotalGeneral = 0.0;
        if (listaDetalles != null) {//inicio if validarListaDetalles
            for (int i = 0; i < listaDetalles.size(); i++) {//inicio for recorrerDetallesFactura
                subtotalGeneral += listaDetalles.get(i).getSubtotal();
            }//fin for recorrerDetallesFactura
        }//fin if validarListaDetalles
        // Aplicando impuesto del 13% según prototipo
        double impuestos = subtotalGeneral * 0.13;
        return subtotalGeneral + impuestos;
    }//fin método calcularTotal

    public boolean generarArchivoFactura() {//inicio método generarArchivoFactura
        try {//inicio try generarFactura
            System.out.println("Generando archivo digital de la factura #" + this.idFactura);
            return true;
        } catch (Exception e) {//inicio catch errorFactura
            e.printStackTrace();
            return false;
        }//fin catch errorFactura
    }//fin método generarArchivoFactura

    // Getters y Setters
    public int getIdFactura() {//inicio método getIdFuncionalidad
        return idFactura;
    }//fin método getIdFuncionalidad

    public void setIdFactura(int idFactura) {//inicio método setIdFactura
        this.idFactura = idFactura;
    }//fin método setIdFactura

    public String getFecha() {//inicio método getFecha
        return fecha;
    }//fin método getFecha

    public void setFecha(String fecha) {//inicio método setFecha
        this.fecha = fecha;
    }//fin método setFecha

    public Cliente getCliente() {//inicio método getCliente
        return cliente;
    }//fin método getCliente

    public void setCliente(Cliente cliente) {//inicio método setCliente
        this.cliente = cliente;
    }//fin método setCliente

    public Usuario getUsuario() {//inicio método getUsuario
        return usuario;
    }//fin método getUsuario

    public void setUsuario(Usuario usuario) {//inicio método setUsuario
        this.usuario = usuario;
    }//fin método setUsuario

    public List<DetalleFactura> getListaDetalles() {//inicio método getListaDetalles
        return listaDetalles;
    }//fin método getListaDetalles

    public void setListaDetalles(List<DetalleFactura> 
            listaDetalles) {//inicio método setListaDetalles
        this.listaDetalles = listaDetalles;
        this.totalPagar = calcularTotal();
    }//fin método setListaDetalles

    public double getTotalPagar() {//inicio método getTotalPagar
        return totalPagar;
    }//fin método getTotalPagar

    public void setTotalPagar(double totalPagar) {//inicio método setTotalPagar
        this.totalPagar = totalPagar;
    }//fin método setTotalPagar

}//fin clase Factura
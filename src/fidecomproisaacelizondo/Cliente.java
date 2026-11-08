package fidecomproisaacelizondo;

import java.io.Serializable;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase modelo Cliente basada en el diagrama de clases para FideCompro.
 */
public class Cliente implements Serializable {//inicio clase Cliente

    private static final long serialVersionUID = 1L;

    private int idCliente;
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;

    public Cliente() {//inicio método ClienteVacio
    }//fin método ClienteVacio

    public Cliente(int idCliente, String nombre, String cedula, String telefono, String correo) {//inicio método ClienteParametros
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }//fin método ClienteParametros

    public void registrarCliente() {//inicio método registrarCliente
        System.out.println("Registrando cliente al por mayor: " + this.nombre);
    }//fin método registrarCliente

    // Getters y Setters
    public int getIdCliente() {//inicio método getIdCliente
        return idCliente;
    }//fin método getIdCliente

    public void setIdCliente(int idCliente) {//inicio método setIdCliente
        this.idCliente = idCliente;
    }//fin método setIdCliente

    public String getNombre() {//inicio método getNombre
        return nombre;
    }//fin método getNombre

    public void setNombre(String nombre) {//inicio método setNombre
        this.nombre = nombre;
    }//fin método setNombre

    public String getCedula() {//inicio método getCedula
        return cedula;
    }//fin método getCedula

    public void setCedula(String cedula) {//inicio método setCedula
        this.cedula = cedula;
    }//fin método setCedula

    public String getTelefono() {//inicio método getTelefono
        return telefono;
    }//fin método getTelefono

    public void setTelefono(String telefono) {//inicio método setTelefono
        this.telefono = telefono;
    }//fin método setTelefono

    public String getCorreo() {//inicio método getCorreo
        return correo;
    }//fin método getCorreo

    public void setCorreo(String correo) {//inicio método setCorreo
        this.correo = correo;
    }//fin método setCorreo

    @Override
    public String toString() {//inicio método toString
        return nombre + " (Cédula: " + cedula + ")";
    }//fin método toString

}//fin clase Cliente
package fidecomproisaacelizondo;

import java.io.Serializable;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase modelo Usuario basada en el diagrama de clases para FideCompro.
 */
public class Usuario implements Serializable {//inicio clase Usuario

    private static final long serialVersionUID = 1L;

    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    // Constructor vacío
    public Usuario() {//inicio método UsuarioVacio
    }//fin método UsuarioVacio

    // Constructor con parámetros
    public Usuario(int idUsuario, String nombreUsuario, String contrasena, 
            String rol) {//inicio método UsuarioParametros
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }//fin método UsuarioParametros

    // Método de autenticación según diagrama de clases
    public boolean autenticar(String nombreUsuario, String contrasena) {//inicio método autenticar
        if (this.nombreUsuario != null && this.contrasena != null) {//inicio if validarNulos
            if (this.nombreUsuario.equals(nombreUsuario) && 
                    this.contrasena.equals(contrasena)) {//inicio if compararCredenciales
                return true;
            }//fin if compararCredenciales
        }//fin if validarNulos
        return false;
    }//fin método autenticar

    // Getters y Setters
    public int getIdUsuario() {//inicio método getIdUsuario
        return idUsuario;
    }//fin método getIdUsuario

    public void setIdUsuario(int idUsuario) {//inicio método setIdUsuario
        this.idUsuario = idUsuario;
    }//fin método setIdUsuario

    public String getNombreUsuario() {//inicio método getNombreUsuario
        return nombreUsuario;
    }//fin método getNombreUsuario

    public void setNombreUsuario(String nombreUsuario) {//inicio método setNombreUsuario
        this.nombreUsuario = nombreUsuario;
    }//fin método setNombreUsuario

    public String getContrasena() {//inicio método getContrasena
        return contrasena;
    }//fin método getContrasena

    public void setContrasena(String contrasena) {//inicio método setContrasena
        this.contrasena = contrasena;
    }//fin método setContrasena

    public String getRol() {//inicio método getRol
        return rol;
    }//fin método getRol

    public void setRol(String rol) {//inicio método setRol
        this.rol = rol;
    }//fin método setRol

    @Override
    public String toString() {//inicio método toString
        return "Usuario: " + nombreUsuario + " | Rol: " + rol;
    }//fin método toString

}//fin clase Usuario
package Redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase Servidor en escucha constante para múltiples clientes concurrentes.
 */
public class Servidor {//inicio clase Servidor

    private static final int PUERTO = 5000;
    // Variable y método estático para manejar el estado global del servidor
    private static boolean activo = false;

    public static void setActivo(boolean estado) {//inicio setActivo
        activo = estado;
    }//fin setActivo

    public static boolean isServidorActivo() {//inicio isServidorActivo
        return activo;
    }//fin isServidorActivo

    public Servidor() {//inicio método ServidorConstructor
        this.activo = true;
    }//fin método ServidorConstructor

    public void iniciarServidor() {//inicio método iniciarServidor
        try {//inicio try servidorSocket
            ServerSocket servidorSocket = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado en el puerto " + PUERTO);

            while (activo) {//inicio while escucharClientes
                Socket clienteSocket = servidorSocket.accept();
                System.out.println("Nuevo cliente conectado: " + clienteSocket.getInetAddress());

                // Instancio y lanzo hilo para el cliente
                ManejadorCliente manejador = new ManejadorCliente(clienteSocket);
                new Thread(manejador).start();
            }//fin while escucharClientes

        } catch (IOException e) {//inicio catch errorServidor
            System.err.println("Error en el servidor: " + e.getMessage());
        }//fin catch errorServidor
    }//fin método iniciarServidor

    public static void main(String[] args) {//inicio método main
        Servidor servidor = new Servidor();
        servidor.iniciarServidor();
    }//fin método main

}//fin clase Servidor
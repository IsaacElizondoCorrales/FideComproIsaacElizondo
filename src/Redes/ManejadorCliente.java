package Redes;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Clase ManejadorCliente para procesar peticiones concurrentes mediante Hilos (Runnable).
 */
public class ManejadorCliente implements Runnable {//inicio clase ManejadorCliente

    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public ManejadorCliente(Socket socket) {//inicio método ManejadorClienteConstructor
        this.socket = socket;
    }//fin método ManejadorClienteConstructor

    @Override
    public void run() {//inicio método run
        try {//inicio try comunicacionCliente
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());

            // Ciclo para escuchar peticiones del cliente conectado
            boolean conectado = true;
            while (conectado) {//inicio while procesarPeticiones
                Object peticion = entrada.readObject();
                if (peticion != null) {//inicio if validarPeticion
                    System.out.println("Petición recibida del cliente: " + peticion.toString());
                    
                    // Aquí puedes manejar la lógica de negocio o respuestas según la petición
                    salida.writeObject("Respuesta procesada exitosamente por el servidor FideCompro");
                    salida.flush();
                }//fin if validarPeticion
            }//fin while procesarPeticiones

        } catch (Exception e) {//inicio catch errorManejador
            System.out.println("Cliente desconectado o error en hilo: " + e.getMessage());
        } finally {//inicio finally cerrarConexion
            try {//inicio try cerrarSockets
                if (socket != null) {//inicio if cerrarSocket
                    socket.close();
                }//fin if cerrarSocket
            } catch (Exception ex) {//inicio catch errorCierre
                ex.printStackTrace();
            }//fin catch errorCierre
        }//fin finally cerrarConexion
    }//fin método run

}//fin clase ManejadorCliente
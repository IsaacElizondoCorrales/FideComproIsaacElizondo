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
 * Descripcion: Clase ClienteRed para gestionar la conexión de Sockets con el servidor FideCompro.
 */
public class ClienteRed {//inicio clase ClienteRed

    private String servidorIP;
    private int puerto;
    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public ClienteRed(String servidorIP, int puerto) {//inicio método ClienteRedConstructor
        this.servidorIP = servidorIP;
        this.puerto = puerto;
    }//fin método ClienteRedConstructor

    public boolean conectar() {//inicio método conectar
        try {//inicio try conexionServidor
            socket = new Socket(servidorIP, puerto);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());
            System.out.println("Conectado exitosamente al servidor en " + servidorIP + ":" + puerto);
            return true;
        } catch (Exception e) {//inicio catch errorConexion
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
            return false;
        }//fin catch errorConexion
    }//fin método conectar

    public Object enviarPeticion(Object peticion) {//inicio método enviarPeticion
        try {//inicio try enviarObjeto
            if (salida != null && entrada != null) {//inicio if validarStreams
                salida.writeObject(peticion);
                salida.flush();
                return entrada.readObject();
            }//fin if validarStreams
        } catch (Exception e) {//inicio catch errorEnvio
            e.printStackTrace();
        }//fin catch errorEnvio
        return null;
    }//fin método enviarPeticion

    public void desconectar() {//inicio método desconectar
        try {//inicio try cerrarTodo
            if (salida != null) {//inicio if cerrarSalida
                salida.close();
            }//fin if cerrarSalida
            if (entrada != null) {//inicio if cerrarEntrada
                entrada.close();
            }//fin if cerrarEntrada
            if (socket != null) {//inicio if cerrarSocketCliente
                socket.close();
            }//fin if cerrarSocketCliente
            System.out.println("Desconectado del servidor.");
        } catch (Exception e) {//inicio catch errorDesconexion
            e.printStackTrace();
        }//fin catch errorDesconexion
    }//fin método desconectar

}//fin clase ClienteRed
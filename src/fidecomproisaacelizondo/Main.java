package fidecomproisaacelizondo;

import GUI.VentanaServidor;
import GUI.VentanaInicioSesion;
import javax.swing.SwingUtilities;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Descripcion: Clase ejecutable para probar la visualización del GUI del servidor.
 */

/**
 * GUÍA DE CUMPLIMIENTO DE REQUISITOS DEL AVANCE 2 - PROYECTO FIDECOMPRO
 * 
 * 1. Clases y Objetos: Implementado mediante el uso de clases modelo 
 *    estructuradas (Usuario, Cliente, Producto, DetalleFactura, Factura) 
 *    ubicadas en el paquete 'fidecomproisaacelizondo'.
 * 2. Herencia: Aplicada en las interfaces gráficas que heredan de JFrame 
 *    (ej. VentanaInicioSesion extends JFrame) y en clases de red.
 * 3. Polimorfismo: Implementado mediante la sobreescritura de métodos 
 *    de interfaces y clases padre (ej. @Override public void run() en 
 *    ManejadorCliente implementando Runnable).
 * 4. Excepciones y Condiciones: Uso extensivo de bloques try-catch para 
 *    controlar errores de red, E/S y estructuras condicionales if/else 
 *    para validaciones de negocio.
 * 5. Serialización (Opcional): Implementada en la clase Factura mediante 
 *    'implements Serializable' y transmitida a través de streams de objetos 
 *    (ObjectOutputStream / ObjectInputStream) en el paquete 'Redes'.
 * 6. Interfaz Gráfica de Usuario (GUI): Desarrollada completamente en Java 
 *    Swing, respetando los prototipos oficiales de diseño del sistema.
 * 7. Multihilos (Opcional): Implementado en el Servidor y ManejadorCliente 
 *    utilizando hilos concurrentes (Thread y Runnable) para atender múltiples 
 *    conexiones de clientes simultáneamente.
 */
public class Main {//inicio clase Main

    public static void main(String[] args) {//inicio método main
        SwingUtilities.invokeLater(() -> {//inicio lambda ejecutarGUI
            VentanaServidor ventana = new VentanaServidor();
            ventana.setVisible(true);
        });//fin lambda ejecutarGUI
        SwingUtilities.invokeLater(() -> {//inicio lambda ejecutarLogin
            VentanaInicioSesion login = new VentanaInicioSesion();
            login.setVisible(true);
        });//fin lambda ejecutarLogin
    }//fin método main

}//fin clase Main

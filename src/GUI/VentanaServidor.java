package GUI;

import Redes.Servidor;
import javax.swing.*;
import java.awt.*;
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
 * Descripcion: Ventana de control con lógica funcional para el Servidor de sockets FideCompro.
 */
public class VentanaServidor extends JFrame {//inicio clase VentanaServidor

    private JTextArea txtLogServidor;
    private JButton btnIniciarServidor;
    private JButton btnDetenerServidor;
    private JLabel lblEstado;
    
    private ServerSocket servidorSocket;
    private boolean servidorActivo;
    private Thread hiloServidor;

    public VentanaServidor() {//inicio método VentanaServidorConstructor
        setTitle("FideCompro - Monitoreo del Servidor");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        agregarEventos();
    }//fin método VentanaServidorConstructor

    private void inicializarComponentes() {//inicio método inicializarComponentes
        // Panel Superior: Título y Estado
        JPanel panelSuperior = new JPanel(new GridLayout(2, 1));
        panelSuperior.setBackground(new Color(230, 230, 230));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel lblTitulo = new JLabel("Consola de Control del Servidor", JLabel.LEFT);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblTitulo);

        lblEstado = new JLabel("Estado: Servidor Inactivo", JLabel.LEFT);
        lblEstado.setFont(new Font("Arial", Font.PLAIN, 12));
        lblEstado.setForeground(Color.RED);
        panelSuperior.add(lblEstado);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel Central: Log / Registro de Eventos
        txtLogServidor = new JTextArea();
        txtLogServidor.setEditable(false);
        txtLogServidor.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtLogServidor.setText("--- Registro de Actividad del Servidor FideCompro ---\n");

        JScrollPane scrollLog = new JScrollPane(txtLogServidor);
        scrollLog.setBorder(BorderFactory.createTitledBorder("Log de Conexiones P2P / Concurrencia"));
        add(scrollLog, BorderLayout.CENTER);

        // Panel Inferior: Botones de Acción
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelInferior.setBackground(new Color(240, 240, 240));

        btnIniciarServidor = new JButton("Iniciar Servidor");
        btnIniciarServidor.setBackground(new Color(110, 110, 110));
        btnIniciarServidor.setForeground(Color.WHITE);
        panelInferior.add(btnIniciarServidor);

        btnDetenerServidor = new JButton("Detener Servidor");
        btnDetenerServidor.setBackground(new Color(200, 200, 200));
        btnDetenerServidor.setEnabled(false);
        panelInferior.add(btnDetenerServidor);

        add(panelInferior, BorderLayout.SOUTH);
    }//fin método inicializarComponentes

    private void agregarEventos() {//inicio método agregarEventos
        btnIniciarServidor.addActionListener(e -> {//inicio lambda iniciarServidorAccion
            iniciarServidorGUI();
        });//fin lambda iniciarServidorAccion

        btnDetenerServidor.addActionListener(e -> {//inicio lambda detenerServidorAccion
            detenerServidorGUI();
        });//fin lambda detenerServidorAccion
    }//fin método agregarEventos

    private void iniciarServidorGUI() {//inicio método iniciarServidorGUI
        servidorActivo = true;
        
        // ---> AQUÍ CAMBIAS EL ESTADO GLOBAL PARA QUE EL LOGIN LO RECONOZCA <---
        // (Asegúrate de tener un método estático setActivo(true) en tu clase Servidor)
        Redes.Servidor.setActivo(true); 

        btnIniciarServidor.setEnabled(false);
        btnDetenerServidor.setEnabled(true);
        lblEstado.setText("Estado: Servidor Activo (Escuchando en puerto 5000)");
        lblEstado.setForeground(new Color(0, 128, 0));
        txtLogServidor.append("[SISTEMA] Servidor iniciado correctamente.\n");

        hiloServidor = new Thread(() -> {//inicio hilo escuchandoSockets
            try {//inicio try socketServidor
                servidorSocket = new ServerSocket(5000);
                while (servidorActivo) {//inicio while aceptarClientes
                    Socket clienteSocket = servidorSocket.accept();
                    txtLogServidor.append("[CONEXIÓN] Nuevo cliente conectado desde: " + clienteSocket.getInetAddress() + "\n");
                }//fin while aceptarClientes
            } catch (IOException ex) {//inicio catch errorSocketServidor
                if (servidorActivo) {
                    txtLogServidor.append("[ERROR] El servidor se detuvo inesperadamente: " + ex.getMessage() + "\n");
                }
            }//fin catch errorSocketServidor
        });//fin hilo escuchandoSockets
        
        hiloServidor.start();
    }//fin método iniciarServidorGUI

    private void detenerServidorGUI() {//inicio método detenerServidorGUI
        servidorActivo = false;
        try {//inicio try cerrarSocketServidor
            if (servidorSocket != null && !servidorSocket.isClosed()) {//inicio if validarSocketAbierto
                servidorSocket.close();
            }//fin if validarSocketAbierto
        } catch (IOException e) {//inicio catch errorCierreSocket
            e.printStackTrace();
        }//fin catch errorCierreSocket

        btnIniciarServidor.setEnabled(true);
        btnDetenerServidor.setEnabled(false);
        lblEstado.setText("Estado: Servidor Inactivo");
        lblEstado.setForeground(Color.RED);
        txtLogServidor.append("[SISTEMA] Servidor detenido por el usuario.\n");
    }//fin método detenerServidorGUI

}//fin clase VentanaServidor
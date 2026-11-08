package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Ventana principal con panel lateral y funcionalidad de cierre 
 * de sesión hacia el login.
 */
public class VentanaMenuPrincipal extends JFrame {//inicio clase

    // Constantes de la Paleta de Colores Corporativa
    private final Color AZUL_PETROLEO = new Color(27, 59, 72);
    private final Color ARENA_CALIDO = new Color(247, 245, 242);
    private final Color AMBAR_OCRE = new Color(217, 155, 38);
    private final Color ESPRESSO = new Color(44, 34, 30);

    private JPanel panelMenuLateral;
    private JPanel panelContenidoCentral;
    private JButton btnInicio;
    private JButton btnClientes;
    private JButton btnProductos;
    private JButton btnFacturas;
    private JButton btnCerrarSesion;

    public VentanaMenuPrincipal() {//inicio constructor
        setTitle("FideCompro - Sistema de Facturación");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        agregarEventos();
    }//fin constructor

    private void inicializarComponentes() {//inicio inicializar
        // Panel Superior (Cabecera)
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setBackground(AZUL_PETROLEO);
        panelSuperior.setPreferredSize(new Dimension(1000, 50));

        JLabel lblLogo = new JLabel(
            "  FideCompro  |  Sistema de Facturación al por Mayor"
        );
        lblLogo.setFont(new Font("Arial", Font.BOLD, 14));
        lblLogo.setForeground(ARENA_CALIDO);
        panelSuperior.add(lblLogo, BorderLayout.WEST);

        JLabel lblUsuarioActivo = new JLabel("Administrador ▼  ");
        lblUsuarioActivo.setFont(new Font("Arial", Font.PLAIN, 12));
        lblUsuarioActivo.setForeground(ARENA_CALIDO);
        panelSuperior.add(lblUsuarioActivo, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel Lateral Izquierdo (Menú de Navegación)
        panelMenuLateral = new JPanel();
        panelMenuLateral.setLayout(null);
        panelMenuLateral.setBackground(AZUL_PETROLEO);
        panelMenuLateral.setPreferredSize(new Dimension(220, 650));

        btnInicio = crearBotonMenu("Inicio");
        btnInicio.setBounds(15, 30, 190, 40);
        panelMenuLateral.add(btnInicio);

        btnClientes = crearBotonMenu("Clientes");
        btnClientes.setBounds(15, 85, 190, 40);
        panelMenuLateral.add(btnClientes);

        btnProductos = crearBotonMenu("Productos");
        btnProductos.setBounds(15, 140, 190, 40);
        panelMenuLateral.add(btnProductos);

        btnFacturas = crearBotonMenu("Facturas");
        btnFacturas.setBounds(15, 195, 190, 40);
        panelMenuLateral.add(btnFacturas);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBounds(15, 555, 190, 40);
        btnCerrarSesion.setBackground(AMBAR_OCRE);
        btnCerrarSesion.setForeground(ESPRESSO);
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 12));
        btnCerrarSesion.setFocusPainted(false);
        panelMenuLateral.add(btnCerrarSesion);

        add(panelMenuLateral, BorderLayout.WEST);

        // Panel Central (Área de trabajo)
        panelContenidoCentral = new JPanel();
        panelContenidoCentral.setLayout(new BorderLayout());
        panelContenidoCentral.setBackground(ARENA_CALIDO);

        JLabel lblBienvenida = new JLabel(
            "Bienvenido al sistema FideCompro", 
            JLabel.CENTER
        );
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
        lblBienvenida.setForeground(ESPRESSO);
        panelContenidoCentral.add(lblBienvenida, BorderLayout.CENTER);

        add(panelContenidoCentral, BorderLayout.CENTER);
    }//fin inicializar

    private JButton crearBotonMenu(String texto) {//inicio botonMenu
        JButton boton = new JButton(texto);
        boton.setBackground(new Color(35, 75, 92)); // Azul más claro
        boton.setForeground(ARENA_CALIDO);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        return boton;
    }//fin botonMenu

    private void agregarEventos() {//inicio agregarEventos
        btnCerrarSesion.addActionListener(e -> {//inicio cerrarSesion
            int opcion = JOptionPane.showConfirmDialog(
                this, 
                "¿Desea cerrar sesión y volver al inicio?", 
                "Cerrar Sesión", 
                JOptionPane.YES_NO_OPTION
            );
            if (opcion == JOptionPane.YES_OPTION) {//inicio si
                VentanaInicioSesion login = new VentanaInicioSesion();
                login.setVisible(true);
                this.dispose();
            }//fin si
        });//fin cerrarSesion

        btnClientes.addActionListener(e -> 
            new VentanaClientes().setVisible(true)
        );
        btnProductos.addActionListener(e -> 
            new VentanaProductos().setVisible(true)
        );
        btnFacturas.addActionListener(e -> 
            new VentanaCrearFactura().setVisible(true)
        );
    }//fin agregarEventos

    public static void main(String[] args) {//inicio main
        SwingUtilities.invokeLater(() -> {//inicio lambda
            new VentanaMenuPrincipal().setVisible(true);
        });//fin lambda
    }//fin main

}//fin clase
package GUI;

import javax.swing.*;
import java.awt.*;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Ventana de Inicio de Sesión con validación 
 * de servidor activo y redirección al menú principal.
 */
public class VentanaInicioSesion extends JFrame {//inicio clase

    private final Color AZUL_PETROLEO = new Color(27, 59, 72);
    private final Color ARENA_CALIDO = new Color(247, 245, 242);
    private final Color AMBAR_OCRE = new Color(217, 155, 38);
    private final Color ESPRESSO = new Color(44, 34, 30);

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIniciarSesion;
    private JButton btnCrearCuenta;

    public VentanaInicioSesion() {//inicio constructor
        setTitle("FideCompro - Inicio de Sesión");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        agregarEventos();
    }//fin constructor

    private void inicializarComponentes() {//inicio inicializar
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(ARENA_CALIDO);

        JLabel lblTitulo = new JLabel("FideCompro", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(AZUL_PETROLEO);
        lblTitulo.setBounds(100, 30, 300, 30);
        panelPrincipal.add(lblTitulo);

        JLabel lblSub = new JLabel(
            "Sistema de Facturación al por Mayor", 
            JLabel.CENTER
        );
        lblSub.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSub.setForeground(ESPRESSO);
        lblSub.setBounds(100, 65, 300, 20);
        panelPrincipal.add(lblSub);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(80, 120, 340, 45);
        txtUsuario.setBackground(Color.WHITE);
        txtUsuario.setForeground(ESPRESSO);
        txtUsuario.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Usuario"
            )
        );
        panelPrincipal.add(txtUsuario);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(80, 180, 340, 45);
        txtContrasena.setBackground(Color.WHITE);
        txtContrasena.setForeground(ESPRESSO);
        txtContrasena.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Contraseña"
            )
        );
        panelPrincipal.add(txtContrasena);

        btnIniciarSesion = new JButton("Iniciar sesión");
        btnIniciarSesion.setBounds(80, 250, 340, 40);
        btnIniciarSesion.setBackground(AMBAR_OCRE);
        btnIniciarSesion.setForeground(ESPRESSO);
        btnIniciarSesion.setFont(new Font("Arial", Font.BOLD, 13));
        btnIniciarSesion.setFocusPainted(false);
        panelPrincipal.add(btnIniciarSesion);

        btnCrearCuenta = new JButton(
            "¿No tienes cuenta? Regístrate aquí"
        );
        btnCrearCuenta.setBounds(80, 310, 340, 30);
        btnCrearCuenta.setBorderPainted(false);
        btnCrearCuenta.setContentAreaFilled(false);
        btnCrearCuenta.setForeground(AZUL_PETROLEO);
        btnCrearCuenta.setFont(new Font("Arial", Font.BOLD, 12));
        panelPrincipal.add(btnCrearCuenta);

        add(panelPrincipal, BorderLayout.CENTER);
    }//fin inicializar

    private void agregarEventos() {//inicio eventos
        btnIniciarSesion.addActionListener(e -> {//inicio login
            String usuario = txtUsuario.getText().trim();
            String password = new String(
                txtContrasena.getPassword()
            ).trim();

            if (usuario.isEmpty() || password.isEmpty()) {//inicio vacio
                JOptionPane.showMessageDialog(
                    this, 
                    "Por favor ingrese usuario y contraseña.", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE
                );
            } else {//inicio conexion
                boolean servidorDisponible = Redes.Servidor
                    .isServidorActivo(); 
                
                if (!servidorDisponible) {//inicio caido
                    JOptionPane.showMessageDialog(
                        this, 
                        "El servidor de FideCompro está inactivo.\n" +
                        "Debe encender el servidor antes de ingresar.", 
                        "Error de Conexión", 
                        JOptionPane.ERROR_MESSAGE
                    );
                    return; 
                }//fin caido

                JOptionPane.showMessageDialog(
                    this, 
                    "¡Bienvenido, " + usuario + "!", 
                    "Acceso Exitoso", 
                    JOptionPane.INFORMATION_MESSAGE
                );
                
                VentanaMenuPrincipal menu = new VentanaMenuPrincipal();
                menu.setVisible(true);
                this.dispose();
            }//fin conexion
        });//fin login

        btnCrearCuenta.addActionListener(e -> {//inicio registro
            VentanaCrearUsuario ventanaRegistro = 
                new VentanaCrearUsuario();
            ventanaRegistro.setVisible(true);
        });//fin registro
    }//fin eventos

    public static void main(String[] args) {//inicio main
        SwingUtilities.invokeLater(() -> {//inicio lambda
            new VentanaInicioSesion().setVisible(true);
        });//fin lambda
    }//fin main

}//fin clase
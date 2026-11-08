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
 * Descripcion: Ventana gráfica con validaciones individuales para 
 * el registro de nuevos usuarios en el sistema.
 */
public class VentanaCrearUsuario extends JFrame {//inicio clase

    private final Color AZUL_PETROLEO = new Color(27, 59, 72);
    private final Color ARENA_CALIDO = new Color(247, 245, 242);
    private final Color AMBAR_OCRE = new Color(217, 155, 38);
    private final Color ESPRESSO = new Color(44, 34, 30);

    private JTextField txtNombreUsuario;
    private JPasswordField txtContrasena;
    private JComboBox<String> cbRol;
    private JButton btnGuardarUsuario;
    private JButton btnCancelar;

    public VentanaCrearUsuario() {//inicio constructor
        setTitle("FideCompro - Crear Usuario");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        agregarEventos();
    }//fin constructor

    private void inicializarComponentes() {//inicio inicializar
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(ARENA_CALIDO);

        JLabel lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(AZUL_PETROLEO);
        lblTitulo.setBounds(30, 25, 300, 25);
        panelPrincipal.add(lblTitulo);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setBounds(30, 80, 370, 40);
        txtNombreUsuario.setBackground(Color.WHITE);
        txtNombreUsuario.setForeground(ESPRESSO);
        txtNombreUsuario.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Nombre de usuario"
            )
        );
        panelPrincipal.add(txtNombreUsuario);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(30, 140, 370, 40);
        txtContrasena.setBackground(Color.WHITE);
        txtContrasena.setForeground(ESPRESSO);
        txtContrasena.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Contraseña"
            )
        );
        panelPrincipal.add(txtContrasena);

        String[] roles = {
            "Seleccionar rol...", "Administrador", 
            "Vendedor", "Inventario"
        };
        cbRol = new JComboBox<>(roles);
        cbRol.setBounds(30, 200, 370, 40);
        cbRol.setBackground(Color.WHITE);
        cbRol.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Rol del usuario"
            )
        );
        panelPrincipal.add(cbRol);

        btnGuardarUsuario = new JButton("Guardar usuario");
        btnGuardarUsuario.setBounds(30, 270, 175, 40);
        btnGuardarUsuario.setBackground(AMBAR_OCRE);
        btnGuardarUsuario.setForeground(ESPRESSO);
        btnGuardarUsuario.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardarUsuario.setFocusPainted(false);
        panelPrincipal.add(btnGuardarUsuario);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(225, 270, 175, 40);
        btnCancelar.setBackground(new Color(210, 205, 195));
        btnCancelar.setForeground(ESPRESSO);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
        btnCancelar.setFocusPainted(false);
        panelPrincipal.add(btnCancelar);

        add(panelPrincipal, BorderLayout.CENTER);
    }//fin inicializar

    private void agregarEventos() {//inicio eventos
        btnGuardarUsuario.addActionListener(e -> {//inicio guardar
            String usuario = txtNombreUsuario.getText().trim();
            String password = new String(
                txtContrasena.getPassword()
            ).trim();
            int rolSeleccionado = cbRol.getSelectedIndex();

            if (usuario.isEmpty()) {//inicio user
                JOptionPane.showMessageDialog(
                    this, 
                    "Por favor, rellena el nombre de usuario.", 
                    "Campo Vacío", 
                    JOptionPane.WARNING_MESSAGE
                );
                txtNombreUsuario.requestFocus();
            } else if (password.isEmpty()) {//inicio pass
                JOptionPane.showMessageDialog(
                    this, 
                    "Por favor, rellena la contraseña.", 
                    "Campo Vacío", 
                    JOptionPane.WARNING_MESSAGE
                );
                txtContrasena.requestFocus();
            } else if (rolSeleccionado == 0) {//inicio rol
                JOptionPane.showMessageDialog(
                    this, 
                    "Por favor, selecciona un rol de usuario válido.", 
                    "Rol Requerido", 
                    JOptionPane.WARNING_MESSAGE
                );
                cbRol.requestFocus();
            } else {//inicio exito
                JOptionPane.showMessageDialog(
                    this, 
                    "¡Usuario '" + usuario + "' guardado con éxito!", 
                    "Registro Exitoso", 
                    JOptionPane.INFORMATION_MESSAGE
                );
                this.dispose();
            }//fin exito
        });//fin guardar

        btnCancelar.addActionListener(e -> {//inicio cancelar
            this.dispose();
        });//fin cancelar
    }//fin eventos

    public static void main(String[] args) {//inicio main
        SwingUtilities.invokeLater(() -> {//inicio lambda
            new VentanaCrearUsuario().setVisible(true);
        });//fin lambda
    }//fin main

}//fin clase
package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/*
 * Universidad Fidélitas / Programación Cliente/Servidor Concurrente 
 * 3er Cuatrimestre
 * Avance 2: Proyecto 1 - FideCompro
 * Creado por: Isaac Andres Elizondo Corrales 
 * Profesor: Mario Alberto Vargas Montes
 * Fecha: Noviembre del 2026
 * Descripcion: Ventana gráfica para el Registro y Gestión de Clientes al por mayor.
 */
public class VentanaClientes extends JFrame {//inicio clase

    private final Color AZUL_PETROLEO = new Color(27, 59, 72);
    private final Color ARENA_CALIDO = new Color(247, 245, 242);
    private final Color AMBAR_OCRE = new Color(217, 155, 38);
    private final Color ESPRESSO = new Color(44, 34, 30);

    private JTextField txtNombre;
    private JTextField txtCedula;
    private JTextField txtCorreo;
    private JTextField txtTelefono;
    private JTextArea txtDireccion;
    private JButton btnGuardarCliente;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;

    public VentanaClientes() {//inicio constructor
        setTitle("FideCompro - Gestión de Clientes");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
    }//fin constructor

    private void inicializarComponentes() {//inicio inicializar
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(ARENA_CALIDO);

        JLabel lblTitulo = new JLabel("Registro de Clientes");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(AZUL_PETROLEO);
        lblTitulo.setBounds(30, 20, 300, 25);
        panelPrincipal.add(lblTitulo);

        txtNombre = new JTextField();
        txtNombre.setBounds(30, 65, 390, 40);
        txtNombre.setBackground(Color.WHITE);
        txtNombre.setForeground(ESPRESSO);
        txtNombre.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Nombre completo"
            )
        );
        panelPrincipal.add(txtNombre);

        txtCedula = new JTextField();
        txtCedula.setBounds(440, 65, 390, 40);
        txtCedula.setBackground(Color.WHITE);
        txtCedula.setForeground(ESPRESSO);
        txtCedula.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Cédula / Identificación"
            )
        );
        panelPrincipal.add(txtCedula);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(30, 120, 390, 40);
        txtCorreo.setBackground(Color.WHITE);
        txtCorreo.setForeground(ESPRESSO);
        txtCorreo.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Correo electrónico"
            )
        );
        panelPrincipal.add(txtCorreo);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(440, 120, 390, 40);
        txtTelefono.setBackground(Color.WHITE);
        txtTelefono.setForeground(ESPRESSO);
        txtTelefono.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Teléfono"
            )
        );
        panelPrincipal.add(txtTelefono);

        txtDireccion = new JTextArea();
        JScrollPane scrollDir = new JScrollPane(txtDireccion);
        scrollDir.setBounds(30, 175, 530, 60);
        scrollDir.setBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(AZUL_PETROLEO), 
                "Dirección"
            )
        );
        panelPrincipal.add(scrollDir);

        btnGuardarCliente = new JButton("Guardar cliente");
        btnGuardarCliente.setBounds(580, 190, 250, 40);
        btnGuardarCliente.setBackground(AMBAR_OCRE);
        btnGuardarCliente.setForeground(ESPRESSO);
        btnGuardarCliente.setFont(new Font("Arial", Font.BOLD, 12));
        btnGuardarCliente.setFocusPainted(false);
        panelPrincipal.add(btnGuardarCliente);

        JLabel lblSubLista = new JLabel("Lista de Clientes");
        lblSubLista.setFont(new Font("Arial", Font.BOLD, 14));
        lblSubLista.setForeground(AZUL_PETROLEO);
        lblSubLista.setBounds(30, 255, 200, 20);
        panelPrincipal.add(lblSubLista);

        String[] columnas = {
            "ID", "Nombre", "Cédula", "Teléfono", "Correo", "Acciones"
        };
        Object[][] datos = {
            {
                "1", "Distribuidora La Unión S.A.", 
                "3-101-123456", "2222-3333", 
                "contacto@launion.com", "Editar / Eliminar"
            },
            {
                "2", "Comercializadora del Sur", 
                "3-101-987654", "8888-9999", 
                "ventas@delsur.com", "Editar / Eliminar"
            }
        };

        modeloTabla = new DefaultTableModel(datos, columnas);
        tablaClientes = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaClientes);
        scrollTabla.setBounds(30, 285, 800, 260);
        panelPrincipal.add(scrollTabla);

        add(panelPrincipal, BorderLayout.CENTER);
    }//fin inicializar

    public static void main(String[] args) {//inicio main
        SwingUtilities.invokeLater(() -> {//inicio lambda
            new VentanaClientes().setVisible(true);
        });//fin lambda
    }//fin main

}//fin clase
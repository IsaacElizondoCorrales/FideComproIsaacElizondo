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
 * Descripcion: Ventana gráfica para la Creación y Emisión de Facturas al por mayor.
 */
public class VentanaCrearFactura extends JFrame {//inicio clase VentanaCrearFactura

    private JComboBox<String> cbCliente;
    private JTextField txtFecha;
    private JTextField txtBuscarProducto;
    private JTextField txtCantidad;
    private JButton btnAgregarProducto;
    private JButton btnGenerarFactura;
    private JTable tablaDetalle;
    private DefaultTableModel modeloDetalle;
    private JLabel lblSubtotalValor;
    private JLabel lblImpuestosValor;
    private JLabel lblTotalValor;
    private JTable tablaFacturasRecientes;
    private DefaultTableModel modeloRecientes;

    public VentanaCrearFactura() {//inicio método VentanaCrearFacturaConstructor
        setTitle("FideCompro - Crear Factura");
        setSize(950, 750);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
    }//fin método VentanaCrearFacturaConstructor

    private void inicializarComponentes() {//inicio método inicializarComponentes
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // Título de la sección
        JLabel lblTitulo = new JLabel("Crear Factura");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBounds(30, 20, 300, 25);
        panelPrincipal.add(lblTitulo);

        // Selector de Cliente y Fecha
        String[] clientes = {"Seleccionar cliente...", "Distribuidora La Unión S.A.", "Comercializadora del Sur"};
        cbCliente = new JComboBox<>(clientes);
        cbCliente.setBounds(30, 60, 480, 40);
        cbCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
        panelPrincipal.add(cbCliente);

        txtFecha = new JTextField("2026-11-04");
        txtFecha.setBounds(530, 60, 370, 40);
        txtFecha.setBorder(BorderFactory.createTitledBorder("Fecha de emisión"));
        panelPrincipal.add(txtFecha);

        // Sección de Búsqueda de Productos para la Factura
        JLabel lblSubProd = new JLabel("Productos");
        lblSubProd.setFont(new Font("Arial", Font.BOLD, 14));
        lblSubProd.setBounds(30, 115, 200, 20);
        panelPrincipal.add(lblSubProd);

        txtBuscarProducto = new JTextField();
        txtBuscarProducto.setBounds(30, 140, 580, 35);
        txtBuscarProducto.setBorder(BorderFactory.createTitledBorder("Buscar producto..."));
        panelPrincipal.add(txtBuscarProducto);

        txtCantidad = new JTextField("1");
        txtCantidad.setBounds(625, 140, 130, 35);
        txtCantidad.setBorder(BorderFactory.createTitledBorder("Cantidad"));
        panelPrincipal.add(txtCantidad);

        btnAgregarProducto = new JButton("Agregar");
        btnAgregarProducto.setBounds(770, 140, 130, 35);
        btnAgregarProducto.setBackground(new Color(110, 110, 110));
        btnAgregarProducto.setForeground(Color.WHITE);
        panelPrincipal.add(btnAgregarProducto);

        // Tabla de Detalle de Factura
        String[] columnasDetalle = {"ID", "Nombre", "Tipo", "Precio unitario", "Cantidad", "Subtotal", "Acciones"};
        Object[][] datosDetalle = {}; // Inicialmente vacío o con datos de prueba
        modeloDetalle = new DefaultTableModel(datosDetalle, columnasDetalle);
        tablaDetalle = new JTable(modeloDetalle);
        JScrollPane scrollDetalle = new JScrollPane(tablaDetalle);
        scrollDetalle.setBounds(30, 185, 870, 140);
        panelPrincipal.add(scrollDetalle);

        // Totales (Subtotal, Impuestos 13%, Total)
        JLabel lblSubtotalTexto = new JLabel("Subtotal:");
        lblSubtotalTexto.setBounds(650, 335, 100, 20);
        panelPrincipal.add(lblSubtotalTexto);
        lblSubtotalValor = new JLabel("¢ 0.00", JLabel.RIGHT);
        lblSubtotalValor.setBounds(770, 335, 130, 20);
        panelPrincipal.add(lblSubtotalValor);

        JLabel lblImpuestosTexto = new JLabel("Impuestos (13%):");
        lblImpuestosTexto.setBounds(650, 360, 120, 20);
        panelPrincipal.add(lblImpuestosTexto);
        lblImpuestosValor = new JLabel("¢ 0.00", JLabel.RIGHT);
        lblImpuestosValor.setBounds(770, 360, 130, 20);
        panelPrincipal.add(lblImpuestosValor);

        JLabel lblTotalTexto = new JLabel("Total:");
        lblTotalTexto.setFont(new Font("Arial", Font.BOLD, 13));
        lblTotalTexto.setBounds(650, 385, 100, 20);
        panelPrincipal.add(lblTotalTexto);
        lblTotalValor = new JLabel("¢ 0.00", JLabel.RIGHT);
        lblTotalValor.setFont(new Font("Arial", Font.BOLD, 13));
        lblTotalValor.setBounds(770, 385, 130, 20);
        panelPrincipal.add(lblTotalValor);

        btnGenerarFactura = new JButton("Generar factura");
        btnGenerarFactura.setBounds(740, 415, 160, 35);
        btnGenerarFactura.setBackground(new Color(110, 110, 110));
        btnGenerarFactura.setForeground(Color.WHITE);
        panelPrincipal.add(btnGenerarFactura);

        // Tabla inferior: Facturas Recientes
        JLabel lblSubRecientes = new JLabel("Facturas recientes");
        lblSubRecientes.setFont(new Font("Arial", Font.BOLD, 14));
        lblSubRecientes.setBounds(30, 440, 200, 20);
        panelPrincipal.add(lblSubRecientes);

        String[] columnasRecientes = {"ID", "Cliente", "Fecha", "Total", "Estado", "Acciones"};
        Object[][] datosRecientes = {
            {"1", "Distribuidora La Unión S.A.", "2026-11-01", "¢ 59,664.00", "Generada", "Ver / PDF"}
        };
        modeloRecientes = new DefaultTableModel(datosRecientes, columnasRecientes);
        tablaFacturasRecientes = new JTable(modeloRecientes);
        JScrollPane scrollRecientes = new JScrollPane(tablaFacturasRecientes);
        scrollRecientes.setBounds(30, 470, 870, 200);
        panelPrincipal.add(scrollRecientes);

        add(panelPrincipal, BorderLayout.CENTER);
    }//fin método inicializarComponentes

    public static void main(String[] args) {//inicio método main
        SwingUtilities.invokeLater(() -> {//inicio lambda mainCrearFactura
            new VentanaCrearFactura().setVisible(true);
        });//fin lambda mainCrearFactura
    }//fin método main

}//fin clase VentanaCrearFactura